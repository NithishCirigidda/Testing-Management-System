import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;

public class ViewTestActivityEffortServlet1 extends HttpServlet
     {
         TMSManager tmsManager=null;   
         Activity activityObj=null;
         Effort effortObj=null;
          public void service(HttpServletRequest Req,HttpServletResponse Res) throws IOException,ServletException
            {
                  Res.setContentType("text/html");
                  PrintWriter out=Res.getWriter();
                  RequestDispatcher rd1 = Req.getRequestDispatcher("/header");
	  rd1.include(Req, Res);
             try
             {  
                  tmsManager=new TMSManager();
                  activityObj=new Activity();      
                  effortObj=new Effort();
                   String activity_id= Req.getParameter("activity_id"); 


                   Effort effortObj=tmsManager.getTestActivityEffort(activity_id);
                   if(effortObj.getActivityObj()==null)
                       out.println("<h4 align=\"center\">There is no ActivityId with this id</h4>");
                else
                 {
               out.println("<html>");
               out.println("<body>");
               out.println("<table border=0 align=center bgcolor=\"#bbccff\"><caption>TestCase Content</caption>");
               out.println("<tr><td>ActivityId:</td>");
               out.println("<td>"+effortObj.getActivityObj().getActivityId()+"</td>");    

               out.println("<tr><td>EmpNo:</td>");
               User userObj = effortObj.getUserObj();
               out.println("<td>"+userObj.getEmpNo()+"</td></tr>");  

               out.println("<tr><td>EffortDate:</td>");
               out.println("<td>"+effortObj.getEffortDate()+"</td></tr>");
             
               out.println("<tr><td>StartDate:</td>");
               out.println("<td>"+effortObj.getStartDate()+"</td></tr>");
                
               out.println("<tr><td>EndDate</td>");       	
               out.println("<td>"+effortObj.getEndDate()+"</td></tr>");   
                
               out.println("<tr><td>Effort</td>");     
               out.println("<td>"+effortObj.getEffort()+"</td></tr>");
                
                out.println("<tr><td>Description</td>");       
                out.println("<td>"+effortObj.getEffortDescription()+"</td></tr>") ;  

                out.println("<tr><td>TimeStamp</td>");       
                out.println("<td>"+effortObj.getEffortTimeStamp()+"</td></tr>") ;  

                out.println("</table>");
                out.println("</body></html>");
            }
         
         }
            catch(Exception s)
           {
                 System.out.println(s);
          }
                out.println("<html>");
	out.println("<head>");
	out.println("<title>ViewTestActivityEffortServlet</title></head>");
	out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
	out.println("<form action = \"./viewTestActivityEffort1\" align=\"center\" method = Post>");
	out.println("<table border=0 align =center width=\"100\" bgcolor=\"#bbccff\">");
	out.println("<caption>ViewTestActivityEffortServlet</caption>");
                   out.println("<tr><td>ActivityId :<input type=\"text\" name=\"activity_id\" /></td></tr>");
	out.println("<tr><td><input type=submit name=\"submit\" value=send></td>");
	out.println("<td><input type=reset name=\"clear\" value=Clear></td></tr>");
	out.println("</table></br>");
	out.println("</form></body></html>");
                RequestDispatcher rd2 = Req.getRequestDispatcher("/footer");
                rd2.include(Req, Res);  
    }
}
                   