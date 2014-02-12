    import java.io.*;
    import javax.servlet.*;
    import javax.servlet.http.*;
   public class UpdateProjectServlet extends HttpServlet
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

       String project_id=request.getParameter("project_id");
         projectObj = tmsManager.getProject(project_id);
            if(projectObj.getProjectId() == null)
            out.println(" <h4 align= \"center\">Please Enter Valid Project  id</h4>");

else
{
project_id = projectObj.getProjectId();
String project_name =projectObj.getProjectName();
String description = projectObj.getDescription();
int is_alive=projectObj.getIsAlive();
String time_stamp = projectObj.getTimeStamp();
    out.println("<html><head><title>ProjectUpdation</title></head>");
    out.println("<body bgcolor=#ccffdd>");
    out.println("<form  method = POST action = \"./updateProject2\" >");
    out.println("<table border=0 width=50% align=center bgcolor=#bbccff>");
    out.println("<caption><strong>ProjectUpdation</strong>");
   out.println("<tr><td>ProjectId</td><td><input type=text name=project_id value = "+project_id+" /></td></tr>");
   out.println("<tr><td>ProjectName</td><td><input type=text name=project_name value = "+project_name+" /></td></tr>");
   out.println("<tr><td>Description</td><td><input type=text name=description value = "+description+" /></td></tr>");
   out.println("<tr><td>IsAlive</td><td><input type=text name=is_alive value = "+is_alive+" /></td></tr>");
   out.println("<tr><td>TimeStamp</td><td><input type=text name=time_stamp value = "+time_stamp+" /></td></tr>");
   out.println("<tr><td colspan=2 align=center><input type=submit value=Submit><input type=Reset value=Clear></td></tr>");
    out.println("</table></form></body></html>");
     

       project_id=request.getParameter("project_id");
       project_name=request.getParameter("project_name");
       description=request.getParameter("description");
       is_alive=Integer.parseInt(request.getParameter("is_alive"));
       time_stamp=request.getParameter("time_stamp");

projectObj.setProjectId(project_id);
projectObj.setProjectName(project_name);
projectObj.setDescription(description); 
projectObj.setIsAlive(is_alive);
projectObj.setTimeStamp(time_stamp);
    String message=null;
message=tmsManager.updateProject(projectObj);
out.println(message);

    out.println("<html><body><h3 align=\"center\">"+message+"</h4></body></html>");



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
}
catch(Exception e)
{
System.out.println(e.getMessage());
 }



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

RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);















}  
}