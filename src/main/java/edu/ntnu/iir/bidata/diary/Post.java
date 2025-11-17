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
   * @param auth Author name.
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
   * @param title Title.
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
   * @param text Text.
   */
  public void setText(String text) {
    if (text.isEmpty()) {
      throw new IllegalArgumentException("Text is empty");
    } else {
      this.text = text;
    }
  }
}
