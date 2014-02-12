import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewProjectServlet1 extends HttpServlet
{
     TMSManager tmsManager = null;
      User userObj = null;
      Project projectObj=null;
   
      public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
               response.setContentType("text/html");
               PrintWriter out = response.getWriter();
	  RequestDispatcher rd1=request.getRequestDispatcher("./header");
               rd1.include(request,response); 
               
            try
           {
               tmsManager = new TMSManager();
               userObj = new User();
               projectObj=new Project();
              
               
             
               String project_id = request.getParameter("project_id");
            
               projectObj = tmsManager.getProject(project_id);
              if(projectObj.getProjectId() == null)
{
           
  
            out.println(" <h2 align = center>Please enter Valid Project id</h2>");
}
              else
              {
               project_id = projectObj.getProjectId();
               String project_name= projectObj.getProjectName();
               String description = projectObj.getDescription();
               int is_alive=projectObj.getIsAlive();
               String time_stamp = projectObj.getTimeStamp();

              out.println("<html><head><title>View Project</title></head>");
              out.println("<body bgcolor = #ccffdd>");
              out.println("<table border = 2 width = 45% align = center bgcolor = #bbccff>");
	out.println("<a href=./TestManager>TestManagerHome</a>");
              out.println("<caption>Project Content</caption>");
              out.println(" <tr><td>ProjectId</td><td>"+project_id+"</td></tr>");
              out.println(" <tr><td>ProjectName</td><td>"+project_name+"</td></tr>");
              out.println(" <tr><td>Description</td><td>"+description+"</td></tr>");
              out.println(" <tr><td>IsAlive</td><td>"+is_alive+"</td></tr>");
              out.println(" <tr><td>TimeStamp</td><td>"+time_stamp+"</td></tr>");

              out.println("</table>");
              out.println("</body>");
              out.println("</html>");

             }
           }
             catch(Exception e)
             {
               System.out.println(e.getMessage());
             }
     
            out.println("<html><head><title>View Project</title></head>");
            out.println("<body bgcolor =\"#ccffdd\">");
            out.println("<form  method =\"POST\"  action =\"./viewProject1\" ><br><br><br>");
            out.println("<table border =  2 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>View Project</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter Project ID</td>");
            out.println("<td><input type = \"text\" name = \"project_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
    } 
}
         
