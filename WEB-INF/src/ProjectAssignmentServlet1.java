
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ProjectAssignmentServlet1 extends HttpServlet
{
User userObj=null;
TMSManager tmsManager = null;
Project projectObj=null;
ProjectAssignment projectAssignmentObj=null;
   

public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {   
                     response.setContentType("text/html");
                     PrintWriter out = response.getWriter();
                     RequestDispatcher rd1=request.getRequestDispatcher("./header");
                     rd1.include(request,response);

          try{
	
        	  userObj=new User();
	 tmsManager = new TMSManager();
	projectObj=new Project();
	projectAssignmentObj=new ProjectAssignment();
     	

         
           String  project_id=request.getParameter("project_id");
           String  project_name=request.getParameter("project_name");
          String  emp_no=request.getParameter("emp_no");
          String  emp_name=request.getParameter("emp_name");
        String  start_date=request.getParameter("planstart_date");       

	String  end_date=request.getParameter("planend_date");       
	String time_stamp1=request.getParameter("time_stamp");
	java.sql.Date time_stamp=java.sql.Date.valueOf(time_stamp1);
	System.out.println("capturing time_stamp"+time_stamp);
	int is_alive=Integer.parseInt(request.getParameter("is_alive"));

	projectObj.setProjectId(project_id);
	projectObj.setProjectName(project_name);
	projectAssignmentObj.setProjectObj(projectObj);
  
   
	userObj.setEmpNo(emp_no);
	projectAssignmentObj.setUserObj(userObj);

	projectAssignmentObj.setEmpName(emp_name);
	/*String[] planstart_date = start_date.split("-");
                int sy=Integer.parseInt(planstart_date[0]);
	int sm=Integer.parseInt(planstart_date[1]);
	int sd=Integer.parseInt(planstart_date[2]);*/
                   java.sql.Date  planstart_date1=java.sql.Date.valueOf(start_date);

	/*String[] planend_date =end_date.split("-");
                int y=Integer.parseInt(planend_date[0]);
	int m=Integer.parseInt(planend_date[1]);
	int d=Integer.parseInt(planend_date[2]);*/
                   java.sql.Date  planend_date1=java.sql.Date.valueOf(end_date);


	projectAssignmentObj.setPlanstartDate(planstart_date1);
	projectAssignmentObj.setPlanendDate(planend_date1);

	 projectAssignmentObj.setTimeStamp(time_stamp);
	projectAssignmentObj.setIsAlive(is_alive);
	
	String message=null;
	message=tmsManager.projectAssignment(projectAssignmentObj);
              
                   if(message=="failed"){
                   out.println("<html><body><h3 align=center>"+message+"</h4></body></html>");}
                    else if(message==null){
	   out.println("<html><body><h3 align=center>\"Please enter valid Details\"</h4></body></html>");}
                    else if(message=="successfully inserted"){
                    out.println("<html><body><h3 align=center>"+message+"</h4></body></html>");
	out.println("<a href=./Administrator>Admin Home</a>");
}
      
}
catch(Exception e)
{
System.out.println(e.getMessage());
}

 out.println("<html><head><title>Project Assignment</title></head>");
          out.println("<body bgcolor = #ccffdd >");
          out.println("<form  method = POST action = \"./projectAssignmentDetails1\">");
          out.println("<table border = 0 width = 45% align = center bgcolor = #bbccff>");
          out.println("<caption><strong>Project Assignment</strong></caption>");
         
         out.println("<tr><td>Project Id</td><td><input type = text name =project_id  ><td></tr>");
          out.println("<tr><td>ProjectName</td><td><input type = text name = project_name><td></tr>");
          out.println("<tr><td>EmpNo</td><td><input type = text name = emp_no><td></tr><tr>");
         out.println("<tr><td>EmpName</td><td><input type = text name =emp_name  ><td></tr>");

          out.println("<tr><td>PlanstartDate</td><td><input type = text name =planstart_date ><td></tr>");
           out.println("<tr><td>PlanEndDate</td><td><input type = text name = planend_date><td></tr>");
          out.println("<tr><td>TimeStamp</td><td><input type = text name = time_stamp><td></tr><tr>");
         out.println("<tr><td>IsAlive</td><td><input type = text name =is_alive  ><td></tr>");


  out.println("<tr><td colspan = 2  align =\"center\"><input type = \"submit\" name=submit value = submit>");
         out.println("<input type = \"Reset\" name=reset value = clear></td></tr>");
         out.println("</table></form></body></html>");
 
RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
  }
}
