/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author xyh10
 */
public class Model_Package_Sender {
    private int fileID;
    private byte [] data;
    private boolean finish;

    public Model_Package_Sender() {
    }

    public Model_Package_Sender(int fileID, byte[] data, boolean finish) {
        this.fileID = fileID;
        this.data = data;
        this.finish = finish;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
    
    public JSONObject toJSONObject(){
        try {
            JSONObject obj = new JSONObject();
            obj.put("fileID", fileID);
            obj.put("data", data);
            obj.put("finish", finish);
            return obj;
        } catch (JSONException e) {
            return null;
        }
            
    }
    
}
