package com.freakz.pdirtng.objects;

import com.freakz.pdirtng.io.IOHandler;

/**
 * Date: 26.5.2011
 * Time: 13:55
 *
 * @author Petri Airio
 */
public class Player extends Mobile {

  private IOHandler ioHandler;
  private String password;

  public Player(String name, IOHandler ioHandler) {
    super(name);
    this.ioHandler = ioHandler;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String toString() {
    return getName() + " is here.";
  }

  public IOHandler getIoHandler() {
    return ioHandler;
  }
}
