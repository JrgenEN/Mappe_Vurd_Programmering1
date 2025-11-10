package edu.ntnu.iir.bidata.diary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
  private static final String UPPERCASE_NAME = "TEST NAME";
  private static final String LOWERCASE_NAME = "test name";
  private static final String VALID_NAME = "Test Name";
  private static final String EMPTY_NAME = "";

  private Author onlyBigLetters;
  private Author noBigLetters;
  private Author validName;
  private Author emptyName;

  @Before
  public void setUp() {
    onlyBigLetters = new Author(UPPERCASE_NAME);
    noBigLetters = new Author(LOWERCASE_NAME);
    validName = new Author(VALID_NAME);
    emptyName = new Author(EMPTY_NAME);
  }
  @Test
  public void TestEmptyName() {
    assertEquals("Empty Name Failed", EMPTY_NAME, emptyName.getName());
  }

  @Test
  public void TestFormattingUppercaseName() {
    System.out.println(onlyBigLetters.getName());
    assertEquals("Formatting failed", VALID_NAME, onlyBigLetters.getName());
  }

  @Test
  public void TestFormattingForNoBigLetters() {
    System.out.println(noBigLetters.getName());
    assertEquals("Formatting failed", VALID_NAME, noBigLetters.getName());
  }
  @Test
  public void TestFormattingForValidName() {
    System.out.println(validName.getName());
    assertEquals("Valid Name Failed", VALID_NAME, validName.getName());
  }
}