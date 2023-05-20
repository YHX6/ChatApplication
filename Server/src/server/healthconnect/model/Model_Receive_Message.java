/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.model;


/**
 *
 * @author xyh10
 */
public class Model_Receive_Message {
    private int fromUserID;
    private String text;
    private int messageType;
    private Model_Receive_Image dataImage;

    public Model_Receive_Message() {
    }

    public Model_Receive_Message(int fromUserID, String text, int messageType, Model_Receive_Image dataImage) {
        this.fromUserID = fromUserID;
        this.text = text;
        this.messageType = messageType;
        this.dataImage = dataImage;
    }

    public int getFromUserID() {
        return fromUserID;
    }

    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
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

    public Model_Receive_Image getDataImage() {
        return dataImage;
    }

    public void setDataImage(Model_Receive_Image dataImage) {
        this.dataImage = dataImage;
    }

   

    
    
    
    
    
}
