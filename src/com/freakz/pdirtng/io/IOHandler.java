package com.freakz.pdirtng.io;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Date: 24.5.2011
 * Time: 13:41
 *
 * @author Petri Airio
 */
public class IOHandler {

    private InputStream inputStream;
    private OutputStream outputStream;

    public IOHandler(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

}
