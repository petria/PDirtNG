package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;

/**
 * Date: 18.8.2011
 * Time: 12:20
 *
 * @author Petri Airio
 */
public class HandlerCommunicationCommands extends EngineBaseHandler {

  public void HandlerCommunicationCommands_Say(Request request, Response response) {
    request.getPlayer().getLocation().messageToRoom(request.getPlayer().getName() + " says: " + request.getArgsParser().getArgs() + "\n");
  }

}
