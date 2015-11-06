/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TB_PrestamoDao;
import com.isdemu.model.TbPrestamoEquipo;
import com.isdemu.model.TbrPrestamoEquipoInventario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
public class TB_PrestamoDaoImpl implements TB_PrestamoDao {
    
     @Autowired
	private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

    
    @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("esntra aqui GET dao ");
		TbPrestamoEquipo prestamo =(TbPrestamoEquipo)obj;
	        getCurrentSession().save(prestamo);
	}
        
        
     @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbPrestamoEquipo.class);
           // System.out.println("criteria="+dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list().get(0));
           // dc.addOrder(Order.asc("codigo_inventario"));
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
                
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbPrestamoEquipo prestamo = (TbPrestamoEquipo) getCurrentSession().get(TbPrestamoEquipo.class, id);
		if(prestamo!=null)
			getCurrentSession().delete(prestamo);
                        
	}
        
        
	@Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbPrestamoEquipo prestamo = (TbPrestamoEquipo) getCurrentSession().get(TbPrestamoEquipo.class, id);
		return prestamo;
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}
        
        
        @Override
	public List getPreInv(Serializable id) {
            
		// TODO Auto-generated method stub
               System.out.println("ingresa al inventario faltante");
            Session session = null;
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("SELECT  CI.ID_INVENTARIO, I.CODIGO_INVENTARIO,CA.NOMBRE_CLASE ,I.DESCRIPCION_EQUIPO FROM TBR_PRESTAMO_EQUIPO_INVENTARIO CI INNER JOIN TB_INVENTARIO I ON CI.ID_INVENTARIO=I.ID_INVENTARIO INNER JOIN TBC_CLASE_ACTIVO CA ON CA.ID_CLASE_ACTIVO = I.ID_CLASE_ACTIVO WHERE CI.ID_PRESTAMO_EQUIPO ='"+id+"'");
            System.out.println("la query"+query);
            List Vinventario = query.list();
            
            return Vinventario;
            }
        
        @Override
    public List LastIdPrestamo() {
        DetachedCriteria dc = DetachedCriteria.forClass(TbPrestamoEquipo.class,"pre");
            
             dc.addOrder(Order.desc("idPrestamoEquipo"));
          
		return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
    }
    
}
