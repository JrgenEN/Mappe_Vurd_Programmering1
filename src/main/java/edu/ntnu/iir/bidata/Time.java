package edu.ntnu.iir.bidata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
  private String clock;
  private String date;

  /**
   * Sets to current date and time on your computer
   */
  public Time()
  {
    this.setDateTime();
  }

  /**
   * Use format Clock HH:mm, and Date dd.MM.yyyy
   * @param temp_clock the clock you want in format HH:mm
   * @param temp_date the  date you want in format dd.MM.yyyy
   */
  public Time(String temp_clock, String temp_date){
    this.clock = temp_clock;
    this.date = temp_date;
  }

  /**
   * Gets the date
   * @return the date
   */
  public String getDate(){
    return this.date;
  }

  /**
   * Gets the clock
   * @return the clock
   */
  public String getClock(){
    return this.clock;
  }

  /**
   * Sets the date and time to current date and time
   */
  private void setDateTime(){
    LocalDateTime temp = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
    String[] arr = temp.format(formatter).split(" ");
    this.clock = arr[0];
    this.date = arr[1];
  }
}