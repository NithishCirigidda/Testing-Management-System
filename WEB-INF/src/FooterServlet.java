import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FooterServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res) 
{
try
{
 res.setContentType("text/html");
 PrintWriter out=res.getWriter();
  out.println("<hr>");
  out.println("<center><h5 valign = bottom><em> Copyrights &copy NeoApp Technologies 2011</em></h5></center>");

}
catch(Exception e)
{
}

}
}