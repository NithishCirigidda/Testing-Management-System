
public class TestPhaseCreationHandler 
{

      DBStorage dBStorage= null;
      TestPhase testPhaseObj = null;

      public TestPhaseCreationHandler() throws Exception
      {
                dBStorage = new DBStorage();	      
      }

      public String createTestPhase(TestPhase testPhaseObj)  throws Exception
      {
            return  dBStorage.storeTestPhase(testPhaseObj);
      }

      public String updateTestPhase(TestPhase testPhaseObj)  throws Exception
     {
            return dBStorage.updateTestPhase(testPhaseObj);
     }

     public TestPhase getTestPhase(String phase_id)  throws Exception
     {
                 return dBStorage.getTestPhase(phase_id);
      }

     public String deleteTestPhase(String phase_id)  throws Exception
    {
          return dBStorage.deleteTestPhase(phase_id);
    }  
}