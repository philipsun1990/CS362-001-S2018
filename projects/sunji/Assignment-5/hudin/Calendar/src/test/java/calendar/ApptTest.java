/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

@Test(timeout = 4000)
 public void test01()  throws Throwable  {
   int startHour=21;
   		 int startMinute=30;
   		 int startDay=15;
   		 int startMonth=01;
   		 int startYear=2018;
   		 String title="Birthday Party";
   		 String description="This is my birthday party.";
       String emailAddress="ABC@gmail.com";
   		 //Construct a new Appointment object with the initial data
   		 Appt appt = new Appt(startHour,
   		          startMinute ,
   		          startDay ,
   		          startMonth ,
   		          startYear ,
   		          title,
   		         description,
               emailAddress);
   		 appt.toString();

   	// assertions
      assertTrue(appt.hasTimeSet());
      assertNull(appt.getXmlElement());
      assertNotNull(appt.getRecurDays());
      assertFalse(appt.isRecurring());
      assertNotNull(appt.isRecurring());
      assertTrue(appt.isOn(15,01,2018));
   		 assertTrue(appt.getValid());
       assertNotNull(appt.getTitle());
   		 assertEquals(21, appt.getStartHour());
   		 assertEquals(30, appt.getStartMinute());
   		 assertEquals(15, appt.getStartDay());
   		 assertEquals(01, appt.getStartMonth());
   		 assertEquals(2018, appt.getStartYear());
   		 assertEquals("Birthday Party", appt.getTitle());
   		 assertEquals("This is my birthday party.", appt.getDescription());
       assertEquals("ABC@gmail.com",appt.getEmailAddress());

       int recurdays[] = null;
		int recurby = 1;
		int recurinc = 1;
		int recurnnum= 1;
		appt.setRecurrence(recurdays, recurby, recurinc, recurnnum);
		appt.isRecurring();

		// assertions
    appt.setValid();
		assertTrue(appt.getValid());
}


@Test
 public void test05()  throws Throwable  {
	 int startHour=0;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title=null;
	 String description=null;
	 int[] recurringDays = null;

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);
// assertions
assertEquals(true, appt.getValid());
appt.setRecurrence(recurringDays, 2, 0, 0);
assertEquals(2, appt.getRecurBy());
assertEquals(0, appt.getRecurIncrement());
assertEquals(0, appt.getRecurNumber());
assertNotNull(appt.getRecurDays());
}

@Test
 public void test06()  throws Throwable  {
	 int startHour=21;
	int startMinute=-5;
	int startDay=15;
	int startMonth=01;
	int startYear=2018;
	String title="";
	String description="";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	assertEquals(true, appt.getValid());
}

@Test
 public void test08()  throws Throwable  {
	 int startHour=21;
	 int startMinute=60;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	assertEquals(true, appt.getValid());
}

@Test
 public void test09()  throws Throwable  {
	 int startHour=21;
	 int startMinute=30;
	 int startDay=0;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	assertEquals(true, appt.getValid());
}


@Test
 public void test12()  throws Throwable  {
	 int startHour=3;
	 int startMinute=0;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);


		int startMinute2=59;
		Appt appt2 = new Appt(startHour,
			 				startMinute2 ,
			 				startDay ,
			 				startMonth ,
			 			  startYear ,
			 				title,
			 				description,
              emailAddress);

    int startMinute3=15;
		int startDay2=1;

		Appt appt3 = new Appt(startHour,
					 					 startMinute3 ,
					 					 startDay2 ,
					 					 startMonth ,
					 					 startYear ,
					 					 title,
					 					description,
                    emailAddress);


		int startDay3=CalendarUtil.NumDaysInMonth(startYear,startMonth-1);

		Appt appt4 = new Appt(startHour,
							 startMinute3 ,
							 startDay3 ,
							 startMonth ,
							 startYear ,
							 title,
							description,
              emailAddress);

 	int startMonth2=12;

	Appt appt5 = new Appt(startHour,
					 	startMinute3 ,
					  startDay ,
					  startMonth2 ,
					 	startYear ,
					 	title,
					 description,
           emailAddress);

	assertEquals(true, appt.getValid());
	assertEquals(true, appt2.getValid());
	assertEquals(true, appt3.getValid());
	assertEquals(true, appt4.getValid());
	assertEquals(true, appt5.getValid());

 appt.setStartMinute(startMinute);
 appt2.setStartMinute(startMinute2);
 appt3.setStartDay(startDay2);
 appt4.setStartDay(startDay3);
 appt5.setStartMonth(startMonth2);

}


@Test
 public void test14()  throws Throwable  {
	 int startHour=11;
	 int startMinute=30; //change invalid minute lower bound
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);

	appt.setStartHour(-1);
  assertEquals(true, appt.getValid());
}


@Test
 public void test15()  throws Throwable  {
	 int startHour=11;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);
appt.setStartMinute(-1);
assertEquals(true, appt.getValid());
}

@Test
 public void test16()  throws Throwable  {
	 int startHour=11;
	 int startMinute=30;
	 int startDay=15;
	 int startMonth=01;
	 int startYear=2018;
	 String title="Birthday Party";
	 String description="This is my birthday party.";

  String emailAddress="ABC@gmail.com";

  Appt appt = new Appt(startHour,
           startMinute ,
           startDay ,
           startMonth ,
           startYear ,
           title,
          description,
          emailAddress);
appt.setStartDay(-1);
assertEquals(true, appt.getValid());
}//end test16 function
@Test
 public void test04()  throws Throwable  {
   Appt appt8 = new Appt(15, 30, 9, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt8.setValid();
   assertTrue(appt8.getValid());
   Appt appt9 = new Appt(15, 30, 9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt9.setValid();
   assertTrue(appt9.getValid());
   Appt appt10 = new Appt(0, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt10.setValid();
   assertTrue(appt10.getValid());
   Appt appt11 = new Appt(23, 30, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt11.setValid();
   assertTrue(appt11.getValid());
   Appt appt12 = new Appt(15, 0, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt12.setValid();
   assertTrue(appt12.getValid());
   Appt appt13 = new Appt(15, 59, 9, 10, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt13.setValid();
   assertTrue(appt13.getValid());
   Appt appt14 = new Appt(15, 30, 9, 10, 0, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt14.setValid();
   assertFalse(appt14.getValid());
   Appt appt15 = new Appt(15, 30, 31, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt15.setValid();
   assertTrue(appt15.getValid());
   Appt appt16 = new Appt(15, 30, 1, 1, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
   appt16.setValid();
   assertTrue(appt16.getValid());
}
}
