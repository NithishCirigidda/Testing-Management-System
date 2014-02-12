import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewUserServlet extends HttpServlet
{
      TMSManager tmsManager = null;
      User userObj = null;
      
      public ViewUserServlet() throws Exception
      {
           tmsManager = new TMSManager();
           userObj = new User();
     }

    public void service(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
     {
         
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();


            RequestDispatcher rd1=request.getRequestDispatcher("./header");
            rd1.include(request,response);
          
           
          out.println("<html><head><title>View User</title></head>");
            out.println("<body bgcolor =\"bbccff\">");
            out.println("<form  method =\"POST\"  action =\"./viewUser1\" ><br><br><br>");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>View User</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter user ID</td>");
            out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
       
            
          
         RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
     

 }
}