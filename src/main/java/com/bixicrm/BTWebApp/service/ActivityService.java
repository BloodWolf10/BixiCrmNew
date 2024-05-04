/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bixicrm.BTWebApp.service;

import com.bixicrm.BTWebApp.entity.Activity;
import com.bixicrm.BTWebApp.repository.ActivityDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gavin
 */

@Service
public class ActivityService {
    
    @Autowired
    private ActivityDAO activitydao;
   
   public List<Activity> getAllActivity()
   {
       return activitydao.findAll(); }
   
   
   public Activity addActivity(Activity activity) {
       
       return activitydao.save(activity);
   }
   
   public void deleteActivity(Long id)
   {
       activitydao.deleteById(id);
   }
   
   public Activity editActivity(Long id)
   {
        Activity activity = activitydao.findById(id).orElse(null);
       return activitydao.save(activity);
   }
}
