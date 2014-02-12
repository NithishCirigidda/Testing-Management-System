    import java.io.*;
    import javax.servlet.*;
    import javax.servlet.http.*;
   public class UpdateProjectServlet2 extends HttpServlet
    { 
Project projectObj=null;
  TMSManager tmsManager=null;


public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
      {

   
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
     RequestDispatcher rd1=request.getRequestDispatcher("./header");
          rd1.include(request,response);

      try
       {
    tmsManager =new TMSManager();
     projectObj = new Project();

       
    String   project_id=request.getParameter("project_id");
       String project_name=request.getParameter("project_name");
      String description=request.getParameter("description");
       int is_alive=Integer.parseInt(request.getParameter("is_alive"));
      String  time_stamp=request.getParameter("time_stamp");

projectObj.setProjectId(project_id);
projectObj.setProjectName(project_name);
projectObj.setDescription(description); 
projectObj.setIsAlive(is_alive);
projectObj.setTimeStamp(time_stamp);
    String message=null;
message=tmsManager.updateProject(projectObj);

    out.println("<html><body><h3 align=center>"+message+"</h4></body></html>");

out.println("<html><head><title>UpdateProject</title></head>");
            out.println("<body onload=onSubmit() bgcolor =\"#bbccff\">");
            out.println("<form  method =\"POST\"  action =\"./updateProject\" ><br><br><br>");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>UpdateProject</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter Project ID</td>");
            out.println("<td><input type = \"text\" name = \"project_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body></html>");

}
catch(Exception e)
{
System.out.println(e.getMessage());
 }
RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
}  
}