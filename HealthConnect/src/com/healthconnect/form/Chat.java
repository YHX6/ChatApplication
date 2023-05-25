/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.form;

import com.healthconnect.component.ChatBody;
import com.healthconnect.component.ChatBottom;
import com.healthconnect.component.ChatTitle;
import com.healthconnect.event.EventChat;
import com.healthconnect.event.PublicEvent;
import com.healthconnect.model.Model_Receive_Message;
import com.healthconnect.model.Model_Send_Message;
import com.healthconnect.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author xyh10
 */
public class Chat extends javax.swing.JPanel {

    /**
     * Creates new form Menu_Left
     */
    private ChatTitle chatTitle;
    private ChatBody chatBody;
    private ChatBottom chatBottom;
    
    public Chat() {
        initComponents();
        init();
    }
    
    
    private void init(){
        setLayout(new MigLayout("fillx", "0[fill]0", "[]0[100%, fill]0[shrink 0]0"));
        
        chatTitle = new ChatTitle();
        chatBody = new ChatBody();
        chatBottom = new ChatBottom();
        
        PublicEvent.getInstance().addEventChat(new EventChat(){   // register and define send message eveent
            @Override
            public void sendMessage(Model_Send_Message data) {
                chatBody.addItemRight(data);
            }
            
            @Override
            public void receiveMessage(Model_Receive_Message data) {
                if(chatTitle != null && chatTitle.getUser().getUserID() == data.getFromUserID()){
                    chatBody.addItemLeft(data);
                }
            }

            
            
        });
        
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::50%");  
    }

        
    public void setUser(Model_User_Account user){
        chatTitle.setUserName(user);
        chatBottom.setUser(user);
        chatBody.setUser(user);
        //chatBody.clearChat();
        chatBody.initHistory();
    }
    
    public void updateUser(Model_User_Account user){
         chatTitle.updateUser(user);
        chatBottom.setUser(user);
    }
    
    public void initHistory(){
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
