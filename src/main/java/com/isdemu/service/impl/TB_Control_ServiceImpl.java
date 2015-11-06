/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TB_ControlDao;
import com.isdemu.service.TB_Control_Service;
import java.util.List;
import java.io.Serializable;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Miranda
 */
@Service
@Transactional
public class TB_Control_ServiceImpl implements TB_Control_Service {
    
    @Autowired
       private TB_ControlDao tbControlDao;

    @Override
	public void save(Object obj) {
             System.out.println("esntra aqui GET service");
		// TODO Auto-generated method stub
		tbControlDao.save(obj);
	}
        
        
    @Override
         public List getConInv(Serializable id){
             System.out.println("service impl getconinv");
         return tbControlDao.getConInv(id);
         }
        
    @Override
       public List getAll() {
            System.out.println("service impl");
               // TODO Auto-generated method stub
               return tbControlDao.getAll();
       }
        
   @Override
   public void delete(Serializable id) {
           // TODO Auto-generated method stub
           tbControlDao.delete(id);
   }

   @Override
   public Object findByKey(Serializable id) {
           // TODO Auto-generated method stub
           return tbControlDao.findByKey(id);
   }
   
   @Override
         public List getInvControl(Serializable id){
             System.out.println("service impl getconinv");
         return tbControlDao.getInvControl(id);
         }
   
   @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbControlDao.update(obj);
	}
        
    @Override
    public List LastIdControl() {
        return tbControlDao.LastIdControl();
    }
}
