import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewProjectAssignmentServlet1 extends HttpServlet
{
 TMSManager tmsManager = null;
      User userObj = null;
      Project projectObj=null;
ProjectAssignment projectAssignmentObj=null;
     
          

 public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
          
        response.setContentType("text/html");
            PrintWriter out = response.getWriter();
        RequestDispatcher rd1=request.getRequestDispatcher("./header");
          rd1.include(request,response);
          try{
            tmsManager = new TMSManager();
           userObj = new User();
          projectObj=new Project();
          projectAssignmentObj=new ProjectAssignment();        
        String  Id ="neoapp";
       String project_id = request.getParameter("project_id");
	System.out.println(project_id);            
       projectAssignmentObj = tmsManager.getProjectAssignment(project_id);
        projectObj = projectAssignmentObj.getProjectObj();
          //out.println(projectAssignmentObj.getProjectObj());
           if(projectAssignmentObj.getProjectObj()==null)
           out.println(" <font ><h4 align=\"center\">There is no project with this Id</h4></font>");
                
 
          
            else {
            projectObj = projectAssignmentObj.getProjectObj();
            project_id=projectObj.getProjectId();
            String project_name=projectObj.getProjectName();
            userObj=projectAssignmentObj.getUserObj();
           String emp_no=userObj.getEmpNo();
           String emp_name=projectAssignmentObj.getEmpName();
           java.sql.Date planstart_date = projectAssignmentObj.getPlanstartDate(); 
           java.sql.Date planend_date = projectAssignmentObj.getPlanendDate(); 
           java.sql.Date time_stamp = projectAssignmentObj.getTimeStamp();
           int is_alive = projectAssignmentObj.getIsAlive() ;

            out.println("<html><head><title>View ProjectAsignment</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<a href=./Administrator>Admin Home</a><br>");
            out.println("<table border =2 width = 45% align = center bgcolor = #bbccff>");
            out.println("<caption>Project Assignment Content</caption>");
            out.println(" <tr><td>ProjectId</td><td>"+project_id+"</td></tr>");
            out.println(" <tr><td>ProjectName</td><td>"+project_name+"</td></tr>");
            out.println(" <tr><td>EmpNo</td><td>"+emp_no+"</td></tr>");
            out.println(" <tr><td>EmpName</td><td>"+emp_name+"</td></tr>");
            out.println(" <tr><td>PlanstartDate</td><td>"+planstart_date+"</td></tr>");
            out.println(" <tr><td>PlanEndDate</td><td>"+planend_date+"</td></tr>");
            out.println(" <tr><td>TimeStamp</td><td>"+time_stamp+"</td></tr>");
            out.println(" <tr><td>IsAlive</td><td>"+is_alive+"</td></tr>");
                   out.println("</table>");
            out.println("</body>");
            out.println("</html>");

     }
}
catch(Exception e){
               System.out.println(e.getMessage());
}
             out.println("<html><head><title>ViewProjectAssignment</title></head>");
            out.println("<body bgcolor =\"#ccffdd\">");
            out.println("<form  method =\"POST\"  action =\"./viewProjectAssignment1\" ><br><br><br>");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>ViewProjectAssignment</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter project Id</td>");
            out.println("<td><input type = \"text\" name = \"project_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

    RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);

}
}



           
        
