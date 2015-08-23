/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TBH_MovimientoDao;
import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbhMovimiento;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AlejandroPC
 */
@Repository
public class TBH_MovimientoDaoImp implements TBH_MovimientoDao {
    @Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
        
         @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbhMovimiento.class);
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
        @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("dao impl save");
		TbhMovimiento movimiento =(TbhMovimiento)obj;
	        getCurrentSession().save(movimiento);
	}
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbhMovimiento movimiento = (TbhMovimiento) getCurrentSession().get(TbhMovimiento.class, id);
		if(movimiento!=null)
			getCurrentSession().delete(movimiento);
	}
        
        @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbhMovimiento movimiento = (TbhMovimiento) getCurrentSession().get(TbhMovimiento.class, id);
		return movimiento;
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}
        
}
