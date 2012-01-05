package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.MudObject;

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


}
