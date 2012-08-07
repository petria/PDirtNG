package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;

/**
 * Date: 7.8.2012
 * Time: 10:43
 *
 * @author Petri Airio
 */
public class HandlerPlayerCommands extends EngineBaseHandler {


  public void HandlerPlayerCommands_Inventory(Request request, Response response) {
    response.setResponse("inventory!");
  }


}
