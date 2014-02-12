import java.sql.*;
import java.io.*;
import java.util.Scanner; 
public class TestDemo
{
      Project projectObj = null;
      TestPhase testPhaseObj = null;
      ActivityUser activityUserObj = null;
      User userObj= null;
      static TestCase testCaseObj=null;  
      Activity activityObj=null; 
      Effort effortObj=null;  
      TMSManager tmsManager = null;   
      Date date=null;
  

      public TestDemo() throws Exception
      {
           date=new Date(2010,22,03);   
          projectObj= new Project(); 
          testPhaseObj= new TestPhase();
          activityObj = new Activity();
          userObj = new User();
          activityUserObj = new ActivityUser();
          testCaseObj=new TestCase( );
          effortObj=new Effort();
          tmsManager= new TMSManager();
     }
 /* ---------------------------------------------- CreateTest phase -------------------------------------*/
     public void createTestPhase() throws Exception
     {
           testPhaseObj.setPhaseId("101"); 
           testPhaseObj.setPhaseName("System test");
           projectObj.setProjectId("003");
           testPhaseObj.setProjectObj(projectObj);
           testPhaseObj.setDescription(" this is phase System test");
           testPhaseObj.setIsAlive(0);
           testPhaseObj.setTimeStamp("null");
           System.out.println(tmsManager.createTestPhase(testPhaseObj));
     }
/*--------------------------------------------ViewTestPhase-----------------------------------------*/   
  public void getTestPhase() throws Exception
     {
           testPhaseObj.setPhaseId("101"); 
           TestPhase phaseObj=tmsManager.getTestPhase(testPhaseObj.getPhaseId());
           
           System.out.println("phase_id:  "+phaseObj.getPhaseId());
           System.out.println("phase_name: "+phaseObj.getPhaseName());
           projectObj = phaseObj.getProjectObj();
           System.out.println("project_id: "+projectObj.getProjectId());
           System.out.println("description: "+phaseObj.getDescription());
           System.out.println("is_alive: "+phaseObj.getIsAlive());
           System.out.println("time_stamp: "+phaseObj.getTimeStamp());

      }
/*--------------------------------------------UpdateTestPhase---------------------------------------*/
        public void updateTestPhase() throws Exception
        {
               testPhaseObj.setPhaseId("101"); 
               testPhaseObj.setPhaseName("functional testing");
               projectObj.setProjectId("002");
               testPhaseObj.setProjectObj(projectObj);
               testPhaseObj.setDescription("test phase function test under process");
               testPhaseObj.setIsAlive(1);
               testPhaseObj.setTimeStamp("null");
               System.out.println(tmsManager.updateTestPhase(testPhaseObj));
        }
/*---------------------------------------------DeleteTestPhase------------------------------------------*/
   
     public void deleteTestPhase() throws Exception
        {
             testPhaseObj.setPhaseId("101");
             System.out.println(tmsManager.deleteTestPhase(testPhaseObj.getPhaseId()));
        }
    
 /* ----------------------------------------------Create Test activity-------------------------------------*/
         public void createTestActivity() throws Exception
     {
           
           activityObj.setActivityId("1001"); 
           testPhaseObj.setPhaseId("102");
           activityObj.setTestPhaseObj(testPhaseObj); 
           activityObj.setActivityName("second activity test");
           activityObj.setActivityDescription("activity execution  ");
           activityObj.setActivityType(0);
           Date startDate = new Date(2010,05,07);
           activityObj.setStartDate(startDate);
           Date endDate = new Date(2010,06,10);
           activityObj.setEndDate(endDate);
           activityObj.setActivityEffort(20);
           activityObj.setStatus(1);
           userObj.setEmpNo("001");
           activityObj.setUserObj(userObj);
	java.sql.Date date=java.sql.Date.valueOf("2011-03-28");
           activityObj.setTimeStamp(date);
           System.out.println(tmsManager.createTestActivity(activityObj));
     }
/*---------------------------------------------------VieTestPhase----------------------------*/
     public void getTestActivity() throws Exception
     {
           activityObj.setActivityId("1001"); 

           Activity activityObj1 = tmsManager.getTestActivity(activityObj.getActivityId());           
           System.out.println("activity_id:  "+activityObj1.getActivityId());

           TestPhase testphaseObj1 = activityObj1.getTestPhaseObj();
           System.out.println("phase_id:  "+testphaseObj1.getPhaseId());
           System.out.println("activity_name: "+activityObj1.getActivityName());
           System.out.println("activity_description: "+activityObj1.getActivityDescription());
           System.out.println("activity_type: "+activityObj1.getActivityType());
           System.out.println("start_date: "+activityObj1.getStartDate());
           System.out.println("end_date: "+activityObj1.getEndDate());
           System.out.println("activity_effort: "+activityObj1.getActivityEffort());
           System.out.println("status: "+activityObj1.getStatus());
           userObj = activityObj.getUserObj();
           System.out.println("emp_no: "+userObj.getEmpNo());
           System.out.println("time_stamp: "+activityObj1.getTimeStamp());
      }
/*-------------------------------------UpdateTestActivity-----------------------------------------*/
     public void updateTestActivity() throws Exception
     {
           activityObj.setActivityId("1001"); 
           testPhaseObj.setPhaseId("101"); 
           activityObj.setTestPhaseObj(testPhaseObj);        
           activityObj.setActivityName("first activity test");
           activityObj.setActivityDescription("I am the latest activity to execute ");
           activityObj.setActivityType(1);
           Date startDate = new Date(2010,05,07);
           activityObj.setStartDate(startDate);
           Date endDate = new Date(2010,06,11);
           activityObj.setEndDate(endDate);
           activityObj.setActivityEffort(30);
           activityObj.setStatus(1);
           userObj.setEmpNo("002");
           activityObj.setUserObj(userObj);
	java.sql.Date date1=java.sql.Date.valueOf("2011-03-28");
           activityObj.setTimeStamp(date1);
           System.out.println(tmsManager.updateTestActivity(activityObj));
     }

/*---------------------------------DeleteTestActivity-----------------------------------------*/
      public void deleteTestActivity() throws Exception
        {
             activityObj.setActivityId("1001");
             System.out.println(tmsManager.deleteTestActivity(activityObj.getActivityId()));
        }

 /* ---------------------------------------------- activity assignment-------------------------------------*/

    public void assignActivity() throws Exception
    {
         activityObj.setActivityId("1001");
         activityUserObj.setActivityObj(activityObj);
         userObj.setEmpNo("001");
         activityUserObj.setUserObj(userObj);
         activityUserObj.setActivityEffort(0);
         Date startDate = new Date(2010,05,17);
         activityUserObj.setStartDate(startDate);
         Date endDate = new Date(2010,06,19);
         activityUserObj.setEndDate(endDate);
         activityUserObj.setStatus(0);
         activityUserObj.setPercentageCompleted(0);
         activityUserObj.setTimeStamp("null");
         System.out.println(tmsManager.assignTestActivity(activityUserObj)); 

    }
/*-----------------------------------------ViewAssignment------------------------------------------*/
     public void getActivityAssignment() throws Exception
     {
       activityObj.setActivityId("1001");
       activityUserObj.setActivityObj(activityObj);
       activityObj = activityUserObj.getActivityObj();
       ActivityUser activityUserObj1 = tmsManager.getTestActivityAssignment(activityObj.getActivityId());
       activityObj = activityUserObj1.getActivityObj();
       System.out.println(activityObj.getActivityId());
       activityObj = activityUserObj1.getActivityObj();
       System.out.println("activity_id : "+activityObj.getActivityId());
       userObj = activityUserObj1.getUserObj();
       System.out.println("emp_no : "+userObj.getEmpNo());
       System.out.println("activity_effort : "+activityUserObj1.getActivityEffort());   
       System.out.println("start_date : "+activityUserObj1.getStartDate()); 
       System.out.println("end_date : "+activityUserObj1.getEndDate()); 
       System.out.println("status : "+activityUserObj1.getStatus()); 
       System.out.println("percentage_completed : "+activityUserObj1.getPercentageCompleted()); 
       System.out.println("time_stamp : "+activityUserObj1.getTimeStamp());
     
     }

/*-------------------------------------------update activty assignment----------------------------------------*/

    public void updateActivityAssignment()  throws Exception
    {
         activityObj.setActivityId("1001");
         activityUserObj.setActivityObj(activityObj);
         userObj.setEmpNo("002");
         activityUserObj.setUserObj(userObj);
         activityUserObj.setActivityEffort(0);
         Date startDate = new Date(2010,05,07);
         activityUserObj.setStartDate(startDate);
         Date endDate = new Date(2010,05,10);
         activityUserObj.setEndDate(endDate);
         activityUserObj.setStatus(0);
         activityUserObj.setPercentageCompleted(0);
         activityUserObj.setTimeStamp("null");
         System.out.println(tmsManager.updateTestActivityAssignment(activityUserObj)); 

    }
/* ====================CreateTestCase=========================*/
         
              public void createTestCase() throws Exception
             { 
               testCaseObj.setTestCaseId("15");   
               testCaseObj.setTestCaseDescription("this s Next testcase Description");
               testCaseObj.setTestCasePhase("normal ");
              
              Project projectObj=new Project();
              projectObj.setProjectId("2");
              testCaseObj.setProjectObj(projectObj);
             
             User userObj=new User();
             userObj.setUserId("123");
             testCaseObj.setUserObj(userObj);
             
             Activity activityObj=new Activity(); 
             activityObj.setActivityId("001");
             testCaseObj.setActivityObj(activityObj);                  
               
             testCaseObj.setExpectedBehaviour("Bad") ;
               System.out.println(tmsManager.createTestCase(testCaseObj));
             }
 
/*=====================ViewTestCase==========================   */

         public void getTestCase() throws Exception
           {

                TestCase testCaseObj=tmsManager.getTestCase("15");

                System.out.println(testCaseObj.getTestCaseId());   
                System.out.println( testCaseObj.getTestCaseDescription());
                System.out.println(testCaseObj.getTestCasePhase());
                Project projectObj=testCaseObj.getProjectObj(); 	
                System.out.println(projectObj.getProjectId());   
                User userObj = testCaseObj.getUserObj();
                System.out.println(userObj.getUserId());
                Activity activityObj=testCaseObj.getActivityObj();	
                System.out.println(activityObj.getActivityId());
                System.out.println(testCaseObj.getExpectedBehaviour()) ;
           }

/*=====================updateTestCase=========================*/

          public void updateTestCase() throws Exception  
         {
             testCaseObj.setExpectedBehaviour("Excellent") ;
             testCaseObj.setTestCaseId("15");
             System.out.println(tmsManager.updateTestCase(testCaseObj));
          }

/*=======================deleteTestCase========================*/

          public void deleteTestCase()throws Exception  
         {           
                     testCaseObj.setTestCaseId("15");
                     System.out.println(tmsManager.deleteTestCase(testCaseObj.getTestCaseId()));     
          }
/*====================add execution details=======================*/ 
      
           public void addTestCaseExecutionDetails() throws Exception
           { 
          
               activityObj.setActivityId("001");
               testCaseObj.setActivityObj(activityObj);                                
               
               testCaseObj.setTestCaseId("001");   
      
               userObj.setUserId("12");      
               testCaseObj.setUserObj(userObj); 
              
                           

              testCaseObj.setActualDate(new Date(1970,01,01));   
              testCaseObj.setTestCaseStatus("complete");   
              testCaseObj.setComments("better");   
              testCaseObj.setActualBehaviour("got value");   

                               System.out.println(tmsManager.addTestCaseExecutionDetails(testCaseObj));

             }
 
/*======================ViewTestCaseExecutionDetails================*/

     public void  getTestCaseExecutionDetails() throws Exception
      {
//                testCaseObj.setTestCaseId("001");
                TestCase testCaseObj=tmsManager.getTestCaseExecutionDetails("001");
           
                Activity activityObj=testCaseObj.getActivityObj();	
                System.out.println(activityObj.getActivityId());    
                System.out.println(testCaseObj.getTestCaseId()); 
                User userObj = testCaseObj.getUserObj ();
                System.out.println(userObj.getUserId());
                System.out.println( testCaseObj.getActualDate());

                System.out.println( testCaseObj.getTestCaseStatus());
                System.out.println(testCaseObj.getComments());
                System.out.println(testCaseObj.getActualBehaviour()) ;

       }
/*==========================UpdateExecutionDetails==================*/ 


         public void updateTestCaseExecutionDetails() throws Exception  
         {
             testCaseObj.setTestCaseStatus("Complete") ;
            testCaseObj.setTestCaseId("001") ;
             System.out.println(tmsManager.updateTestCaseExecutionDetails(testCaseObj));
          }

/*========================= AddTestActivityEffort================*/

      public void addTestActivityEffort() throws Exception
      {
          
               activityObj.setActivityId("001");
               effortObj.setActivityObj(activityObj);                       
               userObj.setEmpNo("1");
               effortObj.setUserObj( userObj);
             
               effortObj.setEffortDate(new Date(2010,10,01));

              effortObj.setStartDate(new Date(2010,10,02));
             
              effortObj.setEndDate(new Date(2010,11,01));

              effortObj.setEffort(4);
          
               effortObj.setEffortDescription("I dont Know");

               effortObj.setEffortTimeStamp("2010-11-17");
                              

               System.out.println(tmsManager.addTestActivityEffort(effortObj));

}
/*========================ViewTestCaseActivityEffort==============*/
       
  public void getTestActivityEffort(String activityId) throws Exception
        {
           Effort effortObj=tmsManager.getTestActivityEffort(activityId);

                Activity activityObj=effortObj.getActivityObj();	

                System.out.println(activityObj.getActivityId());    
                User userObj = effortObj.getUserObj();
  
                System.out.println(userObj.getEmpNo());
                System.out.println(effortObj.getEffortDate());
                System.out.println(effortObj.getStartDate());
                System.out.println(effortObj.getEndDate());
                System.out.println(effortObj.getEffort());
                System.out.println(effortObj.getEffortDescription());
                System.out.println(effortObj.getEffortTimeStamp());
                        
       }
/*=======================UpdateTestActivityEffort===================*/

           public void updateTestActivityEffort() throws Exception
           { 
                                 
                        activityObj.setActivityId("001"); 
                        effortObj.setActivityObj(activityObj);

                        effortObj.setEffortDescription("Well") ; 
                        System.out.println(tmsManager.updateTestActivityEffort(effortObj));
           }

// =======================Main=====================================

        public static void main(String[] args) 
       {
                  try 
                   {
               TestDemo test= new TestDemo();
                System.out.println("Enter your Choice b/w 1..21");

               Scanner sc= new Scanner(System.in);
               int i=sc.nextInt();
    
               
                        switch(i)
                        {

                         case 1:  test.createTestPhase();
       		break;
                         case 2:  test.getTestPhase();
       		break;
                         case 3:  test.updateTestPhase();
       		break;
                         case 4:  test.deleteTestPhase();
       		break;
                 
                         case 5:  test.createTestActivity();
       		break;
                         case 6:  test.getTestActivity();
       		break;
                         case 7:  test.updateTestActivity();
       		break;
                         case 8:  test.deleteTestActivity();
       		break;

                         case 9:  test.assignActivity();
       		break;
                         case 10:  test.getActivityAssignment();
       		break;
                         case 11:  test.updateActivityAssignment();
     		break;
                   

                         case 12:  test.createTestCase();
       		break;

	      case 13:  test.getTestCase();
 		 break;

                        case 14: test.updateTestCase();
                                      break;

 	      case 15: test.deleteTestCase();
                                      break;

     	      case 16: test.addTestCaseExecutionDetails();
                                      break;

                          case 17: test.getTestCaseExecutionDetails(); 
		break;
                           
                         case 18: test.updateTestCaseExecutionDetails();	
		break;
                   
                         case 19: test.addTestActivityEffort();
                                       break;
                  
                        case 20:test.getTestActivityEffort("001");
                                       break;
                  
                         case 21: test.updateTestActivityEffort();
                                      break;
                
                        default:System.out.println("give proper input b/w 1...20");  
   
                     }
                 }
                 catch(Exception e)
                {
                     System.out.println(e);
                }
        }
}
   