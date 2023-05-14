/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author xyh10
 */
public class Chat_Right extends javax.swing.JLayeredPane {

    /**
     * Creates new form Chat_Left
     */
    public Chat_Right() {
        initComponents();
        txt.setBackground(new Color(103, 252, 98));
    }
    
    public void setText(String text){
        if(text.equals("")){  // if the text is empty ,make sure it does not takes a new line
            txt.hideText();
        }else{
            txt.setText(text);
        }    
        txt.seen();
    }
    
    
    public void setImage(Icon... images){
        txt.setImage(true, images);  //set images to the right
    }
        
    public void setImage(String... imageEncodingStrings){
        txt.setImage(false, imageEncodingStrings);
    }
    
    public void setTime(String time){
        txt.setTime("10:30 AM");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.healthconnect.component.Chat_Item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.healthconnect.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
