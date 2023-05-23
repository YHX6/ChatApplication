/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import server.healthconnect.app.MessageType;
import server.healthconnect.connection.DatabaseConnection;
import server.healthconnect.model.Model_File;
import server.healthconnect.model.Model_Receive_Message;
import server.healthconnect.model.Model_Send_Message;

/**
 *
 * @author xyh10
 */
public class ServiceMessage {
    
     //sql
    private final String GET_MESSAGES_BY_ID = "insert into messages values (?,?,?,?,?);";
    private final String INSERT_MESSAGE = "";
    
    //instance
    private final Connection con;
    
    public ServiceMessage(){
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    public void PersistMessage(Model_Send_Message message)throws SQLException{
        PreparedStatement p = con.prepareStatement(GET_MESSAGES_BY_ID);
        p.setInt(1, message.getFromUserID());
        p.setInt(2, message.getToUserID());  
        p.setInt(3, message.getMessageType());
        p.setString(4, message.getText());
        p.setString(5, message.getTime());
        p.execute();
        p.close();
    }
    
    public List<Model_Send_Message> getMessages(){
        return null;
    }
    
}
