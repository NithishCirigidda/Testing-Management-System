import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateProjectAssignmentServlet2 extends HttpServlet
{
      TMSManager tmsManager = null;
      User userObj = null;
      Project projectObj=null;
     ProjectAssignment projectAssignmentObj=null;
      public UpdateProjectAssignmentServlet2() throws Exception
      {
           tmsManager = new TMSManager();
           userObj = new User();
         projectObj=new Project();
       projectAssignmentObj=new ProjectAssignment();

}

 public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {
          try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
           RequestDispatcher rd1=request.getRequestDispatcher("./header");
          rd1.include(request,response);
         
  String project_id=request.getParameter("project_id");
 String  project_name=request.getParameter("project_name");
       String emp_no=request.getParameter("emp_no");
 String emp_name=request.getParameter("emp_name");
  String  start_date=request.getParameter("planstart_date");       

String  end_date=request.getParameter("planend_date");       
String time_stamp1=request.getParameter("time_stamp");
java.sql.Date time_stamp=java.sql.Date.valueOf(time_stamp1);
 int is_alive=Integer.parseInt(request.getParameter("is_alive"));

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
out.println("<html><head><title>UpdateProjectAssignment</title></head>");
            out.println("<body onload=onSubmit() bgcolor =\"#ccffdd\">");
            out.println("<form  method =\"POST\"  action =\"./updateProjectAssignment2\" ><br><br><br>");
            out.println("<table border = 1bordercolor=black width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>UpdateProjectAssignment</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter Project ID</td>");
            out.println("<td><input type = \"text\" name = \"project_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body></html>");

}catch(Exception e){
System.out.println("hai ........"+e.getMessage());
}

RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
  }
}
