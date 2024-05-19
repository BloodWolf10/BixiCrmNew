/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bixicrm.BTWebApp.repository;

import com.bixicrm.BTWebApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gavin
 */
public interface RoleDAO extends JpaRepository<Role,Integer>{
    
    Role findByName(String Name);
}
