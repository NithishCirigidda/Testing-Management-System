import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CreateTestActivityServlet extends HttpServlet
{
     User userObj = null;
     TestPhase testPhaseObj = null;
     Activity activityObj = null;
     TMSManager tmsManager = null;
     
     public CreateTestActivityServlet() throws Exception{
     tmsManager = new TMSManager();
     activityObj = new Activity();
     testPhaseObj= new TestPhase();
     userObj = new User();
     }

     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

          try{

               response.setContentType("text/html");
               PrintWriter out = response.getWriter();

               out.println("<html><head><title>Activity Creation</title></head>");
               out.println("<body bgcolor = #ccffdd >");
               out.println("<a href=./TestManager>TestManagerHome</a>");
               out.println("<form  method = POST action = \"./createTestActivity\" >");
               out.println("<table border = 0 width = 45% align = center bgcolor = #bbccff>");
               out.println("<caption><b>CreateActivity</b></caption>");
               out.println("<tr><td>Activity ID</td><td><input type = text name = activity_id ><td></tr>");
               out.println("<tr><td>Phase ID</td><td><input type = text name = phase_id><td></tr>");
               out.println("<tr><td>Activity Name</td><td><input type = text name = activity_name><td><tr>");
               out.println("<tr><td valign = top>Activity Description</td><td><textarea rows = 4 cols = 16 name = activity_description></textarea><td></tr>");
               out.println("<tr><td>Activity Type</td><td><input type = text name = activity_type><td></tr>");
               out.println("<tr><td>Start Date (yyyy-mm-dd)</td><td><input type = text name = start_date><td></tr>");
               out.println("<tr><td>End Date (yyyy-mm-dd)</td><td><input type = text name = end_date><td></tr>");
               out.println("<tr><td>Activity effort</td><td><input type = text name = activity_effort><td></tr>");
               out.println("<tr><td>Status</td><td><input type = text name = status><td></tr>");
               out.println("<tr><td>Employee No</td><td><input type = text name = emp_no><td></tr>");
               out.println("<tr><td>Time Stamp</td><td><input type = text name = time_stamp><td></tr>");
               out.println("<tr ><td colspan = 2  align = center><input type = submit value = Submit><input type = Reset  value = Clear></td></tr>");
               out.println("</table></form>");
               out.println("</body></html>");
          
          String activity_id = request.getParameter("activity_id");
           System.out.println(activity_id);
          String phase_id = request.getParameter("phase_id");
	System.out.println(phase_id);	
          String activity_name = request.getParameter("activity_name");
		System.out.println(activity_name);	
          String activity_description = request.getParameter("activity_description");
		System.out.println(activity_description);
          int  activity_type = Integer.parseInt(request.getParameter("activity_type"));
		System.out.println(activity_type);


         //*******converting String to java.sql.Date*************

           String s1date= request.getParameter("start_date");
           /*String[] sdate = s1date.split("-");
                int sy=Integer.parseInt(sdate[0]);
	int sm=Integer.parseInt(sdate[1]);
	int sd=Integer.parseInt(sdate[2]);*/
           String e1date=request.getParameter("end_date");
         /*  String[] edate = e1date.split("-");
	int ey=Integer.parseInt(edate[0]);
	int em=Integer.parseInt(edate[1]);
	int ed=Integer.parseInt(edate[2]);*/

          java.sql.Date start_date =java.sql.Date.valueOf(s1date);
            
	System.out.println("Start date:"+start_date);
             java.sql.Date end_date =java.sql.Date.valueOf(e1date);
	System.out.println("End date:"+end_date);
          int  activity_effort = Integer.parseInt(request.getParameter("activity_effort"));
          int  status = Integer.parseInt(request.getParameter("status"));
          String emp_no = request.getParameter("emp_no");         
          String time_stamp1 = request.getParameter("time_stamp");
          java.sql.Date time_stamp=java.sql.Date.valueOf(time_stamp1);
	System.out.println("Time Stamp:"+time_stamp);
          activityObj.setActivityId(activity_id);

          testPhaseObj.setPhaseId(phase_id);
          activityObj.setTestPhaseObj(testPhaseObj);

          activityObj.setActivityName(activity_name);
          activityObj.setActivityDescription(activity_description);
          activityObj.setActivityType(activity_type);
          activityObj.setStartDate(start_date);
          activityObj.setEndDate(end_date);

          activityObj.setActivityEffort(activity_effort);
          activityObj.setStatus(status);

          userObj.setEmpNo(emp_no);
          activityObj.setUserObj(userObj);

          activityObj.setTimeStamp(time_stamp);

         
          String message = tmsManager.createTestActivity(activityObj);         
                                 
          out.println("<html><body><h4>"+message+"</h4></body></html>");
          System.out.println(message);
         }catch(Exception e){System.out.println("hai ........"+e.getMessage());}

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     }
}