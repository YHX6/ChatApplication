/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.healthconnect.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author xyh10
 */
public class Util {
    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    public static Date toDate(String str){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
    
    public static String toDateStr(Date date){
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
    
    public static void main(String[] args) {
        System.out.println(toDateStr(new Date()));
    }
}
