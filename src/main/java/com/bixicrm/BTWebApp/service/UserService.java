/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.service;

import com.bixicrm.BTWebApp.entity.User;
import com.bixicrm.BTWebApp.repository.UserDAO;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gavin
 */
@Service
public class UserService {
      @Autowired
    private UserDAO userdao;
   
   public List<User> getAllUsers()
   {
       return userdao.findAll(); }
   
   
    public User SaveOrUpdateUser(User user) {
       
       return userdao.save(user);
   }
   
   
   public void deleteUser(Long id)
   {
       userdao.deleteById(id);
   }
   

   public User getUserById(Long id)
   {       
       return userdao.findById(id).orElse(null);
   }
 
    
}
