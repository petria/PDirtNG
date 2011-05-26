package com.freakz.pdirtng.io;

/**
 * Date: 25.5.2011
 * Time: 14:42
 *
 * @author Petri Airio
 */
public interface IOClient {

  String getLine();

  void print(String line);

  void quit();
}
