/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbInventario;
import com.isdemu.model.TbcClasificacionActivo;
import com.isdemu.model.TbcPersona;
import com.isdemu.model.TbcPoliza;

import com.isdemu.service.TBC_ClasificacionActivo_Service;
import com.isdemu.service.TBC_Poliza_Service;
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
 * @author AlejandroPC
 */


@Controller 
 @RequestMapping(value="/Poliza")
public class TBC_PolizaController {
    
    @Autowired
	private TBC_Poliza_Service tbPolizaService;
    @Autowired
        private TBC_ClasificacionActivo_Service tbClasActService;
    
    //************consultar*********************
    @RequestMapping(value="/consultarPoli")
	public ModelAndView consultarPolizas(String b) 
        {
		ModelAndView modelAndView = new ModelAndView("consultar_poliza");

		List poliza = tbPolizaService.getAll();
		modelAndView.addObject("poliza", poliza);
                modelAndView.addObject("msj",b);

		return modelAndView;
	}
        
        
     //*************Insertar**************
        @RequestMapping(value="/insertarPoliza", method=RequestMethod.GET)
	public ModelAndView addPoliza(String b) {
              System.out.println("esntra aqui GET poliza");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		String message = b;
                 myModel.put("message", message); 
               
                 myModel.put("poliza", new TbcPoliza());
               
                
		return new ModelAndView("poliza",myModel);
	}
        
        
        @RequestMapping(value="/insertarPoliza", method=RequestMethod.POST)
	public ModelAndView addingPoliza(@ModelAttribute TbcPoliza poliza) {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("entra aqui POST poliza"+poliza);
 
		tbPolizaService.save(poliza);
		String message = "Poliza was successfully added.";
		modelAndView.addObject("message", message);
		return addPoliza("1");
	}
        
        @RequestMapping(value="/deletePoliza/{id}", method=RequestMethod.GET)
	public ModelAndView deletePoliz(@PathVariable Integer id) 
        {
		ModelAndView modelAndView = new ModelAndView("home");
		tbPolizaService.delete(id);
		String message = "poliza was successfully deleted.";
		modelAndView.addObject("message", message);
		return consultarPolizas("1");
	}
        
        @RequestMapping(value="/editPoliza/{id}", method=RequestMethod.GET)
	public ModelAndView editPolizaPage(@PathVariable Integer id) {
		 
		TbcPoliza poliza = (TbcPoliza) tbPolizaService.findByKey(id);
                  
                  Map<String, Object> myModel = new HashMap<String, Object>();
                  
                   myModel.put("poliza",poliza );  
		return new ModelAndView("actualizar_poliza",myModel);
	}

	@RequestMapping(value="/editPoliza/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPoliza(@ModelAttribute TbcPoliza poliza, @PathVariable Integer id) {
            
		TbcPoliza polizaActual = (TbcPoliza) tbPolizaService.findByKey(id);
		ModelAndView modelAndView = new ModelAndView("home");
                
                polizaActual.setCodigoPoliza(poliza.getCodigoPoliza());
                polizaActual.setFechaInicio(poliza.getFechaInicio());
                polizaActual.setFechaFin(poliza.getFechaFin());
                polizaActual.setNombrePoliza(poliza.getNombrePoliza()); 
		tbPolizaService.update(polizaActual); 
		String message = "poliza was successfully edited.";
		modelAndView.addObject("message", message); 
		return consultarPolizas("2");
	}
        
        
    
}