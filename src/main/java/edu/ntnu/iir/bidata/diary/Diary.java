package edu.ntnu.iir.bidata.diary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Class to make a diary with an HashMap of Posts.
 *
 *
 * @author jorge
 *
 * @version 2.0
 * @see Post
 * @see HashMap
 * @see Collection
 * @see List
 * @since 1.0
 */
public class Diary {
  private static final String POST_ADDED = "Post added successfully";
  private static final String POST_ALREADY_EXIST = "Error!\nAlready a post on this date!\n";
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
      Post post = new Post(author, title, text);
      this.posts.put(date, post);
      System.out.println(POST_ADDED);
    } else {
      System.out.println(POST_ALREADY_EXIST);
    }
  }

  /**
   * Adds a post to the diary.
   *
   *
   * @param post Post you want to add to the diary.
   */
  public void addPost(Post post) {
    if (!posts.containsKey(post.getDate())) {
      posts.put(post.getDate(), post);
      System.out.println(POST_ADDED);
    } else {
      System.out.println(POST_ALREADY_EXIST);
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
      Post post = new Post(author, title, text, time, date);
      this.posts.put(date, post);
      System.out.println(POST_ADDED);
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
   * Search for posts with keyword.
   *
   *
   * @param keyword Keyword you want to search for.
   * @return Returns the post, and null if no posts.
   */
  public Post getPostByKeyWord(String keyword) {
    for (Post post : this.getAllPosts()) {
      if (post.getText().contains(keyword)) {
        return post;
      }
    }
    return null;
  }


  /**
   * Gets the posts between to dates.
   *
   *
   * @param start Start date.
   * @param end End date.
   * @return Collection of the dates between end and start. Returns empty Collection if none.
   */
  public Collection<Post> getPostBetweenDates(Time start, Time end) {
    List<Post> allPosts = new ArrayList<>();

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDate startDate = start.toLocalDate();
    LocalDate endDate = end.toLocalDate();

    for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
      Post post = this.getPost(date.format(fmt));
      if (post != null) {
        allPosts.add(post);
      }
    }

    return allPosts;
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
