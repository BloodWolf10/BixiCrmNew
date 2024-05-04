/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.Controllers;

import com.bixicrm.BTWebApp.entity.User;
import com.bixicrm.BTWebApp.service.UserService;
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
    
    @Autowired
    private UserService userservice;
    
    
    @GetMapping("/getUsers")
    public String getUsers(Model model)
    {
        
        model.addAttribute("userList", userservice.getAllUsers());
        return "viewUsers";
    }
    
    
    
    @GetMapping("/addUser")
    public String addUser(Model model)
    {
        model.addAttribute("user",new User());
        return "addUser";
    }
    
    @PostMapping("/saveUser")
    public String saveUser(User user)
    {
        userservice.SaveOrUpdateUser(user);
        
        return"redirect:/getUsers";
    }
    
  @GetMapping("/editUser/{id}")
public String editUser(@PathVariable Long id, Model model) {
    User user = userservice.getUserById(id);
    model.addAttribute("user", user);
    return "editUser";
}
    
      // To Save Edited User
    @PostMapping("/editSaveUser")
    public String editSaveUser( User user)
    {       
         userservice.SaveOrUpdateUser(user);
        
        return"redirect:/getUsers";
        
    }
    
    
        @GetMapping("/deleteUser/{id}")
    
    public String deleteUser(@PathVariable Long id, Model model)
    {
        userservice.deleteUser(id);
       
        return "redirect:/getUsers";
    }




}
