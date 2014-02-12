
    import java.io.*;
    import javax.servlet.*;
    import javax.servlet.http.*;
    public class CreateProjectServlet extends HttpServlet
    { 
    


    public void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {
     try{

    response.setContentType("text/html");
    PrintWriter out=response.getWriter();

 RequestDispatcher rd1=request.getRequestDispatcher("./header");
  rd1.include(request,response);

    out.println("<html><head><title>ProjectCreation</title></head>");
    out.println("<body bgcolor=#ccffdd>");
    out.println("<form  method = POST action = \"./createProjectDetails1\">");
    out.println("<table border=0 width=50% align=center bgcolor=#bbccff>");
    out.println("<caption><strong>ProjectCreation</strong>");
   out.println("<tr><td>ProjectId</td><td><input type=text name=project_id></td></tr>");
   out.println("<tr><td>ProjectName</td><td><input type=text name=project_name></td></tr>");
   out.println("<tr><td>Description</td><td><input type=text name=description></td></tr>");
   out.println("<tr><td>IsAlive</td><td><input type=text name=is_alive></td></tr>");
   out.println("<tr><td>TimeStamp</td><td><input type=text name=time_stamp></td></tr>");
   out.println("<tr><td colspan=2 align=center><input type=submit value=Submit><input type=Reset value=Clear></td></tr>");
    out.println("</table></form></body></html>");
     

     
}catch(Exception e){}

 RequestDispatcher rd2=request.getRequestDispatcher("./footer");
 rd2.include(request,response);

  }
}