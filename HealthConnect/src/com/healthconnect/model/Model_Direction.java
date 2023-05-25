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
public class Model_Direction {
    private int meID;
    private int otherID;

    public Model_Direction(int meID, int otherID) {
        this.meID = meID;
        this.otherID = otherID;
    }

    public int getMeID() {
        return meID;
    }

    public void setMeID(int meID) {
        this.meID = meID;
    }

    public int getOtherID() {
        return otherID;
    }

    public void setOtherID(int otherID) {
        this.otherID = otherID;
    }

    public Model_Direction() {
    }

    
    
    public JSONObject toJsonObject(){
        try {
            JSONObject obj = new JSONObject();
            obj.put("meID", meID);
            obj.put("otherID", otherID);
            return obj;
        } catch (JSONException e) {
            return null;
        }
        
    }
    
}
