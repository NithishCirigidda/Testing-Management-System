import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class TestManagerServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  res.setContentType("text/html");
  PrintWriter out=res.getWriter();
  RequestDispatcher rd1=req.getRequestDispatcher("./header");
  rd1.include(req,res);

  out.println("<bgcolor= #ccffbb>"); 
  out.println("<table align=right>");
  out.println("<tr><td ><a href=\"./changePassword\">Change Password</a></td>");
  out.println("<td><a href=\"./login\">&nbsp&nbsp logout</a></td></tr>");
  out.println("</table>");
  out.println("<br>");
  out.println("<h1 align=center> <B>Test Manager</B></h1>");

  out.println("<table>");
   out.println("<tr><td><a href=\"./viewProject\">View Project</a></td></tr>");

 out.println("<tr><td><a href=\"./createTestPhase\">Create TestPhase</a></td></tr>");
 out.println("<tr><td><a href=\"./viewTestPhase\">View TestPhase</a></td></tr>");  
 out.println("<tr><td><a href=\"./updateTestPhase1\">Update TestPhase</a></td></tr>");
 out.println("<tr><td><a href=\"./deleteTestPhase\">Delete TestPhase</a></td></tr>");   

 out.println("<tr><td><a href=\"./createTestActivity\">Create TestActivity</a></td></tr>");
 out.println("<tr><td><a href=\"./viewTestActivity\">View TestActivity</a></td></tr>");
 out.println("<tr><td><a href=\"./updateTestActivity1\">Update TestActivity</a></td></tr>");
 out.println("<tr><td><a href=\"./deleteTestActivity\">Delete TestActivity</a></td></tr>");
 
 out.println("<tr><td><a href=\"./assignTestActivity\">Assign TestActivity</a></td></tr>");
 out.println("<tr><td><a href=\"./viewActivityAssignment\">View Activity Assignment</a></td></tr>"); 
 out.println("<tr><td><a href=\"./updateActivityAssignment1\">Update Activity Assignment</a></td></tr>"); 

// out.println("<tr><td><a href=\"./viewTesters\">viewTesters</a></td></tr>"); 

 out.println("<tr><td><a href=\"./ActivityEffort\">View Total Effort Of Activity</a></td></tr>"); 
 out.println("<tr><td><a href=\"./PhaseEffort\">View Total Effort Of Phase</a></td></tr>"); 
 out.println("<tr><td><a href=\"./ProjectEffort\">View Total Effort Of Project</a></td></tr>"); 
 out.println("<tr><td><a href=\"./TesterEfort\">View Total Effort Of Tester</a></td></tr>");

out.println("<tr><td><a href=\"./TesterTestCases\">View Test Case Of Tester</a></td></tr>");
 out.println("<tr><td><a href=\"./ActivityTestCases\"> View Test Cases Of  Activity</a></td></tr>");

out.println("<tr><td><a href=\"./ActivityExecutionTestCases\"> View Executed Test Cases Of  Activity</a></td></tr>");  
 out.println("<tr><td><a href=\"./TesterExecutionTestCases\"> View Executed Test Cases Of  Tester</a></td></tr>");

out.println("<tr><td><a href=\".//ActivityNonExcecutiontestcases\"> View  Non Executed Test Cases Of  Activity</a></td></tr>");
out.println("<tr><td><a href=\"./TesterNonExecutionTestCases\">View Non Executed  Test Cases Of  Tester</a></td></tr>"); 

out.println("<tr><td><a href=\"./ActivityFailedTestCases\"> View  Failed Test Cases Of  Activity</a></td></tr>");
out.println("<tr><td><a href=\"./TesterFailedTestCases\"> View Failed Test Cases Of  Tester</a></td></tr>");

out.println("<tr><td><a href=\"./ActivityPassedTestCases\"> View  Passed Test Cases Of  Activity</a></td></tr>");
out.println("<tr><td><a href=\"./TesterPassedTestCases\">View Passed Test Cases Of  Tester</a></td></tr>");

out.println("<tr><td><a href=\"./closeTestActivity1\"> Close Test Activity</a></td></tr>");

out.println("</table>");
out.println("</form>");
RequestDispatcher rd2=req.getRequestDispatcher("./footer");
rd2.include(req,res);
out.println("</body>");
out.println("</html>");
  }
}