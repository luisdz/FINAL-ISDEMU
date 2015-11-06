/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.service.Depreciacion_Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Luis
 */
@Controller
@RequestMapping(value = "/Depreciacion")
public class DepreciacionController 

{
    @Autowired
    private Depreciacion_Service depreciacionService;
    
    @RequestMapping(value = "/consultarDepreciacion")
    public ModelAndView consultarDepreciacionPage() 
    {
        ModelAndView modelAndView = new ModelAndView("consultar_depreciacion");        
       // List movimientoR = tbrMovimientoInvService.getAll(); 
         List activos = depreciacionService.getAll();
       //  List movimientoI = tbMovimientoService.getAllInvPer();         
                  
        modelAndView.addObject("activos", activos);
        return modelAndView;
    }
    
    
    @RequestMapping(value = "/aplicarDepreciacion", method = RequestMethod.GET)
    public ModelAndView aplicadDeprec() 
    { 
         System.out.println("antes aplicardepre");   
         depreciacionService.aplicarDepreciacion();
         System.out.println("despues aplicardepre");
         return consultarDepreciacionPage();
    }
}
