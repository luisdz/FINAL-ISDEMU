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
 * @author Miranda
 */
public interface TB_Prestamo_Service {
    public void save(Object obj);
    public List getAll();
    public void delete(Serializable id);
    public Object findByKey(Serializable id);
    public List getPreInv(Serializable id);
    public void update(Object obj);
    public List LastIdPrestamo();
}
