package edu.ntnu.iir.bidata;

import java.util.HashSet;
// Todo Add comments to class
public class DiaryInterface {
  private static Diary diary;

  public static void init()
  {
    diary = new Diary();
    System.out.println("Hello, welcome to the diary!");
    System.out.println("To add a paragraph write: Add");
    System.out.println("To print all posts write: All");
    System.out.println("To print a specific post write: Print");
    System.out.println("To remove posts write: Remove");
    System.out.println("To quit write: Quit");
  }

  /**
   * Start function. Starts the program interface.
   */
  public static void start()
  {
    boolean started = true;
    while(started)
    {
      HashSet<String> words = Input.getInputSet();

      for (String w : words) {
        switch (w) {
          case "add" -> {
            System.out.println("Author: ");
            String author = Input.getInput();
            System.out.println("Title: ");
            String title = Input.getInput();
            System.out.println("Text: ");
            String text = Input.getInput();
            diary.addPost(author, title, text);
          }
          case "print" -> {
            System.out.println("Write date of written post");
            String date = Input.getInput();

            if (diary.getAllPosts().contains(diary.getPost(date))) {
              System.out.println("Getting post at date: " + date);
              diary.getPost(date).printPost();
            } else {
              System.out.println("No posts found");
            }
          }
          case "quit" -> started = false;
          case "all" -> diary.getAllPosts().forEach(Post::printPost);

          case "remove" -> {
            System.out.println("Write date of written post");
            String date = Input.getInput();

            if (diary.getPost(date) != null) {
              diary.removePost(date);
            } else {
              System.out.println("No posts found");
            }
          }
        }
      }
    }
  }

}
