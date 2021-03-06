/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;


import com.isdemu.model.TbsUsuario;

import com.isdemu.service.TBS_Usuario_Service;
import com.isdemu.service.TBS_Rol_Service;
import com.isdemu.model.TbInventario;
import com.isdemu.service.TBC_ClasificacionLocalizacion_Service;
import com.isdemu.service.TBC_Localizacion_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.BarcodeEAN;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Walter
 */
@Controller 
 @RequestMapping(value="/Usuario")
public class TBS_UsuarioController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    
    @Autowired
        private TBS_Rol_Service tbsRolService;
   
     @Autowired
        private TBS_Usuario_Service tbsUsuarioService;
     
     @Autowired
	private TB_Inventario_Service tbInventarioService;
     
     @Autowired
        private TBC_Localizacion_Service tbcLocalizacionService;

     @Autowired
        private TBC_ClasificacionLocalizacion_Service tbcClasificacionLocalizacionService;
     
     @RequestMapping(value="/list")
	public ModelAndView listOfPaises(String b) {
		ModelAndView modelAndView = new ModelAndView("consultar_usuario");

		List usuario = tbsUsuarioService.getAll();
		modelAndView.addObject("usuario", usuario);
                modelAndView.addObject("msj",b);
		return modelAndView;
	}
        
      @RequestMapping(value="/username", method=RequestMethod.GET)
	public @ResponseBody String listusername() {
		
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();
            
             TbsUsuario usuario_id = (TbsUsuario) tbsUsuarioService.findByNick(name).get(0);

            return usuario_id.getNombreUsuario();
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
	public ModelAndView addPaisPage(String p) {
              System.out.println("esntra aqui GET usuario");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		String message = p;
                 
                 //List ClasAct = tbClasActService.getAll();
               List rol = tbsRolService.getAll();
               
                 //List region=tbcRegionService.getAll();
                 myModel.put("usuario", new TbsUsuario());
                myModel.put("message", message);
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
                 
                String password = "123456";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

                
                usuario.setClave(hashedPassword);
                usuario.setEstado(1);
                 
                tbsUsuarioService.save(usuario);
		String message = "Usuario was successfully added.";
		modelAndView.addObject("message", message);
		return addPaisPage("1");
	}
        
        @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		tbsUsuarioService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return listOfPaises("1");
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
        
             @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPais(@ModelAttribute TbsUsuario usuario, @PathVariable Integer id) {
            TbsUsuario Usuario = (TbsUsuario) tbsUsuarioService.findByKey(id);
           ModelAndView modelAndView = new ModelAndView("home");

           Usuario.setNombreUsuario(usuario.getNombreUsuario());           
           Usuario.setApellidoUsuario(usuario.getApellidoUsuario());
           Usuario.setTbsRol(usuario.getTbsRol());
           
           tbsUsuarioService.update(Usuario);
           String message = "Persona was successfully edited.";
           modelAndView.addObject("message", message);

           return listOfPaises("2");
	}
         
         @RequestMapping(value="/codigo_barra", method=RequestMethod.POST)
        @ResponseBody public String codigo(@RequestBody String codigos) throws FileNotFoundException, DocumentException {       
       
       JSONObject array = new JSONObject(codigos);
       
       
       
        Document document = new Document();   
        
        File file = new File(this.getClass().getResource("/codigoBarraIsdemu.pdf").getFile());
    
            String absolutePath = file.getAbsolutePath(); 

            absolutePath=absolutePath.replaceAll("%20"," ");
            
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(absolutePath));    

    Rectangle one = new Rectangle(76,35);
    document.setPageSize(one);
    document.setMargins(2, 2, 2, 2);
    
    document.open();

		    Barcode128 code128 = new Barcode128();
		    code128.setGenerateChecksum(true);
       
       JSONArray object = array.getJSONArray("Inventario");
                 for(int i=0;i<object.length();i++)
                 {
                    JSONObject object2 = object.getJSONObject(i);
                  
                     //JSONArray object = array.getJSONArray("Inventario");
                    String id = object2.getString("idInv");
                    
                        
                    code128.setCode(id);
                    document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));            

                    document.newPage();
                    
                    
                   
                }    
            
    document.close();

    
    
    return "Almacenado";
  
       }
        
        
        
       @RequestMapping(value="/imprimir_codigo_barra", method=RequestMethod.GET)
       @ResponseBody public void codigo(HttpServletRequest request, HttpServletResponse response) throws  ServletException, DocumentException, IOException {       
           String pdfFileName = "codigoBarraIsdemu.pdf";
           
           File file = new File(this.getClass().getResource("/codigoBarraIsdemu.pdf").getFile());
    
            String absolutePath = file.getAbsolutePath(); 

            absolutePath=absolutePath.replaceAll("%20"," ");
		System.out.println("DIR:"+absolutePath);
            String contextPath = absolutePath;
		File pdfFile = new File(contextPath);

		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "inline; filename=" + pdfFileName);
		response.setContentLength((int) pdfFile.length());

		FileInputStream fileInputStream = new FileInputStream(pdfFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
  
       }
        
             
         @RequestMapping(value="/update_clave")
	public ModelAndView editClave() {
            
            User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String name = user.getUsername();
            
             TbsUsuario usuario_id = (TbsUsuario) tbsUsuarioService.findByNick(name).get(0);
                
            TbsUsuario usuario = (TbsUsuario) tbsUsuarioService.findByKey(usuario_id.getIdUsuario());

            Map<String, Object> myModel = new HashMap<String, Object>();

            myModel.put("usuario",usuario);            
            return new ModelAndView("actualizar_contrasena",myModel);
	}
        
         @RequestMapping(value="/update_clave/{id}", method=RequestMethod.POST)
	 public ModelAndView edditingClaves(@ModelAttribute TbsUsuario usuario, @PathVariable Integer id) {
         TbsUsuario Usuario = (TbsUsuario) tbsUsuarioService.findByKey(id);
         ModelAndView modelAndView = new ModelAndView("home");

           String password = usuario.getClave();
           BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
           String hashedPassword = passwordEncoder.encode(password);
           
           Usuario.setClave(hashedPassword);
           
           tbsUsuarioService.update(Usuario);
           String message = "Persona was successfully edited.";
           modelAndView.addObject("message", message);

           return modelAndView;
	}
         
         
          @RequestMapping(value = "/ListInventario",method=RequestMethod.GET)
            public ModelAndView ListaInventario()  
            {
               
                ModelAndView modelAndView = new ModelAndView("codigo_barra");        

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll(); 
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);        
                return new ModelAndView("codigo_barra", myModel);
            }
            
            @RequestMapping(value="/listInvFiltro", method=RequestMethod.POST) 
	public ModelAndView listInvFilto(@ModelAttribute TbInventario clasilocalizacion) {
		ModelAndView modelAndView = new ModelAndView("codigo_barra_filtro");
                int IdUbicacion=clasilocalizacion.getTbcUbicacion().getIdUbicacion();
		//List inventario = tbInventarioService.getAll();
                
               System.out.println("INGRESA CONTROLLER ListaInventario--- idLocalizacion = " + IdUbicacion);
                List inventario = tbInventarioService.getAllFiltro(IdUbicacion);
		modelAndView.addObject("inventario", inventario);

		return modelAndView;
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
