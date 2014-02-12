import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class TesterEffortServlet extends HttpServlet
 {


     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
       {
            
           
              res.setContentType("text/html");     
              PrintWriter out=res.getWriter();
              RequestDispatcher rd1= req.getRequestDispatcher("/header");	
              rd1.include(req,res);
                                
              out.println("<br>");
              out.println("<html>");
              out.println("<head>");
              out.println("<title>Tester Effort  </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Tester Effort </h3>");
              out.println("<form action=\"./TesterEffortInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
              out.println("<table align=\"center\" bgcolor=#ccbbff> ");
             
              out.println("<tr align=\"center\" ><td><b>Enter Emp_No:</b>&nbsp&nbsp<input type=\"text\" name=\"emp_no\"></td></tr>");
              out.println("<tr align=\"center\" ><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"Submit\" value=\" Submit\">&nbsp&nbsp<input type=\"Reset\" value=\"clear\"</td></tr>");
              out.println("</form>");
              out.println("</table>");
              out.println("<br>");

              out.println("</body>");
              out.println("</html>");


            RequestDispatcher rd2= req.getRequestDispatcher("/footer");	
            rd2.include(req,res);
              
         }
}