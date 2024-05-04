/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author gavin
 */

@Entity
@Table(name="activity")
public class Activity {
    
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long Id;
    
  
  @OneToOne
  @JoinColumn(name="User_id")
   private User user;
   
   @Column(name="Activity_Type")
   private String Type;
   
   @Column(name="Activity_Date")
  private Date Act_Date;
  
  @Column(name="Activity_Notes")
 private String	Notes;
 
@OneToOne
  @JoinColumn(name="Lead_id")
 private Lead lead;
 
@OneToOne
  @JoinColumn(name="Contact_id")
private Contact	contact;

    public Activity() {
        super();
    }

    public Activity(User user, String Type, Date Act_Date, String Notes, Lead lead, Contact contact) {
        this.user = user;
        this.Type = Type;
        this.Act_Date = Act_Date;
        this.Notes = Notes;
        this.lead = lead;
        this.contact = contact;
    }

  




  
  // Getters and Setters
    public long getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

   

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Date getAct_Date() {
        return Act_Date;
    }

    public void setAct_Date(Date Act_Date) {
        this.Act_Date = Act_Date;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public Lead getLeadId() {
        return lead;
    }

    public void setLeadId(Long LeadId) {
        
        if(lead == null)
        {
            lead = new Lead();
        }
        
         lead.setId(LeadId);
        
    }

    public User getUser() {
        return user;
    }

    public void setUser(Long UserId) {
        
        if(user == null)
        {
            user = new User();
        }
        
        user.setId(UserId);
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Long ContactId) {
        if (contact == null)
        {
            contact = new Contact();
        }
        
        contact.setId(ContactId);
    }

  



}
