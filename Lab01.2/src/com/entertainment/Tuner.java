/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

import java.util.Objects;

class Tuner {
  private int channel = 3;  // default channel for cable and satellite customers
  
  public int getChannel() {
    return this.channel;
  }
  public void setChannel(int channel) {
    this.channel = channel;
  }

  @Override
  public boolean equals(Object o) {
    boolean areEqual;
    if (this == o) {
      areEqual = true;
    } else if (!(o instanceof Tuner)) {
      areEqual = false;
    } else {
      Tuner that = (Tuner) o;
      if(this.hashCode() != that.hashCode()) {
        areEqual = false;
      } else {
        areEqual = this.getChannel() == that.getChannel();
      }
    }
    return areEqual;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getChannel());
  }
}