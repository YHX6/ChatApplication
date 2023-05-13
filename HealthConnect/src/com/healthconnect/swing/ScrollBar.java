/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.swing;

import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author xyh10
 */
public class ScrollBar extends javax.swing.JScrollBar{
    
    public ScrollBar(){
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242,242,242));
        setUnitIncrement(20);
    }
    
}
