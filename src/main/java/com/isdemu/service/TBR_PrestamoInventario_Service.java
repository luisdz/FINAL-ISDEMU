/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service;

import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Walter
 */
public interface TBR_PrestamoInventario_Service {
    
    public void save(Object obj);
    public Object findByKey(Serializable id);
    public void delete(Serializable id);
}
