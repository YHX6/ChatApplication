/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.swing;

import javax.swing.JProgressBar;

/**
 *
 * @author xyh10
 * This clas is used to show image under progress
 */
public class Progress extends  JProgressBar{
    private ProgressType progressType = ProgressType.NONE;
    
    public static enum ProgressType{
        NONE, DOWN_FILE, CANCEL, FILE
    }

    public ProgressType getProgressType() {
        return progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        repaint();
    }
    
    
    public Progress(){
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
    
}
