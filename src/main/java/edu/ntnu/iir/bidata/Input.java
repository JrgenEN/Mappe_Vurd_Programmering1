package edu.ntnu.iir.bidata;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

/**
 * Static class for user input.
 *
 */
public class Input {
  private static Scanner input = new Scanner(System.in);

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
    HashSet<String> words = new HashSet<>();
    words.addAll(Arrays.asList(wordArray));

    return words;
  }
}
