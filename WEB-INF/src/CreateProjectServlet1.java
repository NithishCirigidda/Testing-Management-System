    import java.io.*;
    import javax.servlet.*;
    import javax.servlet.http.*;
    public class CreateProjectServlet1 extends HttpServlet
    { 
    TMSManager tmsManager=null;
    Project projectObj=null;
      String message=null;

    public void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
    {

response.setContentType("text/html");
    PrintWriter out=response.getWriter();
 RequestDispatcher rd1=request.getRequestDispatcher("./header");
  rd1.include(request,response);
     try{
    
                tmsManager =new TMSManager();
	 projectObj = new Project();


       String project_id=request.getParameter("project_id");
       String project_name=request.getParameter("project_name");
       String description=request.getParameter("description");
       int is_alive=Integer.parseInt(request.getParameter("is_alive"));
       String time_stamp=request.getParameter("time_stamp");

       projectObj.setProjectId(project_id);
       projectObj.setProjectName(project_name);
       projectObj.setDescription(description); 
       projectObj.setIsAlive(is_alive);
       projectObj.setTimeStamp(time_stamp);
      
       message=tmsManager.createProject(projectObj);
       
       if(message=="failed")
       {
      out.println("<h3 align=\"center\"> Invalid Details </h3>");
        }
   else{
    out.println("<html><body><h3 align=center>"+message+"</h4></body></html>");

    System.out.println(message);
      }
     }catch(Exception e){}

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
 RequestDispatcher rd2=request.getRequestDispatcher("./footer");
 rd2.include(request,response);

  }
}