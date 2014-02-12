import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateProjectAssignmentServlet1 extends HttpServlet
{
      TMSManager tmsManager = null;
      User userObj = null;
      Project projectObj=null;
     ProjectAssignment projectAssignmentObj=null;
     
      



 public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

             response.setContentType("text/html");
             PrintWriter out = response.getWriter();
            RequestDispatcher rd1=request.getRequestDispatcher("./header");
            rd1.include(request,response);

          try{

            
              tmsManager = new TMSManager();
             userObj = new User();
            projectObj=new Project();
           projectAssignmentObj=new ProjectAssignment();
            out.println("<html><head><title>UpdateProjectAssignment</title></head>");
            out.println("<body onload=onSubmit() bgcolor =\"#ccffdd\">");
            out.println("<form  method =\"POST\"  action =\"./updateProjectAssignment\" ><br><br><br>");
            out.println("<table border = 1bordercolor=black width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>UpdateProjectAssignment</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter Project ID</td>");
            out.println("<td><input type = \"text\" name = \"project_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body></html>");

 


}catch(Exception e){
System.out.println("hai ........"+e.getMessage());
}

RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
  }
}
