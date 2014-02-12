import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CreateTestPhaseServlet extends HttpServlet
{
     TMSManager tmsManager = null;
     Project projectObj = null;
     TestPhase testPhaseObj = null;
    
       public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
            { 
          
          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response);  

         response.setContentType("text/html");
          PrintWriter out = response.getWriter();

          try{

         
          tmsManager = new TMSManager();
         projectObj = new Project();
         testPhaseObj = new TestPhase();


          out.println("<html><head><title>Phase Create</title></head>");
          out.println("<body bgcolor = #ccffdd >");
          out.println("<form  method = POST action = \"./createTestPhase\" >");
          out.println("<table  border = 1 width = 45% align = center bgcolor = #bbccff>");
          out.println("<caption><strong>CreatePhase</strong></caption>");
          out.println("<tr><td>Phase ID</td><td><input type = text name = phase_id ></td></tr>");
          out.println("<tr><td>Phase Name</td><td><input type = text name = phase_name></td></tr>");
          out.println("<tr><td>Project ID</td><td><input type = text name = project_id><td></tr><tr>");
          out.println("<td valign = top>Description</td><td><textarea rows = 4 cols = 16 name = description></textarea></td></tr>");
          out.println("<tr><td>Is Alive</td><td><input type = text name = is_alive></td></tr>");
          out.println("<tr><td>Time Stamp</td><td><input type = text name = time_stamp></td></tr>");
          out.println("<tr ><td colspan = 2  align =center><input type = submit  name = Submit value = Submit> <input type = Reset  name = Reset value = Clear></td></tr>");
          out.println("</table></form>");
	out.println("<a href=./TestManager>TestManagerHome</a>");
          out.println("</body></html>");
          
          String phase_id = request.getParameter("phase_id");
          String phase_name = request.getParameter("phase_name");
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
          
          String message = tmsManager.createTestPhase(testPhaseObj);   
       // out.println(message);
       if(message=="Test phase created successfully"){
          out.println("<html><body><h4 align = center>"+message+"</h4></body></html>");}
        else{
         out.println("<html><body><h4 align = center>\"Provide proper input fields\"</h4></body></html>");}
        
          }catch(Exception e){}

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 
     }
}