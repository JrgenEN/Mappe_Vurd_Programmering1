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
    for (Post temp : posts) {
      temp.printPost();
      System.out.println();
    }
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
    test.removePost(date);
    assertNull("Failed removing", test.getPost(date));
  }

  @Test
  public void TestAddingAExistingElement() {
    test.addPost("Invalid","invalid","invalid","10:55", "13.10.2025");
    assertNotEquals("Invalid", test.getPost("13.10.2025").getAuthor().getName());
  }

  @Test
  public void  TestAddingInvalidDate() {
    test.addPost("Invalid","invalid","invalid","10:55", "Invalid");
    assertNull("Not null", test.getPost("Invalid"));
  }

  @Test
  public void TestAddingInvalidTime() {
    test.addPost("Invalid","invalid","invalid","Invalid", "01.10.2025");
    assertNull(test.getPost("01.10.2025"));
  }

  @Test
  public void TestFindByKeyword(){
    assertNotNull("Couldn't find post by right keyword.", test.getPostByKeyWord("test"));
  }
}
