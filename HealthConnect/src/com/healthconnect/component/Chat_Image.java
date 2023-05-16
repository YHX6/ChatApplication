/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.healthconnect.component;

import com.healthconnect.event.PublicEvent;
import com.healthconnect.swing.PictureBox;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author xyh10
 */
public class Chat_Image extends javax.swing.JLayeredPane {

    /** Creates new form Chat_Image */
    public Chat_Image(boolean right) {
        initComponents();
        setLayout(new MigLayout("","0[" +  (right ? "right":"left") + "]0","2[]2"));
    }
    
    public void addImage(Icon... images ){
        for(Icon image:images){
            PictureBox pic = new PictureBox();
            pic.setPreferredSize(getAutoSize(image, 200, 200));
            pic.setImage(image);
            addEvent(pic, image);   // add view image event for images
            add(pic, "wrap");
        }
    }   
    
    public void addImage(String... imageEncodingStrings ){
        for(String imageString:imageEncodingStrings){
            Image_Item pic = new Image_Item();
            pic.setPreferredSize(new Dimension(200,200));
            pic.setImage(imageString);
            add(pic, "wrap");
        }
    }
    
    private void addEvent(Component com, Icon image){
        // register a certain event for a comppnent
        com.setCursor(new Cursor(Cursor.HAND_CURSOR));  // cursor
        com.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent me){
                if(SwingUtilities.isLeftMouseButton(me)){  // if it is left click, then view image
                    PublicEvent.getInstance().getEventImageView().viewImage(image);
                }
            }
        });
    }
    
        
    private Dimension getAutoSize(Icon image, int w, int h) {
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        
        if(w >= iw) w = iw;  // solve the problem when the picture too small that it has a large empty srounding it 
        if(h >= ih) h = ih;
        
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        return new Dimension(width, height);
    }

    private Image toImage(Icon icon) {
        return ((ImageIcon) icon).getImage();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}