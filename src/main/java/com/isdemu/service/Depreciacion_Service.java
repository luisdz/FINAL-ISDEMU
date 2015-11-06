/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service;

import java.util.List;

/**
 *
 * @author Luis
 */
public interface Depreciacion_Service {
    public List getAll(); 
    public void aplicarDepreciacion();
    
}
