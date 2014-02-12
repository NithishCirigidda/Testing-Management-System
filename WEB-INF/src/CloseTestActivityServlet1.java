import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CloseTestActivityServlet1 extends HttpServlet
{
      TMSManager tmsManager = null;

      public CloseTestActivityServlet1() throws Exception
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

            out.println("<html><head><title> Close Activity</title></head>");
            out.println("<body bgcolor =\"#ffcc00\">");
            out.println("<form  method =\"POST\"  action =\"./closeTestActivity2\" >");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>Close Activity</b></caption>");
            out.println("<tr><td>Enter Activity ID</td>");
            out.println("<td><input type = \"text\" name = \"activity_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table><br><br><br><br><br>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

           

         }catch(Exception e){
              System.out.println("1"+e);
        }  
	 RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
	rd2.include(request, response);
    }
}            
            