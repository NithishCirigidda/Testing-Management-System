import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class TesterExecutionTestCasesIncludeServlet  extends HttpServlet
      {

     TestCase[] testerExeTestcase = null;

     TMSManager  tmsManager= null; 
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
	 tmsManager=new TMSManager();
                      testerExeTestcase= new TestCase[1000];
              	userId=req.getParameter("user_id");
                   testerExeTestcase =tmsManager.getTesterExcecutionTestcases(userId);
                         for(int i=0;i<testerExeTestcase.length;i++)
                         {
	        Id=testerExeTestcase[i].getActivityObj().getActivityId();
                          }

                          
	       if(Id=="NeoApp")
	        {
	              out.println("<h2 align=\"center\"> Invalid TesterId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\">TesterExecutionTestCases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=#ccbbff>");
                                  out.println("<th>ActivityId<th>TestCaseId<th>UserId<th>Testcase Actual Date<th>Testcase Status<th>Comments<th>Actualbehavior");
                                 for(int i=0;i<testerExeTestcase.length;i++)
	               {
                                        out.println("<tr><td>" + testerExeTestcase[i].getActivityObj().getActivityId()  +"</td><td>"+testerExeTestcase[i].getTestCaseId() +"</td><td>"+testerExeTestcase[i].getUserObj().getUserId()+"</td><td>"+testerExeTestcase[i].getActualDate()+"</td><td>"+testerExeTestcase[i].getTestCaseStatus()+"</td><td>"+ testerExeTestcase[i].getComments()+"</td><td>"+testerExeTestcase[i].getActualBehaviour()+"</td></tr>" );
                                       
	               }
                                    out.println("</table>");                    
                                 }

                  }

                  catch(Exception e)
	 {
                    System.out.println(e.getMessage());
	 }
             
               out.println("<br>");
              out.println("<html>");
              out.println("<head>");
              out.println("<title>Tester Execution TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Tester Execution TestCases</h3>");
              out.println("<form action=\"./TesterExecutionTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
             out.println("<table align=\"center\" bgcolor=#ccbbff> ");
             
               out.println("<tr align=\"center\" ><td><b>TesterId:</b>&nbsp&nbsp<input type=\"text\" name=\"user_id\"></td></tr>");
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