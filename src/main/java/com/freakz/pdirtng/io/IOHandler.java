package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Location;
import com.freakz.pdirtng.objects.Player;

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
  private Player player;

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
    this.handlerStack.push(gameHandler);
    LoginHandler loginHandler = new LoginHandler(this, this.engine);
    this.handlerStack.push(loginHandler);

    this.running = true;

    while (this.running) {
      String prompt = getHandler().getPrompt();
      if (prompt != null) {
        this.IOClient.print(prompt);
      }
      String line = this.IOClient.getLine();
      if (line != null && line.length() > 0) {
        Response response = pushLineToHandler(line);
        if (response.getResponse() != null) {
          this.IOClient.print(response.getResponse());
        }

        if (response.getStatus() == Response.STATUS_LOGIN_OK) {
          this.handlerStack.pop();
          this.player = new Player(loginHandler.getLogin(), this);
          this.player.setLocation(engine.getWorld().findLocationById(-1906), Location.EXIT_ENTERED_GAME, Location.EXIT_ENTERED_GAME);
        } else if (response.getStatus() == Response.STATUS_QUIT) {
          this.player.setLocation(null, Location.EXIT_QUIT_GAME, Location.EXIT_QUIT_GAME);
          this.running = false;
        }

      }
    }

    this.engine.delIOHandler(this);
    this.IOClient.quit();
  }

  private Response pushLineToHandler(String line) {
    Handler handler = getHandler();
    Response response = handler.handleLine(this.player, line);
    return response;
  }

  public void sendLine(String message) {
    this.IOClient.print(message);
  }

  public Player getPlayer() {
    return player;
  }

}
