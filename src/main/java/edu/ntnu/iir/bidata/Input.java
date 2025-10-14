package edu.ntnu.iir.bidata;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

/**
 * Static class to handle user input
 * @author jorge
 * @version 1.0
 * @see Scanner
 * @see Arrays
 * @see HashSet
 */
public class Input {
  private final static Scanner input = new Scanner(System.in);

  /**
   * Gets a string of the input
   * @return in calls getInput to loop or returns in
   */
  public static String getInput()
  {
    System.out.print("> ");
    String in = input.nextLine();
    return in.isEmpty() ? getInput() : in;
  }

  /**
   * Gets a HashSet of user input. Uses delimiter " "
   * @return words Returns a HashSet of the input.
   */
  public static HashSet<String> getInputSet(){
    System.out.print("> ");

    String inputLine = input.nextLine().trim().toLowerCase();

    String[] wordArray = inputLine.split(" ");

    return new HashSet<>(Arrays.asList(wordArray));
  }
}
