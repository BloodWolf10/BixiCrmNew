/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.service;

import com.bixicrm.BTWebApp.entity.Contact;
import com.bixicrm.BTWebApp.repository.ContactDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gavin
 */

@Service
public class ContactService {
    
    @Autowired
    private ContactDAO contactdao;
   
   public List<Contact> getAllContacts()
   {
       return contactdao.findAll(); }
   
   
   public Contact SaveOrUpdateContact(Contact contact) {
       
       return contactdao.save(contact);
   }
   
   public void deleteContact(Long id)
   {
       contactdao.deleteById(id);
   }
   
 
      public Contact getContactById(Long id)
   {       
       return contactdao.findById(id).orElse(null);
   }
}
