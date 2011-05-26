package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;

import java.io.*;

/**
 * Date: 25.5.2011
 * Time: 13:42
 *
 * @author Petri Airio
 */
public class KonsoleClient implements IOClient {

  private PDirtNG engine;
  private IOHandler ioHandler;
  private boolean running;

  public KonsoleClient(PDirtNG engine) {
    this.engine = engine;
    this.ioHandler = new IOHandler(engine, System.in, this);
  }


  public String getLine() {
    String line;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    try {
      line = br.readLine();
    } catch (IOException e) {
      line = null;
      e.printStackTrace();
    }
    return line;
  }

  public void print(String line) {
    System.out.print(line);
    System.out.flush();
  }

  public synchronized void quit() {
    notifyAll();
  }

  public synchronized void start() {
    ioHandler.start();
    try {
      wait();
    } catch (InterruptedException e) {
      //
    }
  }

}
