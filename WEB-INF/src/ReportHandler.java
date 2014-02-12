public class ReportHandler {

	private TestCase testcase;
                    private TestCaseExecutionMgtHandler temh=new TestCaseExecutionMgtHandler();    

	public TestCase[] getTesterExecutionTestcases(String userId)  throws Exception
                    {

                     System.out.println("In ReportHandler");
	 TestCase [] testcase=temh.getTesterExecutionTestcases(userId) ;
                      return testcase;
	}

	
	public TestCase[] getActivityExecutionTestcases(String activityId) throws Exception 
	{     
	       TestCase[] testcase = temh.getActivityExecutionTestcases(activityId);
	        return testcase;	
		
	}

	
	public TestCase[] getTesterNonExecutionTestcases(String userId) throws Exception
	{
	     TestCase[] testcase = temh.getTesterNonExecutionTestcases(userId);
	      return testcase;	
	}

	
	public TestCase[] getTesterFailedTestcases(String userId) throws Exception
	{
	 TestCase[] testcase = temh.getTesterFailedTestcases(userId);
	 return testcase;	

	}

	
	 public TestCase[] getActivityNonExecutionTestcases(String activityId) throws Exception
                    {
                       TestCase[] testcase = temh.getActivityNonExecutionTestcases(activityId);
	        return testcase;	
		
                     
	}

	
	public TestCase[] getActivityFailedTestcases(String activityId) throws Exception
                   {
	   TestCase[] testcase=temh.getActivityFailedTestcases(activityId);		
                     return testcase; 	
	}

	
	public TestCase[] getTesterPassedTestcases(String userId) throws Exception
	 {
	   TestCase[] testcase = temh.getTesterPassedTestcases(userId);
	    return testcase;		
	}

	
	public TestCase[] getActivityPassedTestcases(String activityId) throws Exception
	 {
	 TestCase[] testcase=temh.getActivityPassedTestcases(activityId);		
                     return testcase; 	
	}

                   

}