package com.freakz.pdirtng;

import com.freakz.pdirtng.objects.Location;
import com.freakz.pdirtng.objects.MudObject;

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

  private List<MudObject> locations = new ArrayList<MudObject>();


  public static World getInstance() {
    return ourInstance;
  }

  private World() {
  }

  public void addLocation(Location location) {
    this.locations.add(location);
  }

  public List<MudObject> getLocations() {
    return locations;
  }

}
