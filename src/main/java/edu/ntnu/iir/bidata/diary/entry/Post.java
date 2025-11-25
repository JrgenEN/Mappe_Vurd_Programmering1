package edu.ntnu.iir.bidata.diary.entry;

import edu.ntnu.iir.bidata.utility.Time;

/**
 * Class to create post.
 * Is used as an entry class.
 *
 * <p>Dependencies: {@link Author}, {@link Time}
 *
 * </p>
 *
 * @author jorge
 *
 * @version 2.0
 * @see Time
 * @see Author
 * @since 1.0
 */
public class Post {
  private Author author;
  private String title;
  private String text;
  private Time dateTime;

  /**
   * Constructor for post-Class.
   *
   * @param auth  Author of the post
   * @param title Title of the post
   * @param text  Text of the post
   */
  public Post(String auth, String title, String text) {

    Time time = new Time();
    setDateTime(time.getClock(), time.getDate());
    setAuthor(auth);
    setTitle(title);
    setText(text);

  }

  /**
   * Constructor for post-Class with clock and date.
   *
   * @param auth  Author of the post
   * @param title Title of the post
   * @param text  Text of the post
   * @param clock Clock of the post
   * @param date  Date of the post
   */
  public Post(String auth, String title, String text, String clock, String date) {

    setDateTime(clock, date);
    setAuthor(auth);
    setTitle(title);
    setText(text);
  }

  /**
   * Constructor for post-Class with a post-string.
   *
   * @param post post-string.
   */
  public Post(String post) {
    stringToPost(post);
  }

  /**
   * Prints the post in format.
   */
  public String toString() {
    return this.getTitle() + "\n"
            + this.getText()
            + "\nAuthor: " + this.getAuthor().getName()
            + "\n" + this.getClock() + " "
            + this.getDate();

  }
  // Getters for posts.

  public Author getAuthor() {
    return this.author;
  }

  public String getTitle() {
    return this.title;
  }

  public String getText() {
    return this.text;
  }

  public String getClock() {
    return this.dateTime.getClock();
  }

  public String getDate() {
    return this.dateTime.getDate();
  }

  /**
   * Setter for author.
   *
   *
   * @param auth Author of post.
   */
  public void setAuthor(String auth) {
    if (auth.isEmpty()) {
      throw new IllegalArgumentException("Author name is empty");
    } else {
      this.author =  new Author(auth);
    }
  }

  /**
   * Setter for title of post.
   *
   *
   * @param title Title of post.
   */
  public void setTitle(String title) {
    if (title.isEmpty()) {
      throw new IllegalArgumentException("Title is empty");
    } else {
      this.title = title;
    }

  }

  /**
   * Setter for text.
   *
   *
   * @param text Text of post.
   */
  public void setText(String text) {
    if (text.isEmpty()) {
      throw new IllegalArgumentException("Text is empty");
    } else {
      this.text = text;
    }
  }

  /**
   * Setter for time and date.
   *
   * @param time Time of post.
   * @param date Date of post.
   */
  private void setDateTime(String time, String date) {
    if (time.isEmpty() || date.isEmpty()) {
      throw new IllegalArgumentException("Time and date is empty");
    } else {
      this.dateTime = new Time(time, date);
    }
  }

  /**
   * Function that converts a post formated string to a post-object.
   * If the string is not formated correctly, it throws an exception.
   *
   * @param post post formated string.
   */
  private void stringToPost(String post) {
    String[] parts = post.split("\n");
    if (parts.length != 4) {
      throw new IllegalArgumentException("Invalid post");
    }
    this.setTitle(parts[0]);
    this.setText(parts[1]);
    this.setAuthor(parts[2].split(":")[1].replaceFirst(" ", ""));
    String[] timeParts = parts[3].split(" ");
    this.setDateTime(timeParts[0], timeParts[1]);
  }
}
