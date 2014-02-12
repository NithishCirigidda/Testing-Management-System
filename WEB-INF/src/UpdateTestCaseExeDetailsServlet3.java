import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
public class UpdateTestCaseExeDetailsServlet3 extends HttpServlet
     {
          TMSManager  tmsManager=null;
          TestCase testCaseObj=null;
           Activity activityObj=null;
           User userObj=null;  
           Project projectObj=null;
  

           public void service(HttpServletRequest req,HttpServletResponse res)
           throws IOException,ServletException
          {

                RequestDispatcher rd1 = req.getRequestDispatcher("/header");
                rd1.include(req,res);
                     try
                     {                  
                        tmsManager=new TMSManager();
                         testCaseObj= new TestCase();
                         projectObj = new Project();
                         userObj = new User();
                         activityObj = new Activity();
           
                         res.setContentType("text/html"); 
                         PrintWriter out =res.getWriter(); 
                         String testcase_id = req.getParameter("testcase_id"); 
  
                        testCaseObj=tmsManager.getTestCaseExecutionDetails(testcase_id);
                       activityObj =  testCaseObj.getActivityObj();
                       String activity_id = activityObj.getActivityId();

                       testcase_id=testCaseObj.getTestCaseId();   
  
                      userObj=testCaseObj.getUserObj();
                     String user_id = userObj.getUserId();
 
                     Date testcase_actual_date=testCaseObj.getActualDate(); 
                     String testcase_status=testCaseObj.getTestCaseStatus();
                     String comments=testCaseObj.getComments();
 
                    String actual_behaviour=testCaseObj.getActualBehaviour();
                   activity_id = req.getParameter("activity_id"); 
                   System.out.println(activity_id);
                   testcase_id= req.getParameter("testcase_id"); 

                   user_id=req.getParameter("user_id");

                    String ef1date = req.getParameter("testcase_actual_date");
                  /* String[] efdate = ef1date.split("-");
                   int efy=Integer.parseInt(efdate[0]);
               	int efm=Integer.parseInt(efdate[1]);
  	int efd=Integer.parseInt(efdate[2]);*/
                 java.sql.Date effort_date1 =java.sql.Date.valueOf(ef1date);

                   testcase_status=req.getParameter("testcase_status");

                   comments=req.getParameter("comments");

                   actual_behaviour=req.getParameter("actual_behaviour");

                           testCaseObj.setActivityObj(activityObj);
                           activityObj.setActivityId(activity_id);

                           testCaseObj.setTestCaseId(testcase_id);

                           testCaseObj.setUserObj(userObj);
                           userObj.setUserId(user_id); 

                           testCaseObj.setActualDate(effort_date1);
                           testCaseObj.setTestCaseStatus(testcase_status); 
                           testCaseObj.setComments(comments);      
                           testCaseObj.setActualBehaviour(actual_behaviour);  
          
                String msg=tmsManager.updateTestCaseExecutionDetails(testCaseObj);
                out.println(msg);
                out.println("<html>");
	out.println("<head>");
	out.println("<title>UpdateTestCaseExecutionDetails</title></head>");
	out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
	out.println("<form action = \"./updateTestCaseExecution2\" align=\"center\" method = POST>");
	out.println("<table border=\"0\" align =center width=\"100\" bgcolor=\"#bbccff\">");
	out.println("<caption>UpdateTestCaseExecutionDetatils</caption>");
	out.println("<tr><td>TestCaseId :&nbsp&nbsp");
                out.println("<input type=text name=\"testcase_id\"  /></td></tr></table></br>");
	out.println("<p align=\"center\">");
	out.println("<input type=submit name=\"submit\" value=send >");
	out.println("<input type=reset name=\"clear\" value=Clear >");
	out.println("</p>");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");
              
           }catch(Exception e)
              {
                  System.out.println("texe"+e);
        
                }

                RequestDispatcher rd2 = req.getRequestDispatcher("/footer");
                rd2.include(req,res);

       }
}
