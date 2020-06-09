/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public interface Volume {
  static void silenceAll(Volume ... vols) {
    for(Volume vol : vols) {
      vol.silence();
    }
  }

  public void setVolume(int volume);
  public int getVolume();
  public void mute();
  default void silence() {
    setVolume(0);
  }
  public boolean isMuted();
}