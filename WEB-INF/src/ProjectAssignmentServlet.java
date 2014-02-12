
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ProjectAssignmentServlet extends HttpServlet
{
   

public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {   


  response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          try{
  RequestDispatcher rd1=request.getRequestDispatcher("./header");
          rd1.include(request,response);

            
        



          out.println("<html><head><title>Project Assignment</title></head>");
          out.println("<body bgcolor = #ccffdd >");
          out.println("<form  method = POST action = \"./projectAssignmentDetails1\">");
          out.println("<table border = 0 width = 45% align = center bgcolor = #bbccff>");
          out.println("<caption><strong>Project Assignment</strong></caption>");
         
       out.println("<tr><td>Project Id</td><td><input type = text name =project_id  ><td></tr>");
          out.println("<tr><td>ProjectName</td><td><input type = text name = project_name><td></tr>");
          out.println("<tr><td>EmpNo</td><td><input type = text name = emp_no><td></tr><tr>");
        out.println("<tr><td>EmpName</td><td><input type = text name =emp_name  ><td></tr>");

         out.println("<tr><td>PlanstartDate</td><td><input type = text name =planstart_date ><td></tr>");
          out.println("<tr><td>PlanEndDate</td><td><input type = text name = planend_date><td></tr>");
          out.println("<tr><td>TimeStamp</td><td><input type = text name = time_stamp><td></tr><tr>");
        out.println("<tr><td>IsAlive</td><td><input type = text name =is_alive  ><td></tr>");


  out.println("<tr><td colspan = 2  align =\"center\"><input type = \"submit\" name=submit value = submit>");
         out.println("<input type = \"Reset\" name=reset value = clear></td></tr>");
         out.println("</table></form></body></html>");

   
         

}
catch(Exception e)
{
System.out.println(e.getMessage());
}

RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
  }
}
