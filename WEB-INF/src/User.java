import java.sql.Date;

public class User
{
    private String emp_no;
    private String password;
    private String user_id;
    private String user_name;
    private String email;
    private String phone_office;
    private String phone_home;
    private String phone_voip;
    private String phone_mobile;
    private String cubic_no;
    private String location;
    private Date birthday;
    private String description;
    private int is_alive;
    private String time_stamp;

    public void setEmpNo(String emp_no)
    {
          this.emp_no = emp_no;
    }
    public String getEmpNo()
    {
          return emp_no;
    }    

    public void setPassword(String password)
    {
          this.password = password;
    }
    public String getPassword()
    {
          return password;
    }

    public void setUserId(String user_id)
    {
          this.user_id = user_id;
    }    
    public String getUserId()
    {
         return user_id;
    }

    public void setUserName(String user_name)
    {
         this.user_name = user_name;
    }
    public String getUserName()
    {
         return user_name;
    }

    public void setEmail(String email)
    {
         this.email = email;
    }
    public String getEmail()
    {
         return email;
    }

    public void setPhoneOffice(String phone_office)
    {
         this.phone_office = phone_office;
    }
    public String getPhoneOffice()
    {
         return phone_office;
    }

    public void setPhoneHome(String phone_home)
    {
         this.phone_home = phone_home;
    }
    public String getPhoneHome()
    {
         return phone_home;
    }

    public void setPhoneVoip(String phone_voip)
    {
         this.phone_voip = phone_voip;
    }
    public String getPhoneVoip()
    {
         return phone_voip;
    }

    public void setPhoneMobile(String phone_mobile)
    {
         this.phone_mobile = phone_mobile;
    }
    public String getPhoneMobile()
    {
         return phone_mobile;
    }

    public void setCubicNo(String cubic_no)
    {
         this.cubic_no = cubic_no;
    }
    public String getCubicNo()
    {
         return cubic_no;
    }

    public void setLocation(String location)
    {
         this.location = location;
    }
    public String getLocation()
    {
         return location;
    }
  
     public void setBirthday(Date birthday)
    {
         this.birthday = birthday;
	System.out.println("user class"+birthday);
    }
    public Date getBirthday()
    {
         return birthday;
    }

     public void setDescription(String description)
     {
          this.description = description;
     }
     public String getDescription()
     {
          return description; 
     }
  
     public void setIsAlive(int is_alive)
     {
          this.is_alive = is_alive;
     }
     public int getIsAlive()
     {
          return is_alive;
     }

     public void setTimeStamp(String time_stamp)
     {
          this.time_stamp = time_stamp;
     }
     public String getTimeStamp()
     {
          return time_stamp;
     }
}