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
 * @author Walter
 */
public interface TBR_PrestamoInventarioDao {
   
    public void save(Object obj);
    public Object findByKey(Serializable id);
    public void delete(Serializable id);
}
