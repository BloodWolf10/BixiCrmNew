/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.Controllers;

import com.bixicrm.BTWebApp.entity.Contact;
import com.bixicrm.BTWebApp.service.ContactService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ContactController {
      private static final Logger logger = LogManager.getLogger(ContactController.class);
    
   @Autowired
    private ContactService contactservice;
    
    
    
  // Mapping to View All Available Clients  
    
   @GetMapping("/getContacts")
    public String getContacts(Model model)
    {
        
       try{
        model.addAttribute("contactList", contactservice.getAllContacts());
        return "viewContacts";}
       
       catch(Exception e)
       {
           logger.fatal("Unable to retrieve contact page" + e);
           return"/dashboard";
       }
    }
    
  // Mapping for all new Contacts   
    
     @GetMapping("/Contact")
    public String addContact(Model model)
    {
        
        try{
        model.addAttribute("contact",new Contact());
        return "addContact";}
        
        catch(Exception e)
        {
            logger.fatal("Unable to return contact page "+ e );
            return"/getContacts";
        }
    }
    
    
   // Mapping to Save Client Information After Successfully Adding Client and Redirect to the List of All Clients
    
    
        @PostMapping("/saveContact")
    public String saveContact(Contact contact)
    {
        try{
        contactservice.SaveOrUpdateContact(contact);
        
        return"redirect:/getContacts";}
        
        
        catch(Exception e)
        {
            logger.fatal("Unable to save contact: "+ contact.getFirstName() + "" + contact.getLastName());
            return"/getContacts";
        }
    }
    
    
    @GetMapping("/editContact/{id}")
public String editContact(@PathVariable Long id, Model model) {
    
    try{
    Contact contact = contactservice.getContactById(id);
    model.addAttribute("contact", contact);
    return "editContact";}
    
    catch(Exception e)
    {
        logger.warn("Unable to retrieve edit page" + e.getMessage() + id);
        return"/getContacts";
    }
}
    
    // To Save Edited Client 
    @PostMapping("/editSaveContact")
    public String editSaveContact( Contact contact)
    {  
        
       try{ 
         contactservice.SaveOrUpdateContact(contact);
         logger.info("Contact edited: " + contact.getId());
        return"redirect:/getContacts";}
       
       catch(Exception e)
       {
           logger.fatal("Unable to update edited Contact: "+ contact.getId() + e.getMessage());
           return"/getContacts";
       }
        
    }
    
    
    @GetMapping("/deleteContact/{id}")
    
    public String deleteContact(@PathVariable Long id, Model model)
    {
        try{
        contactservice.deleteContact(id);
        logger.info("Contact delete: ");
        return "redirect:/getContacts";}
        
        catch( Exception e)
        {
            logger.fatal("Unable to delete contact: " + id +""+ e.getMessage());
            return"/getContacts";
        }
    }
    
    
    @GetMapping("/contact/{id}")
    public String showContactDetails(@PathVariable Long id, Model model) {
 try{
    Contact contact = contactservice.getContactById(id);
    model.addAttribute("contact", contact);
    return "contact-details";} 
 
   catch(Exception e)
    {
        logger.warn("Unable to retrieve Contact page" + e.getMessage() + id);
        return"/getContacts";
    }
 
    }
    
}
