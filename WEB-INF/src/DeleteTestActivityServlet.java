import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteTestActivityServlet extends HttpServlet
{
      TMSManager tmsManager = null;
      Activity activityObj = null;

                   
     
     public void doGet(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
           response.setContentType("text/html");
             PrintWriter out = response.getWriter();
          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

        
               
            

            out.println("<html><head><title>Activity Deletion</title></head>");
            out.println("<body bgcolor = \"#ccffdd\" >");
            out.println("<form  method = \"GET\" action = \"./deleteTestActivity1\" ><br><br><br>");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><strong>Delete Activity</strong></caption>");
            out.println("<tr><td>Enter Activity ID</td>");
            out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table></body></html>");
          
           

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 