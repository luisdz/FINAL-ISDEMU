/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TBC_PersonaDao;

import com.isdemu.model.TbcPersona;
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
 * @author Jose Eduardo
 */
@Repository
public class TBC_PersonaDaoImpl implements TBC_PersonaDao{
    @Autowired
	private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

    
    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("esntra aqui GET dao ");
		TbcPersona persona =(TbcPersona)obj;
	        getCurrentSession().save(persona);
	}
        
        
     @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbcPersona.class);
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
                
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbcPersona persona = (TbcPersona) getCurrentSession().get(TbcPersona.class, id);
		if(persona!=null)
			getCurrentSession().delete(persona);
                        
	}
        
        
	@Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbcPersona persona = (TbcPersona) getCurrentSession().get(TbcPersona.class, id);
		return persona;
	}
        
          @Override
        public List getAllidUbicacion(Serializable id){
        	
            DetachedCriteria dc = DetachedCriteria.forClass(TbcPersona.class,"persona");            
            
            dc.createAlias("persona.tbcUbicacion", "ubicacion");
            dc.add(Restrictions.eq("ubicacion.idUbicacion",id));         
             
           return  dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
        }
        
         @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}
        
       
}
