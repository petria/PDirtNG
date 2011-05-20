package com.freakz.pdirtng.objects;

/**
 * Date: 20.5.2011
 * Time: 13:09
 *
 * @author Petri Airio
 */
public class Location extends MudObject {

  public static int EXIT_NORTH = 0;
  public static int EXIT_EAST = 1;
  public static int EXIT_SOUTH = 2;
  public static int EXIT_WEST = 3;
  public static int EXIT_UP = 4;
  public static int EXIT_DOWN = 5;
  public static int EXIT_NORTHEAST = 6;
  public static int EXIT_NORTHWEST = 7;
  public static int EXIT_SOUTHEAST = 8;
  public static int EXIT_SOUTHWEST = 9;


  public static String[] EXIT_NAMES =
      {"North", "East", "South", "West", "Up", "Down", "NorthEast", "NorthWest", "SouthEast", "SouthWest"};

  private static final int NUM_OF_EXITS = 10;

  private int[] exits = new int[NUM_OF_EXITS];

  private int id;
  private int zoneId;
  private String flags;
  private String shortDescription;
  private String longDescription;

  public Location(int id) {
    super();
    this.id = id;
  }

  public int[] getExits() {
    return exits;
  }

  public void setExit(int direction, int targetId) {
    exits[direction] = targetId;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String longDescription) {
    this.longDescription = longDescription;
  }

  public int getZoneId() {
    return zoneId;
  }

  public void setZoneId(int zoneId) {
    this.zoneId = zoneId;
  }

  public int getId() {
    return id;
  }

  public void setFlags(String flags) {
    this.flags = flags;
  }
}
