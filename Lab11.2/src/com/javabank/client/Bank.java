/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank.client;

import com.javabank.Account;
import com.javabank.Auditor;
import com.javabank.Teller;

public class Bank {
  public static final Object sharedLock = new Object();

  public static void main(String[] args) {
    Account a1 = new Account("Account-1", 1000);
    Account a2 = new Account("Account-2", 1000);
    Account a3 = new Account("Account-3", 1000);
    
    // create two Teller threads
    Teller t12 = new Teller(a1, a2);
    t12.setName("Teller-1/2");

    Teller t21 = new Teller(a2, a1);
    t21.setName("Teller-2/1");
    
    Teller t13 = new Teller(a1, a3);
    t13.setName("Teller-1/3");

    Teller t31 = new Teller(a3, a1);
    t31.setName("Teller-3/1");
    
    Teller t23 = new Teller(a2, a3);
    t23.setName("Teller-2/3");

    Teller t32 = new Teller(a3, a2);
    t32.setName("Teller-3/2");
    
    // create the Auditor thread
    Auditor auditor = new Auditor(a1, a2, a3);
    auditor.setName("Auditor");
    
    // start everybody up
    auditor.start();
    t12.start();
    t21.start();
    t13.start();
    t31.start();
    t23.start();
    t32.start();
  }
}