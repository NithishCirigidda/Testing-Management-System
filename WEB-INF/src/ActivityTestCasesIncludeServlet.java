import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class ActivityTestCasesIncludeServlet extends HttpServlet
      {

     TestCase[]  testcase = null;

     TMSManager tmsManager= null; 
    String activityId = null;
  
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
       {
            
                               res.setContentType("text/html");     
                               PrintWriter out=res.getWriter();
                               RequestDispatcher rd1= req.getRequestDispatcher("/header");	
                               rd1.include(req,res);

             try
	{
                     String Id="Neoapp";
	 tmsManager=new TMSManager( );
                     testcase = new TestCase[1000];
              	activityId=req.getParameter("activity_id");
                    testcase =tmsManager.getActivityTestcases(activityId);
                       //out.println(testcase);
                        for(int i=0;i<testcase.length;i++)
                        {
	    Id=testcase[i].getTestCaseId();
                        }
                        //out.println(Id);
	       if(Id=="Neoapp")
	        {
	              out.println("<h2 align=\"center\"> Invalid ActivityId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\">Activity Test Cases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=\"bbccff\">");
                                  out.println("<th>TestCaseId<th>TestCaseDescription<th>TestCasePhase<th>ProjectId<th>UserId<th>ActivityId<th>ExpectedBehaviour");
                                 for(int i=0;i<testcase.length;i++)
	               {
                                        out.println("<tr><td>" + testcase[i].getTestCaseId()  +"</td><td>"+testcase[i].getTestCaseDescription()  +"</td><td>"+testcase[i].getTestCasePhase()+"</td><td>"+testcase[i].getProjectObj().getProjectId()+"</td><td>"+testcase[i].getUserObj().getUserId()+"</td><td>"+testcase[i].getActivityObj().getActivityId()+"</td><td>"+testcase[i].getExpectedBehaviour()+"</td></tr>" );
                                       
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
              out.println("<title> Activity TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Activity TestCases</h3>");
              out.println("<form action=\"./ActivityTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
             out.println("<table align=\"center\" bgcolor=\"bbccff\"> ");
              //out.println("<b>Enter ActivityId</b>");
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