package com.freakz.pdirtng.engine;

/**
 * Date: 26.5.2011
 * Time: 13:18
 *
 * @author Petri Airio
 */
public class Response {

  public static final int STATUS_OK = 0;
  public static final int STATUS_QUIT = 1;
  public static final int STATUS_LOGIN_OK = 2;

  private String response;
  private int status;

  public Response(String response) {
    this.response = response;
    this.status = STATUS_OK;
  }

  public Response() {
    this.status = STATUS_OK;
  }

  public Response(String response, int status) {
    this.response = response;
    this.status = status;
  }

  public void setResponse(String response) {
    this.response = response;
  }
  public String getResponse() {
    return this.response;
  }

  public void setStatus(int status) {
    this.status = status;
  }
  public int getStatus() {
    return this.status;
  }
}
