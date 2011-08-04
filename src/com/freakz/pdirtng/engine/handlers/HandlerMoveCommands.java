package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;

/**
 * Date: 4.8.2011
 * Time: 15:47
 *
 * @author Petri Airio, Landis+Gyr Oy
 */
public class HandlerMoveCommands extends EngineBaseHandler {

  public void HandlerMoveCommands_n_e_s_w_u_d_move(Request request, Response response) {
    System.out.println("HandlerMoveCommands_move()");
  }

  public void HandlerMoveCommands_goto(Request request, Response response) {
    System.out.println("HandlerMoveCommands_goto");
  }

}
