/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jose Eduardo
 */
public interface TBC_ClaseActivoDao {
     public void save(Object obj);
    public List getAll();
    public void delete(Serializable id);
    public Object findByKey(Serializable id);
    public void update(Object obj);
    public List getTop();
    public List getAllidClasi(Serializable id);
    public List LastCodClase(Serializable id);   
}
