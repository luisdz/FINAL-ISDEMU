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
import com.isdemu.service.TBC_Ubicacion_Service;
import com.isdemu.service.TBC_Persona_Service;
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
 @RequestMapping(value="/Persona")
public class TBC_PersonaController {
    
    @Autowired
	private TB_Inventario_Service tbInventarioService;
    @Autowired
        private TBC_Poliza_Service tbPolizaService;
    
    @Autowired
        private TBC_ClasificacionActivo_Service tbClasActService;
    
     @Autowired
        private TBC_Persona_Service tbcPersonaService;
   
     @Autowired
        private TBC_Ubicacion_Service tbcUbicacionService;
      
     @RequestMapping(value="/list")
	public ModelAndView listOfPaises(String b) {
		ModelAndView modelAndView = new ModelAndView("consultar_personal");

		List personal = tbcPersonaService.getAll();
		modelAndView.addObject("persona", personal);
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
               List ubicacion = tbcUbicacionService.getAll();
               
                 //List region=tbcRegionService.getAll();
                 myModel.put("persona", new TbcPersona());
                 myModel.put("message", message); 
                myModel.put("ubicacion",ubicacion);
                // myModel.put("clasificacionA",ClasAct );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
                System.out.println("esntra aqui GET persona");
		return new ModelAndView("persona",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingPais(@ModelAttribute TbcPersona persona) {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("entra aqui POST persona"+persona);
                 
                tbcPersonaService.save(persona);
		String message = "Persona was successfully added.";
		modelAndView.addObject("message", message);
		return addPaisPage("1");
	}
        
        @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		tbcPersonaService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return listOfPaises("1");
	}   
        
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPaisPage(@PathVariable Integer id) {

            TbcPersona persona = (TbcPersona) tbcPersonaService.findByKey(id);

             Map<String, Object> myModel = new HashMap<String, Object>();
             List ubicacion = tbcUbicacionService.getAll();
             myModel.put("ubicacion",ubicacion ); 
             myModel.put("persona",persona);            
             return new ModelAndView("actualizar_persona",myModel);
	}
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPais(@ModelAttribute TbcPersona persona, @PathVariable Integer id) {
            TbcPersona Persona = (TbcPersona) tbcPersonaService.findByKey(id);
           ModelAndView modelAndView = new ModelAndView("home");

           Persona.setNombrePersona(persona.getNombrePersona());           
           Persona.setJefatura(persona.getJefatura());
           Persona.setEncargadoAfijo(persona.getEncargadoAfijo());
           Persona.setTbcUbicacion(persona.getTbcUbicacion());
           
           tbcPersonaService.update(Persona);
           String message = "Persona was successfully edited.";
           modelAndView.addObject("message", message);

           return listOfPaises("2");
	}
    
}
