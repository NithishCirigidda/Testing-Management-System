  public class TestCaseExecutionMgtHandler
   {
          DBStorage dBStorage=null;

/*          public TestCaseExecutionMgtHandler() throws Exception 
          {
                      dBStorage=new DBStorage();
          }
*/
          
/*  ===========================addTestCaseExecution===========*/
        
           public String addTestCaseExecutionDetails(TestCase testcaseObj) throws Exception
           {
                   dBStorage=new DBStorage();
      
                    return dBStorage.addTestCaseExecutionDetails(testcaseObj);
            }
/*============================View TestCaseExecution==============*/
    
       public TestCase getTestCaseExecutionDetails(String testcase_id) throws Exception
          {
                    dBStorage=new DBStorage();
                    return dBStorage.getTestCaseExecutionDetails(testcase_id);
          }

/*=====================UpdateTestExecutionDetails==================*/

           public String updateTestCaseExecutionDetails(TestCase testcaseObj) throws Exception
          {
                    dBStorage=new DBStorage();
                    return dBStorage.updateTestCaseExecutionDetails(testcaseObj);
          }
/*******************************************************************************/


public TestCase[] getTesterExecutionTestcases(String userId)  throws Exception
                   {
                      dBStorage=new DBStorage();
                      System.out.println("In TCEM");
	  TestCase[] tetestcase=dBStorage.getTesterExecutionTestcases(userId);
                       return tetestcase;	                  

	}
	 public  TestCase[] getActivityExecutionTestcases(String activityId) throws Exception
	 {
                       dBStorage=new DBStorage();
	    TestCase[] activityExeTestCases= dBStorage.getActivityExecutionTestcases(activityId);
	     return activityExeTestCases;
	  
	   }

	
	public  TestCase[] getTesterNonExecutionTestcases(String userId) throws Exception
	{
                     System.out.println("from TCEM");
                    dBStorage=new DBStorage();
	TestCase[] nonExecutionTestcases= dBStorage.getTesterNonExecutionTestcases(userId);
	return nonExecutionTestcases;	
	}

	
	public  TestCase[] getTesterFailedTestcases(String userId) throws Exception
	 {
                     dBStorage=new DBStorage();
	  TestCase[] testcase = dBStorage.getTesterFailedTestcases(userId);
	  return testcase;	
	}

	
	 public  TestCase[] getActivityNonExecutionTestcases(String activityId) throws Exception
	{

                      dBStorage=new DBStorage();
	   TestCase[] activityExeTestCases= dBStorage.getActivityNonExecutionTestcases(activityId);
	     return activityExeTestCases;
	  
                     }

	
	public TestCase[] getActivityFailedTestcases(String activityId) throws Exception
                    {

                    dBStorage=new DBStorage();
	TestCase[] testcase=dBStorage.getActivityFailedTestcases(activityId);
                     return testcase;
	}

	
	public TestCase[] getTesterPassedTestcases(String userId) throws Exception
	 {
                    dBStorage=new DBStorage();
	TestCase[] testcase=dBStorage.getTesterPassedTestcases(userId);
                     return testcase;	
	}

	
	public TestCase[] getActivityPassedTestcases(String activityId) throws Exception
	{
                    dBStorage=new DBStorage();
	 TestCase[] testcase = dBStorage.getActivityPassedTestcases(activityId);
	  return testcase;
	}


    }
