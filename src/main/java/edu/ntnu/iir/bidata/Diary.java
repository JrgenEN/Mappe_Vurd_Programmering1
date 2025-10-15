package edu.ntnu.iir.bidata;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Class to make a diary with an HashMap of Posts.
 *
 *
 * @author jorge
 *
 * @version 1.0
 * @see Post
 * @see HashMap
 * @see Collection
 * @see List
 */
public class Diary {
  private final HashMap<String, Post> posts;

  /**
   * Constructor For diary. Initializing posts to a new HashMap.
   */
  public Diary() {
    this.posts = new HashMap<>();
  }

  /**
   * Add a post to the diary.
   *
   *
   * @param author Author of the post
   * @param title Title of the post
   * @param text Text of the post
   */
  public void addPost(String author, String title, String text) {
    String date = new Time().getDate();
    if (!posts.containsKey(date)) {
      this.posts.put(date, new Post(author, title, text));
      System.out.println("Post added successfully");
    } else {
      System.out.println("Error!\nAlready a post on this date!\n");
    }
  }

  /**
   * Add a post to the diary.
   *
   *
   * @param author Author of the post
   * @param title Title of the post
   * @param text Text of the post
   * @param time Time of the post
   * @param date Date of the post
   */
  public void addPost(String author, String title, String text, String time, String date) {
    Time test = new Time(time, date);

    if (posts.containsKey(date) || test.getDate() == null || test.getClock() == null) {
      System.out.println("Error!");

      if (posts.containsKey(date)) {
        System.out.println("Already a post on this date!");
      }
      if (test.getDate() == null) {
        System.out.println("Invalid date!");
      }
      if (test.getClock() == null) {
        System.out.println("Invalid time!");
      }
    } else {
      this.posts.put(date, new Post(author, title, text, time, date));
      System.out.println("Post added successfully");
    }
  }

  /**
   * Gets a specific post on a date.
   *
   *
   * @param date The date of the wanted post
   * @return The post on the date specified or null if not a valid date
   */
  public Post getPost(String date) {
    if (this.posts.get(date) != null) {
      return this.posts.get(date);
    }
    return null;
  }

  /**
   * Gets all the posts in the diary.
   *
   *
   * @return A collection with all the posts in the diary
   *
   */
  public Collection<Post> getAllPosts() {
    return this.posts.values();
  }

  /**
   * Removes a post from the diary.
   *
   *
   * @param date Date of the post
   */
  public void removePost(String date) {
    if (this.posts.get(date) != null) {
      this.posts.remove(date);
      System.out.println("Post removed");
    } else {
      System.out.println("No posts on this date!");
    }


  }
}
