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
import java.sql.Date;

/**
 *
 * @author gavin
 */

@Entity
@Table(name="contact_")
public class Contact{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="Contact_Firstname")
private String FirstName;

@Column(name="Contact_Lastname")
private String LastName;

@Column(name="Contact_Email")
private String Email;

@Column(name="Contact_Phonenumber")
private String PhoneNumber;

@Column(name="Contact_Createdtimedate")
private Date CreatedDated;

@Column(name="Contact_Tag")
private String	Tag;

@Column(name="Contact_Note")
private String	Note;


//@OneToOne
//@JoinColumn(name="User_id")
//private User user;
//
//@OneToOne
//@JoinColumn(name="Client_id")
//private Client client;

    public Contact() {
        super();
    }

    public Contact(String FirstName, String LastName, String Email, String PhoneNumber, Date CreatedDated, String Tag, String Note, User user, Client client) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.CreatedDated = CreatedDated;
        this.Tag = Tag;
        this.Note = Note;
//        this.user = user;
//        this.client = client;
    }








// getters and Setters

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(Long User_id) {
//        if(user==null)
//        {
//            user = new User();
//        }
//          user.setId(User_id);
//    }
//
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public Date getCreatedDated() {
        return CreatedDated;
    }

    public void setCreatedDated(Date CreatedDated) {
        this.CreatedDated = CreatedDated;
    }


   



}
