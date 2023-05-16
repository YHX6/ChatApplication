/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.form;

import com.healthconnect.event.EventMessage;
import com.healthconnect.event.PublicEvent;
import com.healthconnect.model.Model_Message;
import com.healthconnect.model.Model_Register;
import javax.swing.Timer;

/**
 *
 * @author xyh10
 */
public class P_Register extends javax.swing.JPanel {

    /**
     * Creates new form P_Login
     */
    public P_Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        fieldUserName = new javax.swing.JTextField();
        lbPwd = new javax.swing.JLabel();
        fieldPwd = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        lbConfirmPwd = new javax.swing.JLabel();
        fieldConfirmPwd = new javax.swing.JPasswordField();
        lbWarning = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(0, 0, 0));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Resiter");

        lbUserName.setForeground(new java.awt.Color(0, 0, 0));
        lbUserName.setText("User Name");

        lbPwd.setForeground(new java.awt.Color(0, 0, 0));
        lbPwd.setText("Password");

        fieldPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPwdActionPerformed(evt);
            }
        });

        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        backBtn.setForeground(new java.awt.Color(81, 38, 222));
        backBtn.setText("Back Login");
        backBtn.setContentAreaFilled(false);
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        lbConfirmPwd.setForeground(new java.awt.Color(0, 0, 0));
        lbConfirmPwd.setText("Confirm Password");

        fieldConfirmPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldConfirmPwdActionPerformed(evt);
            }
        });

        lbWarning.setBackground(new java.awt.Color(255, 0, 0));
        lbWarning.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldPwd)
                            .addComponent(fieldUserName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbUserName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbPwd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(fieldConfirmPwd)
                            .addComponent(lbConfirmPwd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPwd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbConfirmPwd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldConfirmPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPwdActionPerformed

    private void fieldConfirmPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldConfirmPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldConfirmPwdActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        PublicEvent.getInstance().getEventLogin().goLogin();
        
        
        
    }//GEN-LAST:event_backBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        String userName = fieldUserName.getText().trim();
        String password = String.valueOf(fieldPwd.getPassword());
        String confirmPassword = String.valueOf(fieldConfirmPwd.getPassword());
        if(userName.equals("")){
            lbWarning.setForeground(new java.awt.Color(255, 0, 0));
            lbWarning.setText("UserName is required!");
            fieldUserName.grabFocus();
        }else if(password.equals("")){
            lbWarning.setForeground(new java.awt.Color(255, 0, 0));
            lbWarning.setText("Password is required!");
            fieldPwd.grabFocus();
        }else if(!password.equals(confirmPassword)){
            lbWarning.setForeground(new java.awt.Color(255, 0, 0));
            lbWarning.setText("Password not the same!");
            fieldConfirmPwd.grabFocus();
        }else{
            Model_Register data = new Model_Register(userName, password);
            PublicEvent.getInstance().getEventLogin().register(data, new EventMessage() {
                @Override
                public void callMessage(Model_Message message) {
//                    System.out.println(message.getMessage());
                    if(!message.isAction()){
                        lbWarning.setForeground(new java.awt.Color(255, 0, 0));
                        lbWarning.setText(message.getMessage());
                        
                    }else{  // if ok, then login in
                        lbWarning.setForeground(new java.awt.Color(0, 255 , 0));
                        lbWarning.setText(message.getMessage());
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        
                        PublicEvent.getInstance().getEventLogin().login();
                    }
                }
            });
        }
    }//GEN-LAST:event_registerBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPasswordField fieldConfirmPwd;
    private javax.swing.JPasswordField fieldPwd;
    private javax.swing.JTextField fieldUserName;
    private javax.swing.JLabel lbConfirmPwd;
    private javax.swing.JLabel lbPwd;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel lbWarning;
    private javax.swing.JButton registerBtn;
    // End of variables declaration//GEN-END:variables
}
