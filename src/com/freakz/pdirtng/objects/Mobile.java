package com.freakz.pdirtng.objects;

import java.util.List;

/**
 * Date: 9.6.2011
 * Time: 8:02
 *
 * @author Petri Airio
 */
public class Mobile extends MudObject {

  private String name;
  private String description;
  private String examine;

//  private int location;
  private Location location;
  private int homeLocation;
  private int damage;
  private int armor;
  private int agression;
  private int speed;
  private int carryCapacity;
  private int strength;
  private int visibility;
  private int timesKilled;
  private int timesDied;

  private int level;
  private int weapon;
  private int score;

  private int pnum;                 /* player/mobile number */
  private long id;

  private List<Object> objects;     /* carrying */
  private int zone;
  private int wimpy;

  public Mobile(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getExamine() {
    return examine;
  }

  public void setExamine(String examine) {
    this.examine = examine;
  }

  public Location getLocation() {
    return this.location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public void setLocation(int locationId) {
    this.location = World.getInstance().findLocationById(locationId);
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


  public int getHomeLocation() {
    return homeLocation;
  }

  public void setHomeLocation(int homeLocation) {
    this.homeLocation = homeLocation;
  }

  public int getDamage() {
    return damage;
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public int getArmor() {
    return armor;
  }

  public void setArmor(int armor) {
    this.armor = armor;
  }

  public int getAgression() {
    return agression;
  }

  public void setAgression(int agression) {
    this.agression = agression;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public int getCarryCapacity() {
    return carryCapacity;
  }

  public void setCarryCapacity(int carryCapacity) {
    this.carryCapacity = carryCapacity;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getVisibility() {
    return visibility;
  }

  public void setVisibility(int visibility) {
    this.visibility = visibility;
  }

  public int getTimesKilled() {
    return timesKilled;
  }

  public void setTimesKilled(int timesKilled) {
    this.timesKilled = timesKilled;
  }

  public int getTimesDied() {
    return timesDied;
  }

  public void setTimesDied(int timesDied) {
    this.timesDied = timesDied;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getWeapon() {
    return weapon;
  }

  public void setWeapon(int weapon) {
    this.weapon = weapon;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getPnum() {
    return pnum;
  }

  public void setPnum(int pnum) {
    this.pnum = pnum;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setZone(int zone) {
    this.zone = zone;
  }

  public int getZoneId() {
    return zone;
  }

  public void setWimpy(int wimpy) {
    this.wimpy = wimpy;
  }

  public int getWimpy() {
    return wimpy;
  }

  public String toString() {
    return getDescription();
  }

  public Location moveTo(int id, int goneTo) {
    Location newLocation = World.getInstance().findLocationById(id);
    if (newLocation != null) {
      Location oldLocation = getLocation();
      oldLocation.removeMobile(this, goneTo);
      newLocation.addMobile(this);
    }
    return newLocation;
  }

}
