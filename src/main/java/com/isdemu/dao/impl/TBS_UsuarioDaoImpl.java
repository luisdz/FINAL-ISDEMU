/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TBS_UsuarioDao;

import com.isdemu.model.TbsUsuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Walter
 */
@Repository
public class TBS_UsuarioDaoImpl implements TBS_UsuarioDao {
    
    @Autowired
	private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    
    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("esntra aqui GET dao ");
		TbsUsuario usuario =(TbsUsuario)obj;
	        getCurrentSession().save(usuario);
	}
        
        
     @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbsUsuario.class);
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
                
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbsUsuario usuario = (TbsUsuario) getCurrentSession().get(TbsUsuario.class, id);
		if(usuario!=null)
			getCurrentSession().delete(usuario);
                        
	}
        
        
	@Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbsUsuario usuario = (TbsUsuario) getCurrentSession().get(TbsUsuario.class, id);
		return usuario;
	}
        
        
         @Override
	public List findByNick(String usuario) {
		// TODO Auto-generated method stub
		//TbsUsuario usuario2 = (TbsUsuario) getCurrentSession().get(TbsUsuario.class, usuario);
            
                DetachedCriteria dc = DetachedCriteria.forClass(TbsUsuario.class);
                dc.add(Restrictions.eq("usuario",usuario));
                 
               System.out.println("User : "+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list());
		return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
        
        @Override
	public String getPassword(String usuario) {
		// TODO Auto-generated method stub
		//TbsUsuario usuario = (TbsUsuario) getCurrentSession().get(TbsUsuario.class, usuario);
                
                DetachedCriteria dc = DetachedCriteria.forClass(TbsUsuario.class);
                dc.add(Restrictions.eq("usuario", usuario));
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return ( (TbsUsuario)((dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list()).get(0)) ).getClave();
		//return usuario;
	}
        
        @Override
	public String getRol(String usuario) {
		// TODO Auto-generated method stub
		//TbsUsuario usuario = (TbsUsuario) getCurrentSession().get(TbsUsuario.class, usuario);
                
                DetachedCriteria dc = DetachedCriteria.forClass(TbsUsuario.class);
                dc.add(Restrictions.eq("usuario", usuario));
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return ( (TbsUsuario)((dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list()).get(0)) ).getTbsRol().getNombreRol();
		//return usuario;
	}
        
               
         @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}
}
