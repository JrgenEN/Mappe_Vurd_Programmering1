package edu.ntnu.iir.bidata.diary;

import org.junit.Before;
import org.junit.Test;
import java.util.Collection;

import static org.junit.Assert.*;

public class DiaryTest {
  private static final String DATE_1 = "10.10.2025";
  private static final String DATE_2 = "13.10.2025";
  private static final String TIME = "10:55";

  private Diary test;

  @Before
  public void setup()
  {
    test = new Diary();
    test.addPost("Jørgen", "Title", "Text");
    test.addPost("Test", "Test", "test", TIME, DATE_2);
    test.addPost("Test2", "Test2", "test2", TIME, DATE_1);
  }

  @Test
  public void TestGettingAllPosts() {
    Collection<Post> posts = test.getAllPosts();
    assertNotNull(posts);
  }

  @Test
  public void TestGettingOnePost() {
    assertNotEquals(null, test.getPost("13.10.2025"));
  }

  @Test
  public void TestGettingPostsBetweenDates() {
    final int EXPECTED_POST_COUNT = 2;
    Time start = new Time(TIME, DATE_1);
    Time end = new Time(TIME, DATE_2);

    assertEquals("Failed getting posts between dates",
            EXPECTED_POST_COUNT, test.getPostBetweenDates(start, end).size());
  }

  @Test
  public void TestRemovingPost() {
    String date = "10.10.2025";
    assertTrue("Failed removing", test.removePost(date));

  }

  @Test
  public void TestAddingAExistingElement() {
    assertFalse("Added post when it shouldn't",test.addPost("Invalid","invalid","invalid","10:55", "13.10.2025"));
  }

  @Test
  public void  TestAddingInvalidDate() {
    assertFalse("Added post when it shouldn't", test.addPost("Invalid","invalid","invalid","10:55", "Invalid"));
  }

  @Test
  public void TestAddingInvalidTime() {
    assertFalse("Added post when it shouldn't", test.addPost("Invalid","invalid","invalid","Invalid", "01.10.2025"));
  }

  @Test
  public void TestFindByKeyword(){
    assertNotNull("Couldn't find post by right keyword.", test.getPostByKeyWord("test"));
  }
}
