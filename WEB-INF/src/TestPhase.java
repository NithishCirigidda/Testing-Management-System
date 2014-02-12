public class TestPhase 
{

    private String phase_id;
    private String phase_name;
    private Project projectObj;
    private String description;
    private int is_alive;
    private String time_stamp;
   
    public void setPhaseId(String phase_id)
    {
         this.phase_id = phase_id;    
    }
    public  String getPhaseId()
    {
         return phase_id;
    }
    public void setPhaseName(String phase_name)
    {
         this.phase_name = phase_name; 
    }
    public  String getPhaseName()
    {
         return phase_name;
    }
    public void setProjectObj(Project projectObj)
    {
         this.projectObj = projectObj; 
    }
    public  Project getProjectObj()
    {
         return projectObj;
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