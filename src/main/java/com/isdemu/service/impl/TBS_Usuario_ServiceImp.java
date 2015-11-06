/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBS_UsuarioDao;
import com.isdemu.model.TbsUsuario;
import com.isdemu.service.TBS_Usuario_Service;
import java.util.List;
import java.io.Serializable;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
/**
 *
 * @author Walter
 */
@Service
@Transactional
public class TBS_Usuario_ServiceImp implements TBS_Usuario_Service {
    
       @Autowired
       private TBS_UsuarioDao tbUsuarioDao;
       
       @Override
	public void save(Object obj) {
             System.out.println("esntra aqui GET service");
		// TODO Auto-generated method stub
		tbUsuarioDao.save(obj);
	}
        
    @Override
       public List getAll() {
            System.out.println("service impl");
               // TODO Auto-generated method stub
               return tbUsuarioDao.getAll();
       }
        
   @Override
   public void delete(Serializable id) {
           // TODO Auto-generated method stub
           tbUsuarioDao.delete(id);
   }

   @Override
   public Object findByKey(Serializable id) {
           // TODO Auto-generated method stub
           return tbUsuarioDao.findByKey(id);
   }
   
    @Override
   public List findByNick(String usuario) {
           // TODO Auto-generated method stub
           return tbUsuarioDao.findByNick(usuario);
   }
   
   @Override
   public String getPassword(String usuario) {
           // TODO Auto-generated method stub
           return tbUsuarioDao.getPassword(usuario);
   }
   
   @Override
   public String getRol(String usuario) {
           // TODO Auto-generated method stub
           return tbUsuarioDao.getRol(usuario);
   }
   
         
    @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbUsuarioDao.update(obj);
	}
    
}
