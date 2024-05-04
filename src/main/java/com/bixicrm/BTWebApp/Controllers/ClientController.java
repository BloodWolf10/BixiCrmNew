/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.Controllers;

import com.bixicrm.BTWebApp.entity.Client;
import com.bixicrm.BTWebApp.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author gavin
 */

@Controller
public class ClientController {
    
    private static final Logger logger = LogManager.getLogger(ClientController.class);
    
    @Autowired
    private ClientService clientservice;
    
    
    
  // Mapping to View All Available Clients  
    
   @GetMapping("/getClients")
    public String getClient(Model model)
    {
        try{
        model.addAttribute("clientList", clientservice.getAllClient());
        return "viewClients"; }
        
        catch(Exception e)
        {
            logger.fatal("Unable to retrieve client list" + e);
            return"/";
        }
       
    }
    
  // Mapping for all new Clients to Register   
    
     @GetMapping("/register")
    public String addClient(Model model)
    {
       try{
        model.addAttribute("client",new Client());
        return "ClientRegistration"; }
       
       catch(Exception e)
       {
           logger.warn("Unable to retrieve client page" + e);
           return"/";
       }
    }
    
    
   // Mapping to Save Client Information After Successfully Adding Client and Redirect to the List of All Clients
    
    
        @PostMapping("/saveClient")
    public String saveClient(Client client)
    {
        try{
        clientservice.SaveOrUpdateClient(client);
        logger.info("Client Added"+client);
         return"redirect:/getClients";
        }
        
        catch(Exception e)
        {
            logger.fatal("Unable to Save Client Information" + e + client);
            return"/";
        }
       
    }
    
    
    // To Get Clients Info to Edit
    
//    @GetMapping("/editClient/{id}")
//    public String editClient(@PathVariable Long id, Model model)
//    {
//        model.addAttribute("client", clientservice.getClientById(id));
//        
//        return"editClient";
//    }
    
//    
    @GetMapping("/editClient/{id}")
public String editClient(@PathVariable Long id, Model model) {
    
    
    Client client = clientservice.getClientById(id);
 try{
    model.addAttribute("client", client);
    return "editClient";}
    
    catch(Exception e)
    {
        logger.fatal("Unable to Edit Client"+ e+client);
        return"/";
    }
}
    
    // To Save Edited Client 
    @PutMapping("/editSaveClient")
    public String editSaveClient(@ModelAttribute Client client)
    {    
        try{
         clientservice.SaveOrUpdateClient(client); 
        
        return"redirect:/getClients"; }
        
        catch(Exception e)
                {
                   logger.fatal("Unable to Update Client"+e+client);
                    return"/";
                }
        
    }
    
    
    @GetMapping("/deleteClient/{id}")
    
    public String deleteClient(@PathVariable Long id, Model model)
    {
       try{
        clientservice.deleteClient(id);
       
        return "redirect:/getClients"; }
       
       catch(Exception e)
       {
           logger.fatal("Unable to Delete Client"+e+id);
           return"/";
       }
    } 
    
}
