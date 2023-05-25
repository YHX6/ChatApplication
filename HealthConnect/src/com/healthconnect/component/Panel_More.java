/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.component;

import com.healthconnect.app.MessageType;
import com.healthconnect.emoji.Emoji;
import com.healthconnect.emoji.Model_Emoji;
import com.healthconnect.event.PublicEvent;
import com.healthconnect.main.Main;
import com.healthconnect.model.Model_Send_Message;
import com.healthconnect.model.Model_User_Account;
import com.healthconnect.service.Service;
import com.healthconnect.swing.ScrollBar;
import com.healthconnect.swing.WrapLayout;
import com.healthconnect.util.Util;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author xyh10
 */
public class Panel_More extends javax.swing.JPanel {

    /**
     * Creates new form Panel_More
     */
    private Model_User_Account user;
    public Panel_More() {
        initComponents();
        init();
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }
    
    
    private void init(){
        setLayout(new MigLayout("fillx"));
        //header part
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonImage());
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle1());
        panelHeader.add(getEmojiStyle2());
        add(panelHeader, "w 100%, h 30!, wrap");
        
        // detail part
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));
        JScrollPane ch = new JScrollPane(panelDetail);
        ch.setBorder(null);
        ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ch.setVerticalScrollBar(new ScrollBar());
  
        add(ch, "w 100%, h 100%");
    }
    
    private JButton getButtonImage(){
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/image.png")));
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               JFileChooser ch = new JFileChooser();
               ch.setMultiSelectionEnabled(true);
               ch.setFileFilter(new FileFilter(){
                   @Override
                   public boolean accept(File f) {
                      return f.isDirectory() || isImageFile(f);
                   }

                   @Override
                   public String getDescription() {
                       return "";
                   }
                   
               });
               int option = ch.showOpenDialog(Main.getFrames()[0]);
               if(option == JFileChooser.APPROVE_OPTION){
                   File[] files = ch.getSelectedFiles();
                   try {
                       for(File file:files){
                           Model_Send_Message message = new Model_Send_Message(Service.getInstance().getUser().getUserID(), user.getUserID(), "" ,MessageType.IMAGE, Util.toDateStr(new Date()));
                           Service.getInstance().addFile(file, message);
                           PublicEvent.getInstance().getEventChat().sendMessage(message);
                       }
                   } catch (Exception ee) {
                       ee.printStackTrace();;
                   }
               }
            }
            
        });
        return cmd;
    }
    
    
    
    private JButton getButtonFile(){
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/healthconnect/icon/link.png")));
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser ch = new JFileChooser();
                ch.showOpenDialog(Main.getFrames()[0]);
                //update
            }     
        });
        
        return cmd;
    }
    
    
    private JButton getEmojiStyle1(){
        //
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getEmoji(1).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for(Model_Emoji d:Emoji.getInstance().getStyle1()){
                    panelDetail.add(getButton(d));
         
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
            
        
        });
        
        return cmd;
    }
        
    private JButton getEmojiStyle2(){
        //
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getEmoji(21).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for(Model_Emoji d:Emoji.getInstance().getStyle2()){
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
            
        
        });
        
        return cmd;
    }
    
    private JButton getButton(Model_Emoji data){
        JButton c = new JButton(data.getIcon());
        c.setName(data.getId() + "");
        c.setBorder(new EmptyBorder(3, 3, 3, 3));
        c.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.setContentAreaFilled(false);
        c.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Model_Send_Message message = new Model_Send_Message( Service.getInstance().getUser().getUserID(), user.getUserID(), data.getId() + "", MessageType.EMOJI, Util.toDateStr(new Date()));
                sendMessage(message);
                PublicEvent.getInstance().getEventChat().sendMessage(message);
            }
        });
        return c;
    }
    
    private void sendMessage(Model_Send_Message data){
        Service.getInstance().getClient().emit("send_to_user", data.toJSONObject());
    }
    
    private void clearSelected(){
        for(Component c:panelHeader.getComponents()){
            if(c instanceof OptionButton){
                ((OptionButton) c).setSelected(false);
            }
        }
    }
    
    private boolean isImageFile(File file){
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".png") ||name.endsWith(".jpeg") || name.endsWith(".gif");
    }
    
    
    private JPanel panelHeader;
    private JPanel panelDetail;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
