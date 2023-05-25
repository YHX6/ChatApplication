/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.model;

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

    @Override
    public String toString() {
        return "Model_Direction{" + "meID=" + meID + ", otherID=" + otherID + '}';
    }

    
    
}
