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
}
