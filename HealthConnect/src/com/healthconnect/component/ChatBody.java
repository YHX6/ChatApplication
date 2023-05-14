/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import com.healthconnect.swing.ScrollBar;
import java.awt.Color;
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
        addItemRight("hello 在做气泡聊天的时候，原本已经用Jtextarea已经实现。后来因为使用到emoji表情，需要将组件改为JtextPane来实现插入图片，改组件后出现了这样的问题,情，需要将组件改为JtextPane来实现插入图片，改组件后出,情，需要将组件改为JtextPane来实现插入图片，改组件后出");
        addItemRight("hello 在做气泡聊天的时候，原本已经用Jtextarea已经实现。后来因为使用到emoji表情，需要将组件改为JtextPane来实现插入图片，改组件后出现了这样的问题,情，需要将组件改为JtextPane来实现插入图片，改组件后出,情，需要将组件改为JtextPane来实现插入图片，改组件后出");
        addItemRight("hello 在做气泡聊天的时候，原本已经用Jtextarea已经实现。后来因为使用到emoji表情，需要将组件改为JtextPane来实现插入图片，改组件后出现了这样的问题,情，需要将组件改为JtextPane来实现插入图片，改组件后出,情，需要将组件改为JtextPane来实现插入图片，改组件后出");
        addItemLeft("asd\n  asda\n asdsa");
        addItemRight("asdasdadasdsadasd  asdasd asd");
        addItemLeft("asd\n  asda\n asdsa");
        addItemRight("asdasdadasdsadasd  asdasd asd");
        addItemLeft("asd\n  asda\n asdsa");
        addItemRight("asdasdadasdsadasd  asdasd asd");
        addItemLeft("asd\n  asda\n asdsa");
        addItemRight("asdasdadasdsadasd  asdasd asd");
        addItemLeft("asd\n  asda\n asdsa");
        addItemRight("asdasdadasdsadasd  asdasd asd");
        addItemLeft("asd\n  asda\n asdsa");
        addItemRight("asdasdadasdsadasd  asdasd asd");
        addItemLeft("asd\n  asda\n asdsa");
        addItemRight("asdasdadasdsadasd  asdasd asd");
        addItemLeft("asdsakdasklnasklaskasdlas");
        
        
    }
    
    private void init(){
        body.setLayout(new MigLayout("fillx", "", "15[]15"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }
    
    public void addItemLeft(String text){
        Chat_Left item = new Chat_Left();
        item.setText(text);
        body.add(item, "wrap, w :: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
    }
        
    public void addItemRight(String text){
        Chat_Right item = new Chat_Right();
        item.setText(text);
        body.add(item, "wrap, al right, w :: 80%");  // set woyj as 80% max width
        body.repaint();
        body.revalidate();
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
