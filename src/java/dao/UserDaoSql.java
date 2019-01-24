   
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDaoSql implements UserDao {

    @Override
    public boolean isValidUser(User user) {
        try {
            Connection connection = Database.getConnection();
            String sql = "select (1) from users where username = ? and password = ?";
            PreparedStatement st = connection.prepareStatement(sql);
            
            st.setString(1, user.getUsername());
            st.setString(1, user.getPassword());
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()){
                return true;
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return false;
    }

    @Override
    public User getUser(String username) {
        
        User user = new User();
        
        try {
            Connection con = Database.getConnection();
            String sql = "select * from users where username = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                user.setUsername(rs.getString("username"));
                //user.setPassword(rs.getString("..."));
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return user;
    }

    @Override
    public boolean insertUser(User user) {
        
        
        
        return false;
    }

    @Override
    public List<User> getAllUser() {
        List <User> users = new ArrayList <>();
        
        try {
            Connection connection = Database.getConnection();
            String sql = "select (1) from users";
            Statement st = connection.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                User user = new User ();
                user.setUsername(rs.getString("username"));
                //user.setPassword(rs.getString("..."));
                
                users.add(user);
            }
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        
        return users;
    }
    
    @Override
    public boolean usernameExist (String username){
        
        try {
            Connection connection = Database.getConnection();
            String sql = "select (1) from users where username = ?";
            
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            
            return ps.executeQuery().next();
            
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return false;   
    }
    
    @Override
    public String getEmailByUsername (String username){
        throw new UnsupportedOperationException();
    }
    
}
