package edu.ntnu.iir.bidata;

import java.util.HashSet;

/**
 * Diary interface.
 *
 *
 * @author jorge
 *
 * @version 1.0
 * @since 1.0
 * @see Diary
 * @see HashSet
 * @see Input
 */
public class DiaryInterface {
  private static Diary diary;

  /**
   * Initialize the Interface.
   */
  public static void init() {
    diary = new Diary();
    System.out.println("Hello, welcome to the diary!");
    System.out.println("To add a paragraph write: Add");
    System.out.println("To print all posts write: All");
    System.out.println("To print a specific post write: Print");
    System.out.println("To remove posts write: Remove");
    System.out.println("To add posts for forgotten days write: Forgot");
    System.out.println("To quit write: Quit");
  }

  /**
   * Start function. Starts the program interface.
   */
  public static void start() {
    boolean started = true;

    while (started) {
      HashSet<String> words = Input.getInputSet();
      for (String w : words) {
        switch (w) {
          case "add" -> add();
          case "print" -> print();
          case "all" -> all();
          case "remove" -> remove();
          case "forgot" -> forgot();
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
    System.out.println("Write date of written post\nUse format dd.mm.yyyy");
    String date = Input.getInput();

    if (diary.getAllPosts().contains(diary.getPost(date))) {
      System.out.println("Getting post at date: " + date);
      diary.getPost(date).printPost();
    } else {
      System.out.println("No posts found");
    }
  }

  /**
   * Function to handle removing of posts.
   */
  private static void remove() {
    System.out.println("Write date of written post\nUse format dd.mm.yyyy");
    String date = Input.getInput();

    if (diary.getPost(date) != null) {
      diary.removePost(date);
    } else {
      System.out.println("No posts found");
    }
  }

  /**
   * Function to handle printing of all posts.
   */
  private static void all() {
    diary.getAllPosts().forEach((post -> {
      post.printPost();
      System.out.println();
    }));
  }

  /**
   * Function to handle adding of posts to the diary.
   */
  private static void add() {
    System.out.println("Author: ");
    String author = Input.getInput();
    System.out.println("Title: ");
    String title = Input.getInput();
    System.out.println("Text: ");
    String text = Input.getInput();
    diary.addPost(author, title, text);
  }

  /**
   * Function to handle forgotten dates.
   * Adds a post on a specified day, month & year.
   */
  private static void forgot() {
    System.out.println("Author: ");
    final String author = Input.getInput();
    System.out.println("Title: ");
    final String title = Input.getInput();
    System.out.println("Text: ");
    final String text = Input.getInput();
    System.out.println("Forgotten Date\nUse format dd.mm.yyyy");
    String date = Input.getInput();
    String time = new Time().getClock();
    diary.addPost(author, title, text, time, date);
  }
}
