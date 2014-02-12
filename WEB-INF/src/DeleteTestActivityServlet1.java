import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteTestActivityServlet1 extends HttpServlet
{
      TMSManager tmsManager = null;
      Activity activityObj = null;

                   
     
     public void doGet(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
           response.setContentType("text/html");
             PrintWriter out = response.getWriter();
          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

          try{

            tmsManager = new TMSManager();
              activityObj = new Activity();
           
               
            

           
            String activity_id = request.getParameter("activity_id");
            String message = tmsManager.deleteTestActivity(activity_id);
            
           
          out.println("<h2><center>"+message+"</center></h2>");
             

            out.println("<html><head><title>Activity Deletion</title></head>");
            out.println("<body bgcolor = \"#ccffdd\" >");
            out.println("<form  method = \"GET\" action = \"./deleteTestActivity1\" ><br><br><br>");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><strong>Delete Activity</strong></caption>");
            out.println("<tr><td>Enter Activity ID</td>");
            out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table></body></html>");
          


             
           // out.println("<body bgcolor = #ccffdd>");
            //out.println("<h2><center>"+message+"</center></h2>");
            //out.println("</body>");
            //out.println("</html>");
           }catch(Exception e){
               System.out.println(e.getMessage());
           }



           

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 




     } 
}
 