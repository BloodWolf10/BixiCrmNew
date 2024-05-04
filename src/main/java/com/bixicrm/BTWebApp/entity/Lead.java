/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author gavin
 */

@Entity
@Table(name="lead_")
public class Lead {
    
 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long	Id;
 
 @OneToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="Contact_id")
  private  Contact contact;
 
 @OneToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="User_id")
  private  User user;
 
 @Column(name="Lead_Status")
  private  String Status;

    public Lead() {
        
        super();
    }

    public Lead(Contact contact, User user, String Status) {
        this.contact = contact;
        this.user = user;
        this.Status = Status;
    }
 
 
 
 // Getters and Setters

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContactID(Long Contact_id) {
        if ( contact == null) {
           contact  = new Contact();
        }
        contact.setId(Contact_id);
    }

    public User getUser() {
        return user;
    }

    public void setUserID(Long User_id) {
        if ( user == null) {
           user  = new User();
        }
        user.setId(User_id);
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

  
}
