package dao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientDataSource;

public class Database {

    private static DataSource ds;

    public static Connection getConnection() {

        if (ds == null) {
            Properties properties = new Properties();
            
            try (BufferedInputStream input = new BufferedInputStream(ClassLoader.getSystemResourceAsStream("/WEB-INF/dbinfo.properties"))) {
                properties.load(input);
                /*properties.setProperty("dbname", "qnadb");
                properties.setProperty("username", "root");
                properties.setProperty("password", "root@123");
                properties.setProperty("server", "localhost");
                properties.setProperty("port", "1527");*/
                
                ClientDataSource cds = new ClientDataSource();
                cds.setDatabaseName(properties.getProperty("dbname"));
                cds.setUser(properties.getProperty("username"));
                cds.setPassword(properties.getProperty("password"));
                cds.setPortNumber(Integer.parseInt(properties.getProperty("port")));
                cds.setServerName(properties.getProperty("server"));

                ds = cds;

            //} catch (FileNotFoundException ex) {
               // Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        try {
            return ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
