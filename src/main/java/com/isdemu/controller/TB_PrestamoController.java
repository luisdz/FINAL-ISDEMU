/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.isdemu.model.TbInventario;
import com.isdemu.model.TbcClasificacionActivo;
import com.isdemu.model.TbcPersona;
import com.isdemu.model.TbcPoliza;

import com.isdemu.model.TbPrestamoEquipo;
import com.isdemu.model.TbControlSalida;
import com.isdemu.model.TbrPrestamoEquipoInventario;
import com.isdemu.service.TBC_ClasificacionActivo_Service;
import com.isdemu.service.TBC_Poliza_Service;
import com.isdemu.service.TBR_PrestamoInventario_Service;
import com.isdemu.service.TB_Control_Service;
import com.isdemu.service.TB_Prestamo_Service;
import com.isdemu.service.TB_Inventario_Service;
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
 @RequestMapping(value="/Prestamo")
public class TB_PrestamoController {
    
    @Autowired
	private TB_Inventario_Service tbInventarioService;
    @Autowired
        private TBC_Poliza_Service tbPolizaService;    
    @Autowired
        private TB_Prestamo_Service tbPrestamoService;    
    @Autowired
        private TBR_PrestamoInventario_Service tbrPrestamoInvService;
      
     @RequestMapping(value="/list")
	public ModelAndView listOfPaises() {
		ModelAndView modelAndView = new ModelAndView("consultar_prestamo");
                System.out.println("esntra aqui GET prestamo");
		List prestamo = tbPrestamoService.getAll();
		modelAndView.addObject("prestamo", prestamo);

		return modelAndView;
	}
        
       @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addPaisPage() {
              System.out.println("esntra aqui GET persona");
		//ModelAndView modelAndView = new ModelAndView("inventario");
               Map<String, Object> myModel = new HashMap<String, Object>();
		
                 
                 //List ClasAct = tbClasActService.getAll();
                /// List poliza = tbPolizaService.getAll();
                List inventario= tbInventarioService.getAll();
                 //List region=tbcRegionService.getAll();
                 myModel.put("prestamo", new TbPrestamoEquipo());
                 myModel.put("inventario",inventario);
                // myModel.put("poliza",poliza );
                // myModel.put("clasificacionA",ClasAct );
                // myModel.put("persona",persona);
                // myModel.put("region",region);
                System.out.println("esntra aqui GET persona");
		return new ModelAndView("prestamo",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody String addingPais(@RequestBody String prestamo) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("String Json:"+prestamo);
                 
                TbPrestamoEquipo prestamoEquipo = new TbPrestamoEquipo();
                
                
                JSONObject array2 = new JSONObject(prestamo);
                JSONArray object3 = array2.getJSONArray("Prestamo");
                
                JSONObject objectNumero = object3.getJSONObject(0);
                
                String nPrestamo = objectNumero.getString("nPrestamo");
                String destino = objectNumero.getString("destino");
                String hora_inicio = objectNumero.getString("hora_inicio");
                String hora_fin = objectNumero.getString("hora_fin");
                String fecha_solic = objectNumero.getString("fecha_solic");
                String fecha_reser = objectNumero.getString("fecha_reser");
                String tema = objectNumero.getString("tema");
                String persona = objectNumero.getString("persona");
               
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("nPrestamo Json:"+nPrestamo);
                System.out.println("Numero Json:"+destino);
                System.out.println("hora_inicio Json:"+hora_inicio);
                System.out.println("hora_fin Json:"+hora_fin);
                System.out.println("fecha_solic Json:"+fecha_solic);
                System.out.println("fecha_reser Json:"+fecha_reser);
               
                Date hora_F=new Date();
                        try {
                          hora_F = formatter.parse(hora_fin);
                        } catch (ParseException ex) {
                   }
                 Date fecha_sol=new Date();
                        try {
                          fecha_sol = formatter.parse(fecha_solic);
                        } catch (ParseException ex) {
                   }
                        
                 Date fecha_res=new Date();
                        try {
                          fecha_res = formatter.parse(fecha_reser);
                        } catch (ParseException ex) {
                   }
                        
                 Date hora_I=new Date();
                        try {
                          hora_I = formatter.parse(hora_inicio);
                        } catch (ParseException ex) {
                   }
                               
                prestamoEquipo.setNPrestamo(Integer.parseInt(nPrestamo));
                prestamoEquipo.setHoraInicio(hora_I);
                prestamoEquipo.setHoraFin(hora_F);
                prestamoEquipo.setFechaSolicitud(fecha_sol);
                prestamoEquipo.setFechaReservacion(fecha_res);
                prestamoEquipo.setTemaImpartir(tema);
                prestamoEquipo.setPersonaImpartir(persona);
                
                tbPrestamoService.save(prestamoEquipo);
                
                TbPrestamoEquipo UltPres =(TbPrestamoEquipo) tbPrestamoService.LastIdPrestamo().get(0);
                
                 
                // JSONObject array = new JSONObject(prestamo);
                 JSONArray object = array2.getJSONArray("Inventario");
                 for(int i=0;i<object.length();i++)
                 {
                    JSONObject object2 = object.getJSONObject(i);
                  
                     //JSONArray object = array.getJSONArray("Inventario");
                    String id = object2.getString("idInv");
                    
                    TbrPrestamoEquipoInventario preInv= new TbrPrestamoEquipoInventario();
                    preInv.setTbPrestamoEquipo(UltPres);
                    
                    TbInventario tempInv =(TbInventario)tbInventarioService.findByKey(Integer.parseInt(id));
                    preInv.setTbInventario(tempInv);
                    
                    tbrPrestamoInvService.save(preInv);
                    
                    System.out.println("Id Json:"+id);
                   
                }
                 
                
                
                
            
		//tbMovimientoService.save(movi);
		String message = "Prestamo was successfully added.";
		modelAndView.addObject("message", message);
		return "22";
	}
        
      @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
                System.out.println(id);
		tbPrestamoService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
        
        @RequestMapping(value="/editPrestamo2/{id}", method=RequestMethod.GET)
	public ModelAndView editControlInventarioPage(@PathVariable Integer id) 
        {
                System.out.println("Entra actualiza1");
		//ModelAndView modelAndView = new ModelAndView("actualizar_inventario");
            
                TbPrestamoEquipo pres = (TbPrestamoEquipo) tbPrestamoService.findByKey(id);
                System.out.println("Entra actualiza5");
		List pre = tbPrestamoService.getPreInv(id);
               // TbcRegion activo = (TbcRegion) tbRegionService.findByKey(unidad.getTbcRegion().getIdRegion());
                System.out.println("Entra actualiza2");
                  Map<String, Object> myModel = new HashMap<String, Object>();
                   //List ClasAct = tbClasActService.getAll();  
                    myModel.put("prestamoInv",pre); 
                   myModel.put("prestamo",pres);
                 // myModel.put("clasificacionA",activo );
                  //myModel.put("AllclasificacionA",ClasAct );
                
                  
                   System.out.println("Entra actualiza");
                //System.out.println("A ver el combo:"+inventario.getTbcClasificacionActivo().getIdClasificacionActivo()+activo.getNombreClasificacion());
		//modelAndView.addObject("inventario",inventario);
		return new ModelAndView("actualizar_prestamo",myModel);
	}
        
        
        @RequestMapping(value="/editPrestamo2/{id1}", method=RequestMethod.POST)
	public @ResponseBody String updatePais(@RequestBody String prestamo, @PathVariable Integer id1) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("home");
		 System.out.println("String Json:"+prestamo);
                 System.out.println("id Json:"+id1);
                
                TbPrestamoEquipo prestamoEquipo = (TbPrestamoEquipo) tbPrestamoService.findByKey(id1);
                
                JSONObject array2 = new JSONObject(prestamo);
                JSONArray object3 = array2.getJSONArray("Prestamo");
                
                JSONObject objectNumero = object3.getJSONObject(0);
                
                String nPrestamo = objectNumero.getString("nPrestamo");
                String destino = objectNumero.getString("destino");
                String hora_inicio = objectNumero.getString("hora_inicio");
                String hora_fin = objectNumero.getString("hora_fin");
                String fecha_solic = objectNumero.getString("fecha_solic");
                String fecha_reser = objectNumero.getString("fecha_reser");
                String tema = objectNumero.getString("tema");
                String persona = objectNumero.getString("persona");
                
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("nPrestamo Json:"+nPrestamo);
                System.out.println("Numero Json:"+destino);
                System.out.println("hora_inicio Json:"+hora_inicio);
                System.out.println("hora_fin Json:"+hora_fin);
                System.out.println("fecha_solic Json:"+fecha_solic);
                System.out.println("fecha_reser Json:"+fecha_reser);
               
                Date hora_F=new Date();
                        try {
                          hora_F = formatter.parse(hora_fin);
                        } catch (ParseException ex) {
                   }
                 Date fecha_sol=new Date();
                        try {
                          fecha_sol = formatter.parse(fecha_solic);
                        } catch (ParseException ex) {
                   }
                        
                 Date fecha_res=new Date();
                        try {
                          fecha_res = formatter.parse(fecha_reser);
                        } catch (ParseException ex) {
                   }
                        
                 Date hora_I=new Date();
                        try {
                          hora_I = formatter.parse(hora_inicio);
                        } catch (ParseException ex) {
                   }
                               
                prestamoEquipo.setNPrestamo(Integer.parseInt(nPrestamo));
                prestamoEquipo.setHoraInicio(hora_I);
                prestamoEquipo.setHoraFin(hora_F);
                prestamoEquipo.setFechaSolicitud(fecha_sol);
                prestamoEquipo.setFechaReservacion(fecha_res);
                prestamoEquipo.setTemaImpartir(tema);
                prestamoEquipo.setPersonaImpartir(persona);
                prestamoEquipo.setDestino(destino);
                
                tbPrestamoService.update(prestamoEquipo);
                
                tbrPrestamoInvService.delete(id1);
                
                TbPrestamoEquipo UltPres =(TbPrestamoEquipo) tbPrestamoService.findByKey(id1);
                
                 
                // JSONObject array = new JSONObject(prestamo);
                 JSONArray object = array2.getJSONArray("Inventario");
                 for(int i=0;i<object.length();i++)
                 {
                    JSONObject object2 = object.getJSONObject(i);
                  
                     //JSONArray object = array.getJSONArray("Inventario");
                    String id = object2.getString("idInv");
                    
                    TbrPrestamoEquipoInventario preInv= new TbrPrestamoEquipoInventario();
                    preInv.setTbPrestamoEquipo(UltPres);
                    
                    TbInventario tempInv =(TbInventario)tbInventarioService.findByKey(Integer.parseInt(id));
                    preInv.setTbInventario(tempInv);
                    
                    tbrPrestamoInvService.save(preInv);
                    
                    System.out.println("Id Json:"+id);
                   
                }
                 
		//tbMovimientoService.save(movi);
		String message = "Prestamo was successfully added.";
		modelAndView.addObject("message", message);
		return "22";
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
    
}
