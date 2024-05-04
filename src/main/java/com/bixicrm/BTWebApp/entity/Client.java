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
import jakarta.persistence.Table;
import java.util.Date;


/**
 *
 * @author gavin
 */
@Entity
@Table(name="client_")
public class Client {

    public Client() {
        
        super();
    }
    
    

    public Client( String Firstname, String Lastname, String PhoneNumber, String Email, String Role, Date CreateDate, String CompanyName, String StreetAddress, String City, String Country, String ExpirationDate, String CardType, String AccountType, String CardNumber, String Password) {
        
      
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Role = Role;
//        this.CreateDate = CreateDate;
        this.CompanyName = CompanyName;
        this.StreetAddress = StreetAddress;
        this.City = City;
        this.Country = Country;
        this.ExpirationDate = ExpirationDate;
        this.CardType = CardType;
        this.AccountType = AccountType;
        this.CardNumber = CardNumber;
        this.Password = Password;
    }
    
    
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="Client_Firstname")
    private String Firstname;
    
    @Column(name="Client_Lastname")
    private String Lastname;
    
    @Column(name="Client_Phonenumber")
    private String PhoneNumber;
    
     @Column(name="Client_Email")
    private String Email;
     
      @Column(name="Client_Role")
    private String Role;
      
//      @Column(name="Client_Createddate")
//    private Date CreateDate;
      
       @Column(name="Client_Companyname")
    private String CompanyName;
       
        @Column(name="Client_Address_Streetaddress")
    private String StreetAddress;
        
       @Column(name="Client_Address_City") 
    private String City;
       
       @Column(name="Client_Address_Country")
    private String Country;	
       
       @Column(name="Client_Paymentinfo_Expirationdate")
    private String ExpirationDate;
       
       @Column(name="Client_Paymentinfo_Cardtype")
    private String CardType;
       
       @Column(name="Client_Paymentinfo_Accounttype")
    private String AccountType;
       
       @Column(name="Client_Paymentinfo_Cardnumber")
    private String CardNumber;
       
       @Column(name="Client_Password")
       private String Password;

       
    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String CardType) {
        this.CardType = CardType;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String FirstName) {
        this.Firstname = FirstName;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String LastName) {
        this.Lastname = LastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

//    public Date getCreateDate() {
//        return CreateDate;
//    }

//    public void setCreateDate(Date CreateDate) {
//        this.CreateDate = CreateDate;
//    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getStreetAddress() {
        return StreetAddress;
    }

    public void setStreetAddress(String StreetAddress) {
        this.StreetAddress = StreetAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

//    @Override
//    public String toString() {
//        return "Client{" + "id=" + id + ", Email=" + Email + ", Role=" + Role + ", Password=" + Password + '}';
//    }
    
    

    
}
