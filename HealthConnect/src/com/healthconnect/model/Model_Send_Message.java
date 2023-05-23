/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.model;

import com.healthconnect.app.MessageType;
import com.healthconnect.util.Util;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author xyh10
 */
public class Model_Send_Message {
    private int fromUserID;
    private int toUserID;
    private String text;
    private MessageType messageType;
    private Model_File_Sender file;
    private String time;

    public Model_Send_Message(int fromUserID, int toUserID, String text, MessageType messageType) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.messageType = messageType;
    }

    public Model_Send_Message(int fromUserID, int toUserID, String text, MessageType messageType, String time) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.messageType = messageType;
        this.file = file;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    

    public Model_Send_Message() {
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    public int getToUserID() {
        return toUserID;
    }

    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Model_File_Sender getFile() {
        return file;
    }

    public void setFile(Model_File_Sender file) {
        this.file = file;
    }

   
    
    public JSONObject toJSONObject(){
        try {
            JSONObject obj = new JSONObject();
            obj.put("fromUserID", fromUserID);
            obj.put("toUserID", toUserID);
            obj.put("text", text);
            obj.put("messageType", messageType.getValue());
            if(messageType== MessageType.FILE || messageType == MessageType.IMAGE){
                obj.put("text", file.getFileExtensions());
            }else{
                obj.put("text", text);
            }
            obj.put("time", time);
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }
    
}
