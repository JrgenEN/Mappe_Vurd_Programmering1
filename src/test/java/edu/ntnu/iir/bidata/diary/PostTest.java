package edu.ntnu.iir.bidata.diary;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostTest {
  @Test
  public void TestCreateEmptyPost() {
    try {
      Post test = new Post("", "", "");
      System.out.println(test.getAuthor().getName());
    } catch (IllegalArgumentException e) {
      assertEquals("Author name is empty", e.getMessage());
    }
  }
  @Test
  public void TestCreatePost() {
    Post test = new Post("Jørgen", "Title Test", "Text test need to make it a bit longer");
    assertEquals("Jørgen", test.getAuthor().getName());
    assertEquals("Title Test", test.getTitle());
    assertEquals("Text test need to make it a bit longer", test.getText());
  }
}