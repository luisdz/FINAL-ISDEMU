/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbInventario;
import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbtVerificarInventario;
import com.isdemu.service.TBC_ClasificacionLocalizacion_Service;
import com.isdemu.service.TBC_Persona_Service;
import com.isdemu.service.TBT_VerificarInventario_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.isdemu.spring.WebAppConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jose Eduardo
 */
@Controller 
 @RequestMapping(value="/VerificarInventario")
public class TBT_VerificarInventarioController  extends WebAppConfig{
     @Autowired
	private TB_Inventario_Service tbInventarioService;
    
    @Autowired
        private TBC_ClasificacionLocalizacion_Service tbcClasificacionLocalizacionService;
     
     @Autowired
        private TBT_VerificarInventario_Service tbcVerificarInventarioService;
     
     @Autowired
        private TBC_Persona_Service tbcPersonaService;
     
        @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView VInventario() {
             
		//ModelAndView modelAndView = new ModelAndView("inventario");
                 Map<String, Object> myModel = new HashMap<String, Object>();
		List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                 myModel.put("verificarInventario", new TbInventario());
                 myModel.put("clasiLocalizacion",clasiLocalizacion);
                 
                
		return new ModelAndView("verificarInventario",myModel);
	}
        
        
         //Agregar a la tabla temporal los inventarios para luego ser comparados
        @RequestMapping(value="/add/agregarTBTemporal", method=RequestMethod.POST)
	public @ResponseBody List<Object> InsertandoMismoCodigo(@RequestBody String inventario) {
		ModelAndView modelAndView = new ModelAndView("home");
		System.out.println("String Json:" + inventario);
                 
                 JSONObject array = new JSONObject(inventario);
                 System.out.println("Object Array:" + array);
                 JSONArray object = array.getJSONArray("Inventario");
                 System.out.println("Object JsonArray:" + object);
                 JSONObject object2 = object.getJSONObject(0);
                  System.out.println("Object2:" + object2);
                 String idLocalizacion = object2.getString("idlocalizacion");
                
                 //Convertir el idClase a int
                 int idLocalizacionInt=Integer.parseInt(idLocalizacion);
                
                 System.out.println("localizacion:" + idLocalizacionInt);
                 
               
                
                for (int i = 0; i < object.length(); i++) 
                {
                    JSONObject ObjInv = object.getJSONObject(i);
                    System.out.println("objeto for"+ObjInv);
                    TbtVerificarInventario Vinv=new TbtVerificarInventario();
                                   
                    String codigoStr=ObjInv.getString("codigo");
                     Vinv.setCodigoInventario(codigoStr);
                    
                     String idInv=ObjInv.getString("idInv");
                     int idInvInteger=Integer.parseInt(idInv);
                     Vinv.setIdInventario(idInvInteger);
                     
                    Vinv.setIdLocalizacion(idLocalizacionInt);
                    tbcVerificarInventarioService.save(Vinv);
                }
                
               List<TbtVerificarInventario> InventarioFaltante= tbcVerificarInventarioService.getInventarioFaltante(idLocalizacionInt);
               List<TbtVerificarInventario> InventarioSobrante= tbcVerificarInventarioService.getInventarioSobrante(idLocalizacionInt);
               
               //tbcVerificarInventarioService.delete(1);
               // tbInventarioService.save(inventario);
                String message = "Pais was successfully added.";
                
               List<Object> newList = new ArrayList<Object>();
               newList.add(InventarioFaltante);
               newList.add(InventarioSobrante);
               System.out.println("la 1 "+newList.get(0));
                System.out.println("la 2 "+newList.get(1));
                System.out.println("la 2 listas en una"+newList);
                modelAndView.addObject("message", message);
                return newList;
	}
        
        
        @RequestMapping(value="/consultar/{id}", method=RequestMethod.GET)
	public ModelAndView consultarVerificarInventario(@PathVariable Integer id) {
		//ModelAndView modelAndView = new ModelAndView("actualizar_inventario");
		TbInventario inventario = (TbInventario) tbInventarioService.findByKey(id);
              //  TbcClasificacionActivo activo = (TbcClasificacionActivo) tbClasActService.findByKey(inventario.getTbcClasificacionActivo().getIdClasificacionActivo());
                
                  Map<String, Object> myModel = new HashMap<String, Object>();
                 //  List ClasAct = tbClasActService.getAll();  
                 //  List persona=tbcPersonaService.getAll();
                //   List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                   myModel.put("inventario",inventario ); 
            
                  // myModel.put("persona",persona);
               //   myModel.put("clasiLocalizacion",clasiLocalizacion);
               //   myModel.put("AllclasificacionA",ClasAct );
                
                //System.out.println("A ver el combo:"+inventario.getTbcClasificacionActivo().getIdClasificacionActivo()+activo.getNombreClasificacion());
		//modelAndView.addObject("inventario",inventario);
		return new ModelAndView("consultar_verificar_inventario",myModel);
	}
        
        
            
    @RequestMapping(value = "/ReporteVerificarFaltante/{id}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvFalt(HttpServletResponse response, @PathVariable Integer id)  throws JRException, IOException, SQLException, ClassNotFoundException 
  {      

    Connection conn = dataSource().getConnection();
      
    InputStream jasperxml =  this.getClass().getResourceAsStream("/vfaltante.jrxml"); 
   
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
   
    Map<String,Object> params = new HashMap<>();
    
   int b = id;
  
    params.put("id", b);
   //File file = new File("resources/Logo.jpg");
    File file = new File(this.getClass().getResource("/Logo.jpg").getFile());
    
   String absolutePath = file.getAbsolutePath(); 
   
   absolutePath = absolutePath.replaceAll("%20"," ");
   
   params.put("realpath",absolutePath);
   System.out.println("reportURL :" + absolutePath); 
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    //System.out.println("report4 :");
    //response.setContentType("application/x-pdf");
    response.setContentType("application/vnd.ms-excel");
     
   response.setHeader("Content-disposition", "inline; filename=InvFaltante.xlsx");

   final OutputStream outStream = response.getOutputStream();
   JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "C:\\Rpt01.xls"); 
      exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();
       
       
       
       
 }
  
    @RequestMapping(value = "/ReporteVerificarSobrante/{id}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvSobre(HttpServletResponse response, @PathVariable Integer id)  throws JRException, IOException, SQLException, ClassNotFoundException 
  {      

    Connection conn = dataSource().getConnection();
      
    InputStream jasperxml =  this.getClass().getResourceAsStream("/vsobrante.jrxml"); 
   
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
   
    Map<String,Object> params = new HashMap<>();
    
   int b = id;
  
    params.put("id", b);
   //File file = new File("resources/Logo.jpg");
    File file = new File(this.getClass().getResource("/Logo.jpg").getFile());
    
   String absolutePath = file.getAbsolutePath(); 
   
   absolutePath = absolutePath.replaceAll("%20"," ");
   
   params.put("realpath",absolutePath);
   System.out.println("reportURL :" + absolutePath); 
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    //System.out.println("report4 :");
    //response.setContentType("application/x-pdf");
    response.setContentType("application/vnd.ms-excel");
     
   response.setHeader("Content-disposition", "inline; filename=InvSobrante.xlsx");

   final OutputStream outStream = response.getOutputStream();
   JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "C:\\Rpt01.xls"); 
      exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();
       
       
       
       
 }
  
  
   //Agregar a la tabla temporal los inventarios para luego ser comparados
        @RequestMapping(value="/deleteTBTemporal",  method = RequestMethod.GET)
	public ModelAndView deletetbt() {
		tbcVerificarInventarioService.delete(1);
                return VInventario();
              
	}
        
        
        
        //------------------------CODIGO PARA VERIFICAR INVENTARIO POR PERSONA-------------------------------------
         @RequestMapping(value="/addinvperona", method=RequestMethod.GET)
	public ModelAndView VInventarioPerona() {
             
		//ModelAndView modelAndView = new ModelAndView("inventario");
                 Map<String, Object> myModel = new HashMap<String, Object>();
		List persona=tbcPersonaService.getAll();
                 myModel.put("verificarinv_persona", new TbInventario());
                 myModel.put("persona",persona);
                 
                
		return new ModelAndView("verificarinv_persona",myModel);
	}
        
        
        
         //Agregar a la tabla temporal los inventarios para luego ser comparados
        @RequestMapping(value="/add/agregarTBTemporalPersona", method=RequestMethod.POST)
	public @ResponseBody List<Object> InsertandoMismoCodigoPersona(@RequestBody String inventario) {
		ModelAndView modelAndView = new ModelAndView("home");
		System.out.println("String Json:" + inventario);
                 
                 JSONObject array = new JSONObject(inventario);
                 System.out.println("Object Array:" + array);
                 JSONArray object = array.getJSONArray("Inventario");
                 System.out.println("Object JsonArray:" + object);
                 JSONObject object2 = object.getJSONObject(0);
                  System.out.println("Object2:" + object2);
                 String idLocalizacion = object2.getString("idlocalizacion");
                
                 //Convertir el idClase a int
                 int idLocalizacionInt=Integer.parseInt(idLocalizacion);
                
                 System.out.println("persona:" + idLocalizacionInt);
                 
               
                
                for (int i = 0; i < object.length(); i++) 
                {
                    JSONObject ObjInv = object.getJSONObject(i);
                    System.out.println("objeto for"+ObjInv);
                    TbtVerificarInventario Vinv=new TbtVerificarInventario();
                                   
                    String codigoStr=ObjInv.getString("codigo");
                     Vinv.setCodigoInventario(codigoStr);
                    
                     String idInv=ObjInv.getString("idInv");
                     int idInvInteger=Integer.parseInt(idInv);
                     Vinv.setIdInventario(idInvInteger);
                     
                    Vinv.setIdLocalizacion(idLocalizacionInt);
                    tbcVerificarInventarioService.save(Vinv);
                }
                
               List<TbtVerificarInventario> InventarioFaltante= tbcVerificarInventarioService.getInventarioFaltantePersona(idLocalizacionInt);
               List<TbtVerificarInventario> InventarioSobrante= tbcVerificarInventarioService.getInventarioSobrantePersona(idLocalizacionInt);
               
               //tbcVerificarInventarioService.delete(1);
               // tbInventarioService.save(inventario);
                String message = "Pais was successfully added.";
                
               List<Object> newList = new ArrayList<Object>();
               newList.add(InventarioFaltante);
               newList.add(InventarioSobrante);
               System.out.println("la 1 "+newList.get(0));
                System.out.println("la 2 "+newList.get(1));
                System.out.println("la 2 listas en una"+newList);
                modelAndView.addObject("message", message);
                return newList;
	}
        
        
                 
    @RequestMapping(value = "/ReporteVerificarFaltantePersona/{id}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvFaltPersona(HttpServletResponse response, @PathVariable Integer id)  throws JRException, IOException, SQLException, ClassNotFoundException 
  {      

    Connection conn = dataSource().getConnection();
      
    InputStream jasperxml =  this.getClass().getResourceAsStream("/vfaltantepersona.jrxml"); 
   
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
   
    Map<String,Object> params = new HashMap<>();
    
   int b = id;
  
    params.put("id", b);
   //File file = new File("resources/Logo.jpg");
    File file = new File(this.getClass().getResource("/Logo.jpg").getFile());
    
   String absolutePath = file.getAbsolutePath(); 
   
   absolutePath = absolutePath.replaceAll("%20"," ");
   
   params.put("realpath",absolutePath);
   System.out.println("reportURL :" + absolutePath); 
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    //System.out.println("report4 :");
    //response.setContentType("application/x-pdf");
    response.setContentType("application/vnd.ms-excel");
     
   response.setHeader("Content-disposition", "inline; filename=InvFaltante.xlsx");

   final OutputStream outStream = response.getOutputStream();
   JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "C:\\Rpt01.xls"); 
      exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();
       
       
       
       
 }
  
    @RequestMapping(value = "/ReporteVerificarSobrantePersona/{id}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvSobrePersona(HttpServletResponse response, @PathVariable Integer id)  throws JRException, IOException, SQLException, ClassNotFoundException 
  {      

    Connection conn = dataSource().getConnection();
      
    InputStream jasperxml =  this.getClass().getResourceAsStream("/vsobrantepersona.jrxml"); 
   
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
   
    Map<String,Object> params = new HashMap<>();
    
   int b = id;
  
    params.put("id", b);
   //File file = new File("resources/Logo.jpg");
    File file = new File(this.getClass().getResource("/Logo.jpg").getFile());
    
   String absolutePath = file.getAbsolutePath(); 
   
   absolutePath = absolutePath.replaceAll("%20"," ");
   
   params.put("realpath",absolutePath);
   System.out.println("reportURL :" + absolutePath); 
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    //System.out.println("report4 :");
    //response.setContentType("application/x-pdf");
    response.setContentType("application/vnd.ms-excel");
     
   response.setHeader("Content-disposition", "inline; filename=InvSobrante.xlsx");

   final OutputStream outStream = response.getOutputStream();
   JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "C:\\Rpt01.xls"); 
      exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();
       
       
       
       
 }
  
        
  
        
}
