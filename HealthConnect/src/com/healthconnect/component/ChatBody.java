/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import com.healthconnect.app.MessageType;
import com.healthconnect.emoji.Emoji;
import com.healthconnect.event.EventInitChatMessage;
import com.healthconnect.event.PublicEvent;
import com.healthconnect.model.Model_Receive_Message;
import com.healthconnect.model.Model_Send_Message;
import com.healthconnect.model.Model_User_Account;
import com.healthconnect.service.Service;

import com.healthconnect.swing.ScrollBar;
import com.healthconnect.util.Util;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;
import sun.security.util.Password;

/**
 *
 * @author xyh10
 */
public class ChatBody extends javax.swing.JPanel {

    /**
     * Creates new form ChatTitle
     */
    private Model_User_Account user;
    public ChatBody() {
        initComponents();
        init();
    }
    
    private void init(){
        body.setLayout(new MigLayout("fillx", "", "15[]15"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        
        PublicEvent.getInstance().addEventInitChatMessage(new EventInitChatMessage(){
            @Override
            public void initChatMessages(List<Model_Send_Message> messages) {
                Collections.sort(messages, (a,b) -> (a.getTime().compareTo(b.getTime())));
                clearChat();
                
                int thisID = Service.getInstance().getUser().getUserID();
                
                String dateSoFar = null;
                for(Model_Send_Message m:messages){
                    String dateThis = m.getTime().substring(0, 10);
                    //System.out.println(dateSoFar);
                    if(dateSoFar == null || !dateThis.equals(dateSoFar)){
                        dateSoFar = dateThis;
                        addDate(dateSoFar);
                    }
                    
                    if(m.getFromUserID() == thisID){
                        addItemRight(m);
                    }else{
                        addItemLeft(m);
                    }
                }
            }
            
        });
        
        
        
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user; 
    }
    
    public void initHistory(){
        body.removeAll();
        
    }
    
    public void clearChat(){
        body.removeAll();
        repaint();
        revalidate();
    }
    

    public void addItemLeft(String text, String user, Icon... images){
        Chat_Left_Profile item = new Chat_Left_Profile();
        item.setText(text);
        item.setImage(images);
        item.setTime(Util.toDateStr(new Date()));
        item.setUserProfile(user);
        body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
    }
    
        public void addItemLeft(Model_Send_Message data){
        if(data.getMessageType() == MessageType.TEXT){
            Chat_Left_Profile item = new Chat_Left_Profile();
            item.setText(data.getText());
            item.setTime(data.getTime());
            body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        }else if(data.getMessageType() == MessageType.EMOJI){
            Chat_Left_Profile item = new Chat_Left_Profile();
            item.setEmoji(Emoji.getInstance().getEmoji(Integer.valueOf(data.getText())).getIcon());
            item.setTime(data.getTime());
            body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        }else if(data.getMessageType() == MessageType.IMAGE){
           // toD
        }
        
        repaint();
        revalidate();
    }
    
        
    public void addItemLeft(Model_Receive_Message data){
        if(data.getMessageType() == MessageType.TEXT){
            Chat_Left_Profile item = new Chat_Left_Profile();
            item.setText(data.getText());
            item.setTime("asd");
            body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        }else if(data.getMessageType() == MessageType.EMOJI){
            Chat_Left_Profile item = new Chat_Left_Profile();
            item.setEmoji(Emoji.getInstance().getEmoji(Integer.valueOf(data.getText())).getIcon());
            item.setTime("asd");
            body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        }else if(data.getMessageType() == MessageType.IMAGE){
            Chat_Left_Profile item = new Chat_Left_Profile();
            item.setText("");
            item.setImage(data.getDataImage());
            item.setTime("asd");
            body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        }
        
        repaint();
        revalidate();
    }
    
    public void addItemFile(String text, String user, String filename, String filesize){
        Chat_Left_Profile item = new Chat_Left_Profile();
        item.setText(text);
        item.setFile(filename, filesize);
        item.setTime(Util.toDateStr(new Date()));
        item.setUserProfile(user);
        body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
    }
        
    public void addItemFileRight(String text, String filename, String filesize){
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setFile(filename, filesize);
        
        body.add(item, "wrap, al right, w 100:: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
    }
    
        
    public void addItemRight(Model_Send_Message data){
        if(data.getMessageType() == MessageType.TEXT){
            Chat_Right item = new Chat_Right();
            item.setText(data.getText()); 
            item.setTime(data.getTime());
            body.add(item, "wrap, al right, w 100:: 80%");  // set woyj as 80% max width
           
        }else if(data.getMessageType() == MessageType.EMOJI){
            Chat_Right item = new Chat_Right();
            item.setEmoji(Emoji.getInstance().getEmoji(Integer.valueOf(data.getText())).getIcon());
            item.setTime(data.getTime());
            body.add(item, "wrap, al right, w 100:: 80%");  // set woyj as 80% max width
            
        }else if(data.getMessageType() == MessageType.IMAGE){
            Chat_Right item = new Chat_Right();
            item.setText("");
            item.setImage(data.getFile());
            item.setTime(data.getTime());
            body.add(item, "wrap, al right, w 100:: 80%");  // set woyj as 80% max width
            
        }
        repaint();
        revalidate();
        scrollToBottom();
    }
        

    
    public void addDate(String date){
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        body.add(item, "wrap, al center");
        body.repaint();
        body.revalidate();
    }
        
    
    // add method to scroll to the bottom of chat panel
    private void scrollToBottom(){   
        JScrollBar vertiBar  = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener(){
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e){
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                vertiBar.removeAdjustmentListener(this);
            }
        };
        vertiBar.addAdjustmentListener(downScroller);
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
