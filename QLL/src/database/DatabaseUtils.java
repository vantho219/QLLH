/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Darling
 */
public class DatabaseUtils {
    public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=DBStudent;encrypt=true;trustServerCertificate=true;user=sa;password=123456";
    public static Connection getDBConnect(){

        try {
            Connection conn = null;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        }catch (ClassNotFoundException ex){
            System.out.println("no driver");
            System.out.println("Error:"+ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error:"+ex.toString());
        }
        return null;
    }
}
