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
  private List<Mobile> mobiles  = new ArrayList<Mobile>();

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
    zone.addLocation(location);
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

  public void addObject(MudObject mudObject) {
    Zone zone = this.zones.get(mudObject.getZoneId());
    zone.addObject(mudObject);

    Location location = findLocationById(mudObject.getLocation());
    if (location != null) {
      location.addObject(mudObject);
    }

    this.mudObjects.add(mudObject);
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

  public void moveMobiles() {
    for (Mobile mobile: this.mobiles) {
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

  public Mobile findMobileByName(String target) {
    for (Mobile mobile : this.mobiles) {
      if (mobile.getName().equalsIgnoreCase(target)) {
        return mobile;
      }
    }
    return null;
  }
}
