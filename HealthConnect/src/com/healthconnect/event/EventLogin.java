/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.healthconnect.event;

import com.healthconnect.model.Model_Login;
import com.healthconnect.model.Model_Message;
import com.healthconnect.model.Model_Register;

/**
 *
 * @author xyh10
 */
public interface EventLogin {
    
    public void login(Model_Login data);
    public void register(Model_Register data, EventMessage eventMessage);
    public void goRegister();
    public void goLogin();
    
}
