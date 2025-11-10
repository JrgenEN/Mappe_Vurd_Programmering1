package edu.ntnu.iir.bidata.ui;

import edu.ntnu.iir.bidata.diary.AuthorRegister;
import edu.ntnu.iir.bidata.diary.Diary;
import edu.ntnu.iir.bidata.diary.Time;
import edu.ntnu.iir.bidata.diary.Post;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Diary interface.
 *
 * @author jorge
 * @version 1.0
 * @see Diary
 * @see HashSet
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

  /**
   * Initialize the Interface.
   */
  private DiaryInterface() {
  }

  public static void init() {
    authorRegister = new AuthorRegister();
    System.out.println("Hello, welcome to the diary!");
    commands();
  }

  public static void commands(){
    System.out.println("To add a paragraph write: Add");
    System.out.println("To print all posts write: All");
    System.out.println("To print a specific post write: Print");
    System.out.println("To print a date range of posts write: Date");
    System.out.println("To print all post by author write: Author");
    System.out.println("To find a post with a keyword write: keyword");
    System.out.println("To remove posts write: Remove");
    System.out.println("To add posts for forgotten days write: Forgot");
    System.out.println("For help, type: Help");
    System.out.println("To quit write: Quit");
  }
  /**
   * Start function. Starts the program interface.
   */
  public static void start() {
    boolean started = true;

    while (started) {
      Set<String> words = Input.getInputSet();

      for (String w : words) {
        switch (w) {
          case "add" -> add();
          case "print" -> print();
          case "all" -> all();
          case "keyword" -> keyword();
          case "remove" -> remove();
          case "forgot" -> forgot();
          case "date" -> date();
          case "author" -> postByAuthor();
          case "help" -> commands();
          case "quit" -> started = false;
          default -> System.out.println("Invalid option.");
        }
      }
    }
  }

  /**
   * Function to handle prints of posts.
   */
  private static void print() {
    System.out.println(AUTHOR);
    String author = Input.getInput();

    if (authorRegister.getDiary(author) != null)
    {
      System.out.println("Write date of written post\nUse format dd.mm.yyyy");
      String date = Input.getInput();

      if (authorRegister.getDiary(author).getPost(date) != null)
      {
        authorRegister.getDiary(author).getPost(date).printPost();
      } else {
        System.out.println(NO_POST_FOUND);
      }
    } else {
      System.out.println("No author found!");
    }
  }


  /**
   * Function to handle removing of posts.
   */
  private static void remove() {
    System.out.println(AUTHOR);
    String author = Input.getInput();

    if (authorRegister.getDiary(author) != null)
    {
      System.out.println("Write date of written post\nUse format dd.mm.yyyy");
      String date = Input.getInput();

      if (authorRegister.getDiary(author).getPost(date) != null)
      {
        authorRegister.getDiary(author).removePost(date);
      } else {
        System.out.println(DiaryInterface.NO_POST_FOUND);
      }
    } else {
      System.out.println("No author found!");
    }
  }

  /**
   * Function to handle printing of all posts.
   */
  private static void all() {
    authorRegister.getAllDiary().forEach(diary -> {
      System.out.println();
      diary.getAllPosts().forEach(post -> {
        post.printPost();
        System.out.println();
      });
    });
  }

  /**
   * Searches for keywords in all posts and prints them.
   */
  private static void keyword()
  {
    System.out.println("To check all write: None");
    System.out.println(AUTHOR);
    String author = Input.getInput();
    if (!author.equals("none")) {
      if (authorRegister.getDiary(author) != null) {
        System.out.println("Type a keyword to find in posts: ");
        String keyword = Input.getInput();

        authorRegister.getDiary(author).getPostByKeyWord(keyword).printPost();
      }
    } else {
      System.out.println("Type a keyword to find in posts: ");
      String keyword = Input.getInput();

      authorRegister.getAllDiary().forEach(diary -> {
        if (diary.getPostByKeyWord(keyword) != null){
          System.out.println();
          diary.getPostByKeyWord(keyword).printPost();
        }
      });
    }

  }

  /**
   * Gets the post in a date interval.
   */
  private static void date(){
    System.out.println("To check all write: None");
    System.out.println(AUTHOR);
    String author = Input.getInput();
    if (!author.equals("none")) {
      System.out.println("Use format dd.mm.yyyy");
      System.out.println("Type start date: ");
      String startDate = Input.getInput();
      System.out.println("Type end date: ");
      String endDate = Input.getInput();
      String time = new Time().getClock();
      authorRegister.getDiary(author).getPostBetweenDates(new Time(time, startDate), new Time(time, endDate)).
              forEach(post -> {
                System.out.println();
                if (post == null) {
                  // Do nothing if post is null.
                } else {
                  System.out.println();
                  post.printPost();
                }
              }
      );
    } else {
      System.out.println("Use format dd.mm.yyyy");
      System.out.println("Type start date: ");
      String startDate = Input.getInput();
      System.out.println("Type end date: ");
      String endDate = Input.getInput();
      String time = new Time().getClock();
      authorRegister.getAllDiary().
              forEach(diary -> {
        diary.getPostBetweenDates(new Time(time, startDate), new Time(time, endDate)).
                forEach(post -> {

                  if (post == null) {
                    // Do nothing if post is null.
                  } else {
                    System.out.println();
                    post.printPost();
                  }
        });
      });
    }
  }

  /**
   * Function to handle adding of posts to the diary's.
   */
  private static void add() {
    if (!authorRegister.getAuthors().isEmpty()){
      authorRegister.getAuthors().forEach(author -> {
        System.out.println("Previous authors: ");
        System.out.println(author);
      });
    }
    System.out.println(AUTHOR);
    String author = Input.getInput();
    System.out.println(TITLE);
    String title = Input.getInput();
    System.out.println(TEXT);
    String text = Input.getInput();
    authorRegister.addDiaryPost(new Post(author, title, text));
  }

  /**
   * Function to handle forgotten dates.
   * Adds a post on a specified day, month & year.
   */
  private static void forgot() {
    if (!authorRegister.getAuthors().isEmpty()){
      authorRegister.getAuthors().forEach(author -> {
        System.out.println("Previous authors: ");
        System.out.println(author);
      });
    }
    System.out.println(AUTHOR);
    final String author = Input.getInput();
    System.out.println(TITLE);
    final String title = Input.getInput();
    System.out.println(TEXT);
    final String text = Input.getInput();
    System.out.println("Forgotten Date\nUse format dd.mm.yyyy");
    String date = Input.getInput();
    String time = new Time().getClock();
    authorRegister.addDiaryPost(new Post(author, title, text, time, date));
  }

  /**
   * Gets the posts by a specific author.
   */
  private static void postByAuthor() {
    System.out.println(AUTHOR);
    String author = Input.getInput();
    if(authorRegister.getAuthors().contains(author))
    {
      System.out.println();
      authorRegister.getDiary(author).getAllPosts().forEach(post -> {
        post.printPost();
        System.out.println();
      });

    }
    else  {
      System.out.println(NO_POST_FOUND);
    }
  }
}

