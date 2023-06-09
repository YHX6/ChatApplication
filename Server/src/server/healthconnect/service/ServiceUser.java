/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.healthconnect.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import server.healthconnect.connection.DatabaseConnection;
import server.healthconnect.model.Model_Client;
import server.healthconnect.model.Model_Login;
import server.healthconnect.model.Model_Message;
import server.healthconnect.model.Model_Register;
import server.healthconnect.model.Model_User_Account;

/**
 *
 * @author xyh10
 */
public class ServiceUser {
    private final Connection con;
    
    public ServiceUser(){
        this.con = DatabaseConnection.getInstance().getConnection();
    }
    
    public Model_Message register(Model_Register data) {
        Model_Message message = new Model_Message();
        try {
            //check if username is occupied
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, data.getUserName());
            ResultSet r = p.executeQuery();
            if(r.next()){  // If empty, so use has exit
                message.setAction(false);
                message.setMessage("User Already Exist!");
            }else{
                message.setAction(true);
            }
            r.close();
            p.close();
            
            // insert user register
            if(message.isAction()){
                con.setAutoCommit(false);
                p = con.prepareStatement(INSER_USER, PreparedStatement.RETURN_GENERATED_KEYS);   // get user id generated by database
                p.setString(1, data.getUserName());
                p.setString(2, data.getPassword());
                p.execute();
                r = p.getGeneratedKeys();
                r.next();
                int userID = r.getInt(1);
                p.close();
                r.close();
                
                // create user aacount
                p = con.prepareStatement(INSERT_USER_ACCOUNT);
                p.setInt(1, userID);
                p.setString(2, data.getUserName());
                p.execute();
                p.close();
                con.commit();
                con.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("User Accout created!");
                message.setData(new Model_User_Account(userID, data.getUserName(), "", "profile_default.jpg", true));
            }
        } catch (SQLException e) {
            
            message.setAction(false);
            message.setMessage("Server Error!");
            System.err.println(e);
            try {
                if(con.getAutoCommit() == false){
                    con.rollback();
                    con.setAutoCommit(true);
                }
            } catch (SQLException e1) {
                System.err.println(e1);
            }
            
        }
        return message;
    }
    
    public Model_User_Account login(Model_Login login) throws Exception{
        Model_User_Account data = null;
        PreparedStatement p = con.prepareStatement(LOGIN);
        p.setString(1, login.getUserName());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        
        if(r.next()){
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            data = new Model_User_Account(userID, userName, gender, image, true);
        }
        r.close();
        p.close();
        
        return data;
    }
    
    
    public List<Model_User_Account> getUser(int exitUser) throws SQLException{
        List<Model_User_Account> list = new ArrayList<>();
        PreparedStatement p = con.prepareStatement(SELECT_USER_ACCOUNT);
        p.setInt(1, exitUser);
        ResultSet r = p.executeQuery();
        while(r.next()){
            int userID = r.getInt(1);
            String userName = r.getString(2);
            String gender = r.getString(3);
            String image = r.getString(4);
            list.add(new Model_User_Account(userID, userName, gender, image, checkUserStatus(userID))); // status is not the status in the datase
        }
        
        
        return list;
    }
    
    
    private boolean checkUserStatus(int userID){
        List<Model_Client> clients = Service.getInstance(null).getListClients();
        for(Model_Client c:clients){
            if(c.getUser().getUserID() == userID){
                return true;
            }
        }
        return false;
    }
    
    
    //sql
    private final String LOGIN = "select UserID, user_account.UserName, Gender, ImageString from `user` join user_account using(UserID) where `user`.UserName=binary(?) and `user`.Password = binary(?) and user_account.Status = '1';";
    private final String SELECT_USER_ACCOUNT = "select UserID, UserName, Gender, ImageString from user_account where user_account.Status ='1' and UserID<>?";
    private final String INSER_USER = "insert into user (UserName, `Password`) values (?, ?)";
    private final String CHECK_USER = "select UserID from user where UserName = ? limit 1";
    private final String INSERT_USER_ACCOUNT = "insert into user_account (UserID, UserName) values (?, ?)";
    
}
