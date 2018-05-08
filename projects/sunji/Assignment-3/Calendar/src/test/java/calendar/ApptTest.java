/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.Console;
import calendar.Appt;
import calendar.CalendarUtil;

public class ApptTest  {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  
  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();

  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  
 {
    Appt appt = new Appt(12,30, 15, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    // setvalid month branch
    Appt appt0 = new Appt(12, 30, 15, -1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid year branch
    Appt appt1 = new Appt(12, 30, 15, 11, 0, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid day branch
    Appt appt2 = new Appt(12, 30, 0, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid day branch
    Appt appt3 = new Appt(12, 30, 32, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid month branch
    Appt appt4 = new Appt(12, 30, 20, 13, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid hour branch
    Appt appt5 = new Appt(-1, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid hour branch
    Appt appt6 = new Appt(24, 30, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid minute branch
    Appt appt7 = new Appt(12, 61, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    //setvalid minute branch
    Appt appt8 = new Appt(12, -1, 20, 12, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");

    appt.setValid();
    appt0.setValid();
    appt1.setValid();
    appt2.setValid();
    appt3.setValid();
    appt4.setValid();
    appt5.setValid();
    appt6.setValid();
    appt7.setValid();
    appt8.setValid();

    assertTrue(appt.getValid());
    assertFalse(appt0.getValid());
    assertFalse(appt1.getValid());
    assertFalse(appt2.getValid());
    assertFalse(appt3.getValid());
    assertFalse(appt4.getValid());
    assertFalse(appt5.getValid());
    assertFalse(appt6.getValid());
    assertFalse(appt7.getValid());
    assertFalse(appt8.getValid());
    
    //test tostring
    appt0.toString();

  }

  @Test(timeout = 4000)
 public void test02()  throws Throwable  
 {
    Appt appt0 = new Appt(12, 30, 15, 11, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    int hour = appt0.getStartHour();
    int minute = appt0.getStartMinute();
    int day = appt0.getStartDay();
    int month = appt0.getStartMonth();
    int year = appt0.getStartYear();
    String title = appt0.getTitle();
    String description = appt0.getDescription();
    String email = appt0.getEmailAddress();
    boolean valid = appt0.getValid(); 
    int[] recurDays = new int[0];
    assertEquals(hour, 12);
    assertEquals(minute, 30);
    assertEquals(day, 15);
    assertEquals(month, 11);
    assertEquals(year, 2018);
    assertEquals(title, "Doctor");
    assertEquals(description, "Appointment at doctor");
    assertEquals(email, "sj@sj.com");
    assertTrue(valid);
    assertTrue(appt0.hasTimeSet());

    assertNotEquals(0, month);
    assertNotEquals(13, month);
    assertTrue(hour > 11);
  }
  
  @Test(timeout = 4000)
  public void test03() throws Throwable 
  {
    Appt appt0 = new Appt(12, 30, 15, 11, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    assertTrue(appt0.isOn(15, 11, 2018));
  }

  @Test(timeout = 4000)
  public void test04() throws Throwable 
  {
    Appt appt0 = new Appt(15, 11, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    assertFalse(appt0.hasTimeSet());
  }

  @Test(timeout = 4000)
  public void test05() throws Throwable 
  {
    Appt appt0 = new Appt(15, 1, 2018, null, null, null);
    assertEquals("", appt0.getDescription());
    assertEquals("", appt0.getTitle());
    assertEquals("", appt0.getEmailAddress());
    assertEquals(1, appt0.getStartMonth());
  }

  @Test(timeout = 4000)
  public void test06() throws Throwable 
  {
    Appt appt8 = new Appt(12, 30, 5, 0, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt8.setValid();
    appt8.setStartMonth(2);
    assertFalse(appt8.getStartMonth() < 1);
    assertFalse(appt8.getValid());
  }
  @Test(timeout = 4000)
  public void test07()  throws Throwable  
  {
    Appt appt8 = new Appt(12, 30, 5, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    assertNull(appt8.getXmlElement());
  }

  @Test(timeout = 4000)
  public void test08() throws Throwable 
  {
    Appt appt8 = new Appt(0, 30, 5, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt8.setValid();
    assertTrue(appt8.getValid());
    Appt appt7 = new Appt(23, 30, 5, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt7.setValid();
    assertTrue(appt7.getValid());

  }

  @Test(timeout = 4000)
  public void test09() throws Throwable 
  {
    Appt appt8 = new Appt(12, 0, 5, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt8.setValid();
    assertTrue(appt8.getValid());
    Appt appt7 = new Appt(12, 59, 5, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt7.setValid();
    assertTrue(appt7.getValid());

  }

  @Test(timeout = 4000)
  public void test10() throws Throwable 
  {
    int startYear  = 2018;
    int startMonth = 1;
    int NumDaysInMonth = CalendarUtil.NumDaysInMonth(startYear, startMonth - 1);
    //test boundary where day = 1
    Appt appt8 = new Appt(12, 30, 1, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt8.setValid();
    assertTrue(appt8.getValid());
    //test boundary where day = numdaysinmonth
    Appt appt7 = new Appt(12, 30, NumDaysInMonth, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt7.setValid();
    assertTrue(appt7.getValid());
  }

  @Test(timeout = 4000)
  public void test11() throws Throwable 
  {
    Appt appt8 = new Appt(12, 30, 15, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    int[] recurringDays = new int[1];
    recurringDays[0] = 1;
    appt8.setRecurrence(recurringDays, Appt.RECUR_BY_WEEKLY, 10, 10);
    assertEquals(appt8.getRecurIncrement(), 10);
    assertEquals(appt8.getRecurNumber(), 10);
  }

  @Test(timeout = 4000)
  public void test12() throws Throwable 
  {
    Appt appt8 = new Appt(12, 30, 15, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    assertNotNull(appt8.getRecurDays());
    
  }

  @Test(timeout = 4000)
  public void test13() throws Throwable 
  {
    Appt appt8 = new Appt(11, 00, 15, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com");
    appt8.setValid();
    String testString = appt8.toString();
    assertEquals(testString, appt8.toString());
  }

  @Test(timeout = 4000)
  public void test14() throws Throwable 
  {
    Appt appt8 = new Appt(11, 00, 15, 1, 2018, "Doctor", "Appointment at doctor", "sj@sj.com"); 
    //wrong day and month but right year shoudl return false;
    assertFalse(appt8.isOn(12, 3, 2018));
    assertTrue(appt8.isOn(15,1,2018));
  }

  @Test(timeout = 4000)
  public void test15() throws Throwable 
  {
    int days = CalendarUtil.NumDaysInMonth(2018, 0);
    assertEquals("Jan", 31, days);
    days = CalendarUtil.NumDaysInMonth(2018, 1);
    assertEquals("Feb", 28, days);
    days = CalendarUtil.NumDaysInMonth(2016, 1);
    assertEquals("Feb_l", 29, days);
    days = CalendarUtil.NumDaysInMonth(2016, 2);
    assertEquals("Feb_l", 31, days);
    days = CalendarUtil.NumDaysInMonth(2018, 11);
    assertEquals("Dec", 31, days);
    
    boolean leap = CalendarUtil.IsLeapYear(2018);
    assertFalse("l 2018", leap);
    leap = CalendarUtil.IsLeapYear(2016);
    assertTrue("l 2016", leap);
    leap = CalendarUtil.IsLeapYear(2000);
    assertTrue("l 2000", leap);
    leap = CalendarUtil.IsLeapYear(1900);
    assertFalse("l 1900", leap);
  }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
    Appt appt1 = new Appt(15, 30, 9, 4, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertEquals("Min", 30, appt1.getStartMinute());
    assertEquals("Hour", 15, appt1.getStartHour());
    assertEquals("Day", 9, appt1.getStartDay());
    assertEquals("Month", 4, appt1.getStartMonth());
    assertEquals("Year", 2018, appt1.getStartYear());
    assertEquals("Title", "Birthday Party", appt1.getTitle());
    assertEquals("Desc", "This is my birthday party", appt1.getDescription());
    assertEquals("Email", "xyz@gmail.com", appt1.getEmailAddress());
    assertTrue("Time", appt1.hasTimeSet());
    assertTrue("True Occur", appt1.isOn(9, 4, 2018));
    assertFalse("False Occur 1", appt1.isOn(10, 14, 2018));
    assertFalse("False Occur 2", appt1.isOn(9, 15, 2018));
    assertFalse("False Occur 3", appt1.isOn(9, 14, 2019));
    appt1.setValid();
    assertTrue("Is Valid", appt1.getValid());
    assertFalse("No Recur", appt1.isRecurring());
  }

   @Test(timeout = 4000)
    public void test17()  throws Throwable {
    // initliaze test attributes
    int startDay = 14;
    int startMonth = 9;
    int startYear = 2018;
    String title = null;
    String description = null;
    String emailAddress = null;
    // create appointment with attributes
    Appt appt1 = new Appt(startDay, startMonth, startYear, title, description, emailAddress);
    // test alt constructor worked properly
    assertEquals(14, appt1.getStartDay());
    assertEquals(9, appt1.getStartMonth());
    assertEquals(2018, appt1.getStartYear());
    // use set methods
    appt1.setStartHour(10);
    appt1.setStartMinute(15);
    appt1.setStartDay(20);
    appt1.setStartMonth(5);
    appt1.setStartYear(2019);
    appt1.setTitle("Test Title");
    appt1.setDescription("Test Description");
    appt1.setXmlElement(null);
    appt1.setValid();
    // test set methods
    assertNull(appt1.getXmlElement());
    assertTrue(appt1.getValid());
    assertEquals(15, appt1.getStartMinute());
    assertEquals(20, appt1.getStartDay());
    assertEquals(5, appt1.getStartMonth());
    assertEquals(2019, appt1.getStartYear());
    assertEquals("Test Description", appt1.getDescription());
    /*
    These last two tests will fail because of a bug I introduced from assignment-1
    */
    assertEquals("Test Title", appt1.getTitle());
    assertEquals(10, appt1.getStartHour());
  }

}


