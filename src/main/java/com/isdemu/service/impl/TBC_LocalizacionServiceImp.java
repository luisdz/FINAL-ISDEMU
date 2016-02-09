/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBC_LocalizacionDao;
import com.isdemu.dao.TbcClasificacionActivoDao;
import com.isdemu.service.TBC_Localizacion_Service;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose Eduardo
 */
@Service
@Transactional
public class TBC_LocalizacionServiceImp implements  TBC_Localizacion_Service{
    
    @Autowired
	private TBC_LocalizacionDao tbcLocalizacionDao;
    
    
    @Override
	public void save(Object obj) {
             System.out.println("esntra aqui GET service");
		// TODO Auto-generated method stub
		tbcLocalizacionDao.save(obj);
	}
    
    @Override
	public List getAll() {
             System.out.println("service impl");
		// TODO Auto-generated method stub
		return tbcLocalizacionDao.getAll();
	}
        
     @Override
        public void delete(Serializable id) {
                // TODO Auto-generated method stub
                tbcLocalizacionDao.delete(id);
        }
        
     @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		return tbcLocalizacionDao.findByKey(id);
	}
        
           @Override
         public List getAllidClasi(Serializable id){
         return tbcLocalizacionDao.getAllidClasi(id);
         }
         
         @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbcLocalizacionDao.update(obj);
	}
        
        @Override
         public List getRepLocalizacion(Serializable id,Serializable param02,Serializable param03){
             System.out.println("service impl getconinv");
         return tbcLocalizacionDao.getRepLocalizacion(id,param02,param03);
         }
}
