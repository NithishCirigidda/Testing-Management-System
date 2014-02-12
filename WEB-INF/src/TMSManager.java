import java.io.*;
import java.util.*;
public class TMSManager
{
         private TestPhase testPhaseObj=null;
         private Activity activityObj=null;
         Effort effortObj=null;  
         private ActivityUser acctivityUserObj=null;
         ActivityUser activityUserObj=null;
         TestCase testCaseObj=null; 
   private LoginManagementSystem lms = null;
   private ProjectCreationManagementSystem pcms =null;
   private TeamAssignmentManagementSystem tams=null;
    private User userObj=null;
     private Project projectObj=null; 
   private ProjectAssignment projectAssignmentObj=null;
        
       

        private TestActivityAssignmentHandler activityAssignmentHandler= null;
        private TestPhaseCreationHandler testPhaseCreateHandler= null;
        private TestActivityHandler activityHandler = null;
        TestActivityAssignmentHandler testAssignmentHandler =null;
       TestCaseLoader testCaseLoader = null; 
        TestCaseExecutionMgtHandler exeMgtHandler=null;  
        TestActivityEffortHandler   activityEffortHandler=null;
       private TestActivityEffortHandler effort = new TestActivityEffortHandler();
        ReportHandler rep=new ReportHandler();

       public TMSManager() throws Exception
       {
   lms=new LoginManagementSystem();
   pcms = new ProjectCreationManagementSystem();
   tams=new TeamAssignmentManagementSystem();
     
            userObj=new User();
    projectObj=new Project();
    projectAssignmentObj=new ProjectAssignment();
	 

            testPhaseCreateHandler=new  TestPhaseCreationHandler();
             activityHandler = new TestActivityHandler() ;
             activityAssignmentHandler = new TestActivityAssignmentHandler();

            testCaseLoader=new TestCaseLoader();
              exeMgtHandler=new TestCaseExecutionMgtHandler();                     
              activityEffortHandler=new TestActivityEffortHandler(); 
              effortObj=new Effort();

      }
/*..............................................................Authenticate.................................................*/

public String authenticate(String user_id, String password)
   {
  return lms.authenticate(user_id,password);

    }
/*...................................................ChangePassWord...........................................................*/

 public String changePassword(String user_id, String oldPassword, String newPassword)
   {
              
                 return lms.changePassword(user_id,oldPassword,newPassword);
               

   }

/*-----------------------------------CreateTestPhase----------------------------------------------*/
  
       public String createTestPhase(TestPhase testPhaseObj) throws Exception
       { 
     
                return  testPhaseCreateHandler.createTestPhase(testPhaseObj);
       
       }    
/*-----------------------------------ViewTestPhase----------------------------------------------*/  
       
         public TestPhase getTestPhase(String phase_id) throws Exception
        {
             return testPhaseCreateHandler.getTestPhase(phase_id);
         }
/*............................................createUser...........................................................................*/
          public String createUser(User userObj) 
  {
      return lms.createUser(userObj);
    }
/*............................................viewUser...........................................................................*/
public User getUser(String user_id) 
  {
    return lms.getUser(user_id);    
    }  

/*............................................updateUser...........................................................................*/
public String updateUser(User userObj)
     {
       return lms.updateUser(userObj);    
          }  


/*............................................deleteUser...........................................................................*/

  public String deleteUser(String user_id)
{
return lms.deleteUser(user_id);
}
/*.........................................asignmentProject.............................................................*/
public String projectAssignment(ProjectAssignment projectAssignmentObj)
{
        return tams.projectAssignment(projectAssignmentObj);
}

/*......................................................getAssignmentProject........................................*/

public ProjectAssignment getProjectAssignment(String project_id) 
{
                 return tams.getProjectAssignment(project_id);
  }

/*.....................................updateAssignmentProject..............................................*/
public String updateProjectAssignment(ProjectAssignment projectAssignmentObj)
{
        
         return tams.updateProjectAssignment(projectAssignmentObj) ;
}

    
/*-----------------------------------UpdateTestPhase----------------------------------------------*/  
  
      public String updateTestPhase(TestPhase testPhaseObj) throws Exception
     {
              return  testPhaseCreateHandler.updateTestPhase(testPhaseObj);          
     }
/*-----------------------------------Delete----------------------------------------------*/   
      public String deleteTestPhase(String phase_id) throws Exception
     {
          return testPhaseCreateHandler.deleteTestPhase(phase_id);
     }  
/*-------------------------------CreateActivity--------------------------------------------*/

    public String createTestActivity(Activity activityObj) throws Exception
    {
         return activityHandler.createTestActivity(activityObj);
    }
/*-------------------------------GetActivity--------------------------------------------*/

    public Activity getTestActivity(String activity_id) throws Exception
    {
         return activityHandler.getTestActivity(activity_id);
    }
/*-----------------------------------UpdateActivity--------------------------------------------*/

    public String updateTestActivity(Activity activityObj) throws Exception
    {
         return activityHandler.updateTestActivity(activityObj); 
    }    
/*-------------------------------DeleteActivity--------------------------------------------*/
   
     public String deleteTestActivity(String activity_id) throws Exception
    {
            return activityHandler.deleteTestActivity(activity_id);
    }

/*------------------------------------------ Close Activity  --------------------------------------*/
    public String closeTestActivity(String activity_id) throws Exception
    {
           return  activityHandler.closeTestActivity(activity_id);
    } 
/*------------------------------------------ Activity Assignment --------------------------------------*/
    
    public String assignTestActivity(ActivityUser activityUserObj) throws Exception
    {
         return activityAssignmentHandler.assignTestActivity(activityUserObj);
    }
/*------------------------------------ViewTestActivityAssignment--------------------------------------------*/

     public ActivityUser getTestActivityAssignment(String activity_id) throws Exception
      {
           return activityAssignmentHandler.getTestActivityAssignment(activity_id);
       }
/*-------------------------------------UpdateTestActivityAssignment--------------------------------------------*/
     
      public String updateTestActivityAssignment(ActivityUser activityUserObj) throws Exception
      {
           return activityAssignmentHandler.updateTestActivityAssignment(activityUserObj);
       }



/*************************************** Create Project**********************/
public String createProject(Project projectObj) 
  {
           
      return pcms.createProject(projectObj);
   }
/******************view Project******************/

public Project getProject(String project_id) 
{
  return pcms.getProject(project_id);
  }

/******************update Project******************/
public String updateProject(Project projectObj) 
{
  return pcms.updateProject(projectObj);
    }
/******************delete Project******************/

public String deleteProject(String project_id) 
{
  return pcms.deleteProject(project_id);
  }

/* ======================CreateTestCase===========================*/
         
         public String createTestCase(TestCase testCaseObj)throws Exception
         {
                 return testCaseLoader.createTestCase(testCaseObj);     
         }
/*========================ViewTestCase==========================*/
         
          public TestCase getTestCase(String testCase_id) throws Exception
         {
                       return testCaseLoader.getTestCase(testCase_id);
          }
/*==========================UpdateTestCase========================*/
  
         public String updateTestCase(TestCase testCaseObj) throws Exception 
        {
                  return testCaseLoader.updateTestCase(testCaseObj);
        }

/*===========================DeleteTestCase========================*/
         public String deleteTestCase(String testCase_id) throws Exception
         {
                    return testCaseLoader.deleteTestCase(testCase_id);
          }  
/*=====================add TestCaseExecution Details===================*/
         
            public String addTestCaseExecutionDetails(TestCase testCaseObj) throws Exception
           {  
                       exeMgtHandler= new TestCaseExecutionMgtHandler();
                      return  exeMgtHandler.addTestCaseExecutionDetails(testCaseObj);
           }
/*====================View TestCaseExecution Details===================*/
    
           public TestCase  getTestCaseExecutionDetails(String testCase_id) throws Exception
          {
                       return exeMgtHandler.getTestCaseExecutionDetails(testCase_id);
          }

/*=======================UpdateTestCaseExecutionDetails==============*/
  
         public String updateTestCaseExecutionDetails(TestCase testCaseObj) throws Exception 
        {
                  return  exeMgtHandler.updateTestCaseExecutionDetails(testCaseObj);
        }

/*=======================AddTestActivityEffort======================*/
           
        public String addTestActivityEffort(Effort effortObj) throws Exception
        {
               return activityEffortHandler.addTestActivityEffort(effortObj);

         }
/*======================ViewTestActivityEffort=====================*/

        public Effort getTestActivityEffort(String activity_id) throws Exception
        {
                return activityEffortHandler.getTestActivityEffort(activity_id);
         }
/*====================UpdateTestActivityEffort======================*/
  
         public String updateTestActivityEffort(Effort effortObj) throws Exception 
        {
                  return activityEffortHandler.updateTestActivityEffort(effortObj);
        }

/********************************getActivityEffort**********************************/
   
 public int getActivityEffort(String activity_id) throws Exception
    {
            System.out.println("from TMS Manager");
            int effort1=activityEffortHandler.getActivityEffort(activity_id);
               return effort1;
    } 

/***************************getProjectEffort*********************************************/
    public int getProjectEffort(String projectId) throws Exception
    {
     int effort2 = activityEffortHandler.getProjectEffort(projectId);
     return effort2;
    }

/*********************************getTestPhaseEffort**********************************************************/
     public int getTestPhaseEffort(String phaseId) throws Exception
     {
       int effort3=activityEffortHandler.getTestPhaseEffort(phaseId);
      return effort3;
     }



 /**************************************getTesterEffort*************************/  
   public int getTesterEffort(String emp_no)throws Exception
     {
          int testerEffort=activityEffortHandler.getTesterEffort(emp_no);
          return testerEffort;
    }
/**************************************getTesterTestCase*******/

    public TestCase[] getTesterTestcases(String emp_no) throws Exception
    {
   	
     TestCase[] testcases = testCaseLoader.getTesterTestcases(emp_no);
	return testcases;
     }
 /**************************************getActivityTestCase*************************/  
        public TestCase[] getActivityTestcases(String activityId) throws Exception
       {
         TestCase[] testcases = testCaseLoader.getActivityTestcases(activityId);
         return testcases;
       } 
 /**************************************getTesterExcecutionTestCases*************************/  
       public TestCase[] getTesterExcecutionTestcases(String userId) throws Exception
        {
          System.out.println("In TMSManager");
         TestCase[] testcases=rep.getTesterExecutionTestcases(userId);
          return testcases;
        }

 /***************************************getActivityExecutionTestCases*********************************/
    public TestCase[] getActivityExecutionTestcases(String activityId) throws Exception
    {
	TestCase[] testcases =rep.getActivityExecutionTestcases(activityId);
	return testcases;
    }

 /***************************************getTesterNonExecutionTestCases*********************************/ 

    public TestCase[] getTesterNonExecutionTestcases(String userId) throws Exception
        {
         TestCase[] testcases=rep.getTesterNonExecutionTestcases(userId);
          return testcases;
        }

/*****************************getFailedTestcaseOfTester*******************************************************/
    public TestCase[] getTesterFailedTestcases(String userId) throws Exception
    {
    TestCase[] testcases = rep.getTesterFailedTestcases(userId);
    return testcases;
    }

/*****************************getFailedTestcaseOfActivity*******************************************************/

    public TestCase [] getActivityFailedTestcases(String activityId) throws Exception
    {
      TestCase [] testcase=rep.getActivityFailedTestcases(activityId);
      return  testcase;
    }
/*****************************getPassedTestcaseOfTester*******************************************************/
    public TestCase[] getTesterPassedTestcases(String userId) throws Exception
    {
    TestCase[] testcases = rep.getTesterPassedTestcases(userId);
    return testcases;
    }
/*****************************getPassedTestcaseOfActivity*******************************************************/

    public TestCase [] getActivityPassedTestcases(String activityId) throws Exception
    {
      TestCase [] testcase=rep.getActivityPassedTestcases(activityId);
      return  testcase;
    }

/***********************************************getActivityNonExecutionTestcases**********************************/

public TestCase[] getActivityNonExecutionTestcases(String activityId) throws Exception
    {
	TestCase[] testcases =rep.getActivityNonExecutionTestcases(activityId);
	return testcases;
    }


}

