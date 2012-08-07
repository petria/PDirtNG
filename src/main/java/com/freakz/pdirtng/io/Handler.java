package com.freakz.pdirtng.io;

import com.freakz.pdirtng.engine.Response;
import com.freakz.pdirtng.objects.Player;

/**
 * Date: 25.5.2011
 * Time: 14:35
 *
 * @author Petri Airio
 */
public interface Handler {

  String getPrompt();

  Response handleLine(Player player, String line);

}
