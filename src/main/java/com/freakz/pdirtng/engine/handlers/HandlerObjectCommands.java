package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.MudObject;
import com.freakz.pdirtng.objects.World;
import com.freakz.pdirtng.objects.Zone;

import java.util.List;

/**
 * Date: 18.8.2011
 * Time: 12:06
 *
 * @author Petri Airio
 */
public class HandlerObjectCommands extends EngineBaseHandler {

  public void HandlerObjectCommands_Examine(Request request, Response response) {
    MudObject mudObject = request.getEngine().getWorld().findLocationMudObjectByName(request.getPlayer().getLocation(), request.getArgsParser().getArgs());
    if (mudObject != null) {
      response.setResponse(mudObject.getExamine() + "\n");
    } else {
      response.setResponse("You see nothing special.\n");
    }
  }

  public void HandlerObjectCommands_Take_Get(Request request, Response response) {
    if (!request.getArgsParser().hasArgs()) {
      response.setResponse("Get what?\n");
    } else {
      MudObject mudObject = request.getEngine().getWorld().findLocationMudObjectByName(request.getPlayer().getLocation(), request.getArgsParser().getArgs());
      if (mudObject != null) {

      } else {
        response.setResponse("It's not here.\n");
      }

    }
  }

  public void HandlerObjectCommands_Where(Request request, Response response) {

    List<MudObject> found = request.getEngine().getWorld().findMudObjectsByName(request.getArgsParser().getArgs());
    if (found.size() == 0) {
      response.setResponse("I don't know what that is.");
    } else {
      String resp = "";
      for (MudObject obj : found) {
        Zone zone = request.getEngine().getWorld().getZone(obj.getZoneId());
        String zoneName = "<zonename??>";
        if (zone != null) {
          zoneName = zone.getZoneName();
        }
        String where = World.getInstance().getRealLocationString(obj);
        resp += String.format("[%4d] %13s - %-20s | %s\n", obj.getId(), obj.getName(), where, zoneName);
      }
      response.setResponse(resp);
    }

  }


}
