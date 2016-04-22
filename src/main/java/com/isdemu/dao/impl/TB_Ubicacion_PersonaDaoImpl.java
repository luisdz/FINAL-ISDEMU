/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TB_Ubicacion_PersonaDao;

import com.isdemu.model.TbUbicacionPersona;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SQLQuery;
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
public class TB_Ubicacion_PersonaDaoImpl implements TB_Ubicacion_PersonaDao {
    
    @Autowired
	private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("esntra aqui GET dao ");
		TbUbicacionPersona ubicacionpersona =(TbUbicacionPersona)obj;
	        getCurrentSession().save(ubicacionpersona);
	}
        
        
     @Override
	public List getAll() {
	System.out.println("ingresa al getAllInvPer");
            Session session = null; 
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("select distinct p.ID_PERSONA, p.NOMBRE_PERSONA from [ActivosFijosISDEMU].[dbo].[TB_UBICACION_PERSONA] u\n" +
"  inner join [ActivosFijosISDEMU].[dbo].[TBC_PERSONA] p on u.ID_PERSONA=p.ID_PERSONA");
            List mov = query.list();
            return mov;
	}
                
       
        
	@Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbUbicacionPersona ubicacionpersona = (TbUbicacionPersona) getCurrentSession().get(TbUbicacionPersona.class, id);
		return ubicacionpersona;
	}
        
          @Override
        public List getAllidUbicacion(Serializable id){
        	
            DetachedCriteria dc = DetachedCriteria.forClass(TbUbicacionPersona.class,"ubicacionpersona");            
            
            dc.createAlias("ubicacionpersona.tbcUbicacion", "ubicacion");
            dc.add(Restrictions.eq("ubicacion.idUbicacion",id));         
             
           return  dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
        }
        
        @Override
        public List getAllidPersona(Serializable id){
        	
            DetachedCriteria dc = DetachedCriteria.forClass(TbUbicacionPersona.class,"ubicacionpersona");            
            
            dc.createAlias("ubicacionpersona.tbcPersona", "persona");
            dc.add(Restrictions.eq("persona.idPersona",id));         
             
           return  dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
        }
        
       
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}
    
}
