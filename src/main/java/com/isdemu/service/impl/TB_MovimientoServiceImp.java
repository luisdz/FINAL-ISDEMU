/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;


import com.isdemu.dao.TB_MovimientoDao;
import com.isdemu.service.TB_Movimiento_Service;
import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author AlejandroPC
 */

@Service
@Transactional
public class TB_MovimientoServiceImp implements TB_Movimiento_Service {
    
    @Autowired
	private TB_MovimientoDao tbMovimientoDao;
    
    
    @Override
	public List getAll() {
             System.out.println("service impl");
		// TODO Auto-generated method stub
		return tbMovimientoDao.getAll();
	}
        
         @Override
         public List getTop(){
         return tbMovimientoDao.getTop();
         }
         @Override
         public List getMovInv(Serializable id){
             System.out.println("service impl getmovinv");
         return tbMovimientoDao.getMovInv(id);
         }
         
          @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		tbMovimientoDao.save(obj);
	}
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		tbMovimientoDao.delete(id);
	}
        
        
        
        @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		return tbMovimientoDao.findByKey(id);
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbMovimientoDao.update(obj);
	}

    @Override
    public List LastIdMovimiento() {
        return tbMovimientoDao.LastIdMovimiento();
    }

    @Override
    public List getAllInvPer() {
        return tbMovimientoDao.getAllInvPer();
    }
}