package com.freakz.pdirtng.objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Date: 20.5.2011
 * Time: 13:25
 *
 * @author Petri Airio
 */
public class Bootstrap {


  private static final String LOCATIONS_DATA_FILE = "data/locations";
  private static final String ZONES_DATA_FILE = "data/zones";
  private static final String OBJECTS_DATA_FILE = "data/objects";


  public void loadZones() throws Exception {
    File f = new File(ZONES_DATA_FILE);
    BufferedReader br = new BufferedReader(new FileReader(f));
    String line = br.readLine();
    int zoneCount = Integer.parseInt(line);

    for (int i = 0; i < zoneCount; i++) {
      Zone zone = new Zone();
      line = br.readLine();
      String[] split = line.split(" ");
      zone.setZoneName(split[0]);
      zone.setStartLocation(Integer.parseInt(split[1]));
      World.getInstance().addZone(zone);

    }

  }

  public void loadLocations() throws Exception {

    File f = new File(LOCATIONS_DATA_FILE);
    BufferedReader br = new BufferedReader(new FileReader(f));
    String line = br.readLine();
    int locationCount = Integer.parseInt(line);

    for (int i = 0; i < locationCount; i++) {
      line = br.readLine();
      String split[] = line.split(" ");
      int id = Integer.parseInt(split[0]);
      int zoneId = Integer.parseInt(split[1]);
      Location location = new Location(id);
      location.setZoneId(zoneId);
      int idx = 2;
      for (int dir = 0; dir < 9; dir++) {
        String dirStr = split[idx];
        if (dirStr.length() == 0) {
          idx++;
          dirStr = split[idx];
        }

        int exitId = Integer.parseInt(dirStr);
        location.setExit(dir, exitId);
        idx++;
      }
      line = br.readLine();
      location.setFlags(line);
      line = br.readLine();
      location.setShortDescription(line);
      String desc = "";
      while (true) {
        line = br.readLine();
        if (line.equals("^")) {
          break;
        }
        desc += line + "\n";
      }
      location.setLongDescription(desc);
      World.getInstance().addLocation(location);

    }
  }

  public void loadObjects() throws Exception {
    File f = new File(OBJECTS_DATA_FILE);
    BufferedReader br = new BufferedReader(new FileReader(f));
    String line = br.readLine();
    int objectCount = Integer.parseInt(line);

    for (int i = 0; i < objectCount; i++) {
      Object object = new Object();
      line = br.readLine();
      String[] s = line.split(" ");
      object.setName(s[0]);
      object.setAltName(s[1]);
      object.setZoneId(Integer.parseInt(s[2]));
      object.setId(Integer.parseInt(s[3]));
      // s[4] =     int           onum;        number for the code to test so that cloned
      object.setLinked(Integer.parseInt(s[5]));
      object.setVisibility(Integer.parseInt(s[6]));
      object.setCarried(Integer.parseInt(s[7]));
      object.setLocation(Integer.parseInt(s[8]));
      object.setState(Integer.parseInt(s[9]));
      object.setDamage(Integer.parseInt(s[10]));
      object.setArmor(Integer.parseInt(s[11]));
      object.setMaxState(Integer.parseInt(s[12]));
      object.setValue(Integer.parseInt(s[13]));
      object.setSize(Integer.parseInt(s[14]));

      line = br.readLine(); // flags
      String[] desc = new String[4];
      String descX = null;
      for (int j = 0; j < 4; j++) {
        descX = "";
        while (true) {
          line = br.readLine();
          descX += line.replaceAll("\\^", "");
          if (line.endsWith("^")) {
            break;
          }
        }
        desc[j] = descX;
      }
      object.setDescriptions(desc);

      descX = "";
      while (true) {
        line = br.readLine();
        descX += line.replaceAll("^", "");
        if (descX.endsWith("^")) {
          break;
        }
      }
      object.setExamine(descX);
      br.readLine(); // empty line between objects

      World.getInstance().addObject(object);
    }

  }

}
