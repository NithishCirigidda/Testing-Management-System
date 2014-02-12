import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

    public class TesterFailedTestCasesIncludeServlet extends HttpServlet
      {

     TestCase[]   failedTestcase = null;

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
                     failedTestcase = new TestCase[1000];
              	     userId=req.getParameter("user_id");
                     failedTestcase=tmsManager.getTesterFailedTestcases(userId);
                       
                        for(int i=0;i<failedTestcase.length;i++)
                        {
	        Id=failedTestcase[i].getTestCaseId();
                        }
                        
	       if(Id==null)
	        {
	              out.println("<h2 align=\"center\">Invalid TesterId </h2>");
                            }
                           else
	        {	
                                  out.println("<h3 align=\"center\">Failed Test Cases</h3>");
                                  out.println("<Table border =1 align = \"center\">");
                                  out.println("<tr bgcolor=#ccbbff>");
                                  out.println("<th>ActivityId<th>TestcaseId<th>UserId<th>Testcase Actual Date<th>Testcase Status<th>Comments<th>Actualbehavior");
                                 for(int i=0;i<failedTestcase.length;i++)
	               {
                                        out.println("<tr><td>" + failedTestcase[i].getActivityObj().getActivityId()  +"</td><td>"+failedTestcase[i].getTestCaseId()  +"</td><td>"+failedTestcase[i].getUserObj().getUserId()+"</td><td>"+failedTestcase[i].getActualDate()+"</td><td>"+ failedTestcase[i].getTestCaseStatus()+"</td><td>"+failedTestcase[i].getComments()+"</td><td>"+failedTestcase[i].getActualBehaviour()+"</td></tr>" );
                                       
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
              out.println("<title>Failed TestCases </title>");
              out.println("</head>");
              out.println("<Body bgcolor=\"bbccff\">");
              out.println("<h3 align=\"center\">Tester Failed TestCases</h3>");
              out.println("<form action=\"./TesterFailedTestCasesInclude\" align=\"center\" width=\"100\" bgcolor=\"bbccff\" method = \"get\">");
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