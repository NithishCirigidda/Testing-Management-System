import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ViewTestCaseServlet1 extends HttpServlet
 {
     TestCase testCaseObj= new TestCase();  
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
     { 

       RequestDispatcher rd1=req.getRequestDispatcher("./header");
       rd1.include(req,res);
       res.setContentType("text/html");
       PrintWriter out =res.getWriter();  
             
       try{
           TMSManager tmsManager=new TMSManager();
             
            String testcase_id= req.getParameter("Testcase_id"); 
	System.out.println("TestcaseId :"+testcase_id);
            TestCase testCaseObj=tmsManager.getTestCase(testcase_id);
             if(testCaseObj.getTestCaseId()==null)
             out.println("<h4 align = center>Please enter your Testcase id</h4>");
             else
                 {
                 out.println("<html>");
                 out.println("<body>");
                 out.println("<table border=0 align=center bgcolor=\"#bbccff\"><caption>TestCase Content</caption>");
                 out.println("<tr><td>TestCaseId:</td>");
                 out.println("<td>"+testCaseObj.getTestCaseId()+"</td></tr>");  
                 out.println("<tr><td>TestCaseDescription:</td>");
                 out.println("<td>"+testCaseObj.getTestCaseDescription()+"</td></tr>");
                 out.println("<tr><td>TestCasePhase:</td>");
                 out.println("<td>"+testCaseObj.getTestCasePhase()+"</td></tr>");
                
                 out.println("<tr><td>ProjectId</td>");       
                 Project projectObj=testCaseObj.getProjectObj(); 	
                 out.println("<td>"+projectObj.getProjectId()+"</td></tr>");   
                     
                 out.println("<tr><td>UserId</td>");
                 //User userObj = testCaseObj.getUserObj();
                 out.println("<td>"+testCaseObj.getUserObj().getUserId()+"</td></tr>");
                
                 out.println("<tr><td>ActivityId</td>");     
                 Activity activityObj=testCaseObj.getActivityObj();	
                 out.println("<td>"+activityObj.getActivityId()+"</td></tr>");
                
                 out.println("<tr><td>ExpectedBehaviour</td>");       
                 out.println("<td>"+testCaseObj.getExpectedBehaviour()+"</td></tr>") ;  
                 out.println("</table>");
                 out.println("</body></html>");
                  }
          }
            catch(Exception e)
              {
                 System.out.println(e.getMessage());
              }
               out.println("<html>");
               out.println("<head>");
               out.println("<title>ViewTestCase</title></head>");
               out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
               out.println("</body>");
               out.println("</html>");

                out.println("<form action = \"./viewTestcase1\" align=\"center\" method = POST>");
	out.println("<table border=0 align =center width=\"100\" bgcolor=\"#bbccff\">");
	out.println("<caption>ViewTestCase</caption>");
	out.println("<tr><td>TestCaseId :&nbsp&nbsp<input type=\"text\" name=\"Testcase_id\" value=\"\" /></td></tr>");
	out.println("</table></br>");
	out.println("<p align=\"center\">");
	out.println("<input type=submit name=\"submit\" value=send>");
	out.println("<input type=reset name=\"clear\" value=Clear>");
	out.println("</p>");
               out.println("</form></body></html>"); 
                RequestDispatcher rd2=req.getRequestDispatcher("./footer");
                rd2.include(req,res);

     }
}