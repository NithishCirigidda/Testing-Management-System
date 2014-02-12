import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateTestCaseServlet extends HttpServlet
 {
           TestCase testCaseObj= null;  
           TMSManager tmsManager=null;
           Project projectObj=null;
           User userObj=null;
           Activity activityObj=null; 
            
      public void service(HttpServletRequest req,HttpServletResponse res)
      throws IOException, ServletException
     {  
              RequestDispatcher rd1= req.getRequestDispatcher("/header");	
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
                   String testcase_id= req.getParameter("testcase_id"); 
                   testCaseObj=tmsManager.getTestCase(testcase_id);
                                   
                   out.println("<html>");
	out.println("<head>");
	out.println("<title>UpdateTestCase</title></head>");
	out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
	out.println("<form action = \"./updateTestcase\" align=\"center\" method = Post>");
	out.println("<table border=\"0\" align =center width=\"100\" bgcolor=\"#bbccff\">");
	out.println("<caption>UpdateTestCase</caption>");
	out.println("<tr><td>TestCaseId :&nbsp&nbsp");
                   out.println("<input type=\"text\" name=\"testcase_id\" value=\"\" /></td></tr></table></br>");
	out.println("<p align=\"center\">");
	out.println("<input type=submit name=\"submit\" value=send>");
	out.println("<input type=reset name=\"clear\" value=Clear>");
	out.println("</p>");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");

                   if(testCaseObj.getTestCaseId()==null)
                         out.println("<h4 align = center>Please enter your Testcase id</h4>");
                   else
                   {
                        testcase_id = testCaseObj.getTestCaseId();
                        String testcase_description = testCaseObj.getTestCaseDescription();
                        String testcase_phase = testCaseObj.getTestCasePhase();
                        String expected_behaviour  = testCaseObj.getExpectedBehaviour();

          out.println("<html>");
          out.println("<body>");
          out.println("<form method = POST action = \"./updateTestcase\">");
          out.println("<table border=0 align=center bgcolor=\"#bbccff\"><caption>TestCase Content</caption>");

          out.println("<tr><td>TestCaseId:</td>");
          out.println("<td><input type = \"text\" name = \"testcase_id\" value="+testcase_id+"> </td></tr>");

          out.println("<tr><td>TestCaseDescription:</td>");
          out.println("<td><input type = \"text\" name=\"testcase_description\" value="+testcase_description +"></td></tr>");

          out.println("<tr><td>TestCasePhase:</td>");
          out.println("<td><input type=text name=\"testcase_phase\" value="+testcase_phase +" </td></tr>");
                       
          out.println("<tr><td>ProjectId</td>");       
          Project projectObj=testCaseObj.getProjectObj(); 	
          out.println("<td><input type = \"text\" name = \"project_id\" value="+projectObj.getProjectId()+"></td></tr>");   
            
          out.println("<tr><td>UserId</td>");
          User userObj = testCaseObj.getUserObj();
          out.println("<td><input type = \"text\" name = \"user_id\" value="+userObj.getUserId()+"></td></tr>");
              
          out.println("<tr><td>ActivityId</td>");     
          Activity activityObj=testCaseObj.getActivityObj();	
          out.println("<td><input type = \"text\" name = \"activity_id\" value="+activityObj.getActivityId()+"></td></tr>");
                
          out.println("<tr><td>ExpectedBehaviour</td>");       
          out.println("<td><input type=text name=\"expected_behaviour\" value="+expected_behaviour+" </td></tr>");
          
          out.println("<tr><td><input type=submit name=\"submit\" value=Update></td></tr>");
                
          out.println("</form>");
          out.println("</table>");
          out.println("</body></html>");

                        testcase_id=req.getParameter("testcase_id");
                        testcase_description=req.getParameter("testcase_description");
                        testcase_phase=req.getParameter("testcase_phase");
                       String  project_id=req.getParameter("project_id");
                       String user_id=req.getParameter("user_id");
                        String activity_id=req.getParameter("activity_id"); 
                        expected_behaviour=req.getParameter("expected_behaviour");


         testCaseObj.setTestCaseId(testcase_id);
         testCaseObj.setTestCaseDescription(testcase_description);
         testCaseObj.setTestCasePhase(testcase_phase);

         projectObj.setProjectId(project_id);
         testCaseObj.setProjectObj(projectObj);

         userObj.setUserId(user_id);
         testCaseObj.setUserObj(userObj);

         activityObj.setActivityId(activity_id);
         testCaseObj.setActivityObj(activityObj);

         testCaseObj.setExpectedBehaviour(expected_behaviour);
  
         String msg = tmsManager.updateTestCase(testCaseObj);
         out.println(msg);   
     }
   }
   catch(Exception e)
   {
        System.out.println(e);
   }

 RequestDispatcher rd2= req.getRequestDispatcher("/footer");	
              rd2.include(req,res); 

 }
}

      
         
           