package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.PDirtNG;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Player;

/**
 * Date: 25.5.2011
 * Time: 14:47
 *
 * @author Petri Airio
 */
public class LoginHandler extends BaseHandler {

  private static final int STATE_GET_LOGIN = 0;
  private static final int STATE_GET_PASSWD = 1;
  private static final int STATE_END = 2;

  private static final String[] prompts = {"Login: ", "Password: ", null};

  private int state = STATE_GET_LOGIN;
  private String login;

  public LoginHandler(IOHandler ioHandler, PDirtNG engine) {
    super(ioHandler, engine);
  }

  public String getPrompt() {
    return prompts[state];
  }

  public Response handleLine(Player player, String line) {
    Response response = new Response();
    switch (state) {
      case STATE_GET_LOGIN:
        if (line.equalsIgnoreCase("Rydis")) {
          login = line;
          response.setResponse("name ok!\n");
          state++;
        } else {
          response.setResponse("name nok!\n");
        }
        break;
      case STATE_GET_PASSWD:
        if (line.equalsIgnoreCase("1234")) {
          response.setResponse("Password ok!\n");
          response.setStatus(PDirtNG.STATUS_LOGIN_OK);
          state++;
        } else {
          response.setResponse("Invalid password!\n");
          state = STATE_GET_LOGIN;
        }
        break;
      case STATE_END:
        break;
    }
    return response;
  }

  public String getLogin() {
    return login;
  }

}
