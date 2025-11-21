package edu.ntnu.iir.bidata.diary.entry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {


  @Test
  void TestCreateEmptyPost() {
    try {
      Post test = new Post("", "", "");
      System.out.println(test.getAuthor().getName());
    } catch (IllegalArgumentException e) {
      assertEquals("Author name is empty", e.getMessage());
    }
  }
  @Test
  void TestCreatePost() {
    Post test = new Post("Jørgen", "Title Test", "Text test need to make it a bit longer");
    assertEquals("Jørgen", test.getAuthor().getName());
    assertEquals("Title Test", test.getTitle());
    assertEquals("Text test need to make it a bit longer", test.getText());
  }
}