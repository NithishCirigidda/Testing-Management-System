import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ChangePasswordServlet extends HttpServlet
{

     TMSManager tmsManager = null;
      User userObj = null;

     public ChangePasswordServlet()
     {
         try{
          tmsManager = new TMSManager();
          userObj = new User();
          }catch(Exception e){
               System.out.println(e);
          }
     }
     public void service(HttpServletRequest request,HttpServletResponse response) 
     throws ServletException,IOException
    {
        try{

             RequestDispatcher rd1=request.getRequestDispatcher("./header");
             rd1.include(request, response);

             response.setContentType("text/html");
             PrintWriter out=response.getWriter();

            String user_id = request.getParameter("user_id");
            String oldPassword = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");
            String conformPassword = request.getParameter("conformPassword");
        
            out.println("<html><head><title>Change Password</title></head>");
            out.println("<body bgcolor = \"#ccffdd\" >");
            out.println("<form  method = \"POST\" action = \"./changePassword\"><br>");
            out.println("<table border = 0 width = \"45%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption>Change Password</caption>");
            out.println("<tr><td>Enter User ID</td>");
            out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
            out.println("<tr><td>Old Password</td><td><input type = \"password\" name = \"oldPassword\" ></td></tr>");
            out.println("<tr><td>New Password</td><td><input type = \"password\" name = \"newPassword\" ></td></tr>");
            out.println("<tr><td>Conform Password</td><td><input type = \"password\" name = \"conformPassword\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table></form></body></html>");
                     
            if(!newPassword.equals(conformPassword))
                 out.println("<h4 align = center>Please verify your new password and conform</h4>");
            else
            {

            String message = tmsManager.changePassword(user_id, oldPassword, newPassword);
            out.println("<h4 align = center>"+message+"<h4>");
            }
            }catch(Exception e){
                 System.out.println("in changePassword"+e);
            }
             RequestDispatcher rd2=request.getRequestDispatcher("./footer");
             rd2.include(request, response);
       }
 }
            