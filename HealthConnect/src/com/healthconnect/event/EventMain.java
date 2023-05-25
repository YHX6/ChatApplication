/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.healthconnect.event;

import com.healthconnect.model.Model_User_Account;

/**
 *
 * @author xyh10
 */
public interface EventMain {
    
    public void showLoading(boolean show);
    
    public void initChat();
    
    public void selectUser(Model_User_Account user);
    
    public void updateUser(Model_User_Account user);
    
    public void showLoginPage();
    
}
