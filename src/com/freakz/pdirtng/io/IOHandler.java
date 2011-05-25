package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    ResponseHandler responseHandler;
    private boolean running;

    private Deque<Handler> handlerStack = new ArrayDeque<Handler>();

    public IOHandler(PDirtNG engine, InputStream inputStream, ResponseHandler responseHandler) {
        this.engine = engine;
        this.inputStream = inputStream;
        this.responseHandler = responseHandler;
    }

    public void start() {
        this.engine.addIOHandler(this);
    }

    private String getLine() {
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        try {
            line = br.readLine();
        } catch (IOException e) {
            line = null;
            e.printStackTrace();
        }
        return line;
    }

    public void run() {
        running = true;
        while (running) {
            String line = getLine();
            if (line != null) {
                pushLineToHandler(line);
            } else {
                running = false;
            }
        }

        this.engine.delIOHandler(this);
    }

    private void pushLineToHandler(String line) {
        Handler handler = this.handlerStack.peek();
        String response = handler.handleLine(line);
        this.responseHandler.handleResponse(response);
    }

    public void sendReply(String reply) {
        pushLineToHandler(reply);
    }
}
