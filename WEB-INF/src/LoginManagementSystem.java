    public class LoginManagementSystem 
  { 
          User userObj=null;
          DBStorage dBStorage = null;
          String s=null;         
   public LoginManagementSystem()
  {
         try
        {
               userObj = new User();
               dBStorage = new DBStorage();
         }
         catch(Exception e)
         {
          }
  }
/*===================authentication===============================*/
  public String authenticate(String user_id, String password)
 {
   s =dBStorage.getPassword(user_id);
    if(s.equals(password))
      return "valid password";
    else
    return "enter correct username/password";
  }
/*===================change password===========================*/

 public String changePassword(String user_id, String oldPassword, String newPassword)
 {
         s =dBStorage.getPassword(user_id);
         if(s.equals(oldPassword))
            return dBStorage.updatePassword(user_id, newPassword);
         else
            return "Password cannot be changed";
        
} 
/***********************************************Create User****************************/
  public String createUser(User userObj) 
{
  String createMsg=null;
  try
  {
   createMsg= dBStorage.storeUser(userObj);
  }
  catch(Exception e)
  {
   System.out.println(e);
   }  
  return createMsg;
 }
/*********************************************view user************************/
   public User getUser(String user_id) 
   {
       try
    {
    userObj= dBStorage.getUser(user_id);
   }
   catch(Exception e)
   {
   System.out.println(e);
   }
return userObj;   
}
/**************************update UserDetails**********************/
    public String updateUser(User userObj)
  {
    String updateMsg=null;
  try
  {
   updateMsg= dBStorage.updateUser(userObj);
  }
  catch(Exception e)
  {
   System.out.println(e);
   }  
  return updateMsg;
   }

/**************************************deleteuser*************************************/
    public String deleteUser(String user_id)
{
return dBStorage.deleteUser(user_id);
}
}