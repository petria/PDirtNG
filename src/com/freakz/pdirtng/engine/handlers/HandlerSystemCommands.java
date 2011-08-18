package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.io.IOHandler;

/**
 * Date: 18.8.2011
 * Time: 12:16
 *
 * @author Petri Airio
 */
public class HandlerSystemCommands extends EngineBaseHandler {

  public void HandlerSystemCommands_who(Request request, Response response) {
    String txt;
    txt = "Level        Player\n";
    txt += "-----------------------------------------------------------------------------\n";
    int count = 0;
    for (IOHandler ioHandler : request.getEngine().getClients()) {
      String level = "LEVEL";
      String name = ioHandler.getPlayer().getName();
      txt += String.format("[%-10s] %s\n", level, name);
      count++;
    }
    txt += "-----------------------------------------------------------------------------\n";
    txt += String.format("Total of %d visible users.\n", count);
    response.setResponse(txt);
  }

}
