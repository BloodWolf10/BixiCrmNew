/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.service;


import com.bixicrm.BTWebApp.entity.Lead;
import com.bixicrm.BTWebApp.repository.LeadDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gavin
 */

@Service
public class LeadService {
    
    @Autowired
    private LeadDAO leaddao;
   
   public List<Lead> getAllLeads()
   {
       return leaddao.findAll(); }
   
   
   public Lead addLead(Lead lead) {
       
       return leaddao.save(lead);
   }
   
   public void deleteLead(Long id)
   {
       leaddao.deleteById(id);
   }
   
   public Lead editLead(Long id)
   {
       Lead lead = leaddao.findById(id).orElse(null);
       return leaddao.save(lead);
   }
    
}
