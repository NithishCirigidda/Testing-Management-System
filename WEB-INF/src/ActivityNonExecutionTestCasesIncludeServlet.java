import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class ActivityNonExecutionTestCasesIncludeServlet  extends HttpServlet
      {

     TestCase[] nonExeTestcase = null;

     TMSManager  tmsManager= null; 
    String activityId = null;
  
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
       {
            
              res.setContentType("text/html");     
              PrintWriter out=res.getWriter();
              RequestDispatcher rd1= req.getRequestDispatcher("/header");	
              rd1.include(req,res);

             try
	{
                     String Id="NeoApp";
	 tmsManager=new TMSManager();
                      nonExeTestcase = new TestCase[1000];
              	activityId=req.getParameter("activity_id");
                   nonExeTestcase =tmsManager.getActivityNonExecutionTestcases(activityId);
                         for(int i=0;i<nonExeTestcase.length;i++)
                         {
	        Id=nonExeTestcase[i].getActivityObj().getActivityId();
                          }

                          
	       if(Id=="NeoApp")
	        {
	              out.println("<h2 align=\"center\"> Invalid ActivityId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\">Activity Non Execution TestCases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=\"bbccff\">");
                                  out.println("<th>ActivityId<th>TestCaseId<th>UserId");
                                 for(int i=0;i< nonExeTestcase.length;i++)
	               {
                                        out.println("<tr><td>" + nonExeTestcase[i].getActivityObj().getActivityId()  +"</td><td>"+nonExeTestcase[i].getTestCaseId() +"</td><td>"+nonExeTestcase[i].getUserObj().getUserId()+"</tr>" );
                                       
	               }
                                    out.println("</table>");                    
                                 }

                  }

                  catch(Exception e)
	 {

	 }
             
               out.println("<br>");
              out.println("<html>");
              out.println("<head>");
              out.println("<title>Activity Non-Execution TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Activity Non-Execution TestCases</h3>");
              out.println("<form action=\"./ActivityNonExcecutiontestcasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
              out.println("<table align=\"center\" bgcolor=\"bbccff\"> ");
             
               out.println("<tr align=\"center\" ><td><b>ActivityId:</b>&nbsp&nbsp<input type=\"text\" name=\"activity_id\"></td></tr>");
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