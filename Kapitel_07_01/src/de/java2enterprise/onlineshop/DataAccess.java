package de.java2enterprise.onlineshop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class DataAccess {
    final Logger logger =
            Logger.getLogger(
                DataAccess.class.getName());

    public static void main(String[] args) 
            throws Exception {
        DataAccess dataAccess = new DataAccess();
        dataAccess.test();
    }
    
    public void test() throws 
        FileNotFoundException, 
        IOException, 
        ClassNotFoundException, 
        SQLException {
                
        final Properties p = new Properties();
        p.load(new FileInputStream(
                "C:/tmp/jdbc.properties"));
        Class.forName(p.getProperty("driver"));
        
        try(Connection con = DriverManager.getConnection(
                p.getProperty("url"), 
                p.getProperty("username"), 
                p.getProperty("password"))) {

            if(con.isValid(10)) {
                logger.info("Connected!");
            }
        } 
        logger.info("Program finished!");        
    }
}
