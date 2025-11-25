package edu.ntnu.iir.bidata.ui;

import static edu.ntnu.iir.bidata.utility.Constants.AUTHOR;
import static edu.ntnu.iir.bidata.utility.Constants.KEYWORD_TO_FIND;
import static edu.ntnu.iir.bidata.utility.Constants.NONE;
import static edu.ntnu.iir.bidata.utility.Constants.NO_POST_FOUND;
import static edu.ntnu.iir.bidata.utility.Constants.PREVIOUS_AUTHORS;
import static edu.ntnu.iir.bidata.utility.Constants.TEXT;
import static edu.ntnu.iir.bidata.utility.Constants.TITLE;
import static edu.ntnu.iir.bidata.utility.Constants.TO_CHECK_ALL_WRITE;
import static edu.ntnu.iir.bidata.utility.Constants.USE_FORMAT;
import static edu.ntnu.iir.bidata.utility.Constants.WRITE_DATE_OF_WRITTEN_POST;

/**
 * Class to handle text output and output of literals.
 *
 * <p>Dependencies: {@link edu.ntnu.iir.bidata.utility.Constants}.
 *
 * </p>
 *
 * @author jorge
 * @version 1.0
 * @see edu.ntnu.iir.bidata.utility.Constants
 * @since 1.0
 */
public class Display {
  private Display() {}

  /**
   * Command list.
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
   * Wrapper for System.out.println.
   */
  public static void message(String message) {
    System.out.println(message);
  }

  /**
   * Wrapper for System.out.print.
   */
  public static void msgNoln(String message) {
    System.out.print(message);
  }

  /**
   * Prints literal constant AUTHOR.
   */
  public static void author() {
    System.out.println(AUTHOR);
  }

  /**
   * Prints literal constant WRITE_DATE_OF_WRITTEN_POST.
   * And prints literal constant USE_FORMAT.
   */
  public static void writeDateAndFormat() {
    System.out.println(WRITE_DATE_OF_WRITTEN_POST);
    Display.useFormat();
  }

  /**
   * Prints literal constant NO_POST_FOUND.
   */
  public static void noPostFound() {
    System.out.println(NO_POST_FOUND);
  }

  /**
   * Prints new line.
   */
  public static void newLine() {
    System.out.println();
  }

  /**
   * Prints literal constant TO_CHECK_ALL_WRITE.
   */
  public static void toCheckAllWriteNone() {
    System.out.println(TO_CHECK_ALL_WRITE + NONE);
  }

  /**
   * Prints literal constant KEYWORD_TO_FIND.
   */
  public static void keywordToFind() {
    System.out.println(KEYWORD_TO_FIND);
  }

  /**
   * Prints literal constant USE_FORMAT.
   */
  public static void useFormat() {
    System.out.println(USE_FORMAT);
  }

  /**
   * Prints literal constant PREVIOUS_AUTHORS.
   */
  public static void previousAuthors() {
    System.out.println(PREVIOUS_AUTHORS);
  }

  /**
   * Prints literal constant TEXT.
   */
  public static void text() {
    System.out.println(TEXT);
  }

  /**
   * Prints literal constant TITLE.
   */
  public static void title() {
    System.out.println(TITLE);
  }
}
