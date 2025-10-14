import edu.ntnu.iir.bidata.Post;
import org.junit.Test;
import org.junit.Assert;

public class PostTest {

  @Test
  public void TestCreateEmptyPost() {
    Post test = new Post("", "", "");
    Assert.assertFalse("Author is empty", test.getAuthor().isEmpty());
    Assert.assertFalse("Text is empty", test.getText().isEmpty());
    Assert.assertFalse("Title is empty", test.getTitle().isEmpty());
    test.printPost();
  }
  @Test
  public void TestCreatePost() {
    Post test = new Post("Jørgen", "Title Test", "Text test need to make it a bit longer");
    Assert.assertEquals("Jørgen", test.getAuthor());
    Assert.assertEquals("Title Test", test.getTitle());
    Assert.assertEquals("Text test need to make it a bit longer", test.getText());
    test.printPost();
  }
}