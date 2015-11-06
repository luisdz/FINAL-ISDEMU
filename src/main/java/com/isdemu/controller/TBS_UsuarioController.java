/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;


import com.isdemu.model.TbsUsuario;

import com.isdemu.service.TBS_Usuario_Service;
import com.isdemu.service.TBS_Rol_Service;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.Barcode128;
//import com.itextpdf.text.pdf.PdfWriter;

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
 @RequestMapping(value="/Usuario")
public class TBS_UsuarioController {
    
    @Autowired
        private TBS_Rol_Service tbsRolService;
   
     @Autowired
        private TBS_Usuario_Service tbsUsuarioService;
    
     
     @RequestMapping(value="/list")
	public ModelAndView listOfPaises() {
		ModelAndView modelAndView = new ModelAndView("consultar_usuario");

		List usuario = tbsUsuarioService.getAll();
		modelAndView.addObject("usuario", usuario);

		return modelAndView;
	}
        @RequestMapping(value="/consultarPass/{usuario}", method=RequestMethod.GET)
	public ModelAndView consultarPassword(@PathVariable String usuario) {
		ModelAndView modelAndView = new ModelAndView("home");
		String clave=tbsUsuarioService.getPassword(usuario);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	} 
        
         @RequestMapping(value="/consultarRol/{usuario}", method=RequestMethod.GET)
	public ModelAndView consultarRol(@PathVariable String usuario) {
		ModelAndView modelAndView = new ModelAndView("home");
		String Rol=tbsUsuarioService.getRol(usuario);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}  
      
        
    @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPaisPage() {
              System.out.println("esntra aqui GET usuario");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		
                 
                 //List ClasAct = tbClasActService.getAll();
               List rol = tbsRolService.getAll();
               
                 //List region=tbcRegionService.getAll();
                 myModel.put("usuario", new TbsUsuario());
             
                myModel.put("rol",rol);
                // myModel.put("clasificacionA",ClasAct );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
                System.out.println("esntra aqui GET usuario");
		return new ModelAndView("usuario",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingPais(@ModelAttribute TbsUsuario usuario) {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("entra aqui POST persona"+usuario);
                
                usuario.setClave("$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.");
                usuario.setEstado(1);
                 
                tbsUsuarioService.save(usuario);
		String message = "Usuario was successfully added.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
        
        @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		tbsUsuarioService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}   
        
         @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPaisPage(@PathVariable Integer id) {

            TbsUsuario usuario = (TbsUsuario) tbsUsuarioService.findByKey(id);

             Map<String, Object> myModel = new HashMap<String, Object>();
             List rol = tbsRolService.getAll();
             myModel.put("rol",rol ); 
             myModel.put("usuario",usuario);            
             return new ModelAndView("actualizar_usuario",myModel);
	}
        
//        @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
//	public ModelAndView edditingPais(@ModelAttribute TbsUsuario usuario, @PathVariable Integer id) {
//            TbsUsuario Usuario = (TbsUsuario) tbsUsuarioService.findByKey(id);
//           ModelAndView modelAndView = new ModelAndView("home");
//
//           Usuario.setNombreUsuario(usuario.getNombreUsuario());           
//           Usuario.setApellidoUsuario(usuario.getApellidoUsuario());
//           Usuario.setTbsRol(usuario.getTbsRol());
//           
//           tbsUsuarioService.update(Usuario);
//           String message = "Persona was successfully edited.";
//           modelAndView.addObject("message", message);
//
//           return modelAndView;
//	}
//        
//       @RequestMapping(value="/codigo_barra")
//        public void codigo() throws FileNotFoundException, DocumentException {       
//       
//       Document document = new Document(new Rectangle(PageSize.A4));    
//    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/codigoBarraIsdemu.pdf"));    
//
//    document.open();
//	    document.add(new Paragraph("ISDEMU"));
//
//		    Barcode128 code128 = new Barcode128();
//		    code128.setGenerateChecksum(true);
//		    code128.setCode("61563333333");    
//
//	    document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
//            
//            code128.setCode("4545454545");  
//            document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
//    document.close();
//
//    System.out.println("Document Generated...!!!!!!");
//  
//       }
}
