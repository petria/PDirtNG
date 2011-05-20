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
      do {
        line = br.readLine();
        desc += line + "\n";
      } while (!line.equals("^"));
      location.setLongDescription(desc);

    }

  }

}
