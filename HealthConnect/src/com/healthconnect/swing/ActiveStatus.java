/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author xyh10
 */
public class ActiveStatus extends Component{
    
    private boolean active;
    public ActiveStatus(){
        setPreferredSize(new Dimension(8,8));
        repaint();
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void paint(Graphics g) {
        if(active){
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(62,165,49));
            g2.fillOval(0, (getHeight()/2) -2, 8, 8);
        }
//        super.paint(g); 
    }
    
    
    
    
}
