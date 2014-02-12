public class TestActivityAssignmentHandler 
{

      private ActivityUser activityUserObj =null;
      private DBStorage dBStorage =null;

      public  TestActivityAssignmentHandler()throws Exception
      {
           activityUserObj = new ActivityUser();  
           dBStorage = new DBStorage();
      }

      public String assignTestActivity(ActivityUser activityUserObj) throws Exception
      {
           return dBStorage.storeActivityAssignment( activityUserObj);
      }
      public ActivityUser getTestActivityAssignment(String activity_id ) throws Exception
      {
           return dBStorage.getActivityAssignment(activity_id);
       }
       public String updateTestActivityAssignment(ActivityUser activityUserObj) throws Exception
      {
           return dBStorage.updateActivityAssignment(activityUserObj);
       }

}