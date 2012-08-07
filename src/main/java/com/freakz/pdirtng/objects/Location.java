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
public class Location extends MObject {

  public static final int EXIT_NORTH = 0;
  public static final int EXIT_EAST = 1;
  public static final int EXIT_SOUTH = 2;
  public static final int EXIT_WEST = 3;
  public static final int EXIT_UP = 4;
  public static final int EXIT_DOWN = 5;
  public static final int EXIT_NORTHEAST = 6;
  public static final int EXIT_NORTHWEST = 7;
  public static final int EXIT_SOUTHEAST = 8;
  public static final int EXIT_SOUTHWEST = 9;

  public static final int EXIT_UNKNOWN = 100;
  public static final int EXIT_ENTERED_GAME = 101;
  public static final int EXIT_QUIT_GAME = 102;
  public static final int EXIT_GOTO_HERE = 200;


  public static String[] EXIT_NAMES =
      {"North", "East", "South", "West", "Up", "Down", "NorthEast", "NorthWest", "SouthEast", "SouthWest"};

  public static String[] EXIT_NAMES_SHORT =
      {"n", "e", "s", "w", "u", "d", "ne", "nw", "se", "sw"};

  public static final int NUM_OF_EXITS = 10;

  private int exits[] = new int[NUM_OF_EXITS];

  private int id;
  private int zoneId;
  private String flags;
  private String shortDescription;
  private String longDescription;
  private List<Mobile> mobiles;
  private List<MudObject> mudObjects;

  private String zoneName;

  public Location(int id) {
    super();
    this.id = id;
    this.mobiles = new ArrayList<Mobile>();
    this.mudObjects = new ArrayList<MudObject>();
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
    for (MudObject mudObject : mudObjects) {
      lookReply += mudObject.getDescriptions()[mudObject.getState()] + "\n";
    }

    String objectNames = "[";
    for (MudObject mudObject : mudObjects) {
      objectNames += (mudObject.getName() + " ");
    }
    objectNames = objectNames.trim() + "]\n";
    lookReply += objectNames;

    for (MObject mobile : mobiles) {
      lookReply += mobile.toString() + "\n";
    }
    lookReply += "\n" + getExitsString() + "\n";
    return lookReply;
  }

  public void addObject(MudObject mudObject) {
    this.mudObjects.add(mudObject);
  }

  public void removeObject(MudObject mudObject) {
    this.mudObjects.remove(mudObject);
  }

  public List<MudObject> getMudObjects() {
    return this.mudObjects;
  }

  public void addMobile(Mobile mobile) {
    addMobile(mobile, EXIT_UNKNOWN);
  }

  public void addMobile(Mobile mobile, int arrivedFrom) {
    this.mobiles.add(mobile);
    if (arrivedFrom == EXIT_ENTERED_GAME) {
      messageToRoom(mobile.getName() + " has entered game.\n");
    } else if (arrivedFrom == EXIT_GOTO_HERE) {
      messageToRoom(mobile.getName() + " appears with ear splitting bang.\n");
    } else {
      messageToRoom(mobile.getName() + " has arrived.\n");
    }
  }

  public void removeMobile(Mobile mobile, int goneTo) {
    this.mobiles.remove(mobile);
    if (goneTo == EXIT_QUIT_GAME) {
      messageToRoom(mobile.getName() + " has left game.\n");
    } else if (goneTo == EXIT_GOTO_HERE) {
      messageToRoom(mobile.getName() + " disappears in a puff of smoke.\n");
    } else if (goneTo != EXIT_UNKNOWN) {
      messageToRoom(mobile.getName() + " has gone " + EXIT_NAMES[goneTo] + "\n");
    }
  }

  public void messageToRoom(String message) {
    for (Mobile mobile : mobiles) {
      if (mobile instanceof Player) {
        Player player = (Player) mobile;
        IOHandler ioHandler = player.getIoHandler();
        if (ioHandler != null) {
          ioHandler.sendLine(message);
        }
      }
    }
  }

  public int getValidExits() {
    int numOfExits = 0;
    for (int i = 0; i < exits.length; i++) {
      if (exits[i] != 0) {
        numOfExits++;
      }
    }
    return numOfExits;
  }

  public void setZoneName(String zoneName) {
    this.zoneName = zoneName;
  }

  public String getZoneName() {
    return zoneName;
  }

}
