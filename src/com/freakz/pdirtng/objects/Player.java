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

  private int location;


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

  public int getLocation() {
    return location;
  }

  public void setLocation(int location) {
    this.location = location;
  }

}
