package edu.ntnu.iir.bidata.ui;

import static edu.ntnu.iir.bidata.utility.Constants.*;
import static edu.ntnu.iir.bidata.utility.Constants.USE_FORMAT;

/**
 * Class to handle display.
 */
public class Display {
  private Display() {}

  /**
   *
   *
   */
  public static void commands() {
    System.out.println("Commands:");
    System.out.println("Add \t\t To add a paragraph.");
    System.out.println("All \t\t To print all posts.");
    System.out.println("Forgot \t\t To add posts for forgotten days.");
    System.out.println("Print \t\t To print a specific post.");
    System.out.println("Date \t\t To print a date range of posts.");
    System.out.println("Author \t\t To print all post by author.");
    System.out.println("Keyword \t To find a post with a keyword.");
    System.out.println("Remove \t\t To remove posts.");
    System.out.println("Stats \t\t To get statistics of authors write.");
    System.out.println("To quit write: Quit");
  }

  /**
   *
   */
  public static void message(String message) {
    System.out.println(message);
  }

  /**
   *
   */
  public static void author() {
    System.out.println(AUTHOR);
  }

  /**
   *
   */
  public static void noAuthorFound() {
    System.out.println(NO_AUTHOR_FOUND);
  }

  /**
   *
   */
  public static void writeDateAndFormat() {
    System.out.println(WRITE_DATE_OF_WRITTEN_POST + "\n" + USE_FORMAT);
  }

  /**
   *
   */
  public static void noPostFound() {
    System.out.println(NO_POST_FOUND);
  }
  /**
   *
   */
  public static void newLine() {
    System.out.println();
  }

  /**
   *
   */
  public static void toCheckAllWriteNone() {
    System.out.println(TO_CHECK_ALL_WRITE + NONE);
  }

  /**
   *
   */
  public static void keywordToFind() {
    System.out.println(KEYWORD_TO_FIND);
  }

  /**
   *
   */
  public static void useFormat() {
    System.out.println(USE_FORMAT);
  }

  /**
   *
   */
  public static void previousAuthors() {
    System.out.println(PREVIOUS_AUTHORS);
  }

  /**
   *
   */
  public static void text() {
    System.out.println(TEXT);
  }

  /**
   *
   */
  public static void title() {
    System.out.println(TITLE);
  }
}
