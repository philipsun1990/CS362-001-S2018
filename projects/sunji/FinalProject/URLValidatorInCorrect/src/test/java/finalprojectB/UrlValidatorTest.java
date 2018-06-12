
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
   //You can use this function to implement your manual testing	   
     UrlValidator url = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
     //valid URLS
     assertTrue(url.isValid("http://www.google.com"));
     assertTrue(url.isValid("http://google.com"));
     //FAILURE:  assertTrue(url.isValid("google.com"));
     //ERROR:    assertTrue(url.isValid("https://www.google.com/search?q=pie&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiRhp7M1rPbAhWtHjQIHbUfB34Q_AUICigB&biw=1536&bih=700&dpr=1.25#imgrc=Ml01ptT80Q0DCM"));
     //ERROR:    assertTrue(url.isValid("ftp://www.example.com"));
     
     //invalid URLS
     assertFalse(url.isValid("hslgkjslguiod"));
     assertFalse(url.isValid("something@this@you"));
     assertFalse(url.isValid(""));
     //ERROR:    assertFalse(url.isValid("htp://google.com"));
     //FAILURE:  assertFalse(url.isValid("http://google..com"));
     assertFalse(url.isValid("textfile.txt"));
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	

        UrlValidator urlVal = new UrlValidator();

        //Min & max ports
        assertFalse("https://www.google.com:0/1/2/3/4",urlVal.isValid("https://www.google.com:0/1/2/3/4"));
        assertFalse("http://6.5.4.3:65535/?h=j", urlVal.isValid("http://6.5.4.3:65535/?h=j")); //changed

        //Min & max IP's
        assertFalse(urlVal.isValid("http://0.0.0.0"));
        assertFalse(urlVal.isValid("http://255.255.255.255"));
   
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	  

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Second Partition Testing: authorities");

      UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String baseUrl = "http://";

      for (int i=0;i<testUrlAuthority.length;i++) {
            String testUrl = baseUrl + testUrlAuthority[i].item;
            boolean res = uVal.isValid(testUrl);
            //assertEquals(testUrlAuthority[i].valid, res);
            if(res == testUrlAuthority[i].valid){
               System.out.println(testUrl + " Passed authorities test");
            }else{
               System.out.println(testUrl + " Failed authorities test");
            }
         }
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
   }
   //You need to create more test cases for your Partitions if you need to 
   
      public void testYourThirdPartition(){
      //Test URL Port
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Third Partition Testing: ports");

      UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String baseUrl = "http://www.google.com";

      for (int i=0;i<testUrlPort.length;i++) {
            String testUrl = baseUrl + testUrlPort[i].item;
            boolean res = uVal.isValid(testUrl);
            //assertEquals(testUrlPort[i].valid, res);
            if(res == testUrlPort[i].valid){
               System.out.println(testUrl + " Passed ports test");
            }else{
               System.out.println(testUrl + " Failed ports test");
            }
         }
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
   }
   
   public void testYourFourthPartition(){
      //Test URL Path
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Fourth Partition Testing: paths");

      UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String baseUrl = "http://www.google.com";

      for (int i=0;i<testPath.length;i++) {
            String testUrl = baseUrl + testPath[i].item;
            boolean res = uVal.isValid(testUrl);
            //assertEquals(testPath[i].valid, res);
            if(res == testPath[i].valid){
               System.out.println(testUrl + " Passed path test");
            }else{
               System.out.println(testUrl + " Failed path test");
            }
         }
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
   }
   
   public void testYourFifthPartition(){
      //Test URL Query
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("Fifth Partition Testing: queries");

      UrlValidator uVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      String baseUrl = "http://www.google.com";

      for (int i=0;i<testUrlQuery.length;i++) {
            String testUrl = baseUrl + testUrlQuery[i].item;
            boolean res = uVal.isValid(testUrl);
            //assertEquals(testUrlQuery[i].valid, res);
            if(res == testUrlQuery[i].valid){
               System.out.println(testUrl + " Passed query test");
            }else{
               System.out.println(testUrl + " Failed query test");
            }
         }
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   }

   public void testIsValid()
   {
	   //You can use this function for programming based testing

        String schemes[] = new String[5];
        schemes[0]= "";
        schemes[1]= "http://";
        schemes[2]= "http:";
        schemes[3]= "ftp://";
        schemes[4]= "fdslgn";


         String authority[] = new String[5];
         authority[0]= "";
         authority[1]= "www.google.com";
         authority[2]= "twitch.tv";
         authority[3]= "fdslgiog";
         authority[4]= "12ab.3c";

         String port[] = new String[4];
         port[0]= "";
         port[1]= ":0";
         port[2]= ":ljiowrg";
         port[3]= ":-1";

         String path[] = new String[4];
         path[0]= "/";
         path[1]= "/abc123";
         path[2]= "stuff";
         path[3]= "gsdjkgoi";

         String query[] = new String[3];
         query[0]= "";
         path[1]= "@#garbage";
         path[2]= "!@#dsbgsr";
         
         UrlValidator url = new UrlValidator(schemes, null, UrlValidator.ALLOW_ALL_SCHEMES);
         
         String testUrl;
         boolean result;
         int counter = 0;
         
         for(int i = 0; i < 5; i++ ) {
           for(int j = 0; j < 5; j++) {
             for(int k = 0; k < 4; k++) {
               for(int l = 0; l < 4; l++) {
                 for(int m = 0; m < 3; m++) {
                   counter++;
                   
                   testUrl = schemes[i] + authority[j] + port[k] + path[l] + query[m];
                   
                   if(i < 5 && j < 5 && k < 4 && l < 4 && m < 3) {
                    // result = url.isValid(testUrl);
                     System.out.print(testUrl);
                     System.out.print("\t\t\t");
                   //  System.out.print(result);
                     System.out.print("\n");
                   }
                   System.out.print(counter);
                 }
               }
             }
           }
         }


   }

   
   
   /*
    * main() method runs the tests on UrlValidator.isValid()
    * 
    * args[1] == true sets printStatus = true
    * args[2] == true sets printIndex = true
    */
   public static void main(String args[])
   {
      UrlValidatorTest test = new UrlValidatorTest("Url Test");
      
      if(args.length > 1 && (args[1].toLowerCase()).equals("true"))
         test.printStatus = true;
      if(args.length > 2 && (args[2].toLowerCase()).equals("true"))
         test.printIndex = true;
      
      test.testManualTest();
      test.testYourFirstPartition();
      test.testYourSecondPartition();
      test.testYourThirdPartition();
      test.testYourFourthPartition();
      test.testYourFifthPartition();
      test.testIsValid();
      
   }



   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
                           new ResultPair("https://", true),
                               new ResultPair("ftp://", true),
                               new ResultPair("h3t://", true),
                               new ResultPair("3ht://", false),
                               new ResultPair("http:/", false),
                               new ResultPair("http:///", false),
                               new ResultPair("123http:/", false),
                               new ResultPair("http:/", false),
                               new ResultPair("--http://", false),
                               new ResultPair(".http+/", false),
                               new ResultPair("http:", false),
                               new ResultPair("http/", false),
                               new ResultPair("://", false),
                               new ResultPair("", true)};

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
                             new ResultPair("www.amazon.com", true),
                             new ResultPair("oregonstate.edu", true),
                                  new ResultPair("go.com", true),
                                  new ResultPair("go.au", true),
                                  new ResultPair("0.0.0.0", true),
                                  new ResultPair("255.255.255.255", true),
                                  new ResultPair("256.256.256.256", false),
                                  new ResultPair("256.0.256.1", false),
                                  new ResultPair("amazon", false),
                                  new ResultPair("amazon com", false),
                                  new ResultPair("255.com", true),
                                  new ResultPair("1.2.3.4.5", false),
                                  new ResultPair("1.2.3.4.", false),
                                  new ResultPair("1.2.3", false),
                                  new ResultPair(".1.2.3.4", false),
                                  new ResultPair("1....2.3.4.", false),
                                  new ResultPair("beavers.gov", true),
                                  new ResultPair("foo.cn", true),
                                  new ResultPair("user@foo.gov", true),
                                  new ResultPair("255", false),
                                  new ResultPair("go.a", false),
                                  new ResultPair("go.a1a", false),
                                  new ResultPair("go.cc", true),
                                  new ResultPair("go.1aa", false),
                                  new ResultPair("aaa.", false),
                                  new ResultPair(".aaa", false),
                                  new ResultPair("aaa", false),
                                  new ResultPair("", false)
   };

   ResultPair[] testUrlPort = {new ResultPair(":80", true),
                             new ResultPair(":65535", true),
                             new ResultPair(":8080", true),
                             new ResultPair(":0", true),
                             new ResultPair("", true),
                             new ResultPair(":-1", false),
                             new ResultPair(":65636", true),
                             new ResultPair(":65a", false),
                             new ResultPair(":ABC", false),
   };

   ResultPair[] testPath = {new ResultPair("/test1", true),
                          new ResultPair("/t123", true),
                          new ResultPair("/$23", true),
                          new ResultPair("/..", false),
                          new ResultPair("/../", false),
                          new ResultPair("/test1/", true),
                          new ResultPair("", true),
                          new ResultPair("/test1/file", true),
                          new ResultPair("/..//file", false),
                          new ResultPair("/test1//file", false)
   };
   

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
                              new ResultPair("?action=edit&mode=up", true),
                              new ResultPair("", true)
   };

}
