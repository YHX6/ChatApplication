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
import com.corundumstudio.socketio.listener.DisconnectListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import server.healthconnect.model.Model_Client;
import server.healthconnect.model.Model_Login;
import server.healthconnect.model.Model_Message;
import server.healthconnect.model.Model_Register;
import server.healthconnect.model.Model_User_Account;

/**
 *
 * @author xyh10
 */
public class Service {
    private static Service instance;
    private SocketIOServer server;
    private JTextArea textArea;
    private final int PORT_NUMBER = 9812;
    private ServiceUser serviceUser;
    private List<Model_Client> listClients;
    
    public static Service getInstance(JTextArea textArea){
        if(instance == null) instance = new Service(textArea);
        return instance;
    }
    
    public Service(JTextArea textArea){
        this.textArea = textArea;
        serviceUser = new ServiceUser();
        listClients = new ArrayList<>();
        
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
        
        // add even register from client side,   Check with Login.java in client
        server.addEventListener("register", Model_Register.class, new DataListener<Model_Register>(){
            @Override
            public void onData(SocketIOClient sioc, Model_Register t, AckRequest ar) throws Exception{
                Model_Message message = serviceUser.register(t);
                ar.sendAckData(message.isAction(), message.getMessage(), message.getData());
                    
                textArea.append("User Registering:  {UserName:  " + t.getUserName() + "        Password:" + t.getPassword() +  "        ActionStatus: "  + message.getMessage()  +    "}\n");
                if(message.isAction()){
                    server.getBroadcastOperations().sendEvent("list_user", (Model_User_Account) message.getData());
                    addClient(sioc, (Model_User_Account) message.getData());
                }
                
            }
            
        });
        //add eventlistner, create menu left based on uses in the database
        server.addEventListener("list_user", Integer.class, new DataListener<Integer>(){
            @Override
            public void onData(SocketIOClient sioc, Integer userID, AckRequest ar) throws Exception{
                try {
                    List<Model_User_Account> list = serviceUser.getUser(userID);
                    sioc.sendEvent("list_user", list.toArray());
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        });
        //
        server.addEventListener("login", Model_Login.class, new DataListener<Model_Login>(){
            @Override
            public void onData(SocketIOClient sioc, Model_Login t, AckRequest ar) throws Exception{
                Model_User_Account login = serviceUser.login(t);
                if(login != null){
                    ar.sendAckData(true, login);
                    addClient(sioc, login);
                    userConnect(login.getUserID());
                }else{
                    ar.sendAckData(false);
                }
                
            }
        });
       
        server.addDisconnectListener(new DisconnectListener(){
            @Override
            public void onDisconnect(SocketIOClient sioc) {
                int userID = removeClient(sioc);
                if(userID != 0){ // remove and disconnect
                    userDisconnect(userID);
                }
            }
        });
        
        server.start();
        textArea.setText("Server start on port: " + PORT_NUMBER + "\n");
    }

    public List<Model_Client> getListClients() {
        return listClients;
    }
 
    private void addClient(SocketIOClient client, Model_User_Account user){
        listClients.add(new Model_Client(client,user));
    }
    
    private void userConnect(int userID){
        server.getBroadcastOperations().sendEvent("user_status", userID, true);
    }
    
    private void userDisconnect(int userID){
        server.getBroadcastOperations().sendEvent("user_status", userID, false);
    }
    
    public int removeClient(SocketIOClient client){
        for(Model_Client d:listClients){
            if(d.getClient() == client){
                listClients.remove(d);
                return d.getUser().getUserID();
            }
        }
        return 0;
    }
    
    
    
}
