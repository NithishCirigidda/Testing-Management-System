import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
public class ViewTestCaseExeDetailsServlet1 extends HttpServlet
{
    TMSManager  tmsManager=null;
     TestCase testCaseObj=null;
     Project projectObj=null;
     User userObj=null;
     Activity activityObj=null;
  public void service(HttpServletRequest req,HttpServletResponse res)
     throws IOException, ServletException
     {
          RequestDispatcher rd1=req.getRequestDispatcher("./header");
          rd1.include(req,res);
            res.setContentType("text/html");
             PrintWriter out=res.getWriter();
           try
           {
               tmsManager=new TMSManager();
                 testCaseObj=new  TestCase();
                 projectObj=new Project();
                 userObj=new User();
                 activityObj=new Activity(); 
                 String testcase_id=req.getParameter("testcase_id");
                 testCaseObj.setTestCaseId(testcase_id);
                 
                 TestCase testCaseObj=tmsManager.getTestCaseExecutionDetails(testcase_id);
                 if(testCaseObj.getTestCaseId()==null)
                   {
                      out.println("There is no testcase with this id");
                  }
                  else
                   {
                      out.println("<html><body><table border=0 bgcolor=#bbccff align=center>");

                      out.println("<tr><td>ActivityId</td>");
                      out.println("<td>"+testCaseObj.getActivityObj().getActivityId()+"</td></tr>");
                      out.println("<tr><td>TestCaseId</td>");
                      out.println("<td>"+testCaseObj.getTestCaseId()+"</td></tr>");
                      out.println("<tr><td>UserId</td>");       
                      out.println("<td>"+testCaseObj.getUserObj().getUserId()+"</td></tr>");
                      out.println("<tr><td>ActualDate</td>");       
                      out.println("<td>"+testCaseObj.getActualDate()+"</td></tr>") ;  
                      out.println("<tr><td>TestCaseStatus</td>");       
                      out.println("<td>"+testCaseObj.getTestCaseStatus()+"</td></tr>") ;  
                      out.println("<tr><td>Comments</td>");       
                      out.println("<td>"+testCaseObj.getComments()+"</td></tr>") ;  
                      out.println("<tr><td>ActualBehaviour</td>");       
                      out.println("<td>"+testCaseObj.getActualBehaviour()+"</td></tr>") ; 
                      out.println("</table></body></html>");      
                   }
                
           }
           catch(Exception s)
           {
                 System.out.println(s.toString());
           }
                 out.println("<html>");
                 out.println("<body bgcolor = \"#bbffdd\" >");
                 out.println("<form action = \"./viewTestCaseExecution1\"   method =Post >"); 
                 out.println("<table border = \"0\" width = \"200\" align = \"center\" bgcolor = \"#bbccff\">");
                 out.println("<caption>ViewTestCaseExeDetails</caption>");
                 out.println("<tr><td>TestCaseId</td>");
                 out.println("<td><input type = \"text\" name = \"testcase_id\" ></td></tr>");
                 out.println("<tr><td colspan = 2  align =\"center\"><input type = \"submit\" name=submit value = send></td></tr>");
                 out.println("</table>");
                 out.println("</form>"); 
                 out.println("</body>");
                 out.println("</html>"); 
     
                RequestDispatcher rd2=req.getRequestDispatcher("./footer");
                rd2.include(req,res);
 }
}