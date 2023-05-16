/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import com.healthconnect.swing.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author xyh10
 */
public class ChatBody extends javax.swing.JPanel {

    /**
     * Creates new form ChatTitle
     */
    public ChatBody() {
        initComponents();
        init();
        
        // testing
//        String[] imgs = {"LGF5]+Yk^6#M@-5c,1J5@[or[Q6.", "L5BpbD1,0g2|I^-=5Y%N18$kR%?G"};
//        
//        addItemLeft("hello 在做气泡聊天的时候，原本已经用Jtextarea已经实现。后来因为使用到emoji表情，需要将组件改为JtextPane来实现插入图片，改组件后出现了这样的问题,情，需要将组件改为JtextPane来实现插入图片，改组件后出,情，需要将组件改为JtextPane来实现插入图片，改组件后出","Johnathan");
//        addItemLeft("hello", "Johnathan");
//        addDate("06/12/1998");
//        addItemRight("hello 在做气泡聊天的时候，原本已经用Jtextarea已经实现。后来因为使用到emoji表情，需要将组件改为JtextPane来实现插入图片，改组件后出现了这样的问题,情，需要将组件改为JtextPane来实现插入图片，改组件后出,情，需要将组件改为JtextPane来实现插入图片，改组件后出");
//        addDate("TODAY");
//        addItemLeft(" 在做气泡聊天的时候，原本已经用Jtextarea已经实现。后来因为使用到emoji表情，需要将组件改为JtextPane来实现插入图片，改组件后出现了这样的问题,情","Shiyun");
//        addItemLeft("", "Shiyun", new ImageIcon(getClass().getResource("/com/healthconnect/icon/spongebob.png")), new ImageIcon(getClass().getResource("/com/healthconnect/icon/hutao.jpg")),  new ImageIcon(getClass().getResource("/com/healthconnect/icon/tick.png")),  new ImageIcon(getClass().getResource("/com/healthconnect/icon/zzs.jpg")));
//        addItemRight("asd在做气泡聊天的时候，原本已经用Jtextarea已经实现。后来因为使用到emoji表情，需要将组件改为JtextPane来实现插入图片，改组件后出现了这样的问题,情", new ImageIcon(getClass().getResource("/com/healthconnect/icon/spongebob.png")), new ImageIcon(getClass().getResource("/com/healthconnect/icon/hutao.jpg")));
//        addItemLeft("asd", "Shiyun", imgs);
//        addItemFile("dada", "Yaohong", "mydoc.pdf", "1MB");
//        addItemFileRight("", "mydoc.pdf", "1MB");
    }
    
    private void init(){
        body.setLayout(new MigLayout("fillx", "", "15[]15"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }
    
    public void addItemLeft(String text, String user, Icon... images){
        Chat_Left_Profile item = new Chat_Left_Profile();
        item.setText(text);
        item.setImage(images);
        item.setTime("asd");
        item.setUserProfile(user);
        body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
    }
    
        
    public void addItemLeft(String text, String user, String[] imageEncodingsStrings){
        Chat_Left_Profile item = new Chat_Left_Profile();
        item.setText(text);
        item.setImage(imageEncodingsStrings);
        item.setTime("asd");
        item.setUserProfile(user);
        body.add(item, "wrap, w 100:: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
    }
    
    public void addItemFile(String text, String user, String filename, String filesize){
        Chat_Left_Profile item = new Chat_Left_Profile();
        item.setText(text);
        item.setFile(filename, filesize);
        item.setTime("asd");
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
    
        
    public void addItemRight(String text, Icon... images){
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setImage(images);
//        item.setUserProfile(user);
        body.add(item, "wrap, al right, w 100:: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
        item.setTime("sd");
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
