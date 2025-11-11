package edu.ntnu.iir.bidata.ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Static class to handle user input.
 *
 *
 * @author jorge
 *
 * @version 1.0
 * @see Scanner
 * @see Arrays
 * @see HashSet
 */
public class Input {
  private static final Scanner inp = new Scanner(System.in);

  private Input() {}

  /**
   * Gets a string of the input.
   *
   *
   * @return Loops function if empty otherwise returns input.
   */
  public static String getInput() {

    System.out.print("> ");
    String in = inp.nextLine();
    return in.isEmpty() ? getInput() : in;
  }

  /**
   * Gets a HashSet of user input. Uses delimiter " ".
   *
   *
   * @return words Returns a HashSet of the input.
   */
  public static Set<String> getInputSet() {
    System.out.print("> ");

    String inputLine = inp.nextLine().trim().toLowerCase();

    String[] wordArray = inputLine.split(" ");

    return new HashSet<>(Arrays.asList(wordArray));
  }
}
