/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbInventario;
import com.isdemu.service.Depreciacion_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.isdemu.spring.WebAppConfig;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Luis
 */
@Controller
@RequestMapping(value = "/Depreciacion")
public class DepreciacionController extends WebAppConfig  

{
    @Autowired
    private Depreciacion_Service depreciacionService;
    
    @Autowired
	private TB_Inventario_Service tbInventarioService;
    
    @RequestMapping(value = "/consultarDepreciacion")
    public ModelAndView consultarDepreciacionPage() 
    {
        ModelAndView modelAndView = new ModelAndView("consultar_depreciacion");        
       // List movimientoR = tbrMovimientoInvService.getAll(); 
         List activos = depreciacionService.getAll();
       //  List movimientoI = tbMovimientoService.getAllInvPer();         
                  
        modelAndView.addObject("activos", activos);
        return modelAndView;
    }
    
    
    @RequestMapping(value = "/aplicarDepreciacion", method = RequestMethod.GET)
    public ModelAndView aplicadDeprec() 
    { 
         System.out.println("antes aplicardepre");   
         depreciacionService.aplicarDepreciacion();
         System.out.println("despues aplicardepre");
         return consultarDepreciacionPage();
    }
    
    //Reporte de depreciacion
        
         
       @RequestMapping(value = "/ExcelReporteInvPersona", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptAsig(HttpServletResponse response) throws JRException, IOException, SQLException, ClassNotFoundException 
  {      
      Connection conn = dataSource().getConnection();
      System.out.println(conn);    
  
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteDepreciacion.jrxml"); 
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
    System.out.println("report3 :" + jasperReport);    
        System.out.println("report3 :" + response);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    response.setContentType("application/vnd.ms-excel");
     
   response.setHeader("Content-disposition", "inline; filename=ReporteDepreciacion.xlsx");

   final OutputStream outStream = response.getOutputStream();
     
       JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();     
 }          
    //fin reporte depreciacion
  
  //lkjk
  @RequestMapping(value = "/ExcelReporteInvPersona2", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptAsig2(HttpServletResponse response) throws JRException, IOException, SQLException, ClassNotFoundException 
  {      
      Document document = new Document();
try{
    response.setContentType("application/pdf");
    PdfWriter.getInstance(document, response.getOutputStream());
    document.open();
    document.add(new Paragraph("howtodoinjava.com"));
    document.add(new Paragraph(new Date().toString()));
    //Add more content here
}catch(Exception e){
    e.printStackTrace();
}
    System.out.println("response :" + response);
    document.close();
}    
  
  //kjkj
    
    
}
