
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import model.User;

public class UserDaoSql implements UserDao {

    @Override
    public boolean isValidUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        User user = new User();
        
        try {
            Class.forName("...");
            Connection con = Database.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("..." + username);
            
            while(rs.next()){
                user.setUsername(rs.getString("..."));
                user.setPassword(rs.getString("..."));
            }
            
        } catch (Exception e) {
        }
        
        return user;
    }

    @Override
    public boolean insertUser(User user) {
        // ststement = database.getconnection
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAllUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
