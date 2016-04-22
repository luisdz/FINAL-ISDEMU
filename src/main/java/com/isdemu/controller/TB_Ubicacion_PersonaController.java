/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;


import com.isdemu.model.TbUbicacionPersona;

import com.isdemu.service.TB_Ubicacion_Persona_Service;
import com.isdemu.service.TBC_Ubicacion_Service;
import com.isdemu.service.TBC_Persona_Service;

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
 @RequestMapping(value="/UbicacionPersona")
public class TB_Ubicacion_PersonaController {
    
    @Autowired
        private TB_Ubicacion_Persona_Service tbcUbicacionPersonaService;
    
    @Autowired
        private TBC_Persona_Service tbcPersonaService;
   
     @Autowired
        private TBC_Ubicacion_Service tbcUbicacionService;
    
     @RequestMapping(value="/list_ubicacion/{id}")
	public ModelAndView listUbicacionPersona(String b, @PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("consultar_ubicacionpersona_id");

		List ubicacionpersona = tbcUbicacionPersonaService.getAllidPersona(id);
		modelAndView.addObject("ubicacionpersona", ubicacionpersona);
                modelAndView.addObject("msj",b);
		return modelAndView;
	}
        
    @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addUbicacionPersona(String p) {
              System.out.println("esntra aqui GET persona");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		
                 String message = p;
                 //List ClasAct = tbClasActService.getAll();
               List ubicacion = tbcUbicacionService.getAll();
               List persona = tbcPersonaService.getAll();
               
                 //List region=tbcRegionService.getAll();
                 myModel.put("ubicacionpersona", new TbUbicacionPersona());
                 myModel.put("message", message); 
                myModel.put("ubicacion",ubicacion);
                myModel.put("persona",persona);
                // myModel.put("clasificacionA",ClasAct );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
                System.out.println("esntra aqui GET persona");
		return new ModelAndView("ubicacionpersona",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addUbicacionPersona(@ModelAttribute TbUbicacionPersona ubicacionpersona) {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("entra aqui POST persona"+ubicacionpersona);
                 
                tbcUbicacionPersonaService.save(ubicacionpersona);
		String message = "Persona was successfully added.";
		modelAndView.addObject("message", message);
		return addUbicacionPersona("1");
	}
        
        @RequestMapping(value="/list")
	public ModelAndView listOfPaises(String b) {
		ModelAndView modelAndView = new ModelAndView("consultar_ubicacionpersona");

		List personal = tbcUbicacionPersonaService.getAll();
		modelAndView.addObject("persona", personal);
                modelAndView.addObject("msj",b);
		return modelAndView;
	}
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPaisPage(@PathVariable Integer id) {

            TbUbicacionPersona ubicacionpersona = (TbUbicacionPersona) tbcUbicacionPersonaService.findByKey(id);

             Map<String, Object> myModel = new HashMap<String, Object>();
             List ubicacion = tbcUbicacionService.getAll();
             myModel.put("ubicacion",ubicacion );
             List persona = tbcPersonaService.getAll();
             myModel.put("persona",persona );
             myModel.put("ubicacionpersona",ubicacionpersona);            
             return new ModelAndView("actualizar_ubicacionpersona",myModel);
	}
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPais(@ModelAttribute TbUbicacionPersona ubicacionpersona, @PathVariable Integer id) {
            TbUbicacionPersona UbiacionPersona = (TbUbicacionPersona) tbcUbicacionPersonaService.findByKey(id);
           ModelAndView modelAndView = new ModelAndView("home");

           UbiacionPersona.setTbcPersona(ubicacionpersona.getTbcPersona());           
           UbiacionPersona.setJefatura(ubicacionpersona.getJefatura());
           UbiacionPersona.setEncargadoAfijo(ubicacionpersona.getEncargadoAfijo());
           UbiacionPersona.setTbcUbicacion(ubicacionpersona.getTbcUbicacion());
           
           tbcUbicacionPersonaService.update(UbiacionPersona);
           String message = "Persona was successfully edited.";
           modelAndView.addObject("message", message);

           return listOfPaises("2");
	}
     
}
