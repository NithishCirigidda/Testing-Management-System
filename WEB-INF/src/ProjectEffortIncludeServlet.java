import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProjectEffortIncludeServlet extends HttpServlet
 {
 	
            TMSManager tmsManager= null;
             int effortobj=-1;
              String projectId=null;
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
       {
          
              res.setContentType("text/html");     
              PrintWriter out=res.getWriter();
	RequestDispatcher rd1= req.getRequestDispatcher("/header");	
	rd1.include(req,res);

                     try

                    {
                                 tmsManager = new TMSManager();         
                                 projectId=req.getParameter("project_id");
		int effortobj=-1;                             
                                effortobj = tmsManager.getProjectEffort(projectId);
            		
                                 if(effortobj==0)
                                    {
                                    out.println("<h2 align=\"center\"> Invalid ProjectId </h2>");        
                                    }
		else
                                        {                 
                                    out.println("<h1 align=\"center\">Project Effort</h1>");
                                    out.println("<Table border =1 align = \"center\">");
                                    out.println("<tr bgcolor=#ccbbff>");
                                    out.println("<th>ProjectID<th>Effort");
                               
                                      out.println("<tr><td>" + projectId +"</td><td>"+ effortobj  +"</td></tr>" );
                                       out.println("</table>");
	                      }
              
                  }
	catch(Exception ex)
	{
	}
             out.println("<br>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title> Project Effort  </title>");
             out.println("</head>");
             out.println("<Body bgcolor=\"bbccff\">");
             out.println("<h3 align=\"center\">Project Effort</h3>");
             out.println("<form action=\"./ProjectEffortInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
             out.println("<table align=\"center\" bgcolor=#ccbbff> ");
             
             out.println("<tr align=\"center\" ><td><b>Enter ProjectId:</b>&nbsp&nbsp<input type=\"text\" name=\"project_id\"></td></tr>");
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