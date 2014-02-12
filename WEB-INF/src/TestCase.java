 import java.sql.Date;
public class TestCase {

	private String testcase_id;
	private String testcase_description;
	private String testcase_phase;
	private String expected_behaviour;
                         
             
	private Project projectObj;
	private User userObj;
	private Activity activityObj;
                  
                   private Date testcase_actual_date;
                   private String testcase_status;
                   private String comments;
                   private String testcase_actual_behaviour;


	public User getUserObj() 
                   {
		return this.userObj;
	}
	public void setUserObj(User userObj) 
                  {
		this.userObj = userObj;
	}

                   public Project getProjectObj()
                 {     
		return this.projectObj;
                                     
	}
	public void setProjectObj(Project projectObj) 
                  {
		this.projectObj = projectObj;
	}
                              
	public Activity getActivityObj() {
		return this.activityObj;
	}
	public void setActivityObj(Activity activityObj) {
		this.activityObj = activityObj;
	}

	public String getTestCaseId() {
		return this.testcase_id;
	}
	public void setTestCaseId(String testcase_id) {
		this.testcase_id = testcase_id;
	}

	public String getTestCaseDescription() {
		return this.testcase_description;
	}
	public void setTestCaseDescription(String testcase_description)
                  {
		this.testcase_description = testcase_description;
	}

	public String getTestCasePhase() {
		return this.testcase_phase;
	}
	public void setTestCasePhase(String testcase_phase) {
		this.testcase_phase = testcase_phase;
	}

	public String getExpectedBehaviour() {

                                   System.out.println(expected_behaviour);
		return this.expected_behaviour;
	}
	public void setExpectedBehaviour(String expectedBehaviour) 
                  {
                                   System.out.println(expectedBehaviour);
                     	this.expected_behaviour = expectedBehaviour;
	}
                    public Date getActualDate()
                    {         
                         return this.testcase_actual_date; 
                    }  
                    public void setActualDate(Date testcase_actual_date)
                   {
		this.testcase_actual_date= testcase_actual_date;
	}
                    public String getTestCaseStatus()
                    {         
                         return this. testcase_status; 
                    }  
                     public void setTestCaseStatus( String testcase_status )
                     {
		this.testcase_status =testcase_status;
	  }
                    public String getComments()
                       {         
                         return this. comments; 
                        }  
                      public void setComments( String comments )
                     {
		this.comments =comments;
	  }
                        public String getActualBehaviour()
                       {         
                                    return this.testcase_actual_behaviour; 
                        }  
                      public void setActualBehaviour(String  testcase_actual_behaviour)
                     {
		this.testcase_actual_behaviour=testcase_actual_behaviour;
	  }
}