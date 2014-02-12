import java.util.Date;
public class Effort
 {

	private User userObj;
	private Activity activityObj;
	private Date effort_date;
                   private Date start_date;
	private Date end_date;
                   private int effort;
                   private String effort_description;   
                  private String  effort_time_stamp;

             
	public Date getStartDate()
                   {
                         return  this.start_date;
                   }
	public void setStartDate(Date start_date) 
                   {
	      this.start_date = start_date;
	}
	public Date getEndDate()
                  {
	     return this.end_date;
	}
	public void setEndDate(Date end_date) 
                   {
  	    this.end_date = end_date;
                    }
     
	public int getEffort()
                   {
		return this.effort;
	}

	public void setEffort(int effort) 
                    {
		this.effort = effort;
	}
                   public Date getEffortDate() 
                  {
		return this.effort_date;
	}

	public void setEffortDate(Date effort_date) {
		this.effort_date = effort_date;
	}
                   public User getUserObj() 
                   {
		return this.userObj;
	}
	public void setUserObj(User userObj) 
                  {
		this.userObj = userObj;
	}

                   public Activity getActivityObj() 
                  {
                             return this.activityObj;
	}
	public void setActivityObj(Activity activityObj) 
                   {
		this.activityObj = activityObj;
	}
	public String getEffortDescription()
                  {
		return this.effort_description;
	}
	public void setEffortDescription(String effort_description) {
		this.effort_description = effort_description;
	}
                 
                    public String getEffortTimeStamp()
  	{
                                   return this.effort_time_stamp;
                     }

                    public void setEffortTimeStamp(String effort_time_stamp)
	{
                                   this.effort_time_stamp=effort_time_stamp;
                    }

}