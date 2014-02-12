import java.sql.Date;
public class ProjectAssignment
{
private Project projectObj;
private User userObj;

private String emp_name;
private Date planstart_date;
private Date planend_date;
private int status;
private java.sql.Date time_stamp;
private int is_alive ;

public void setProjectObj(Project projectObj)
{
this.projectObj=projectObj;
}
public Project getProjectObj()
{
return projectObj;
}
public void setUserObj(User userObj)
{
this.userObj=userObj;
}
public User getUserObj()
{
return userObj;
}

public void setEmpName(String emp_name)
{
this.emp_name= emp_name;
}
public String getEmpName()
{
return emp_name;
}

public void setPlanstartDate(Date planstart_date)
{
this. planstart_date= planstart_date;
}
public Date getPlanstartDate()
{
return planstart_date;
}
public void setPlanendDate(Date planend_date)
{
this.planend_date=planend_date;
}
public Date getPlanendDate()
{
return planend_date;
}

public void setTimeStamp(java.sql.Date time_stamp)
{
this.time_stamp=time_stamp;
}
public java.sql.Date getTimeStamp()
{
return time_stamp;
}
public void setIsAlive(int is_alive)
{
this.is_alive=is_alive;
}
public int getIsAlive()
{
return is_alive;
}
}
