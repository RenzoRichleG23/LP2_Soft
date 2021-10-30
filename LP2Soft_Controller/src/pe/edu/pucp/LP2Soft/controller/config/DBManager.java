/**
 * @author INFunables Group
 */
package pe.edu.pucp.LP2Soft.controller.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static DBManager dbManager = new DBManager();
    private Connection con;
    
    private String url = "jdbc:mysql://claselp220212.ciqxiwc8rvxa.us-east-1.rds.amazonaws.com:3306/inf28220212"; 
    private String user = "root";
    private String password = "LP2INF20212";
    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
    public static DBManager getInstance() {
        return dbManager;
    }
}

