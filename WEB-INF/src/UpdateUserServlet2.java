import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateUserServlet2 extends HttpServlet
{
User userObj=null;
TMSManager tmsManager = null;


public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {   




  response.setContentType("text/html");
          PrintWriter out = response.getWriter();
         RequestDispatcher rd1=request.getRequestDispatcher("./header");
         rd1.include(request,response);
          try{

        userObj=new User();
        tmsManager = new TMSManager();

        String emp_no = request.getParameter("emp_no");
         String password = request.getParameter("password");
           String user_id = request.getParameter("user_id");

      String user_name = request.getParameter("user_name");
        String email = request.getParameter("email");
            String phone_office = request.getParameter("phone_office");


               String phone_home= request.getParameter("phone_home");
             String phone_voip = request.getParameter("phone_voip");
           String phone_mobile = request.getParameter("phone_mobile");

       String cubic_no= request.getParameter("cubic_no");
           String location = request.getParameter("location");
       String   bdate = request.getParameter("birthday");


   String description = request.getParameter("description");
          int is_alive = Integer.parseInt(request.getParameter("is_alive"));
              String time_stamp = request.getParameter("time_stamp");

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
   
       out.println("<html><body><h4 align =\"center\">"+message+"</h4></body></html>");
       

    out.println("<html><head><title>UpdateUser</title></head>");
            out.println("<body onload=onSubmit() bgcolor =\"#ffccbb\">");
            out.println("<form  method =\"POST\"  action =\"./updateUser1\" ><br><br><br>");
            out.println("<table border = 1 width = \"40%\" align = \"center\" bgcolor = \"#bbccff\">");
            out.println("<caption><b>UpdateUser</b></caption>");
            out.println("<tr><td style = font face: verdana>Enter User ID</td>");
            out.println("<td><input type = \"text\" name = \"user_id\" ></td></tr>");
            out.println("<tr><td colspan = 2 align = \"center\"><input type = \"submit\"  name = \"Submit\" value = \"Submit\">");
            out.println("<input type = \"Reset\"  name = \"Reset\" value = \"Clear\"></td></tr>");
            out.println("</table>");
            out.println("</body></html>");
    
  }    

         catch(Exception e)
{
System.out.println(e.getMessage());
}

 RequestDispatcher rd2=request.getRequestDispatcher("./footer");
      rd2.include(request,response);

}
}
