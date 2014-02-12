public class ProjectCreationManagementSystem
{
private DBStorage dbStorage = null;

public ProjectCreationManagementSystem() throws Exception
{

dbStorage = new DBStorage();
}
/******************create project******************/

public String createProject(Project projectObj) 
{
  return dbStorage.storeProject(projectObj);
    }

/******************view project******************/

public Project getProject(String project_id) 
{
  return dbStorage.getProject(project_id);
  }

/******************update project******************/
public String updateProject(Project projectObj) 
{
  return dbStorage.updateProject(projectObj);
    }
/******************delete project******************/

public String deleteProject(String project_id) 
{
  return dbStorage.deleteProject(project_id);
  }

}