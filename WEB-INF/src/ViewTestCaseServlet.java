 import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewTestCaseServlet extends HttpServlet
 {
     
    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
     { 

       RequestDispatcher rd1=req.getRequestDispatcher("./header");
       rd1.include(req,res);
 
             
    try{

            
             res.setContentType("text/html");
             PrintWriter out =res.getWriter();   
            

 
     	out.println("<html>");
	out.println("<head>");
	out.println("<title>ViewTestCase</title></head>");
	out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
                 out.println("</body>");
                  out.println("</html>");

                out.println("<form action = \"./viewTestcase1\" align=\"center\" method = POST>");
	out.println("<table border=0 align =center width=\"100\" bgcolor=\"#bbccff\">");
	out.println("<caption>ViewTestCase</caption>");
	out.println("<tr><td>TestCaseId :&nbsp&nbsp<input type=\"text\" name=\"Testcase_id\" value=\"\" /></td></tr>");
	out.println("</table></br>");
	out.println("<p align=\"center\">");
	out.println("<input type=submit name=\"submit\" value=send>");
	out.println("<input type=reset name=\"clear\" value=Clear>");
	out.println("</p>");
               out.println("</form></body></html>"); 

                
           }
          catch(Exception e)
         {
              System.out.println(e.getMessage());
         }
          RequestDispatcher rd2=req.getRequestDispatcher("./footer");
          rd2.include(req,res);

     }
}