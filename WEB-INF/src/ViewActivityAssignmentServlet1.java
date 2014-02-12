import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewActivityAssignmentServlet1 extends HttpServlet
{
 TMSManager tmsManager = null;
      User userObj = null;
      Activity activityObj = null;
      ActivityUser activityUserObj = null;

     
         
          

    public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 
          
         response.setContentType("text/html");
         PrintWriter out = response.getWriter(); 
          try{
           tmsManager = new TMSManager();
           userObj = new User();
           activityObj =  new Activity();
           activityUserObj = new ActivityUser();
                
               String activity_id = request.getParameter("activity_id");
            //activityObj.setActivityId(activity_id);
            activityUserObj = tmsManager.getTestActivityAssignment(activity_id);

            if(activityUserObj.getActivityObj()==null)
             out.println(" <h4 align = center>Please enter valid activity id</h4>");
            else
             { 
            activityObj = activityUserObj.getActivityObj();
            activity_id = activityObj.getActivityId();

            userObj = activityUserObj.getUserObj();
            String emp_no = userObj.getEmpNo();

            int activity_effort = activityUserObj.getActivityEffort();
            java.sql.Date start_date = activityUserObj.getStartDate();
            java.sql.Date end_date = activityUserObj.getEndDate();
            int status = activityUserObj.getStatus();
            int percentage_completed = activityUserObj.getPercentageCompleted();
            String time_stamp = activityUserObj.getTimeStamp() ;
                      
            out.println("<html><head><title>View Test Phase</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<table border = 0 width = 250 align = center bgcolor = #bbccff>");
            out.println("<caption>Activity Assignment Content</caption>");
            out.println(" <tr><td>Activity ID</td><td>"+activity_id+"</td></tr>");
            out.println(" <tr><td>Employee No</td><td>"+emp_no+"</td></tr>");
            out.println(" <tr><td>Activity Effort</td><td>"+activity_effort+"</td></tr>");
            out.println(" <tr><td>Start Date</td><td>"+start_date+"</td></tr>");
            out.println(" <tr><td>End Date</td><td>"+end_date+"</td></tr>");
            out.println(" <tr><td>Status</td><td>"+status+"</td></tr>");
            out.println(" <tr><td>Percentage Completed</td><td>"+percentage_completed+"</td></tr>");
            out.println(" <tr><td>Time Stamp</td><td>"+time_stamp+"</td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html><br><br>");
            }  
         }catch(Exception e){
               System.out.println("view"+e);
           }
                out.println("<html><head><title>Activity Assignment View</title></head>");
              out.println("<body bgcolor = \"#ccffdd\" >");
              out.println("<form  method = \"POST\" action = \"./viewActivityAssignment1\"><br><br>");
              out.println("<table border = 2 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
              out.println("<caption><b>ViewActivity Assignment</b></caption>");
              out.println("<tr><td style = font family: verdana>Enter Activity ID</td>");
              out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
              out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
              out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
              out.println("</table></body></html>");

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 