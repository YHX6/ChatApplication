/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.service;

import com.healthconnect.event.PublicEvent;
import com.healthconnect.model.Model_User_Account;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author xyh10
 */
public class Service {
    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9812;
    private final String IP = "localhost";
    private Model_User_Account user;
    
    public static Service getInstance(){
        if(instance == null) instance = new Service();
        return instance;
    }
    
    public Service( ){
        
    }

    public Socket getClient() {
        return client;
    }
    
    public void startService(){    
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    // list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for(Object o:os){
                        Model_User_Account u = new Model_User_Account(o);
                        if(u.getUserID() != user.getUserID()){
                            users.add(u);
                        }
                        
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
            });
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
    }
    
    private void error(Exception e){
        System.err.println(e);
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }
    
}
