import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
 
public class UpdateActivityAssignmentServlet1 extends HttpServlet
{
      TMSManager tmsManager = null;
      User userObj = null;
      Activity activityObj = null;
      ActivityUser activityUserObj = null;

      public UpdateActivityAssignmentServlet1()
      {
          try{
           tmsManager = new TMSManager();
           userObj = new User();
           activityObj =  new Activity();
           activityUserObj = new ActivityUser();
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
     }
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

          try{

               response.setContentType("text/html");
               PrintWriter out = response.getWriter();

               out.println("<html><head><title>Activity Assignment Updation</title></head>");
               out.println("<body bgcolor = \"#ccffdd\" >");
               out.println("<form  method = POST action = \"./updateActivityAssignment2\"><br><br><br>");
               out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
               out.println("<caption><b>Update Activity Assignment</b></caption>");
               out.println("<tr><td style = font family: verdana>Enter Activity ID</td>");
               out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
               out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
               out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
               out.println("</table></body></html>");
             }catch(Exception e){
               System.out.println("1"+e);
           }

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 