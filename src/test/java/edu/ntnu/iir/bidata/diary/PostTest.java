package edu.ntnu.iir.bidata.diary;

import org.junit.Test;

import static org.junit.Assert.*;

public class PostTest {
  @Test
  public void TestCreateEmptyPost() {
    Post test = new Post("", "", "");
    assertFalse("Author is empty", test.getAuthor().getName().isEmpty());
    assertFalse("Text is empty", test.getText().isEmpty());
    assertFalse("Title is empty", test.getTitle().isEmpty());
  }
  @Test
  public void TestCreatePost() {
    Post test = new Post("Jørgen", "Title Test", "Text test need to make it a bit longer");
    assertEquals("Jørgen", test.getAuthor().getName());
    assertEquals("Title Test", test.getTitle());
    assertEquals("Text test need to make it a bit longer", test.getText());
  }
}