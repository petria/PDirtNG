package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Location;
import com.freakz.pdirtng.objects.MudObject;

/**
 * Date: 5.1.2012
 * Time: 12:58
 *
 * @author Petri Airio, Landis+Gyr Oy
 */
public class HandlerWizCommands extends EngineBaseHandler {

  public void HandlerWizCommands_Show(Request request, Response response) {

    MudObject obj = request.getEngine().getWorld().findMudObjectByName(request.getArgsParser().getArgs());
    if (obj != null) {
      Location location = request.getEngine().getWorld().findLocationById(obj.getLocation());
      String resp = "";
      resp += String.format("Item [%3d]: %s (%s)\n", obj.getId(), obj.getName(), obj.getAltName());
      resp += String.format("Location:   %s (Zone: %d)\n", location.getShortDescriptionNoColor(), location.getZoneId());
      response.setResponse(resp);
    } else {
      response.setResponse("What's that?\n");
    }
  }

}
