/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.event;

import com.healthconnect.model.Model_Send_Message;
import java.util.List;

/**
 *
 * @author xyh10
 */
public interface EventInitChatMessage {
    public void initChatMessages(List<Model_Send_Message> messages);
}
