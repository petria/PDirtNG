package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Location;

/**
 * Date: 18.8.2011
 * Time: 10:33
 *
 * @author Petri Airio
 */
public class HandlerRoomCommands extends EngineBaseHandler {

  public void HandlerRoomCommands_look(Request request, Response response) {
    Location location = request.getPlayer().getLocation();
    response.setResponse(location.look());
  }

}
