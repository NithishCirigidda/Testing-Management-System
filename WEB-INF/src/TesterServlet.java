import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class TesterServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
   RequestDispatcher rd1=req.getRequestDispatcher("./header");
  rd1.include(req,res);

   out.println("<bgcolor=blue>"); 
  out.println("<table align=right>");
  out.println("<tr><td ><a href=\"./changePassword\">Change Password</a></td>");
  out.println("<td><a href=\"./login\">&nbsp&nbsp logout</a></td></tr>");
  out.println("</table>");
  out.println("<br>");
  out.println("<h2 align=center> <B>TESTER</B></h2>");
   
  out.println("<table>");
 out.println("<tr><td><a href=\"./viewTestActivity\">View TestActivity</a></td></tr>");

  out.println("<tr><td><a href=\"./createTestcase\">Create Testcase</a></td></tr>");
  out.println("<tr><td><a href=\"./view\">View Testcase</a></td></tr>");
   out.println("<tr><td><a href=\"./update\">Update Testcase</a></td></tr>");
   out.println("<tr><td><a href=\"./deleteTestcase\">Delete Testcase</a></td></tr>");

  out.println("<tr><td><a href=\"./addTestCaseExecution\">Add  TestCase Execution</a></td></tr>");
  out.println("<tr><td><a href=\"./viewTestCaseExecution\">View TestCase Execution</a></td></tr>");
  out.println("<tr><td><a href=\"./updateTestCaseExecution1\">Update TestCase Execution</a></td></tr>"); 

 out.println("<tr><td><a href=\"./addTestActivityEffort\">Add Test Activity Effort</a></td></tr>"); 
 out.println("<tr><td><a href=\"./viewTestActivityEffort\">View Test Activity Effort</a></td></tr>"); 
 out.println("<tr><td><a href=\"./updateTestActivityEffort1\">Update Test Activity Effort</a></td></tr>"); 
out.println("</table>");
   out.println("</form>"); 
  out.println("<br>");
    RequestDispatcher rd2=req.getRequestDispatcher("./footer");
  rd2.include(req,res);
  out.println("</body>");
  out.println("</html>");
  }
}