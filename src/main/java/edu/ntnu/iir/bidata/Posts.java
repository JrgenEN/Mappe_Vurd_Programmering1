package edu.ntnu.iir.bidata;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * This class handles posts
 */
public class Posts
{
  private final String author;
  private final String title;
  private final String description;
  private final String date;
  private final String time;

  /**
   *
   * @param author Name of the person adding post
   * @param title Title of post
   * @param description Text for the post
   */
  public Posts(String author, String title, String description)
  {
    this.author = author;
    this.title = title;
    this.description = description;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
    String dateTime = LocalDateTime.now().format(formatter);
    String[] split = dateTime.split(" ");
    this.date = split[1];
    this.time = split[0];
  }
  public Posts(String author, String title, String description, String date)
  {
    this.author = author;
    this.title = title;
    this.description = description;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
    String dateTime = LocalDateTime.now().format(formatter);
    String[] split = dateTime.split(" ");
    this.date = date;
    this.time = split[0];
  }

  /**
   * Prints the post in a clean and efficient way
   */
  public void printPosts(){
    System.out.println(getTitle());
    System.out.println(getDescription());
    System.out.println("Author: " + getAuthor());
    System.out.println("Time: " + time);
    System.out.println("Date: " + date);
  }

  /**
   *  Gets author
   * @return author
   */
  public String  getAuthor()
  {
    return this.author;
  }

  /**
   * Gets title
   * @return title
   */
  public String   getTitle()
  {
    return this.title;
  }

  /**
   * Gets description
   * @return description
   */
  public String   getDescription()
  {
    return this.description;
  }

  /**
   * Gets date
   * @return date
   */
  public String getDate() {
    return date;
  }
}
