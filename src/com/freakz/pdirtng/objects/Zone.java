package com.freakz.pdirtng.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.5.2011
 * Time: 8:46
 *
 * @author Petri Airio, Landis+Gyr Oy
 */
public class Zone extends MudObject {

  private int zoneId;
  private String zoneName;
  private int startLocation;

  private List<Location> locations = new ArrayList<Location>();
  private List<Object> objects = new ArrayList<Object>();
  private List<Mobile> mobiles = new ArrayList<Mobile>();

  public Zone() {
    super();
  }

  public int getZoneId() {
    return zoneId;
  }

  public void setZoneId(int zoneId) {
    this.zoneId = zoneId;
  }

  public String getZoneName() {
    return zoneName;
  }

  public void setZoneName(String zoneName) {
    this.zoneName = zoneName;
  }

  public int getStartLocation() {
    return startLocation;
  }

  public void setStartLocation(int startLocation) {
    this.startLocation = startLocation;
  }

  public void addLocation(Location location) {
    this.locations.add(location);
  }

  public List<Location> getZoneLocations() {
    return this.locations;
  }

  public void addObject(Object object) {
    this.objects.add(object);
  }


  public void addMobile(Mobile mobile) {
    this.mobiles.add(mobile);
  }
}
