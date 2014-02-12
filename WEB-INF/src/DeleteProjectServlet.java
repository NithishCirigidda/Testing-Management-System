import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteProjectServlet extends HttpServlet
{
   TMSManager tmsManager = null;
      User userObj=null;
 Project projectObj=null;
      public DeleteProjectServlet ()
      {
          try{
     tmsManager = new TMSManager();
             userObj=new User();
                projectObj=new Project();
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
     }
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
          try{
            String project_id = request.getParameter("project_id");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
  RequestDispatcher rd1=request.getRequestDispatcher("./header");
          rd1.include(request,response);


           out.println("<html><head><title>Project Deletion</title></head>");
           out.println("<body bgcolor = #ccffdd >");
           out.println("<form  method = POST action = \"./deleteProject\" ><br><br><br>");
           out.println("<table border = 0 width = 40% align = center bgcolor = #bbccff>");
           out.println("<caption><strong>DeleteProject</strong></caption>");
           out.println("<tr><td>Enter  ProjectID</td><td><input type = text name = project_id ></td></tr>");
           out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
           out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
           out.println("</table></body>");
           out.println("</html>");
            String message=null;
             message= tmsManager.deleteProject(project_id);
            if(message == "failed")
                  out.println("<h4 align = center>Please enter valid Project id</h4>");
            else{
            out.println("<html><head><title>Delete Project</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<h2><center>"+message+"</center></h2>");
            out.println("</body>");
            out.println("</html>");
            }
              RequestDispatcher rd2=request.getRequestDispatcher("./footer");
              rd2.include(request,response);

           }catch(Exception e){
               System.out.println(e.getMessage());
           }
     } 
}
 