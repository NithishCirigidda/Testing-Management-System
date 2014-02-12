import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;

public class UpdateTestActivityServlet2 extends HttpServlet{
      TMSManager tmsManager = null;
      User userObj = null;
      TestPhase testPhaseObj = null;
      Activity activityObj = null;

      public UpdateTestActivityServlet2()
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
 public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 

          try{
  
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String activity_id = request.getParameter("activity_id");   
            String phase_id = request.getParameter("phase_id");
            String activity_name = request.getParameter("activity_name");
            String activity_description = request.getParameter("activity_description");           
            int activity_type = Integer.parseInt(request.getParameter("activity_type"));
         //*******converting String to java.sql.Date*************

           String s1date = request.getParameter("start_date");
           /*String[] sdate = s1date.split("-");
                int sy=Integer.parseInt(sdate[0]);
	int sm=Integer.parseInt(sdate[1]);
	int sd=Integer.parseInt(sdate[2]);*/
           String e1date=request.getParameter("end_date");
           /*String[] edate = e1date.split("-");
	int ey=Integer.parseInt(edate[0]);
	int em=Integer.parseInt(edate[1]);
	int ed=Integer.parseInt(edate[2]);*/

          java.sql.Date start_date = java.sql.Date.valueOf(s1date);
          java.sql.Date end_date =java.sql.Date.valueOf(e1date);
          int activity_effort = Integer.parseInt(request.getParameter("activity_effort"));
          int status = Integer.parseInt(request.getParameter("status"));

          String emp_no = request.getParameter("emp_no");         
          String  time_stamp1 = request.getParameter("time_stamp");
	java.sql.Date time_stamp=java.sql.Date.valueOf(time_stamp1);
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
      
        out.println("<h4 align = center>"+ tmsManager.updateTestActivity(activityObj)+"</h4>");         
        out.println("<a href=./TestManager>TestManagerHome</a>");
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
               System.out.println("2"+e.getMessage());
           }

          RequestDispatcher rd2 = request.getRequestDispatcher("/footer");	
          rd2.include(request,response);  
     }
}      