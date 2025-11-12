package edu.ntnu.iir.bidata.diary;

/**
 * Class to handle posts.
 *
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
  private final Time dateTime;

  /**
   * Constructor for post Class.
   *
   * @param auth  Author of the post
   * @param title Title of the post
   * @param text  Text of the post
   */
  public Post(String auth, String title, String text) {
    this.dateTime = new Time();
    setAuthor(auth);
    setTitle(title);
    setText(text);
  }

  /**
   * Constructor for post Class with clock and date.
   *
   * @param auth  Author of the post
   * @param title Title of the post
   * @param text  Text of the post
   * @param clock Clock of the post
   * @param date  Date of the post
   */
  public Post(String auth, String title, String text, String clock, String date) {

    this.dateTime = new Time(clock, date);

    setAuthor(auth);
    setTitle(title);
    setText(text);
  }

  /**
   * Prints the post in format.
   */
  public void printPost() {
    System.out.println(this.getTitle());
    System.out.println(this.getText());
    System.out.println("Author: " + this.getAuthor().getName());
    System.out.println(this.getClock() + " " + this.getDate());
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
   * @param auth Author name.
   */
  public void setAuthor(String auth) {
    try {
      this.author = new Author(auth);
      if (this.author.getName().isEmpty()) {
        throw new IllegalArgumentException("Author name is empty");
      } else {
        this.author =  new Author(auth);
      }
    } catch (Exception e) {
      this.author = new Author("Author");
    }
  }

  /**
   * Setter for title of post.
   *
   *
   * @param title Title.
   */
  public void setTitle(String title) {
    if (title.isEmpty()) {
      this.title = "Title";
    } else {
      this.title = title;
    }
  }

  /**
   * Setter for text.
   *
   *
   * @param text Text.
   */
  public void setText(String text) {
    if (text.isEmpty()) {
      this.text = "Text";
    } else {
      this.text = text;
    }
  }

  /**
   * Setter for date.
   *
   *
   * @param date new date.
   */
  public void setDate(String date) {
    this.dateTime.setDate(date);
  }
}
