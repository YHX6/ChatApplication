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
    
    public Progress(){
        setOpaque(false);
        setUI(new ProgressCircleUI(this));
    }
    
}
