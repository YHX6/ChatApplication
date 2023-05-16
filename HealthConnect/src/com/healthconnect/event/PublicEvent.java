/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.event;

/**
 *
 * @author xyh10
 */
public class PublicEvent {
    
    public static PublicEvent instance;
    private EventImageView eiv;
    private EventChat ec;
    private EventLogin login;
    private EventMain em;
    
    public static PublicEvent getInstance(){
        if(instance == null){
            instance = new PublicEvent();
        }
        return instance;
    }
    
    private PublicEvent(){
        
    }
    
    
    public void addEventImageView(EventImageView eiv){
        this.eiv = eiv;
    }
    
    public EventImageView getEventImageView(){
        return eiv;
    }
    
    public void addEventChat(EventChat ec){
        this.ec = ec;
    }
    
    public EventChat getEventChat(){
        return ec;
    }
    
    public void addEventLogin(EventLogin login){
        this.login = login;
    }
    
    public EventLogin getEventLogin(){
        return login;
    }
    
    public void addEventMain(EventMain em){
        this.em = em;
    }
    
    public EventMain getEventMain(){
        return em;
    }
}
