import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CreateTestCaseServlet extends HttpServlet
{
    TMSManager tmsManager=null;
    TestCase testCaseObj=null;
     Project projectObj=null;
     User userObj=null;
     Activity activityObj=null;      

   public void service(HttpServletRequest  req,HttpServletResponse res) throws IOException,ServletException
    {

           RequestDispatcher rd1=req.getRequestDispatcher("./header");
           rd1.include(req,res);

        try{

                  tmsManager=new TMSManager();
                   testCaseObj=new TestCase();
                   projectObj = new Project();
                   userObj = new User();
                   activityObj = new Activity();

          res.setContentType("text/html");  
           PrintWriter out=res.getWriter();
                   
          out.println("<html>");
          out.println("<body bgcolor = \"#bbffdd\" >");
          out.println("<form action = \"./createTestcase\"   method =Post >"); 
          out.println("<table border = \"0\" width = \"200\" align = \"center\" bgcolor = \"#bbccff\">");
          out.println("<caption>TestCaseCreation</caption>");
          out.println("<tr><td>TestCaseId</td>");
          out.println("<td><input type = \"text\" name = \"testcase_id\" ></td></tr>");
          out.println("<tr><td>TestCaseDescription</td>");
          out.println("<td><input type = \"text\" name = \"testcase_description\"></td></tr>");
          out.println("<tr><td>TestCasePhase</td>");
         out.println("<td><input type = \"text\" name = \"testcase_phase\"></td></tr>");
         out.println("<tr><td>ProjectId</td>");
         out.println("<td><input type = \"text\" name = \"project_id\" ></td></tr>");
         out.println("<tr><td>UserId</td>");
         out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
         out.println("<tr><td>ActivityId</td>");
         out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
         out.println("<tr><td>ExpectedBehaviour</td>");
         out.println("<td><input type = \"text\" name = \"expected_behaviour\"></td></tr>");
         out.println("<tr><td colspan = 2  align =\"center\"><input type = \"submit\" name=submit value = send>");
         out.println("<input type = \"Reset\" name=reset value = clear></td></tr>");
         out.println("</table></form></body></html>");

           String testcase_id=req.getParameter("testcase_id");
           String testcase_description=req.getParameter("testcase_description");
           String testcase_phase=req.getParameter("testcase_phase");
           String project_id=req.getParameter("project_id");
           String user_id=req.getParameter("user_id");
           String activity_id=req.getParameter("activity_id"); 
           String expected_behaviour=req.getParameter("expected_behaviour");

           
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
  
         String msg = tmsManager.createTestCase(testCaseObj);
         out.println(msg);
        }
       catch(Exception e)
       { 
           System.out.println(e.getMessage());
       }
           RequestDispatcher rd2=req.getRequestDispatcher("./footer");
           rd2.include(req,res);
    }
}

          
          


                   