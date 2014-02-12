import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class ManagerLoginServlet extends HttpServlet
{
    DBManager manager =null;
    PreparedStatement pstmt = null ;
    ResultSet rs = null;
     int count;
   
    private String pid = "select project_id from projectassignment where emp_no = (select emp_no from user where user_id=?)";
    public ManagerLoginServlet(){
        try{
            manager = new DBManager();
           count=0;
            
        }catch(Exception e){
              System.out.println(e.getMessage());
          }
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
      // String user_id = request.getParameter("user_id");
       //String password = request.getParameter("password");

       HttpSession session = request.getSession(true);
       String user_id = (String)session.getAttribute("user_id");
      System.out.println(user_id);
     //System.out.println(session.getAttribute("user_id"));
       PrintWriter out = response.getWriter();
       
       RequestDispatcher rd1=request.getRequestDispatcher("./header");
       rd1.include(request,response);
        
       // HttpSession session = request.getSession(true);
       // String pwd = (String)session.getAttribute("password");
        out.println("<P>");
        out.print("<form action=\"./TestManager\" ");
             out.println("method=GET>");
         try
        {
        
         pstmt = manager.getConnection().prepareStatement(pid);
         System.out.println(user_id);
         pstmt.setString(1,user_id);
        
         //pstmt.setString(2,password);
         rs = pstmt.executeQuery();
        
        out.println("<center>");
        out.println("<br><br>");
        out.println("ProjectId: <SELECT NAME=\"project\" >");
         
            while(rs.next())
            {
                String str = rs.getString("project_id");
               
               //System.out.println(rs.getString("project_id")); 
                out.println("<OPTION VALUE=\"" + str + "\">" + str + "</OPTION>");
                count=count +2;
            }
       
        if(count==0)
        {
                out.println("<OPTION VALUE=\"default\">default</OPTION>");
        }
        out.println("</center>");
        out.println("</SELECT>");
        out.println("<br><br>");
        out.println("<input type=submit value = submit>");
        out.println("</form>");
       // response.sendRedirect("./TestManager");
        RequestDispatcher rd2=request.getRequestDispatcher("./footer");
        rd2.include(request,response);
 
        out.println("</body>");
        out.println("</html>");

}
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}