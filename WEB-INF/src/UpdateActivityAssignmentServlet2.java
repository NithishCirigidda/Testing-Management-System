import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
 
public class UpdateActivityAssignmentServlet2 extends HttpServlet
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
             activityUserObj = tmsManager.getTestActivityAssignment(activity_id);
              if(activityUserObj.getActivityObj()==null)
              {
               out.println(" <h4 align= \"center\">Please Enter Valid Activityid</h4>");
               } 
           
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
             
               activityObj.setActivityId(activity_id);
            activityUserObj.setActivityObj(activityObj);

            userObj.setEmpNo(emp_no);
            activityUserObj.setUserObj(userObj);

            activityUserObj.setActivityEffort(activity_effort);
            activityUserObj.setStartDate(start_date);
            activityUserObj.setEndDate(end_date);
            activityUserObj.setStatus(status);
            activityUserObj.setPercentageCompleted(percentage_completed);
            activityUserObj.setTimeStamp(time_stamp);
            
           
            out.println("<html><head><title>Update Activity Assignment</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<form method = POST action = \"./updateActivityAssignment3\">");
            out.println("<table border = 0 width = 200 align = center bgcolor = #bbccff>");
            out.println("<caption>Activity Assignment Content</caption>");
            out.println(" <tr><td>Activity ID</td><td><input type = text name = activity_id value ="+activity_id+" /></td></tr>");
            out.println(" <tr><td>Employee No</td><td><input type = text name = emp_no value ="+emp_no+" /></td></tr>");
            out.println(" <tr><td>Activity Effort</td><td><input type = text name = activity_effort value = "+activity_effort+" /></td></tr>");
            out.println(" <tr><td>Start Date</td><td><input type = text name = start_date value = "+start_date+" /></td></tr>");
            out.println(" <tr><td>End Date</td><td><input type = text name = end_date value ="+end_date+" /></td></tr>");
            out.println(" <tr><td>Status</td><td><input type = text name = status value = "+status+" /></td></tr>");
            out.println(" <tr><td>Percentage Completed</td><td><input type = text name = percentage_completed value = "+percentage_completed+" /></td></tr>");
            out.println(" <tr><td>Time Stamp</td><td><input type = text name = time_stamp value = "+time_stamp+" /></td></tr>");
            out.println("<tr><td colspan = 2 align = center ><input type = submit  name = submit value = Update /><input type = Reset name = Reset value = Clear /></td></tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
           }
           }catch(Exception e){
               System.out.println("2"+e);
           }
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

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 