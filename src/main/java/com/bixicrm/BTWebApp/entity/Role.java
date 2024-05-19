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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author gavin
 */

@Entity
@Table(name="roles")
public class Role {
    
   @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Integer Id;  
   
   
   @Column(name="Roles")
  private String name;

    public Role() {
        super();
    }

    public Role(Integer Id, String name) {
        this.Id = Id;
        this.name = name;
    }

  
   
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getRole() {
        return name;
    }

    public void setRole(String Name) {
        this.name = Name;
    }
    
   

    
   
   
}
