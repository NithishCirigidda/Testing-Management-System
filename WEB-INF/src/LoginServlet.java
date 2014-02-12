import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{

 res.setContentType("text/html");
 PrintWriter out=res.getWriter();
 RequestDispatcher rd1=req.getRequestDispatcher("./header");
 rd1.include(req,res);
 String user_id = req.getParameter("user_id");
 String password = req.getParameter("pwd");
 


  if ((user_id != null && user_id.equals("") != true) || (password != null && password.equals("") != true))
        {
               
 HttpSession session = req.getSession(true);
 session.setAttribute("user_id",user_id);
 
                String[] str=user_id.split("_");
                String designation=str[0];
               try
	{
                       TMSManager tmsmanager=new TMSManager();
                       String b=tmsmanager.authenticate(user_id,password);
                    
                         if(b.equals("valid password"))
                           {
                             if(designation.equals("ADMIN") )
		   res.sendRedirect("./Administrator");
	             else if(designation.equals("TM") )
		    res.sendRedirect("./managerLogin");
                                  //res.sendRedirect("./TestManager");
               	             else if(designation.equals("TESTER") )
		   res.sendRedirect("./Tester");
	          }
                          else
                            out.println("Login Name or Password is incorrect");       
                     }        
                    catch(Exception e)
                    {
	     System.out.println("catch"+e);
                    }
   }
   
  
   out.println("<form method=Get action=\"login\">");
   out.println("<center>userID");
   out.println("<input type=\"text\" name=\"user_id\">"); 
   out.println("<br><br>");
   out.println("password");
   out.println("<input type=\"password\" name=\"pwd\">"); 
   out.println("<br><br>");
  out.println("<input type=submit value=submit></center>");
 RequestDispatcher rd2=req.getRequestDispatcher("./footer");
  rd2.include(req,res);
  out.println("</body>");
  out.println("</html>");
 }
}