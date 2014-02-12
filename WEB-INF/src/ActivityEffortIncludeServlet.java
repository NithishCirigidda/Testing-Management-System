import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ActivityEffortIncludeServlet extends HttpServlet
 {
 	
            TMSManager tmsManager= null;
             int effortobj=-1;
              String activityId=null;
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
       {
          
              res.setContentType("text/html");     
              PrintWriter out=res.getWriter();


	RequestDispatcher rd1= req.getRequestDispatcher("/header");	

	rd1.include(req,res);


                  try
	{
             tmsManager = new TMSManager();         
           activityId=req.getParameter("activity_id");
           int effortobj = tmsManager.getActivityEffort(activityId);
	 if(effortobj==0)
	{
	 out.println("<h2 align=\"center\"> Invalid ActivityId </h2>");
                     }
              else{	
             out.println("<h1 align=\"center\">Activity Effort</h1>");
              out.println("<Table border =1 align = \"center\">");
              out.println("<tr bgcolor=\"bbcccc\">");
              out.println("<th>ActivityID<th>Effort");
//out.println("ActivityEffort:" + effortobj);
              out.println("<tr><td>" + activityId +"</td><td>"+ effortobj  +"</td></tr>" );
              out.println("</table>");
	}
             
                    }
	catch(Exception ex)
	{
	}
             


              out.println("<br>");
              out.println("<html>");
              out.println("<head>");
              out.println("<title>Activity Effort </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Activity Effort </h3>");
              out.println("<form action=\"./ActivityIncludeEffort\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
             out.println("<table align=\"center\" bgcolor=\"cbicbi\"> ");
             
               out.println("<tr align=\"center\" ><td><b> Enter ActivityId:</b>&nbsp&nbsp<input type=\"text\" name=\"activity_id\"></td></tr>");
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