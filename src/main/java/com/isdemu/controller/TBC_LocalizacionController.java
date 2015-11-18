/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbcLocalizacion;

import com.isdemu.service.TBC_ClasificacionLocalizacion_Service;
import com.isdemu.service.TBC_Localizacion_Service;
import com.isdemu.service.TBC_Riesgo_Service;
import com.isdemu.service.TBC_Poliza_Service;

import com.isdemu.service.TB_Inventario_Service;
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
 @RequestMapping(value="/Localizacion")
public class TBC_LocalizacionController {
    
    
     @Autowired
        private TBC_Riesgo_Service tbcRiesgoService;  
     
     @Autowired
        private TBC_ClasificacionLocalizacion_Service tbcClasLocalizacionService;  
      
      @Autowired
        private TBC_Localizacion_Service tbcLocalizacionService;

    
      
     @RequestMapping(value="/list")
	public ModelAndView listOfPaises(String b) {
		ModelAndView modelAndView = new ModelAndView("consultar_localizacion");

		List localizacion = tbcLocalizacionService.getAll();
		modelAndView.addObject("localizacion", localizacion);
                modelAndView.addObject("msj",b);
		return modelAndView;
	}
        
        @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPaisPage(String p) {
              System.out.println("esntra aqui GET persona");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		
                 String message = p;
               List clasificacion_localizacion = tbcClasLocalizacionService.getAll();
               List riesgo = tbcRiesgoService.getAll();
               
                 //List region=tbcRegionService.getAll();
                myModel.put("localizacion", new TbcLocalizacion());
                myModel.put("message", message);
                myModel.put("riesgo",riesgo);
                myModel.put("clasificacion_localizacion",clasificacion_localizacion );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
                System.out.println("esntra aqui GET persona");
		return new ModelAndView("localizacion",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingPais(@ModelAttribute TbcLocalizacion localizacion) {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("entra aqui POST persona"+localizacion);
                 
                tbcLocalizacionService.save(localizacion);
		String message = "Localizacion was successfully added.";
		modelAndView.addObject("message", message);
		return addPaisPage("1");
	}
                    
        @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		tbcLocalizacionService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return listOfPaises("1");
	}
        
          @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPaisPage(@PathVariable Integer id) {
		
                TbcLocalizacion localizacion = (TbcLocalizacion) tbcLocalizacionService.findByKey(id);

                 Map<String, Object> myModel = new HashMap<String, Object>();
                 List clasificacion_localizacion = tbcClasLocalizacionService.getAll();
                 List riesgo = tbcRiesgoService.getAll();  
                 myModel.put("localizacion",localizacion ); 
                 myModel.put("riesgo",riesgo);
                myModel.put("clasificacion_localizacion",clasificacion_localizacion );
                 return new ModelAndView("actualizar_localizacion",myModel);
	}
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPais(@ModelAttribute TbcLocalizacion localizacion, @PathVariable Integer id) {
		 TbcLocalizacion Localizacion = (TbcLocalizacion) tbcLocalizacionService.findByKey(id);
		ModelAndView modelAndView = new ModelAndView("home");
   
                Localizacion.setNombreLocalizacion(localizacion.getNombreLocalizacion());
                Localizacion.setTbcClasificacionLocalizacion(localizacion.getTbcClasificacionLocalizacion());
                Localizacion.setTbcRiesgo(localizacion.getTbcRiesgo());
		tbcLocalizacionService.update(Localizacion);
                String message = "Localuizacion was successfully edited.";
		modelAndView.addObject("message", message);

		return listOfPaises("2");
	}
        
        
}
