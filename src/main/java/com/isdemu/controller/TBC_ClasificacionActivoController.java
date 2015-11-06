/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbcClasificacionActivo;
import com.isdemu.service.TBC_ClasificacionActivo_Service;
import com.isdemu.service.TBC_Poliza_Service;
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
 * @author Jose Eduardo
 */

@Controller 
@RequestMapping(value="/ClasificacionActivo")
public class TBC_ClasificacionActivoController {
    
    //DECLARACION DE VARIABLES
     @Autowired
      private TBC_ClasificacionActivo_Service tbcClasificacionAService;
     
     @Autowired
      private TBC_Poliza_Service tbcPolizaService;
     
     
    
     @RequestMapping(value="/insertarClasificacion", method=RequestMethod.GET)
      public ModelAndView IngresarClasificacion(String b) {
        
            Map<String, Object> myModel = new HashMap<String, Object>();
            List poliza = tbcPolizaService.getAll();
            myModel.put("clasificacionA", new TbcClasificacionActivo());
            myModel.put("poliza",poliza );
            String message = b;
            myModel.put("message", message); 
              return new ModelAndView("clasificacion_activo",myModel);
        }
      
    @RequestMapping(value="/insertarClasificacion", method=RequestMethod.POST)
      public ModelAndView IngresandoClasificacion(@ModelAttribute TbcClasificacionActivo ClasificacionActivo) {
        
            ModelAndView modelAndView = new ModelAndView("home");
            
            tbcClasificacionAService.save(ClasificacionActivo);
        
              return  IngresarClasificacion("1");
        }
      
      @RequestMapping(value="/listaClasificacion")
	public ModelAndView ConsultarClase() {
        
            ModelAndView modelAndView = new ModelAndView("consultar_clasificacionactivo");
            List ClasificacionesActivos =tbcClasificacionAService.getAll();
            modelAndView.addObject("clasiA", ClasificacionesActivos);
        
            return modelAndView;
        }
        
        @RequestMapping(value="/eliminarClasificacion/{id}", method=RequestMethod.GET)
	public ModelAndView eliminarClase(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		tbcClasificacionAService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return ConsultarClase();
	}
        
         @RequestMapping(value="/actualizarClasificacion/{id}", method=RequestMethod.GET)
	public ModelAndView editPaisPage(@PathVariable Integer id) {
		
                TbcClasificacionActivo clasificacionactivo = (TbcClasificacionActivo) tbcClasificacionAService.findByKey(id);

                 Map<String, Object> myModel = new HashMap<String, Object>();
                 List poliza = tbcPolizaService.getAll();  
                 myModel.put("clasificacionA",clasificacionactivo ); 
                 myModel.put("poliza",poliza );
                 return new ModelAndView("actualizar_clasificacionactivo",myModel);
	}
        
        @RequestMapping(value="/actualizarClasificacion/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPais(@ModelAttribute TbcClasificacionActivo clasiA, @PathVariable Integer id) {
		 TbcClasificacionActivo clasificacionactivoActual = (TbcClasificacionActivo) tbcClasificacionAService.findByKey(id);
		ModelAndView modelAndView = new ModelAndView("home");
                clasificacionactivoActual.setNombreClasificacion(clasiA.getNombreClasificacion());
                clasificacionactivoActual.setCodigoClasificacion(clasiA.getCodigoClasificacion());
                clasificacionactivoActual.setTbcPoliza(clasiA.getTbcPoliza());
		tbcClasificacionAService.update(clasificacionactivoActual);
                String message = "Pais was successfully edited.";
		modelAndView.addObject("message", message);

		return ConsultarClase();
	}
}
