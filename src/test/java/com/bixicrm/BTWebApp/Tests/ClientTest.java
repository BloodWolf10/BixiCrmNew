/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.Tests;

import com.bixicrm.BTWebApp.entity.Client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gavin
 */
public class ClientTest {
    
    
     @Test
    public void testClientConstructorAndGetters() {
        String firstname = "John";
        String lastname = "Doe";
        String phoneNumber = "1234567890";
        String email = "john.doe@example.com";
        String role = "User";
        //Date createDate = new Date();
        String companyName = "ExampleCorp";
        String streetAddress = "1234 Main St";
        String city = "Anytown";
        String country = "Anycountry";
        String expirationDate = "12/34";
        String cardType = "Visa";
        String accountType = "Credit";
        String cardNumber = "4111111111111111";
        String password = "password123";

        Client client = new Client(firstname, lastname, phoneNumber, email, role, companyName, streetAddress, city, country, expirationDate, cardType, accountType, cardNumber, password);

        assertEquals(firstname, client.getFirstname());
        assertEquals(lastname, client.getLastname());
        assertEquals(phoneNumber, client.getPhoneNumber());
        assertEquals(email, client.getEmail());
        assertEquals(role, client.getRole());
        // assertEquals(createDate, client.getCreateDate());
        assertEquals(companyName, client.getCompanyName());
        assertEquals(streetAddress, client.getStreetAddress());
        assertEquals(city, client.getCity());
        assertEquals(country, client.getCountry());
        assertEquals(expirationDate, client.getExpirationDate());
        assertEquals(cardType, client.getCardType());
        assertEquals(accountType, client.getAccountType());
        assertEquals(cardNumber, client.getCardNumber());
        assertEquals(password, client.getPassword());
    }
    
    @Test
    public void testClientSetters() {
        Client client = new Client();
        
        String firstname = "Jane";
        String lastname = "Smith";
        String phoneNumber = "0987654321";
        String email = "jane.smith@example.com";
        String role = "Admin";
        // Date createDate = new Date();
        String companyName = "AnotherCorp";
        String streetAddress = "5678 Elm St";
        String city = "Othertown";
        String country = "Othercountry";
        String expirationDate = "01/23";
        String cardType = "MasterCard";
        String accountType = "Debit";
        String cardNumber = "5500000000000004";
        String password = "password321";

        client.setFirstname(firstname);
        client.setLastname(lastname);
        client.setPhoneNumber(phoneNumber);
        client.setEmail(email);
        client.setRole(role);
        // client.setCreateDate(createDate);
        client.setCompanyName(companyName);
        client.setStreetAddress(streetAddress);
        client.setCity(city);
        client.setCountry(country);
        client.setExpirationDate(expirationDate);
        client.setCardType(cardType);
        client.setAccountType(accountType);
        client.setCardNumber(cardNumber);
        client.setPassword(password);

        assertEquals(firstname, client.getFirstname());
        assertEquals(lastname, client.getLastname());
        assertEquals(phoneNumber, client.getPhoneNumber());
        assertEquals(email, client.getEmail());
        assertEquals(role, client.getRole());
        // assertEquals(createDate, client.getCreateDate());
        assertEquals(companyName, client.getCompanyName());
        assertEquals(streetAddress, client.getStreetAddress());
        assertEquals(city, client.getCity());
        assertEquals(country, client.getCountry());
        assertEquals(expirationDate, client.getExpirationDate());
        assertEquals(cardType, client.getCardType());
        assertEquals(accountType, client.getAccountType());
        assertEquals(cardNumber, client.getCardNumber());
        assertEquals(password, client.getPassword());
    }

}
