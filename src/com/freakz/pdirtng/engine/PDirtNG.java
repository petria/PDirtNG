package com.freakz.pdirtng.engine;

import com.freakz.pdirtng.io.IOHandler;
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

  public Response handleLine(String line) {
    String txt = "Mud response: " + line + "\n";
    int status = STATUS_OK;
    if (line.equals("quit")) {
      status = STATUS_QUIT;
      txt = "Bye bye!\n";
    }
    Response response = new Response(txt, status);

    return response;
  }

}
