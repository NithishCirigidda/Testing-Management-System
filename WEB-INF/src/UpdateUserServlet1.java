import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateUserServlet1 extends HttpServlet
{
User userObj=null;
TMSManager tmsManager = null;



public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {   
   
response.setContentType("text/html");
          PrintWriter out = response.getWriter();


          try{
         userObj=new User();
        tmsManager = new TMSManager();
          
         RequestDispatcher rd1=request.getRequestDispatcher("./header");
         rd1.include(request,response);

          out.println("<html><head><title>UpdateUser</title></head>");
            out.println("<body onload=onSubmit() bgcolor =\"#ffcc00\">");
            out.println("<form  method =\"POST\"  action =\"./updateUser\" ><br><br><br>");
            out.println("<table border = 1 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>UpdateUser</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter User ID</td>");
            out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body></html>");

// String user_id = request.getParameter("user_id");
  //    userObj = tmsManager.getUser(user_id);
   }
catch(Exception e){
System.out.println(e.getMessage());
}

 RequestDispatcher rd2=request.getRequestDispatcher("./footer");
      rd2.include(request,response);

}
}