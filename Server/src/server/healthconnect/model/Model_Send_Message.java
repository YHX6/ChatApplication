/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.model;

import java.util.Date;



/**
 *
 * @author xyh10
 */
public class Model_Send_Message {
    private int fromUserID;
    private int toUserID;
    private String text;
    private int messageType;
    private String time;

    public Model_Send_Message() {
    }

    public Model_Send_Message(int fromUserID, int toUserID, String text, int messageType) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.messageType = messageType;
    }

        public Model_Send_Message(int fromUserID, int toUserID, String text, int messageType, String time) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.messageType = messageType;
        this.time = time;
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

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Model_Send_Message{" + "fromUserID=" + fromUserID + ", toUserID=" + toUserID + ", text=" + text + ", messageType=" + messageType + ", time=" + time + '}';
    }
    
    
    
}
