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

  public Response() {
    status = PDirtNG.STATUS_OK;
  }

  public Response(String response, int status) {
    this.response = response;
    this.status = status;
  }

  public void setResponse(String response) {
    this.response = response;
  }
  public String getResponse() {
    return response;
  }

  public void setStatus(int status) {
    this.status = status;
  }
  public int getStatus() {
    return status;
  }
}
