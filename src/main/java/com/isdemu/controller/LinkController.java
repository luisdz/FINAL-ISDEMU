/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.service.TB_Descargo_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.isdemu.service.TB_Movimiento_Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jose Eduardo
 */
@Controller
public class LinkController {
  @Autowired
	private TB_Movimiento_Service tbMovimientoService;
//    
   @Autowired
	private TB_Inventario_Service tbInventarioService;
//    
    @Autowired
	private TB_Descargo_Service tbDescargoService;
    
    
    @RequestMapping(value="/")
	public ModelAndView mainPage() {
            
            Map<String, Object> myModel = new HashMap<String, Object>();
            List movimiento = tbMovimientoService.getTop();
            int registros=movimiento.size();
//           
           List inventarios = tbInventarioService.getTop();
             int registrosInv=inventarios.size();
//             
              List descargos = tbDescargoService.getAll();
             int registrosDes=descargos.size();
//             
           myModel.put("mov",movimiento );
           myModel.put("nmov",registros );
            myModel.put("inv",inventarios );
           myModel.put("ninv",registrosInv );
            myModel.put("descargo",descargos );
            myModel.put("ndeg",registrosDes );
            
         //  ModelAndView modelAndView = new ModelAndView("home");
		//modelAndView.addObject("home", movimiento);
               //System.out.println("entra al top");
		//return  modelAndView;
              return new ModelAndView("login",myModel);
	}
        
        
        @RequestMapping(value = "/protected**", method = RequestMethod.GET)
	public ModelAndView protectedPage() {
 
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security 3.2.3 Hello World");
		model.addObject("message", "This is protected page - Only for Administrators !");
		model.setViewName("protected");
 		return model;
 
	}
        
//        public ModelAndView mainPage() {
//            List movimiento = tbMovimientoService.getTop();
//            int registros=movimiento.size();
//            
//            
//            ModelAndView modelAndView = new ModelAndView("home");
//		modelAndView.addObject("home", movimiento);
//               System.out.println("entra al top");
//		return  modelAndView;
//	}
        
//     @RequestMapping(value="/loginF")
//	public ModelAndView LoginForm() {
//		return new ModelAndView("login");
//	}
        
        //Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	@RequestMapping(value="/index")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}
}
