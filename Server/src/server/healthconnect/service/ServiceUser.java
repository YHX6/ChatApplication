/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.service;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import server.healthconnect.connection.DatabaseConnection;
import server.healthconnect.model.Model_Message;
import server.healthconnect.model.Model_Register;

/**
 *
 * @author xyh10
 */
public class ServiceUser {
    private final Connection con;
    
    public ServiceUser(){
        this.con = DatabaseConnection.getInstance().getConnection();
    }
    
    public Model_Message register(Model_Register data) {
        Model_Message message = new Model_Message();
        try {
            //check if username is occupied
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, data.getUserName());
            ResultSet r = p.executeQuery();
            if(r.next()){  // If empty, so use has exit
                message.setAction(false);
                message.setMessage("User Already Exist!");
            }else{
                message.setAction(true);
            }
            r.close();
            p.close();
            
            // insert user register
            if(message.isAction()){
                
                p = con.prepareStatement(INSER_USER);
                p.setString(1, data.getUserName());
                p.setString(2, data.getPassword());
                p.execute();
                p.close();
                message.setMessage("User Accout created!");
            }
        } catch (SQLException e) {
            
            message.setAction(false);
            message.setMessage("Server Error!");
            
        }
        return message;
        
        
    }
    
    //sql
    private final String INSER_USER = "insert into user (UserName, `Password`) values (?, ?)";
    private final String CHECK_USER = "select UserID from user where UserName = ? limit 1";
    
}
