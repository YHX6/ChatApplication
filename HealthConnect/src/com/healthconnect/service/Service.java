/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.service;

import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;


/**
 *
 * @author xyh10
 */
public class Service {
    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9812;
    private final String IP = "localhost";
    
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
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
    }
    
    private void error(Exception e){
        System.err.println(e);
    }
    
}
