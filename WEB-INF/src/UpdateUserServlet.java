import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateUserServlet extends HttpServlet
{
User userObj=null;
TMSManager tmsManager = null;

public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {   

  response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          try{
	 userObj=new User();
 tmsManager = new TMSManager();
        
         RequestDispatcher rd1=request.getRequestDispatcher("./header");
         rd1.include(request,response);

      
 String user_id = request.getParameter("user_id");
      userObj = tmsManager.getUser(user_id);
                      if(userObj.getUserId() == null)
	{
            out.println(" <h4 align=\"center\">There is no user with this Id</h4></font>");
	out.println("<a href=./Administrator>Admin Home</a><br>");
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
System.out.println(description);
int is_alive=userObj.getIsAlive();
String time_stamp=userObj.getTimeStamp();

          out.println("<html><head><title>Update Creation</title></head>");
          out.println("<body bgcolor = #ccffdd >");
          out.println("<form  method = POST action = \"./updateUser\" >");
          out.println("<table border = 1 width = 45% align = center bgcolor = #bbccff>");
          out.println("<caption><strong>UpdateUser</strong></caption>");
          out.println("<tr><td>EmpNo</td><td><input type = text name =emp_no value ="+emp_no+"><td></tr>");
          out.println("<tr><td>Password</td><td><input type =password name = password value ="+password+"><td></tr>");
          out.println("<tr><td>UserId</td><td><input type = text name = user_id value ="+user_id+"><td></tr><tr>");
        out.println("<tr><td>UserName</td><td><input type = text name =user_name value ="+user_name+"  ><td></tr>");
          out.println("<tr><td>Email</td><td><input type = text name = email value ="+email+"><td></tr>");
          out.println("<tr><td>PhoneOffice</td><td><input type = text name = phone_office value ="+phone_office+"><td></tr><tr>");
                   
        out.println("<tr><td>PhoneHome</td><td><input type = text name =phone_home value ="+phone_home+"  ><td></tr>");
          out.println("<tr><td>PhoneVoip</td><td><input type = text name =phone_voip value ="+phone_voip+"><td></tr>");
          out.println("<tr><td>PhoneMobile</td><td><input type = text name = phone_mobile value ="+phone_mobile+"><td></tr><tr>");
                   
        out.println("<tr><td>CubicNO</td><td><input type = text name =cubic_no value ="+cubic_no+"  ><td></tr>");
          out.println("<tr><td>Location</td><td><input type = text name = location value ="+location+"><td></tr>");
          out.println("<tr><td>BirthDay</td><td><input type = text name = birthday value ="+birthday+"><td></tr><tr>");
  
          out.println("<tr><td>Description</td><td><input type=text  name = description value ="+description+"></textarea></td></tr>");
          out.println("<tr><td>Is Alive</td><td><input type = text name = is_alive value ="+is_alive+"><td></tr>");
          out.println("<tr><td>Time Stamp</td><td><input type = text name = time_stamp value ="+time_stamp+"><td></tr>");
          out.println("<tr ><td colspan = 2  align =center><input type = submit  name = Submit value = Submit> <input type = Reset  name = Reset value = Clear></td></tr>");
          out.println("</table></form>");
          out.println("</body></html>");

             emp_no = request.getParameter("emp_no");
          password = request.getParameter("password");
           user_id = request.getParameter("user_id");

    user_name = request.getParameter("user_name");
           email = request.getParameter("email");
          phone_office = request.getParameter("phone_office");


             phone_home= request.getParameter("phone_home");
           phone_voip = request.getParameter("phone_voip");
          phone_mobile = request.getParameter("phone_mobile");

    cubic_no= request.getParameter("cubic_no");
         location = request.getParameter("location");
       String   bdate = request.getParameter("birthday");


 description = request.getParameter("description");
          is_alive = Integer.parseInt(request.getParameter("is_alive"));
           time_stamp = request.getParameter("time_stamp");

      userObj.setEmpNo(emp_no);
   userObj.setPassword(password);
   userObj.setUserId(user_id);
  userObj.setUserName(user_name);
  userObj.setEmail(email);
  userObj.setPhoneOffice(phone_office);
  userObj.setPhoneHome(phone_home);
  userObj.setPhoneVoip(phone_voip);
   userObj.setPhoneMobile(phone_mobile);
   userObj.setCubicNo(cubic_no);
   userObj.setLocation(location);


String[] birthday2 = bdate.split("-");
                int sy=Integer.parseInt(birthday2[0]);
	int sm=Integer.parseInt(birthday2[1]);
	int sd=Integer.parseInt(birthday2[2]);
                   java.sql.Date birthday1 =new java.sql.Date(sy,sm,sd);
   userObj.setBirthday(birthday1);
    userObj.setDescription(description); 
    userObj.setIsAlive(is_alive);
    userObj.setTimeStamp(time_stamp);
String message=null;
message=tmsManager.updateUser(userObj);
   
       out.println("<html><body ><h4 align= \"center\">"+message+"</h4></body></html>");
      
       
      }    

         }catch(Exception e){System.out.println("hai ........"+e.getMessage());}
out.println("<a href=./Administrator>Admin Home</a><br>");
      out.println("<html><head><title>UpdateUser</title></head>");
            out.println("<body onload=onSubmit() bgcolor =\"#ffccbb\">");
            out.println("<form  method =\"POST\"  action =\"./updateUser\" ><br><br><br>");
            out.println("<table border = 1 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>UpdateUser</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter User ID</td>");
            out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body></html>");

  
 RequestDispatcher rd2=request.getRequestDispatcher("./footer");
      rd2.include(request,response);

}
}