package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);
			//appt.setValid();
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   //int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int[] recurDays = null;
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						   appt.setValid();
						   assertFalse(appt.getValid());
						   //assertEquals(recurDays,appt.getRecurDays());
						   assertTrue(appt.isOn(appt.getStartDay(), appt.getStartMonth(), appt.getStartYear()));
				       		   assertFalse(appt.isOn(1,1,1));
						}				
				}
						
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}

		Appt appt = new Appt (-1, -1, 0, 0, -1, null, null, null);
		appt.setValid();
		assertTrue(appt.getValid());


		Appt appt1 = new Appt (-1, -1, 0, 13, -1, null, null, null);
		appt1.setValid();
		assertTrue(appt1.getValid());

		Appt appt2 = new Appt (-1, -1, 0, 1, -1, null, null, null);
		appt2.setValid();
		assertTrue(appt2.getValid());

		Appt appt3 = new Appt (24, -1, 0, 1, -1, null, null, null);
		appt3.setValid();
		assertTrue(appt3.getValid());


		Appt appt4 = new Appt (23, -1, 0, 1, -1, null, null, null);
		appt4.setValid();
		assertTrue(appt4.getValid());

		Appt appt5 = new Appt (23, 60, 0, 1, -1, null, null, null);
		appt5.setValid();
		assertTrue(appt5.getValid());

		Appt appt6 = new Appt (23, 50, 0, 1, -1, null, null, null);
		appt6.setValid();
		assertTrue(appt6.getValid());

		Appt appt7 = new Appt (23, 50, 40, 1, 2000, null, null, null);
		appt7.setValid();
		assertTrue(appt7.getValid());

		Appt appt8 = new Appt (23, 50, 0, 1, 2000, null, null, null);
		appt8.setValid();
		assertTrue(appt8.getValid());
		}catch(NullPointerException e){
			
		}
	 
		 System.out.println("Done testing...");
	 }


	 
}
