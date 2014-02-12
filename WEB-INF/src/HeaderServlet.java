import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class HeaderServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)
{
try
{
 res.setContentType("img/text/html");
 PrintWriter out=res.getWriter();
 out.println("<html><head><center><h1>TESTING MANAGEMENT SYSTEM<h1></center></head>");
//out.println("<img src=\"./neoapp_logo.jpg\" height=100 width=100>");
 out.println("<body bgcolor=#bbffdd>");
out.println("<hr>");
}
catch(Exception e)
{
}
}
}