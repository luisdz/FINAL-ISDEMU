/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao;

import com.isdemu.model.TbInventario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jose Eduardo
 */
public interface TB_InventarioDao {
    
    public void save(Object obj);
    public List<TbInventario> getAll();
    public void delete(Serializable id);
    public Object findByKey(Serializable id);
    public List findBycodigo(String code);
    public void update(Object obj);
    public List getTop();
    public List LastCodInventario(Serializable id);
    public void ETLInv();
}
