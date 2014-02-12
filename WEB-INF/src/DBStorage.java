 import java.sql.*;
 import java.io.*;
 import java.sql.Date;

public class DBStorage
{  
        private int status;
       TestPhase  testPhaseObj=new TestPhase();
       ActivityUser  activityUserObj = new ActivityUser();
       TestCase testCaseObj = new TestCase();  
       User userObj = new User();
       Project projectObj=new Project();
       Activity activityObj=new Activity();
       Effort effortObj=new Effort(); 
       ResultSet rs = null;
     ProjectAssignment projectAssignmentObj=new  ProjectAssignment();




       DBManager manager = new DBManager();
       //ActivityAssignment  activityAssignment = new ActivityAssignment();
       //ActivityUser  activityUserObj = new ActivityUser();
       TestCaseExecutionMgtHandler exeMgtHandler = new TestCaseExecutionMgtHandler();
       private PreparedStatement pstmt=null; 

               
      /*=========================Statements===========================*/
    
   
    private String insertTestPhase = "insert into phases values(?,?,?,?,?,?)";

    private String updateTestPhase = "update phases set phase_name=?,project_id=?,description=?,is_alive=?,time_stamp=? where phase_id=?";

    private String viewTestPhase = "select * from phases where phase_id=?"; 
    
    private String deleteTestPhase = "delete from phases where phase_id=?";  

     private String insertActivity = "insert into activity values(?,?,?,?,?,?,?,?,?,?,?)";  

       private String viewActivity = "select * from activity where activity_id=?";

       private String updateActivity = "update activity set phase_id=?,activity_name=?,activity_description=?,activity_type=?,start_date=?,end_date=?,activity_effort=?,status=?,emp_no=?,time_stamp=? where activity_id=?";
       
       private String deleteActivity= "delete from activity where activity_id=?";  

       private String getActivityStatus = "select status from activity where activity_id=?";
      
       private String closeActivity = "update activity set status=1 where activity_id=?";
  
      private String assignActivity = "insert into activity_user values(?,?,?,?,?,?,?,?)";
            
       private String getAssign="select * from activity_user where activity_id=?";

       private String updateAssign = "update activity_user set emp_no=?,activity_effort=?,start_date=?, end_date=?,status=?,percentage_completed=?,time_stamp=? where activity_id=?"; 

      private String  showAssignment ="select start_date,end_date from activity_user where activity_id=?";

      private String createTestCase="insert into testcase values(?,?,?,?,?,?,?)";
     
      private String getTestCase="select testcase_id,testcase_description,testcase_phase,project_id,user_id,activity_id,expected_behaviour from testcase where testcase_id=?";

      private String updateTestCase="update testcase set expected_behaviour=? where testcase_id=?";     
         
      private String deleteTestCase="delete from testcase where testcase_id=?";     
        
      private String addExeDetails="insert into testcase_execution values(?,?,?,?,?,?,?)";   
     
       private String getExeDetails="select * from testcase_execution where  testcase_id=?";
           
       private String updateExeDetails="update testcase_execution set testcase_status=?, comments=?, actual_behaviour=?,testcase_actual_date=? where  testcase_id=?";
   
       private String addEffort="insert into effort values(?,?,?,?,?,?,?,?)";   
    
       private String getEffort="select *from effort where activity_id=?";       
   
       private String updateEffort="update effort set description=? where  activity_id=?";

       private String testerTestcases="select * from testcase where user_id=?";    
       private String countUserQuery = "select count(*) from testcase where user_id=?";
   

       private String  activityEffort="select effort from effort where activity_id=?";

       private String testerEffort="select effort from effort where emp_no=?";

      private String projectEffort = "select sum(effort) from activity,effort,phases where effort.activity_id=activity.activity_id and activity.phase_id=phases.phase_id and project_id=?";
       
      private String phaseEffort = "select sum(effort) from activity,effort where effort.activity_id=activity.activity_id and activity.phase_id=?";
 
      private String testcase = "select * from testcase where user_id=?";
      
      private String acttestcase="select testcase_id,testcase_description,testcase_phase,project_id,user_id,activity_id,expected_behaviour from testcase where activity_id=?"; 
     private String countQuery = "select count(*) from testcase where activity_id=?";
    
/******************************** user details****************************/
  private PreparedStatement insertStmt = null;
   private String insertUser="insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   private PreparedStatement updateStmt=null;
   private String updateUser="update user set emp_no=?, password=?, user_name=?, email=?, phone_office=?,phone_home=?,phone_voip=?, phone_mobile=?, cubic_no=?, location=?,birthday=?, description=?,is_alive=?, time_stamp=? where user_id=?";
   private PreparedStatement   viewStmt=null; 
   private String viewUser="select * from user where user_id=?";
  private PreparedStatement deleteStmt=null;    
   private String deleteUser="delete from user where user_id=?";   

/***********************************authentication*************************/
   
   private PreparedStatement passwordStmt=null;    
   private String passwordQuery="select password from user where user_id=?";
   private PreparedStatement passwordChangeStmt=null;    
   private String passwordChangeQuery="update user set password=? where user_id=?";

/******************************************Project***********************************/
     private PreparedStatement insertProjectStmt = null;
   private String insertProject="insert into project values(?,?,?,?,?)";
   private PreparedStatement updateProjectStmt=null;
   private String updateProject="update project set project_name=?, description=?,is_alive=?,time_stamp=? where project_id=?";
   private PreparedStatement   viewProjectStmt=null; 
   private String viewProject="select * from project where project_id=?";
  private PreparedStatement deleteProjectStmt=null;    
   private String deleteProject="delete from project where project_id=?";  







      /**********************************************************************/
       
    private String ExecuTestcases="select * from testcase_execution where user_id=?"; 
   private String ExecuTestcases1="select count(*) from testcase_execution where user_id=?";


/************************************getActivityExecutuionTestCases************************************/

   
    private String activityExecuTestcases="select * from testcase_execution where activity_id=?"; 
   private String activityExecuTestcases1="select count(*) from testcase_execution where activity_id=?";
/*************************************getTesterNonExecutionTestcases*************************************************/

  private PreparedStatement nonExeTestcases=null;
  private PreparedStatement nonExeTestcases1=null;
  private String nonExecuTestcases="select activity_id,testcase_id,user_id from testcase_execution where testcase_status='NOTENTERED' and user_id=?"; 
  private String nonExecuTestcases1="select count(user_id) from testcase_execution where testcase_status='NOTENTERED'  and  user_id=?";

/******************************getFailedTestCasesOfTester****************************************************************/

private PreparedStatement failedTestcases = null;
private PreparedStatement failedTestcases1 = null;
private String failedTestcasesTester = "select * from testcase_execution where user_id=? AND testcase_status='fail' ";
private String failedTestcasesTester1 = "select  count(*) from testcase_execution where user_id=? AND testcase_status='fail' ";

/******************************getFailedTestCasesOfAnActivity****************************************************************/

    private PreparedStatement  failedActivityTestcases = null;
    private PreparedStatement failedActivityTestcases1 = null;
    private String activityFailedTestcases="select * from testcase_execution where activity_id=? AND testcase_status='fail' ";
    private String activityFailedTestcases1 = "select  count(*) from testcase_execution where activity_id=? AND testcase_status='fail' ";

/******************************getPassedTestCasesOfTester****************************************************************/

private PreparedStatement passedTestcases = null;
private PreparedStatement passedTestcases1 = null;
private String passedTestcasesTester = "select * from testcase_execution where user_id=? AND testcase_status='pass' ";
private String passedTestcasesTester1 = "select  count(*) from testcase_execution where user_id=? AND testcase_status='pass' ";


/******************************getPassedTestCasesOfAnActivity****************************************************************/

    private PreparedStatement  passedActivityTestcases = null;
    private PreparedStatement passedActivityTestcases1 = null;
    private String activityPassedTestcases="select * from testcase_execution where activity_id=? AND testcase_status='pass' ";
    private String activityPassedTestcases1 = "select  count(*) from testcase_execution where activity_id=? AND testcase_status='pass' ";
    
/*********************getActivityNonExecutionTestcases*****************************************/

     private PreparedStatement activityNonExeTestcases=null;
    private PreparedStatement activityNonExeTestcases1=null;
    private String activityNonExecuTestcases="select activity_id,testcase_id,user_id from testcase_execution where testcase_status='NOTENTERED' and  activity_id=?"; 
   private String activityNonExecuTestcases1="select count(activity_id) from testcase_execution where testcase_status='NOTENTERED'  and  activity_id=?";

/******************************************ProjectAssignment***********************************/ 
    private PreparedStatement insertAssgnStmt = null;
   private String insertAssgn="insert into projectassignment values(?,?,?,?,?,?,?,?)";
   private PreparedStatement  updateAssgnStmt=null;
   private String updateAssgn="update projectassignment set project_name=?,emp_no=?,emp_name=?,planstart_date=?,planend_date=?,time_stamp=?,is_alive=? where project_id=?";
   private PreparedStatement viewAssgnStmt=null;
   private String viewAssgn="select * from projectassignment where project_id=?";






 public  DBStorage() throws Exception
       {
   
   insertAssgnStmt=manager.getConnection().prepareStatement(insertAssgn);
   viewAssgnStmt=manager.getConnection().prepareStatement(viewAssgn);
   updateAssgnStmt=manager.getConnection().prepareStatement(updateAssgn); 
   insertStmt=manager.getConnection().prepareStatement(insertUser);
   viewStmt=manager.getConnection().prepareStatement(viewUser);
   updateStmt=manager.getConnection().prepareStatement(updateUser);
   deleteStmt=manager.getConnection().prepareStatement(deleteUser);
   passwordStmt=manager.getConnection().prepareStatement(passwordQuery);
   passwordChangeStmt=manager.getConnection().prepareStatement(passwordChangeQuery);


      nonExeTestcases=manager.getConnection().prepareStatement(nonExecuTestcases);  
      nonExeTestcases1=manager.getConnection().prepareStatement(nonExecuTestcases1);
   
       failedTestcases = manager.getConnection().prepareStatement(failedTestcasesTester);
    failedTestcases1 = manager.getConnection().prepareStatement(failedTestcasesTester1);
    activityNonExeTestcases=manager.getConnection().prepareStatement(activityNonExecuTestcases);  
    activityNonExeTestcases1=manager.getConnection().prepareStatement(activityNonExecuTestcases1);
   

       failedActivityTestcases=manager.getConnection().prepareStatement( activityFailedTestcases);
        failedActivityTestcases1=manager.getConnection().prepareStatement( activityFailedTestcases1);
    
        passedTestcases = manager.getConnection().prepareStatement(passedTestcasesTester);
        passedTestcases1 = manager.getConnection().prepareStatement(passedTestcasesTester1);

    passedActivityTestcases=manager.getConnection().prepareStatement( activityPassedTestcases);
    passedActivityTestcases1=manager.getConnection().prepareStatement( activityPassedTestcases1);
  

        pstmt = manager.getConnection().prepareStatement(testerEffort);


        pstmt = manager.getConnection().prepareStatement(projectEffort);

        pstmt = manager.getConnection().prepareStatement(phaseEffort);


insertProjectStmt = manager.getConnection().prepareStatement(insertProject);

updateProjectStmt = manager.getConnection().prepareStatement(updateProject);

deleteProjectStmt = manager.getConnection().prepareStatement(deleteProject);

viewProjectStmt = manager.getConnection().prepareStatement(viewProject);

 status=0;
              
         }        

/***************************Authenticate***********************/
 public String getPassword(String user_id)
{
      String password=null;
      try
     {
              passwordStmt.setObject(1,user_id);
             ResultSet rs=passwordStmt.executeQuery();
             while(rs.next())
            {
             password=rs.getString("password");
            }
     }
      catch(Exception e)
     {
             System.out.println(e);  
      }
       return password;
   }


/**********************************update password************************/

    public String updatePassword(String user_id, String newPassword)
    {
     try
     {
             passwordChangeStmt.setString(1,newPassword);
             passwordChangeStmt.setString(2,user_id);
             status= passwordChangeStmt.executeUpdate();
             if(status == 1)
                 return "Password updated successfully";
             else
                 return "password cannot update";
     }
     catch(Exception e)
     {
      }
      if(status>=1)
               return "successfully updated";
    else
               return "failed";
  }
     public String storeUser(User userObj) 
   {
    try
   {
    insertStmt.setObject(1,userObj.getEmpNo());
    insertStmt.setObject(2,userObj.getPassword());
    insertStmt.setObject(3,userObj.getUserId());
    insertStmt.setObject(4,userObj.getUserName());
    insertStmt.setObject(5,userObj.getEmail());
    insertStmt.setObject(6,userObj.getPhoneOffice());
    insertStmt.setObject(7,userObj.getPhoneHome());
    insertStmt.setObject(8,userObj.getPhoneVoip());
    insertStmt.setObject(9,userObj.getPhoneMobile());
    insertStmt.setObject(10,userObj.getCubicNo());
    insertStmt.setObject(11,userObj.getLocation());
    insertStmt.setObject(12,userObj.getBirthday());
    insertStmt.setObject(13,userObj.getDescription());
    insertStmt.setObject(14,userObj.getIsAlive());
    insertStmt.setObject(15,userObj.getTimeStamp());
    status= insertStmt.executeUpdate();
    }
    catch(Exception e)
    {
    System.out.println(e);
    }    
         
    if(status==1)
    return "successfully inserted";
    else
   return "failed";
   
   }
  /***************************view user *****************************/
   public User getUser(String user_id) 
   {
   try
    {    
    viewStmt.setObject(1,user_id);
    ResultSet rs = viewStmt.executeQuery();
    while(rs.next())
    {
    String emp_no=rs.getString(1);
    String password=rs.getString(2);
     user_id=rs.getString(3);
   String user_name=rs.getString(4);
   String email=rs.getString(5);
   String phone_office=rs.getString(6);
   String phone_home=rs.getString(7);
   String phone_voip=rs.getString(8);
   String phone_mobile=rs.getString(9);
   String cubic_no=rs.getString(10);
  String location=rs.getString(11);
  Date birthday=rs.getDate(12);
  String description=rs.getString(13);
  int is_alive=rs.getInt(14);
  String time_stamp=rs.getString(15);
 
  userObj.setEmpNo(emp_no);
  userObj.setPassword(password);    
  userObj.setUserId(user_id);
  userObj.setUserName(user_name);
  userObj.setEmail(email);
  userObj.setPhoneOffice(phone_office);
  userObj.setPhoneHome(phone_home);
  userObj.setPhoneVoip(phone_voip);
  userObj.setPhoneMobile(phone_mobile);
  userObj.setCubicNo(cubic_no);
  userObj.setLocation(location);
  userObj.setBirthday(birthday);
  userObj.setDescription(description);
  userObj.setIsAlive(is_alive);
  userObj.setTimeStamp(time_stamp);
}  
  }
catch(Exception e)
{
  System.out.println(e);
}
 return userObj;
}
 

/***********************  updateUserDetails*****************************/
public String updateUser(User userObj)
{
try
{
updateStmt.setObject(1,userObj.getEmpNo()); 
updateStmt.setObject(2,userObj.getPassword()); 
updateStmt.setObject(3,userObj.getUserName());
updateStmt.setObject(4,userObj.getEmail());
updateStmt.setObject(5,userObj.getPhoneOffice());    
updateStmt.setObject(6,userObj.getPhoneHome());
updateStmt.setObject(7,userObj.getPhoneVoip());  
updateStmt.setObject(8,userObj.getPhoneMobile()); 
updateStmt.setObject(9,userObj.getCubicNo()); 
updateStmt.setObject(10,userObj.getLocation()); 
updateStmt.setObject(11,userObj.getBirthday());
updateStmt.setObject(12,userObj.getDescription()); 

updateStmt.setObject(13,userObj.getIsAlive()); 
updateStmt.setObject(14,userObj.getTimeStamp()); 
updateStmt.setObject(15,userObj.getUserId()); 
status=updateStmt.executeUpdate();
}
catch(Exception e)
{
System.out.println(e);
}
if(status==1)
return "user update successfully";
else
return "user update failed";
}

/****************************************************Delete User***************************************/
   public String deleteUser(String user_id)
{
   try
{
   deleteStmt.setObject(1,user_id);
  status = deleteStmt.executeUpdate();
}
catch(Exception e)
    {
    System.out.println(e);
    }    
         
    if(status==1)
    return "successfully deleted";
    else
   return "User details cannot br deleted";
}
/************************************project creation*********************************/

public String storeProject(Project projectObj) 
   {
    System.out.println("DBStorage");
    try
   {
    
    insertProjectStmt.setObject(1,projectObj.getProjectId());
    insertProjectStmt.setObject(2,projectObj.getProjectName());
    insertProjectStmt.setObject(3,projectObj.getDescription());
    insertProjectStmt.setObject(4,projectObj.getIsAlive());
    insertProjectStmt.setObject(5,projectObj.getTimeStamp());
    status= insertProjectStmt.executeUpdate();
    }
    catch(Exception e)
    {
    System.out.println(e);
    }    
         
    if(status==1)
    return "successfully inserted";
    else
   return "failed";
   
   }

/***********************************view Project*********************/

public Project getProject(String project_id) 
   {
      try
    {    
    viewProjectStmt.setString(1,project_id);
         
    ResultSet rs = viewProjectStmt.executeQuery();
    while(rs.next())
    {

      project_id=rs.getString(1);
       String project_name=rs.getString(2);
    String description=rs.getString(3);
    int is_alive=rs.getInt(4);
   String time_stamp=rs.getString(5);


  projectObj.setProjectId(project_id);
  projectObj.setProjectName(project_name);
  projectObj.setDescription(description);
  projectObj.setIsAlive( is_alive);
  projectObj.setTimeStamp(time_stamp);
     }
  }
catch(Exception e)
{
  System.out.println(e);
}
 return projectObj;
}

/************************update project**************************/

public String updateProject(Project project)
{
try
{
updateProjectStmt.setObject(1,project.getProjectName());
     updateProjectStmt.setObject(2,project.getDescription());
    updateProjectStmt.setObject(3,project.getIsAlive());
    updateProjectStmt.setObject(4,project.getTimeStamp());
 updateProjectStmt.setObject(5,project.getProjectId());
    status=updateProjectStmt.executeUpdate();
}
catch(Exception e)
    {
    System.out.println(e);
    }    
         
    if(status==1)
    return "successfully updated";
    else
   return "failed";
}

/****************************delete Project*************************/
public String deleteProject(String project_id)
{
   try
{
   deleteProjectStmt.setObject(1,project_id);
  status = deleteProjectStmt.executeUpdate();
}
catch(Exception e)
    {
    System.out.println(e);
    }    
         
    if(status==1)
    return "successfully deleted";
    else
   return "failed";
}

/***************************projectAssignment*************************************/

public String storeProjectAssignment(ProjectAssignment projectAssignmentObj) 
   {
    try
   {
   projectObj=projectAssignmentObj.getProjectObj();  
  insertAssgnStmt.setObject(1,projectObj.getProjectId());
  
   insertAssgnStmt.setObject(2,projectObj.getProjectName());

   userObj=projectAssignmentObj.getUserObj(); 
   insertAssgnStmt.setObject(3,userObj.getEmpNo()); 
  insertAssgnStmt.setObject(4,projectAssignmentObj.getEmpName());         

    insertAssgnStmt.setObject(5,projectAssignmentObj.getPlanstartDate());
    insertAssgnStmt.setObject(6,projectAssignmentObj.getPlanendDate());   
    insertAssgnStmt.setObject(7,projectAssignmentObj.getTimeStamp());
    insertAssgnStmt.setObject(8,projectAssignmentObj.getIsAlive());
     status= insertAssgnStmt.executeUpdate();
    }
    catch(Exception e)
    {
    System.out.println(e);
    }    
         
    if(status==1)
    return "successfully inserted";
    else
   return "failed";
   
   }



/*******************************view Assgn project***************************************/

public ProjectAssignment getProjectAssignment(String project_id) 
   {
try
    {   
      
    viewAssgnStmt.setString(1,project_id);
    ResultSet rs = viewAssgnStmt.executeQuery();
    while(rs.next())
    {
   project_id =rs.getString(1);
 String project_name = rs.getString(2);
 String emp_no = rs.getString(3);
 String emp_name = rs.getString(4); 
Date planstart_date=rs.getDate(5);
Date planend_date=rs.getDate(6);
   java.sql.Date time_stamp=rs.getDate(7);
System.out.println("time_stamp"+time_stamp);
int is_alive=rs.getInt(8);


   projectObj.setProjectId(project_id);
  projectObj.setProjectName(project_name);
  projectAssignmentObj.setProjectObj(projectObj);
 
   userObj.setEmpNo(emp_no);
   projectAssignmentObj.setUserObj(userObj); 
    projectAssignmentObj.setEmpName(emp_name);

      projectAssignmentObj.setPlanstartDate(planstart_date);
  projectAssignmentObj.setPlanendDate(planend_date);
  projectAssignmentObj.setTimeStamp(time_stamp);
projectAssignmentObj.setIsAlive(is_alive);

}  
} 
catch(Exception e)
{
  System.out.println(e);
}
 return projectAssignmentObj;
}
/********************************updateAssignmentProject***************************/
public String updateProjectAssignment(ProjectAssignment projectAssignmentObj)
{
try
{
projectObj=projectAssignmentObj.getProjectObj(); 
    updateAssgnStmt.setObject(1,projectObj.getProjectName());

   userObj=projectAssignmentObj.getUserObj(); 
  updateAssgnStmt.setObject(2,userObj.getEmpNo()); 
updateAssgnStmt.setObject(3,projectAssignmentObj.getEmpName());         
   updateAssgnStmt.setObject(4,projectAssignmentObj.getPlanstartDate());
   updateAssgnStmt.setObject(5,projectAssignmentObj.getPlanendDate());   
    updateAssgnStmt.setObject(6,projectAssignmentObj.getTimeStamp());
   updateAssgnStmt.setObject(7,projectAssignmentObj.getIsAlive());
   
updateAssgnStmt.setObject(8,projectObj.getProjectId());


    status=updateAssgnStmt.executeUpdate();
}
catch(Exception e)
    {
    System.out.println(e);
    }    
         
    if(status==1)
    return "successfully updated";
    else
   return "failed";
    }




/******************************phase Creation*************************/ 

    public String storeTestPhase( TestPhase testPhaseObj) throws Exception 
   {
            pstmt= manager.getConnection().prepareStatement(insertTestPhase); 
            pstmt.setObject(1,testPhaseObj.getPhaseId());
            pstmt.setObject(2,testPhaseObj.getPhaseName());
            projectObj = testPhaseObj.getProjectObj();
            pstmt.setObject(3,projectObj.getProjectId());
            pstmt.setString(4,testPhaseObj.getDescription());
            pstmt.setInt(5,testPhaseObj.getIsAlive());
            pstmt.setString(6,testPhaseObj.getTimeStamp());
            String id=testPhaseObj.getPhaseId();
            String name=testPhaseObj.getPhaseName();
            String projectId=projectObj.getProjectId();
           int isAlive=testPhaseObj.getIsAlive();
                System.out.println(id);
                 System.out.println(isAlive);
            if(id==""&name==""&projectId=="")
             {
             return "Provide proper input fields";
              }
               else
            status = pstmt.executeUpdate();
               if(status==1)
              return "Test phase created successfully";
            else
                 return "Provide proper input fields";
    }
/************************************Phase Updation*******************************/ 

     public String updateTestPhase(TestPhase testPhaseObj) throws Exception
     {    
             pstmt = manager.getConnection().prepareStatement(updateTestPhase);          
           pstmt.setObject(1,testPhaseObj.getPhaseName());
            projectObj = testPhaseObj.getProjectObj();
            pstmt.setObject(2,projectObj.getProjectId());
            pstmt.setString(3,testPhaseObj.getDescription());
            pstmt.setInt(4,testPhaseObj.getIsAlive());
            pstmt.setString(5,testPhaseObj.getTimeStamp());
           pstmt.setObject(6,testPhaseObj.getPhaseId());
            status = pstmt.executeUpdate();
             if(status == 1)
                   return "Test phase updated successfully";
           else 
                return "failed to update fields";           
     }
/************************************Phase View*******************************/ 
   
 public TestPhase getTestPhase(String phase_id)   throws Exception
    {
             pstmt = manager.getConnection().prepareStatement(viewTestPhase); 
           pstmt.setObject(1,phase_id);
           ResultSet rs = pstmt.executeQuery();
           while(rs.next())
            {
           phase_id = rs.getString(1);
           String phase_name = rs.getString(2);
           String project_id = rs.getString(3);
           String description = rs.getString(4);
           int is_alive = rs.getInt(5);
           String time_stamp = rs.getString(6);
           testPhaseObj.setPhaseId(phase_id);
           testPhaseObj.setPhaseName(phase_name);
           projectObj.setProjectId(project_id);
           testPhaseObj.setProjectObj(projectObj);
           testPhaseObj.setDescription(description);
           testPhaseObj.setIsAlive(is_alive);
           testPhaseObj.setTimeStamp(time_stamp);
           }
             return testPhaseObj;         
    }
/************************************Phase Deletion*******************************/ 
     public String deleteTestPhase(String phase_id) throws Exception
     {
              pstmt = manager.getConnection().prepareStatement(deleteTestPhase); 
            pstmt.setObject(1,phase_id);
          status = pstmt.executeUpdate();
            if(status == 1)
             return "phase successfully deleted";
         else
             return "phase deletion failed";
     }
/************************************Activity Insertion*******************************/ 
    public String storeTestActivity(Activity activityObj)  throws Exception
    {
             pstmt =  manager.getConnection().prepareStatement(insertActivity);
	System.out.println("In store Test Activity");
             pstmt.setObject(1,activityObj.getActivityId());
             testPhaseObj = activityObj.getTestPhaseObj();
             pstmt.setObject(2,testPhaseObj.getPhaseId());//own
             pstmt.setObject(3,activityObj.getActivityName());
             pstmt.setObject(4,activityObj.getActivityDescription());
             pstmt.setObject(5,activityObj.getActivityType());
             pstmt.setObject(6,activityObj.getStartDate());
             pstmt.setObject(7,activityObj.getEndDate());
             pstmt.setObject(8,activityObj.getActivityEffort());
             pstmt.setObject(9,activityObj.getStatus());
             userObj = activityObj.getUserObj();
             pstmt.setObject(10,userObj.getEmpNo());
             pstmt.setDate(11,activityObj.getTimeStamp());
             status =   pstmt.executeUpdate();
             if(status == 1)
             return "Test Activity created successfully";
              else
             return "Provide proper input fields";
    }
/************************************Activity getting*******************************/
 public Activity getTestActivity(String activity_id)  throws Exception
    {
        pstmt = manager.getConnection().prepareStatement(viewActivity);
        pstmt.setObject(1,activity_id);
           ResultSet rs = pstmt.executeQuery();
           while(rs.next())
            {
           activity_id = rs.getString(1);
           String phase_id = rs.getString(2);
           String activity_name = rs.getString(3);
           String activity_description = rs.getString(4);
           int activity_type = rs.getInt(5);
           Date start_date = rs.getDate(6);
           Date end_date = rs.getDate(7);
           int activity_effort = rs.getInt(8);
           int status = rs.getInt(9);
           String emp_no = rs.getString(10);
           java.sql.Date time_stamp = rs.getDate(11);
	System.out.println("DBstorage time stamp :"+time_stamp);
           activityObj.setActivityId(activity_id);
           testPhaseObj.setPhaseId(phase_id);
           activityObj.setTestPhaseObj(testPhaseObj);
           activityObj.setActivityName(activity_name);
           activityObj.setActivityDescription(activity_description);
           activityObj.setActivityType(activity_type);
           activityObj.setStartDate(start_date);           
           activityObj.setEndDate(end_date);
           activityObj.setActivityEffort(activity_effort);           
           activityObj.setStatus(status);
           userObj.setEmpNo(emp_no);
           activityObj.setUserObj(userObj);
           activityObj.setTimeStamp(time_stamp);
           }
            
             return activityObj;         
    }


/************************************Activity updation*******************************/

   public String updateTestActivity(Activity activityObj)  throws Exception
    {
            pstmt = manager.getConnection().prepareStatement(updateActivity);      
            testPhaseObj = activityObj.getTestPhaseObj();
            pstmt.setObject(1,testPhaseObj.getPhaseId());
            pstmt.setObject(2,activityObj.getActivityName());
           pstmt.setObject(3,activityObj.getActivityDescription());
           pstmt.setObject(4,activityObj.getActivityType());
            pstmt.setObject(5,activityObj.getStartDate());
            pstmt.setObject(6,activityObj.getEndDate());
            pstmt.setObject(7,activityObj.getActivityEffort());
            pstmt.setObject(8,activityObj.getStatus());
             userObj = activityObj.getUserObj();
            pstmt.setObject(9,userObj.getEmpNo());
            pstmt.setDate(10,activityObj.getTimeStamp());
            pstmt.setObject(11,activityObj.getActivityId());
            status = pstmt.executeUpdate();
              if(status == 1)
           return "Test Activity updated successfully"; 
        else
           return "Provide proper input fields";
    }
/************************************Activity Deletion*******************************/ 
     public String deleteTestActivity(String activity_id)   throws Exception
     {
          pstmt= manager.getConnection().prepareStatement(deleteActivity);  
          pstmt.setObject(1,activity_id);
          status = pstmt.executeUpdate();
            if(status == 1)
             return "Activity successfully deleted";
         else
             return "Activity deletion failed";
     }
/************************************Get Activity Status *******************************/ 
    public int getActivityStatus(String activity_id) throws Exception
    {
        try{
         pstmt = manager.getConnection().prepareStatement(getActivityStatus); 
         pstmt.setObject(1, activity_id);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
        {
             status = rs.getInt(status);
        }
         }catch(Exception e){System.out.println("db"+e);}
        return status;
     }
/************************************Close Activity *******************************/ 
    public String closeTestActivity(String activity_id) throws Exception
    {
         try{
         pstmt = manager.getConnection().prepareStatement(closeActivity); 
         pstmt.setObject(1, activity_id);
         status = pstmt.executeUpdate();
          }catch(Exception e){System.out.println("db"+e);}
           if(status == 1)
             return "Activity successfully closed";
         else
             return " Failed to close Activity";
    }
/*--------------------------------------------- Activity Assignment ----------------------------------------*/
    public String storeActivityAssignment(ActivityUser activityUserObj) throws Exception
    {
         pstmt = manager.getConnection().prepareStatement(assignActivity); 
         activityObj = activityUserObj.getActivityObj();
         userObj = activityUserObj.getUserObj();
          pstmt.setObject(1,activityObj.getActivityId());
         pstmt.setObject(2,userObj.getEmpNo());
          pstmt.setObject(3,activityUserObj.getActivityEffort());
          pstmt.setObject(4,activityUserObj.getStartDate());
          pstmt.setObject(5,activityUserObj.getEndDate());
          pstmt.setObject(6,activityUserObj.getStatus());
          pstmt.setObject(7,activityUserObj.getPercentageCompleted());
          pstmt.setObject(8,activityUserObj.getTimeStamp());
         status =  pstmt.executeUpdate();
          if(status == 1)
             return "Activity Assigned successfully ";
         else
             return "Activity assignment failed";
    }

 /*--------------------------------------------- get Activity Assignment ----------------------------------------*/
    public ActivityUser getActivityAssignment(String activity_id) throws Exception
    {
        
           pstmt= manager.getConnection().prepareStatement(getAssign); 
           
           pstmt.setObject(1,activity_id);
           rs = pstmt.executeQuery();
           while(rs.next())
           {
             activity_id = rs.getString(1);
             String emp_no = rs.getString(2);
             int activity_effort = rs.getInt(3);
             Date start_date = rs.getDate(4);
             Date end_date = rs.getDate(5);
             int status = rs.getInt(6);
             int pc = rs.getInt(7);
             String ts = rs.getString(8);
       
             activityObj.setActivityId(activity_id);
             activityUserObj.setActivityObj(activityObj);
            
             userObj.setEmpNo(emp_no);
             activityUserObj.setUserObj(userObj);
             activityUserObj.setActivityEffort(activity_effort);
             activityUserObj.setStartDate(start_date);
             activityUserObj.setEndDate(end_date);
             activityUserObj.setStatus(status);
             activityUserObj.setPercentageCompleted(pc);
             activityUserObj.setTimeStamp(ts);
             }
              return activityUserObj;
     }
   
 /*--------------------------------------------- update Activity Assignment ----------------------------------------*/
    public String updateActivityAssignment(ActivityUser activityUserObj)  throws Exception
    {
       pstmt = manager.getConnection().prepareStatement(updateAssign); 
         activityObj = activityUserObj.getActivityObj();
         userObj = activityUserObj.getUserObj();
        
         pstmt.setObject(1,userObj.getEmpNo());
         pstmt.setObject(2,activityUserObj.getActivityEffort());
         pstmt.setObject(3,activityUserObj.getStartDate());
        pstmt.setObject(4,activityUserObj.getEndDate());
        pstmt.setObject(5,activityUserObj.getStatus());
         pstmt.setObject(6,activityUserObj.getPercentageCompleted());
         pstmt.setObject(7,activityUserObj.getTimeStamp());
         pstmt.setObject(8,activityObj.getActivityId());
         status = pstmt.executeUpdate(); 
         if(status == 1)
             return "Activity Assignment Updated successfully ";
         else
             return "Activity assignment Updation fail";
    }

/* =======================CreateTestcase==========================*/
    
      public String storeTestCase(TestCase testCaseObj) throws Exception
      {
                pstmt = manager.getConnection().prepareStatement(createTestCase); 
                pstmt.setObject(1,testCaseObj.getTestCaseId());
                pstmt.setObject(2,testCaseObj.getTestCaseDescription());
               pstmt.setObject(3,testCaseObj.getTestCasePhase());
              pstmt.setObject(4,(testCaseObj.getProjectObj()).getProjectId());
               pstmt.setObject(5,(testCaseObj.getUserObj()).getUserId());
               pstmt.setObject(6,(testCaseObj.getActivityObj()).getActivityId());
               pstmt.setObject(7,testCaseObj.getExpectedBehaviour()); 

              status =pstmt.executeUpdate();
              if(status==1)
                     return "TestCase creation Successfully"  ;
              else
                  return "TestCase creation is Failed"  ;
      }       
  /*=====================ViewTestCase=======================*/
        
         public TestCase getTestCase(String testcase_id) throws Exception
         {    
	System.out.println("DBStorage :"+testcase_id);
                  pstmt= manager.getConnection().prepareStatement(getTestCase); 
                  pstmt.setString(1,testcase_id);
                  ResultSet rs=pstmt.executeQuery();
                  while(rs.next())
                 {
                           testcase_id=rs.getString(1);
                            String testcase_description=rs.getString(2);
                            String testcase_phase=rs.getString(3);
                            String project_id=rs.getString(4);
                            projectObj.setProjectId(project_id);
                            String user_id=rs.getString(5); 
                            userObj.setUserId(user_id);
                            String activity_id=rs.getString(6);
                            activityObj.setActivityId(activity_id);
                            String expected_behaviour=rs.getString(7);
                             
	testCaseObj.setTestCaseId(testcase_id); 
                   testCaseObj.setTestCaseDescription(testcase_description);
                   testCaseObj.setTestCasePhase(testcase_phase);
                   testCaseObj.setProjectObj(projectObj);
                   testCaseObj.setUserObj(userObj);
                   testCaseObj.setActivityObj(activityObj);
                   testCaseObj.setExpectedBehaviour(expected_behaviour);     
        }
                  return testCaseObj;
   }  
/*===================UpdateTestCase=============================*/

       public String updateTestCase(TestCase testCaseObj) throws Exception
      {
                
       
                pstmt = manager.getConnection().prepareStatement(updateTestCase);            
 
                pstmt.setObject(1,testCaseObj.getExpectedBehaviour());         
                pstmt.setObject(2,testCaseObj.getTestCaseId());
    
                status =pstmt.executeUpdate();

                if(status == 1)
                          return "Test Case updated successfully";
                else
                          return "failed to update fields";           
      }

/*==================Delete testCase==================================*/
      
        public String deleteTestCase(String testcase_id) throws Exception
      {            
            pstmt=manager.getConnection().prepareStatement(deleteTestCase);   
               pstmt.setObject(1,testcase_id);
            status=pstmt.executeUpdate();
                if(status==1)
                      return "Testcase Deleted successfully";          
             else
                   return "Testcase cannot be deleted";      
         }
//======================Add Execution Details======================//
  
   public String addTestCaseExecutionDetails(TestCase testCaseObj)throws Exception
    {
               pstmt=manager.getConnection().prepareStatement(addExeDetails);   
               pstmt.setObject(1,(testCaseObj.getActivityObj()).getActivityId());
               pstmt.setObject(2,testCaseObj.getTestCaseId());
               pstmt.setObject(3,(testCaseObj.getUserObj()).getUserId());
               pstmt.setObject(4,testCaseObj.getActualDate());
               pstmt.setObject(5,testCaseObj.getTestCaseStatus());
               pstmt.setObject(6,testCaseObj.getComments());
               pstmt.setObject(7,testCaseObj.getActualBehaviour()); 
               status =pstmt.executeUpdate();
               if(status==1)
                              return  " Create TestCase execution Details Successfully"  ;
               else
                     return " Creation is failed  for TestCase execution Details"  ;
       }
/*=====================ViewTestCaseExecutionDetails=================*/
     
          public TestCase  getTestCaseExecutionDetails(String testcase_id) throws Exception 
         {         
              pstmt=manager.getConnection().prepareStatement(getExeDetails);   
               pstmt.setString(1,testcase_id);      
              ResultSet rs=pstmt.executeQuery();
              while(rs.next())
              {
                String activity_id=rs.getString(1);
                activityObj.setActivityId(activity_id);

                 String testcaseId=rs.getString(2);

                  String user_id=rs.getString(3); 
                  userObj.setUserId(user_id);
              
                Date actual_date=rs.getDate(4);    
                
                String testcase_status=rs.getString(5);

                String comments=rs.getString(6);
                
                String actual_behaviour=rs.getString(7);
                
                   testCaseObj.setActivityObj(activityObj);
 	testCaseObj.setTestCaseId(testcase_id); 
                   testCaseObj.setUserObj(userObj);
                   testCaseObj.setActualDate(actual_date);
                   testCaseObj.setTestCaseStatus(testcase_status);
                   testCaseObj.setComments(comments);
                   testCaseObj.setActualBehaviour(actual_behaviour);     
       } 
           return  testCaseObj;      
  }
/*========================UpdateTestCaseExecutionDetails=============*/
           
          public String updateTestCaseExecutionDetails(TestCase testCaseObj) throws Exception
          {
                 pstmt = manager.getConnection().prepareStatement(updateExeDetails);            
                pstmt.setObject(1,testCaseObj.getTestCaseStatus());      
                pstmt.setObject(2,testCaseObj.getComments());
                pstmt.setObject(3,testCaseObj.getActualBehaviour());
	pstmt.setObject(4,testCaseObj.getActualDate());
                pstmt.setObject(5,testCaseObj.getTestCaseId());   
                status =pstmt.executeUpdate();
                 if(status != 0)
                          return "Test Case Execution updated successfully";
                else
                          return "failed to update Execution Details";           
           }
/*===========================AddTestActivityEffort=================*/
 
     public String addTestActivityEffort(Effort effortObj) throws Exception
    {                         
              pstmt=manager.getConnection().prepareStatement(addEffort);   
              pstmt.setObject(1,(effortObj.getActivityObj()).getActivityId());
              pstmt.setObject(2,(effortObj.getUserObj()).getEmpNo());
              pstmt.setObject(3,effortObj.getEffortDate());
              pstmt.setObject(4,effortObj.getStartDate());
              pstmt.setObject(5,effortObj.getEndDate());
              pstmt.setObject(6,effortObj.getEffort	());
              pstmt.setObject(7,effortObj.getEffortDescription()); 
              pstmt.setObject(8,effortObj.getEffortTimeStamp());
                 status =pstmt.executeUpdate();
               if(status==1)
                   return " Adding TestActivityEffort Successful";
                else
                     return " Adding TestActivityEffort is Failed " ;
       }
/*====================ViewTestActivityEffort=====================*/
  
         public Effort getTestActivityEffort(String activity_id) throws Exception
         {
               pstmt=manager.getConnection().prepareStatement(getEffort);   
                          pstmt.setString(1,activity_id);      
              ResultSet rs=pstmt.executeQuery();
              while(rs.next())
              {
                String activity_id1=rs.getString(1);
                activityObj.setActivityId(activity_id1);
               String empNo=rs.getString(2); 
                userObj.setEmpNo(empNo);
                Date effortDate=rs.getDate(3);
                Date startDate=rs.getDate(4);
                 Date endDate=rs.getDate(5);
                int effort=rs.getInt(6);
                String effortDescription=rs.getString(7);   
                String  effortTimeStamp=rs.getString(8);

                   effortObj.setActivityObj(activityObj);
                   effortObj.setUserObj(userObj);
                   effortObj.setEffortDate(effortDate);
                   effortObj.setStartDate(startDate);
                   effortObj.setEndDate(endDate);
                   effortObj.setEffort(effort);
                   effortObj.setEffortDescription(effortDescription);
                   effortObj.setEffortTimeStamp(effortTimeStamp);
               }
           return  effortObj;      
     }

/*=======================UpdateTestActivityEffort===============*/
  
          public String updateTestActivityEffort(Effort effortObj)throws Exception
          {
                 pstmt = manager.getConnection().prepareStatement(updateEffort);            
                 pstmt.setObject(1,effortObj.getEffortDescription());  
                pstmt.setObject(2,effortObj.getActivityObj().getActivityId());   
                status =pstmt.executeUpdate();
                  if(status != 0)
                          return "Test Activity Effort updated successfully";
                else
                          return "failed to update Effort";           
            }

/************************************getActivityEffort*******************************/ 
    public int getActivityEffort(String activity_id) throws Exception
    {
         System.out.println("DBStorage");
        System.out.println(activity_id);
               pstmt=manager.getConnection().prepareStatement(activityEffort);   
              pstmt.setString(1,activity_id);      
     ResultSet rs=pstmt.executeQuery();
     int activityEffort=0;  
     while(rs.next())
     { 
     activityEffort += rs.getInt("effort"); 
     }
       System.out.println(activityEffort);
     return activityEffort;
    }


/************************************getTesterEffort*******************************/ 
public int getTesterEffort(String emp_no)throws Exception
  {   
   pstmt = manager.getConnection().prepareStatement(testerEffort);
  
  pstmt.setString(1,emp_no);
    
      ResultSet rs=pstmt.executeQuery();
       int testerEffort=0;
     while(rs.next())
     {
       testerEffort+=rs.getInt("effort");
      }
     return testerEffort;
   }
/***********************getTesterTestCases***************************/
public TestCase[] getTesterTestcases(String user_id) throws Exception                             
{
      

     pstmt = manager.getConnection().prepareStatement(countUserQuery);
        pstmt.setString(1,user_id);
        ResultSet rs1 = pstmt.executeQuery();
       rs1.next();
       int length = Integer.parseInt(rs1.getString(1));


      pstmt = manager.getConnection().prepareStatement(testerTestcases);
     // int length = 100;
       pstmt.setString(1,user_id);
       ResultSet rs = pstmt.executeQuery();
       TestCase[]  testcase = new TestCase[length];
     int i=0;
      while(rs.next())
     {
       
       TestCase tc = new TestCase();
        tc. setTestCaseId(rs.getString(1));
        tc. setTestCaseDescription(rs.getString(2));
        tc.setTestCasePhase(rs.getString(3));
        projectObj.setProjectId(rs.getString(4));
        tc.setProjectObj(projectObj);	
        userObj.setEmpNo(rs.getString(5));	
        tc.setUserObj(userObj);
        activityObj.setActivityId(rs.getString(6));
        tc.setActivityObj(activityObj);
        tc.setExpectedBehaviour(rs.getString(7));
        testcase[i] = tc;
        i+=1;  
  }

return testcase;
}
    /*****************************************getActivityTestCases***************************/
   public TestCase[] getActivityTestcases(String activityId) throws Exception   
   {
       
       pstmt = manager.getConnection().prepareStatement(countQuery);
        pstmt.setString(1,activityId);
        ResultSet rs1 = pstmt.executeQuery();
       rs1.next();
       int length = Integer.parseInt(rs1.getString(1));
       System.out.println("DBStorage:"+activityId);
       pstmt = manager.getConnection().prepareStatement(acttestcase);
       pstmt.setString(1,activityId);
       ResultSet rs = pstmt.executeQuery();
      /*if(rs==null)
       {
      System.out.println("Given ActivityId not matched");
        }
     else
      {*/
       TestCase[]  testcase = new TestCase[length];
     int i=0;
      while(rs.next())
     {
       TestCase tc = new TestCase();
        tc. setTestCaseId(rs.getString(1));
        tc. setTestCaseDescription(rs.getString(2));
        tc.setTestCasePhase(rs.getString(3));
        projectObj.setProjectId(rs.getString(4));
        tc.setProjectObj(projectObj);	
        userObj.setUserId(rs.getString(5));	
        tc.setUserObj(userObj);
        activityObj.setActivityId(rs.getString(6));
        tc.setActivityObj(activityObj);     
        tc.setExpectedBehaviour(rs.getString(7));
        testcase[i] = tc;
        i+=1;   
     }
     return testcase;
   }
 /*****************************************getTesterExecutionTestcases***************************/
      public TestCase[] getTesterExecutionTestcases(String userId) throws Exception
      {            System.out.println("line3");
                    pstmt = manager.getConnection().prepareStatement(ExecuTestcases1); 
	 System.out.println("line4");
                   pstmt.setString(1,userId);
                  System.out.println("line5");
      	ResultSet rs1= pstmt.executeQuery();
                      System.out.println("line1");   
           	//int length=-1;
	rs1.next();
	System.out.println("line2");
                   int length=rs1.getInt(1);
	System.out.println("No. of  executed testcases: " + length);
	 TestCase[] testcase=new TestCase[length];
	pstmt = manager.getConnection().prepareStatement(ExecuTestcases); 
                  pstmt.setString(1,userId);
	ResultSet rs=pstmt.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();
	
        
      
             activityObj.setActivityId(rs.getString(1));
             tc.setActivityObj(activityObj);
              tc.setTestCaseId(rs.getString(2));
              userObj.setUserId(rs.getString(3));	
              tc.setUserObj(userObj);
             tc.setActualDate(rs.getDate(4));
             tc.setTestCaseStatus(rs.getString(5));
             tc.setComments(rs.getString(6));
             tc.setActualBehaviour(rs.getString(7));
             testcase[i]=tc;
            i+=1;
            } 
     return testcase;
          }
   
 /****************************getActivityExecutuionTestCases******************************************/
	


  public TestCase[] getActivityExecutionTestcases(String activityId) throws Exception
      {            

                   System.out.println(activityId);
                    pstmt = manager.getConnection().prepareStatement(activityExecuTestcases1);
                   	pstmt.setString(1,activityId);
                   ResultSet rs1= pstmt.executeQuery();
                      System.out.println("line1");   
           	//int length=-1;
	rs1.next();
	System.out.println("line2");
                   int length=rs1.getInt(1);
                    System.out.println(length);
                   
                   
	 TestCase[] testcase=new TestCase[length];
                    pstmt = manager.getConnection().prepareStatement(activityExecuTestcases);
	pstmt.setString(1,activityId);
	ResultSet rs=pstmt.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();
              activityObj.setActivityId(rs.getString(1));
              tc.setActivityObj(activityObj);
              tc.setTestCaseId(rs.getString(2));
             userObj.setUserId(rs.getString(3));
             tc.setUserObj(userObj);
             tc.setActualDate(rs.getDate(4));
             tc.setTestCaseStatus(rs.getString(5));
             tc.setComments(rs.getString(6));
             tc.setActualBehaviour(rs.getString(7));
             testcase[i]=tc;
            i+=1;
            } 
     return testcase;
          }


 /*****************************************getTesterNonExecutionTestcases***************************/
     public TestCase[] getTesterNonExecutionTestcases(String userId) throws Exception
      {
	nonExeTestcases1.setString(1,userId);
      	ResultSet rs1=nonExeTestcases1.executeQuery();
                       //nonExecuTestcases1  
           	int length=-1;
	rs1.next();
	length=rs1.getInt(1);
	System.out.println("No. of  nonexecuted testcases: " + length);
	 TestCase[] testcase=new TestCase[length];
	nonExeTestcases.setString(1,userId);
	ResultSet rs=nonExeTestcases.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();
              activityObj.setActivityId(rs.getString(1));
              tc.setActivityObj(activityObj);
              tc.setTestCaseId(rs.getString(2));
              userObj.setUserId(rs.getString(3));
              tc.setUserObj(userObj);
           //tc.setTestcaseActualDate(rs.getString(4));
          // tc.setTestcaseStatus(rs.getString(5));
          // tc.setComments(rs.getString(6));
          //  tc.setActualBehavior(rs.getString(7));
             testcase[i]=tc;
            i+=1;
            } 
     return testcase;
 
        }


/******************************************getFailedTestcaseOfTester*************************************/



   public TestCase[] getTesterFailedTestcases(String userId) throws Exception
      {
	failedTestcases1.setString(1,userId);
      	ResultSet rs1=failedTestcases1.executeQuery();
                         
           	int length=10;
	rs1.next();
	length=rs1.getInt(1);
	System.out.println("No. of  Failedtestcases Of tester: " + length);
	 TestCase[] testcase=new TestCase[length];
	failedTestcases.setString(1,userId);
	ResultSet rs=failedTestcases.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();
              activityObj.setActivityId(rs.getString(1));
              tc.setActivityObj(activityObj);
              tc.setTestCaseId(rs.getString(2));
              userObj.setUserId(rs.getString(3));
              tc.setUserObj(userObj);
          tc.setActualDate(rs.getDate(4));
          tc.setTestCaseStatus(rs.getString(5));
          tc.setComments(rs.getString(6));
          tc.setActualBehaviour(rs.getString(7));
             testcase[i]=tc;
            i+=1;
            } 
     return testcase;
 
       } 
/******************************************getActivityFailedTestcaseOfTester*************************************/
    public TestCase[] getActivityFailedTestcases(String activityId) throws Exception
      {
	failedActivityTestcases1.setString(1,activityId);
      	ResultSet rs1=failedActivityTestcases1.executeQuery();
                         
           	int length=0;
	rs1.next();
	length=rs1.getInt(1);
	System.out.println("No. of  Failedtestcases Of Activity : " + length);
	 TestCase[] testcase=new TestCase[length];
	failedActivityTestcases.setString(1,activityId);
	ResultSet rs=failedActivityTestcases.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();
              activityObj.setActivityId(rs.getString(1));
              tc.setActivityObj(activityObj);
              tc.setTestCaseId(rs.getString(2));
            userObj.setUserId(rs.getString(3));	
            tc.setUserObj(userObj);     
            tc.setActualDate(rs.getDate(4));
             tc.setTestCaseStatus(rs.getString(5));
             tc.setComments(rs.getString(6));
             tc.setActualBehaviour(rs.getString(7));
             testcase[i]=tc;
             i+=1;
            } 
     return testcase;
 
       }

/******************************************getPassedTestcaseOfTester*************************************/



   public TestCase[] getTesterPassedTestcases(String userId) throws Exception
      {
	passedTestcases1.setString(1,userId);
      	ResultSet rs1=passedTestcases1.executeQuery();
                         
           	int length=0;
	rs1.next();
	length=rs1.getInt(1);
	System.out.println("No. of  Passedtestcases Of tester: " + length);
	 TestCase[] testcase=new TestCase[length];
	passedTestcases.setString(1,userId);
	ResultSet rs=passedTestcases.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();
              activityObj.setActivityId(rs.getString(1));
              tc.setActivityObj(activityObj);
              tc.setTestCaseId(rs.getString(2));
             userObj.setUserId(rs.getString(3));	
            tc.setUserObj(userObj);
            tc.setActualDate(rs.getDate(4));
            tc.setTestCaseStatus(rs.getString(5));
            tc.setComments(rs.getString(6));
            tc.setActualBehaviour(rs.getString(7));
             testcase[i]=tc;
            i+=1;
            } 
     return testcase;
 
       } 
/******************************************getActivityPassedTestcase*************************************/
    public TestCase[] getActivityPassedTestcases(String activityId) throws Exception
      {
	passedActivityTestcases1.setString(1,activityId);
      	ResultSet rs1=passedActivityTestcases1.executeQuery();
                         
           	int length=0;
	rs1.next();
	length=rs1.getInt(1);
	System.out.println("No. of  Passed testcases Of Activity : " + length);
	 TestCase[] testcase=new TestCase[length];
	passedActivityTestcases.setString(1,activityId);
	ResultSet rs=passedActivityTestcases.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();

   
        
             activityObj.setActivityId(rs.getString(1));
             tc.setActivityObj(activityObj);     
        
              
             tc.setTestCaseId(rs.getString(2));
             userObj.setUserId(rs.getString(3));	
             tc.setUserObj(userObj);
             tc.setActualDate(rs.getDate(4));
             tc.setTestCaseStatus(rs.getString(5));
             tc.setComments(rs.getString(6));
             tc.setActualBehaviour(rs.getString(7));
             testcase[i]=tc;
             i+=1;
            } 
     return testcase;
 
       }

/************************************getProjectEffort*******************************/ 
public int getProjectEffort(String projectId)throws Exception
  {
      pstmt = manager.getConnection().prepareStatement(projectEffort);

     pstmt.setString(1,projectId);

      ResultSet rs=pstmt.executeQuery();
       
      rs.next();
      int effort=rs.getInt("sum(effort)");
      System.out.println(effort);
      return effort;
   }

/************************************gettestPhaseEffort*******************************/ 

public int getTestPhaseEffort(String phaseId)throws Exception
  {
 pstmt = manager.getConnection().prepareStatement(phaseEffort);

     pstmt.setString(1,phaseId);

      ResultSet rs=pstmt.executeQuery();
       
      rs.next();
      int effort=rs.getInt("sum(effort)");
      
      return effort;
   }
/*************************************getActivityNonExecutionTestcases********************************/

       public TestCase[] getActivityNonExecutionTestcases(String activityId) throws Exception
      {
	activityNonExeTestcases1.setString(1,activityId);
      	ResultSet rs1=activityNonExeTestcases1.executeQuery();
                         
           	int length=-1;
	rs1.next();
	length=rs1.getInt(1);
	System.out.println("No. of Non-executed  testcases of Activity are:" + length);
	 TestCase[] testcase=new TestCase[length];
	activityNonExeTestcases.setString(1,activityId);
	ResultSet rs=activityNonExeTestcases.executeQuery();
	 int i=0;
              while(rs.next())
             {
              TestCase tc=new TestCase();

                 activityObj.setActivityId(rs.getString(1));	
                 tc.setActivityObj(activityObj);
                 tc.setTestCaseId(rs.getString(2));
                 userObj.setUserId(rs.getString(3));	
                 tc.setUserObj(userObj);
              //tc.setTestcaseActualDate(rs.getString(4));
             //tc.setTestcaseStatus(rs.getString(5));
             //tc.setComments(rs.getString(6));
             //tc.setActualBehavior(rs.getString(7));
             testcase[i]=tc;
            i+=1;
            } 
     return testcase;
          }



}
