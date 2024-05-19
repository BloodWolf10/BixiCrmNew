/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author gavin
 */

@Entity
 @Table(name="user_")
public class User implements UserDetails{
    
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Column(name="User_Firstname")
    String FirstName;
    
    @Column(name="User_Lastname")
    String LastName;
    
    @Column(name="User_Email")
    String email;
    
    @Column(name="User_Password")
    String password;
    
    
     String User2; 
   
//  @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Client_id")
//     Client client;

    public User() {
        super();
    }

    public User( String FirstName, String LastName, String Email, String Password, Client client, String User2) {
        
        this.FirstName = FirstName;
        this.LastName = LastName;
//        this.username = Username;
        this.password = Password;
        this.User2 = User2;
        this.email = Email;
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

//    public void setUsername(String Username) {
//        this.username = Username;
//    }
//
//    public String getUser2() {
//        return User2 = this.username;
//    }

//    public void setUser2(String User2) {
//        this.User2 = User2;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    
    


   @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        this.password = Password;
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
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roleList;

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
    
    
    
  
    
    
    /* UserDetails Service Method Implementations */



    @Override
    public String getUsername() {
       return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        
        for(Role role: roleList )
        {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
            authorityList.add(authority);
        }
        
        return authorityList;
    }
    
    
    
}
