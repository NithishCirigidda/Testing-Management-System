public class TestActivityHandler 
{
    private DBStorage dBStorage;
    private TestActivityLifeCycleManagementHandler talcm = null;
    private Activity activityObj;
   
   public TestActivityHandler()throws Exception
   {
        
        dBStorage = new DBStorage();
        activityObj = new Activity();
        talcm = new TestActivityLifeCycleManagementHandler();
   }  

    public String createTestActivity(Activity activityObj) throws Exception
    {
        return dBStorage.storeTestActivity(activityObj);
    }

    public Activity getTestActivity(String activity_id) throws Exception
    {
         return dBStorage.getTestActivity(activity_id);

    }

    public String updateTestActivity(Activity activityObj) throws Exception
    {
         return dBStorage.updateTestActivity(activityObj);
    }

    public String deleteTestActivity(String activity_id) throws Exception
    {
         return dBStorage.deleteTestActivity(activity_id);		
    }
    public String closeTestActivity(String activity_id) throws Exception
    {
           return  talcm.closeTestActivity(activity_id);
    } 

}