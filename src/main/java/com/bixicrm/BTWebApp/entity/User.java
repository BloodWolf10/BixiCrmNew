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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author gavin
 */

@Entity
 @Table(name="user_")
public class User {
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name="User_Firstname")
    String FirstName;
    
    @Column(name="User_Lastname")
    String LastName;
    
    @Column(name="User_Email")
    String Email;
    
    @Column(name="User_Password")
    String Password;
    
   
//  @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Client_id")
//     Client client;

    public User() {
        super();
    }

    public User( String FirstName, String LastName, String Email, String Password, Client client) {
        
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.Password = Password;
//        this.client = client;
    }
           
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this. id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String First_Name) {
        this.FirstName = First_Name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String Last_Name) {
        this.LastName = Last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

//    public Client getClient() {
//        return client;
//    }
//
//   public void setClientID(Long Client_id) {
//        if ( client == null) {
//           client  = new Client();
//        }
//        client.setId(Client_id);
//    }
    
    
}
