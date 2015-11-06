/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBS_RolDao;
import com.isdemu.service.TBS_Rol_Service;
import java.util.List;
import java.io.Serializable;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Walter
 */
@Service
@Transactional
public class TBS_Rol_ServiceImp implements TBS_Rol_Service {
    
     @Autowired
       private TBS_RolDao tbRolDao;
     
     @Override
       public List getAll() {
            System.out.println("service impl");
               // TODO Auto-generated method stub
               return tbRolDao.getAll();
       }
       
       @Override
   public Object findByKey(Serializable id) {
           // TODO Auto-generated method stub
           return tbRolDao.findByKey(id);
   }
    
}
