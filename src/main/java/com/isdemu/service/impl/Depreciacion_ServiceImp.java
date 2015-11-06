/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.dao.DepreciacionDao;
import com.isdemu.service.Depreciacion_Service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Luis
 */
@Service
@Transactional
public class Depreciacion_ServiceImp implements Depreciacion_Service {
    @Autowired
	private DepreciacionDao depreciaciondao;
    
    @Override
    public List getAll() {
        return depreciaciondao.getAll();
    }

    @Override
    public void aplicarDepreciacion() {
        System.out.println("aplicardepre service imp");  
       depreciaciondao.aplicarDepreciacion();
    }
    
}
