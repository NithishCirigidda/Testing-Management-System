import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class TesterTestCasesIncludeServlet extends HttpServlet
      {

     TestCase[]  testcase = null;

     TMSManager tmsManager= null; 
    String userId = null;
  
     public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
       {
            
              res.setContentType("text/html");     
              PrintWriter out=res.getWriter();
              RequestDispatcher rd1= req.getRequestDispatcher("/header");	
              rd1.include(req,res);

             try
	{
                     String Id="NeoApp";
	 tmsManager=new TMSManager( );
                     testcase = new TestCase[1000];
              	userId=req.getParameter("user_id");
                      testcase =tmsManager.getTesterTestcases(userId);
                        for(int i=0;i<testcase.length;i++)
                         {
	        Id=testcase[i].getTestCaseId();
                          }
                         //  out.println(Id);
	       if(Id=="NeoApp")
	        {
	              out.println("<h2 align=\"center\"> Invalid TesterId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\">Tester  Test Cases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=#ccbbff>");
                                  out.println("<th>TestCaseId<th>TestCaseDescription<th>TestCasePhase<th>ProjectId<th>UserId<th>ActivityId<th>ExpectedBehaviour");
                                 for(int i=0;i<testcase.length;i++)
	               {
                                        out.println("<tr><td>" + testcase[i].getTestCaseId()  +"</td><td>"+testcase[i].getTestCaseDescription()  +"</td><td>"+testcase[i].getTestCasePhase()+"</td><td>"+testcase[i].getProjectObj().getProjectId()+"</td><td>"+testcase[i].getUserObj().getEmpNo()+"</td><td>"+testcase[i].getActivityObj().getActivityId()+"</td><td>"+testcase[i].getExpectedBehaviour()+"</td></tr>" );
                                       
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
             out.println("<title>Tester TestCases  </title>");
             out.println("</head>");
             out.println("<Body bgcolor=\"bbccff\">");
             out.println("<h3 align=\"center\">Tester TestCases </h3>");
             out.println("<form action=\"./TesterTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
             out.println("<table align=\"center\" bgcolor=#ccbbff> ");
             out.println("<tr align=\"center\" ><td><b>Enter TesterId:</b>&nbsp&nbsp<input type=\"text\" name=\"user_id\"></td></tr>");
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