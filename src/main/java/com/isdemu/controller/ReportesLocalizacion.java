/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.spring.WebAppConfig;

import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbcLocalizacion;
import com.isdemu.service.TBC_ClasificacionLocalizacion_Service;
import com.isdemu.service.TBC_Localizacion_Service;
import com.isdemu.service.TBC_Persona_Service;
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
 * @author Luis
 */
@Controller
@RequestMapping(value = "/ReportesL")
public class ReportesLocalizacion extends WebAppConfig
{
     @Autowired
    private TBC_Persona_Service tbcPersonaService;
     
      @Autowired
        private TBC_ClasificacionLocalizacion_Service tbcClasificacionLocalizacionService;
      
    @Autowired
        private TBC_Localizacion_Service tbcLocalizacionService;
    
      
      
   @RequestMapping(value = "/reporteLocalizacion")
    public ModelAndView reporteAsignadoaPage()  throws JRException, IOException, SQLException, ClassNotFoundException 
    {
        ModelAndView modelAndView = new ModelAndView("reporte_inventario_localizacion");        
               
       Map<String, Object> myModel = new HashMap<String, Object>();
       
        List persona = tbcPersonaService.getAll();
        List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();        
        myModel.put("clasiLocalizacion",clasiLocalizacion);
        myModel.put("persona", persona);        
        myModel.put("movimiento", new TbMovimiento());        
         return new ModelAndView("reporte_inventario_localizacion", myModel);
    }
    
    
    
    @RequestMapping(value = "/reporteAsignado", method = RequestMethod.POST)
    @ResponseBody
    public   void reporteAsignadoa(HttpServletResponse response,@RequestBody String movi) throws ClassNotFoundException, SQLException, IOException, JRException 
    {
         
        System.out.println("esntra aqui POST reporte asignado" + movi);               
       
        System.out.println("String Json:" + movi);
        JSONObject array = new JSONObject(movi);
        JSONArray arrayPer = array.getJSONArray("Persona");         
        JSONObject objectPer = arrayPer.getJSONObject(0);         
        int persona=Integer.parseInt(objectPer.getString("id"));         
        JSONArray arrayPar = array.getJSONArray("Inventario");         
        JSONObject objectPar = arrayPar.getJSONObject(0);         
        int param01=Integer.parseInt(objectPar.getString("para01"));
        int param02 = 0;
        double param03=0;
        
        if(param01 == 1)
        {
            param02=599;
            param03=999999;
        }
        else if(param01 == 0)
        {
           param02=0;
           param03=600;
        }
        
        
       
        Connection conn = dataSource().getConnection();

        //String userName = "afi";
        //String password = "ActivoFijo$";

        //String url = "jdbc:sqlserver://192.168.10.187:1433;databaseName=ActivosFijosISDEMU";

       // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       // Connection conn = DriverManager.getConnection(url, userName, password);
//        Connection conn = dataSource().getConnection("sa","admin123");
        InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteAsignadoA.jrxml"); 
        //jasperxml = JasperCompileManager.compileReportToStream(jasperxml );

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
        //System.out.println("report entra url:"+this.getClass().getResource("/ireportPrueba04.jrxml"));      
        //InputStream jasperStream = this.getClass().getResourceAsStream("/ireportPrueba03.jrxml");    
        //System.out.println("report2 :" + jasperStream);
        Map<String,Object> params = new HashMap<>();


    
        params.put("id_localizacion", 229);
        params.put("mayor600", 599);
        params.put("menorque", 999999.00);


        //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        System.out.println("report3 :" + jasperReport);
        System.out.println("report3 :" + response);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
        //System.out.println("report4 :");
        //response.setContentType("application/x-pdf");
        //response.setContentType("application/application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "inline; filename=activoasignado.xlsx");

       final OutputStream outStream = response.getOutputStream();
    //JasperExportManager.(jasperPrint, outStream);
            //exportReportToPdfStream(jasperPrint, outStream);
     
       JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xlsx"); 
       exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outStream);
       System.out.println("parametro: " +  param01 + " persona: " + persona );
       //exporter.exportReport();            
       //-------------
    // JRXlsxExporter exporter = new JRXlsxExporter();
//     exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//     exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outStream));
//     SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
//     configuration.setOnePagePerSheet(true);
//     configuration.setDetectCellType(true);
//     configuration.setCollapseRowSpan(false);
//     exporter.setConfiguration(configuration);
            //-------------
     exporter.exportReport();   
       
       
       // return 1;
    }
    
  @RequestMapping(value = "/getReporteLocalizacion/{id}/{param}", method = RequestMethod.GET)
  @ResponseBody
     
  public void getRptAsig(HttpServletResponse response, @PathVariable Integer id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException 
  {      
    Connection conn = dataSource().getConnection();
      
    //InputStream jasperxml =  this.getClass().getResourceAsStream("/formatoMov.jrxml");
    InputStream jasperxml =  this.getClass().getResourceAsStream("/inventarioLocalizacion.jrxml"); 
    
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
     
     TbcLocalizacion localizacion = (TbcLocalizacion)tbcLocalizacionService.findByKey(id);
     
     String nombrefiltro = localizacion.getNombreLocalizacion().toUpperCase();
             
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
        
        params.put("id_localizacion", id);
        params.put("mayor600", param02);
        params.put("menorque", param03);
        params.put("tipo_valor", tipoRep);              
        params.put("inventario_de", nombrefiltro); 
        
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
     
   response.setHeader("Content-disposition", "inline; filename=inventario_localizacion.xlsx");

   final OutputStream outStream = response.getOutputStream();
    //JasperExportManager.(jasperPrint, outStream);
            //exportReportToPdfStream(jasperPrint, outStream);
     
       JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();     
       
       
       
 }
  
        @RequestMapping(value = "/verReporteLocalizacion/{id}/{param}", method = RequestMethod.GET)
	public ModelAndView detalleControlInventarioPage(@PathVariable Integer id,@PathVariable Integer param) 
        {
        System.out.println("id :" + id + " param " + param); 
        Map<String,Object> params = new HashMap<>();
//     
        int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=600;
            param03=999999.00;
        }
        else if(param == 0)
        {
           param02=0;
           param03=600.00;
        }
    
        params.put("id_localizacion", id);
        params.put("mayor600", param02);
        params.put("menorque", param03);
		//ModelAndView modelAndView = new ModelAndView("actualizar_inventario");
          
                System.out.println("Entra actualiza5");
		List con = tbcLocalizacionService.getRepLocalizacion(id,param02,param03);
               // TbcRegion activo = (TbcRegion) tbRegionService.findByKey(unidad.getTbcRegion().getIdRegion());
                System.out.println("Entra actualiza2");
                  Map<String, Object> myModel = new HashMap<String, Object>();
                   //List ClasAct = tbClasActService.getAll();  
                   myModel.put("reportLocali",con); 
                 // myModel.put("clasificacionA",activo );
                  //myModel.put("AllclasificacionA",ClasAct );
                
                  
                   System.out.println("Entra actualiza");
                //System.out.println("A ver el combo:"+inventario.getTbcClasificacionActivo().getIdClasificacionActivo()+activo.getNombreClasificacion());
		//modelAndView.addObject("inventario",inventario);
		return new ModelAndView("reporte_localizacion",myModel);
	}
    
    
}
