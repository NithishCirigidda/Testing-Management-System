import java.io.*;
import java.sql.*;
class TestCaseLoader
{
         DBStorage dBStorage=null;
         TestCase testCaseObj=null; 

         public TestCaseLoader()throws Exception
         {	      
                      dBStorage= new DBStorage();
                       testCaseObj=new TestCase();
         } 
       
/*===================CreateTestcase============================= */

        public String createTestCase(TestCase testCaseObj)throws Exception 
         {     
                 return  dBStorage.storeTestCase(testCaseObj);
         }

/*=====================ViewTestCase=========================  */

         public TestCase getTestCase(String testCase_id)throws Exception 
         {
                return  dBStorage.getTestCase(testCase_id);
          }

/*======================updateTestCase========================*/
        
            public String updateTestCase(TestCase testCaseObj) throws Exception
         {
                return dBStorage.updateTestCase(testCaseObj);
          }
            

/*======================DeleteTestCase==========================*/
          public String deleteTestCase(String testcase_id)throws Exception  
         {
                     return dBStorage.deleteTestCase(testcase_id);  
          }

/******************************************************/

public TestCase[] getTesterTestcases(String emp_no) throws Exception
                   {
                     
	 TestCase[]   testcase = dBStorage.getTesterTestcases(emp_no);
	return testcase;
	}


	public TestCase[] getActivityTestcases(String activityId) throws Exception
                    {
                     TestCase[]   testcase = dBStorage.getActivityTestcases(activityId); 
                      return testcase;
	}
}