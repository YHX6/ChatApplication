/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import com.healthconnect.app.MessageType;
import com.healthconnect.event.PublicEvent;
import com.healthconnect.model.Model_Send_Message;
import com.healthconnect.model.Model_User_Account;
import com.healthconnect.service.Service;
import com.healthconnect.swing.JIMSendTextPane;
import com.healthconnect.swing.ScrollBar;
import com.healthconnect.util.Util;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author xyh10
 */
public class ChatBottom extends javax.swing.JPanel {

    /**
     * Creates new form ChatTitle
     */
    private Model_User_Account user;
    
    public ChatBottom() {
        initComponents();
        init();
    }

    
     
    private void init(){
        //add txt
        mig = new MigLayout("fillx, filly","2[fill]0[]0[]2", "5[fill]2[]0");
        setLayout(mig);
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        JIMSendTextPane txt = new JIMSendTextPane();
        txt.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent ke){
                refresh();
                if(ke.getKeyChar()==10 && ke.isControlDown()){  // press control+enter
                    eventSend(txt);
                }
            }
        
        });
        
        txt.setBorder(new EmptyBorder(5,5,5,5));
        txt.setHintText("Write Message Here...");
        // scroll bar for txt
        scroll.setViewportView(txt);
        ScrollBar sb = new ScrollBar();
        sb.setBackground(new Color(229,229,229));
        sb.setPreferredSize(new Dimension(5, 10));
        scroll.setVerticalScrollBar(sb);
        add(sb); 
        add(scroll, "w 100%");  
        

        // send button
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setBackground(Color.white);
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
      
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/send.png")));
        cmd.addActionListener(new ActionListener(){     // add send message event
            @Override
            public void actionPerformed(ActionEvent ae){
                eventSend(txt);
            }
        
        });
        
        
        // more button
        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
      
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/more_disable.png")));
        cmdMore.addActionListener(new ActionListener(){     // add send message event
            @Override
            public void actionPerformed(ActionEvent ae){
                if(panelMore.isVisible()){
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/more_disable.png")));
                    panelMore.setVisible(false);
                    mig.setComponentConstraints(panelMore, "dock south,h 0!");
                    revalidate();
                }else{
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/more.png")));
                    panelMore.setVisible(true);
                    mig.setComponentConstraints(panelMore, "dock south,h 170!");
                    revalidate();
                }
            }
        
        });
        
    
        panel.add(cmdMore);
        panel.add(cmd);
        add(panel, "wrap");
        panelMore = new Panel_More();
        panelMore.setVisible(false);
        add(panelMore, "dock south,h 0!");  //set height 0
    }
    
    private void eventSend(JIMSendTextPane txt){            
        String text = txt.getText().trim();       
        if(!txt.equals("")){
            Model_Send_Message message = new Model_Send_Message(Service.getInstance().getUser().getUserID(), user.getUserID(), text, MessageType.TEXT, Util.toDateStr(new Date()));                      
            send(message);                      // send to server     
            PublicEvent.getInstance().getEventChat().sendMessage(message);     // add to text pane     
            txt.setText("");     
            txt.grabFocus();                   
            refresh();              
        }else{           
            txt.grabFocus();     
        }
    }
    
    
    private void send(Model_Send_Message data){
        Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
        
    }

    private void refresh(){
        revalidate();
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
        panelMore.setUser(user);
    } 

    private Panel_More panelMore;
    private MigLayout mig;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
