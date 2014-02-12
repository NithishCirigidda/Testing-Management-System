import java.io.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateTestActivityEffortServlet extends HttpServlet
 {

       TestCase testCaseObj= null;  
       TMSManager tmsManager=null;
       Project projectObj=null;
       User userObj=null;
       Activity activityObj=null; 
       Effort effortObj=null;
       public void service(HttpServletRequest req,HttpServletResponse res)
       throws IOException, ServletException
      {  
	
	 RequestDispatcher  rd1 = req.getRequestDispatcher("/header");
	 rd1.include(req,res);
                 res.setContentType("text/html"); 
                 PrintWriter out =res.getWriter();   
                  
           try
          {
               tmsManager=new TMSManager();
               testCaseObj= new TestCase();
               projectObj = new Project();
               userObj = new User();
               activityObj = new Activity();
               effortObj=new Effort();
                
              
                                           
              String activity_id= req.getParameter("activity_id"); 
              effortObj=tmsManager.getTestActivityEffort(activity_id);
                        
            
            activityObj=effortObj.getActivityObj() ;  

                     if(activityObj==null)
                     {
                            out.println("There is no testcase with this id"); 
                     }
   
                                                    
                     else
                    {
                         // activityObj=effortObj.getActivityObj() ;  
                            activity_id=activityObj.getActivityId();
              
                            userObj=effortObj.getUserObj();
                            String emp_no=userObj.getEmpNo();

                            Date effort_date=effortObj.getEffortDate();
                            Date start_date=effortObj.getStartDate();
                            Date end_date=effortObj.getEndDate(); 
                            int effort=effortObj.getEffort(); 
                            String effort_description=effortObj.getEffortDescription();
                            String effort_time_stamp=effortObj.getEffortTimeStamp();  
             
           
              out.println("<html><body>");
              out.println("<form method = POST action = \"./updateTestActivityEffort\">");
              out.println("<table border=0 align=center bgcolor=\"#bbccff\"><caption>TestCase Content</caption>");
              out.println("<tr><td>Activity ID</td><td><input type = \"text\" name = \"activity_id\" value="+activity_id+"></td></tr>");              
              out.println("<tr><td>Employee No</td><td><input type = \"text\" name = \"emp_no\" value="+emp_no+"></td></tr>");
              out.println("<tr><td>EffortDate:</td>");
              out.println("<td><input type = \"text\" name = \"effort_date\" value="+effort_date+"> </td></tr>");
              out.println("<tr><td>StartDate:</td>");
              out.println("<td><input type = \"text\" name = \"start_date\" value="+start_date+"> </td></tr>");
              out.println("<tr><td>EndDate:</td>");
              out.println("<td><input type = \"text\" name = \"end_date\" value="+end_date+"> </td></tr>");
              out.println("<tr><td>Effort:</td>");
              out.println("<td><input type = \"text\" name = \"effort\" value="+effort+"> </td></tr>");
              out.println("<tr><td>EffortDescription:</td>");
              out.println("<td><input type = \"text\" name=\"effort_description\" value="+effort_description+"></td></tr>");
              out.println("<tr><td>TimeStamp:</td>");
              out.println("<td><input type = \"text\" name = \"effort_time_stamp\" value="+effort_time_stamp+"> </td></tr>");
              out.println("<tr><td><input type=submit name=\"submit\" value=Update></td></td>");
              out.println("</table></form>");
              out.println("</body></html>");
      
              activity_id=req.getParameter("activity_id");
              emp_no=req.getParameter("emp_no");


             /*------------*/
             String ef1date = req.getParameter("effort_date");
             String[] efdate = ef1date.split("-");
                   int efy=Integer.parseInt(efdate[0]);
	int efm=Integer.parseInt(efdate[1]);
	int efd=Integer.parseInt(efdate[2]);
             String s1date = req.getParameter("start_date");
             String[] sdate = s1date.split("-");
                   int sy=Integer.parseInt(sdate[0]);
	int sm=Integer.parseInt(sdate[1]);
 	int sd=Integer.parseInt(sdate[2]);
            String e1date=req.getParameter("end_date");
            String[] edate = e1date.split("-");
	int ey=Integer.parseInt(edate[0]);
	int em=Integer.parseInt(edate[1]);
	int ed=Integer.parseInt(edate[2]);

          Date effort_date1 =new     java.sql.Date(efy,efm,efd);
          Date start_date1 =new     java.sql.Date(sy,sm,sd);
          Date end_date1 =new     java.sql.Date(ey,em,ed);
             /*------------*/
           
          
              effort=Integer.parseInt(req.getParameter("effort")); 
              effort_description=req.getParameter("effort_description");
              effort_time_stamp=req.getParameter("effort_time_stamp");  
             
              activityObj.setActivityId(activity_id);
              effortObj.setActivityObj(activityObj);
              userObj.setEmpNo(emp_no);
              effortObj.setUserObj(userObj);
              effortObj.setEffortDate(effort_date1);
              effortObj.setStartDate(start_date1);
              effortObj.setEndDate(end_date1);
              effortObj.setEffort(effort);
              effortObj.setEffortDescription(effort_description);
              effortObj.setEffortTimeStamp(effort_time_stamp);
         
              String msg = tmsManager.updateTestActivityEffort(effortObj);
              out.println(msg);
           } 
           
       }
        catch(Exception e)
       { 
            System.out.println(e);
       }
                 out.println("<html>");
              out.println("<head>");
              out.println("<title>UpdateTestActivityEffort</title></head>");
              out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
              out.println("<form action = \"./updateTestActivityEffort\" align=\"center\" method = Post>");
              out.println("<table border=\"0\" align =center width=\"100\" bgcolor=\"#bbccff\">");
              out.println("<caption>UpdateTestActivityEffort</caption>");
              out.println("<tr><td>ActivityId<input type=\"text\" name=\"activity_id\"></td></tr>");
              out.println("</table>");            
              out.println("<p align=center ><input type=submit name=\"submit\" value=send>");
              out.println("<input type=reset name=\"clear\" value=Clear></p>");
              out.println("</form></body></html>");
	RequestDispatcher rd3 = req.getRequestDispatcher("/footer");
              rd3.include(req,res);
    }
}

 
    
