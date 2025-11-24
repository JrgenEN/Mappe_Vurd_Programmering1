package edu.ntnu.iir.bidata;

import edu.ntnu.iir.bidata.ui.DiaryInterface;
import edu.ntnu.iir.bidata.utility.FileSave;

/**
 * The main starting point of your application. Let this class create the
 * instance of your main class that starts your application.
 */

public class Main {
  /**
   * Main class for the program.
   *
   *
   * @param args Arguments
   */
  public static void main(String[] args) {
    FileSave.init();
    DiaryInterface.init();
    DiaryInterface.start();
  }
}