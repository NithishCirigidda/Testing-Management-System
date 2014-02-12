import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateTestActivityEffortServlet1 extends HttpServlet
 {
      public void service(HttpServletRequest req,HttpServletResponse res)
       throws IOException, ServletException
      {  
	
	 RequestDispatcher  rd1 = req.getRequestDispatcher("/header");
	         rd1.include(req,res);
                  
           try
          {
                  res.setContentType("text/html"); 
                  PrintWriter out =res.getWriter();   
                
              out.println("<html>");
              out.println("<head>");
              out.println("<title>UpdateTestActivityEffort</title></head>");
              out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
              out.println("<form action = \"./updateTestActivityEffort\" align=\"center\" method = Post>");
              out.println("<table border=\"0\" align =center width=\"100\" bgcolor=\"#bbccff\">");
              out.println("<caption>UpdateTestActivityEffort</caption>");
              out.println("<tr><td>ActivityId<input type=\"text\" name=\"activity_id\"></td></tr>");
              out.println("</table>");            
              out.println("<p align=center ><input type=submit name=\"submit\" value=send>");
              out.println("<input type=reset name=\"clear\" value=Clear></p>");
              out.println("</form></body></html>");
      } 
           
        catch(Exception e)
       { 
            System.out.println(e);
       }
	RequestDispatcher rd3 = req.getRequestDispatcher("/footer");
              rd3.include(req,res);
    }
}
