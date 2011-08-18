package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Object;

/**
 * Date: 18.8.2011
 * Time: 12:06
 *
 * @author Petri Airio
 */
public class HandlerObjectCommands extends EngineBaseHandler {

  public void HandlerObjectCommands_Examine(Request request, Response response) {
    Object object = request.getEngine().getWorld().findObjectByName(request.getPlayer().getLocation(), request.getArgs().getArgs());
    if (object != null) {
      response.setResponse(object.getExamine() + "\n");
    } else {
      response.setResponse("You see nothing special.\n");
    }
  }

}
