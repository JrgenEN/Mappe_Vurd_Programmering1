package edu.ntnu.iir.bidata.diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

/**
 * Class to handle date and time.
 *
 *
 * @author jorge
 * @version 2.0
 * @see LocalDateTime
 * @see LocalDate
 * @see DateTimeFormatter
 * @since 1.0
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
   * Convert String date to LocalDate date.
   *
   *
   * @return date As LocalDate.
   */
  public LocalDate toLocalDate() {
    if (this.date == null) {
      throw new IllegalStateException("Date is null");
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    try {
      return LocalDate.parse(this.date, formatter);
    } catch (DateTimeParseException e) {
      throw new IllegalArgumentException("Invalid date format: " + this.date);
    }
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
    final List<String> testD = Arrays.asList(d.split("\\."));
    final List<String> testT = Arrays.asList(t.split(":"));
    final int[] intDate = new int[3];
    
    for (int i = 0; i < testD.size(); i++) {
      try {
        intDate[i] = Integer.parseInt(testD.get(i));
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Use numbers for date");
      }
    }
    this.clock = t;
    this.date = d;

    if (testD.size() != 3) {
      throw new IllegalArgumentException("Invalid date format, use dd.MM.yyyy");
    } else if (testT.size() != 2) {
      throw new IllegalArgumentException("Invalid time format, use HH:mm");
    } else if (intDate[0] > 31 || intDate[0] <= 0) {
      throw new IllegalArgumentException("Invalid day, use 1-31");
    } else if (intDate[1] > 12 || intDate[1] <= 0) {
      throw new IllegalArgumentException("Invalid month, use 1-12");
    } else if (intDate[2] > 2025 || intDate[2] <= 1900) {
      throw new IllegalArgumentException("Invalid year, use 1900-2025");
    }
  }
}