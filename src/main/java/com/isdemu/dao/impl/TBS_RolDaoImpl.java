/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TBS_RolDao;
import com.isdemu.model.TbsRol;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Walter
 */
@Repository
public class TBS_RolDaoImpl implements TBS_RolDao {
    
    @Autowired
	private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

    
    @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbsRol.class);
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
        
    @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbsRol rol = (TbsRol) getCurrentSession().get(TbsRol.class, id);
		return rol;
	}
}
