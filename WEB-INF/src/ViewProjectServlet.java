import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewProjectServlet extends HttpServlet
{
     

 public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
          try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
         
           RequestDispatcher rd1=request.getRequestDispatcher("./header");
           rd1.include(request,response); 
         
            out.println("<html><head><title>View Project</title></head>");
            out.println("<body bgcolor =\"#ccffdd\">");
            out.println("<form  method =\"POST\"  action =\"./viewProject1\" ><br><br><br>");
            out.println("<table border = 2 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>View Project</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter Project ID</td>");
            out.println("<td><input type = \"text\" name = \"project_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        
 
 
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
     
RequestDispatcher rd2=request.getRequestDispatcher("./footer");
    rd2.include(request,response);
} 
}
