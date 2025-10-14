import edu.ntnu.iir.bidata.Time;
import org.junit.Test;

import org.junit.Assert;

public class TimeTest {

  @Test
  public void TestCreateTimeEmptyBrackets()
  {
    String dateToday = new Time().getDate();
    Time test = new Time();
    Assert.assertEquals(dateToday, test.getDate());
  }
  @Test
  public void TestCreateTimeWithBrackets(){
    String testTime = "14:54";
    String testDate = "13.10.2025";
    Time test = new Time(testTime, testDate);
    Assert.assertEquals(testTime, test.getClock());
    Assert.assertEquals(testDate, test.getDate());
  }
  @Test
  public void TestCreateInvalidDate(){
    String testTime = "14:54";
    String testDate = "Invalid";
    Time test = new Time(testTime, testDate);
    Assert.assertNull(test.getDate());
  }
  @Test
  public void TestCreateInvalidTime(){
    String testTime = "Invalid";
    String testDate = "13.10.2025";
    Time test = new Time(testTime, testDate);
    Assert.assertNull(test.getClock());
  }
}
