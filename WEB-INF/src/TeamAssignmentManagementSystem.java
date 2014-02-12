import java.io.*;
import java.sql.Date;

public class TeamAssignmentManagementSystem 
{
  private DBStorage dbStorage = null;
 ProjectAssignment projectAssignmentObj=null;
public TeamAssignmentManagementSystem() throws Exception 
{
dbStorage = new DBStorage();
  projectAssignmentObj=new  ProjectAssignment();
}
/******************AssignmentProject******************/
public String projectAssignment(ProjectAssignment projectAssignmentObj) 
{
String msg=null;
  try
  {
  msg=dbStorage.storeProjectAssignment(projectAssignmentObj);
  }
  catch(Exception e)
  {
   System.out.println(e);
   }  
  return msg;
  
  }

/******************viewAssignment******************/
public ProjectAssignment getProjectAssignment( String project_id) 
{
try
  {
projectAssignmentObj=dbStorage.getProjectAssignment(project_id);
  }
  catch(Exception e)
  {
   System.out.println(e);
   }  
      return projectAssignmentObj;
 }

/*****************updateProjectAssignment******************/
public String updateProjectAssignment(ProjectAssignment projectAssignmentObj) 
{
String msg=null;
  try
  {
 msg=dbStorage.updateProjectAssignment(projectAssignmentObj);
  }
  catch(Exception e)
  {
   System.out.println(e);
   }  
  return msg;

}

}
