import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateTestPhaseServlet2 extends HttpServlet
{
      TMSManager tmsManager = null;
       Project projectObj = null;
      TestPhase testPhaseObj = null;

      
           
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

	 response.setContentType("text/html");
          PrintWriter out = response.getWriter();

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

         try
         {


           tmsManager = new TMSManager();
           projectObj = new Project();
           testPhaseObj = new TestPhase();
          String   phase_id = request.getParameter("phase_id");
           String  phase_name = request.getParameter("phase_name");
          String project_id = request.getParameter("project_id");
          String description = request.getParameter("description");
          int is_alive = Integer.parseInt(request.getParameter("is_alive"));
          String time_stamp = request.getParameter("time_stamp");

          testPhaseObj.setPhaseId(phase_id); 
          testPhaseObj.setPhaseName(phase_name);

          projectObj.setProjectId(project_id);
          testPhaseObj.setProjectObj(projectObj);

          testPhaseObj.setDescription(description);
          testPhaseObj.setIsAlive(is_alive);
          testPhaseObj.setTimeStamp(time_stamp);
       
          String message = tmsManager.updateTestPhase(testPhaseObj);   
         
          out.println("<html><body bgcolor = #ccffdd><center><h4>"+message+"</h4>");
	out.println("<a href=./TestManager>TestManagerHome</a>");
         out.println("<form name = form1 method = POST action = \"./updateTestPhase\"><br><br><br>");
            out.println("<table border = 0 width = 40% align = center bgcolor = #bbccff>");
            out.println("<caption><strong>Update Phase</strong></caption>");
            out.println("<tr><td>Enter Phase ID</td><td><input type = text name = phase_id ></td></tr>");
            out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
            out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
            out.println("</table></center></body>");
          out.println("</html>");

          System.out.println(message);
            }
          catch(Exception e){
               System.out.println(e.getMessage());
           }

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 