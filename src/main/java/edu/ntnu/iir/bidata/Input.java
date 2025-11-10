package edu.ntnu.iir.bidata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

/**
 * Static class to handle user inp.
 *
 *
 * @author jorge
 *
 * @version 1.0
 * @see Scanner
 * @see Arrays
 * @see HashSet
 * @see Set
 */
public class Input {
  private static final Scanner inp = new Scanner(System.in);

  private Input(){}

  /**
   * Gets a string of the input.
   *
   *
   * @return in calls getInput to loop or returns in
   */
  public static String getInput() {
    System.out.print("> ");
    String in = inp.nextLine();
    return in.isEmpty() ? getInput() : in;
  }

  /**
   * Gets a HashSet of user inp. Uses delimiter " ".
   *
   *
   * @return words Returns a HashSet of the inp.
   */
  public static Set<String> getInputSet() {
    System.out.print("> ");

    String inpLine = inp.nextLine().trim().toLowerCase();

    String[] wordArray = inpLine.split(" ");

    return new HashSet<>(Arrays.asList(wordArray));
  }
}
