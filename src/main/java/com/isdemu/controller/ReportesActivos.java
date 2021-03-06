/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbInventario;
import com.isdemu.model.TbcLocalizacion;
import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbcClaseActivo;
import com.isdemu.model.TbcPersona;
import com.isdemu.model.TbhMovimiento;
import com.isdemu.service.TBC_ClaseActivo_Service;
import com.isdemu.service.TBC_ClasificacionLocalizacion_Service;
import com.isdemu.service.TBC_Localizacion_Service;
import com.isdemu.service.TBC_Persona_Service;
import com.isdemu.service.TBH_Movimiento_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.isdemu.spring.WebAppConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
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
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping(value = "/Reportes")
public class ReportesActivos extends WebAppConfig
{
    
     @Autowired
    private TBC_Persona_Service tbcPersonaService;
     
      @Autowired
        private TBC_ClasificacionLocalizacion_Service tbcClasificacionLocalizacionService;
      
      @Autowired
	private TB_Inventario_Service tbInventarioService;
      
      @Autowired
	private TBC_ClaseActivo_Service tbcClaseService;
      
      @Autowired
      private TBH_Movimiento_Service tbhMovimientoService;
      
      @Autowired 
      private TBC_Localizacion_Service tbLocalizacionService;
      
      
    
      
      
   @RequestMapping(value = "/reporteAsignadoa")
    public ModelAndView reporteAsignadoaPage()  throws JRException, IOException, SQLException, ClassNotFoundException 
    {
        
        ModelAndView modelAndView = new ModelAndView("reporte_activo_asignado");        
               
       Map<String, Object> myModel = new HashMap<String, Object>();
       
        List persona = tbcPersonaService.getAll();
        List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();        
        myModel.put("clasiLocalizacion",clasiLocalizacion);
        myModel.put("persona", persona);        
        myModel.put("movimiento", new TbMovimiento());        
         return new ModelAndView("reporte_activo_asignado", myModel);
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
        
        
       
//        String userName = "sa";
//        String password = "admin123";
        //String url = "jdbc:sqlserver://DESKTOP-78K7A51:1433;databaseName=ActivosFijosISDEMU";
        
        //String userName = "afi";
      //  String password = "ActivoFijo$";
       // String url = "jdbc:sqlserver://192.168.10.187:1433;databaseName=ActivosFijosISDEMU";
       // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       Connection conn = dataSource().getConnection("sa","admin123");
       System.out.println(conn);

        InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteAsignadoA.jrxml"); 
        //jasperxml = JasperCompileManager.compileReportToStream(jasperxml );

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
        //System.out.println("report entra url:"+this.getClass().getResource("/ireportPrueba04.jrxml"));      
        //InputStream jasperStream = this.getClass().getResourceAsStream("/ireportPrueba03.jrxml");    
        //System.out.println("report2 :" + jasperStream);
        Map<String,Object> params = new HashMap<>();


    
        params.put("idpersona", 229);
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
    
       @RequestMapping(value = "/getReporteAsignado/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptAsig(HttpServletResponse response, @PathVariable Integer id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException 
  {      
   // String userName = "sa";
   // String password = "admin123";

   // String url = "jdbc:sqlserver://DESKTOP-78K7A51:1433;databaseName=ActivosFijosISDEMU";

    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   // Connection conn = DriverManager.getConnection(url, userName, password);
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
      
    //InputStream jasperxml =  this.getClass().getResourceAsStream("/formatoMov.jrxml");
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteAsignadoA.jrxml"); 
    
    //jasperxml = JasperCompileManager.compileReportToStream(jasperxml );
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    //System.out.println("report entra url:"+this.getClass().getResource("/ireportPrueba04.jrxml"));      
    //InputStream jasperStream = this.getClass().getResourceAsStream("/ireportPrueba03.jrxml");    
    //System.out.println("report2 :" + jasperStream);
    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
   System.out.println("id :" + id + " param " + param); 
     String tipoRep="";
     
     TbcPersona pers=(TbcPersona)tbcPersonaService.findByKey(id);   
     String nombrefiltro="ASIGNADO A " + pers.getNombrePersona().toUpperCase();
    
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("idpersona", id);
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
     
   response.setHeader("Content-disposition", "inline; filename=InventarioPorPersona.xlsx");

   final OutputStream outStream = response.getOutputStream();
    //JasperExportManager.(jasperPrint, outStream);
            //exportReportToPdfStream(jasperPrint, outStream);
     
       JRXlsxExporter exporter = new JRXlsxExporter();
    
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       
       exporter.exportReport();     
       
       
       
 }
  
  //*************************Vistas previas reportes
  
  //********************Reporte por persona****************************************************
  @RequestMapping(value = "/filtroReporteInvPersona",method=RequestMethod.GET)
            public ModelAndView ListaInventario()  
            {
               
                ModelAndView modelAndView = new ModelAndView("prev_invPersona");        

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invPersona", myModel);
            }
            
            
            @RequestMapping(value="/listReporteInvPersona", method=RequestMethod.POST) 
	public ModelAndView listInvFiltro(@ModelAttribute TbInventario invent) 
        {
		ModelAndView modelAndView = new ModelAndView("prev_invPersonaLista");
                int idpersona=invent.getTbcPersona().getIdPersona();
                int val =  invent.getValor().intValue();
                
                int param02 = 0;
        double param03=0;
        
        if(val == 1)
        {
            param02=599;
            param03=999999.00;
        }
        else if(val == 0)
        {
           param02=0;
           param03=600.00;
        }
        
        
        String  code = "where TB_INVENTARIO.\"VALOR\" >=" + param02 +"and   TBC_PERSONA.\"ID_PERSONA\" = "+ idpersona +"  and TB_INVENTARIO.\"VALOR\" < " + param03;
    
        
                List result = tbInventarioService.customSQL(code);
                System.out.println("val : "+ val);
               System.out.println("INGRESA CONTROLLER ListaInventario--- id perso = " + idpersona);
               
               // List inventario = tbInventarioService.getAllFiltro(IdLocalizacion);
		modelAndView.addObject("activos", result);

		return modelAndView;
	}
        
       //Reporte por Clase 
        
        @RequestMapping(value = "/filtroReporteInvClase",method=RequestMethod.GET)
            public ModelAndView filtroInventarioClase()  
            {
               
                ModelAndView modelAndView = new ModelAndView("prev_invClase");        

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll();
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invClase", myModel);
            }
            
            
            @RequestMapping(value="/listReporteInvClase", method=RequestMethod.POST) 
	public ModelAndView listInvClase(@ModelAttribute TbInventario invent) 
        {
		ModelAndView modelAndView = new ModelAndView("prev_invClaseLista");
                int id=invent.getTbcClaseActivo().getIdClaseActivo();
                int val =  invent.getValor().intValue();
                
                int param02 = 0;
        double param03=0;
        
        if(val == 1)
        {
            param02=599;
            param03=999999.00;
        }
        else if(val == 0)
        {
           param02=0;
           param03=600.00;
        }
        
        
        String  code = "where TB_INVENTARIO.\"VALOR\" >=" + param02 +"and   TBC_CLASE_ACTIVO.\"ID_CLASE_ACTIVO\" = "+ id +"  and TB_INVENTARIO.\"VALOR\" < " + param03;
    
        
               List result = tbInventarioService.customSQL(code);
               System.out.println("val : "+ val);
               System.out.println("INGRESA CONTROLLER ListaInventario--- id perso = " + id);
               
               // List inventario = tbInventarioService.getAllFiltro(IdLocalizacion);
		modelAndView.addObject("activos", result);

		return modelAndView;
	}
        
        @RequestMapping(value = "/getReporteClaseInv/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptClase(HttpServletResponse response, @PathVariable Integer id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteXclase.jrxml"); 
    
    
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);

    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
   System.out.println("id :" + id + " param " + param); 
     String tipoRep="";
     
      TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
     String nombrefiltro="LA CLASE " + clase.getNombreClase().toUpperCase();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("idpersona", id);
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
   response.setHeader("Content-disposition", "inline; filename=InventarioPorClase.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  
  //Reporte por factura
        
        @RequestMapping(value = "/filtroReporteInvFactura",method=RequestMethod.GET)
            public ModelAndView filtroInventarioFactura()  
            {
               
                ModelAndView modelAndView = new ModelAndView("prev_invFactura");        

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll();
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invFactura", myModel);
            }
            
            
            @RequestMapping(value="/listReporteInvFactura", method=RequestMethod.POST) 
	public ModelAndView listInvFactura(@ModelAttribute TbInventario invent) 
        {
                
                
		ModelAndView modelAndView = new ModelAndView("prev_invFacturaList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
                int val =  invent.getValor().intValue();
                String numeroF= invent.getMarca();
                int param02 = 0;
        double param03=0;
        
        if(val == 1)
        {
            param02=599;
            param03=999999.00;
        }
        else if(val == 0)
        {
           param02=0;
           param03=600.00;
        }
        
        
        String  code = "where TB_INVENTARIO.\"VALOR\" >=" + param02 +" and   TB_INVENTARIO.\"N_FACTURA\" = \'"+numeroF+"\'  and TB_INVENTARIO.\"VALOR\" < " + param03;
    
        
                System.out.println("query : "+ code);
               List result = tbInventarioService.customSQL(code);
               
               //System.out.println("INGRESA CONTROLLER ListaInventario--- id perso = " + id);
               
               // List inventario = tbInventarioService.getAllFiltro(IdLocalizacion);
		modelAndView.addObject("activos", result);
                System.out.println("val : "+ val);
		return modelAndView;
	}
        
        
        
        @RequestMapping(value = "/getReportefacturaInv/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptFActura(HttpServletResponse response, @PathVariable String id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteXfactura.jrxml"); 
    
    
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);

    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
    System.out.println("id :" + id + " param " + param); 
     String tipoRep="";
     
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
     String nombrefiltro="LA FACTURA NUMERO " + id.toUpperCase();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("numfactura", id);
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
   response.setHeader("Content-disposition", "inline; filename=InventarioPorFactura.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  
  //***********Reporte por codigo***********************************************
  
        
  
  @RequestMapping(value = "/filtroReporteInvCodigo",method=RequestMethod.GET)
            public ModelAndView filtroInventarioCodigo()  
            {          

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll();
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invCodigo", myModel);
            }
            
            
            @RequestMapping(value="/listReporteInvCodigo", method=RequestMethod.POST) 
	public ModelAndView listInvCodigo(@ModelAttribute TbInventario invent) 
        {
                                
		ModelAndView modelAndView = new ModelAndView("prev_invFacturaList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
                int val =  invent.getValor().intValue();
                String numeroF= invent.getMarca();
                int param02 = 0;
        double param03=0;
        
        if(val == 1)
        {
            param02=599;
            param03=999999.00;
        }
        else if(val == 0)
        {
           param02=0;
           param03=600.00;
        }        
        
        String  code = "where TB_INVENTARIO.\"VALOR\" >=" + param02 +" and   TB_INVENTARIO.\"CODIGO_INVENTARIO\" like \'"+numeroF+"%\'  and TB_INVENTARIO.\"VALOR\" < " + param03;
               System.out.println("query : "+ code);
               List result = tbInventarioService.customSQL(code);
		modelAndView.addObject("activos", result);
                System.out.println("val : "+ val);
		return modelAndView;
	}
              
        
        @RequestMapping(value = "/getReporteCodigoInv/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
   // ireport reporte codigo  
  public void getRptCodigo(HttpServletResponse response, @PathVariable String id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteXCodigo.jrxml"); 
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
    System.out.println("id :" + id + " param " + param); 
     String tipoRep="";     
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
     String nombrefiltro="CODIGO " + id.toUpperCase();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("numfactura", id);
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
   response.setHeader("Content-disposition", "inline; filename=InventarioPorCodigo.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  //*************************************************************
  // Reporte Nuevo Ingreso
   @RequestMapping(value = "/filtroReporteInvNuevoInv",method=RequestMethod.GET)
            public ModelAndView filtroInventarioNuevoInv()  
            {          

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll();
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invNuevoIngreso", myModel);
            }
            
      @RequestMapping(value="/listReporteInvNuevoInv", method=RequestMethod.POST) 
	public ModelAndView listReporteInvNuevoInv(@ModelAttribute TbInventario invent) 
        {
                                
		ModelAndView modelAndView = new ModelAndView("prev_invNuevoIngresoList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
                int val =  0;
                String numeroF= invent.getMarca();
                numeroF=numeroF.replace(",","");
                int param02 = 0;
                
                System.out.println("año nuevo ingreso :" + numeroF + "*");
        double param03=0;
        
        if(val == 1)
        {
            param02=599;
            param03=999999.00;
        }
        else if(val == 0)
        {
           param02=0;
           param03=600.00;
        }        
        
        String  code = "where year(TB_INVENTARIO.\"FECHA_ADQUISICION\") = " + numeroF ;
               System.out.println("query : "+ code);
               List result = tbInventarioService.customSQL(code);
		modelAndView.addObject("activos", result);
                System.out.println("val : "+ val);
		return modelAndView;
	}
  
  @RequestMapping(value = "/getReporteInvNuevoIng/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvNuevoIng(HttpServletResponse response, @PathVariable String id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteNuevoIngreso.jrxml"); 
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
    System.out.println("id :" + id + " param " + param); 
     String tipoRep="";     
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
     String nombrefiltro="CODIGO " + id.toUpperCase();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("numfactura", id);
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
   response.setHeader("Content-disposition", "inline; filename=InventarioNuevoIngreso.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  
  //*************************************************************
  //REPORTE POR FINANCIAMIENTO
   @RequestMapping(value = "/filtroReporteInvFianc",method=RequestMethod.GET)
            public ModelAndView filtroInvFianc()  
            {          

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll();
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invFinanciamiento", myModel);
            }
            
      @RequestMapping(value="/listReporteInvFianc", method=RequestMethod.POST) 
	public ModelAndView listReporteInvFianc(@ModelAttribute TbInventario invent) 
        {
                                
		ModelAndView modelAndView = new ModelAndView("prev_invFinanciamientoList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
                int val =  invent.getValor().intValue();
                String numeroF= invent.getMarca();
                numeroF=numeroF.replace(",","");
                int param02 = 0;
                
                System.out.println("año nuevo ingreso :" + numeroF + "*");
        double param03=0;
        
        if(val == 1)
        {
            param02=599;
            param03=999999.00;
        }
        else if(val == 0)
        {
           param02=0;
           param03=600.00;
        }        
        
       // String  code = "where year(TB_INVENTARIO.\"FECHA_ADQUISICION\") = " + numeroF ;
        String  code = "where TB_INVENTARIO.\"VALOR\" >=" + param02 +" and   TB_INVENTARIO.\"FINANCIAMIENTO\" like \'"+numeroF+"\'  and TB_INVENTARIO.\"VALOR\" < " + param03;
               System.out.println("query : "+ code);
               List result = tbInventarioService.customSQL(code);
		modelAndView.addObject("activos", result);
                System.out.println("val : "+ val);
		return modelAndView;
	}
  
  @RequestMapping(value = "/getReporteInvFianc/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvFianc(HttpServletResponse response, @PathVariable String id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteXFinanc.jrxml"); 
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
    System.out.println("id :" + id + " param " + param); 
     String tipoRep="";     
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
     String nombrefiltro="TIPO FINANCIAMIENTO " + id.toUpperCase();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("numfactura", id);
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
   response.setHeader("Content-disposition", "inline; filename=InventarioPorFinanciamiento.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  
  
 //*************************************************************


//Fin vistas previas reportes   
  
  
  
  
  //*************************************************************
  //***************Formato de asignacion*********************
  
   @RequestMapping(value = "/getFormatoAsignacion/{id}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getformatoAsig(HttpServletResponse response, @PathVariable String id) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
        InputStream jasperxml =  this.getClass().getResourceAsStream("/formatoAsig.jrxml"); 

        JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
        Map<String,Object> params = new HashMap<>();

        System.out.println("id :"); 
        String tipoRep="";     
          //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
        String nombrefiltro="CODIGO " + id.toUpperCase();
        int param02 = 0;
        double param03=0;
        
        
        File file = new File(this.getClass().getResource("/Logo.jpg").getFile());
        String absolutePath = file.getAbsolutePath();    
        absolutePath = absolutePath.replaceAll("%20"," "); 
        Date fecha = new Date();
        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        String fech = dt1.format(fecha).toUpperCase();
        Date fechaR= dt1.parse(fech);
        System.out.println("format "+fech);
        
        params.put("fecha", fechaR);
        
        params.put("realpath",absolutePath);
        params.put("top",id); 
    
     
        System.out.println("report3 :" + jasperReport);    
        System.out.println("report3 :" + response);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "inline; filename=formatoAsignacion.xlsx");
        final OutputStream outStream = response.getOutputStream();
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);  
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
        exporter.exportReport();
 }
  //********************************************************
  
  
  @RequestMapping(value = "/filtroReporteInvHistorialP",method=RequestMethod.GET)
            public ModelAndView filtroInventarioPersonaHist()  
            {
               
                ModelAndView modelAndView = new ModelAndView("prev_invPersonaHist");        

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll();
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invPersonaHist", myModel);
            }
            
            
             @RequestMapping(value = "/getRptInvHistPersona/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvHistPers(HttpServletResponse response, @PathVariable String id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteHistMov_persona.jrxml"); 
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
     
     
     String tipoRep="";     
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
     String nombrefiltro="TIPO FINANCIAMIENTO " + id.toUpperCase();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
        int idn = Integer.parseInt(id);
        TbcPersona pers =(TbcPersona)tbcPersonaService.findByKey(idn); 
    
        params.put("persona", pers.getNombrePersona());  
         
      
       
        
        Date fecha = new Date();
        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("MMMMM yyyy");
        String fech = dt1.format(fecha).toUpperCase();
        System.out.println("format "+fech);
        
       // params.put("fecha_reporte", fech);  
       
    
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);    
        System.out.println("report3 :" + response);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    //System.out.println("report4 :");
    //response.setContentType("application/x-pdf");
    response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-disposition", "inline; filename=InventarioHistorialPorPersonal.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  
  
    @RequestMapping(value="/listReporteInvHPers", method=RequestMethod.POST) 
	public ModelAndView listReporteInvHistPers(@ModelAttribute TbInventario invent) 
        {
                                
		ModelAndView modelAndView = new ModelAndView("prev_invPersonaHistList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
                if(invent.getTbcPersona().getIdPersona() == 0)
                {
                   return filtroInventarioPersonaHist();
                }
                
                
                String nombre = ((TbcPersona)tbcPersonaService.findByKey(invent.getTbcPersona().getIdPersona())).getNombrePersona();
                //String npersona = invent.getTbcPersona().getNombrePersona();
                //String numeroF= invent.getMarca();
               // numeroF=numeroF.replace(",","");
                int param02 = 0;
                
                //System.out.println("año nuevo ingreso :" + numeroF + "*");
           
                
        
       // String  code = "where year(TB_INVENTARIO.\"FECHA_ADQUISICION\") = " + numeroF ;
        String  code = " TBH_MOVIMIENTO.\"PERSONA_ANTERIOR\" = \'" + nombre;
        code = code + "\' group by TBH_MOVIMIENTO.\"CODIGO_INVENTARIO\",TBH_MOVIMIENTO.\"DESCRIPCION_EQUIPO\",TBH_MOVIMIENTO.\"PERSONA_ANTERIOR\"\n" +
" \n" +
" ) as b \n" +
" on a.\"ID_MOVIMIENTOH\" = b.\"ID_MOVIMIENTOH\"  ";
               System.out.println("query : "+ code);
               List result = tbhMovimientoService.reporteHist(code);
		modelAndView.addObject("activos", result); 
		return modelAndView;
	}
  
        
        @RequestMapping(value="/listReporteInvHCod", method=RequestMethod.POST) 
	public ModelAndView listReporteInvHistCod(@ModelAttribute TbInventario invent) 
        {
                                
		ModelAndView modelAndView = new ModelAndView("prev_invCodigoHistList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
                //String nombre = ((TbcPersona)tbcPersonaService.findByKey(invent.getTbcPersona().getIdPersona())).getNombrePersona();
                //String npersona = invent.getTbcPersona().getNombrePersona();
                String numcod= invent.getMarca();
               // numeroF=numeroF.replace(",","");
                int param02 = 0;
                
                //System.out.println("año nuevo ingreso :" + numeroF + "*");
           
                
        
       // String  code = "where year(TB_INVENTARIO.\"FECHA_ADQUISICION\") = " + numeroF ;
        String  code = " TBH_MOVIMIENTO.\"CODIGO_INVENTARIO\" = \'" + numcod;
        code = code + "\' group by TBH_MOVIMIENTO.\"CODIGO_INVENTARIO\",TBH_MOVIMIENTO.\"DESCRIPCION_EQUIPO\",TBH_MOVIMIENTO.\"PERSONA_ANTERIOR\"\n" +
" \n" +
" ) as b \n" +
" on a.\"ID_MOVIMIENTOH\" = b.\"ID_MOVIMIENTOH\"  ";
               System.out.println("query : "+ code);
               List result = tbhMovimientoService.reporteHist(code);
		modelAndView.addObject("activos", result); 
		return modelAndView;
	}
        
         @RequestMapping(value = "/getRptInvHistCodigo/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRptInvHistCod(HttpServletResponse response, @PathVariable String id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   
      Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteHistMov_codigo.jrxml"); 
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
     
     
     String tipoRep="";     
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);   
     String nombrefiltro="TIPO FINANCIAMIENTO " + id.toUpperCase();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
        //int idn = Integer.parseInt(id);
        //TbcPersona pers =(TbcPersona)tbcPersonaService.findByKey(idn); 
    
        params.put("persona", id);  
         
      
       
        
        Date fecha = new Date();
        // *** same for the format String below
        SimpleDateFormat dt1 = new SimpleDateFormat("MMMMM yyyy");
        String fech = dt1.format(fecha).toUpperCase();
        System.out.println("format "+fech);
        
       // params.put("fecha_reporte", fech);  
       
    
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);    
        System.out.println("report3 :" + response);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    //System.out.println("report4 :");
    //response.setContentType("application/x-pdf");
    response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-disposition", "inline; filename=InventarioHistorialPorCodigo.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  
  @RequestMapping(value = "/filtroReporteInvHistorialC",method=RequestMethod.GET)
            public ModelAndView filtroInventarioCodigoHist()  
            {               
                ModelAndView modelAndView = new ModelAndView("prev_invCodigoHist");        

                Map<String, Object> myModel = new HashMap<String, Object>();
                System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll();
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invCodigoHist", myModel);
            }
  
            
            
            
   //***********Reporte por informatico localizacion***********************************************
  
        
  
  @RequestMapping(value = "/filtroReporteInfoLocal",method=RequestMethod.GET)
            public ModelAndView filtroInformaticoLocal()  
            {          

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll(); 
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invInfLocal", myModel);
            }
            
            
            @RequestMapping(value="/listReporteInvInformaticoLocal", method=RequestMethod.POST) 
	public ModelAndView listInvInformaticoLocal(@ModelAttribute TbInventario invent) 
        {
                                
		ModelAndView modelAndView = new ModelAndView("prev_invInfLocalList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
                int val =  invent.getValor().intValue();
                String numeroF= "61104";
                int param02 = 0;
                int id_local = invent.getIdLocalizacion();
        double param03=0;
        
        if(val == 1)
        {
            param02=599;
            param03=999999.00;
        }
        else if(val == 0)
        {
           param02=0;
           param03=600.00;
        }        
        
        String  code = "where   TB_INVENTARIO.\"CODIGO_INVENTARIO\" like \'"+numeroF+"%\'  and TB_INVENTARIO.\"ID_LOCALIZACION\" = " + id_local;
               System.out.println("query : "+ code);
               List result = tbInventarioService.customSQL(code);
		modelAndView.addObject("activos", result);
                System.out.println("val : "+ val);
		return modelAndView;
	}
              
        
        @RequestMapping(value = "/getReporteInformaticoLocalInv/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
   // ireport reporte codigo  
  public void getRptInformaticoLocal(HttpServletResponse response, @PathVariable Integer id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteInformaticoLocalizacion.jrxml"); 
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
    System.out.println("id :" + id + " param " + param); 
     String tipoRep="";
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);  
     TbcLocalizacion local = (TbcLocalizacion)tbLocalizacionService.findByKey(id);
     
     
     String nombrefiltro=" "+local.getNombreLocalizacion();
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("numfactura", "61104");
        params.put("mayor600", param02);
        params.put("menorque", param03);        
        params.put("tipo_valor", "INFORMATICO");              
        params.put("inventario_de", nombrefiltro); 
        params.put("idLocalizacion",id);
         
      
       
        
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
   response.setHeader("Content-disposition", "inline; filename=InventarioInformaticoXLocal.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  //*************************************************************    
  
   //***********Reporte por informatico***********************************************
  
        
  
  @RequestMapping(value = "/filtroReporteInfo",method=RequestMethod.GET)
            public ModelAndView filtroInformatico()  
            {          

               Map<String, Object> myModel = new HashMap<String, Object>();
               System.out.println("INGRESA CONTROLLER ListaInventario---");
                //List persona = tbcPersonaService.getAll();
                List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                List personas =tbcPersonaService.getAll();
                List clases= tbcClaseService.getAll(); 
                myModel.put("clase", clases);
                myModel.put("inventario", new TbInventario());       
                myModel.put("clasiLocalizacion",clasiLocalizacion);
                myModel.put("persona",personas);
                return new ModelAndView("prev_invInf", myModel);
            }
            
            
            @RequestMapping(value="/listReporteInvInformatico", method=RequestMethod.POST) 
	public ModelAndView listInvInformatico(@ModelAttribute TbInventario invent) 
        {
                                
		ModelAndView modelAndView = new ModelAndView("prev_invInfList");
                //int id=invent.getTbcClaseActivo().getIdClaseActivo();                
                System.out.println("metodo post reporte factura");
              //  int val =  invent.getValor().intValue();
                String numeroF= "61104";
                int param02 = 0;
                int id_local = 0;
        double param03=0;
        
                
        
        String  code = "where   TB_INVENTARIO.\"CODIGO_INVENTARIO\" like \'"+numeroF+"%\'  ";
               System.out.println("query : "+ code);
               List result = tbInventarioService.customSQL(code);
		modelAndView.addObject("activos", result);
                //System.out.println("val : "+ val);
		return modelAndView;
	}
              
        
        @RequestMapping(value = "/getReporteInformaticoInv/{id}/{param}", method = RequestMethod.GET)
        @ResponseBody
   // ireport reporte codigo  
  public void getRptInformatico(HttpServletResponse response, @PathVariable Integer id,@PathVariable Integer param) throws JRException, IOException, SQLException, ClassNotFoundException, ParseException 
  {      
   Connection conn = dataSource().getConnection();
      System.out.println(conn);
     
    InputStream jasperxml =  this.getClass().getResourceAsStream("/reporteInformatico.jrxml"); 
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    Map<String,Object> params = new HashMap<>();
     
    System.out.println("id :"); 
    System.out.println("id :" + id + " param " + param); 
     String tipoRep="";
      //TbcClaseActivo clase=(TbcClaseActivo)tbcClaseService.findByKey(id);  
     TbcLocalizacion local = (TbcLocalizacion)tbLocalizacionService.findByKey(id);
     
     
     String nombrefiltro="Isdemu";
     int param02 = 0;
        double param03=0;
        
        if(param == 1)
        {
            param02=599;
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
    
        params.put("numfactura", "61104");
        params.put("mayor600", param02);
        params.put("menorque", param03);        
        params.put("tipo_valor", "INFORMATICO");              
        params.put("inventario_de", nombrefiltro); 
        params.put("idLocalizacion",id);
         
      
       
        
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
   response.setHeader("Content-disposition", "inline; filename=InventarioInformaticoIDEMU.xlsx");
   final OutputStream outStream = response.getOutputStream();
       JRXlsxExporter exporter = new JRXlsxExporter();
       exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
       //exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME,  "E:\\Rpt01.xls"); 
      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,outStream);
       exporter.exportReport();
 }
  //************************************************************* 
    
}
