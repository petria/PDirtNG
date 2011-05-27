package com.freakz.pdirtng.objects;

import com.freakz.pdirtng.io.IOHandler;

/**
 * Date: 26.5.2011
 * Time: 13:55
 *
 * @author Petri Airio
 */
public class Player extends MudObject {

  private String name;
  private IOHandler ioHandler;
  private String password;

  private Location location;

  public Player(String name, IOHandler ioHandler) {
    this.name = name;
    this.ioHandler = ioHandler;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location, int arrivedFrom, int goneTo) {
    if (this.location != null) {
      this.location.removeMobile(this, goneTo);
    }
    this.location = location;
    if (location != null) {
      this.location.addMobile(this, arrivedFrom);
    }
  }

  public String toString() {
    return getName() + " is here.";
  }

  public IOHandler getIoHandler() {
    return ioHandler;
  }
}
