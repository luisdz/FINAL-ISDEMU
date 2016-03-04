/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TB_Ubicacion_PersonaDao;
import com.isdemu.service.TB_Ubicacion_Persona_Service;
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
public class TB_Ubicacion_Persona_ServiceImp implements TB_Ubicacion_Persona_Service {
    
    @Autowired
       private TB_Ubicacion_PersonaDao tbUbicacionPersonaDao;
    
    @Override
	public void save(Object obj) {
             System.out.println("esntra aqui GET service");
		// TODO Auto-generated method stub
		tbUbicacionPersonaDao.save(obj);
	}
        
    @Override
       public List getAll() {
            System.out.println("service impl");
               // TODO Auto-generated method stub
               return tbUbicacionPersonaDao.getAll();
       }
        

   @Override
   public Object findByKey(Serializable id) {
           // TODO Auto-generated method stub
           return tbUbicacionPersonaDao.findByKey(id);
   }
   
    @Override
         public List getAllidUbicacion(Serializable id){
         return tbUbicacionPersonaDao.getAllidUbicacion(id);
         }
         
    @Override
         public List getAllidPersona(Serializable id){
         return tbUbicacionPersonaDao.getAllidPersona(id);
         }
    
    @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbUbicacionPersonaDao.update(obj);
	}
    
}
