import java.io.*;
import java.sql.*;
public class TestActivityEffortHandler 
{

	Effort effortObj=null;
                   DBStorage dBStorage=null;  
                 
                 TestActivityEffortHandler() throws Exception
                  {
                            dBStorage= new DBStorage();
                            effortObj=new Effort(); 
                  }

	public String addTestActivityEffort(Effort effortObj)  throws Exception 
                  {
                               
                                   return  dBStorage.addTestActivityEffort(effortObj);                              
	} 
                 
                 public Effort getTestActivityEffort(String activity_id) throws Exception
                  {
                                  return dBStorage.getTestActivityEffort(activity_id);                                                           
                 }	
                 
                  public String  updateTestActivityEffort(Effort effortObj ) throws Exception
                  {
                             return dBStorage.updateTestActivityEffort(effortObj);
                  }

                   public int getActivityEffort(String activityId) throws Exception
                  {
                   System.out.println("TestActivity EffortHandler");
                  dBStorage= new DBStorage();
                  int effort2=dBStorage.getActivityEffort(activityId);
                  return effort2;
  
                  }

	
	public int getTestPhaseEffort(String phaseId) throws Exception
                     {
                       dBStorage= new DBStorage();
                      int effort4=dBStorage.getTestPhaseEffort(phaseId);
	    return effort4;
	}

	
	public int  getProjectEffort(String projectId) throws Exception 
	 {
                           dBStorage= new DBStorage();
                          int effort3 = dBStorage.getProjectEffort(projectId);
	       return effort3;
	}

		
	public int getTesterEffort(String emp_no)throws Exception
                   {
                  
                    dBStorage= new DBStorage();
                    int testerEffort=dBStorage.getTesterEffort(emp_no);
                     return testerEffort;
		
	} 


}
