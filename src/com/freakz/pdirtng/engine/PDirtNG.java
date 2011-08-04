package com.freakz.pdirtng.engine;

import com.freakz.pdirtng.engine.handlers.EngineBaseHandler;
import com.freakz.pdirtng.io.IOHandler;
import com.freakz.pdirtng.objects.*;
import com.freakz.pdirtng.objects.Object;

import java.lang.reflect.Method;
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
    scanHandlers();
  }

  public void addIOHandler(IOHandler ioHandler) {
    this.clients.add(ioHandler);
  }

  public void delIOHandler(IOHandler ioHandler) {
    this.clients.remove(ioHandler);
  }

  public Response handleLine(Player player, String line) {
    String txt = null;
    int status = STATUS_OK;
    if (line.equals("quit")) {
      status = STATUS_QUIT;
      txt = "Bye bye!\n";
    } else if (line.startsWith("examine ")) {
      String target = line.replaceFirst("examine ", "");
      Object object = this.world.findObjectByName(player.getLocation(), target);
      if (object != null) {
        txt = object.getExamine() + "\n";
      } else {
        txt = "You see nothing special.\n";
      }

    } else if (line.equals("look")) {

      Location location = player.getLocation();
      txt = location.look();

    } else if (line.startsWith("goto ")) {
      String target = line.replaceAll("goto ", "");
      Mobile mobile = this.world.findMobileByName(target);
      if (mobile != null) {
        player.setLocation(mobile.getLocation(), Location.EXIT_GOTO_HERE, Location.EXIT_GOTO_HERE);
      }

    } else if (line.matches("n|e|s|w|u|d")) {

      int dir = Location.resolveDir(line);
      Location location = player.getLocation();
      int moveToId = location.getExits()[dir];
      if (moveToId != 0) {
        location = world.findLocationById(moveToId);
        txt = location.look();
        player.setLocation(location, Location.EXIT_UNKNOWN, dir);
      } else {
        txt = "Can't go that way!\n";
      }

    } else if (line.matches("who")) {
      txt = "Level        Player\n";
      txt += "-----------------------------------------------------------------------------\n";
      int count = 0;
      for (IOHandler ioHandler : this.clients) {
        String level = "LEVEL";
        String name = ioHandler.getPlayer().getName();
        txt += String.format("[%-10s] %s\n", level, name);
        count++;
      }
      txt += "-----------------------------------------------------------------------------\n";
      txt += String.format("Total of %d visible users.\n", count);
    } else if (line.startsWith("say ")) {
      String say = line.replaceFirst("say ", "");
      player.getLocation().messageToRoom(player.getName() + " says: " + say + "\n");
    } else {
      txt = "I beg your pardon?\n";
    }


    Response response = new Response(txt, status);

    return response;
  }

  public World getWorld() {
    return this.world;
  }

  private void scanHandlers() {
    String scanDir = "out/production/PDirtNG/";
    try {
      List<String> classNames = DynamicClassLoading.scanClasses(scanDir, "com/freakz/pdirtng/engine/handlers/", "com.freakz.pdirtng.engine.handlers.HandlerTestCommands.*");
      ClassLoader loader = new CustomClassLoader(scanDir);

      for (String name : classNames) {
        String ownerClass = name.replaceAll("com.freakz.pdirtng.engine.handlers.", "");

        EngineBaseHandler handler = (EngineBaseHandler) DynamicClassLoading.instantiate(loader, name);

        Method methods[] = handler.getClass().getMethods();
        for (Method method : methods) {
          String methodName = method.getName();
          String split[] = methodName.split("_");
          if (split[0].matches(ownerClass)) {
            String matcher = split[1];
            int foo = 0;
          }

        }

      }


    } catch (Exception e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }

}
