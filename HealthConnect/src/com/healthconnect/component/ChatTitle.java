/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import com.healthconnect.model.Model_User_Account;

/**
 *
 * @author xyh10
 */
public class ChatTitle extends javax.swing.JPanel {

    /**
     * Creates new form ChatTitle
     */
    private Model_User_Account user;
    
    public ChatTitle() {
        initComponents();

    }
    
    public void setUserName(Model_User_Account user){
        this.user = user;
        name.setText(user.getUserName());
        if(user.isStatus()){
            setStatusActive();
        }else{
            setStatusText("Offline");
        }
    }
    
    
    public void updateUser(Model_User_Account user){
        if(this.user == user){
            name.setText(user.getUserName());
            if(user.isStatus()){
                setStatusActive();
            }else{
                setStatusText("Offline");
            }
        }
    }
    
    private void setStatusActive(){
        status.setText("Active now");
        status.setForeground(new java.awt.Color(40,147,59));
    }
    
    private void setStatusText(String text){
        status.setText(text);
        status.setForeground(new java.awt.Color(160,160,160));
    }

    public Model_User_Account getUser() {
        return user;
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        name = new javax.swing.JLabel();
        status = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 242, 242));
        setPreferredSize(new java.awt.Dimension(400, 45));

        layer.setLayout(new java.awt.GridLayout(0, 1));

        name.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 14)); // NOI18N
        name.setText("Name");
        layer.add(name);

        status.setForeground(new java.awt.Color(0, 255, 0));
        status.setText("Active now");
        layer.add(status);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layer, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel name;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
