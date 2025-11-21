package edu.ntnu.iir.bidata.ui;

import static edu.ntnu.iir.bidata.utility.Constants.NONE;

import edu.ntnu.iir.bidata.diary.entry.Author;
import edu.ntnu.iir.bidata.diary.entry.Post;
import edu.ntnu.iir.bidata.diary.registers.AuthorRegister;
import edu.ntnu.iir.bidata.diary.registers.Diary;
import edu.ntnu.iir.bidata.utility.Time;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Diary interface. Creates the interface and handles user input.
 *
 * @author jorge
 * @version 3.0
 * @see Diary
 * @see Set
 * @see Arrays
 * @see Map
 * @see Input
 * @see AuthorRegister
 *
 * @since 1.0
 */
public class DiaryInterface {
  private static AuthorRegister register;

  /**
   * Initialize the Interface.
   */
  private DiaryInterface() {}

  /**
   * Initializing the register class.
   */
  public static void init() {
    register = new AuthorRegister();
    Display.message("Hello, welcome to the diary!");
  }

  /**
   * Start a function. Starts the program interface.
   */
  public static void start() {
    boolean started = true;


    while (started) { // Main program loop.
      try {
        Thread.sleep(1000); // Delay for 1 second.
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // restore interrupt status
      }

      Display.commands();
      Set<String> words = Input.getInputSet(); // Get user input.

      // Checks the user input set.
      for (String word : words) {
        switch (word) {
          case "add":
            add();
            break;
          case "print":
            print();
            break;
          case "all":
            all();
            break;
          case "keyword":
            keyword();
            break;
          case "remove":
            remove();
            break;
          case "forgot":
            forgot();
            break;
          case "date":
            date();
            break;
          case "author":
            postByAuthor();
            break;
          case "stats":
            stats();
            break;
          case "quit":
            started = false;
            break;
          default:
            Display.message("Invalid option.");
        }
      }
    }
  }

  /**
   * Function to handle prints of posts.
   */
  private static void print() {
    Display.author();
    previousAuthors();
    try {
      final String author = Author.formatName(Input.getInput());
      Display.newLine();
      printPreviousDates(author);
      Diary diary = register.getDiary(author);
      Display.writeDateAndFormat();
      String date = Input.getInput();
      Display.newLine();
      Post post = diary.getPost(date);
      printPost(post);
      Display.newLine();
    } catch (Exception e) {
      if (e.getMessage().contains("No diary")) {
        Display.message(e.getMessage());
        Display.newLine();
      } else {
        Display.message(e.getMessage() + ". Use previous dates");
        Display.newLine();
      }
    }
  }


  /**
   * Function to handle removing of posts.
   */
  private static void remove() {
    Display.newLine();
    previousAuthors();
    Display.author();
    final String author = Author.formatName(Input.getInput());
    try {
      final Diary diary = register.getDiary(author);
      Display.newLine();
      printPreviousDates(author);
      Display.writeDateAndFormat();
      String date = Input.getInput();
      Display.newLine();
      if (!diary.removePost(date)) {
        Display.noPostFound();
      } else {
        Display.message("Post removed successfully!");
      }
    } catch (Exception e) {
      Display.message("Failed to remove post: " + e.getMessage());
    } finally {
      Display.newLine();
    }
  }

  /**
   * Function to handle printing of all posts.
   */
  private static void all() {
    register.getAllDiary().forEach(diary -> {
      Display.newLine();
      diary.getAllPosts().forEach(post -> {
        printPost(post);
        Display.newLine();
      });
    });
  }

  /**
   * Searches for keywords in all or authors posts and prints them.
   */
  private static void keyword() {
    Display.newLine();
    previousAuthors();
    Display.toCheckAllWriteNone();
    Display.author();
    final String a = Author.formatName(Input.getInput());
    Display.newLine();
    boolean n = !a.equals(NONE);
    try {
      Collection<Diary> d = n ? List.of(register.getDiary(a)) : register.getAllDiary();

      Display.keywordToFind();
      String keyword = Input.getInput();

      d.forEach(diary -> {
        Post foundPosts = diary.getPostByKeyWord(keyword);
        if (foundPosts != null) {
          Display.newLine();
          printPost(foundPosts);
        }
      });
    } catch (Exception e) {
      Display.newLine();
      Display.message(e.getMessage());
    } finally {
      Display.newLine();
    }
  }

  /**
   * Gets the post in a date interval.
   */
  private static void date() {
    Display.newLine();
    previousAuthors();
    Display.toCheckAllWriteNone();
    Display.author();
    final String a = Author.formatName(Input.getInput());
    boolean n = !a.equals(NONE);


    try {
      final Collection<Diary> d = n ? List.of(register.getDiary(a)) : register.getAllDiary();
      Display.newLine();

      printPreviousDates(a);
      Display.useFormat();
      Display.message("Type start date: ");
      String startDate = Input.getInput();

      Display.message("Type end date: ");
      String endDate = Input.getInput();

      String time = new Time().getClock();
      Time start = new Time(time, startDate);
      Time end = new Time(time, endDate);
      d.forEach(diary ->
          diary.getPostBetweenDates(start, end).forEach(post -> {
            if (post != null) {
              Display.newLine();
              printPost(post);
            }
          })
      );
    } catch (Exception e) {
      Display.newLine();
      Display.message("Failed to get posts: " + e.getMessage());
    } finally {
      Display.newLine();
    }

  }

  /**
   * Function to handle adding of posts to the diary's.
   */
  private static void add() {
    Display.newLine();
    previousAuthors();
    Display.author();
    final String author = Input.getInput();
    Display.newLine();

    Display.title();
    final String title = Input.getInput();
    Display.newLine();

    Display.text();
    final String text = Input.getInput();
    Display.newLine();

    try {
      if (register.addDiaryPost(new Post(author, title, text))) {
        Display.message("Post added successfully!");
      } else {
        Display.message("Failed to add post, only one post per day is allowed.");
        Display.message("Use forgot to add a post on a different day.");
      }
    } catch (Exception e) {
      Display.message("Failed to add post: " + e.getMessage());
    } finally {
      Display.newLine();
    }
  }


  /**
   * Function to handle forgotten dates.
   * It enables the user to add a post on a different day, then today.
   */
  private static void forgot() {
    Display.newLine();
    previousAuthors();
    Display.author();
    final String author = Author.formatName(Input.getInput());
    Display.newLine();

    Display.title();
    final String title = Input.getInput();
    Display.newLine();

    Display.text();
    final String text = Input.getInput();
    Display.newLine();

    Display.message("Forgotten Date");
    Display.useFormat();
    try {
      printPreviousDates(author);
      String date = Input.getInput();
      String time = new Time().getClock();
      if (register.addDiaryPost(new Post(author, title, text, time, date))) {
        Display.message("Post added successfully!");
      } else {
        Display.message("Failed to add post.");
      }
    } catch (Exception e) {
      Display.message("Failed to add post: " + e.getMessage());
    } finally {
      Display.newLine();
    }
  }

  /**
   * Gets the diary of an author and prints all posts.
   * If no posts. it prints no posts found.
   */
  private static void postByAuthor() {
    Display.newLine();
    previousAuthors();
    Display.author();
    final String author = Author.formatName(Input.getInput());
    Display.newLine();

    if (register.getAuthorsName().contains(author)) {
      Display.newLine();
      register.getDiary(author).getAllPosts().forEach(post -> {
        printPost(post);
        Display.newLine();
      });

    } else {
      Display.noPostFound();
    }
  }

  /**
   * Gets the statistics of the posts by authors.
   */
  private static void stats() {
    Map<String, Integer> statistics = register.getStatistics();

    String[] names = statistics.keySet().toArray(new String[0]);
    Arrays.sort(names);
    for (String name : names) {
      int expected = statistics.get(name);
      Display.message(name + " : " + expected + " post's");
    }
  }

  /**
   * Prints all the previous authors that have made posts.
   */
  private static void previousAuthors() {
    if (!register.getAuthorsName().isEmpty()) {
      Display.previousAuthors();
      register.getAuthorsName().forEach(System.out::println);
    }
  }

  private static void printPreviousDates(String name) {

    try {
      Diary diary = register.getDiary(name);
      Display.message("Previous dates: ");

      diary.getAllDates().forEach(date ->
          System.out.print(date + " ")
      );
    } catch (Exception e) {
      System.out.print(" ");
    } finally {
      Display.newLine();
    }
  }

  /**
   * Print a post.
   */
  private static void printPost(Post post) {
    Display.message(post.toString());
  }
}