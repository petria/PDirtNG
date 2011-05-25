package com.freakz.pdirtng.io;

/**
 * Date: 25.5.2011
 * Time: 14:57
 *
 * @author Petri Airio, Landis+Gyr Oy
 */
public abstract class BaseHandler implements Handler {

    protected IOHandler ioHandler;

        public BaseHandler(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public abstract String handleLine(String line);

    public void sendReply(String reply) {
        ioHandler.sendReply(reply);
    }

}
