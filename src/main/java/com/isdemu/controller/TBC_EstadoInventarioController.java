/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;


import com.isdemu.model.TbcEstadoInventario;

import com.isdemu.service.TBC_EstadoInventario_Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Walter
 */
@Controller 
 @RequestMapping(value="/EstadoInventario")
public class TBC_EstadoInventarioController {
    
    @Autowired
        private TBC_EstadoInventario_Service tbcEstadoInventarioService;
    
    
    @RequestMapping(value="/list")
	public ModelAndView listOfPaises(String b) {
		ModelAndView modelAndView = new ModelAndView("consultar_estadoinventario");

		List estadoinventario = tbcEstadoInventarioService.getAll();
		modelAndView.addObject("estadoinventario", estadoinventario);
                modelAndView.addObject("msj",b);
		return modelAndView;
	}
        
        @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPaisPage(String p) {
              System.out.println("esntra aqui GET persona");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		
                 String message = p;
                 //List ClasAct = tbClasActService.getAll();               
                 //List region=tbcRegionService.getAll();
                myModel.put("estadoinventario", new TbcEstadoInventario());
                myModel.put("message", message); 
                // myModel.put("clasificacionA",ClasAct );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
                System.out.println("esntra aqui GET persona");
		return new ModelAndView("estadoinventario",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingPais(@ModelAttribute TbcEstadoInventario estadoinventario) {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("entra aqui POST persona"+estadoinventario);
                 
                tbcEstadoInventarioService.save(estadoinventario);
		String message = "Persona was successfully added.";
		modelAndView.addObject("message", message);
		return addPaisPage("1");
	}
        
        @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		tbcEstadoInventarioService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return listOfPaises("1");
	}
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editingEstado(@PathVariable Integer id) {
		 
		TbcEstadoInventario estadoinventario = (TbcEstadoInventario) tbcEstadoInventarioService.findByKey(id);
                  
                  Map<String, Object> myModel = new HashMap<String, Object>();
                  
                   myModel.put("estadoinventario",estadoinventario );  
		return new ModelAndView("actualizar_estadoinventario",myModel);
	}
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingEstado(@ModelAttribute TbcEstadoInventario estadoinventario, @PathVariable Integer id) {
                System.out.println("ID ACTAULIZA"+id);
		TbcEstadoInventario estadoInventario = (TbcEstadoInventario) tbcEstadoInventarioService.findByKey(id);
		ModelAndView modelAndView = new ModelAndView("home");
                
                estadoInventario.setNombreEstado(estadoinventario.getNombreEstado());
                estadoInventario.setDescripcion(estadoinventario.getDescripcion());
		tbcEstadoInventarioService.update(estadoInventario); 
		String message = "Estado Inventario was successfully edited.";
		modelAndView.addObject("message", message); 
		return listOfPaises("2");
	}
    
}
