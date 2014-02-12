import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewTestPhaseServlet1 extends HttpServlet
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
            
            String phase_id = request.getParameter("phase_id");
            testPhaseObj = tmsManager.getTestPhase(phase_id);
           
            if(testPhaseObj.getPhaseId() == null)
           out.println(" <h4 align = center>Please enter Phase id</h4>");

           else
          {
            phase_id = testPhaseObj.getPhaseId();
            String phase_name = testPhaseObj.getPhaseName();
            projectObj = testPhaseObj.getProjectObj();
            String project_id = projectObj.getProjectId();
            String description = testPhaseObj.getDescription();
            int is_alive = testPhaseObj.getIsAlive();
            String time_stamp = testPhaseObj.getTimeStamp() ;
            
            out.println("<html><head><title>View Test Phase</title></head>");
            out.println("<body bgcolor = #ccffdd>");
	out.println("<a href=./TestManager>TestManagerHome</a>");
            out.println("<table border = 1 border=black width = 200 align = center bgcolor = #bbccff>");
            out.println("<caption>Phase Content</caption>");
            out.println(" <tr><td>Phase ID</td><td>"+phase_id+"</td></tr>");
            out.println(" <tr><td>Phase Name</td><td>"+phase_name+"</td></tr>");
            out.println(" <tr><td>Project ID</td><td>"+project_id+"</td></tr>");
            out.println(" <tr><td>Description</td><td>"+description+"</td></tr>");
            out.println(" <tr><td>Is Alive</td><td>"+is_alive+"</td></tr>");
            out.println(" <tr><td>Time_Stamp</td><td>"+time_stamp+"</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
      }

    }
      catch(Exception e)
        {
               System.out.println(e.getMessage());
        }
       
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

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 
     } 
}
