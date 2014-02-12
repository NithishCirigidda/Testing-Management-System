import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateProjectAssignmentServlet extends HttpServlet
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

         
 String project_id = request.getParameter("project_id");
            
            projectAssignmentObj = tmsManager.getProjectAssignment(project_id);
           projectObj = projectAssignmentObj.getProjectObj();
          
   if( projectAssignmentObj.getProjectObj()== null)
               out.println(" <font ><h4 align=\"center\">There is no project with this id</h1></font>");
            else{
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


       out.println("<html><head><title>Project Assignment</title></head>");
          out.println("<body bgcolor = #ccffdd >");
          out.println("<a href=./Administrator>Admin Home</a>");
          out.println("<form  method = POST action = \"./updateProjectAssignment\" >");
          out.println("<table bordercolor=black border  = 1 width = 45% align = center bgcolor = #bbccff>");
          out.println("<caption><strong>Update Project Assignment</strong></caption>");
         
       out.println("<tr><td>Project Id</td><td><input type = text name =project_id value = "+project_id+"></td></tr>");
          out.println("<tr><td>ProjectName</td><td><input type = text name = project_name value = "+project_name+" ></td></tr>");
          out.println("<tr><td>EmpNo</td><td><input type = text name = emp_no value = "+emp_no+" ></td></tr><tr>");
        out.println("<tr><td>EmpName</td><td><input type = text name =emp_name value = "+emp_name+" ></td></tr>");

         out.println("<tr><td>PlanstartDate</td><td><input type = text name =planstart_date value ="+planstart_date+" ></td></tr>");
          out.println("<tr><td>PlanEndDate</td><td><input type = text name = planend_date value = "+planend_date+" ></td></tr>");
          out.println("<tr><td>TimeStamp</td><td><input type = text name = time_stamp value ="+time_stamp+"></td></tr><tr>");
        out.println("<tr><td>IsAlive</td><td><input type = text name =is_alive  value = "+is_alive+"></td></tr>");


  out.println("<tr><td colspan = 2  align =\"center\"><input type = \"submit\" name=submit value = submit>");
         out.println("<input type = \"Reset\" name=reset value = clear></td></tr>");
         out.println("</table></form></body></html>");

      project_id=request.getParameter("project_id");
  project_name=request.getParameter("project_name");
       emp_no=request.getParameter("emp_no");
  emp_name=request.getParameter("emp_name");
  String  start_date=request.getParameter("planstart_date");       

String  end_date=request.getParameter("planend_date");       
String time_stamp1=request.getParameter("time_stamp");
 time_stamp=java.sql.Date.valueOf(time_stamp1);
 is_alive=Integer.parseInt(request.getParameter("is_alive"));

String[] planstart_date2 = start_date.split("-");
                int sy=Integer.parseInt(planstart_date2[0]);
	int sm=Integer.parseInt(planstart_date2[1]);
	int sd=Integer.parseInt(planstart_date2[2]);
                   java.sql.Date  planstart_date1=new java.sql.Date(sy,sm,sd);

String[] planend_date2 =end_date.split("-");
                int y=Integer.parseInt(planend_date2[0]);
	int m=Integer.parseInt(planend_date2[1]);
	int d=Integer.parseInt(planend_date2[2]);
                   java.sql.Date  planend_date1=new java.sql.Date(y,m,d);




projectObj.setProjectId(project_id);
projectObj.setProjectName(project_name);
projectAssignmentObj.setProjectObj(projectObj);
  
   
userObj.setEmpNo(emp_no);
projectAssignmentObj.setUserObj(userObj);
projectAssignmentObj.setEmpName(emp_name);
projectAssignmentObj.setPlanstartDate(planstart_date1);
projectAssignmentObj.setPlanendDate(planend_date1);

 projectAssignmentObj.setTimeStamp(time_stamp);
projectAssignmentObj.setIsAlive(is_alive);

String message=null;
message=tmsManager.updateProjectAssignment(projectAssignmentObj);
out.println("<html><body><h3 align=center>"+message+"</h4></body></html>");
    
}
}catch(Exception e){
System.out.println("hai ........"+e.getMessage());
}
out.println("<html><head><title>UpdateProjectAssignment</title></head>");
            out.println("<body onload=onSubmit() bgcolor =\"#ccffdd\">");
            out.println("<form  method =\"POST\"  action =\"./updateProjectAssignment\" ><br><br><br>");
            out.println("<table border = 1 bordercolor=black width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>UpdateProjectAssignment</b></caption>");
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
