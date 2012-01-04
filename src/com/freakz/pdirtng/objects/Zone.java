package com.freakz.pdirtng.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 30.5.2011
 * Time: 8:46
 *
 * @author Petri Airio
 */
public class Zone extends MObject {

  private int zoneId;
  private String zoneName;
  private int startLocation;

  private List<Location> locations = new ArrayList<Location>();
  private List<MudObject> mudObjects = new ArrayList<MudObject>();
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

  public void addObject(MudObject mudObject) {
    this.mudObjects.add(mudObject);
  }


  public void addMobile(Mobile mobile) {
    this.mobiles.add(mobile);
  }
}
