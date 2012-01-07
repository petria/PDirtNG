package com.freakz.pdirtng.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 5/20/11
 * Time: 5:37 PM
 *
 * @author Petri Airio
 */
public class World implements Runnable {

  private static final int GAME_TICK_SECONDS = 3;
  private static final int MOBILES_MOVE_RANDOM = 30;

  private static World ourInstance = new World();

  private List<Location> locations = new ArrayList<Location>();
  private List<Zone> zones = new ArrayList<Zone>();
  private List<MudObject> mudObjects = new ArrayList<MudObject>();
  private List<Mobile> mobiles = new ArrayList<Mobile>();

  public static World getInstance() {
    return ourInstance;
  }

  private World() {
  }

  /**
   * Adds location to the World. Also adds Location to Zone it belongs to.
   *
   * @param location new Location
   */
  public void addLocation(Location location) {
    int zoneId = location.getZoneId();
    Zone zone = this.zones.get(zoneId);
    int numInZone = zone.addLocation(location);
    location.setZoneName(zone.getZoneName() + numInZone);
    this.locations.add(location);
  }

  public List<Location> getLocations() {
    return locations;
  }

  public Location findLocationById(int exitId) {
    for (Location location : locations) {
      if (location.getId() == exitId) {
        return location;
      }
    }
    return null;
  }

  public void addZone(Zone zone) {
    zone.setZoneId(this.zones.size());
    this.zones.add(zone);
  }

  public Zone getZone(int zoneId) {
    for (Zone zone : this.zones) {
      if (zone.getZoneId() == zoneId) {
        return zone;
      }
    }
    return null;
  }

  public void addObject(MudObject mudObject) {
    Zone zone = this.zones.get(mudObject.getZoneId());
    zone.addObject(mudObject);
    this.mudObjects.add(mudObject);
  }

  public void placeObjects() {
    for (MudObject mudObject : this.mudObjects) {


      if (mudObject.getCarried() != MudObject.FLAG_IN_ROOM) {

        if (mudObject.getCarried() == MudObject.FLAG_IN_CONTAINER) {
//        System.out.println("** FLAG_IN_CONTAINER OBJECT: " + mudObject.getName() + "[" + mudObject.getId() + "]");
          MudObject container = findMudObjectById(mudObject.getLocation());
          if (container != null) {
            System.out.printf("**[%03d]  %s is in container %s\n", mudObject.getId(), mudObject.getName(), container.getName());
            container.addMudObject(mudObject);
          } else {
            System.out.printf("** ??\n");
          }
        } else {
          Mobile mobile = findMobileById(mudObject.getLocation());
          mobile.addMudObject(mudObject);
          System.out.printf("**[%03d]  %s is carrying/wielding %s\n", mudObject.getId(), mobile.getName(), mudObject.getName());
        }

      } else {
        Location location = findLocationById(mudObject.getLocation());
        location.addObject(mudObject);
        System.out.printf("**[%03d]  %s is in location %s\n", mudObject.getId(), mudObject.getName(), location.getZoneName());
      }

    }

  }


  public void addMobile(Mobile mobile) {
    Zone zone = this.zones.get(mobile.getZoneId());
    zone.addMobile(mobile);

    Location location = mobile.getLocation();
    if (location != null) {
      location.addMobile(mobile);
    }

    this.mobiles.add(mobile);
  }

  public MudObject findMudObjectById(long mudObjectId) {
    for (MudObject obj : mudObjects) {
      if (obj.getId() == mudObjectId) {
        return obj;
      }
    }
    return null;
  }

  public MudObject findMudObjectByName(String name) {
    MudObject mudObject = null;
    for (MudObject obj : mudObjects) {
      if (obj.getName().startsWith(name) || obj.getAltName().startsWith(name)) {
        return obj;
      }
    }
    return mudObject;
  }


  public MudObject findLocationMudObjectByName(Location location, String target) {
    for (MudObject obj : location.getMudObjects()) {
      if (obj.getName().startsWith(target) || obj.getAltName().startsWith(target)) {
        return obj;
      }
    }
    return null;
  }

  public void start() {
    Thread t = new Thread(this);
    t.start();
  }

  public Mobile findMobileById(int mobileId) {
    for (Mobile mobile : this.mobiles) {
      if (mobile.getId() == mobileId) {
        return mobile;
      }
    }
    return null;
  }

  public Mobile findMobileByName(String target) {
    for (Mobile mobile : this.mobiles) {
      if (mobile.getName().equalsIgnoreCase(target)) {
        return mobile;
      }
    }
    return null;
  }


//------------------------------------------------------------------------
//------------------------------------------------------------------------
//------------------------------------------------------------------------

  public void moveMobiles() {
    for (Mobile mobile : this.mobiles) {
      if (mobile.getSpeed() > 0) {
        int rnd = 1 + (int) (Math.random() * 100);
        Location location = mobile.getLocation();
        if (location != null && location.getValidExits() > 0 && rnd > MOBILES_MOVE_RANDOM) {
          int rndExit = ((int) (Math.random() * 100)) % Location.NUM_OF_EXITS;
          int dir = 0;
          while (true) {
            dir = location.getExits()[rndExit];
            if (dir != 0) {
              break;
            }
            rndExit++;
            if (rndExit == Location.NUM_OF_EXITS) {
              rndExit = 0;
            }
          }
          Location newLocation = findLocationById(dir);
          mobile.setLocation(newLocation, Location.EXIT_UNKNOWN, rndExit);
//          mobile.moveTo(dir, rndExit);
        }
      }
    }
  }

  public void run() {
    while (true) {
      moveMobiles();
      try {
        Thread.sleep(1000 * GAME_TICK_SECONDS);
      } catch (InterruptedException e) {
        //
      }
    }
  }


}
