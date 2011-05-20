package com.freakz.pdirtng.startup;

import com.freakz.pdirtng.World;
import com.freakz.pdirtng.objects.Bootstrap;
import com.freakz.pdirtng.objects.Location;
import com.freakz.pdirtng.objects.MudObject;

import java.util.List;

/**
 * Date: 5/20/11
 * Time: 5:27 PM
 *
 * @author Petri Airio
 */
public class PDirtNG {


  public static void main(String[] args) throws Exception {

    Bootstrap boot = new Bootstrap();
    boot.loadLocations();

    World world = World.getInstance();

    List<MudObject> locations = world.getLocations();
    for (MudObject mObj : locations) {
      Location location = (Location) mObj;
      System.out.println("------: " + location.getId() + " -> " + location.getObjectId());
      System.out.println(location.getShortDescription() + " [" + location.getZoneId() + "]");
      System.out.println(location.getLongDescription());
    }

  }

}
