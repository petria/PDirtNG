package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;

/**
 * Date: 25.5.2011
 * Time: 13:42
 *
 * @author Petri Airio, Landis+Gyr Oy
 */
public class KonsoleClient implements ResponseHandler {

    private PDirtNG engine;
    private IOHandler ioHandler;

    public KonsoleClient(PDirtNG engine) {
        this.engine = engine;
        this.ioHandler = new IOHandler(engine, System.in, this);
    }

    public void handleResponse(String response) {
        System.out.println("R: " + response);
    }


}
