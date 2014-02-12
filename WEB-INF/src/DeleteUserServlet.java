import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteUserServlet extends HttpServlet
{
      TMSManager tmsManager = null;
      User userObj=null;

      public DeleteUserServlet ()
      {
          try{
              tmsManager = new TMSManager();
             userObj=new User();
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
     }
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
          try{
            String user_id = request.getParameter("user_id");

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
         RequestDispatcher rd1=request.getRequestDispatcher("./header");
       rd1.include(request,response);


           out.println("<html><head><title>User Deletion</title></head>");
           out.println("<body bgcolor = #ccffdd >");
           out.println("<form  method = POST action = \"./deleteUser\" ><br><br><br>");
           out.println("<table border = 0 width = 40% align = center bgcolor = #bbccff>");
           out.println("<caption><strong>DeleteUser</strong></caption>");
           out.println("<tr><td>Enter  UserID</td><td><input type = text name = user_id ></td></tr>");
           out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
           out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
           out.println("</table></body>");
           out.println("</html>");

           String message = tmsManager.deleteUser(user_id);
          if(user_id == null)
                out.println("<h4 align = center>Pelase enter User id</h4>");
          else{
            out.println("<html><head><title>Delete User</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<h2><center>"+message+"</center></h2>");
            out.println("</body>");
            out.println("</html>");
              }

           }catch(Exception e){
               System.out.println(e.getMessage());
           }
        RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);

     } 

}
 