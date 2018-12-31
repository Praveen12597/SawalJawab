
package dao;

import java.util.List;
import model.User;

public interface UserDao {
    
    public boolean isValidUser (User user);
    public boolean insertUser (User user);
    public User getUser (String username);
    public List<User> getAllUser ();
    
}
