/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bixicrm.BTWebApp.repository;

import com.bixicrm.BTWebApp.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gavin
 */

@Repository
public interface LeadDAO extends JpaRepository<Lead,Long> {
    
}
