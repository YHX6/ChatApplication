/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.healthconnect.form;

import com.healthconnect.event.EventLogin;
import com.healthconnect.event.EventMessage;
import com.healthconnect.event.PublicEvent;
import com.healthconnect.model.Model_Login;
import com.healthconnect.model.Model_Message;
import com.healthconnect.model.Model_Register;
import com.healthconnect.model.Model_User_Account;
import com.healthconnect.service.Service;
import io.socket.client.Ack;
import java.util.Arrays;

/**
 *
 * @author xyh10
 */
public class Login extends javax.swing.JPanel {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        init();
    }
    
    private void init(){
        PublicEvent.getInstance().addEventLogin(new EventLogin(){
           @Override
           public void login(Model_Login data){
               new Thread(new Runnable(){
                   @Override
                   public void run(){
                        PublicEvent.getInstance().getEventMain().showLoading(true);
                        
                        Service.getInstance().getClient().emit("login", data.toJsonObject(), new Ack(){
                            @Override
                            public void call(Object... os) {
                                if(os.length > 0){
                                    boolean action = (Boolean) os[0];
                                    if(action){  // if action is true, then show loading page
                                        Service.getInstance().setUser(new Model_User_Account(os[1]));
                                        
                                        PublicEvent.getInstance().getEventProfileBar().showRrofile();
                                        try {
                                            Thread.sleep(3000);
                                        } catch (Exception e) {

                                        }
                      
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                                        //PublicEvent.getInstance().getEventMain().refreshChat();
                                        PublicEvent.getInstance().getEventMain().selectUser(null);
                                        PublicEvent.getInstance().getEventMain().initChat();
                                        //System.out.println("clicked user list");
                                            
                                    }else{  // if password is wrong
                                        PublicEvent.getInstance().getEventMain().showLoading(false);
                           
                                    }
                                    
                                }else{
                          
                                    PublicEvent.getInstance().getEventMain().showLoading(false);
                                }
                                
                            }

                        });
                        
                   
                   }
               
               }).start();
           }
           
           @Override
           public void register(Model_Register data, EventMessage eventMessage){
               // here, we use emit method to send a json data to the server, the sender method name is "register"
               Service.getInstance().getClient().emit("register", data.toJsonObject(), new Ack(){
                   @Override
                   public void call(Object... os){   // recieve objects from server side. check with Service.java in server side 
                       if(os.length > 0){
                           Model_Message ms = new Model_Message((boolean) os[0], os[1].toString());
                          PublicEvent.getInstance().getEventProfileBar().showRrofile();
                           if(ms.isAction()){
                               Model_User_Account user =new Model_User_Account(os[2]);
//                               System.out.println(user.getUserID() + " ");
                                Service.getInstance().setUser(user);
                                PublicEvent.getInstance().getEventProfileBar().showRrofile();
                                PublicEvent.getInstance().getEventMain().refreshChat();
                           }
                            eventMessage.callMessage(ms);
                           //call message back when done register
                       }
                   }
               });
           }
           
           @Override
           public void goRegister(){
               slide.show(1);
           }
           
           @Override
           public void goLogin(){
               slide.show(0);
           }

            @Override
            public void logout() {
                Service.getInstance().getClient().emit("logout", Service.getInstance().getUser().getUserID());
                PublicEvent.getInstance().getEventMenuLeft().clearMenuLeft();
                PublicEvent.getInstance().getEventMain().showLoginPage();
            }
        
           
           
        });
        
        
        
        P_Login login = new P_Login();
        P_Register register = new P_Register();
        slide.init(login, register);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pictureBox1 = new com.healthconnect.swing.PictureBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        slide = new com.healthconnect.swing.PanelSlide();

        setBackground(new java.awt.Color(255, 255, 255));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/healthconnect/icon/loginBG.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(73, 77, 255));
        jLabel1.setForeground(new java.awt.Color(104, 80, 255));
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("HealthConnect  copyright @YHX6");

        jPanel1.setBackground(new java.awt.Color(108, 141, 244));
        jPanel1.setPreferredSize(new java.awt.Dimension(304, 380));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 378));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 288, Short.MAX_VALUE)
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 335, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 227, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.healthconnect.swing.PictureBox pictureBox1;
    private com.healthconnect.swing.PanelSlide slide;
    // End of variables declaration//GEN-END:variables
}
