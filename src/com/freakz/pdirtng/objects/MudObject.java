package com.freakz.pdirtng.objects;

/**
 * Date: 30.5.2011
 * Time: 8:44
 *
 * @author Petri Airio
 */
public class MudObject extends MObject {

  public static final int FLAG_IN_ROOM = 0;
  public static final int FLAG_IN_CONTAINER = 1;
  public static final int FLAG_CARRIED_BY = 2;
  public static final int FLAG_WORN_BY = 3;
  public static final int FLAG_WIELDED_BY = 4;
  public static final int FLAG_BOTH_BY = 5; /* both wielded 6 worn */

  private String name;
  private String altName;
  private String[] descriptions;
  private String examine;

  private int id;
  private int linked;
  private int zoneId;

  private int value;
  private int size;
  private int location;
  private int visibility;
  private int damage;
  private int armor;

  private int state;
  private int maxState;

  private int carried;
  private int carriedFlag = FLAG_IN_ROOM;

  public MudObject() {
    super();
  }

  public void setZoneId(int zoneId) {
    this.zoneId = zoneId;
  }

  public int getZoneId() {
    return this.zoneId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAltName() {
    return altName;
  }

  public void setAltName(String altName) {
    this.altName = altName;
  }

  public String[] getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(String[] descriptions) {
    this.descriptions = descriptions;
  }

  public String getExamine() {
    return examine;
  }

  public void setExamine(String examine) {
    this.examine = examine;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getLinked() {
    return linked;
  }

  public void setLinked(int linked) {
    this.linked = linked;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public int getLocation() {
    return location;
  }

  public void setLocation(int location) {
    this.location = location;
  }

  public int getVisibility() {
    return visibility;
  }

  public void setVisibility(int visibility) {
    this.visibility = visibility;
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

  public int getCarried() {
    return carried;
  }

  public void setCarried(int carried) {
    this.carried = carried;
  }

  public int getCarriedFlag() {
    return carriedFlag;
  }

  public void setCarriedFlag(int carriedFlag) {
    this.carriedFlag = carriedFlag;
  }

  public void setMaxState(int state) {
    this.maxState = state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getState() {
    return state;
  }

  public int getMaxState() {
    return maxState;
  }
}
