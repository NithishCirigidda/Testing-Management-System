import java.sql.Date;

public class ActivityUser
{

    private Activity activityObj;
    private User userObj;
    private int activity_effort;
    private Date start_date;
    private Date end_date;
    private int status;
    private int percentage_completed;
    private String time_stamp;

    public void setActivityObj(Activity activityObj)
    {
        this.activityObj = activityObj;
    }
    public void setUserObj(User userObj)
    {
        this.userObj = userObj;
    }
    public void setActivityEffort(int activity_effort)
    {
        this.activity_effort=activity_effort;
    }
    public void setStartDate(Date start_date )
    {
        this.start_date=start_date;
    }
    public void setEndDate(Date end_date)
    {
        this.end_date=end_date;
    }
        public void setStatus(int status)
    {
        this.status=status;
    }
    public void setPercentageCompleted(int percentage_completed)
    {
        this. percentage_completed= percentage_completed;
    }
    public void setTimeStamp(String time_stamp)
    {
        this.time_stamp= time_stamp;
    }     

    public Activity getActivityObj()
    {
      return  this.activityObj;
    }
    public User getUserObj()
    {
      return this.userObj;
    }
    public int getActivityEffort()
    {
      return this.activity_effort;
    }
    public Date getStartDate()
    {
      return this.start_date;
    }
    public Date getEndDate()
    {
      return this.end_date;
    }
    public int getStatus()
    {
      return this.status;
    }
    public int getPercentageCompleted()
    {
       return this. percentage_completed;
    }
    public String getTimeStamp()
    {
      return this.time_stamp;
    }
}