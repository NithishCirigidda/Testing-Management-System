 import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Date;
public class UpdateTestCaseExeDetailsServlet1 extends HttpServlet
     {
             public void service(HttpServletRequest req,HttpServletResponse res)
           throws IOException,ServletException
          {

                RequestDispatcher rd1 = req.getRequestDispatcher("/header");
                rd1.include(req,res);
              try
              {
                res.setContentType("text/html"); 
                PrintWriter out =res.getWriter();      
                 out.println("<html>");
	out.println("<head>");
	out.println("<title>UpdateTestCaseExecutionDetails</title></head>");
	out.println("<body bgcolor =\"#bbffdd\" align=\"center\">");
	out.println("<form action = \"./updateTestCaseExecution2\" align=\"center\" method = POST>");
	out.println("<table border=\"0\" align =center width=\"100\" bgcolor=\"#bbccff\">");
	out.println("<caption>UpdateTestCaseExecutionDetatils</caption>");
	out.println("<tr><td>TestCaseId :&nbsp&nbsp");
                out.println("<input type=text name=\"testcase_id\"  /></td></tr></table></br>");
	out.println("<p align=\"center\">");
	out.println("<input type=submit name=\"submit\" value=send >");
	out.println("<input type=reset name=\"clear\" value=Clear >");
	out.println("</p>");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");

           
           }catch(Exception e){
                  System.out.println("texe"+e);
           }


                RequestDispatcher rd2 = req.getRequestDispatcher("/footer");
                rd2.include(req,res);

       }
}
