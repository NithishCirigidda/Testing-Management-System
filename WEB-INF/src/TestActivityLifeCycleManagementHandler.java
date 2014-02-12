public class TestActivityLifeCycleManagementHandler{

    private Activity activity = null;
    DBStorage dBStorage = null;
    int status;
    public TestActivityLifeCycleManagementHandler() throws Exception{
       dBStorage=new DBStorage();
    } 
    public String closeTestActivity(String activity_id) throws Exception{
        status = dBStorage.getActivityStatus(activity_id);
       System.out.println("status="+status);
        if(status==0){
        System.out.println("talcmh");
            return dBStorage.closeTestActivity(activity_id);}
        else 
            return "Activity already closed ";
    }
}