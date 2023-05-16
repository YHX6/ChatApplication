/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.service;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import javax.swing.JTextArea;
import server.healthconnect.model.Model_Message;
import server.healthconnect.model.Model_Register;

/**
 *
 * @author xyh10
 */
public class Service {
    private static Service instance;
    private SocketIOServer server;
    private JTextArea textArea;
    private final int PORT_NUMBER = 9812;
    
    public static Service getInstance(JTextArea textArea){
        if(instance == null) instance = new Service(textArea);
        return instance;
    }
    
    public Service(JTextArea textArea){
        this.textArea = textArea;
        
    }
    
    public void startService(){
        // start server with configurations
        Configuration config = new Configuration();
        config.setPort(PORT_NUMBER);
        server = new SocketIOServer(config);
        server.addConnectListener(new ConnectListener(){
            @Override
            public void onConnect(SocketIOClient sioc){
                textArea.append("Client connected:     " +  sioc.getRemoteAddress() + "\n");
            }
        });
        
        // add even register from client side, 
        server.addEventListener("register", Model_Register.class, new DataListener<Model_Register>(){
            @Override
            public void onData(SocketIOClient sioc, Model_Register t, AckRequest ar) throws Exception{
                Model_Message message = new ServiceUser().register(t);
                ar.sendAckData(message.isAction(), message.getMessage());
//                textArea.append(message.isAction() + "    " +message.getMessage());
                textArea.append("User Registering:  {UserName:  " + t.getUserName() + "        Password:" + t.getPassword() +  "        ActionStatus: "  + message.getMessage()  +    "}\n");
            }
            
        });
        server.start();
        textArea.setText("Server start on port: " + PORT_NUMBER + "\n");
    }
    
}
