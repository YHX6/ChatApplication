/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.healthconnect.event;

import com.healthconnect.model.Model_Receive_Message;
import com.healthconnect.model.Model_Send_Message;


/**
 *
 * @author xyh10
 */
public interface EventChat {
    public void sendMessage(Model_Send_Message data);
    
    public void receiveMessage(Model_Receive_Message data);
    
}
