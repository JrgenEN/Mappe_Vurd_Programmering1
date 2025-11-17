package edu.ntnu.iir.bidata.diary;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
  @Test
  public void TestCreateTimeEmptyBrackets() {
    String dateToday = new Time().getDate();
    Time test = new Time();
    assertEquals(dateToday, test.getDate());
  }

  @Test
  public void TestCreateTimeWithBrackets() {
    String testTime = "14:54";
    String testDate = "13.10.2025";
    Time test = new Time(testTime, testDate);
    assertEquals(testTime, test.getClock());
    assertEquals(testDate, test.getDate());
  }

  @Test
  public void TestCreateInvalidDate() {
    String testTime = "14:54";
    String testDate = "Invalid";
    try {
      Time test = new Time(testTime, testDate);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Use numbers for date", e.getMessage());
    }
  }

  @Test
  public void TestCreateInvalidTime() {
    String testTime = "Invalid";
    String testDate = "13.10.2025";
    try {
      Time test = new Time(testTime, testDate);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid time format, use HH:mm", e.getMessage());
    }
  }

  @Test
  public void TestCreateNegativeDay() {
    String testTime = "14:54";
    String testDate = "-13.10.2025";
    try {
      Time test = new Time(testTime, testDate);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid day, use 1-31", e.getMessage());
    }
  }

  @Test
  public void TestCreateInvalidMonth() {
    String testTime = "14:54";
    String testDate = "13.Invalid.2025";
    try {
      Time test = new Time(testTime, testDate);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Use numbers for date", e.getMessage());
    }
  }
  @Test
  public void TestCreateNegativeMonth() {
    String testTime = "14:54";
    String testDate = "13.-10.2025";
    try {
      Time test = new Time(testTime, testDate);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid month, use 1-12", e.getMessage());
    }
  }

  @Test
  public void TestCreateYearZero() {
    String testTime = "14:54";
    String testDate = "13.10.0";
    try {
      Time test = new Time(testTime, testDate);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid year, use 1900-2025", e.getMessage());
    }
  }

  @Test
  public void TestInvalidFormat() {
    String testTime = "14:54";
    String testDate = "13.1";
    try {
      Time test = new Time(testTime, testDate);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid date format, use dd.MM.yyyy", e.getMessage());
    }
  }
}