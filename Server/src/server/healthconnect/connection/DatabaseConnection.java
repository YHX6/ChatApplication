/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author xyh10
 */
public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;    
    
    private DatabaseConnection(){
        
    }
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    

    public void connectToDatabase() throws Exception{
        String server = "localhost";
        String port = "3306";
        String database = "healthc";
        String userName = "root";
        String password = "root";
        connection = DriverManager.getConnection("jdbc:mysql://" + server + ":"+port+"/"+database, userName, password);
    }
    
    
}
