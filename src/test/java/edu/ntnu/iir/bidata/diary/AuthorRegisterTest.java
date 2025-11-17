package edu.ntnu.iir.bidata.diary;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.*;

public class AuthorRegisterTest {
  private static final String NAME_FORMATTED = "Test";
  private static final String NAME_UPPERCASE = "TEST";
  private static final String NAME_LOWERCASE = "test";
  private static final String NAME_BAD_FORMAT = "tEST";

  private static final String TITLE = "Title Test";
  private static final String TEXT = "This is a test.";
  private static final String TIME = "10:10";

  private static final String DATE_FIRST = "10.10.2025";
  private static final String DATE_SECOND = "11.10.2025";
  private static final String DATE_THIRD = "12.10.2025";
  private static final String DATE_FOURTH = "10.11.2025";

  private AuthorRegister authorRegister;

  @Before
  public void setUp() {
    authorRegister = new AuthorRegister();

    Post post1 = new Post(NAME_FORMATTED, TITLE, TEXT, TIME, DATE_FIRST);
    Post post2 = new Post(NAME_UPPERCASE, TITLE, TEXT, TIME, DATE_SECOND);
    Post post3 = new Post(NAME_LOWERCASE, TITLE, TEXT, TIME, DATE_THIRD);
    Post post4 = new Post(NAME_BAD_FORMAT, TITLE, TEXT, TIME, DATE_FOURTH);

    authorRegister.addDiaryPost(post1);
    authorRegister.addDiaryPost(post2);
    authorRegister.addDiaryPost(post3);
    authorRegister.addDiaryPost(post4);
  }

  @Test
  public void TestAddingSameAuthorWithDifferentFormats() {
    final int EXPECTED_DIARY_POSTS = 4;

    assertEquals("Different Authors for the same name",
            EXPECTED_DIARY_POSTS, authorRegister.getDiary(NAME_FORMATTED).getAllPosts().size());
  }

  @Test
  public void TestAddingNewAuthor() {
    final String NAME = "Test To";
    final int EXPECTED_DIARY_POSTS = 1;

    Post post = new Post(NAME, TITLE, TEXT, TIME, DATE_FIRST);

    authorRegister.addDiaryPost(post);

    assertEquals("Something wrong with adding second author",
            EXPECTED_DIARY_POSTS, authorRegister.getDiary(NAME).getAllPosts().size());
  }

  @Test
  public void TestGettingDiaryByInvalidName() {
    try {
      authorRegister.getDiary("");
    } catch (Exception e) {
      assertEquals("No diary for ", e.getMessage());
    }

  }

  @Test
  public void TestGettingStatistics() {
    Map<String, Integer> statistics = authorRegister.getStatistics();

    String[] names = statistics.keySet().toArray(new String[0]);
    Arrays.sort(names);
    for (String name : names) {
      int expected = statistics.get(name);
      System.out.println(name + " : " + expected);
      assertEquals(expected, authorRegister.getDiary(name).getAllPosts().size());
    }
  }
}