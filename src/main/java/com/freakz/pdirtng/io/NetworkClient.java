package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Date: 5/27/11
 * Time: 7:37 AM
 *
 * @author Petri Airio
 */
public class NetworkClient implements IOClient, Runnable {

  private PDirtNG engine;
  private Socket socket;
  private Thread thread;
  private IOHandler ioHandler;

  public NetworkClient(PDirtNG engine, Socket socket) throws IOException {

    this.engine = engine;
    this.socket = socket;
    this.ioHandler = new IOHandler(engine, socket.getInputStream(), this);

    this.thread = new Thread(this);
    this.thread.start();
  }


  public String getLine() {
    String line;
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      line = br.readLine();
    } catch (IOException e) {
      line = null;
      e.printStackTrace();
    }
    return line;
  }

  public void print(String line) {
    try {
      PrintWriter pw = new PrintWriter(socket.getOutputStream());
      pw.print(line);
      pw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public synchronized void quit() {
    notifyAll();
  }

  public synchronized void run() {

    this.ioHandler.start();
    try {
      wait();
      this.socket.close();
    } catch (Exception e) {
      // ignore
    }
  }
}
