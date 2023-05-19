/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import com.healthconnect.event.PublicEvent;
import com.healthconnect.model.Model_User_Account;
import com.healthconnect.swing.ActiveStatus;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author xyh10
 */
public class Item_People extends javax.swing.JPanel {

    /**
     * Creates new form Item_People
     */
    private final Model_User_Account user;
    private boolean mouseOver;
    
    public Item_People(Model_User_Account user) {
        this.user = user;
        initComponents();
        lb.setText(user.getUserName());
        activeStatus.setActive(user.isStatus());
        init();
        
    }

    public Model_User_Account getUser() {
        return user;
    }


    public ActiveStatus getActiveStatus() {
        return activeStatus;
    }
    
    public void updateStatus(){
        activeStatus.setActive(user.isStatus());
    }
    
    private void init(){
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent me){
                setBackground(new Color(229,229,229));
                mouseOver = true;
            }
            
            @Override
            public void mouseExited(MouseEvent me){
                setBackground(new Color(242,242,242));
                mouseOver = false;
            }
            
            @Override
            public void mouseReleased(MouseEvent me){
                if(mouseOver){
                    PublicEvent.getInstance().getEventMain().selectUser(user);
                }
            }
            
            
        
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new com.healthconnect.swing.ImageAvatar();
        lb = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        activeStatus = new com.healthconnect.swing.ActiveStatus();

        setBackground(new java.awt.Color(242, 242, 242));

        imageAvatar1.setBorderSize(0);
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/healthconnect/icon/user-active.png"))); // NOI18N

        lb.setFont(new java.awt.Font("Microsoft YaHei UI", 2, 12)); // NOI18N
        lb.setForeground(new java.awt.Color(159, 159, 159));
        lb.setText("Active");

        lb1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        lb1.setText("Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(activeStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageAvatar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lb1)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.healthconnect.swing.ActiveStatus activeStatus;
    private com.healthconnect.swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb1;
    // End of variables declaration//GEN-END:variables
}
