import edu.ntnu.iir.bidata.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


public class dagbokTest
{
  /**
   * Fixture for the tests
   */
  @Before
  public void setup(){
  }

  @After
  public void tearDown()
  {

  }
  @Test
  public void testCreatingInnlegg()
  {
    Posts test = new Posts("Jørgen", "Title", "description");
    Assert.assertEquals("Jørgen", test.getAuthor());
    Assert.assertEquals("Title", test.getTitle());
    Assert.assertEquals("description", test.getDescription());
  }
}
