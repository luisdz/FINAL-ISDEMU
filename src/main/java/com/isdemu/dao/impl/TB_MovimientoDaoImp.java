/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;


import com.isdemu.dao.TB_MovimientoDao;


import com.isdemu.model.TbMovimiento;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author AlejandroPC
 */


@Repository
public class TB_MovimientoDaoImp implements TB_MovimientoDao {
    
     @Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
        
        
        @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbMovimiento.class);
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
}