/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javabank;

import static com.javabank.client.Bank.sharedLock;

public class Auditor
extends Thread {
  private Account acct1;
  private Account acct2;
  private Account acct3;

  public Auditor(Account acct1, Account acct2, Account acct3) {
    this.acct1 = acct1;
    this.acct2 = acct2;
    this.acct3 = acct3;
  }
  
  @Override
  public void run() {
    while (true) {
      synchronized (sharedLock) {
        displayBalances();
      }
      try {
        Thread.sleep(2000);
      }
      catch (InterruptedException ignored) {
      }
    }
  }
  
  /*
   * Calculate and display the total of the two accounts.
   * Since we're always transferring between the same two accounts, 
   * the total balance in the two should be constant.
   * If it's not, there's something wrong, so we show "****" to indicate that.
   */
  private void displayBalances() {
    int balance1 = acct1.getBalance();
    int balance2 = acct2.getBalance();
    int balance3 = acct3.getBalance();
    
    StringBuffer msg = new StringBuffer("\n");
    if ((balance1 + balance2 + balance3) != 3000) {  // balance total incorrect?
      msg.append("**** Total = ");
    }
    else {
      msg.append("     Total = ");
    }
    msg.append(balance1 + balance2 + balance3);
    msg.append(" = (" + acct1.getName() + ") " + balance1);
    msg.append(" + (" + acct2.getName() + ") " + balance2);
    msg.append(" + (" + acct3.getName() + ") " + balance3);
    msg.append("\n");
    System.out.println(msg);
  }
}