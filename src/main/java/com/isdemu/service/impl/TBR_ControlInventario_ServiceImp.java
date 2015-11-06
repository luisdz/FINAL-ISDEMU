/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.TBR_ControlInventarioDao;
import com.isdemu.service.TBR_ControlInventario_Service;
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
public class TBR_ControlInventario_ServiceImp implements TBR_ControlInventario_Service {
    @Autowired
	private TBR_ControlInventarioDao tbrcontrolInventarioDao;

    
    @Override
    public void save(Object obj) {
        tbrcontrolInventarioDao.save(obj);
    }
    
    @Override
    public Object findByKey(Serializable id) {
        return tbrcontrolInventarioDao.findByKey(id);
    }
    
    @Override
   public void delete(Serializable id) {
           // TODO Auto-generated method stub
           tbrcontrolInventarioDao.delete(id);
   }
    
}
