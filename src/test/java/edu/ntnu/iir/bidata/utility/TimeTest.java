package edu.ntnu.iir.bidata.utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
  static final String TEST_TIME = "14:54";
  static final String TEST_DATE = "13.10.2025";
  static final String TEST_INVALID = "Invalid";
  static final String TEST_NEGATIVE_DAY = "-13.10.2025";
  static final String TEST_INVALID_MONTH = "13.Invalid.2025";
  static final String TEST_NEGATIVE_MONTH = "13.-10.2025";
  static final String TEST_YEAR_ZERO = "13.10.0";
  static final String TEST_INVALID_FORMAT = "13.1";
  @Test
  void TestCreateTimeEmptyBrackets() {
    String dateToday = new Time().getDate();
    Time test = new Time();
    assertEquals(dateToday, test.getDate());
  }

  @Test
  void TestCreateTimeWithBrackets() {
    Time test = new Time(TEST_TIME, TEST_DATE);
    assertEquals(TEST_TIME, test.getClock());
    assertEquals(TEST_DATE, test.getDate());
  }

  @Test
  void TestCreateInvalidDate() {
    try {
      Time test = new Time(TEST_TIME, TEST_INVALID);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Use numbers for date", e.getMessage());
    }
  }

  @Test
  void TestCreateInvalidTime() {
    try {
      Time test = new Time(TEST_INVALID, TEST_DATE);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid time format, use HH:mm", e.getMessage());
    }
  }

  @Test
  void TestCreateNegativeDay() {
    try {
      Time test = new Time(TEST_TIME, TEST_NEGATIVE_DAY);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid day, use 1-31", e.getMessage());
    }
  }

  @Test
  void TestCreateInvalidMonth() {
    try {
      Time test = new Time(TEST_TIME, TEST_INVALID_MONTH);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Use numbers for date", e.getMessage());
    }
  }
  @Test
  void TestCreateNegativeMonth() {
    try {
      Time test = new Time(TEST_TIME, TEST_NEGATIVE_MONTH);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid month, use 1-12", e.getMessage());
    }
  }

  @Test
  void TestCreateYearZero() {
    try {
      Time test = new Time(TEST_TIME, TEST_YEAR_ZERO);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid year, use 2000-2025", e.getMessage());
    }
  }

  @Test
  void TestInvalidFormat() {
    try {
      Time test = new Time(TEST_TIME, TEST_INVALID_FORMAT);
      System.out.println(test.getDate());
    } catch (IllegalArgumentException e) {
      assertEquals("Invalid date format, use dd.MM.yyyy", e.getMessage());
    }
  }
}