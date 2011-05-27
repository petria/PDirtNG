package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * Date: 5/27/11
 * Time: 7:29 AM
 *
 * @author Petri Airio
 */
public class SocketServer implements Runnable {


  private static final int SERVER_PORT = 6751;
  private boolean running;
  private PDirtNG engine;

  public SocketServer(PDirtNG engine) {
    this.engine = engine;

  }

  public void start() {
    Thread t = new Thread(this);
    t.start();
  }

  public void run() {
    ServerSocket sSocket = null;
    try {

      sSocket = new ServerSocket(SERVER_PORT);
      sSocket.setSoTimeout(3 * 1000);

      running = true;

      while (this.running) {
        try {

          Socket socket = sSocket.accept();
          NetworkClient client = new NetworkClient(engine, socket);
        } catch (SocketTimeoutException e) {
          //
        }

      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setRunning(boolean running) {
    this.running = running;
  }
}
