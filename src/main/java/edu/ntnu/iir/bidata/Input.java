package edu.ntnu.iir.bidata;

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;

public class Input {
  private static Scanner input = new Scanner(System.in);

  public static String getInput()
  {
    System.out.print("> ");
    return input.nextLine();
  }
  public static HashSet<String> getInputSet(){
    System.out.print("> ");
    String inputLine = input.nextLine().trim().toLowerCase();
    String[] wordArray = inputLine.split(" ");
    HashSet<String> words = new HashSet<>();
    words.addAll(Arrays.asList(wordArray));

    return words;
  }
}
