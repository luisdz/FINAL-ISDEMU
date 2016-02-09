/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TBC_LocalizacionDao;

import com.isdemu.model.TbcLocalizacion;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose Eduardo
 */
@Repository
public class TBC_LocalizacionDaoImpl implements  TBC_LocalizacionDao{
    @Autowired
	private SessionFactory sessionFactory;
    
    private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    
        @Override
	public List getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbcLocalizacion.class);
           
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
        
        @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		System.out.println("esntra aqui GET dao ");
		TbcLocalizacion localizacion =(TbcLocalizacion)obj;
	        getCurrentSession().save(localizacion);
	}
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbcLocalizacion localizacion = (TbcLocalizacion) getCurrentSession().get(TbcLocalizacion.class, id);
		if(localizacion!=null)
			getCurrentSession().delete(localizacion);
                        
	}
        
        @Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbcLocalizacion clasA = (TbcLocalizacion) getCurrentSession().get(TbcLocalizacion.class, id);
		return clasA;
	}
        
        @Override
        public List getAllidClasi(Serializable id){
        	
            DetachedCriteria dc = DetachedCriteria.forClass(TbcLocalizacion.class,"localizacion");            
            
            dc.createAlias("localizacion.tbcClasificacionLocalizacion", "clasi");
            dc.add(Restrictions.eq("clasi.idClasificacionLocalizacion", id));         
             
           return  dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
        }
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}
        
        @Override
	public List getRepLocalizacion(Serializable id,Serializable param02,Serializable param03) {
		// TODO Auto-generated method stub
            System.out.println("ingresa al inventario faltante");
            Session session = null;
            session = sessionFactory.getCurrentSession();
            //SQLQuery query = session.createSQLQuery("SELECT  CI.ID_INVENTARIO, I.CODIGO_INVENTARIO,CA.NOMBRE_CLASE ,I.DESCRIPCION_EQUIPO FROM TBR_CONTROL_SALIDA_INVENTARIO CI INNER JOIN TB_INVENTARIO I ON CI.ID_INVENTARIO=I.ID_INVENTARIO INNER JOIN TBC_CLASE_ACTIVO CA ON CA.ID_CLASE_ACTIVO = I.ID_CLASE_ACTIVO WHERE CI.ID_CONTROL_SALIDA ='"+id+"'");
            SQLQuery query = session.createSQLQuery("SELECT " +
"     TB_INVENTARIO.DESCRIPCION_EQUIPO AS TB_INVENTARIO_DESCRIPCION_EQUIPO, " +
"     TB_INVENTARIO.CODIGO_INVENTARIO AS TB_INVENTARIO_CODIGO_INVENTARIO, " +
"     TB_INVENTARIO.MARCA AS TB_INVENTARIO_MARCA, " +
"     TB_INVENTARIO.MODELO AS TB_INVENTARIO_MODELO, " +
"     TB_INVENTARIO.SERIE AS TB_INVENTARIO_SERIE, " +
"     TB_INVENTARIO.FECHA_ADQUISICION AS TB_INVENTARIO_FECHA_ADQUISICION, " +
"     TB_INVENTARIO.VALOR AS TB_INVENTARIO_VALOR, " +
"     TB_INVENTARIO.N_FACTURA AS TB_INVENTARIO_N_FACTURA, " +
"     TB_INVENTARIO.FINANCIAMIENTO AS TB_INVENTARIO_FINANCIAMIENTO, " +
"     TB_INVENTARIO.OBSERVACION AS TB_INVENTARIO_OBSERVACION, " +
"     TB_INVENTARIO.VALOR_LIBRO AS TB_INVENTARIO_VALOR_LIBRO, " +
"     TB_INVENTARIO.FECHA_GARANTIA AS TB_INVENTARIO_FECHA_GARANTIA, " +
"     TB_INVENTARIO.REGION AS TB_INVENTARIO_REGION, " +
"     TB_INVENTARIO.USER_INSERT AS TB_INVENTARIO_USER_INSERT, " +
"     TB_INVENTARIO.FECHA_INSERT AS TB_INVENTARIO_FECHA_INSERT, " +
"     TB_INVENTARIO.USER_UPDATE AS TB_INVENTARIO_USER_UPDATE, " +
"     TB_INVENTARIO.FECHA_UPDATE AS TB_INVENTARIO_FECHA_UPDATE, " +
"     TBC_CLASE_ACTIVO.NOMBRE_CLASE AS TBC_CLASE_ACTIVO_NOMBRE_CLASE, " +
"     TBC_PERSONA.NOMBRE_PERSONA AS TBC_PERSONA_NOMBRE_PERSONA, " +
"     TBC_UBICACION.NOMBRE_UBICACION AS TBC_UBICACION_NOMBRE_UBICACION, " +
"     asignado.NOMBRE_PERSONA AS asignado_NOMBRE_PERSONA" +
" FROM " +
" dbo.TBC_CLASE_ACTIVO TBC_CLASE_ACTIVO INNER JOIN dbo.TB_INVENTARIO TB_INVENTARIO ON TBC_CLASE_ACTIVO.ID_CLASE_ACTIVO = TB_INVENTARIO.ID_CLASE_ACTIVO " +
" INNER JOIN dbo.TBC_PERSONA TBC_PERSONA ON TB_INVENTARIO.ID_PERSONA = TBC_PERSONA.ID_PERSONA " +
" INNER JOIN dbo.TBC_UBICACION TBC_UBICACION ON TB_INVENTARIO.ID_UBICACION = TBC_UBICACION.ID_UBICACION  INNER JOIN dbo.TBC_PERSONA as asignado ON TB_INVENTARIO.ID_PERSONA_ASIGNADO = asignado.ID_PERSONA where TB_INVENTARIO.VALOR >= '"+param02+"' and   TB_INVENTARIO.ID_LOCALIZACION = '"+id+"' and TB_INVENTARIO.VALOR < '"+param03+"'");

            System.out.println("la query"+query);
            List Vinventario = query.list();
            
            return Vinventario;
	}
}
