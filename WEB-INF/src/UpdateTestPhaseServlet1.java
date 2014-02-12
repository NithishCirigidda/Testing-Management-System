import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateTestPhaseServlet1 extends HttpServlet
{
    
     
    
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 
 response.setContentType("text/html");
            PrintWriter out = response.getWriter();

          try{
	
             System.out.println("In Servlet1");
          
           

            out.println("<html><head><title>Phase Updation </title></head>");
            out.println("<body onload = onSubmit() bgcolor = #ccffdd >");
            out.println("<form name = form1 method = POST action = \"./updateTestPhase\"><br><br><br>");
            out.println("<table border = 1 border=\"black\" width = 40% align = center bgcolor = #bbccff>");
            out.println("<caption><strong>Update Phase</strong></caption>");
            out.println("<tr><td>Enter Phase ID</td><td><input type = text name = phase_id ></td></tr>");
            out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
            out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
            out.println("</table></body>");
            out.println("</html>");
          }

         catch(Exception e)
          {
           System.out.println(e.getMessage());
           }

           RequestDispatcher rd2=request.getRequestDispatcher("./footer");
           rd2.include(request,response);

 }
}
