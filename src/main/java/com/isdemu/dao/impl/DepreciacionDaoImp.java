/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao.impl;

import com.isdemu.dao.DepreciacionDao;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis
 */
@Repository
public class DepreciacionDaoImp implements DepreciacionDao
{
    @Autowired
	private SessionFactory sessionFactory;

    @Override
    public List getAll() {
        Session session = null; 
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("  \n" +
"  select inv.ID_INVENTARIO,inv.CODIGO_INVENTARIO,inv.DESCRIPCION_EQUIPO,clase.NOMBRE_CLASE,inv.FECHA_ADQUISICION, inv.VALOR, inv.VALOR_LIBRO  from TB_INVENTARIO as inv inner join TBC_CLASE_ACTIVO as clase on inv.ID_CLASE_ACTIVO=clase.ID_CLASE_ACTIVO where inv.VALOR is not null and inv.FECHA_ADQUISICION is not null and inv.VALOR >= 600\n" +
"");
            List lista = query.list();
            return lista;
    }

    @Override
    public void aplicarDepreciacion() {
        Session session = null; 
            session = sessionFactory.getCurrentSession();
            SQLQuery query = session.createSQLQuery("EXEC sp_valorEnLibros");
            query.executeUpdate();
    }
    
}
