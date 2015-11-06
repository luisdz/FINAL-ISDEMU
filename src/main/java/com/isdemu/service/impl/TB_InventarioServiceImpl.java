/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TB_InventarioDao;
import com.isdemu.model.TbInventario;
import com.isdemu.service.TB_Inventario_Service;
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
public class TB_InventarioServiceImpl implements TB_Inventario_Service {
    
    @Autowired
	private TB_InventarioDao tbInventarioDao;
    
    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		tbInventarioDao.save(obj);
	}
        
    @Override
	public List<TbInventario> getAll() {
             System.out.println("service impl");
		// TODO Auto-generated method stub
		return tbInventarioDao.getAll();
	}
        
        @Override
         public List getTop(){
         return tbInventarioDao.getTop();
         }
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		tbInventarioDao.delete(id);
	}
        
        @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		return tbInventarioDao.findByKey(id);
	}
        
        @Override
        public List LastCodInventario(Serializable id){
                    return tbInventarioDao.LastCodInventario(id);
        }
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		tbInventarioDao.update(obj);
	}

    @Override
    public List findBycodigo(String code) {
    return tbInventarioDao.findBycodigo(code);    
    }
    
     @Override
    public void ETLInv(){
    tbInventarioDao.ETLInv();
    }
}
