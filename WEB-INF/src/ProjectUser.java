import java.sql.Date;
public class ProjectUser
{
private Project projectObj;
private User userObj;
private Date assignment_date;
private Date submit_date;
private int status;
private String time_stamp;

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

public void setAssignmentDate(Date assignment_date)
{
this.assignment_date=assignment_date;
}
public Date getAssignmentDate()
{
return assignment_date;
}
public void setSubmitDate(Date submit_date)
{
this.submit_date=submit_date;
}
public Date getSubmitDate()
{
return submit_date;
}
public void setStatus(int status)
{
this.status=status;
}
public int getStatus()
{
return status;
}
public void setTimeStamp(String time_stamp)
{
this.time_stamp=time_stamp;
}
public String getTimeStamp()
{
return time_stamp;
}
}