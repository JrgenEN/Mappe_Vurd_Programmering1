package edu.ntnu.iir.bidata;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Class to handle date and time.
 *
 *
 * @author jorge
 * @version 1.0
 * @see LocalDateTime
 * @see DateTimeFormatter
 */
public class Time {
  private String clock;
  private String date;

  /**
   * Sets to current date and time on your computer.
   */
  public Time() {
    this.setDateTime();
  }

  /**
   * Use format Clock HH:mm, and Date dd.MM.yyyy.
   *
   *
   * @param time the clock you want in format HH:mm.
   * @param date the  date you want in format dd.MM.yyyy.
   */
  public Time(String time, String date) {
    this.setDateTime(time, date);
  }

  /**
   * Gets the date.
   *
   *
   * @return the date
   */
  public String getDate() {
    return this.date;
  }

  /**
   * Gets the clock.
   *
   *
   * @return the clock.
   */
  public String getClock() {
    return this.clock;
  }

  /**
   * Sets the date and time to current date and time.
   */
  private void setDateTime() {
    LocalDateTime temp = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");
    String[] arr = temp.format(formatter).split(" ");
    this.clock = arr[0];
    this.date = arr[1];
  }

  /**
   * Set date and time from params, with some error handling.
   * Sets time or date null if invalid date or time.
   *
   *
   * @param t time
   * @param d date
   */
  private void setDateTime(String t, String d) {
    final int testD = Arrays.asList(d.split("\\.")).size();
    final int testT = Arrays.asList(t.split(":")).size();

    this.clock = t;
    this.date = d;

    if (testD != 3) {
      this.date = null;
    }
    if (testT != 2) {
      this.clock = null;
    }
  }
}