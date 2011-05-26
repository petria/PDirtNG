package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;
import com.freakz.pdirtng.engine.Response;

/**
 * Date: 25.5.2011
 * Time: 14:57
 *
 * @author Petri Airio
 */
public abstract class BaseHandler implements Handler {

  protected IOHandler ioHandler;
  protected PDirtNG engine;

  public BaseHandler(IOHandler ioHandler, PDirtNG engine) {
    this.ioHandler = ioHandler;
    this.engine = engine;
  }

  public abstract Response handleLine(String line);

}
