/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.util;

import com.entertainment.DisplayType;
import com.entertainment.Television;

public class TelevisionDisplayAdvisor {
  /**
   * TASK: if a Television's display is CRT, print a message indicating need for upgrade
   * 
   * Steps:
   *  loop over the vararg parameter 'tvs' - for each Television:
   *   - determine if its display property is DisplayType.CRT
   *   - if a CRT Television is found, print message to stdout (keep it simple)
   *  
   * OPTIONAL: print "no upgrades needed" (once) if no CRT Televisions are found at all
   */
  public static void check(Television... tvs) {
    for(Television tv : tvs) {
      if(tv.getDisplayType().equals(DisplayType.CRT)) {
        System.out.println(tv.getBrand() + ": display type = " +tv.getDisplayType() + " -- !! TIME FOR AN UPGRADE !!");
      } else {
        System.out.println(tv.getBrand() + ": display type = " +tv.getDisplayType() + " -- no upgrade required");
      }
    }
  }
}