/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.service;

import com.bixicrm.BTWebApp.entity.Role;
import com.bixicrm.BTWebApp.entity.User;
import com.bixicrm.BTWebApp.repository.RoleDAO;
import com.bixicrm.BTWebApp.repository.UserDAO;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author gavin
 */
@Service
public class UserService implements UserDetailsService {
    
      @Autowired
    private final UserDAO userdao;

      
    @Autowired
    private final PasswordEncoder passwordEncoder;
      
    public UserService(UserDAO userdao, RoleDAO roledao, PasswordEncoder passwordEncoder) {
        this.userdao = userdao;
          this.passwordEncoder = passwordEncoder;
    }
      

      
   
   public List<User> getAllUsers()
   {
       return userdao.findAll(); }
   
   
    public User SaveOrUpdateUser(User user) {
        
        //encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userdao.save(user);
   }
   
   
   public void deleteUser(Long id)
   {
       userdao.deleteById(id);
   }
   

   public User getUserById(Long id)
   {       
       return userdao.findById(id).orElse(null);
   }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
          return userdao.findByEmail(email);

    }
    
     private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
        return mapRoles;
    }




 
    
}
