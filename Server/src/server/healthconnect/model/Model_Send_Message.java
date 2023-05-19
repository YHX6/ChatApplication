/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.model;



/**
 *
 * @author xyh10
 */
public class Model_Send_Message {
    private int fromUserID;
    private int toUserID;
    private String text;
    private int messageType;

    public Model_Send_Message() {
    }

    public Model_Send_Message(int fromUserID, int toUserID, String text, int messageType) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
        this.messageType = messageType;
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
    
    
}
