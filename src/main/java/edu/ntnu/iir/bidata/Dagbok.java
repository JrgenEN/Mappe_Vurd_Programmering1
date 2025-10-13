package edu.ntnu.iir.bidata;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author jorge
 * @version 0.1.1
 * @since 0.1
 * @see Input
 * @see Posts
 */
public class Dagbok
{
  private final HashMap<String,Posts> posts;

  public Dagbok()
  {
    this.posts = new HashMap<>();
  }

  /**
   * Start function. Starts the program interface.
   */
  public void start()
  {
    boolean started = true;
    System.out.println("Hello, welcome to the diary!");
    System.out.println("To add a paragraph write: Add");
    System.out.println("To print all posts write: All");
    System.out.println("To print a specific post write: Print");
    System.out.println("To remove posts write: Remove");
    System.out.println("To quit write: Quit");
    while(started)
    {
      HashSet<String> words = Input.getInputSet();

      for (String w : words) {
        switch (w) {
          case "add" -> this.addPosts();
          case "print" -> {
            System.out.println("Write date of written post");
            String date = Input.getInput();

            if (this.getPosts(date) != null) {
              this.getPosts(date).printPosts();
            } else {
              System.out.println("No posts found");
            }
          }
          case "quit" -> started = false;
          case "all" -> this.printAll();
          case "remove" -> {
            System.out.println("Write date of written post");
            String date = Input.getInput();

            if (this.getPosts(date) != null) {
              this.removePosts(date);
            } else {
              System.out.println("No posts found");
            }
          }
        }
      }
    }
  }

  /**
   * Add a post to the diary
   */
  private void addPosts()
  {
    System.out.println("What is your name?");
    String author = Input.getInput();
    System.out.println("Add title: ");
    String title = Input.getInput();
    System.out.println("Add description: ");
    String description = Input.getInput();
    Posts post = new Posts(author,title,description);
    if(this.posts.containsKey(post.getDate()))
    {
      System.out.println("You have already written a post today\n" +
          "Remove the post on this date before adding new");
    }
    else
    {
      posts.put(post.getDate(),post);
    }
    this.posts.put(post.getDate(), post);
    System.out.flush();
  }
  public void addPost(String author, String title, String desc, String date){
    Posts post = new Posts(author, title, desc, date);
    posts.put(post.getDate(), post);
  }

  /**
   * Gets a post from the diary
   * @param date When the post was written
   * @return the post at the specific day
   */
  private Posts getPosts(String date)
  {
    return this.posts.get(date);
  }

  /**
   * Prints all posts from newest to oldest
   */
  private void printAll()
  {
    for (Posts p : this.posts.values())
    {
      p.printPosts();
      System.out.println();
    }
  }

  /**
   * Removes posts from diary, need a date
   * @param date When the post was created
   */
  private void removePosts(String date)
  {
    this.posts.remove(date);
  }

}
