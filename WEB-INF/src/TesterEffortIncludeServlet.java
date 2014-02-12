import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class TesterEffortIncludeServlet extends HttpServlet
 {

   TMSManager tmsManager= null;
    String empno = null;
     int effortobj=1; 
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
  
 {
                       
             res.setContentType("text/html");     
             PrintWriter out=res.getWriter();
             RequestDispatcher rd1= req.getRequestDispatcher("/header");	
             rd1.include(req,res);

                    try
	{

	 tmsManager=new TMSManager( );
              	empno=req.getParameter("emp_no");
                effortobj=tmsManager.getTesterEffort(empno);
	 if(effortobj==0)
	{
	 out.println("<h2 align=\"center\"> Invalid TesterId </h2>");
                     }
                  else
                 {	
              out.println("<h1 align=\"center\">Tester  Effort</h1>");
              out.println("<Table border =1 align = \"center\">");
              out.println("<tr bgcolor=#ccbbff>");
              out.println("<th>EmployeeID<th>Effort");
              out.println("<tr><td>" + empno +"</td><td>"+ effortobj  +"</td></tr>" );
              out.println("</table>");
	}
	}


              catch(Exception e)
	{


	}

             
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