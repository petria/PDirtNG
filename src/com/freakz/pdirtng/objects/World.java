package com.freakz.pdirtng.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 5/20/11
 * Time: 5:37 PM
 *
 * @author Petri Airio
 */
public class World {

  private static World ourInstance = new World();

  private List<Location> locations = new ArrayList<Location>();
  private List<Zone> zones = new ArrayList<Zone>();
  private List<Object> objects = new ArrayList<Object>();


  public static World getInstance() {
    return ourInstance;
  }

  private World() {
  }

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

  public void addObject(Object object) {
    Zone zone = this.zones.get(object.getZoneId());
    this.objects.add(object);
  }

}
