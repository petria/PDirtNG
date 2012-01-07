package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Location;
import com.freakz.pdirtng.objects.MudObject;
import com.freakz.pdirtng.objects.Zone;

/**
 * Date: 5.1.2012
 * Time: 12:58
 *
 * @author Petri Airio, Landis+Gyr Oy
 */
public class HandlerWizCommands extends EngineBaseHandler {

/*  public void HandlerWizCommands_Locations(Request request, Response response) {

  }
  */

  public void HandlerWizCommands_Show(Request request, Response response) {

    MudObject obj = request.getEngine().getWorld().findMudObjectByName(request.getArgsParser().getArgs());
    if (obj != null) {
      Location location = request.getEngine().getWorld().findLocationById(obj.getLocation());
      Zone zone = request.getEngine().getWorld().getZone(location.getZoneId());
      String resp = "";
      resp += String.format("Item [%3d]: %s (%s)\n", obj.getId(), obj.getName(), obj.getAltName());
      resp += String.format("Location:    %s\n", location.getZoneName());
      resp += String.format("Zone/Owner:  %s\n\n", zone.getZoneName());

      resp += String.format("State: %d    Max State: %d\n", obj.getState(), obj.getMaxState());
      resp += String.format("Damage: %d   Armor Class: %d    Size: %d\n", obj.getDamage(), obj.getArmor(), obj.getSize());
      resp += String.format("Base value: %d  Current Value: %d\n", -1, obj.getValue());

      response.setResponse(resp);
    } else {
      response.setResponse("What's that?\n");
    }
  }

}
