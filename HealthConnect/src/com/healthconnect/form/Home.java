/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.form;

import com.healthconnect.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;


/**
 *
 * @author xyh10
 */
public class Home extends javax.swing.JLayeredPane {

    /**
     * Creates new form Home
     */
    private Chat chat;
    public Home() {
        initComponents();
        init();
    }

    private void init(){
        //setLayout(new MigLayout("fillx, filly","5[200!]10[fill, 100%]5[200!]0","0[fill]0"));
        setLayout(new MigLayout("fillx, filly","5[80!]0[200!]10[fill, 100%]5","0[fill]0"));
        //profile
        this.add(new Menu_Profile());
        
        //left 
        this.add(new Menu_Left());
         //chat 
        chat =new Chat();
        this.add(chat);
        
        
        chat.setVisible(false);
        
    }

    public void setUser(Model_User_Account user){
        chat.setUser(user);
        chat.setVisible(true);
    }
    
    public void updateUser(Model_User_Account user){
        chat.updateUser(user);
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 861, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
