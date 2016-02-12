/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.TB_InventarioDao;

import com.isdemu.model.TbInventario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
 * @author Jose Eduardo
 */
@Repository
public class TB_InventarioDaoImpl implements TB_InventarioDao {
    
        @Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
        
        @Override
	public void save(Object obj) {
		// TODO Auto-generated method stub
		
		TbInventario inventario =(TbInventario)obj;
	        getCurrentSession().save(inventario);
	}
        
        @Override
	public List<TbInventario> getAll() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbInventario.class);
           
            List<TbInventario> inventario = dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
            return inventario;
	}
        
        
        @Override
	public List<TbInventario> getAllFiltro(Serializable id) {
	
          DetachedCriteria dc = DetachedCriteria.forClass(TbInventario.class,"inv");
            dc.createAlias("inv.tbcUbicacion", "ubicacion");
            dc.add(Restrictions.eq("ubicacion.idUbicacion", id));
            List<TbInventario> inventario = dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
            return inventario;
	}
        
         @Override
	public List getTop() {
		// TODO Auto-generated method stub
            DetachedCriteria dc = DetachedCriteria.forClass(TbInventario.class);
              dc.addOrder(Order.asc("idInventario"));
              
              Date fecha_finalHoy = new Date();
           Date fecha_inicial = new Date();
           
           //restar dias a la fecha
            Calendar calendar = Calendar.getInstance();	
            calendar.setTime(fecha_finalHoy);
            calendar.add(Calendar.DAY_OF_YEAR, -7);  // numero de días a añadir, o restar en caso de días<0
            fecha_inicial=calendar.getTime();
            
           dc.add(Restrictions.between("fechaInsert",fecha_inicial, fecha_finalHoy));
            System.out.println("fecha inicial:"+fecha_inicial+"fecha final:"+fecha_finalHoy);

            
            return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
        
        @Override
        public List LastCodInventario(Serializable id){
            DetachedCriteria dc = DetachedCriteria.forClass(TbInventario.class,"inv");
            dc.createAlias("inv.tbcClaseActivo", "clase");
            dc.add(Restrictions.eq("clase.idClaseActivo", id));
             dc.addOrder(Order.desc("codigoInventario"));
          
		return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
        }
        
           @Override
        public  List getLastInserted(String cantidad){
             System.out.println("ingresa al customSQL");
            Session session = null; 
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("select top "+ cantidad +"  TB_INVENTARIO.\"DESCRIPCION_EQUIPO\" AS TB_INVENTARIO_DESCRIPCION_EQUIPO,\n" +
"     TB_INVENTARIO.\"CODIGO_INVENTARIO\" AS TB_INVENTARIO_CODIGO_INVENTARIO,\n" +
"     TB_INVENTARIO.\"MARCA\" AS TB_INVENTARIO_MARCA,\n" +
"     TB_INVENTARIO.\"MODELO\" AS TB_INVENTARIO_MODELO,\n" +
"     TB_INVENTARIO.\"SERIE\" AS TB_INVENTARIO_SERIE,\n" +
"     TB_INVENTARIO.\"FECHA_ADQUISICION\" AS TB_INVENTARIO_FECHA_ADQUISICION,\n" +
"     TB_INVENTARIO.\"VALOR\" AS TB_INVENTARIO_VALOR,\n" +
"     TB_INVENTARIO.\"N_FACTURA\" AS TB_INVENTARIO_N_FACTURA,\n" +
"     TB_INVENTARIO.\"FINANCIAMIENTO\" AS TB_INVENTARIO_FINANCIAMIENTO,\n" +
"     TB_INVENTARIO.\"OBSERVACION\" AS TB_INVENTARIO_OBSERVACION,\n" +
"     TB_INVENTARIO.\"VALOR_LIBRO\" AS TB_INVENTARIO_VALOR_LIBRO,\n" +
"     TB_INVENTARIO.\"FECHA_GARANTIA\" AS TB_INVENTARIO_FECHA_GARANTIA,\n" +
"     TB_INVENTARIO.\"REGION\" AS TB_INVENTARIO_REGION,\n" +
"     TB_INVENTARIO.\"USER_INSERT\" AS TB_INVENTARIO_USER_INSERT,\n" +
"     TB_INVENTARIO.\"FECHA_INSERT\" AS TB_INVENTARIO_FECHA_INSERT,\n" +
"     TB_INVENTARIO.\"USER_UPDATE\" AS TB_INVENTARIO_USER_UPDATE,\n" +
"     TB_INVENTARIO.\"FECHA_UPDATE\" AS TB_INVENTARIO_FECHA_UPDATE,\n" +
"     TBC_CLASE_ACTIVO.\"NOMBRE_CLASE\" AS TBC_CLASE_ACTIVO_NOMBRE_CLASE,\n" +
"     TBC_PERSONA.\"NOMBRE_PERSONA\" AS TBC_PERSONA_NOMBRE_PERSONA,\n" +
"     TBC_UBICACION.\"NOMBRE_UBICACION\" AS TBC_UBICACION_NOMBRE_UBICACION,\n" +
"     asignado.\"NOMBRE_PERSONA\" AS asignado_NOMBRE_PERSONA\n" +
"FROM\n" +
"     \"dbo\".\"TBC_CLASE_ACTIVO\" TBC_CLASE_ACTIVO INNER JOIN \"dbo\".\"TB_INVENTARIO\" TB_INVENTARIO ON TBC_CLASE_ACTIVO.\"ID_CLASE_ACTIVO\" = TB_INVENTARIO.\"ID_CLASE_ACTIVO\"\n" +
"     INNER JOIN \"dbo\".\"TBC_PERSONA\" TBC_PERSONA ON TB_INVENTARIO.\"ID_PERSONA\" = TBC_PERSONA.\"ID_PERSONA\"\n" +
"     INNER JOIN \"dbo\".\"TBC_UBICACION\" TBC_UBICACION ON TB_INVENTARIO.\"ID_UBICACION\" = TBC_UBICACION.\"ID_UBICACION\"  INNER JOIN \"dbo\".\"TBC_PERSONA\" as asignado ON TB_INVENTARIO.\"ID_PERSONA_ASIGNADO\" = asignado.\"ID_PERSONA\"\n" +
"     \n" +
"      order by [ID_INVENTARIO] desc");
            List  inventario = query.list();
            return inventario;
        }
        
        
        @Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		TbInventario inventario = (TbInventario) getCurrentSession().get(TbInventario.class, id);
		if(inventario!=null)
			getCurrentSession().delete(inventario);
	}
        
        
	@Override
	public Object findByKey(Serializable id) {
		// TODO Auto-generated method stub
		TbInventario inventario = (TbInventario) getCurrentSession().get(TbInventario.class, id);
		return inventario;
	}
        
        @Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
            System.out.println("ingresa antes de enviar con la sesion el objeto para update");
		getCurrentSession().update(obj);
	}

    @Override
    public List findBycodigo(String code) {
        DetachedCriteria dc = DetachedCriteria.forClass(TbInventario.class,"inv");
            //dc.createAlias("inv.tbcClaseActivo", "clase");
            dc.add(Restrictions.eq("inv.codigoInventario", code));
             //dc.addOrder(Order.desc("idInventario"));
             return dc.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
        }
    
     @Override
    public void ETLInv(){
        System.out.println("entra al ETL");
    Session session = null;
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("DELETE FROM ActivosFijosISDEMU.dbo.tb_descargo\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_localizacion\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tb_inventario\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_clase_activo\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_clasificacion_activo\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_poliza\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_persona\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_ubicacion\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.TBC_CLASIFICACION_LOCALIZACION\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_riesgo\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_proveedor\n" +
"DELETE FROM ActivosFijosISDEMU.dbo.tbc_estado_inventario\n" +
"\n" +
 "INSERT [ActivosFijosISDEMU].[dbo].TBC_CLASIFICACION_LOCALIZACION SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].TBC_CLASIFICACION_LOCALIZACION\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_poliza SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_poliza\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_clasificacion_activo SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_clasificacion_activo\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_clase_activo SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_clase_activo\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_riesgo SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_riesgo\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_localizacion SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_localizacion\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_ubicacion SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_ubicacion\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_persona SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_persona\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_proveedor SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_proveedor\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tbc_estado_inventario SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tbc_estado_inventario\n" +
"\n" +
"\n" +
"INSERT [ActivosFijosISDEMU].[dbo].tb_inventario SELECT *FROM [ISDEMU_PROD].[ActivosFijosISDEMU].[dbo].tb_inventario");
           query.executeUpdate();
    }

    @Override
    public List customSQL(String code) {
     System.out.println("ingresa al customSQL");
            Session session = null; 
            session = sessionFactory.getCurrentSession();
            
            
            
            SQLQuery query = session.createSQLQuery("  \n" + 
"  SELECT\n" +
"     TB_INVENTARIO.\"CODIGO_INVENTARIO\" AS TB_INVENTARIO_CODIGO_INVENTARIO,\n" +
"     TB_INVENTARIO.\"DESCRIPCION_EQUIPO\" AS TB_INVENTARIO_DESCRIPCION_EQUIPO,\n" +
"     TB_INVENTARIO.\"MARCA\" AS TB_INVENTARIO_MARCA,\n" +
"     TB_INVENTARIO.\"MODELO\" AS TB_INVENTARIO_MODELO,\n" +
"     TB_INVENTARIO.\"SERIE\" AS TB_INVENTARIO_SERIE,\n" +
"     TB_INVENTARIO.\"FECHA_ADQUISICION\" AS TB_INVENTARIO_FECHA_ADQUISICION,\n" +
"     Convert(Decimal(15,2), TB_INVENTARIO.\"VALOR\", 2) AS TB_INVENTARIO_VALOR,\n" +
"     TBC_CLASE_ACTIVO.\"NOMBRE_CLASE\" AS TBC_CLASE_ACTIVO_NOMBRE_CLASE,\n" +
"     TBC_PERSONA.\"NOMBRE_PERSONA\" AS TBC_PERSONA_NOMBRE_PERSONA,\n" +
"     TBC_UBICACION.\"NOMBRE_UBICACION\" AS TBC_UBICACION_NOMBRE_UBICACION,\n" +
"     asignado.\"NOMBRE_PERSONA\" AS asignado_NOMBRE_PERSONA,\n" +
"     TB_INVENTARIO.\"N_FACTURA\" AS TB_INVENTARIO_N_FACTURA,\n" +
"     TB_INVENTARIO.\"OBSERVACION\" AS TB_INVENTARIO_OBSERVACION,\n" +
"     Convert(Decimal(15,2), TB_INVENTARIO.\"VALOR_LIBRO\", 2) TB_INVENTARIO_VALOR_LIBRO,\n" +
"     TB_INVENTARIO.\"FECHA_GARANTIA\" AS TB_INVENTARIO_FECHA_GARANTIA,\n" +
"     TB_INVENTARIO.\"REGION\" AS TB_INVENTARIO_REGION,\n" +
"     TB_INVENTARIO.\"FINANCIAMIENTO\" AS TB_INVENTARIO_FINANCIAMIENTO\n" +
"FROM\n" +
"     \"dbo\".\"TBC_CLASE_ACTIVO\" TBC_CLASE_ACTIVO INNER JOIN \"dbo\".\"TB_INVENTARIO\" TB_INVENTARIO ON TBC_CLASE_ACTIVO.\"ID_CLASE_ACTIVO\" = TB_INVENTARIO.\"ID_CLASE_ACTIVO\"\n" +
"     INNER JOIN \"dbo\".\"TBC_PERSONA\" TBC_PERSONA ON TB_INVENTARIO.\"ID_PERSONA\" = TBC_PERSONA.\"ID_PERSONA\"\n" +
"     INNER JOIN \"dbo\".\"TBC_UBICACION\" TBC_UBICACION ON TB_INVENTARIO.\"ID_UBICACION\" = TBC_UBICACION.\"ID_UBICACION\"  INNER JOIN \"dbo\".\"TBC_PERSONA\" as asignado ON TB_INVENTARIO.\"ID_PERSONA_ASIGNADO\" = asignado.\"ID_PERSONA\" \n" +
"     "
                    + code );
            List mov = query.list();
            return mov;
    
    }
}
