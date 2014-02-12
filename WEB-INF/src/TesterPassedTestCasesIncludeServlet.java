import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class TesterPassedTestCasesIncludeServlet extends HttpServlet
      {

     TestCase[]  passedTestcase = null;

     TMSManager tmsManager= null; 
    String userId= null;
  
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
                      passedTestcase = new TestCase[1000];
              	userId=req.getParameter("user_id");
                  passedTestcase=tmsManager.getTesterPassedTestcases(userId);
                       
                        for(int i=0;i<passedTestcase.length;i++)
                        {
	    Id=passedTestcase[i].getTestCaseId();
                        }
                        
	       if(Id==null)
	        {
	              out.println("<h2 align=\"center\">Invalid TesterId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\">Passed Test Cases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=#ccbbff>");
                                  out.println("<th>ActivityId<th>TestcaseId<th>UserId<th>Testcase Actual Date<th>Testcase Status<th>Comments<th>Actualbehavior");
                                 for(int i=0;i<passedTestcase.length;i++)
	               {
                                        out.println("<tr><td>" +passedTestcase[i].getActivityObj().getActivityId()  +"</td><td>"+passedTestcase[i].getTestCaseId()  +"</td><td>"+passedTestcase[i].getUserObj().getUserId()+"</td><td>"+passedTestcase[i].getActualDate()+"</td><td>"+ passedTestcase[i].getTestCaseStatus()+"</td><td>"+passedTestcase[i].getComments()+"</td><td>"+passedTestcase[i].getActualBehaviour()+"</td></tr>" );
                                       
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
              out.println("<title>Passed TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Tester Passed TestCases</h3>");
              out.println("<form action=\"./TesterPassedTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
             out.println("<table align=\"center\" bgcolor=#ccbbff> ");
              //out.println("<b>Enter The UserId</b>");
               out.println("<tr align=\"center\" ><td><b>TesterId:</b>&nbsp&nbsp<input type=\"text\" name=\"user_id\"></td></tr>");
                out.println("<tr align=\"center\" ><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"Submit\" value=\" Submit\">&nbsp&nbsp<input type=\"Reset\" value=\"clear\"</td></tr>");
                out.println("</form>");
                 out.println("</table>");
	out.println("<br>");
          
                 

                  RequestDispatcher rd2= req.getRequestDispatcher("/footer");	
	rd2.include(req,res);
              
         }
}