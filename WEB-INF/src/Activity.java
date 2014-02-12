
public class Activity 
{

    private String activity_id;

   private TestPhase testPhaseObj;
    
    private String activity_name;
    private String activity_description;
    private int activity_type;
    private java.sql.Date start_date;
    private java.sql.Date end_date;
    private int activity_effort;
    private int status;
    private User userObj;
    private java.sql.Date time_stamp;

    public void setActivityId(String activity_id) 
    {
         this.activity_id = activity_id;
    }
   public void setTestPhaseObj(TestPhase testPhaseObj)
    {
         this.testPhaseObj = testPhaseObj;
    }
    public void setActivityName(String activity_name) 
    {
         this.activity_name = activity_name;
    }
    public void setActivityDescription(String activity_description) 
    {
         this.activity_description = activity_description;
    }
    public void setActivityType(int activity_type)
    {
         this.activity_type = activity_type;
    }
    public void setStartDate(java.sql.Date start_date)
    {
         this.start_date = start_date;
    }
    public void setEndDate(java.sql.Date end_date)
    {
         this.end_date = end_date;
    }
    public void setActivityEffort(int activity_effort)
    {
         this.activity_effort = activity_effort;
    }
    public void setStatus(int status)
    {
         this.status = status;
    }
    public void setUserObj(User userObj)
    {
         this.userObj = userObj;
    }
    public void setTimeStamp(java.sql.Date time_stamp)
    {
	System.out.println("Activity-timestamp"+time_stamp);
         this.time_stamp = time_stamp;
    }
     public String getActivityId() 
    {
         return this.activity_id;
    }
    public TestPhase getTestPhaseObj()
    {
         return this.testPhaseObj;
    }   
    public String getActivityName() 
    {
         return this.activity_name;
    }
    public String getActivityDescription()
    {
         return this.activity_description;
    }
    public int getActivityType()
    {
         return this.activity_type;
    }
    public java.sql.Date getStartDate()
    {
         return this.start_date;
    }
    public java.sql.Date getEndDate()
    {
         return this.end_date;
    }
    public int getActivityEffort()
    {
         return this.activity_effort;
    }
    public int getStatus()
    {
         return this.status;
    }
    public User getUserObj()
    {
         return this.userObj;
    }
    public java.sql.Date getTimeStamp()
    {
         return this.time_stamp;
    }
}