/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.service;

import com.fasterxml.jackson.databind.jsontype.impl.AsDeductionTypeSerializer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import server.healthconnect.app.MessageType;
import server.healthconnect.connection.DatabaseConnection;
import server.healthconnect.model.Model_Direction;
import server.healthconnect.model.Model_File;
import server.healthconnect.model.Model_Receive_Message;
import server.healthconnect.model.Model_Send_Message;

/**
 *
 * @author xyh10
 */
public class ServiceChatMessage {
    
     //sql
    private final String GET_MESSAGES_BY_ID = "select FromUserID, ToUserID, MessageType, Content, Time from messages where FromUserID = ? and ToUserID = ?;";
    private final String INSERT_MESSAGE = "insert into messages values (?,?,?,?,?);";
    
    //instance
    private final Connection con;
    
    public ServiceChatMessage(){
        con = DatabaseConnection.getInstance().getConnection();
    }
    
    public void PersistMessage(Model_Send_Message message)throws SQLException{
        PreparedStatement p = con.prepareStatement(INSERT_MESSAGE);
        p.setInt(1, message.getFromUserID());
        p.setInt(2, message.getToUserID());  
        p.setInt(3, message.getMessageType());
        p.setString(4, message.getText());
        p.setString(5, message.getTime());
        p.execute();
        p.close();
    }
    
    public List<Model_Send_Message> getMessages(Model_Direction md) throws SQLException{
        List<Model_Send_Message> messages = new ArrayList<>();
        //1.
        PreparedStatement p = con.prepareStatement(GET_MESSAGES_BY_ID);
        p.setInt(1, md.getMeID());
        p.setInt(2, md.getOtherID());  
        ResultSet rs = p.executeQuery();
        while(rs.next()){
            int fromId = rs.getInt("FromUserID");
            int toID = rs.getInt("ToUserID");
            int messageType = rs.getInt("MessageType");
            String content = rs.getString("Content");
            String time = rs.getString("Time");

            Model_Send_Message m = new Model_Send_Message(fromId, toID, content, messageType, time);
            messages.add(m);
        }
        
        p = con.prepareStatement(GET_MESSAGES_BY_ID);
        p.setInt(2, md.getMeID());
        p.setInt(1, md.getOtherID());  
        rs = p.executeQuery();
        while(rs.next()){
            int fromId = rs.getInt("FromUserID");
            int toID = rs.getInt("ToUserID");
            int messageType = rs.getInt("MessageType");
            String content = rs.getString("Content");
            String time = rs.getString("Time");

            Model_Send_Message m = new Model_Send_Message(fromId, toID, content, messageType, time);
            messages.add(m);
        }

        return messages;
    }
    
}
