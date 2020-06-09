/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.client;

import static com.entertainment.DisplayType.*;

import com.entertainment.DisplayType;
import com.entertainment.Television;
import com.entertainment.util.TelevisionDisplayAdvisor;

public class TelevisionDisplayAdvisorTest {
  
  public static void main(String[] args) {
    // NOTE: TelevisionDisplayAdvisor.check() is a static method, so it's called via the classname
    
    // TODO: pass individual instances
    TelevisionDisplayAdvisor.check(
            new Television("Sony", 50, LED),
            new Television("Toshiba", 75, CRT),
            new Television("LG", 15, LCD));
    System.out.println("-----");
    
    // TODO: pass nothing
    TelevisionDisplayAdvisor.check();
    System.out.println("-----");
    
    // TODO: pass an array - would only do this if you already had one, otherwise just pass individual instances
    Television[] tvArray = {
            new Television("Sony", 50, LED),
            new Television("Toshiba", 75, CRT),
            new Television("LG", 15, LCD)};
    TelevisionDisplayAdvisor.check(tvArray);
    System.out.println("-----");
  }
}