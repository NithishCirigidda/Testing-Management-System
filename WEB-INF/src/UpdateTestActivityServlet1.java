import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateTestActivityServlet1 extends HttpServlet{
      TMSManager tmsManager = null;
      User userObj = null;
      TestPhase testPhaseObj = null;
       Activity activityObj = null;

      public UpdateTestActivityServlet1()
      {
          try{
           tmsManager = new TMSManager();
           userObj = new User();
           testPhaseObj = new TestPhase();
           activityObj =  new Activity();
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
     }
 public void doGet(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

          try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><head><title>Activity Updation</title></head>");
            out.println("<body bgcolor = \"#ccffdd\" >");
            out.println("<form  method = \"POST\" action = \"./updateTestActivity\"><br><br><br>");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>Update Activity</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter Activity ID</td>");
            out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table></body></html>");
           }catch(Exception e){
               System.out.println("1"+e.getMessage());
           }

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}