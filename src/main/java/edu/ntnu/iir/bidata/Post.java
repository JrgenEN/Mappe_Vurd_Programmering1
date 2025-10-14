package edu.ntnu.iir.bidata;

public class Post
{
  private final String author;
  private final String title;
  private final String text;
  private final Time dateTime;

  /**
   * Constructor for post Class
   * @param auth Author of the post
   * @param title Title of the post
   * @param text Text of the post
   */
  public Post(String auth, String title, String text){
    this.author = auth;
    this.title = title;
    this.text = text;
    dateTime = new Time();
  }

  /**
   * Constructor for post Class with clock and date
   * @param auth Author of the post
   * @param title Title of the post
   * @param text Text of the post
   * @param clock Clock of the post
   * @param date Date of the post
   */
  public Post(String auth, String title, String text, String clock, String date){
    this.author = auth;
    this.title = title;
    this.text = text;
    dateTime = new Time(clock, date);
  }
  public void printPost(){
    System.out.println(this.title);
    System.out.println(this.text);
    System.out.println("Author: " + this.author);
    System.out.println(dateTime.getClock() + dateTime.getDate());
  }
}
