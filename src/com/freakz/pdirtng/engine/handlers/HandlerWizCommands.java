package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.MudObject;
import com.freakz.pdirtng.objects.World;
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

    int objectId = 0;
    boolean gotId = false;
    try {
      objectId = Integer.parseInt(request.getArgsParser().getArgs());
      gotId = true;
    } catch (NumberFormatException ex) {
      // ignore
    }

    MudObject obj;
    if (gotId) {
      obj = request.getEngine().getWorld().findMudObjectById(objectId);

    } else {
      obj = request.getEngine().getWorld().findMudObjectByName(request.getArgsParser().getArgs());
    }

    if (obj != null) {
//      Location location = request.getEngine().getWorld().findLocationById(obj.getLocation());
      Zone zone = request.getEngine().getWorld().getZone(obj.getZoneId());
      String zoneName = "<zonename??>";
      if (zone != null) {
        zoneName = zone.getZoneName();
      }
      String resp = "";
      String altName = "";
      if (obj.getAltName() != null && !obj.getAltName().equals("<null>")) {
        altName = String.format(" (%s)", obj.getAltName());
      }
      resp += String.format("Item [%3d]: %s%s\n", obj.getId(), obj.getName(), altName);
      resp += String.format("Location  : %s\n", World.getInstance().getRealLocationString(obj));
      resp += String.format("Zone/Owner: %s\n\n", zoneName);

      resp += String.format("State:          %-4d    Max State:     %-4d\n", obj.getState(), obj.getMaxState());
      resp += String.format("Damage:         %-4d    Armor Class:   %-4d      Size: %d\n", obj.getDamage(), obj.getArmor(), obj.getSize());
      resp += String.format("Base value:     %-4d    Current Value: %-4d\n", 0, obj.getValue());
      resp += String.format("Special Events: %s\n\n", "No.");

      resp += String.format("Properties: %s\n\n", "<TODO>"); // TODO

      resp += String.format("State:   Description:\n");
      for (int i = 0; i < 4; i++) {
        resp += String.format("[%d]    %s\n", i, obj.getDescriptions()[i]);
      }

      response.setResponse(resp);
    } else {
      response.setResponse("What's that?\n");
    }
  }

}
