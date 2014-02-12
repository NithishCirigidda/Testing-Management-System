import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
public class ViewTestCaseExeDetailsServlet extends HttpServlet
{
     
     public void service(HttpServletRequest req,HttpServletResponse res)
     throws IOException, ServletException
     {
          RequestDispatcher rd1=req.getRequestDispatcher("./header");
          rd1.include(req,res);
           try
           {
                
                 res.setContentType("text/html");
                 PrintWriter out=res.getWriter();
                 
              
                 out.println("<html>");
                 out.println("<body bgcolor = \"#bbffdd\" >");
                 out.println("<form action = \"./viewTestCaseExecution1\"   method =Post >"); 
                 out.println("<table border = \"0\" width = \"200\" align = \"center\" bgcolor = \"#bbccff\">");
                 out.println("<caption>ViewTestCaseExeDetails</caption>");
                 out.println("<tr><td>TestCaseId</td>");
                 out.println("<td><input type = \"text\" name = \"testcase_id\" ></td></tr>");
                 out.println("<tr><td colspan = 2  align =\"center\"><input type = \"submit\" name=submit value = send></td></tr>");
                 out.println("</table>");
                 out.println("</form>"); 
                 out.println("</body>");
                 out.println("</html>");
                               
                RequestDispatcher rd2=req.getRequestDispatcher("./footer");
                rd2.include(req,res);
           }
           catch(Exception s)
           {
                 System.out.println(s.toString());
           }
     }
 }