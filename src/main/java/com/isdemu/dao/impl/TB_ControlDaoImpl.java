/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TB_ControlDao;

import com.isdemu.model.TbControlSalida;
import com.isdemu.model.TbrControlSalidaInventario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Miranda
 */
@Repository
public class TB_ControlDaoImpl implements TB_ControlDao{
    
@Autowired
	private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

    
    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("esntra aqui GET dao ");
		TbControlSalida control =(TbControlSalida)obj;
	        getCurrentSession().save(control);
	}
        
        
     @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbControlSalida.class);
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
                
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbControlSalida control = (TbControlSalida) getCurrentSession().get(TbControlSalida.class, id);
		if(control!=null)
			getCurrentSession().delete(control);
                        
	}
        
        
	@Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbControlSalida persona = (TbControlSalida) getCurrentSession().get(TbControlSalida.class, id);
		return persona;
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}
        
        
        @Override
	public List getConInv(Serializable id) {
            
		System.out.println("Entra actualiza3");
            DetachedCriteria dc = DetachedCriteria.forClass(TbrControlSalidaInventario.class,"controlInventario");            
            
            dc.createAlias("controlInventario.tbControlSalida", "cont");
            dc.add(Restrictions.eq("cont.idControlSalida", id));         
             System.out.println("Entra actualiza4");
           return  dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
          
            	}
        
       
	   @Override
	public List getInvControl(Serializable id) {
		// TODO Auto-generated method stub
               System.out.println("ingresa al inventario faltante");
            Session session = null;
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("SELECT  CI.ID_INVENTARIO, I.CODIGO_INVENTARIO,CA.NOMBRE_CLASE ,I.DESCRIPCION_EQUIPO FROM TBR_CONTROL_SALIDA_INVENTARIO CI INNER JOIN TB_INVENTARIO I ON CI.ID_INVENTARIO=I.ID_INVENTARIO INNER JOIN TBC_CLASE_ACTIVO CA ON CA.ID_CLASE_ACTIVO = I.ID_CLASE_ACTIVO WHERE CI.ID_CONTROL_SALIDA ='"+id+"'");
            System.out.println("la query"+query);
            List Vinventario = query.list();
            
            return Vinventario;
	}
        
        
        @Override
        public List LastIdControl() {
            DetachedCriteria dc = DetachedCriteria.forClass(TbControlSalida.class,"con");

                 dc.addOrder(Order.desc("idControlSalida"));

                    return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
        }
    
}
