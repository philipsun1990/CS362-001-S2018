/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  
{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  
  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
@Test(timeout = 4000)
  public void test01()  throws Throwable  
  {
      Appt appt0 = new Appt(12, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals("\t14/12/2018 at -1:-1am ,Birthday Party, This is my birthday party\n", string0);
  }
@Test(timeout = 4000)
	public void test02()  throws Throwable  
 {
   Appt appt2 = new Appt(10, 10, 13, 13, -1, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt2.setValid();
   assertFalse(appt2.getValid());
}
  @Test(timeout = 4000) 
	public void test03() throws Throwable 
	{
	Appt appt3 = new Appt(0, 30, 1, 2, 2000, "Nothing", "Empty Day", "person@gmail.com");
	int [] num = null;
	appt3.setRecurrence(num, 1, 1, 1);
	assertTrue(appt3.isRecurring());
	assertTrue(appt3.getValid());
	appt3.setValid();
	}
  @Test(timeout = 4000)
  public void test04()  throws Throwable  
  {
      Appt appt0 = new Appt(5, -5, 5, 5, 5, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
  }
  @Test(timeout = 4000)
	public void test05() throws Throwable
	{
	Appt appt5 = new Appt(3, -1, 1, 2, 2018, null, null, null);
	appt5.setValid();
	}
  @Test(timeout = 4000)
  public void test06()  throws Throwable  
  {
      Appt appt0 = new Appt(5, 5, -5, 2, 1600, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      assertFalse(appt0.getValid());
  }
}
