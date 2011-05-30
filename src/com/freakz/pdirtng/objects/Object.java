package com.freakz.pdirtng.objects;

/**
 * Date: 30.5.2011
 * Time: 8:44
 *
 * @author Petri Airio
 */
public class Object extends MudObject {

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

  private int carried;
  private int carriedFlag = FLAG_IN_ROOM;

  public Object() {
    super();
  }

  public void setZoneId(int zoneId) {
    this.zoneId = zoneId;
  }

  public int getZoneId() {
    return this.zoneId;
  }
}
