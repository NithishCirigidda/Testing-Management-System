import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewUserServlet1 extends HttpServlet
{
      TMSManager tmsManager = null;
      User userObj = null;
      
      
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
            
            

           String user_id = request.getParameter("user_id");                      
            userObj = tmsManager.getUser(user_id);
            if(userObj.getUserId() == null)
	{
            out.println("<h4 align = center>Please enter User id</h4>");
            out.println("<html><head><title>View User</title></head>");
            out.println("<body bgcolor =\"bbccff\">");
	            
            out.println("<form  method =\"POST\"  action =\"./viewUser1\" ><br><br><br>");
            out.println("<table border = \"3\" width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
	out.println("<a href=./Administrator>Admin Home</a><br>");
            out.println("<caption><b>View User</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter user ID</td>");
            out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
              }       
            else{
              String emp_no = userObj.getEmpNo();
               String password = userObj.getPassword();
               user_id= userObj.getUserId();
               String user_name= userObj.getUserName();
            String email= userObj.getEmail();
	String phone_office= userObj.getPhoneOffice();
	String phone_home= userObj.getPhoneHome();
	String phone_voip= userObj.getPhoneVoip();
	String phone_mobile= userObj.getPhoneMobile();
	String cubic_no= userObj.getCubicNo();
	String location= userObj.getLocation();
	java.sql.Date birthday= userObj.getBirthday();
	String description= userObj.getDescription();
	int is_alive=userObj.getIsAlive();
	String time_stamp=userObj.getTimeStamp();

           out.println("<html><head><title>View User</title></head>");
            out.println("<body bgcolor = \"bbccff\">");
	out.println("<a href=./Administrator>Admin Home</a><br>");
            out.println("<table border = 1 width = 45% align = center bgcolor = #bbccff>");
            out.println("<caption>User Content</caption>");
            out.println(" <tr><td>EmpNo</td><td>"+emp_no+"</td></tr>");
            out.println(" <tr><td>Password</td><td>"+password+"</td></tr>");
            out.println(" <tr><td>UserId</td><td>"+user_id+"</td></tr>");
            out.println(" <tr><td>UserName</td><td>"+user_name+"</td></tr>");
            out.println(" <tr><td>Email</td><td>"+email+"</td></tr>");
            out.println(" <tr><td>PhoneOffice</td><td>"+phone_office+"</td></tr>");
            out.println(" <tr><td>PhoneHome</td><td>"+phone_home+"</td></tr>");
            out.println(" <tr><td>PhoneVoip</td><td>"+phone_voip+"</td></tr>");
            out.println(" <tr><td>PhoneMobile</td><td>"+phone_mobile+"</td></tr>");
            out.println(" <tr><td>CubicNo</td><td>"+cubic_no+"</td></tr>");
            out.println(" <tr><td>Location</td><td>"+ location+"</td></tr>");
            out.println(" <tr><td>Birthday</td><td>"+ birthday+"</td></tr>");
            out.println(" <tr><td>Description</td><td>"+ description+"</td></tr>");
            out.println(" <tr><td>IsAlive</td><td>"+ is_alive+"</td></tr>");
            out.println(" <tr><td>Time Stamp</td><td>"+time_stamp+"</td></tr>");
            
           
out.println("<html><head><title>View User</title></head>");
            out.println("<body bgcolor =\"bbccff\">");
            out.println("<form  method =\"POST\"  action =\"./viewUser1\" ><br><br><br>");
            out.println("<table border = 0 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>View User</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter user ID</td>");
            out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
       

                }

             }
	catch(Exception e)
              
	{
               System.out.println(e.getMessage());
                }


            

         RequestDispatcher rd2=request.getRequestDispatcher("./footer");
          rd2.include(request,response);
      }
}


           