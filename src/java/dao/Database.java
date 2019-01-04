package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.derby.jdbc.ClientDataSource;

public class Database {

    private static DataSource ds;

    public static Connection getConnection() {

        if (ds == null) {
            Properties properties = new Properties();

            try (InputStream input = new FileInputStream("WEB-INF/dbinfo.properties")) {
                properties.load(input);

                ClientDataSource cds = new ClientDataSource();
                cds.setDatabaseName(properties.getProperty("dbname"));
                cds.setUser(properties.getProperty("username"));
                cds.setPassword(properties.getProperty("password"));
                cds.setPortNumber(Integer.parseInt(properties.getProperty("port")));
                cds.setServerName(properties.getProperty("server"));

                ds = cds;

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
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
