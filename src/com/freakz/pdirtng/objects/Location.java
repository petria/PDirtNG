package com.freakz.pdirtng.objects;

import com.freakz.pdirtng.io.IOHandler;

import java.util.ArrayList;
import java.util.List;

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
  public static int EXIT_UNKNOWN = 100;


  public static String[] EXIT_NAMES =
      {"North", "East", "South", "West", "Up", "Down", "NorthEast", "NorthWest", "SouthEast", "SouthWest"};

  public static String[] EXIT_NAMES_SHORT =
      {"n", "e", "s", "w", "u", "d", "ne", "nw", "se", "sw"};

  private static final int NUM_OF_EXITS = 10;

  private int exits[] = new int[NUM_OF_EXITS];

  private int id;
  private int zoneId;
  private String flags;
  private String shortDescription;
  private String longDescription;
  private List<Player> mobiles;

  public Location(int id) {
    super();
    this.id = id;
    this.mobiles = new ArrayList<Player>();
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

  public String getShortDescriptionNoColor() {
    String stripped = shortDescription.replaceAll("\\&\\+W|\\&\\*\\^", "");
    return stripped;
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

  public String getExitsString() {
    String exits = "Obivious exits are:\n";
    // North
    for (int dir = 0; dir < NUM_OF_EXITS; dir++) {
      int exitId = this.exits[dir];
      if (exitId == 0) {
        continue;
      }
      Location exit = World.getInstance().findLocationById(exitId);
      if (exit != null) {
        exits += String.format("[%-9s] %s\n", EXIT_NAMES[dir], exit.getShortDescriptionNoColor());
      }
    }
    return exits;
  }

  public static int resolveDir(String direction) {

    for (int i = 0; i < NUM_OF_EXITS; i++) {
      if (EXIT_NAMES_SHORT[i].equals(direction)) {
        return i;
      }
    }
    for (int i = 0; i < NUM_OF_EXITS; i++) {
      String dir = EXIT_NAMES[i].toLowerCase();
      if (dir.startsWith(direction)) {
        return i;
      }
    }
    return -1;
  }

  public String look() {
    String lookReply = "";
    lookReply += ("------: " + getId() + " -> " + getObjectId() + "\n");
    lookReply += (getShortDescriptionNoColor() + " [" + getZoneId() + "]" + "\n");
    lookReply += (getLongDescription());
    for (MudObject mobile : mobiles) {
      lookReply += mobile.toString() + "\n";
    }
    lookReply += "\n" + getExitsString() + "\n";
    return lookReply;
  }

  public void addMobile(Player mobile, int arrivedFrom) {
    this.mobiles.add(mobile);
    messageToRoom(mobile.getName() + " has arrived.\n");
  }

  public void removeMobile(Player mobile, int goneTo) {
    this.mobiles.remove(mobile);
    if (goneTo != EXIT_UNKNOWN) {
      messageToRoom(mobile.getName() + " has gone " + EXIT_NAMES[goneTo] + "\n");
    }
  }

  public void messageToRoom(String message) {
    for (Player player : mobiles) {
      IOHandler ioHandler = player.getIoHandler();
      if (ioHandler != null) {
        ioHandler.sendLine(message);
      }
    }
  }

}
