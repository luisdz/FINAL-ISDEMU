/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbcLocalizacion;
import com.isdemu.model.TbcUbicacion;

import com.isdemu.service.TBC_Localizacion_Service;
import com.isdemu.service.TBC_Ubicacion_Service;

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
 @RequestMapping(value="/Ubicacion")
public class TBC_UbicacionController {
    
    @Autowired
        private TBC_Localizacion_Service tbcLocalizacionService;
    
    @Autowired
        private TBC_Ubicacion_Service tbcUbicacionService;
    
    @RequestMapping(value="/list")
	public ModelAndView listOfPaises(String b) {
		ModelAndView modelAndView = new ModelAndView("consultar_ubicacion");

		List ubicacion = tbcUbicacionService.getAll();
		modelAndView.addObject("ubicacion", ubicacion);
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
               List localizacion = tbcLocalizacionService.getAll();
               
                 //List region=tbcRegionService.getAll();
                myModel.put("ubicacion", new TbcUbicacion());             
                myModel.put("localizacion",localizacion);
                 myModel.put("message", message); 
                // myModel.put("clasificacionA",ClasAct );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
                System.out.println("esntra aqui GET persona");
		return new ModelAndView("ubicacion",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingPais(@ModelAttribute TbcUbicacion ubicacion) {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("entra aqui POST persona"+ubicacion);
                 
                tbcUbicacionService.save(ubicacion);
		String message = "Persona was successfully added.";
		modelAndView.addObject("message", message);
		return addPaisPage("1");
	}
        
        @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		tbcUbicacionService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return listOfPaises("1");
	}
        
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPaisPage(@PathVariable Integer id) {

            TbcUbicacion ubicacion = (TbcUbicacion) tbcUbicacionService.findByKey(id);

             Map<String, Object> myModel = new HashMap<String, Object>();
             List localizacion = tbcLocalizacionService.getAll();  
             myModel.put("ubicacion",ubicacion ); 
             myModel.put("localizacion",localizacion);            
             return new ModelAndView("actualizar_ubicacion",myModel);
	}
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPais(@ModelAttribute TbcUbicacion ubicacion, @PathVariable Integer id) {
            TbcUbicacion Ubicacion = (TbcUbicacion) tbcUbicacionService.findByKey(id);
           ModelAndView modelAndView = new ModelAndView("home");

           Ubicacion.setNombreUbicacion(ubicacion.getNombreUbicacion());           
           Ubicacion.setTbcLocalizacion(ubicacion.getTbcLocalizacion());
           tbcUbicacionService.update(Ubicacion);
           String message = "Ubicacion was successfully edited.";
           modelAndView.addObject("message", message);

           return listOfPaises("2");
	}
}
