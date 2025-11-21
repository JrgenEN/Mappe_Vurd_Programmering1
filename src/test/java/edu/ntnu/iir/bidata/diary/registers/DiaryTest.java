package edu.ntnu.iir.bidata.diary.registers;

import edu.ntnu.iir.bidata.diary.entry.Post;
import edu.ntnu.iir.bidata.utility.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;


class DiaryTest {
  private static final String DATE_1 = "10.10.2025";
  private static final String DATE_2 = "13.10.2025";
  private static final String TIME = "10:55";

  private Diary test;

  @BeforeEach
  void setup()
  {
    test = new Diary();
    test.addPost("Jørgen", "Title", "Text");
    test.addPost("Test", "Test", "test", TIME, DATE_2);
    test.addPost("Test2", "Test2", "test2", TIME, DATE_1);
  }

  @Test
  void TestGettingAllPosts() {
    Collection<Post> posts = test.getAllPosts();
    assertNotNull(posts);
  }

  @Test
  void TestGettingOnePost() {
    assertNotEquals(null, test.getPost("13.10.2025"));
  }

  @Test
  void TestGettingPostsBetweenDates() {
    final int EXPECTED_POST_COUNT = 2;
    Time start = new Time(TIME, DATE_1);
    Time end = new Time(TIME, DATE_2);

    assertEquals(EXPECTED_POST_COUNT, test.getPostBetweenDates(start, end).size(),
        "Failed getting posts between dates");
  }

  @Test
  void TestRemovingPost() {
    String date = "10.10.2025";
    assertTrue(test.removePost(date),"Failed removing");

  }

  @Test
  void TestAddingAExistingElement() {
    assertFalse(test.addPost("Invalid","invalid","invalid","10:55", "13.10.2025"),
        "Added post when it shouldn't");
  }

  @Test
  void  TestAddingInvalidDate() {
    assertFalse( test.addPost("Invalid","invalid","invalid","10:55", "Invalid"),
        "Added post when it shouldn't");
  }

  @Test
  void TestAddingInvalidTime() {
    assertFalse(test.addPost("Invalid","invalid","invalid","Invalid", "01.10.2025"),
        "Added post when it shouldn't");
  }

  @Test
  void TestFindByKeyword(){
    assertNotNull(test.getPostByKeyWord("test"),"Couldn't find post by right keyword.");
  }
}
