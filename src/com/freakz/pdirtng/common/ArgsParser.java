package com.freakz.pdirtng.common;
/*
Copyright (c) 2001 - 2011, Petri Airio
All rights reserved.

*/

/**
 * ArgsParser parses a String. First word of the string is called cmd.
 * Words after cmd are args.
 * <p/>
 * Date: 8/14/11
 * Time: 10:34 AM
 *
 * @author Petri Airio
 */

public class ArgsParser {

  //~ Instance/static variables ..............................................

  private static java.util.logging.Logger LOG
      = java.util.logging.Logger.getLogger("com.freakz.pdirtng");

  private String _origLine;
  private String _cmd;
  private String[] _args;
  private int _getArgument = 0;

  //~ Constructors ...........................................................

  public ArgsParser(String line) {
    _origLine = line;
    _args = _origLine.split(" ");
    _cmd = _args[0];
  }

  //~ Methods ................................................................

  public boolean hasCommand() {
    if (_cmd != null) {
      return true;
    }
    return false;
  }

  public boolean hasArgs() {
    if (_args != null && _args.length > 1) {
      return true;
    }
    return false;
  }

  public int argCount() {
    if (_args == null) {
      return 0;
    }
    return _args.length;
  }

  public boolean isValidArg(int num) {
    if (hasArgs() && num > -1 && num < _args.length) {
      return true;
    }
    return false;
  }

  public String getCmd() {
    return _cmd;
  }

  public String getArg(int num) {
    if (isValidArg(num)) {
      return _args[num];
    }
    return null;
  }

  public String getArgNext() {
    return _args[_getArgument++];
  }

  public void resetArgNexT() {
    _getArgument = 0;
  }

  public String getArgs() {
    return joinArgs(1);
  }

  public String getArgs(int num) {
    return joinArgs(num);
  }

  private String joinArgs(int fromPos) {
    StringBuilder sb = new StringBuilder();
    if (isValidArg(fromPos)) {
      while (isValidArg(fromPos)) {
        sb.append(getArg(fromPos));
        fromPos++;
        if (isValidArg(fromPos)) {
          sb.append(" ");
        }
      }
    }
    return sb.toString();
  }

  public String getOrigLine() {
    return _origLine;
  }

}
