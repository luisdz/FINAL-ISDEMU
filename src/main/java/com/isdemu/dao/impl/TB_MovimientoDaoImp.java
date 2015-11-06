/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;


import com.isdemu.dao.TB_MovimientoDao;
import com.isdemu.model.TbInventario;


import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbrMovimientoInventario;
import com.isdemu.model.TbtVerificarInventario;
import java.io.Serializable;
import java.util.Calendar;
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
        
        @Override
	public List getTop() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbMovimiento.class,"movimiento");
            //dc.setFetchMode("TbrMovimientoInventario", FetchMode.JOIN);
            
           Date fecha_finalHoy = new Date();
           Date fecha_inicial = new Date();
           
           //restar dias a la fecha
            Calendar calendar = Calendar.getInstance();	
            calendar.setTime(fecha_finalHoy);
            calendar.add(Calendar.DAY_OF_YEAR, -7);  // numero de días a añadir, o restar en caso de días<0
            fecha_inicial=calendar.getTime();
            
           dc.add(Restrictions.between("fechaMovimiento",fecha_inicial, fecha_finalHoy));
            System.out.println("fecha inicial:"+fecha_inicial+"fecha final:"+fecha_finalHoy);

           // dc.add(Restrictions.ge("fechaMovimiento", highestDate));
           // dc.add(Restrictions.lt("fechaMovimiento", highestDate));
             
      
             
           return  dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
          
            	}
        
        @Override
	public List getMovInv(Serializable id) {
            
		
            DetachedCriteria dc = DetachedCriteria.forClass(TbrMovimientoInventario.class,"movimientoInventario");            
            
            dc.createAlias("movimientoInventario.tbMovimiento", "movi");
            dc.add(Restrictions.eq("movi.idMovimiento", id));         
             
           return  dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
          
            	}
        
        
        @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		
		TbMovimiento movimiento =(TbMovimiento)obj;
	        getCurrentSession().save(movimiento);
	}
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbMovimiento movimiento = (TbMovimiento) getCurrentSession().get(TbMovimiento.class, id);
		if(movimiento!=null)
			getCurrentSession().delete(movimiento);
	}
        
        @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbMovimiento movimiento = (TbMovimiento) getCurrentSession().get(TbMovimiento.class, id);
		return movimiento;
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}

    @Override
    public List LastIdMovimiento() {
        DetachedCriteria dc = DetachedCriteria.forClass(TbMovimiento.class,"mov");
            
             dc.addOrder(Order.desc("idMovimiento"));
          
		return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
    }

    @Override
    public List getAllInvPer() 
        {        
            System.out.println("ingresa al getAllInvPer");
            Session session = null; 
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("  \n" +
"  select TB_MOVIMIENTO.ID_MOVIMIENTO,TB_MOVIMIENTO.FECHA_MOVIMIENTO,TB_MOVIMIENTO.RAZON_CAMBIO,TBC_PERSONA.NOMBRE_PERSONA  from TB_MOVIMIENTO inner join TBC_PERSONA on  TB_MOVIMIENTO.ID_PERSONA_NUEVA=TBC_PERSONA.ID_PERSONA where [ID_MOVIMIENTO] in (select b.ID_MOVIMIENTO from [dbo].[TBR_MOVIMIENTO_INVENTARIO] as b )");
            List mov = query.list();
            return mov;
         }
        
}
