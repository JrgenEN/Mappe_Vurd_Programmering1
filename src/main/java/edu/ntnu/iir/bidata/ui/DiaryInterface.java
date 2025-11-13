package edu.ntnu.iir.bidata.ui;

import edu.ntnu.iir.bidata.diary.Author;
import edu.ntnu.iir.bidata.diary.AuthorRegister;
import edu.ntnu.iir.bidata.diary.Diary;
import edu.ntnu.iir.bidata.diary.Post;
import edu.ntnu.iir.bidata.diary.Time;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


/**
 * Diary interface.
 *
 * @author jorge
 * @version 2.0
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
  private static AuthorRegister authorRegister;
  private static final String AUTHOR = "Author: ";
  private static final String TEXT = "Text: ";
  private static final String TITLE = "Title: ";
  private static final String NO_POST_FOUND = "No post found";
  private static final String NONE = "None";
  private static final String USE_FORMAT = "Use format dd.mm.yyyy";
  private static final String NO_AUTHOR_FOUND = "No author found!";
  private static final String WRITE_DATE_OF_WRITTEN_POST = "Write date of written post";
  private static final String PREVIOUS_AUTHORS = "Previous authors: ";
  private static final String KEYWORD_TO_FIND = "Type a keyword to find in posts: ";
  private static final String TO_CHECK_ALL_WRITE = "To check all write: ";

  /**
   * Initialize the Interface.
   */
  private DiaryInterface() {
  }

  /**
   * Initializing the interface class.
   */
  public static void init() {
    authorRegister = new AuthorRegister();
    System.out.println("Hello, welcome to the diary!");
    commands();
  }

  /**
   * Commands for the interface.
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
    System.out.println("For help, type: Help");
    System.out.println("To quit write: Quit");
  }

  /**
   * Start a function. Starts the program interface.
   */
  public static void start() {
    boolean started = true;

    while (started) {
      Set<String> words = Input.getInputSet();

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
          case "help":
            commands();
            break;
          case "quit":
            started = false;
            break;
          default:
            System.out.println("Invalid option.");
        }
      }
    }
  }

  /**
   * Function to handle prints of posts.
   */
  private static void print() {
    System.out.println(AUTHOR);
    previousAuthors();
    final String author = Author.formatName(Input.getInput());

    if (authorRegister.getDiary(author) != null) {
      System.out.println(WRITE_DATE_OF_WRITTEN_POST + "\n" + USE_FORMAT);
      String date = Input.getInput();
      System.out.println();
      if (authorRegister.getDiary(author).getPost(date) != null) {
        printPost(authorRegister.getDiary(author).getPost(date));
      } else {
        System.out.println(NO_POST_FOUND);
      }
    } else {
      System.out.println(NO_AUTHOR_FOUND);
    }
    System.out.println();
  }


  /**
   * Function to handle removing of posts.
   */
  private static void remove() {
    System.out.println(AUTHOR);
    final String author = Author.formatName(Input.getInput());

    if (authorRegister.getDiary(author) != null) {
      System.out.println(WRITE_DATE_OF_WRITTEN_POST + "\n" + USE_FORMAT);
      String date = Input.getInput();

      if (!authorRegister.getDiary(author).removePost(date)) {
        System.out.println(NO_POST_FOUND);
      }
    } else {
      System.out.println(NO_AUTHOR_FOUND);
    }
  }

  /**
   * Function to handle printing of all posts.
   */
  private static void all() {
    authorRegister.getAllDiary().forEach(diary -> {
      System.out.println();
      diary.getAllPosts().forEach(post -> {
        printPost(post);
        System.out.println();
      });
    });
  }

  /**
   * Searches for keywords in all posts and prints them.
   */
  private static void keyword() {
    System.out.println(TO_CHECK_ALL_WRITE + NONE);
    System.out.println(AUTHOR);
    final String author = Author.formatName(Input.getInput());
    if (!author.equals(NONE)) {
      if (authorRegister.getDiary(author) != null) {
        System.out.println(KEYWORD_TO_FIND);
        String keyword = Input.getInput();

        printPost(authorRegister.getDiary(author).getPostByKeyWord(keyword));
      }
    } else {
      System.out.println(KEYWORD_TO_FIND);
      String keyword = Input.getInput();

      authorRegister.getAllDiary().forEach(diary -> {
        Post foundPosts = diary.getPostByKeyWord(keyword);
        if (foundPosts != null) {
          System.out.println();
          printPost(foundPosts);
        }
      });
    }

  }

  /**
   * Gets the post in a date interval.
   */
  private static void date() {
    System.out.println(TO_CHECK_ALL_WRITE + NONE);
    System.out.println(AUTHOR);
    final String author = Author.formatName(Input.getInput());
    System.out.println(USE_FORMAT);
    System.out.println("Type start date: ");
    String startDate = Input.getInput();
    System.out.println("Type end date: ");
    String endDate = Input.getInput();
    String time = new Time().getClock();
    Time start = new Time(time, startDate);
    Time end = new Time(time, endDate);
    if (!author.equals(NONE)) {
      authorRegister.getDiary(author).getPostBetweenDates(start, end)
              .forEach(post -> {
                System.out.println();
                if (post != null) {
                  System.out.println();
                  printPost(post);
                }
              }
      );
    } else {
      authorRegister.getAllDiary().forEach(diary ->
                diary.getPostBetweenDates(start, end).forEach(post -> {
                  if (post != null) {
                    System.out.println();
                    printPost(post);
                  }
                })
      );
    }
  }

  /**
   * Function to handle adding of posts to the diary's.
   */
  private static void add() {
    previousAuthors();
    System.out.println(AUTHOR);
    final String author = Input.getInput();
    System.out.println(TITLE);
    final String title = Input.getInput();
    System.out.println(TEXT);
    final String text = Input.getInput();
    if (authorRegister.addDiaryPost(new Post(author, title, text))) {
      System.out.println("Post added successfully!");
    }
  }

  /**
   * Function to handle forgotten dates.
   * Adds a post on a specified day, month and year.
   */
  private static void forgot() {
    previousAuthors();
    System.out.println(AUTHOR);
    final String author = Author.formatName(Input.getInput());
    System.out.println(TITLE);
    final String title = Input.getInput();
    System.out.println(TEXT);
    final String text = Input.getInput();
    System.out.println("Forgotten Date\n" + USE_FORMAT);
    String date = Input.getInput();
    String time = new Time().getClock();
    if (authorRegister.addDiaryPost(new Post(author, title, text, time, date))) {
      System.out.println("Post added successfully!");
    }
  }

  /**
   * Gets the posts by a specific author.
   */
  private static void postByAuthor() {
    previousAuthors();
    System.out.println(AUTHOR);
    final String author = Author.formatName(Input.getInput());
    if (authorRegister.getAuthorsName().contains(author)) {
      System.out.println();
      authorRegister.getDiary(author).getAllPosts().forEach(post -> {
        printPost(post);
        System.out.println();
      });

    } else {
      System.out.println(NO_POST_FOUND);
    }
  }

  /**
   * Gets the statistics of the posts by authors.
   */
  private static void stats() {
    Map<String, Integer> statistics = authorRegister.getStatistics();

    String[] names = statistics.keySet().toArray(new String[0]);
    Arrays.sort(names);
    for (String name : names) {
      int expected = statistics.get(name);
      System.out.println(name + " : " + expected + " post's");
    }
  }

  /**
   * Gets all the previous authors.
   */
  private static void previousAuthors() {
    if (!authorRegister.getAuthorsName().isEmpty()) {
      System.out.println(PREVIOUS_AUTHORS);
      authorRegister.getAuthorsName().forEach(System.out::println);
    }
  }

  /**
   * Print a post.
   */
  private static void printPost(Post post) {
    System.out.println(post.toString());
  }
}

