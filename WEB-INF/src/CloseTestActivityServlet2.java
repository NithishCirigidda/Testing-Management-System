import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CloseTestActivityServlet2 extends HttpServlet
{
      TMSManager tmsManager = null;

      public CloseTestActivityServlet2() throws Exception
     {
         tmsManager = new TMSManager();
     }

     public void service(HttpServletRequest request, HttpServletResponse response)
     throws IOException,ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 
        
          try{        

              response.setContentType("text/html");     
              PrintWriter out=response.getWriter();

             String activity_id = request.getParameter("activity_id");

            String message = tmsManager.closeTestActivity(activity_id);
            out.println("<h1 align = center>"+message+"</h1><br><br><br>");
         }catch(Exception e){
              System.out.println("2"+e);
        }  
	 RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
	rd2.include(request, response);
    }
}            
            