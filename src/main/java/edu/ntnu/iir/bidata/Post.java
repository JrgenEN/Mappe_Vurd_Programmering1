package edu.ntnu.iir.bidata;

/**
 * Class to handle posts
 * @author jorge
 * @version 1.0
 * @see Time
 */
public class Post {
  private final String author;
  private final String title;
  private final String text;
  private final Time dateTime;

  /**
   * Constructor for post Class
   *
   * @param auth  Author of the post
   * @param title Title of the post
   * @param text  Text of the post
   */
  public Post(String auth, String title, String text) {
    this.dateTime = new Time();
    if (auth.isEmpty()) {
      this.author = "Author";
    }else {
      this.author = auth;
    }
    if (title.isEmpty()) {
      this.title = "Title";
    }else{
      this.title = title;
    }
    if (text.isEmpty()) {
      this.text = "Text";
    }else{
      this.text = text;
    }
  }

  /**
   * Constructor for post Class with clock and date
   *
   * @param auth  Author of the post
   * @param title Title of the post
   * @param text  Text of the post
   * @param clock Clock of the post
   * @param date  Date of the post
   */
  public Post(String auth, String title, String text, String clock, String date) {

      this.dateTime = new Time(clock, date);
      if (auth.isEmpty()) {
        this.author = "Author";
      }else {
        this.author = auth;
      }
      if (title.isEmpty()) {
        this.title = "Title";
      }else{
        this.title = title;
      }
      if (text.isEmpty()) {
        this.text = "Text";
      }else{
        this.text = text;
      }
  }

  /**
   * Prints the post in format
   */
  public void printPost() {
    System.out.println(this.getTitle());
    System.out.println(this.getText());
    System.out.println("Author: " + this.getAuthor());
    System.out.println(this.getClock() + " " + this.getDate());
  }
  // Getters for posts.
  public String getAuthor(){
    return this.author;
  }
  public String getTitle(){
    return this.title;
  }
  public String getText(){
    return this.text;
  }
  public String getClock()
  {
    return this.dateTime.getClock();
  }
  public String getDate(){
    return this.dateTime.getDate();
  }
}
