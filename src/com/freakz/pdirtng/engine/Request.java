package com.freakz.pdirtng.engine;

import com.freakz.pdirtng.common.ArgsParser;

/**
 * Date: 8/4/11
 * Time: 5:42 PM
 *
 * @author Petri Airio
 */
public class Request {

  private ArgsParser args;
  private PDirtNG engine;

  public Request(String line, PDirtNG engine) {
    this.args = new ArgsParser(line);
    this.engine = engine;
  }

  public ArgsParser getArgs() {
    return args;
  }

  public PDirtNG getEngine() {
    return engine;
  }
}
