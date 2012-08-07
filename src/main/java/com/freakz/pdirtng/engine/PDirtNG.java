package com.freakz.pdirtng.engine;

import com.freakz.pdirtng.engine.handlers.EngineBaseHandler;
import com.freakz.pdirtng.io.IOHandler;
import com.freakz.pdirtng.objects.Player;
import com.freakz.pdirtng.objects.World;

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

  private World world;
  private List<IOHandler> clients;
  private List<DynamicHandlerClass> commandHandlers;

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
    Response response = null;
    if (line.equals("quit")) {
      response = new Response("Bye bye!\n", Response.STATUS_QUIT);
    } else {
      for (DynamicHandlerClass handlerClass : commandHandlers) {
        String matcher = handlerClass.getMatcher();
        if (line.matches(matcher)) {
          Request request = new Request(line, player, this);
//          System.out.println("Should invoke: " + handlerClass.getOwnerClass() + " --> " + handlerClass.getMethod());
          try {
            response = new Response();
            handlerClass.getMethod().invoke(handlerClass.getOwnerClass(), request, response);
            break;
          } catch (Exception e) {
            response = new Response("Internal error!: " + e.getMessage(), Response.STATUS_OK);
            e.printStackTrace();
          }
        }
      }
      if (response == null) {
        response = new Response("I beg your pardon?\n", Response.STATUS_OK);
      }
    }
    return response;
  }

  public World getWorld() {
    return this.world;
  }

  public List<IOHandler> getClients() {
    return clients;
  }

  private void scanHandlers() {
    String scanDir = "out/";
    try {
      List<String> classNames = DynamicClassLoading.scanClasses(scanDir, "com/freakz/pdirtng/engine/handlers/", "com.freakz.pdirtng.engine.handlers.Handler.*");
      ClassLoader loader = new CustomClassLoader(scanDir);
      List<DynamicHandlerClass> handlersList = new ArrayList<DynamicHandlerClass>();
      for (String name : classNames) {
        String ownerClass = name.replaceAll("com.freakz.pdirtng.engine.handlers.", "");

        EngineBaseHandler handler = (EngineBaseHandler) DynamicClassLoading.instantiate(loader, name);

        Method methods[] = handler.getClass().getMethods();
        for (Method method : methods) {
          Class[] params = method.getParameterTypes();
          if (params.length != 2) {
            continue;
          }
          if (params[0] != Request.class && params[1] != Response.class) {
            continue;
          }

          String methodName = method.getName();
          if (methodName.startsWith(ownerClass)) {
            methodName = methodName.replaceAll(ownerClass + "_", "");
            String split[] = methodName.split("_");
            String matcher = null;
            for (String matchPart : split) {
              if (matcher == null) {
                matcher = "";
              } else {
                matcher += "|";
              }
              matcher += matchPart.toLowerCase();
              char chr = matchPart.charAt(0);
              if (Character.isUpperCase(chr)) {
                matcher += ".*";
              }
            }

            DynamicHandlerClass dhc = new DynamicHandlerClass(matcher, method, handler);
            handlersList.add(dhc);

          }
        }
      }

      this.commandHandlers = handlersList;

    } catch (Exception e) {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }

}
