package com.freakz.pdirtng.startup;

import com.freakz.pdirtng.engine.PDirtNG;
import com.freakz.pdirtng.io.KonsoleClient;
import com.freakz.pdirtng.io.SocketServer;
import com.freakz.pdirtng.objects.Bootstrap;

/**
 * Date: 5/20/11
 * Time: 5:27 PM
 *
 * @author Petri Airio
 */
public class StartUp {


  public static void main(String[] args) throws Exception {

    Bootstrap boot = new Bootstrap();
    boot.loadLocations();

    PDirtNG engine = new PDirtNG();

    SocketServer socketServer = new SocketServer(engine);
    socketServer.start();

    KonsoleClient konsole = new KonsoleClient(engine);
    konsole.start();

/*    World world = World.getInstance();

List<Location> locations = world.getLocations();
for (Location location: locations) {
  System.out.println("------: " + location.getId() + " -> " + location.getObjectId());
  System.out.println(location.getShortDescriptionNoColor() + " [" + location.getZoneId() + "]");
  System.out.println(location.getLongDescription());
  System.out.println(location.getExitsString());
}*/

  }

}
