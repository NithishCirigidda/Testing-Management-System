import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewTestActivityServlet extends HttpServlet
{
      
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

            try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
          
            out.println("<html><head><title>Activity View</title></head>");
            out.println("<body bgcolor =\"#bbccff\">");
            out.println("<form  method =\"POST\"  action =\"./viewTestActivity1\" ><br><br><br>");
            out.println("<table border =0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>View Activity</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter Activity ID</td>");
            out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
 
            
           }catch(Exception e){
               System.out.println(e.getMessage());
           }

          RequestDispatcher rd2 = request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 