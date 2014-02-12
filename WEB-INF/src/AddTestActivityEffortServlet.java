
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddTestActivityEffortServlet  extends HttpServlet
{
     TMSManager tmsManager=null;
     Activity activityObj=null;   
     Effort effortObj=null;
     User userObj=null; 
     public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
     {
          try
         {
              effortObj=new Effort(); 
              tmsManager=new TMSManager();
              activityObj= new Activity();
              userObj=new User();
              res.setContentType("text/html");  
              PrintWriter out=res.getWriter();
                 RequestDispatcher rd1= req.getRequestDispatcher("/header");	
              rd1.include(req,res);

              out.println("<html>");
              out.println("<body bgcolor = \"#bbffdd\" >");
              out.println("<form action = \"./addTestActivityEffort\"   method =post >"); 
              out.println("<table align=center bgcolor=\"bbccff\">");
              out.println("<caption>ActivityEffort</caption>");
              out.println("<tr><td>ActivityId</td>");
              out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
              out.println("<tr><td>EmpNo</td>");
              out.println("<td><input type = \"text\" name = \"emp_no\" ></td></tr>");
              out.println("<tr><td>EffortDate</td>");
              out.println("<td><input type = \"text\" name = \"effort_date\" ></td></tr>");
              out.println("<tr><td>StartDate</td>");
              out.println("<td><input type = \"text\" name = \"start_date\" ></td></tr>");
              out.println("<tr><td>EndDate</td>");
              out.println("<td><input type = \"text\" name = \"end_date\" ></td></tr>");
              out.println("<tr><td>Effort</td>");
              out.println("<td><input type = \"text\" name = \"effort\" ></td></tr>");
              out.println("<tr><td>Description</td>");
              out.println("<td><input type = \"text\" name = \"effort_description\" ></td></tr>");
              out.println("<tr><td>TimeStamp</td>");
              out.println("<td><input type = \"text\" name = \"effort_time_stamp\" ></td></tr>");
              out.println("<tr><td><input type =\"submit\"  value=Submit ></td>");
              out.println("<td><input type =Reset  value=clear></td></tr>");
              out.println("</table></form></body></html>");
   
/* 
              String [] edate = effort_date.split("-");
              int ey = Integer.parseInt(edate[0]);
              int em = Integer.parseInt(edate[1]);
              int ed = Integer.parseInt(edate[2]);                       
              Date effortDate = new Date(ey,em,ed);

              String [] sdate = start_date.split("-");
              int sy = Integer.parseInt(sdate[0]);
              int sm = Integer.parseInt(sdate[1]);
              int sd = Integer.parseInt(sdate[2]);                       
              Date startDate = new Date(sy,sm,sd);

              String [] eddate = end_date.split("-");
              int edy = Integer.parseInt(eddate[0]);
              int edm = Integer.parseInt(eddate[1]);
              int edd = Integer.parseInt(eddate[2]);                       
              Date endDate = new Date(edy,edm,edd);
              
*/           

    
              String activity_id=req.getParameter("activity_id");
              String emp_no=req.getParameter("emp_no");
              String effort_date1=req.getParameter("effort_date");
	java.sql.Date effort_date=java.sql.Date.valueOf(effort_date1);
              String start_date1=req.getParameter("start_date");
	java.sql.Date start_date=java.sql.Date.valueOf(start_date1);
              String end_date1=req.getParameter("end_date"); 
	java.sql.Date end_date=java.sql.Date.valueOf(end_date1);
              int effort=Integer.parseInt(req.getParameter("effort")); 
              String effort_description=req.getParameter("effort_description");
              String effort_time_stamp=req.getParameter("effort_time_stamp");  



               
              activityObj.setActivityId(activity_id);
              effortObj.setActivityObj(activityObj);
              userObj.setEmpNo(emp_no);
              effortObj.setUserObj(userObj);
              effortObj.setEffortDate(effort_date);
              effortObj.setStartDate(start_date);
              effortObj.setEndDate(end_date);
              effortObj.setEffort(effort);
              effortObj.setEffortDescription(effort_description);
              effortObj.setEffortTimeStamp(effort_time_stamp);
   
              String msg = tmsManager.addTestActivityEffort(effortObj);
              out.println(msg);
        }   
        catch(Exception e)
       { 
            System.out.println(e.getMessage());
       }

          RequestDispatcher rd2= req.getRequestDispatcher("/footer");	
              rd2.include(req,res);

    }
}
