package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;
import com.freakz.pdirtng.engine.Response;

/**
 * Date: 25.5.2011
 * Time: 14:47
 *
 * @author Petri Airio
 */
public class LoginHandler extends BaseHandler {

  public LoginHandler(IOHandler ioHandler, PDirtNG engine) {
    super(ioHandler, engine);
  }

  public String getPrompt() {
    return null;
  }

  public Response handleLine(String line) {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }
}
