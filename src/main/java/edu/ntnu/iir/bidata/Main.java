package edu.ntnu.iir.bidata;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 */

public class Main {
  /**
   * Main class for the program.
   *
   *
   * @param args Arguments
   */
  public static void main(String[] args) {
    DiaryInterface.init();
    DiaryInterface.start();
  }
}