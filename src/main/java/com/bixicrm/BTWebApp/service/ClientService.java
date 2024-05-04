/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.service;

import com.bixicrm.BTWebApp.entity.Client;
import com.bixicrm.BTWebApp.repository.ClientDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gavin
 */

@Service
public class ClientService {
      @Autowired
    private ClientDAO clientdao;
   
   public List<Client> getAllClient()
   {
       return clientdao.findAll(); }
   
   
   public Client SaveOrUpdateClient(Client client) {
       
       return clientdao.save(client);
   }
   
   public void deleteClient(Long id)
   {
       clientdao.deleteById(id);
   }
   
//   public Client editClient(Long id)
//   {
//       Client client = clientdao.findById(id).orElse(null);
//       return clientdao.save(client);
//   }
   
   public Client getClientById(Long id)
   {       
       return clientdao.findById(id).orElse(null);
   }
}
