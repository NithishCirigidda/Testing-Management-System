import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewTestPhaseServlet extends HttpServlet
{
      
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

          try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><head><title>Phase View</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<form  method = POST action = \"./viewTestPhase1\" ><br><br><br>");
            out.println("<table border = 1 border= black width = 40% align = center bgcolor = #bbccff>");
            out.println("<caption><strong>ViewPhase</strong></caption>");
            out.println("<tr><td>Enter Phase ID</td><td><input type = text name = phase_id ></td></tr>");
            out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
            out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
            out.println("</table></body>");
            out.println("</html>");
          
      
           }catch(Exception e){
               System.out.println(e.getMessage());
           }

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 
     } 
}
 