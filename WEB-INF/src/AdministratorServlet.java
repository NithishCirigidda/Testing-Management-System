import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class AdministratorServlet extends HttpServlet
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
  out.println("<h2 align=center> <B>Administrator</B></h2>");
  
  out.println("<table>");
  out.println("<tr><td><a href=\"./createUser\">createUser</a></td></tr>");
  out.println("<tr><td><a href=\"./viewUser\">viewUser</a></td></tr>");
  out.println("<tr><td><a href=\"./updateUser1\">updateUser</a></td></tr>");
  out.println("<tr><td><a href=\"./deleteUser\">deleteUser</a></td></tr>"); 

   out.println("<tr><td><a href=\"./createProjectDetails\">createProject</a></td></tr>");
   out.println("<tr><td><a href=\"./viewProject\">viewProject</a></td></tr>");
   out.println("<tr><td><a href=\"./updateProject1\">updateProject</a></td></tr>");
   out.println("<tr><td><a href=\"./deleteProject\">deleteProject</a></td></tr>");  

 out.println("<tr><td><a href=\"./projectAssignmentDetails\">Assign User To Project</a></td></tr>"); 
 out.println("<tr><td><a href=\"./viewProjectAssignment\">View Project Assignment</a></td></tr>"); 
 out.println("<tr><td><a href=\"./updateProjectAssignment1\">Update Project Assignment</a></td></tr>");   
 out.println("</table>");
  out.println("</form>");
  RequestDispatcher rd2=req.getRequestDispatcher("./footer");
  rd2.include(req,res);
  out.println("</body>");
  out.println("</html>");
  }
}