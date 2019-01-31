/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Praveen verma
 */
public class PasswordHash {
    
    public static boolean matchPass(String password , String Hpassword){
            
        if(BCrypt.checkpw(password, Hpassword))
        {
            return true;
        }
        else{
            return false;
        }
    }
    
    public static String hashPassword(String password , int salt)
    {
        return BCrypt.hashpw(password, BCrypt.gensalt(salt));
    }
    
    public static String hashPassword(String password , String salt)
    {
        return BCrypt.hashpw(password, salt);
    }
    
}
