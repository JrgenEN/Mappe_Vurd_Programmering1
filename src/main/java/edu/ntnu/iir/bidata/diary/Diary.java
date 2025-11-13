package edu.ntnu.iir.bidata.diary;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Class to make a diary with a HashMap of Posts.
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
   * @param author Author of the post
   * @param title  Title of the post
   * @param text   Text of the post
   */
  public void addPost(String author, String title, String text) {
    try {
      String date = new Time().getDate();
      if (!posts.containsKey(date)) {
        Post post = new Post(author, title, text);
        this.posts.put(date, post);
      } else {
        throw new IllegalArgumentException(POST_ALREADY_EXIST);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Adds a post to the diary.
   *
   * @param post Post you want to add to the diary.
   */
  public boolean addPost(Post post) {
    try {
      if (!posts.containsKey(post.getDate())) {
        posts.put(post.getDate(), post);
      } else {
        throw new IllegalArgumentException(POST_ALREADY_EXIST);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * Add a post to the diary.
   *
   * @param author Author of the post
   * @param title  Title of the post
   * @param text   Text of the post
   * @param time   Time of the post
   * @param date   Date of the post
   */
  public boolean addPost(String author, String title, String text, String time, String date) {
    try {
      Time test = new Time(time, date);
      if (posts.containsKey(date)) {
        throw new IllegalArgumentException("Already a post on this date!");
      }
      else if (test.getDate() == null) {
        throw new IllegalArgumentException("Invalid date!");
      } else if (test.getClock() == null) {
        throw new IllegalArgumentException("Invalid time!");
      } else {
        Post post = new Post(author, title, text, time, date);
        this.posts.put(date, post);
      }
    } catch(Exception e) {
      System.out.println(e.getMessage());
      return false;
    }

    return true;
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
   * Search for posts with a keyword.
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
   * @return {@code Collection} of the dates between end and start. If none returns an empty {@code Collection}.
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
    final ArrayList<String> keys = new ArrayList<>(this.posts.keySet());
    Collections.sort(keys);
    final Collection<Post> allPosts = new ArrayList<>();
    for (String key : keys) {
      allPosts.add(this.posts.get(key));
    }
    return allPosts;
  }

  /**
   * Removes a post from the diary.
   *
   *
   * @param date Date of the post
   */
  public boolean removePost(String date) {
    try {
      if (this.posts.get(date) != null) {
        this.posts.remove(date);
      } else {
        throw new IllegalArgumentException("No post's on " + date);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }
}
