
package dao;

import java.sql.Connection;

public class Database {
    private static Connection connection;
    
    public static Connection getConnection (){
        return connection;
    }
}
