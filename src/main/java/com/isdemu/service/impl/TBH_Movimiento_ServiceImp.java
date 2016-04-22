/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBH_MovimientoDao;
import com.isdemu.dao.TB_MovimientoDao;
import com.isdemu.service.TBH_Movimiento_Service;
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
public class TBH_Movimiento_ServiceImp implements TBH_Movimiento_Service {
    
    @Autowired
	private TBH_MovimientoDao tbhMovimientoDao;
    
	public List getAll() {
             System.out.println("service impl");
		// TODO Auto-generated method stub
		return tbhMovimientoDao.getAll();
	}
        
        @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
             System.out.println("service impl save"); 
		tbhMovimientoDao.save(obj);
	}
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		tbhMovimientoDao.delete(id);
	}
        
        
        
        @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		return tbhMovimientoDao.findByKey(id);
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbhMovimientoDao.update(obj);
	}

    @Override
    public List reporteHist(String code) {
    
    return tbhMovimientoDao.reporteHist(code);
    }
    
}
