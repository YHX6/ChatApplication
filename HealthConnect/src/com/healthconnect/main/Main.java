/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.healthconnect.main;

import com.healthconnect.event.EventImageView;
import com.healthconnect.event.PublicEvent;
import com.healthconnect.swing.ComponentResizer;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author xyh10
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        init();
    }
    
    private void init(){
        setIconImage(new ImageIcon(getClass().getResource("/com/healthconnect/icon/icon.png")).getImage());
        ComponentResizer com = new ComponentResizer();
        com.registerComponent(this);
        com.setMinimumSize(new Dimension(900, 500));
        com.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        com.setSnapSize(new Dimension(10,10));
        
        imageView.setVisible(false); // we have two panel, to set imageview as invisible at first
        home.setVisible(true);
        initEvent();
    }
    
    
    public void initEvent(){  // initialize/define the image event, and we can triger this event with the medthods in Chat_Image class
        PublicEvent.getInstance().addEventImageView(new EventImageView() {
            @Override
            public void viewImage(Icon image) {
              imageView.viewImage(image);
            }
            
            @Override
            public void saveImage(Icon image){
                System.out.println("hutao");
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

        border = new javax.swing.JPanel();
        background = new javax.swing.JPanel();
        title = new javax.swing.JPanel();
        cmdMinimize = new javax.swing.JButton();
        cmdMinimize1 = new javax.swing.JButton();
        body = new javax.swing.JLayeredPane();
        imageView = new com.healthconnect.form.View_Image();
        home = new com.healthconnect.form.Home();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        border.setBackground(new java.awt.Color(237, 237, 237));

        background.setBackground(new java.awt.Color(255, 255, 255));

        title.setBackground(new java.awt.Color(235, 235, 235));
        title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleMouseDragged(evt);
            }
        });
        title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleMousePressed(evt);
            }
        });

        cmdMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/healthconnect/icon/minimize.png"))); // NOI18N
        cmdMinimize.setBorder(null);
        cmdMinimize.setContentAreaFilled(false);
        cmdMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdMinimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMinimizeActionPerformed(evt);
            }
        });

        cmdMinimize1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/healthconnect/icon/close.png"))); // NOI18N
        cmdMinimize1.setBorder(null);
        cmdMinimize1.setContentAreaFilled(false);
        cmdMinimize1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdMinimize1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMinimize1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmdMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(cmdMinimize1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdMinimize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdMinimize1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        body.setLayout(new java.awt.CardLayout());
        body.setLayer(imageView, javax.swing.JLayeredPane.POPUP_LAYER);
        body.add(imageView, "card3");
        body.add(home, "card2");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout borderLayout = new javax.swing.GroupLayout(border);
        border.setLayout(borderLayout);
        borderLayout.setHorizontalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        borderLayout.setVerticalGroup(
            borderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, borderLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(border, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private int pX;
    private int pY;
    private void titleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX() - pX,
                            this.getLocation().y + evt.getY() - pY);
    }//GEN-LAST:event_titleMouseDragged

    private void titleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleMousePressed
        // TODO add your handling code here:
        pX = evt.getX();
        pY = evt.getY();
    }//GEN-LAST:event_titleMousePressed

    private void cmdMinimizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMinimizeActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_cmdMinimizeActionPerformed

    private void cmdMinimize1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMinimize1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cmdMinimize1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLayeredPane body;
    private javax.swing.JPanel border;
    private javax.swing.JButton cmdMinimize;
    private javax.swing.JButton cmdMinimize1;
    private com.healthconnect.form.Home home;
    private com.healthconnect.form.View_Image imageView;
    private javax.swing.JPanel title;
    // End of variables declaration//GEN-END:variables
}
