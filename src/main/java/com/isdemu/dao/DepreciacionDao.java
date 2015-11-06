/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.dao;

import java.util.List;

/**
 *
 * @author Luis
 */
public interface DepreciacionDao 
{
    public List getAll();
    public void aplicarDepreciacion();
}
