package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;
import com.freakz.pdirtng.engine.Response;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Date: 24.5.2011
 * Time: 13:41
 *
 * @author Petri Airio
 */
public class IOHandler extends Thread {

  private PDirtNG engine;
  private InputStream inputStream;
  private boolean running;
  protected IOClient IOClient;

  private Deque<Handler> handlerStack = new ArrayDeque<Handler>();

  public IOHandler(PDirtNG engine, InputStream inputStream, IOClient IOClient) {
    this.engine = engine;
    this.inputStream = inputStream;
    this.IOClient = IOClient;
  }

  public void start() {
    Thread t = new Thread(this);
    t.start();
  }

  public Handler getHandler() {
    return this.handlerStack.peek();
  }

  public void run() {
    this.engine.addIOHandler(this);

    GameHandler gameHandler = new GameHandler(this, this.engine);
    handlerStack.push(gameHandler);

    running = true;

    while (running) {
      String prompt = getHandler().getPrompt();
      if (prompt != null) {
        IOClient.print(prompt);
      }
      String line = IOClient.getLine();
      if (line != null) {
        Response response = pushLineToHandler(line);
        IOClient.print(response.getResponse());
        if (response.getStatus() == PDirtNG.STATUS_QUIT) {
          running = false;
        }
      } else {
        running = false;
      }
    }

    this.engine.delIOHandler(this);
    IOClient.quit();
  }

  private Response pushLineToHandler(String line) {
    Handler handler = getHandler();
    Response response = handler.handleLine(line);
    return response;
  }

}
