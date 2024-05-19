/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.Controllers;

import com.bixicrm.BTWebApp.entity.User;
import com.bixicrm.BTWebApp.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gavin
 */

@Controller
public class UserController {
    
      private static final Logger logger = LogManager.getLogger(UserController.class);
    
    @Autowired
    private UserService userservice;
    
    
    @GetMapping("/getUsers")
    public String getUsers(Model model)
    {
        
        try{
        model.addAttribute("userList", userservice.getAllUsers());
        return "viewUsers"; }
        
        catch(Exception e)
        {
            logger.warn("Unable to Retrieve user list" + e );
            return"/";
        }
    }
 
    
    @GetMapping("/addUser")
    public String addUser(Model model)
    {
       try{
        model.addAttribute("user",new User());
        return "addUser"; }
       
       catch(Exception e)
       {
           logger.fatal("Unable to Retrieve User Form"+e);
           return"/";
       }
    }
    
    @PostMapping("/saveUser")
    public String saveUser(User user)
    {
        
        
        userservice.SaveOrUpdateUser(user);
        
        try{
        logger.info("User added: " + user);
        return"redirect:/getUsers"; }
        
        catch(Exception e)
        {
            logger.fatal("Unable to Save User to Database" + e + user.getId());
            return"/";
        }
    }
    
  @GetMapping("/editUser/{id}")
public String editUser(@PathVariable Long id, Model model) {
    
     User user = userservice.getUserById(id);
   try{
   
    model.addAttribute("user", user);
    return "editUser"; }
   
   catch(Exception E)
   {
       logger.fatal("Unable to Retrieve User Edit Page" + E + user);
       return"/";
   }
}
    
      // To Save Edited User
    @PostMapping("/editSaveUser")
    public String editSaveUser( User user)
    { 
       try{
         userservice.SaveOrUpdateUser(user);
        logger.info("User edited: "+user.getId());
        return"redirect:/getUsers";}
       
       catch(Exception e)
       {
           logger.fatal("Unable to Save Edited User" + e + user);
           return"/";
       }
        
    }
    
    
        @GetMapping("/deleteUser/{id}")
    
    public String deleteUser(@PathVariable Long id, Model model)
    {
        
       try{
        userservice.deleteUser(id);
       
        return "redirect:/getUsers"; }
       
       catch(Exception e)
       {
       
       logger.fatal("Deleting User failed" + e + id);
       return"/";
       }
       
    }




}
