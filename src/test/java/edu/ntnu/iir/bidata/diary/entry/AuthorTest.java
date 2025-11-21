package edu.ntnu.iir.bidata.diary.entry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorTest {
  private static final String UPPERCASE_NAME = "TEST NAME";
  private static final String LOWERCASE_NAME = "test name";
  private static final String VALID_NAME = "Test Name";
  private static final String EMPTY_NAME = "";

  private Author onlyBigLetters;
  private Author noBigLetters;
  private Author validName;
  private Author emptyName;

  @BeforeEach
  void setUp() {
    onlyBigLetters = new Author(UPPERCASE_NAME);
    noBigLetters = new Author(LOWERCASE_NAME);
    validName = new Author(VALID_NAME);
    emptyName = new Author(EMPTY_NAME);
  }
  @Test
  void TestEmptyName() {
    assertEquals(EMPTY_NAME, emptyName.getName(), "Empty Name Failed");
  }

  @Test
  void TestFormattingUppercaseName() {
    System.out.println(onlyBigLetters.getName());
    assertEquals(VALID_NAME, onlyBigLetters.getName(),"Formatting failed");
  }

  @Test
  void TestFormattingForNoBigLetters() {
    System.out.println(noBigLetters.getName());
    assertEquals(VALID_NAME, noBigLetters.getName(),"Formatting failed");
  }
  @Test
  void TestFormattingForValidName() {
    System.out.println(validName.getName());
    assertEquals( VALID_NAME, validName.getName(), "Valid Name Failed");
  }
}