import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class CreateUserServlet1 extends HttpServlet
{
     User userObj=new User();
      
    /*public void CreateUserServlet() throws Exception
     {
      userObj=new User();
      tmsManager = new TMSManager();
     }*/
   public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {        
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();

          RequestDispatcher rd1=request.getRequestDispatcher("./header");
          rd1.include(request,response);
           
         
           try
         {
          //System.out.println("hai1");

          String emp_no = request.getParameter("emp_no");
          String password = request.getParameter("password");
          String user_id = request.getParameter("user_id");
          //System.out.println("hai1");
          String user_name = request.getParameter("user_name");
          String email = request.getParameter("email");
          String phone_office = request.getParameter("phone_office");
          //System.out.println("hai1");

          String phone_home= request.getParameter("phone_home");
          String phone_voip = request.getParameter("phone_voip");
          String phone_mobile = request.getParameter("phone_mobile");
          //System.out.println("hai1");
          String cubic_no= request.getParameter("cubic_no");
          String location = request.getParameter("location");
          String  bdate = request.getParameter("birthday");
	/*String[] s=bdate.split("-");
	int year=Integer.parseInt(s[0]);
	int month=Integer.parseInt(s[1]);
	int date=Integer.parseInt(s[2]);
	Date bdate1=new Date(year,month,date);*/
         System.out.println(bdate);
          String description = request.getParameter("description");
          int is_alive = Integer.parseInt(request.getParameter("is_alive"));
          String time_stamp = request.getParameter("time_stamp");
           //System.out.println("hai1");
          System.out.println("emp_no is"+emp_no);
          System.out.println("password"+password);
         userObj.setEmpNo(emp_no);
          System.out.println("emp_no is"+emp_no);
         //System.out.println("hai2");
         userObj.setPassword(password);

//System.out.println("hai2");
         userObj.setUserId(user_id);

//System.out.println("hai2");
         userObj.setUserName(user_name);

 //System.out.println("hai2");
         userObj.setEmail(email);
//System.out.println("hai2");
         userObj.setPhoneOffice(phone_office);
//System.out.println("hai2");

         userObj.setPhoneHome(phone_home);

 //System.out.println("hai2");
         userObj.setPhoneVoip(phone_voip);
//System.out.println("hai2");
         userObj.setPhoneMobile(phone_mobile);
//System.out.println("hai2");

         userObj.setCubicNo(cubic_no);
       //System.out.println("hai2");
         userObj.setLocation(location);
           //System.out.println("hai1.....");


      /*  String[] birthday = bdate.split("-");
        int sy=Integer.parseInt(birthday[0]);
        int sm=Integer.parseInt(birthday[1]);
        int sd=Integer.parseInt(birthday[2]);*/

//java.util.Date d1=new java.util.Date(sy,sm,sd);
//System.out.println("java.util.Date=="+d1);
        java.sql.Date birthday1 =java.sql.Date.valueOf(bdate);
	System.out.println("CUS class"+birthday1);
       //System.out.println("hai2");
      userObj.setBirthday(birthday1);
//System.out.println("hai2");       
userObj.setDescription(description); 
//System.out.println("hai2");      
 userObj.setIsAlive(is_alive);
       //System.out.println("hai1.........");

       userObj.setTimeStamp(time_stamp);
        //System.out.println("hai1.........");

       String message=null; 
     // System.out.println("hai1.........");
      TMSManager tmsManager = new TMSManager();
       message=tmsManager.createUser(userObj);
         //System.out.println("hai1.........");

       out.println("<html><body><h4>"+message+"</h4></body></html>");
       out.println("<a href=./Administrator>Admin Home</a>");
       System.out.println(message);
       }
      catch(Exception e)
      {
       System.out.println("hai ........"+e.toString());
      }
      RequestDispatcher rd2=request.getRequestDispatcher("./footer");
      rd2.include(request,response);
   }
}
