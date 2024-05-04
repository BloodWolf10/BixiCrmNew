/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.Controllers;

import com.bixicrm.BTWebApp.entity.Contact;
import com.bixicrm.BTWebApp.service.ContactService;
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
    
    
   @Autowired
    private ContactService contactservice;
    
    
    
  // Mapping to View All Available Clients  
    
   @GetMapping("/getContacts")
    public String getContacts(Model model)
    {
        
        model.addAttribute("contactList", contactservice.getAllContacts());
        return "viewContacts";
    }
    
  // Mapping for all new Contacts   
    
     @GetMapping("/Contact")
    public String addContact(Model model)
    {
        model.addAttribute("contact",new Contact());
        return "addContact";
    }
    
    
   // Mapping to Save Client Information After Successfully Adding Client and Redirect to the List of All Clients
    
    
        @PostMapping("/saveContact")
    public String saveContact(Contact contact)
    {
        contactservice.SaveOrUpdateContact(contact);
        
        return"redirect:/getContacts";
    }
    
    
    @GetMapping("/editContact/{id}")
public String editContact(@PathVariable Long id, Model model) {
    Contact contact = contactservice.getContactById(id);
    model.addAttribute("contact", contact);
    return "editContact";
}
    
    // To Save Edited Client 
    @PostMapping("/editSaveContact")
    public String editSaveContact( Contact contact)
    {       
         contactservice.SaveOrUpdateContact(contact);
        
        return"redirect:/getContacts";
        
    }
    
    
    @GetMapping("/deleteContact/{id}")
    
    public String deleteContact(@PathVariable Long id, Model model)
    {
        contactservice.deleteContact(id);
       
        return "redirect:/getContacts";
    }
    
}
