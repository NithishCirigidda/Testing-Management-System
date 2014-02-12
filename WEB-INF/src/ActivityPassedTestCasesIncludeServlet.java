import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class ActivityPassedTestCasesIncludeServlet extends HttpServlet
      {

     TestCase[]   activityPassedTestcase = null;

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
                      activityPassedTestcase = new TestCase[1000];
              	activityId=req.getParameter("activity_id");
                   activityPassedTestcase=tmsManager.getActivityPassedTestcases(activityId);
                       
                        for(int i=0;i<activityPassedTestcase.length;i++)
                        {
	    Id=activityPassedTestcase[i].getTestCaseId();
                        }
                        
	       if(Id==null)
	        {
	              out.println("<h2 align=\"center\">Invalid ActivityId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\"> Activity Passed Test Cases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=\"bbccff\">");
                                  out.println("<th>ActivityId<th>TestcaseId<th>UserId<th>Testcase Actual Date<th>Testcase Status<th>Comments<th>Actualbehavior");
                                 for(int i=0;i<activityPassedTestcase.length;i++)
	               {
                                        out.println("<tr><td>" +activityPassedTestcase[i].getActivityObj().getActivityId()  +"</td><td>"+activityPassedTestcase[i].getTestCaseId()  +"</td><td>"+activityPassedTestcase[i].getUserObj().getUserId()+"</td><td>"+activityPassedTestcase[i].getActualDate()+"</td><td>"+ activityPassedTestcase[i].getTestCaseStatus()+"</td><td>"+activityPassedTestcase[i].getComments()+"</td><td>"+activityPassedTestcase[i].getActualBehaviour()+"</td></tr>" );
                                       
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
              out.println("<title> Activity Passed TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Activity Passed TestCases</h3>");
              out.println("<form action=\"./ActivityPassedTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
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