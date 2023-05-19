/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author xyh10
 */
public class Chat_Item extends javax.swing.JLayeredPane {

    /**
     * Creates new form Chat_Item
     */
    private JLabel label;
    public Chat_Item() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0,0,0, 0));
        txt.setOpaque(false);
    }
    
    public void setText(String text){
        txt.setText(text);
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(getBackground() != null){
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        }
        super.paintComponent(g); 
    }
    
    public void setUserProfile(String user){
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        layer.setBorder(new EmptyBorder(10,10,0,10));
        
        // set user profile name 
        JButton cmd = new JButton(user);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setFocusable(false);
        cmd.setForeground(new Color(30,121,213));
        cmd.setFont(new java.awt.Font("sansserif", 1,13));
        
//        txt.setBorder(new EmptyBorder(5,10,10,10));
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        layer.add(cmd);
        add(layer, 0);
        
    }
    
    public void setTime(String time){
        // CREATE A layered pane and add time+logo onto it
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        layer.setBorder(new EmptyBorder(0,5,10,5));
        
        // create text for time, align text to left
        label = new JLabel(time);
        label.setForeground(new Color(110,110,110));
        label.setHorizontalTextPosition(JLabel.LEFT);
        
        layer.add(label);
        add(layer);
    }
    
    public void sendSuccess(){
        if(label != null){
            label.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/tick.png")));
        }
    }
    
    public void seen(){
        if(label != null){
            label.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/double-tick.png")));
        }
    }
    
    public void setImage(boolean right, Icon... images){
        if(images.length > 0){
            JLayeredPane layer = new JLayeredPane();
            layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT : FlowLayout.LEFT));
            layer.setBorder(new EmptyBorder(0,5,0,5));
            Chat_Image chat_Image = new Chat_Image(right);
            chat_Image.addImage(images);
            layer.add(chat_Image);
            add(layer); // add layerpane to Chat_Item
        }
        
    }
    
    public void setImage(boolean right, String... imageEncodingStrings){
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right?FlowLayout.RIGHT : FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0,5,0,5));
        Chat_Image chat_Image = new Chat_Image(right);
        chat_Image.addImage(imageEncodingStrings);
        layer.add(chat_Image);
        add(layer); // add layerpane to Chat_Item
    }
    
    public void setFile(String filename, String filesize){
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0,5,0,5));
        Chat_File item = new Chat_File();
        item.setFile(filename, filesize);
        layer.add(item);
        
        add(layer); // add layerpane to Chat_Item
    }
    
    
    public void setEmoji(boolean right, Icon icon){
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0,5,0,5));

        layer.add(new JLabel(icon));
        
        add(layer); // add layerpane to Chat_Item
        setBackground(null);
    }
    
    
    public void hideText(){
        txt.setVisible(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.healthconnect.swing.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.healthconnect.swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}
