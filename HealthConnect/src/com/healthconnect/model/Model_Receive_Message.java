/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.model;

import com.healthconnect.app.MessageType;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author xyh10
 */
public class Model_Receive_Message {
    private int fromUserID;
    private String text;
    private MessageType messageType;
    private Model_Receive_Image dataImage;

    public Model_Receive_Message() {
    }

    public Model_Receive_Message(int fromUserID, String text, MessageType messageType) {
        this.fromUserID = fromUserID;
        this.text = text;
        this.messageType = messageType;
    }
    
    public Model_Receive_Message(Object json) {
        JSONObject obj = (JSONObject) json;
        try {
            fromUserID = obj.getInt("fromUserID");
            text = obj.getString("text");      
            messageType = MessageType.toMessageType(obj.getInt("messageType"));
            if(!obj.isNull("dataImage")){
                dataImage = new Model_Receive_Image(obj.get("dataImage"));
            }
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    public JSONObject toJSONObject(){
        try {
            JSONObject obj = new JSONObject();
            obj.put("fromUserID", fromUserID);
            obj.put("text", text);
            obj.put("messageType", messageType.getValue());
            if(dataImage != null){
                obj.put("dataImage", dataImage.toJsonObject());
            }
            return obj;
        } catch (JSONException e) {
            return null;
        }
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

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Model_Receive_Image getDataImage() {
        return dataImage;
    }

    public void setDataImage(Model_Receive_Image dataImage) {
        this.dataImage = dataImage;
    }
    
    
    
}
