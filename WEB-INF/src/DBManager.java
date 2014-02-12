import java.sql.*;
public class DBManager
{
    Connection con;
    public DBManager()
    {
        try
        {
            //Load MySQL JDBC Type-4 driver
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tms";
            con = DriverManager.getConnection(url,"root","");    
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }

    public Connection getConnection()
    {
        return con;
    }
}
