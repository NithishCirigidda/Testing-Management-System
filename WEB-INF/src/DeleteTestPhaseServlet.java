import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteTestPhaseServlet extends HttpServlet
{
      TMSManager tmsManager = null;
      TestPhase testPhaseObj = null;

      public DeleteTestPhaseServlet()
      {
          try{
              tmsManager = new TMSManager();
              testPhaseObj = new TestPhase();
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
     }
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

          try{

            String phase_id = request.getParameter("phase_id");
            String message = tmsManager.deleteTestPhase(phase_id);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

           out.println("<html><head><title>Phase Deletion</title></head>");
           out.println("<body bgcolor = #ccffdd >");
           out.println("<form  method = POST action = \"./deleteTestPhase\" ><br><br><br>");
           out.println("<table border = 0 width = 40% align = center bgcolor = #bbccff>");
out.println("<a href=./TestManager>TestManagerHome</a>");
           out.println("<caption><strong>DeletePhase</strong></caption>");
           out.println("<tr><td>Enter Phase ID</td><td><input type = text name = phase_id ></td></tr>");
           out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
           out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
           out.println("</table></body>");
           out.println("</html>");

       
            out.println("<html><head><title>Delete Test Phase</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<h2><center>"+message+"</center></h2>");
	
            out.println("</body>");
            out.println("</html>");
           }catch(Exception e){
               System.out.println(e.getMessage());
           }

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 