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
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import server.healthconnect.app.MessageType;
import server.healthconnect.model.Model_Client;
import server.healthconnect.model.Model_Direction;
import server.healthconnect.model.Model_File;
import server.healthconnect.model.Model_Login;
import server.healthconnect.model.Model_Message;
import server.healthconnect.model.Model_Package_Sender;
import server.healthconnect.model.Model_Receive_Image;
import server.healthconnect.model.Model_Receive_Message;
import server.healthconnect.model.Model_Register;
import server.healthconnect.model.Model_Reques_Files;
import server.healthconnect.model.Model_Send_Message;
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
    private ServiceFile serviceFile;
    private ServiceChatMessage serviceChatMessage;

    public static Service getInstance(JTextArea textArea) {
        if (instance == null) {
            instance = new Service(textArea);
        }
        return instance;
    }

    public Service(JTextArea textArea) {
        this.textArea = textArea;
        serviceUser = new ServiceUser();
        listClients = new ArrayList<>();
        serviceFile = new ServiceFile();
        serviceChatMessage = new ServiceChatMessage();

    }

    public void startService() {
        // start server with configurations
        Configuration config = new Configuration();
        config.setPort(PORT_NUMBER);
        server = new SocketIOServer(config);
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient sioc) {
                textArea.append("Client connected:     " + sioc.getRemoteAddress() + "\n");
            }
        });

        // add even register from client side,   Check with Login.java in client
        server.addEventListener("register", Model_Register.class, new DataListener<Model_Register>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Register t, AckRequest ar) throws Exception {
                Model_Message message = serviceUser.register(t);
                ar.sendAckData(message.isAction(), message.getMessage(), message.getData());

                textArea.append("User Registering:  {UserName:  " + t.getUserName() + "        Password:" + t.getPassword() + "        ActionStatus: " + message.getMessage() + "}\n");
                if (message.isAction()) {
                    server.getBroadcastOperations().sendEvent("list_user", (Model_User_Account) message.getData());
                    addClient(sioc, (Model_User_Account) message.getData());
                }

            }

        });
        //add eventlistner, create menu left based on uses in the database
        server.addEventListener("list_user", Integer.class, new DataListener<Integer>() {
            
            @Override
            public void onData(SocketIOClient sioc, Integer userID, AckRequest ar) throws Exception {
               
                try {
                    List<Model_User_Account> list = serviceUser.getUser(userID);
                    sioc.sendEvent("list_user", list.toArray());
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        });
        
        
                // init chat history
        server.addEventListener("chat_history", Model_Direction.class, new DataListener<Model_Direction>(){
            @Override
            public void onData(SocketIOClient sioc, Model_Direction t, AckRequest ar) throws Exception {
                
                try {
                    List<Model_Send_Message> messages = serviceChatMessage.getMessages(t);
                    sioc.sendEvent("chat_history", messages.toArray());
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            
        });
        
        //user login
        server.addEventListener("login", Model_Login.class, new DataListener<Model_Login>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Login t, AckRequest ar) throws Exception {
       
                Model_User_Account login = serviceUser.login(t);
                if (login != null) {
                    ar.sendAckData(true, login);
                    addClient(sioc, login);
                    userConnect(login.getUserID());
                } else {
                    ar.sendAckData(false);
                }
            }
        });
        

        server.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient sioc) {
                int userID = removeClient(sioc);
                if (userID != 0) { // remove and disconnect
                    userDisconnect(userID);
                }
            }
        });

        // send message to user side
        server.addEventListener("send_to_user", Model_Send_Message.class, new DataListener<Model_Send_Message>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Send_Message t, AckRequest ar) throws Exception {
                sendToClient(t, ar);
            }

        });

         // send file to user side
        server.addEventListener("send_file", Model_Package_Sender.class, new DataListener<Model_Package_Sender>() {
            @Override
            public void onData(SocketIOClient sioc, Model_Package_Sender t, AckRequest ar) throws Exception {
                try {
                    serviceFile.reveiveFile(t);

                    if (t.isFinish()) {
                        ar.sendAckData(true);
                        Model_Receive_Image dataImage = new Model_Receive_Image();
                        dataImage.setFileID(t.getFileID());
                        Model_Send_Message message = serviceFile.closeFile(dataImage);
                        // send to client "message"
                        sendTempFileTiClient(message, dataImage);
                    } else {
                        ar.sendAckData(true);
                    }

                } catch (IOException e) {
                    ar.sendAckData(false);
                }
            }

        });
        
         // get file to user side
        server.addEventListener("get_file", Integer.class, new DataListener<Integer>(){
            @Override
            public void onData(SocketIOClient sioc, Integer t, AckRequest ar) throws Exception {
                Model_File file = serviceFile.initFile(t);
                long fileSize = serviceFile.getFileSize(t);
                ar.sendAckData(file.getFileExtension(), fileSize);
            }
            
        });
        
        // get a list of files from user
        server.addEventListener("reques_file", Model_Reques_Files.class, new DataListener<Model_Reques_Files>(){
            @Override
            public void onData(SocketIOClient sioc, Model_Reques_Files t, AckRequest ar) throws Exception {
                byte[] data = serviceFile.getFileData(t.getCurrentLength(), t.getFileID());
                if(data != null){
                    ar.sendAckData(data);
                }else{
                    ar.sendAckData();
                }
            }
            
        });
        
        server.start();
        textArea.setText("Server start on port: " + PORT_NUMBER + "\n");
    }

    public List<Model_Client> getListClients() {
        return listClients;
    }

    private void addClient(SocketIOClient client, Model_User_Account user) {
        listClients.add(new Model_Client(client, user));
    }

    private void userConnect(int userID) {
        server.getBroadcastOperations().sendEvent("user_status", userID, true);
    }

    private void userDisconnect(int userID) {
        server.getBroadcastOperations().sendEvent("user_status", userID, false);
    }

    public int removeClient(SocketIOClient client) {
        for (Model_Client d : listClients) {
            if (d.getClient() == client) {
                listClients.remove(d);
                return d.getUser().getUserID();
            }
        }
        return 0;
    }

    private void sendToClient(Model_Send_Message data, AckRequest ar) {
        if (data.getMessageType() == MessageType.IMAGE.getValue() || data.getMessageType() == MessageType.FILE.getValue()) {
            try {
                Model_File file = serviceFile.addFileReceiver(data.getText());
                serviceFile.initFile(file, data);
                ar.sendAckData(file.getFileID());
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }

        } else {
            //1. persit in the database
            Model_Receive_Message message = new Model_Receive_Message(data.getFromUserID(), data.getText(), data.getMessageType(), null, data.getTime());
            try {
                serviceChatMessage.PersistMessage(data);
            } catch (SQLException e) {
            }
            
            
            // 2.send to correpsonding people
            for (Model_Client c : listClients) {
                if (c.getUser().getUserID() == data.getToUserID()) {
                    c.getClient().sendEvent("receive_ms", message);
                    break;
                }
            }
        }
    }

    private void sendTempFileTiClient(Model_Send_Message data, Model_Receive_Image dataImage) {
        for (Model_Client c : listClients) {
            if (c.getUser().getUserID() == data.getToUserID()) {
                c.getClient().sendEvent("receive_ms", new Model_Receive_Message(data.getFromUserID(), data.getText(), data.getMessageType(), dataImage));
                break;
            }
        }
    }

}
