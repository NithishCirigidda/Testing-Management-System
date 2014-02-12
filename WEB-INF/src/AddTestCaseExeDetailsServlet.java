import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
public class AddTestCaseExeDetailsServlet extends HttpServlet
     {
          TMSManager  tmsManager=null;
          TestCase testCaseObj=null;
          Activity activityObj = null;
          User userObj = null;
            Date date=null;  
      
         public void service(HttpServletRequest req,HttpServletResponse res)
         throws IOException, ServletException
         {

               RequestDispatcher rd1=req.getRequestDispatcher("./header");
               rd1.include(req,res);

                       try
                         {

                          tmsManager=new TMSManager();
                          testCaseObj=new  TestCase();
                          activityObj = new Activity();
                          userObj = new User();

                              res.setContentType("text/html");
                              PrintWriter out=res.getWriter();


         out.println("<html>");
         out.println("<body bgcolor = \"#bbffdd\" >");
         out.println("<form action = \"./addTestCaseExecution\"   method =post >"); 
         out.println("<table border = \"0\" width = \"200\" align = \"center\" bgcolor = \"#bbccff\">");
         out.println("<caption>AddTestCaseExeDetails</caption>");
         out.println("<tr><td>ActivityId</td>");
         out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
         out.println("<tr><td>TestCaseId</td>");
         out.println("<td><input type = \"text\" name = \"testcase_id\"></td></tr>");
         out.println("<tr><td>UserId</td>");
         out.println("<td><input type =text name = \"user_id\"></td></tr>");
         out.println("<tr><td>TestCaseActualDate</td>");
         out.println("<td><input type = \"text\" name = \"testcase_actual_date\" ></td></tr>");
         out.println("<tr><td>TestCaseStatus</td>");
         out.println("<td><input type = \"text\" name = \"testcase_status\" ></td></tr>");  
         out.println("<tr><td>Comments</td>");
         out.println("<td><input type = \"text\" name = \"comments\" ></td></tr>");
         out.println("<tr ><td>ActualBehaviour</td>");
         out.println("<td><input type = \"text\" name = \"actual_behaviour\" ></td></tr>");

         out.println("<td colspan = 2  align =\"center\"><input type = \"submit\" name=submit value = send></td></tr>");
         out.println("</table></form></body></html>"); 

 
         String activity_id=req.getParameter("activity_id");
         String testcase_id=req.getParameter("testcase_id");
         String user_id=req.getParameter("user_id");
         String testcase_actual_date=req.getParameter("testcase_actual_date");
         String testcase_status=req.getParameter("testcase_status");
         String comments=req.getParameter("comments");
         String testcase_actual_behaviour=req.getParameter("actual_behaviour");
                           
         /*String[] tad = testcase_actual_date.split("-");
            int ty = Integer.parseInt(tad[0]); 
            int tm = Integer.parseInt(tad[1]);
            int td = Integer.parseInt(tad[2]);*/
         java.sql.Date testcase_actual_date1=java.sql.Date.valueOf(testcase_actual_date);
         activityObj.setActivityId(activity_id);
         testCaseObj.setActivityObj(activityObj);
         testCaseObj.setTestCaseId(testcase_id);
         userObj.setUserId(user_id);
         testCaseObj.setUserObj(userObj); 
         testCaseObj.setActualDate(testcase_actual_date1);                           
         testCaseObj.setTestCaseStatus(testcase_status); 
         testCaseObj.setComments(comments);      
         testCaseObj.setActualBehaviour(testcase_actual_behaviour);
                       
         String msg=tmsManager.addTestCaseExecutionDetails(testCaseObj);
         
         out.println("<h4 align = center>"+msg+"</h4>");
     }
     catch(Exception e)
     {
           System.out.println(e);   
     }

      RequestDispatcher rd2=req.getRequestDispatcher("./footer");
      rd2.include(req,res);

   }   
}
