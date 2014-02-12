import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DeleteTestCaseServlet extends HttpServlet
{
    TMSManager tmsManager=null;
    TestCase testCaseObj=null;      


    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
     {  
            
        RequestDispatcher rd1=req.getRequestDispatcher("./header");
        rd1.include(req,res);            

          try{

           tmsManager=new TMSManager();
           testCaseObj=new TestCase();

          res.setContentType("text/html"); 
          PrintWriter out =res.getWriter();   
      
          String testcase_id = req.getParameter("testcase_id");    
   
          
        out.println("<html>");
        out.println("<head><title>Deletion Of TestCase</title>");
        out.println("<body bgcolor =\"#bbffdd\">");
        out.println("<form action =\"./deleteTestcase\" method=POST>");
        out.println("<h3><center><td>DeleteTestCase</td><center></h3>");
        out.println("<table border=\"0\" align =center width=\"40%\" bgcolor=\"#bbccff\">");
        out.println("<tr><td>TestCaseId :<input type=\"text\" name=\"testcase_id\" /></td></tr>");
        out.println("<tr><td align =center ><input type=\"Submit\"  value=send>");
        out.println("<input type=reset  value=clear></td></tr>");
        out.println("</table></form></body></html>");

        String message = tmsManager.deleteTestCase(testcase_id);  
       if(testcase_id.equals(null))
       {
            out.println("<h4 align = center>Please enter your Testcase id</h4>");
       } 
        out.println("<h4 align = center>"+message+"</h4>");
      }
      catch(Exception e){
           System.out.println(e);   
      }

     RequestDispatcher rd2=req.getRequestDispatcher("./footer");
     rd2.include(req,res);
  }
}

         
           