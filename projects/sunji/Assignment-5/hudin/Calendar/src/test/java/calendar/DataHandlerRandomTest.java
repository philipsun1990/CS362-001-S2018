package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;
import org.w3c.dom.Element;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	     @Test
    public void randomtest01() throws Throwable {
        for(int i=0; i<2; i++){
        DataHandler dh=new DataHandler("TESTERONI",i==0);
        for(int k=0; k<60; k++){
            int startDay = ValGen.RandInt(1,37);
            int startMonth = ValGen.RandInt(1,16);
            int startYear = 2018;
            String title = "Birthday Party";
            String description = "This is my birthday party.";
            String emailAddress = "xyz@gmail.com";
            int startHour = ValGen.RandInt(11, 1);
            int startMinute = ValGen.RandInt(62,1);
            Appt appt = new Appt(startHour, startMinute, startDay, startMonth, 
                startYear, title, description, emailAddress
            );
            dh.saveAppt(appt);

            if(k%5==0){
                if(k%3==0){
                    appt.setXmlElement(null);
                }
                dh.deleteAppt(appt);
            }
        }
    }
    }

    @Test
    public void randomtest02() throws Throwable {
        for(int i=0; i<2; i++){
            DataHandler dh=new DataHandler("TESTERONI",i==0);
            for(int k=0; k<60; k++){            
                int startDay = ValGen.RandInt(1,37);
                int startMonth = ValGen.RandInt(1,16);
                int startYear = 2018;
                String title = "Birthday Party";
                String description = "This is my birthday party.";
                String emailAddress = "xyz@gmail.com";
                int startHour = ValGen.RandInt(11, 1);
                int startMinute = ValGen.RandInt(62,1);
                Appt appt = new Appt(startHour, startMinute, startDay, startMonth, 
                    startYear, title, description, emailAddress
                );
                if(ValGen.RandInt(10, 0)==0){
                    appt.setXmlElement(null);
                }

                dh.saveAppt(appt);
                if(k%30==0){
                        dh.deleteAppt(appt);
                }
                appt.setValid();
                if(!appt.getValid()){
                    
                    dh.deleteAppt(appt);
                }
                try{
                    dh.getApptRange(new GregorianCalendar(2018, ValGen.RandInt(12,1), ValGen.RandInt(31,1)), 
                        new GregorianCalendar(2018, ValGen.RandInt(12, 1), ValGen.RandInt(31, 1)));
                }
                catch(Exception e){

                }
                
            }
        }
    }
	 @Test
	  public void radnomtest03()  throws Throwable  {

		DataHandler dh = new DataHandler("fileName");
		DataHandler dh1 = new DataHandler("fileName2");
		long randomseed = System.currentTimeMillis();
		Random random = new Random(randomseed);

		for (int i = 0; i < 100; i++) {
			int year = ValuesGenerator.getRandomIntBetween(random,2018,2018);
			int day = ValuesGenerator.getRandomIntBetween(random, 0,30);
			int month = ValuesGenerator.getRandomIntBetween(random, 0,14);
			int hour = ValuesGenerator.getRandomIntBetween(random, 0,14);
			int min = ValuesGenerator.getRandomIntBetween(random, 0,90);
			int sec = ValuesGenerator.getRandomIntBetween(random, 0,90);
		
			Appt appt1 = new Appt(hour, min, day, month, year, "HW", "HW Day", "p@gmai.com");

			int[] numArr = {1,2,3,2,3};
			appt1.setRecurrence(numArr, appt1.RECUR_BY_WEEKLY, 3, 3);

			appt1.setValid();

			int year2 = ValuesGenerator.getRandomIntBetween(random,2018,2018);
			int day2 = ValuesGenerator.getRandomIntBetween(random, 0,30);
			int month2 = ValuesGenerator.getRandomIntBetween(random, 0,14);
			int hour2 = ValuesGenerator.getRandomIntBetween(random, 0,14);
			int min2 = ValuesGenerator.getRandomIntBetween(random, 0,90);
			int sec2 = ValuesGenerator.getRandomIntBetween(random, 0,90);
			Appt appt2 = new Appt(hour2, min2, day2, month2, year2, "HW", "HW Day", "p@gmai.com");
			appt2.setValid();

			dh.saveAppt(appt1);
			dh.saveAppt(appt2);	
		
			dh1.saveAppt(appt1);
			dh1.saveAppt(appt2);

			GregorianCalendar apt1 = new GregorianCalendar(year, month, day, hour, min, sec);
			GregorianCalendar apt2 = new GregorianCalendar(year2, month2, day2, hour2, min2, sec2);
			try {
				dh.getApptRange(apt1, apt2);
			}
			catch(Exception e) {
			}
			try {
				dh1.getApptRange(apt1, apt2);
			}
			catch(Exception e) {
			}

			dh.deleteAppt(appt1);
			dh.deleteAppt(appt2);
			dh1.deleteAppt(appt1);
			dh1.deleteAppt(appt2);

	 	}
	}
}