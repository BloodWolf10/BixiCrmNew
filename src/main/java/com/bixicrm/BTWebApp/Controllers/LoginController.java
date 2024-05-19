/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author gavin
 */

@Controller
public class LoginController {
    
        @GetMapping("/login")
    public String getLogin()
    {
        return "login";
    }
    
    
    @GetMapping("/userdash")
    public String getUserdash()
    {
        
        return "dashboard-user";
    }
   
    
}
