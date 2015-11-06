/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service;

import com.isdemu.model.TbInventario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jose Eduardo
 */
public interface TB_Inventario_Service {
    public void save(Object obj);
    public List<TbInventario> getAll();
    public List getTop();
    public void delete(Serializable id);
    public Object findByKey(Serializable id);
    public void update(Object obj);
    public List LastCodInventario(Serializable id);    
    public List findBycodigo(String code);
     public void ETLInv();
}
