package calendar;


import org.junit.Test;
import java.util.Random;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		long randomseed = System.currentTimeMillis();
		Random random = new Random(randomseed);
		GregorianCalendar cal = new GregorianCalendar(2018, 4, 19, 4, 9, 00);
		CalDay Cday = new CalDay(cal);
		for (int i = 0; i < 100; i++) {
			int year = ValuesGenerator.getRandomIntBetween(random,2018,2018);
			int day = ValuesGenerator.getRandomIntBetween(random, 0,30);
			int month = ValuesGenerator.getRandomIntBetween(random, 0,14);
			int hour = ValuesGenerator.getRandomIntBetween(random, 0,14);
			int min = ValuesGenerator.getRandomIntBetween(random, 0,90);
			int sec = ValuesGenerator.getRandomIntBetween(random, 0,90);
			Appt appt1 = new Appt(hour, min, day, month, year, "HW", "HW Day", "p@gmai.com");
			appt1.setValid();
			Cday.addAppt(appt1);
		} 
	 }
}
