package com.freakz.pdirtng.engine;

import com.freakz.pdirtng.io.IOHandler;
import com.freakz.pdirtng.objects.Location;
import com.freakz.pdirtng.objects.Player;
import com.freakz.pdirtng.objects.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 24.5.2011
 * Time: 13:57
 *
 * @author Petri Airio
 */
public class PDirtNG {

  public static final int STATUS_OK = 0;
  public static final int STATUS_QUIT = 1;
  public static final int STATUS_LOGIN_OK = 2;

  private World world;
  private List<IOHandler> clients;

  public PDirtNG() {
    this.world = World.getInstance();
    clients = new ArrayList<IOHandler>();
  }

  public void addIOHandler(IOHandler ioHandler) {
    this.clients.add(ioHandler);
  }

  public void delIOHandler(IOHandler ioHandler) {
    this.clients.remove(ioHandler);
  }

  public Response handleLine(Player player, String line) {
    String txt = "Mud response: " + line + "\n";
    int status = STATUS_OK;
    if (line.equals("quit")) {
      status = STATUS_QUIT;
      txt = "Bye bye!\n";
    } else
    if (line.equals("look")) {
      Location location = world.findLocationById(player.getLocation());
      String lookReply = "";
      lookReply += ("------: " + location.getId() + " -> " + location.getObjectId() + "\n");
      lookReply += (location.getShortDescriptionNoColor() + " [" + location.getZoneId() + "]"+ "\n");
      lookReply += (location.getLongDescription() + "\n");
      lookReply += (location.getExitsString() + "\n");
      txt = lookReply;
    }
    Response response = new Response(txt, status);

    return response;
  }

}
