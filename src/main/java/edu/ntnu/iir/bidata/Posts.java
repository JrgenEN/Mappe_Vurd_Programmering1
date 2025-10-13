package edu.ntnu.iir.bidata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class Posts
{
  private String author;
  private String title;
  private String description;
  private String date;
  private String time;

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
  public void printPosts(){
    System.out.println(getTitle());
    System.out.println(getDescription());
    System.out.println("Author: " + getAuthor());
    System.out.println("Time: " + time);
    System.out.println("Date: " + date);
  }
  public String  getAuthor()
  {
    return this.author;
  }
  public String   getTitle()
  {
    return this.title;
  }
  public String   getDescription()
  {
    return this.description;
  }
  public String getDate() {
    return date;
  }
}
