package edu.ntnu.iir.bidata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class to make a diary with an HashMap of Posts.
 *
 *
 * @author jorge
 *
 * @version 1.0
 * @see Post
 * @see ArrayList
 * @see Collection
 * @see List
 */
public class Diary {
  private final ArrayList<Post> posts;

  /**
   * Constructor For diary. Initializing posts to a new HashMap.
   */
  public Diary() {
    this.posts = new ArrayList<>();
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
    this.posts.add(new Post(author, title, text));
    System.out.println("Post added successfully");
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

    if (test.getDate() == null || test.getClock() == null) {
      System.out.println("Error!");
      if (test.getDate() == null) {
        System.out.println("Invalid date!");
      }
      if (test.getClock() == null) {
        System.out.println("Invalid time!");
      }
    } else {
      this.posts.add(new Post(author, title, text, time, date));
      System.out.println("Post added successfully");
    }
  }

  /**
   * Gets a specific post on a date.
   *
   *
   * @param date The date of the wanted post
   * @return A Collection of posts on the date, and an empty collection if no posts
   */
  public Collection<Post> getPost(String date) {
    Collection<Post> getPostContainer = new ArrayList<>();
    for (Post post : this.posts)
    {
      if (post.getDate().equals(date))
      {
        getPostContainer.add(post);
      }
    }
    return getPostContainer;

  }

  /**
   * Gets all the posts in the diary.
   *
   *
   * @return A collection with all the posts in the diary
   *
   */
  public Collection<Post> getAllPosts() {

    return this.posts;
  }

  /**
   * Removes a post from the diary.
   *
   *
   * @param date Date of the post
   */
  public void removePost(String date) {
    if (this.getPost(date) != null) {
      this.posts.removeAll(this.getPost(date));
    }
  }
}
