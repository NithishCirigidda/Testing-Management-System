import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class ActivityFailedTestCasesIncludeServlet extends HttpServlet
      {

     TestCase[]   activityFailedTestcase = null;

     TMSManager tmsManager= null; 
    String activityId= null;
  
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
       {
            
                               res.setContentType("text/html");     
                               PrintWriter out=res.getWriter();
                               RequestDispatcher rd1= req.getRequestDispatcher("/header");	
                               rd1.include(req,res);

             try
	{
                     String Id=null;
	 tmsManager=new TMSManager( );
                      activityFailedTestcase = new TestCase[1000];
              	activityId=req.getParameter("activity_id");
                   activityFailedTestcase=tmsManager.getActivityFailedTestcases(activityId);
                       
                        for(int i=0;i<activityFailedTestcase.length;i++)
                        {
	    Id=activityFailedTestcase[i].getTestCaseId();
                        }
                        
	       if(Id==null)
	        {
	              out.println("<h2 align=\"center\">Invalid ActivityId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\"> Activity Failed Test Cases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=\"bbccff\">");
                                  out.println("<th>ActivityId<th>TestcaseId<th>UserId<th>Testcase Actual Date<th>Testcase Status<th>Comments<th>Actualbehavior");
                                 for(int i=0;i<activityFailedTestcase.length;i++)
	               {
                                        out.println("<tr><td>" +activityFailedTestcase[i].getActivityObj().getActivityId()  +"</td><td>"+activityFailedTestcase[i].getTestCaseId()  +"</td><td>"+activityFailedTestcase[i].getUserObj().getUserId()+"</td><td>"+activityFailedTestcase[i].getActualDate()+"</td><td>"+ activityFailedTestcase[i].getTestCaseStatus()+"</td><td>"+activityFailedTestcase[i].getComments()+"</td><td>"+activityFailedTestcase[i].getActualBehaviour()+"</td></tr>" );
                                       
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
              out.println("<title> Activity Failed TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Activity Failed TestCases</h3>");
              out.println("<form action=\"./ActivityFailedTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
              out.println("<table align=\"center\" bgcolor=\"bbccff\"> ");
              //out.println("<b>Enter The ActivityId</b>");
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