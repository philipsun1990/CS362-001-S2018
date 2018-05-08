/** A JUnit test class to test the class CalDay. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import java.util.*;


public class CalDayTest
{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  
  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    Appt appt0 = new Appt(12, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    Appt appt1 = new Appt(0, 9, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    day.addAppt(appt0);
    day.addAppt(appt1);
    day.getAppts();
    day.getSizeAppts();
    day.getFullInfomrationApp(day);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  
  {
    CalDay day = new CalDay();
    day.iterator();
    day.toString();
  }

  @Test(timeout = 4000)
  public void test02() throws Throwable 
  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    Appt appt0 = new Appt(13, 30, 27, 12, 2018, "Doctor", "Appointment at doctor", "dj@dj.com");
    Appt appt1 = new Appt(12, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(11, 30, 27, -1, 2018, "Birthday Party", "Party!!", "dj@dj.com");  
    appt0.setValid();
    appt1.setValid();
    appt2.setValid();
    assertTrue(appt0.getValid());
    assertTrue(appt1.getValid());
    assertFalse(appt2.getValid());
    day.addAppt(appt0);
    day.addAppt(appt1);
    day.addAppt(appt2);
    assertTrue(day.isValid());
    assertEquals(cal.get(cal.DAY_OF_MONTH), day.getDay());
    assertEquals(cal.get(cal.MONTH)+1, day.getMonth());
    assertTrue(day.appts.contains(appt0));
    assertTrue(day.appts.contains(appt1));
    assertFalse(day.appts.contains(appt2));
    assertEquals(day.getSizeAppts(), 2);
    assertEquals(day.getYear(), 2019);
    String test_string = day.toString();
    assertEquals(day.toString(), test_string);
  }

  @Test(timeout = 4000)
  public void test03() throws Throwable 
  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    Appt appt1 = new Appt(13, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);
    LinkedList<Appt> appts = day.getAppts();
    assertEquals(appts.get(0), appt3);
    assertEquals(appts.get(1), appt2);
    assertEquals(appts.get(2), appt1);
  }

  @Test(timeout = 4000)
  public void test04() throws Throwable 
  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    Appt appt1 = new Appt(12, 31, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 30, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);
    LinkedList<Appt> appts = day.getAppts();
    assertEquals(appts.get(0), appt3);
    assertEquals(appts.get(1), appt1);
    assertEquals(appts.get(2), appt2);
  }
  
  @Test(timeout = 4000)
  public void test05() throws Throwable 
  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    assertNotNull(day.getAppts());

  }

  @Test(timeout = 4000)
  public void test06() throws Throwable 
  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    Appt appt1 = new Appt(12, 31, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 10, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 1, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);
    assertTrue(appt1.hasTimeSet());
    assertTrue(appt2.hasTimeSet());
    assertTrue(appt3.hasTimeSet());
    String buffer1 = day.getFullInfomrationApp(day);
    assertNotNull(buffer1);
    Iterator itr = ((CalDay) day).iterator();
    String buffer;
    buffer = Integer.toString(((CalDay) day).getMonth()) + "-";
    buffer += Integer.toString(((CalDay) day).getDay()) + "-";
    buffer += Integer.toString(((CalDay) day).getYear()) + " ";
    Appt appointment;
    int minute;
    int hour;
    String minString;
    String meridianString;
    while (itr.hasNext()) 
    {
      buffer += "\n\t";
      appointment = (Appt) itr.next();
      if (appointment.hasTimeSet()) 
      {
        hour = appointment.getStartHour();
        if (hour > 12) 
        {
          meridianString = "PM";
        } 
        else 
        {
          meridianString = "AM";
        }
        if (hour == 0) 
        {
          hour = 12;
        } 
        else 
        {
          hour = hour % 12;
        }
        minute = appointment.getStartMinute();
        if (minute < 10) 
        {
          minString = new String("0" + Integer.toString(minute));
        } 
        else 
        {
          minString = Integer.toString(minute);
        }
        buffer += hour + ":" + minString + meridianString + " ";
      }
      buffer += appointment.getTitle() + " ";
      buffer += appointment.getDescription() + " ";
    }
    assertEquals(buffer1, buffer);   
  }

  @Test(timeout = 4000)
  public void test07() throws Throwable 
  {
    GregorianCalendar cal = new GregorianCalendar(2018, 12, 27);
    CalDay day = new CalDay(cal);
    Appt appt1 = new Appt(12, 31, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt2 = new Appt(12, 10, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    Appt appt3 = new Appt(11, 1, 27, 12, 2018, "Birthday Party", "Party!!", "dj@dj.com");
    day.addAppt(appt1);
    day.addAppt(appt2);
    day.addAppt(appt3);
    String test = day.toString();
    assertNotNull(test);
    StringBuilder sb = new StringBuilder();
    if (day.isValid()) 
    {
      String todayDate = (day.getMonth() + 1) + "/" + day.getDay() + "/" + day.getYear();
      sb.append("\t --- " + todayDate + " --- \n");
      sb.append(" --- -------- Appointments ------------ --- \n");
      Iterator<Appt> itr = day.getAppts().iterator();
      while (itr.hasNext()) {
        Object element = itr.next();
        sb.append(element + " ");
      }
      sb.append("\n");
    }
    String test2 = sb.toString();
    assertEquals(test, test2);
  }

    @Test(timeout = 4000)
  public void test08()  throws Throwable  
  {
      GregorianCalendar someday = new GregorianCalendar(2018, 5, 10);
      CalDay day0 = new CalDay(someday);
      Appt appt0 = new Appt(7, 6, 2018, "Meeting No Time", "This is a meeting with no set time.", "work@gmail.com");
      Appt appt1 = new Appt(0, 5, 7, 6, 2018, "Meeting Early Morning", "This is a meeting.", "work@gmail.com");
      Appt appt2 = new Appt(20, 10, 7, 6, 2018, "Meeting Late At Night", "This is a meeting.", "work@gmail.com");
      day0.addAppt(appt0);
      day0.addAppt(appt1);
      day0.addAppt(appt2);
      String string0 = day0.getFullInfomrationApp(day0);
      assertEquals("6-10-2018 \n\tMeeting No Time This is a meeting with no set time. \n\t12:05AM Meeting Early Morning This is a meeting. \n\t8:10PM Meeting Late At Night This is a meeting. ", string0);
  }
  @Test(timeout = 4000)
  public void test09()  throws Throwable  
  {
      DataHandler datahandler = new DataHandler();
      GregorianCalendar calendar = new GregorianCalendar(2020, 4, 20);
      CalDay calDays1 = new CalDay(calendar);
      Appt appt0 = new Appt(15, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      calDays1.addAppt(appt0);
      calDays1.getFullInfomrationApp(calDays1);
      assertEquals(1, calDays1.getSizeAppts());
      String string1 = calDays1.toString();
  }
  @Test(timeout = 4000)
  public void test10()  throws Throwable  
  {
      GregorianCalendar someday = new GregorianCalendar(2018, 5, 10);
      CalDay day0 = new CalDay(someday);
      Appt appt0 = new Appt(7, 6, 2018, "Meeting No Time", "This is a meeting with no set time.", "work@gmail.com");
      Appt appt1 = new Appt(0, 5, 7, 6, 2018, "Meeting Early Morning", "This is a meeting.", "work@gmail.com");
      Appt appt2 = new Appt(20, 10, 7, 6, 2018, "Meeting Late At Night", "This is a meeting.", "work@gmail.com");
      day0.addAppt(appt0);
      day0.addAppt(appt1);
      day0.addAppt(appt2);
      String string0 = day0.getFullInfomrationApp(day0);
      assertEquals("6-10-2018 \n\tMeeting No Time This is a meeting with no set time. \n\t12:05AM Meeting Early Morning This is a meeting. \n\t8:10PM Meeting Late At Night This is a meeting. ", string0);
  }

    @Test(timeout = 4000)
    public void test11()  throws Throwable  
  {
    int sDay = 9;
    int sMonth = 4;
    int sYear = 2018;
    Appt appt0 = new Appt(15, 30, sDay, sMonth, sYear, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
    assertTrue("Appt Valid", appt0.getValid());
    GregorianCalendar testDay = new GregorianCalendar(sYear, sMonth, sDay);
    CalDay calday0 = new CalDay(testDay);
    calday0.addAppt(appt0);
    assertTrue("calday Valid", calday0.isValid());
    assertEquals("Num Appts", 1, calday0.getSizeAppts());
    assertEquals("Day", sDay, calday0.getDay());
    String strOut = calday0.getFullInfomrationApp(calday0);
    String strTest = "5-9-2018 \n\t3:30PM Birthday Party This is my birthday party ";
    System.out.println(strOut);
    System.out.println(strTest);
    assertEquals("Compare output with test", strTest, strOut);   
    Appt appt2 = new Appt(10, 5, sDay, sMonth, sYear, "Test 3", "Testing calday", "xyz@gmail.com");
    assertTrue("Appt2 Valid", appt2.getValid());
    calday0.addAppt(appt2);
    assertEquals("Num Appts3", 2, calday0.getSizeAppts());
    assertTrue("calday Valid", calday0.isValid());
  }
}
