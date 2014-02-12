import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
 
public class UpdateActivityAssignmentServlet3 extends HttpServlet
{
      TMSManager tmsManager = null;
      User userObj = null;
      Activity activityObj = null;
      ActivityUser activityUserObj = null;
      public UpdateActivityAssignmentServlet3()
       {
             try
             {
             tmsManager = new TMSManager();
           userObj = new User();
           activityObj =  new Activity();
           activityUserObj = new ActivityUser();
            }catch(Exception e)
              {}

       }
   
          
     
     public void doPost(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          
           
          
          try{                

            String activity_id = request.getParameter("activity_id");

            String emp_no = request.getParameter("emp_no");

            int activity_effort = Integer.parseInt(request.getParameter("activity_effort"));  
     
          String sdate = request.getParameter("start_date");
                /*int sy = Integer.parseInt(sdate[0]);
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

           String message=null;
             message=tmsManager.updateTestActivityAssignment(activityUserObj);
            //out.println(message);
              //out.println("<h4 align = center> + message + </h4>");
	out.println("<a href=./TestManager>TestManagerHome</a>");
             }catch(Exception e){
               System.out.println("3"+e);
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
 