/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.healthconnect.event;

import java.io.File;

/**
 *
 * @author xyh10
 */
public interface EventFileReceiver {
    public void onReceiving(double percentage);
    public void onStartReceiving();
    public void onFinish(File file);
}
