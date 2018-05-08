/** A JUnit test class to test the class DataHandler. */

package calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest
{
  	//test saving
	@Test(timeout = 4000)
	public void test00()	throws Throwable	
	{
		DataHandler dhfile = new DataHandler();
		Appt appt0 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt0);
		assertTrue("saved", output);
		Appt appt1 = new Appt(5, 5, 4, 35, 2018, null, null, null);
		appt1.setValid();
		assertFalse("bad appt", appt1.getValid());
		output = dhfile.saveAppt(appt1);
		assertFalse("Saved bad appt", output);
	}

  //save appointments - autosave
  @Test(timeout = 4000)
  public void test01()  throws Throwable  
  {
      GregorianCalendar someday = new GregorianCalendar(2018, 5, 10);
      CalDay day0 = new CalDay(someday);
      Appt appt0 = new Appt(8, 5, 7, 6, 2018, "Meeting", "This is a meeting", "work@gmail.com");
      day0.addAppt(appt0);
      DataHandler data0 = new DataHandler("calendar_test.xml");
      assertTrue(data0.saveAppt(appt0));
  }

  //test deleting
	@Test(timeout = 4000)
	public void test02()	throws Throwable	
  {
		DataHandler dhfile = new DataHandler();
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt1);
		assertTrue("save3", output);
		output = dhfile.deleteAppt(appt1);
		assertTrue("save4", output);
	}

  //save appointments - recurring
  @Test(timeout = 4000)
  public void test03()  throws Throwable  
  {
      GregorianCalendar someday = new GregorianCalendar(2018, 5, 10);
      CalDay day0 = new CalDay(someday);
      Appt appt0 = new Appt(8, 5, 7, 6, 2018, "Meeting", "This is a meeting", "work@gmail.com");
      int[] recurDaysArr = {2, 3, 5};
      appt0.setRecurrence(recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
      day0.addAppt(appt0);
      DataHandler data0 = new DataHandler("calendar_test.xml");
      assertTrue(data0.saveAppt(appt0));
  }

  //test no autosave
	@Test(timeout = 4000)
	public void test04()	throws Throwable	
  {
		DataHandler dhfile = new DataHandler("calendar2.xml",false);
		Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		boolean output = dhfile.saveAppt(appt1);
		assertTrue("no autosave", output);
		output = dhfile.deleteAppt(appt1);
		assertTrue("no autosave", output);
	}

  //save appointments - invalid appointment
  @Test(timeout = 4000)
  public void test05()  throws Throwable  
  {
      GregorianCalendar someday = new GregorianCalendar(2018, 5, 10);
      CalDay day0 = new CalDay(someday);
      Appt appt0 = new Appt(-100, 5, 7, 6, 2018, "Meeting", "This is a meeting", "work@gmail.com");
      appt0.setValid();
      day0.addAppt(appt0);
      DataHandler data0 = new DataHandler("calendar_test.xml");
      assertFalse(data0.saveAppt(appt0));
  }

    //delete appointments - autosave
    @Test(timeout = 4000)
    public void test06()  throws Throwable  
    {
        GregorianCalendar someday = new GregorianCalendar(2018, 5, 10);
        CalDay day0 = new CalDay(someday);
        Appt appt0 = new Appt(8, 5, 7, 6, 2018, "Meeting", "This is a meeting", "work@gmail.com");
        day0.addAppt(appt0);
        DataHandler data0 = new DataHandler("calendar_test.xml");
        data0.saveAppt(appt0);
        assertTrue(data0.deleteAppt(appt0));
    }

    //delete appointments - no autosave
    @Test(timeout = 4000)
    public void test07()  throws Throwable  
    {
        GregorianCalendar someday = new GregorianCalendar(2018, 5, 10);
        CalDay day0 = new CalDay(someday);
        Appt appt0 = new Appt(8, 5, 7, 6, 2018, "Meeting", "This is a meeting", "work@gmail.com");
        day0.addAppt(appt0);
        DataHandler data0 = new DataHandler("calendar_test.xml", false);
        data0.saveAppt(appt0);
        assertTrue(data0.deleteAppt(appt0));
    }

     @Test(timeout = 4000)
  public void test08()  throws Throwable  
  {
    DataHandler one = new DataHandler();
    DataHandler two = new DataHandler("data");
    DataHandler three = new DataHandler("data1", false);
  
  }
  @Test (timeout = 4000)
  public void test09()  throws Throwable  
  {
    DataHandler one = new DataHandler("data");
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 27);
    GregorianCalendar lastDay = new GregorianCalendar(2019, 2, 12);
    CalDay day1 = new CalDay(firstDay);
    CalDay day2 = new CalDay(lastDay);
    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    Appt appt1 = new Appt(12, 12, 28, 12, 2018, "Birthday Party", "Party!!", "sj@sj.com");
    int[] recurringDays = new int[0];
    int[] recurringDays1 = new int[0];
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 1, 10);
    appt1.setRecurrence(recurringDays1, Appt.RECUR_BY_YEARLY, 1, 10);
    one.saveAppt(appt0);
    one.saveAppt(appt1);
    one.deleteAppt(appt1);
    one.save();  
  }

  @Test(timeout = 4000)
  public void test10() throws Throwable 
  {
    DataHandler one = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 27);
    GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 29);
    CalDay day1 = new CalDay(firstDay);
    CalDay day2 = new CalDay(lastDay);
    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    Appt appt1 = new Appt(0, 9, 28, 12, 2018, "Birthday Party", "Party!!", "sj@sj.com");
    day1.addAppt(appt0);
    day2.addAppt(appt1);
    one.saveAppt(appt0);
    one.saveAppt(appt1);
    one.deleteAppt(appt1);
    one.save();
  }

  @Test(timeout = 4000)
  public void test11() throws Throwable 
  {
    DataHandler dh = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2019, 5, 25);
    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");  
    int[] recurringDays = new int[0];
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 2, 3);
    dh.saveAppt(appt0);
  }

  @Test(timeout = 4000)
  public void test12() throws Throwable 
  {
    DataHandler dh = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 25);
    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com"); 
    int[] recurringDays = new int[1];
    recurringDays[0] = 1;
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 10, 10);
    dh.saveAppt(appt0);
  }

  @Test(timeout = 4000)
  public void test13() throws Throwable 
  {
    DataHandler dh = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 25);
    Appt appt0 = new Appt(12, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    int[] recurringDays = new int[0];
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 2, 3);
    dh.saveAppt(appt0);
  }

  @Test(timeout = 4000)
  public void test14() throws Throwable 
  { 
    DataHandler dh = new DataHandler("testdir1", false);
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2018, 12, 25);
    Appt appt0 = new Appt(12, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    Appt appt3 = new Appt(12, 30, 20, -2, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    int[] recurringDays = new int[0];
    appt0.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 2, 3);
    appt3.setValid();
    dh.getApptRange(firstDay, lastDay);
    assertTrue(dh.saveAppt(appt0));
    assertEquals("appt", appt0.getXmlElement().getNodeName());
    assertTrue(dh.deleteAppt(appt0));
    assertNull(appt0.getXmlElement());
    assertFalse(appt3.getValid());
    assertFalse(dh.saveAppt(appt3));
    assertFalse(dh.deleteAppt(appt3));
    assertFalse(appt3.isRecurring());
  }
  
  @Test(timeout = 4000)
  public void test15() throws Throwable 
  {
    DataHandler dh = new DataHandler("Yolo2", true);
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2019, 12, 25);
    Appt appt0 = new Appt(12, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt0.setValid();
    assertNotNull(dh.getApptRange(firstDay, lastDay));
    assertFalse(dh.deleteAppt(appt0));
  }

  @Test(timeout = 4000)
  public void test16() throws Throwable 
  {
    DataHandler dh = new DataHandler();
    GregorianCalendar firstDay = new GregorianCalendar(2018, 12, 20);
    GregorianCalendar lastDay = new GregorianCalendar(2020, 1, 25);
    Appt appt0 = new Appt(1, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    Appt appt1 = new Appt(1, 31, 21, 12, 2018, "HELLO", "Appointment at doctor", "sj@sj.com");
    Appt appt2 = new Appt(1, 32, 22, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    Appt appt3 = new Appt(1, 33, 23, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    int[] recurDays = new int[2];
    recurDays[0] = 1;
    recurDays[1] = 2;
    int[] recurDays2 = null;
    appt0.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, 2, 3);
    appt1.setRecurrence(recurDays2, Appt.RECUR_BY_MONTHLY, 2, 3);
    appt2.setRecurrence(recurDays, Appt.RECUR_BY_YEARLY, 2, 3);
    appt3.setRecurrence(recurDays, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
    assertTrue(dh.saveAppt(appt0));
    assertTrue(dh.saveAppt(appt1));
    assertTrue(dh.saveAppt(appt2));
    assertTrue(dh.saveAppt(appt3));
    LinkedList<CalDay> calDays = new LinkedList<CalDay>();
    calDays = dh.getApptRange(firstDay, lastDay);
    assertTrue(calDays.size() > 0);
    assertEquals(calDays.get(0).getAppts().get(0).getRecurIncrement(), 2);
    assertEquals(calDays.get(0).getAppts().getFirst().getRecurNumber(), 1000);
    assertEquals(calDays.get(0).getAppts().getFirst().getRecurBy(), Appt.RECUR_BY_WEEKLY);
    assertTrue(calDays.get(0).getAppts().size() > 1 );
  }
}
