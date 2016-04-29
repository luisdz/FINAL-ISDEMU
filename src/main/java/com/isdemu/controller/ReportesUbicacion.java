/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.spring.WebAppConfig;

import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbcUbicacion;
import com.isdemu.service.TBC_ClasificacionLocalizacion_Service;
import com.isdemu.service.TBC_Localizacion_Service;
import com.isdemu.service.TBC_Persona_Service;
import com.isdemu.service.TBC_Ubicacion_Service;
import com.isdemu.spring.WebAppConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
//import net.sf.jasperreports.export.SimpleExporterInput;
//import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
//import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
//import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
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
 * @author Walter
 */
@Controller
@RequestMapping(value = "/ReportesU")
public class ReportesUbicacion extends WebAppConfig{
    
    @Autowired
    private TBC_ClasificacionLocalizacion_Service tbcClasificacionLocalizacionService;
      
    @Autowired
    private TBC_Localizacion_Service tbcLocalizacionService;
    
    @Autowired
    private TBC_Ubicacion_Service tbcUbicacionService;
    
    @RequestMapping(value = "/reporteUbicacion")
    public ModelAndView reporteAsignadoaPage()  throws JRException, IOException, SQLException, ClassNotFoundException 
    {
               
       Map<String, Object> myModel = new HashMap<String, Object>();
       
        List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();        
        myModel.put("clasiLocalizacion",clasiLocalizacion);       
        myModel.put("movimiento", new TbMovimiento());        
         return new ModelAndView("reporte_inventario_ubicacion", myModel);
    }
    
  @RequestMapping(value = "/getReporteUbicacion/{id}/{param}", method = RequestMethod.GET)
  @ResponseBody     
  public void getRptAsig(HttpServletResponse response, @PathVariable Integer id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException 
  {      
    Connection conn = dataSource().getConnection();
      
    //InputStream jasperxml =  this.getClass().getResourceAsStream("/formatoMov.jrxml");
    InputStream jasperxml =  this.getClass().getResourceAsStream("/inventarioUbicacion.jrxml"); 
    
    //jasperxml = JasperCompileManager.compileReportToStream(jasperxml );
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    //System.out.println("report entra url:"+this.getClass().getResource("/ireportPrueba04.jrxml"));      
    //InputStream jasperStream = this.getClass().getResourceAsStream("/ireportPrueba03.jrxml");    
    //System.out.println("report2 :" + jasperStream);
    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
   System.out.println("id :" + id + " param " + param); 
     String tipoRep="";
//     
     
     TbcUbicacion ubicacion = (TbcUbicacion)tbcUbicacionService.findByKey(id);
     
     String nombrefiltro = ubicacion.getNombreUbicacion().toUpperCase();
             
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=600;
            param03=999999.00;
            tipoRep="MAYORES DE $600.00";
        }
        else if(param == 0)
        {
           param02=0;
           param03=600.00;
           tipoRep="MENORES DE $600.00";
        }
    
        File file = new File(this.getClass().getResource("/Logo.jpg").getFile());
        String absolutePath = file.getAbsolutePath();    
        absolutePath = absolutePath.replaceAll("%20"," ");   
        params.put("realpath",absolutePath);
        
        params.put("id_ubicacion", id);
        params.put("mayor600", param02);
        params.put("menorque", param03);
        params.put("tipo_valor", tipoRep);              
        params.put("ubicacion_de", nombrefiltro); 
        
        Date fecha = new Date();
        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("MMMMM yyyy");
        String fech = dt1.format(fecha).toUpperCase();
        System.out.println("format "+fech);
        
        params.put("fecha_reporte", fech);  
    
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);    
        System.out.println("report3 :" + response);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    //System.out.println("report4 :");
    //response.setContentType("application/x-pdf");
    response.setContentType("application/vnd.ms-excel");
     
   response.setHeader("Content-disposition", "inline; filename=inventario_ubicacion.xlsx");

   final OutputStream outStream = response.getOutputStream();
    //JasperExportManager.(jasperPrint, outStream);
            //exportReportToPdfStream(jasperPrint, outStream);
     
       JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();     
       
       
       
 }
    
}
