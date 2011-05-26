package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;
import com.freakz.pdirtng.engine.Response;

/**
 * Date: 26.5.2011
 * Time: 12:52
 *
 * @author Petri Airio
 */
public class GameHandler extends BaseHandler {

  public GameHandler(IOHandler ioHandler, PDirtNG engine) {
    super(ioHandler, engine);
    ioHandler.IOClient.print("Welcome PDirtNG!\n");
  }

  public String getPrompt() {
    return "PDirtNG> ";
  }

  @Override
  public Response handleLine(String line) {
    Response response = engine.handleLine(line);
    return response;
  }

}
