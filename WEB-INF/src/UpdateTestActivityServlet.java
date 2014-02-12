import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateTestActivityServlet extends HttpServlet{
      TMSManager tmsManager = null;
      User userObj = null;
      TestPhase testPhaseObj = null;
       Activity activityObj = null;

    
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
           testPhaseObj = new TestPhase();
           activityObj =  new Activity();
            String activity_id = request.getParameter("activity_id");            
            activityObj = tmsManager.getTestActivity(activity_id);
            
           
                 
            if(activityObj.getActivityId() == null){
            out.println("<h4 align = center>Please enter your Activity Id</h4>");


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

          }




            else{
            activity_id = activityObj.getActivityId();

            testPhaseObj = activityObj.getTestPhaseObj();
            String phase_id = testPhaseObj.getPhaseId();

            String activity_name = activityObj.getActivityName();
            String activity_description = activityObj.getActivityDescription();
            int activity_type = activityObj.getActivityType();    
            java.sql.Date start_date = activityObj.getStartDate();
            java.sql.Date end_date = activityObj.getEndDate();
            int activity_effort = activityObj.getActivityEffort();
            int status = activityObj.getStatus();

            userObj = activityObj.getUserObj();
            String emp_no = userObj.getEmpNo();

            java.sql.Date time_stamp = activityObj.getTimeStamp();
             
            out.println("<html><head><title>Update Test Activity</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<form method = \"POST\" action = \"./updateTestActivity2\">");
            out.println("<table border = 0 width = 45% align = center bgcolor = #bbccff>");
            out.println("<caption>Activity Content</caption>");
            out.println(" <tr><td>Activity ID</td><td><input type = text  name = activity_id  value = "+activity_id+" /></td></tr>");
            out.println(" <tr><td>Phase ID</td><td><input type = text  name = phase_id  value = "+phase_id+" /></td></tr>");
            out.println(" <tr><td>Activity Name</td><td><input type = text name = activity_name value = "+activity_name+" /></td></tr>");
            out.println(" <tr><td>Activity Description</td><td><input type = text  name = activity_description  value = "+activity_description+" /></td></tr>");
            out.println(" <tr><td>Activity Type</td><td><input type = text name = activity_type value = "+activity_type+" /></td></tr>");
            out.println(" <tr><td>Start Date</td><td><input type = text name = start_date value = "+start_date+" /></td></tr>");
            out.println(" <tr><td>End Date</td><td><input type = text name = end_date value = "+end_date+" /></td></tr>");
            out.println(" <tr><td>Activity Effort</td><td><input type = text name = activity_effort value = "+activity_effort+" /></td></tr>");
            out.println("<tr><td>Status</td><td><input type = text name = status value = "+status+" /></td></tr>");
            out.println(" <tr><td>Employee No</td><td><input type = text name = emp_no value = "+emp_no+" /></td></tr>");
            out.println(" <tr><td>Time Stamp</td><td><input type = text name = time_stamp value  = "+time_stamp+" /></td></tr>");
            out.println("<tr><td colspan = 2 align = center ><input type = submit  name = submit value = Update ><input type = Reset name = Reset value = Clear></td></tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
           

 
       }
           }catch(Exception e){
               System.out.println(e);
           }

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}

 