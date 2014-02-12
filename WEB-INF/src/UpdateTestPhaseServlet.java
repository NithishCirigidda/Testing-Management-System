import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateTestPhaseServlet extends HttpServlet
{
      TMSManager tmsManager = null;
       Project projectObj = null;
      TestPhase testPhaseObj = null;

     
         
          
     
     public void service(HttpServletRequest request, HttpServletResponse response)
                                  throws IOException, ServletException
     {

          RequestDispatcher rd1= request.getRequestDispatcher("/header");	
          rd1.include(request,response); 
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();

          try{
          tmsManager = new TMSManager();
           projectObj = new Project();
           testPhaseObj = new TestPhase();
          String phase_id = request.getParameter("phase_id");
            testPhaseObj = tmsManager.getTestPhase(phase_id);
            System.out.println("test Phase_id"+testPhaseObj.getPhaseId());
             if(testPhaseObj.getPhaseId() == null)
 {
               out.println("<h4 align = center>Please enter your correct phase Id</h4>");
          out.println("<html><head><title>Phase Updation </title></head>");
            out.println("<body onload = onSubmit() bgcolor = #ccffdd >");
            out.println("<form name = form1 method = POST action = \"./updateTestPhase\"><br><br><br>");
            out.println("<table border = 0 width = 40% align = center bgcolor = #bbccff>");
            out.println("<caption><strong>Update Phase</strong></caption>");
            out.println("<tr><td>Enter Phase ID</td><td><input type = text name = phase_id ></td></tr>");
            out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
            out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
            out.println("</table></body>");
            out.println("</html>");
          out.println(testPhaseObj.getPhaseId());
}
           
            else{
            phase_id = testPhaseObj.getPhaseId();
            String phase_name = testPhaseObj.getPhaseName();

            projectObj = testPhaseObj.getProjectObj();
            String project_id = projectObj.getProjectId();

            String description = testPhaseObj.getDescription();
            int is_alive = testPhaseObj.getIsAlive();
            String time_stamp = testPhaseObj.getTimeStamp() ;
        
            out.println("<html><head><title>Update Test Phase</title></head>");
            out.println("<body bgcolor = #ccffdd>");
            out.println("<form method = POST action = \"./updateTestPhase2\">");
            out.println("<table border = 0 width = 200 align = center bgcolor = #bbccff>");
            out.println("<caption>Phase Content</caption>");
            out.println(" <tr><td>Phase ID</td><td><input type = text name = phase_id value ="+phase_id+" ></td></tr>");
            out.println(" <tr><td>Phase Name</td><td><input type = text name = phase_name value ="+phase_name+" ></td></tr>");
            out.println(" <tr><td>Project ID</td><td><input type = text name = project_id value ="+project_id+" ></td></tr>");
            out.println(" <tr><td>Description</td><td><input type = text name = description value ="+description+" ></td></tr>");
            out.println(" <tr><td>Is Alive</td><td><input type = text name = is_alive value ="+is_alive+" ></td></tr>");
            out.println(" <tr><td>Time_Stamp</td><td><input type = text name = time_stamp value = "+time_stamp+" ></td></tr>");
            out.println("<tr><td colspan = 2 align = center ><input type = submit  name = submit value = Update ><input type = Reset name = Reset value = Clear></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");

          phase_id = request.getParameter("phase_id");
          phase_name = request.getParameter("phase_name");
          project_id = request.getParameter("project_id");
          description = request.getParameter("description");
          is_alive = Integer.parseInt(request.getParameter("is_alive"));
          time_stamp = request.getParameter("time_stamp");

          testPhaseObj.setPhaseId(phase_id); 
          testPhaseObj.setPhaseName(phase_name);

          projectObj.setProjectId(project_id);
          testPhaseObj.setProjectObj(projectObj);

          testPhaseObj.setDescription(description);
          testPhaseObj.setIsAlive(is_alive);
          testPhaseObj.setTimeStamp(time_stamp);
       
          String message = tmsManager.updateTestPhase(testPhaseObj);   
          response.setContentType("text/html");
          //PrintWriter out = response.getWriter();
          out.println("<html><body><h4>"+message+"</h4></body></html>");
          System.out.println(message);
            }
          }catch(Exception e){
               System.out.println(e.getMessage());
           }

           /* out.println("<html><head><title>Phase Updation </title></head>");
            out.println("<body onload = onSubmit() bgcolor = #ccffdd >");
            out.println("<form name = form1 method = POST action = \"./updateTestPhase\"><br><br><br>");
            out.println("<table border = 0 width = 40% align = center bgcolor = #bbccff>");
            out.println("<caption><strong>Update Phase</strong></caption>");
            out.println("<tr><td>Enter Phase ID</td><td><input type = text name = phase_id ></td></tr>");
            out.println("<tr><td colspan = 2 align = center><input type = submit  name = Submit value = Submit>");
            out.println("<input type = Reset  name = Reset value = Clear></td></tr>");
            out.println("</table></body>");
            out.println("</html>");*/

          RequestDispatcher rd2= request.getRequestDispatcher("/footer");	
          rd2.include(request,response); 

     } 
}
 