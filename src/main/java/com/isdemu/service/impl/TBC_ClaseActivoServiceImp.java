/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBC_ClaseActivoDao;
import com.isdemu.dao.TB_InventarioDao;
import com.isdemu.service.TBC_ClaseActivo_Service;
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
public class TBC_ClaseActivoServiceImp implements TBC_ClaseActivo_Service{
    
    
    @Autowired
	private TBC_ClaseActivoDao tbClaseActivoDao;
    
    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		tbClaseActivoDao.save(obj);
	}
        
    @Override
	public List getAll() {
             System.out.println("service impl");
		// TODO Auto-generated method stub
		return tbClaseActivoDao.getAll();
	}
        
        @Override
         public List getTop(){
         return tbClaseActivoDao.getTop();
         }
         
          @Override
         public List getAllidClasi(Serializable id){
         return tbClaseActivoDao.getAllidClasi(id);
         }
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		tbClaseActivoDao.delete(id);
	}
        
        @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		return tbClaseActivoDao.findByKey(id);
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbClaseActivoDao.update(obj);
	}
         
        @Override
        public List LastCodClase(Serializable id){
                    return tbClaseActivoDao.LastCodClase(id);
        }
}
