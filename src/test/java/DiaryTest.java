import java.util.Collection;
import edu.ntnu.iir.bidata.diary.Diary;
import edu.ntnu.iir.bidata.diary.Post;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


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
  public void TestGettingAllPosts() {
    Collection<Post> posts = test.getAllPosts();
    Assert.assertNotNull(posts);
    for (Post temp : posts) {
      temp.printPost();
      System.out.println();
    }
  }
  @Test
  public void TestGettingOnePost() {
    Assert.assertNotEquals(null, test.getPost("13.10.2025"));
  }

  @Test
  public void TestRemovingPost() {
    String date = "10.10.2025";
    test.removePost(date);
    Assert.assertNull("Failed removing", test.getPost(date));
  }
  @Test
  public void TestAddingAExistingElement() {
    test.addPost("Invalid","invalid","invalid","10:55", "13.10.2025");
    Assert.assertNotEquals("Invalid", test.getPost("13.10.2025").getAuthor());
  }
  @Test
  public void  TestAddingInvalidDate() {
    test.addPost("Invalid","invalid","invalid","10:55", "Invalid");
    Assert.assertNull("Not null", test.getPost("Invalid"));
  }
  @Test
  public void TestAddingInvalidTime() {
    test.addPost("Invalid","invalid","invalid","Invalid", "01.10.2025");
    Assert.assertNull(test.getPost("01.10.2025"));
  }
  @Test
  public void TestFindByKeyword(){
    Assert.assertNotNull("Couldnt find post by right keyword.", test.getPostByKeyWord("test"));
  }
}
