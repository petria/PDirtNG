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


  public static World getInstance() {
    return ourInstance;
  }

  private World() {
  }

  public void addLocation(Location location) {
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
}
