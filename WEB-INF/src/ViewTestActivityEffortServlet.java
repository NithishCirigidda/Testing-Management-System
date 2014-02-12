import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;

public class ViewTestActivityEffortServlet extends HttpServlet
     {
             
 public void service(HttpServletRequest Req,HttpServletResponse Res) throws IOException,ServletException
   {
          
         try
            {  
        

                     Res.setContentType("text/html");
                     PrintWriter out=Res.getWriter();

                    
                    
                RequestDispatcher rd1 = Req.getRequestDispatcher("/header");
	 rd1.include(Req, Res);
          
     	out.println("<html>");
	out.println("<head>");
	out.println("<title>ViewTestActivityEffort</title></head>");
	out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
	out.println("<form action = \"./viewTestActivityEffort1\" align=\"center\" method = Post>");
	out.println("<table border=0 align =center width=\"100\" bgcolor=\"#bbccff\">");
	out.println("<caption>ViewTestActivityEffortServlet</caption>");
                   out.println("<tr><td>ActivityId :<input type=\"text\" name=\"activity_id\" /></td></tr>");
	out.println("<tr><td><input type=submit name=\"submit\" value=send></td>");
	out.println("<td><input type=reset name=\"clear\" value=Clear></td></tr>");
	out.println("</table></br>");
	out.println("</form></body></html>");
                 
          
         }
            catch(Exception s)
           {
                 System.out.println(s);
          }
            RequestDispatcher rd2 = Req.getRequestDispatcher("/footer");
            rd2.include(Req, Res);  
    }
}