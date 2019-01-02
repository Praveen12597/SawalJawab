
package dao;

public class DaoManager {
    
    public static UserDao getUserDao (){
        return new UserDaoSql();
    }
    
}
