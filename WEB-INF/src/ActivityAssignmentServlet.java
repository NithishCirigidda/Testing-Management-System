import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ActivityAssignmentServlet extends HttpServlet
{
      TMSManager tmsManager = null;
      Activity activityObj = null;
      User userObj = null;
      ActivityUser activityUserObj = null;

      public ActivityAssignmentServlet()
      {
           try
           {
      
                tmsManager = new TMSManager();
                activityObj = new Activity();
                userObj = new User();
                activityUserObj = new ActivityUser();
           }
            catch(Exception e)
            {
                 System.out.println(e.getMessage());
            }
      }
      
      public void doGet(HttpServletRequest request, HttpServletResponse response)
                                   throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

         try
         {

             response.setContentType("text/html");
             PrintWriter out = response.getWriter();
                
             out.println("<html><head><title>Activity Assignment</title></head>");
             out.println("<body bgcolor = \"#ccffdd\" >");
             out.println("<form  method = \"GET\" action = \"./assignTestActivity\" >");
             out.println("<table border = \"0\" width = \"50%\" align = \"center\" bgcolor = \"#bbccff\">");
             out.println("<a href=./TestManager>TestManagerHome</a>");
             out.println("<caption><strong>Activity Assignment</strong></caption>");
             out.println("<tr><td>Activity ID</td><td><input type = \"text\" name = \"activity_id\" ><td></tr>");
             out.println("<tr><td>Employee No</td><td><input type = \"text\" name = \"emp_no\"><td></tr>");
             out.println("<tr><td>Activity Effort</td><td><input type = \"text\" name = \"activity_effort\"><td></tr>");
             out.println("<tr><td valign = \"top\">Activity Description</td>");
             out.println("<td><textarea rows = 4 cols = 16 name = \"activity_description\"></textarea><td></tr>");
             out.println("<tr><td>Start Date (yyyy-mm-dd)</td><td><input type = \"text\" name = \"start_date\"><td></tr>");
             out.println("<tr><td>End Date (yyyy-mm-dd)</td>");
             out.println("<td><input type = \"text\" name = \"end_date\"><td></tr>");
             out.println("<tr><td>Status</td>");
             out.println("<td><input type = \"text\" name = \"status\"><td></tr>");
             out.println("<tr><td>Percentage Completed</td>");
             out.println("<td><input type = \"text\" name = \"percentage_completed\"><td></tr>");
             out.println("<tr><td>Time Stamp</td>");
             out.println("<td><input type = \"text\" name = \"time_stamp\"><td></tr>");
             out.println("<tr ><td colspan = 2  align =\"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
             out.println("<input type = \"reset\"  name = \"Reset\" value = \"Clear\"</td></tr>");
             out.println("</table></form></body></html>");
             String activity_id = request.getParameter("activity_id");
             String emp_no = request.getParameter("emp_no");
             int activity_effort = Integer.parseInt(request.getParameter("activity_effort"));
            
             String sdate = request.getParameter("start_date");
            /* int sy = Integer.parseInt(sdate[0]);
             int sm = Integer.parseInt(sdate[1]);
             int sd = Integer.parseInt(sdate[2]);*/
             java.sql.Date start_date = java.sql.Date.valueOf(sdate);

             String edate = request.getParameter("end_date");
             /*int ey = Integer.parseInt(edate[0]);
             int em = Integer.parseInt(edate[1]);
             int ed = Integer.parseInt(edate[2]);*/
             java.sql.Date end_date = java.sql.Date.valueOf(edate);
        
             int status = Integer.parseInt(request.getParameter("status"));
             int percentage_completed = Integer.parseInt(request.getParameter("percentage_completed"));
             String time_stamp = request.getParameter("time_stamp");
	
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
      
            String message = tmsManager.assignTestActivity(activityUserObj);

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Activity Assignment</title>");
            out.println("</head>");
            out.println("<body bgcolor = #ffccbb >");
            out.println("<h4 align = center> Activity assigned successfully</h4>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     }
}