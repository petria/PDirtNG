package com.freakz.pdirtng.engine;

import com.freakz.pdirtng.common.ArgsParser;
import com.freakz.pdirtng.objects.Player;

/**
 * Date: 8/4/11
 * Time: 5:42 PM
 *
 * @author Petri Airio
 */
public class Request {

  private ArgsParser args;
  private PDirtNG engine;
  private Player player;

  public Request(String line, Player player, PDirtNG engine) {
    this.args = new ArgsParser(line);
    this.player = player;
    this.engine = engine;
  }

  public ArgsParser getArgsParser() {
    return args;
  }

  public PDirtNG getEngine() {
    return engine;
  }

  public Player getPlayer() {
    return player;
  }
}
