package com.freakz.pdirtng.startup;

import com.freakz.pdirtng.objects.Bootstrap;

/**
 * Date: 5/20/11
 * Time: 5:27 PM
 *
 * @author Petri Airio
 */
public class PDirtNG {


  public static void main(String[] args) throws Exception {

    Bootstrap boot = new Bootstrap();
    boot.loadLocations();

  }

}
