/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.isdemu.model.TbControlSalida;
import com.isdemu.service.TBC_Poliza_Service;
import com.isdemu.service.TB_Control_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.isdemu.model.TbInventario;
import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbcClaseActivo;

import com.isdemu.model.TbControlSalida;
import com.isdemu.model.TbrControlSalidaInventario;
import com.isdemu.service.TBR_ControlInventario_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.isdemu.service.TB_Movimiento_Service;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
 * @author Miranda
 */
@Controller 
 @RequestMapping(value="/Control")
public class TB_ControlController {
    
    @Autowired
	private TB_Inventario_Service tbInventarioService;
    @Autowired
        private TBC_Poliza_Service tbPolizaService;
    
    @Autowired
        private TB_Control_Service tbControlService;
    
    @Autowired
        private TBR_ControlInventario_Service tbrControlInvService;
    
    
      
     @RequestMapping(value="/list")
	public ModelAndView listOfPaises() {
		ModelAndView modelAndView = new ModelAndView("control_consultar");

		List control = tbControlService.getAll();
		modelAndView.addObject("control", control);

		return modelAndView;
	}
        
       @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPaisPage() {
              System.out.println("esntra aqui GET control");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		
                 
                 //List ClasAct = tbClasActService.getAll();
                /// List poliza = tbPolizaService.getAll();
                List inventario= tbInventarioService.getAll();
                 //List region=tbcRegionService.getAll();
                 myModel.put("control", new TbControlSalida());
                 myModel.put("inventario",inventario);
                // myModel.put("poliza",poliza );
                // myModel.put("clasificacionA",ClasAct );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
		return new ModelAndView("control",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody String addingPais(@RequestBody String control) {
		ModelAndView modelAndView = new ModelAndView("home");
//                JSONObject jsonObj = new JSONObject(control);
		//System.out.println("entra aqui POST persona"+control.get(0).getIdControlSalida());
                 System.out.println("String Json:"+control);
                 
                 TbControlSalida controlSalida = new TbControlSalida();
                 
                JSONObject array = new JSONObject(control);
                JSONArray object3 = array.getJSONArray("Control");
                 
                JSONObject objectControl = object3.getJSONObject(0);
                                  
                String solicitante = objectControl.getString("solicitante");
                String observacion = objectControl.getString("observacion");
                String destino = objectControl.getString("destino");
                String fecha_devolucion = objectControl.getString("fecha_devolucion");
                String fecha_sal = objectControl.getString("fecha_sal");
                 
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                
                Date fecha_sa=new Date();
                        try {
                          fecha_sa = formatter.parse(fecha_sal);
                        } catch (ParseException ex) {
                   }
                 Date fecha_de=new Date();
                        try {
                          fecha_de = formatter.parse(fecha_devolucion);
                        } catch (ParseException ex) {
                   }
                    controlSalida.setSolicitante(solicitante);
                    controlSalida.setObservacion(observacion);
                    controlSalida.setDestino(destino);
                    controlSalida.setFechaSalida(fecha_sa);
                    controlSalida.setFechaTentativaDevolucion(fecha_de);
                        
                 tbControlService.save(controlSalida);
                 
                 TbControlSalida UltControl =(TbControlSalida) tbControlService.LastIdControl().get(0);
                  
                 
                 JSONArray object = array.getJSONArray("Inventario");
                 for(int i=0;i<object.length();i++)
                 {
                    JSONObject object2 = object.getJSONObject(i);
                  
                     //JSONArray object = array.getJSONArray("Inventario");
                    String id = object2.getString("idInv");
                    
                    
                    TbrControlSalidaInventario conInv= new TbrControlSalidaInventario();
                    conInv.setTbControlSalida(UltControl);
                    
                    TbInventario tempInv =(TbInventario)tbInventarioService.findByKey(Integer.parseInt(id));
                    conInv.setTbInventario(tempInv);
                    
                    tbrControlInvService.save(conInv);
                    
                    System.out.println("Id Json:"+id);
                   
                }
                
              
            
		//tbMovimientoService.save(movi);
		String message = "Constrol was successfully added.";
		modelAndView.addObject("message", message);
		return Integer.toString(UltControl.getIdControlSalida());
	}
        
      @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
                System.out.println(id);
		tbControlService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
        
        @RequestMapping(value="/editControl1/{id}", method=RequestMethod.GET)
	public ModelAndView editControlInventarioPage(@PathVariable Integer id) 
        {
                System.out.println("Entra actualiza1");
		//ModelAndView modelAndView = new ModelAndView("actualizar_inventario");
            
                TbControlSalida cont = (TbControlSalida) tbControlService.findByKey(id);
                System.out.println("Entra actualiza5");
		List con = tbControlService.getInvControl(id);
               // TbcRegion activo = (TbcRegion) tbRegionService.findByKey(unidad.getTbcRegion().getIdRegion());
                System.out.println("Entra actualiza2");
                  Map<String, Object> myModel = new HashMap<String, Object>();
                   //List ClasAct = tbClasActService.getAll();  
                   myModel.put("controlInv",con); 
                   myModel.put("control",cont);
                 // myModel.put("clasificacionA",activo );
                  //myModel.put("AllclasificacionA",ClasAct );
                
                  
                   System.out.println("Entra actualiza");
                //System.out.println("A ver el combo:"+inventario.getTbcClasificacionActivo().getIdClasificacionActivo()+activo.getNombreClasificacion());
		//modelAndView.addObject("inventario",inventario);
		return new ModelAndView("actualizar_control",myModel);
	}
        
        
        @RequestMapping(value="/editControl1/{id1}", method=RequestMethod.POST)	
	public @ResponseBody String updateingPais(@RequestBody String control, @PathVariable Integer id1) {
		ModelAndView modelAndView = new ModelAndView("home");
//                JSONObject jsonObj = new JSONObject(control);
		//System.out.println("entra aqui POST persona"+control.get(0).getIdControlSalida());
                 System.out.println("String Json:"+control);
                 System.out.println("id Json:"+id1);
                TbControlSalida controlSalida = (TbControlSalida) tbControlService.findByKey(id1);
        
                 
                JSONObject array = new JSONObject(control);
                JSONArray object3 = array.getJSONArray("Control");
                 
                JSONObject objectControl = object3.getJSONObject(0);
                                  
                String solicitante = objectControl.getString("solicitante");
                String observacion = objectControl.getString("observacion");
                String destino = objectControl.getString("destino");
                String fecha_devolucion = objectControl.getString("fecha_devolucion");
                String fecha_sal = objectControl.getString("fecha_sal");
                 
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                
                Date fecha_sa=new Date();
                        try {
                          fecha_sa = formatter.parse(fecha_sal);
                        } catch (ParseException ex) {
                   }
                 Date fecha_de=new Date();
                        try {
                          fecha_de = formatter.parse(fecha_devolucion);
                        } catch (ParseException ex) {
                   }
                    controlSalida.setSolicitante(solicitante);
                    controlSalida.setObservacion(observacion);
                    controlSalida.setDestino(destino);
                    controlSalida.setFechaSalida(fecha_sa);
                    controlSalida.setFechaTentativaDevolucion(fecha_de);
                        
                 tbControlService.update(controlSalida);
                 
                 tbrControlInvService.delete(id1);
                 
                 
                 TbControlSalida UltControl =(TbControlSalida) tbControlService.findByKey(id1);
                  
                 
                 JSONArray object = array.getJSONArray("Inventario");
                 for(int i=0;i<object.length();i++)
                 {
                    JSONObject object2 = object.getJSONObject(i);
                  
                     //JSONArray object = array.getJSONArray("Inventario");
                    String id = object2.getString("idInv");
                    
                    
                    TbrControlSalidaInventario conInv= new TbrControlSalidaInventario();
                    conInv.setTbControlSalida(UltControl);
                    
                    TbInventario tempInv =(TbInventario)tbInventarioService.findByKey(Integer.parseInt(id));
                    conInv.setTbInventario(tempInv);
                    
                    tbrControlInvService.save(conInv);
                    
                    System.out.println("Id Json:"+id);
                   
                }
                
              
            
		//tbMovimientoService.save(movi);
		String message = "Constrol was successfully added.";
		modelAndView.addObject("message", message);
		return "2";
	}
        
        @RequestMapping(value = "/agregarInventarioM", method = RequestMethod.POST)
        public @ResponseBody
        List<TbInventario> addingInvDescargo(@RequestBody String cod) {
            //ModelAndView modelAndView = new ModelAndView("descargo");
            System.out.println("codigo inv " + cod);
            Map<String, Object> myModel = new HashMap<String, Object>();
            List<TbInventario> list_invent= tbInventarioService.findBycodigo(cod);        
            System.out.println("list inv " + list_invent);
            //return new ModelAndView("descargo", myModel);

            return list_invent;    
        }
        
        @RequestMapping(value="/detalle/{id}", method=RequestMethod.GET)
	public ModelAndView detalleControlInventarioPage(@PathVariable Integer id) 
        {
                System.out.println("Entra actualiza1");
		//ModelAndView modelAndView = new ModelAndView("actualizar_inventario");
            
                TbControlSalida cont = (TbControlSalida) tbControlService.findByKey(id);
                System.out.println("Entra actualiza5");
		List con = tbControlService.getInvControl(id);
               // TbcRegion activo = (TbcRegion) tbRegionService.findByKey(unidad.getTbcRegion().getIdRegion());
                System.out.println("Entra actualiza2");
                  Map<String, Object> myModel = new HashMap<String, Object>();
                   //List ClasAct = tbClasActService.getAll();  
                   myModel.put("controlInv",con); 
                   myModel.put("control",cont);
                 // myModel.put("clasificacionA",activo );
                  //myModel.put("AllclasificacionA",ClasAct );
                
                  
                   System.out.println("Entra actualiza");
                //System.out.println("A ver el combo:"+inventario.getTbcClasificacionActivo().getIdClasificacionActivo()+activo.getNombreClasificacion());
		//modelAndView.addObject("inventario",inventario);
		return new ModelAndView("detalle_control",myModel);
	}
    
}
