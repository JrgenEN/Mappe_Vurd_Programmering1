import edu.ntnu.iir.bidata.Diary;
import edu.ntnu.iir.bidata.Post;
import java.util.Collection;
import org.junit.Test;
import org.junit.Before;

import org.junit.Assert;

public class DiaryTest {
  private Diary test;

  @Before
  public void setup()
  {
    test = new Diary();
    test.addPost("Jørgen", "Title", "Text");
    test.addPost("Test", "Test", "test", "10:50","13.10.2025");
    test.addPost("Test2", "Test2", "test2", "10:55","10.10.2025");
  }
  @Test
  public void TestGettingAllPosts()
  {
    Collection<Post> posts = test.getAllPosts();

    for (Post temp : posts) {
      temp.printPost();
      System.out.println();
    }
  }
  @Test
  public void TestGettingOnePost(){
    Assert.assertNotEquals(null, test.getPost("13.10.2025"));
  }
}
