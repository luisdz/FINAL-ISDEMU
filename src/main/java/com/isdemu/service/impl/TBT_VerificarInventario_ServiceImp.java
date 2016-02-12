/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBT_VerificarInventarioDao;
import com.isdemu.model.TbtVerificarInventario;
import com.isdemu.service.TBT_VerificarInventario_Service;
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
public class TBT_VerificarInventario_ServiceImp implements TBT_VerificarInventario_Service {
    
     @Autowired
	private TBT_VerificarInventarioDao tbVInventarioDao;
    
    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		tbVInventarioDao.save(obj);
	}
        
    @Override
	public List<TbtVerificarInventario> getAll() {
             System.out.println("service impl");
		// TODO Auto-generated method stub
		return tbVInventarioDao.getAll();
	}
        
         @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		tbVInventarioDao.delete(id);
	}
        
        @Override
	public List<TbtVerificarInventario> getInventarioFaltante(Serializable id) {
             System.out.println("service impl faltante");
		// TODO Auto-generated method stub
		return tbVInventarioDao.getInventarioFaltante(id);
	}
        
        @Override
	public List<TbtVerificarInventario> getInventarioSobrante(Serializable id) {
             System.out.println("service impl sobrante");
		// TODO Auto-generated method stub
		return tbVInventarioDao.getInventarioSobrante(id);
	}
        
         @Override
	public List<TbtVerificarInventario> getInventarioFaltantePersona(Serializable id) {
             System.out.println("service impl faltante");
		// TODO Auto-generated method stub
		return tbVInventarioDao.getInventarioFaltantePersona(id);
	}
        
        @Override
	public List<TbtVerificarInventario> getInventarioSobrantePersona(Serializable id) {
             System.out.println("service impl sobrante");
		// TODO Auto-generated method stub
		return tbVInventarioDao.getInventarioSobrantePersona(id);
	}
}
