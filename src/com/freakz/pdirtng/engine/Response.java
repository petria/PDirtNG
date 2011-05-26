package com.freakz.pdirtng.engine;

/**
 * Date: 26.5.2011
 * Time: 13:18
 *
 * @author Petri Airio
 */
public class Response {

  private String response;
  private int status;

  public Response(String response, int status) {
    this.response = response;
    this.status = status;
  }

  public String getResponse() {
    return response;
  }

  public int getStatus() {
    return status;
  }
}
