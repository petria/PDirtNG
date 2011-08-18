package com.freakz.pdirtng.engine.handlers;

import com.freakz.pdirtng.engine.Request;
import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Location;
import com.freakz.pdirtng.objects.Mobile;

/**
 * Date: 4.8.2011
 * Time: 15:47
 *
 * @author Petri Airio
 */
public class HandlerMoveCommands extends EngineBaseHandler {

  public void HandlerMoveCommands_n_e_s_w_u_d_move(Request request, Response response) {
    String line = request.getArgs().getOrigLine();
    String txt;
    int dir = Location.resolveDir(line);
    Location location = request.getPlayer().getLocation();
    int moveToId = location.getExits()[dir];
    if (moveToId != 0) {
      location = request.getEngine().getWorld().findLocationById(moveToId);
      txt = location.look();
      request.getPlayer().setLocation(location, Location.EXIT_UNKNOWN, dir);
    } else {
      txt = "Can't go that way!\n";
    }
    response.setResponse(txt);

    System.out.println("HandlerMoveCommands_move()");
  }

  public void HandlerMoveCommands_Goto(Request request, Response response) {
    String target = request.getArgs().getArgs();
    if (target.length() == 0) {
      // TODO GOTO HOME LOCATION
    }
    Mobile mobile = request.getEngine().getWorld().findMobileByName(target);
    if (mobile != null) {
      request.getPlayer().setLocation(mobile.getLocation(), Location.EXIT_GOTO_HERE, Location.EXIT_GOTO_HERE);
    } else {
      response.setResponse("Unknown Player, object or room\n");
    }
  }

}
