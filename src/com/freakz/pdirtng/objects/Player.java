package com.freakz.pdirtng.objects;

/**
 * Date: 26.5.2011
 * Time: 13:55
 *
 * @author Petri Airio
 */
public class Player extends MudObject {

  private String name;
  private String password;

  private Location location;

  public Player(String name) {
    this.name = name;
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

  public void setLocation(Location location) {
    if (this.location != null) {
      this.location.removeMobile(this);
    }
    this.location = location;
    this.location.addMobile(this);
  }

  public String toString() {
    return getName() + " is here.";
  }

}
