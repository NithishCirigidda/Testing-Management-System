import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CreateUserServlet extends HttpServlet
{

public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {   
            response.setContentType("text/html");
          PrintWriter out = response.getWriter();

          RequestDispatcher rd1=request.getRequestDispatcher("./header");
          rd1.include(request,response);


          out.println("<html><head><title>User Creation</title></head>");
          out.println("<body bgcolor = #ccffdd >");
          out.println("<form  method = POST action = \"./createUser1\" >");
          out.println("<table border = 0 width = 45% align = center bgcolor = #bbccff>");
          out.println("<caption><strong>CreateUser</strong></caption>");
          out.println("<tr><td>EmpNo</td><td><input type = text name =emp_no  ><td></tr>");
          out.println("<tr><td>Password</td><td><input type = password name = password><td></tr>");
          out.println("<tr><td>UserId</td><td><input type = text name = user_id><td></tr><tr>");
        out.println("<tr><td>UserName</td><td><input type = text name =user_name  ><td></tr>");
          out.println("<tr><td>Email</td><td><input type = text name = email><td></tr>");
          out.println("<tr><td>PhoneOffice</td><td><input type = text name = phone_office><td></tr><tr>");
                   
        out.println("<tr><td>PhoneHome</td><td><input type = text name =phone_home  ><td></tr>");
          out.println("<tr><td>PhoneVoip</td><td><input type = text name =phone_voip><td></tr>");
          out.println("<tr><td>PhoneMobile</td><td><input type = text name = phone_mobile><td></tr><tr>");
                   
        out.println("<tr><td>CubicNO</td><td><input type = text name =cubic_no  ><td></tr>");
          out.println("<tr><td>Location</td><td><input type = text name = location><td></tr>");
          out.println("<tr><td>BirthDay</td><td><input type = text name = birthday><td></tr><tr>");
  
          out.println("<td valign = top>Description</td><td><textarea rows = 4 cols = 16 name = description></textarea></td></tr>");
          out.println("<tr><td>Is Alive</td><td><input type = text name = is_alive><td></tr>");
          out.println("<tr><td>Time Stamp</td><td><input type = text name =\"time_stamp\"><td></tr>");
          out.println("<tr ><td colspan = 2  align =center><input type = submit  name = Submit value = Submit> <input type = Reset  name = Reset value = Clear></td></tr>");
          out.println("</table></form>");
          out.println("</body></html>");



         RequestDispatcher rd2=request.getRequestDispatcher("./footer");
      rd2.include(request,response);


  }
}
