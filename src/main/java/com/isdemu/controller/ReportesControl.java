/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.spring.WebAppConfig;
import com.isdemu.service.TBR_ControlInventario_Service;
//import static com.lowagie.text.Annotation.URL;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import static javax.servlet.SessionTrackingMode.URL;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Luis
 */

 
/**
 *
 * @author Luis
 */

@Controller
@RequestMapping(value = "/Reporte")

public class ReportesControl extends WebAppConfig{
    
    @Autowired
    private TBR_ControlInventario_Service tbrControlInvService;
    
//    @RequestMapping(method = RequestMethod.GET , value = "pdf")
//    public ModelAndView generatePdfReport(ModelAndView modelAndView){
// 
//        //logger.debug("--------------generate PDF report----------");
// 
//        Map<String,Object> parameterMap = new HashMap<String,Object>();
// 
//       List movimiento = tbrMovimientoInvService.getAll(); 
// 
//        JRDataSource JRdataSource = new JRBeanCollectionDataSource(movimiento);
// 
//        parameterMap.put("datasource", JRdataSource);
// 
//        //pdfReport bean has ben declared in the jasper-views.xml file
//        modelAndView = new ModelAndView("pdfReport", parameterMap);
// 
//        return modelAndView;
//    }
    
  
//        @RequestMapping(method = RequestMethod.POST , value = "/GenerateReport")
//        public @ResponseBody void generatePdfReport(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response) throws SQLException{
//    
//            WebApplicationContext context =WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
//            StudentDAO dao=(StudentDAO)context.getBean("studentDAO");
//          
//            BasicDataSource dataSource = (BasicDataSource)context.getBean("myDataSource");
//            String contextPath = request.getServletContext().getRealPath("report/StudentReport.jrxml");
//            dao.generatePdfReport(dataSource,contextPath);
//          
//         }
//        
   
     @RequestMapping(value = "/ReporteControl/{id}", method = RequestMethod.GET)
        @ResponseBody
     
  public void getRpt1(HttpServletResponse response, @PathVariable Integer id) throws JRException, IOException, SQLException, ClassNotFoundException 
  {
   // JasperCompileManager.compileReportToFile(this.getClass().getResource("/ireportPrueba03.jrxml").getPath(),"/ireportPrueba03.jasper"); 
    
   // JasperCompileManager.
   // JasperCompileManager.compileReportToFile("/ireportPrueba03.jrxml", "/ireportPrueba03.jasper");
     //this.getClass().getResource("/ireportPrueba03.jrxml");
   // this.getClass().getResource("/ireportPrueba03.jrxml").toURI();
     
     Connection conn = dataSource().getConnection();
      
    InputStream jasperxml =  this.getClass().getResourceAsStream("/control_salida.jrxml"); 
    //jasperxml = JasperCompileManager.compileReportToStream(jasperxml );
    
    JasperReport jasperReport = JasperCompileManager.compileReport(jasperxml);
    //System.out.println("report entra url:"+this.getClass().getResource("/ireportPrueba04.jrxml"));      
    //InputStream jasperStream = this.getClass().getResourceAsStream("/ireportPrueba03.jrxml");    
    //System.out.println("report2 :" + jasperStream);
    Map<String,Object> params = new HashMap<>();
    int b = id;
    
   
    params.put("id_control_sal", b);
    //JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
    System.out.println("report3 :" + jasperReport);
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,conn);
    System.out.println("report4 :");
    response.setContentType("application/x-pdf");
    response.setHeader("Content-disposition", "inline; filename=ControlSalida.pdf");

    final OutputStream outStream = response.getOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
  }
    
}
