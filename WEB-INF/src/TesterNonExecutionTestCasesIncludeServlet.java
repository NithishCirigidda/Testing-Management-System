import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class TesterNonExecutionTestCasesIncludeServlet  extends HttpServlet
      {

     TestCase[] testerNonExeTestcase = null;

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
                      testerNonExeTestcase = new TestCase[1000];
              	userId=req.getParameter("user_id");
                   testerNonExeTestcase =tmsManager.getTesterNonExecutionTestcases(userId);
                         for(int i=0;i<testerNonExeTestcase.length;i++)
                         {
	        Id=testerNonExeTestcase[i].getActivityObj().getActivityId();
                          }

                          
	       if(Id=="NeoApp")
	        {
	              out.println("<h2 align=\"center\"> Invalid TesterId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\">Tester Non Execution TestCases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=#ccbbff>");
                                  out.println("<th>TesterId<th>TestCaseId<th>ActivityId");
                                 for(int i=0;i<testerNonExeTestcase.length;i++)
	               {
                                        out.println("<tr><td>" + testerNonExeTestcase[i].getUserObj().getUserId()   +"</td><td>"+testerNonExeTestcase[i].getTestCaseId() +"</td><td>"+testerNonExeTestcase[i].getActivityObj().getActivityId() +"</tr>" );
                                       
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
              out.println("<title>Tester Non-Execution TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Tester Non-Execution TestCases</h3>");
              out.println("<form action=\"./TesterNonExecutionTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
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