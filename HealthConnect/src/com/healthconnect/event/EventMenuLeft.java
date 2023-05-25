/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.event;

import com.healthconnect.model.Model_User_Account;
import java.util.List;

/**
 *
 * @author xyh10
 */
public interface EventMenuLeft {
    public void newUser(List<Model_User_Account> users);
    public void UserConnect(int userID);
    public void userDisconnect(int userID);
    public void clearMenuLeft();
}
