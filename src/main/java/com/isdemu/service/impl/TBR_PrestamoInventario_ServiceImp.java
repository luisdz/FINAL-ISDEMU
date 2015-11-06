/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBR_PrestamoInventarioDao;
import com.isdemu.service.TBR_PrestamoInventario_Service;
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
public class TBR_PrestamoInventario_ServiceImp implements TBR_PrestamoInventario_Service{
    
     @Autowired
	private TBR_PrestamoInventarioDao tbrrestamoInventarioDao;

    
    @Override
    public void save(Object obj) {
        tbrrestamoInventarioDao.save(obj);
    }
    
    @Override
    public Object findByKey(Serializable id) {
        return tbrrestamoInventarioDao.findByKey(id);
    }
    
    @Override
   public void delete(Serializable id) {
           // TODO Auto-generated method stub
           tbrrestamoInventarioDao.delete(id);
   }
    
}
