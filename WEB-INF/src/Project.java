public class Project
{
    private String project_id;
    private String project_name;
    private String description;
    private int is_alive;
    private String time_stamp;

    public void setProjectId(String project_id)
    {
         this.project_id = project_id;
    }
    public String getProjectId()
    {
         return project_id;
    }
 
    public void setProjectName(String project_name)
    {
         this.project_name = project_name;
    }
    public String getProjectName()
    {
         return project_name;
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