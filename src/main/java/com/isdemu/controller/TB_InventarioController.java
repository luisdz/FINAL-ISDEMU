/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.isdemu.model.TbDescargo;
import com.isdemu.model.TbInventario;
import com.isdemu.model.TbMovimiento;
import com.isdemu.model.TbcClaseActivo;
import com.isdemu.model.TbcClasificacionActivo;
import com.isdemu.model.TbcEstadoInventario;
import com.isdemu.model.TbcLocalizacion;
import com.isdemu.model.TbcPersona;
import com.isdemu.model.TbcPoliza;
import com.isdemu.model.TbcUbicacion;
import com.isdemu.model.TbrMovimientoInventario;

import com.isdemu.service.TBC_ClaseActivo_Service;
import com.isdemu.service.TBC_ClasificacionActivo_Service;
import com.isdemu.service.TBC_ClasificacionLocalizacion_Service;
import com.isdemu.service.TBC_Localizacion_Service;
import com.isdemu.service.TBC_Persona_Service;
import com.isdemu.service.TBC_Poliza_Service;
import com.isdemu.service.TBC_Proveedor_Service;
import com.isdemu.service.TBC_Ubicacion_Service;
import com.isdemu.service.TBR_MovimientoInventario_Service;

import com.isdemu.service.TB_Descargo_Service;
import com.isdemu.service.TB_Inventario_Service;
import com.isdemu.service.TB_Movimiento_Service;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.json.Json;
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
 * @author Jose Eduardo
 */

@Controller 
 @RequestMapping(value="/Inventario")
public class TB_InventarioController {
    public static String CodigoClasificacion="";
    
    @Autowired
	private TB_Inventario_Service tbInventarioService;
 
    @Autowired
        private TBC_ClasificacionActivo_Service tbClasActService;
    
     @Autowired
        private TBC_Persona_Service tbcPersonaService;
     
      @Autowired
        private TBC_Localizacion_Service tbcLocalizacionService;
    
      @Autowired
        private TBC_ClaseActivo_Service tbcClaseActivoService;
      
      @Autowired
        private TBC_ClasificacionLocalizacion_Service tbcClasificacionLocalizacionService;
      
       @Autowired
        private TBC_Ubicacion_Service tbcUbicacionService; 
       
       @Autowired
        private TBR_MovimientoInventario_Service tbrMovInvService; 
       
        @Autowired
	private TBC_Proveedor_Service tbcProveedorService;
     
     
     
    
    @RequestMapping(value="/list")
	public ModelAndView listActivos() {
		ModelAndView modelAndView = new ModelAndView("consultar_inventario");

		List inventario = tbInventarioService.getAll();
		modelAndView.addObject("inventario", inventario);

		return modelAndView;
	}
        
        
       @RequestMapping(value="/listaClaseA", method=RequestMethod.POST)
	public @ResponseBody  List<TbcClaseActivo> ClaseA(@RequestBody String clasi) {
		int idClasi= Integer.parseInt(clasi);
                
              
                System.out.println("INGRESA CONTROLLER LISTA CLASE---");
		System.out.println(idClasi);
                //obtener el codigo de la clasificacion del activo seleccionado y guardarlo en una variable local
                TbcClasificacionActivo clasificacionActivo = (TbcClasificacionActivo) tbClasActService.findByKey(idClasi);
                CodigoClasificacion=clasificacionActivo.getCodigoClasificacion();
                System.out.println("Variable con ocidgo Clasificacion;"+CodigoClasificacion);
                //
                
                 List<TbcClaseActivo> movi = tbcClaseActivoService.getAllidClasi(idClasi);
              
                
               
                return movi;
                 
	}
        
        //llenado de combo de localizacon segun la clasificacion de localizacion o tipo seleccionado
          @RequestMapping(value="/listaLocalizacion", method=RequestMethod.POST)
	  public @ResponseBody  List<TbcLocalizacion> LlenarLocalizacion(@RequestBody String clasi) {
		int idClasi= Integer.parseInt(clasi);
                List <TbcLocalizacion> lozalizacion=tbcLocalizacionService.getAllidClasi(idClasi);
                 System.out.println("lista de localizacon"+lozalizacion);    
                return lozalizacion;
                 
	}
          
           //llenado de combo de ubicacion segun la  localizacion seleccionado
          @RequestMapping(value="/listaUbicacion", method=RequestMethod.POST)
	  public @ResponseBody  List<TbcUbicacion> LlenarUbicacion(@RequestBody String idLocalizacion) {
		int idLoc= Integer.parseInt(idLocalizacion);
                List <TbcUbicacion> ubicacion=tbcUbicacionService.getAllidLocalizacion(idLoc);
                 System.out.println("lista de localizacon"+ubicacion);    
                return ubicacion;
                 
	}
          
          //llenado de combo de ubicacion segun la  localizacion seleccionado
          @RequestMapping(value="/listaPersona", method=RequestMethod.POST)
	  public @ResponseBody  List<TbcPersona> LlenarPersona(@RequestBody String idUbicacion) {
		int idUbicacionInt= Integer.parseInt(idUbicacion);
                List <TbcPersona> persona=tbcPersonaService.getAllidUbicacion(idUbicacionInt);
                 System.out.println("lista de localizacon"+persona);    
                return persona;
                 
	}
        
        //METODO formar codigo de inventario
         @RequestMapping(value="/regionPersona", method=RequestMethod.POST)
	public @ResponseBody  String regPersona(@RequestBody String idPersona) {
		int idClasi= Integer.parseInt(idPersona);
                
              
                System.out.println("INGRESA CONTROLLER LISTA CLASE---");
		System.out.println(idClasi);
                //obtener el codigo de la clasificacion del activo seleccionado y guardarlo en una variable local
                TbcClasificacionActivo clasificacionActivo = (TbcClasificacionActivo) tbClasActService.findByKey(idClasi);
                CodigoClasificacion=clasificacionActivo.getCodigoClasificacion();
                System.out.println("Variable con ocidgo Clasificacion;"+CodigoClasificacion);
                //
                
                 List<TbcClaseActivo> movi = tbcClaseActivoService.getAllidClasi(idClasi);
              
                
               
                return "";
                 
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView insertarInventario(String b) {
             
		//ModelAndView modelAndView = new ModelAndView("inventario");
                 Map<String, Object> myModel = new HashMap<String, Object>();
		 List ClasAct = tbClasActService.getAll();
                 List persona=tbcPersonaService.getAll();
             System.out.println("antesss");
                 List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                 //List ClaseActivo=tbcClaseActivoService.getAll();
                 String message = "0";
                 if(b!=null){
                 message = "1";
                 }
                  
                  String codigoIngresado = b;
                  myModel.put("message", message); 
                  
                 List ClaseActivo=tbcClaseActivoService.getTop();
                 
                 List proveedor=tbcProveedorService.getAll();
                 
                 myModel.put("inventario", new TbInventario());
                  myModel.put("codigoIngresado",codigoIngresado);
                 myModel.put("clasificacionA",ClasAct );
                 myModel.put("claseActivo",ClaseActivo );
                 myModel.put("persona",persona);
                
                 myModel.put("clasiLocalizacion",clasiLocalizacion);
                  myModel.put("proveedor",proveedor);
                
               
                
		return new ModelAndView("inventario",myModel);
	}
        
        
        @RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView insertandoInventario(@ModelAttribute TbInventario inventario) {
		ModelAndView modelAndView = new ModelAndView("home");
		
                inventario.setValorLibro(BigDecimal.ZERO);
                inventario.setFechaInsert(new Date());
                //obtener el codigo de la clase seleccionada para armar el codigo de inventario
                TbcClaseActivo codigoClaseA = (TbcClaseActivo)tbcClaseActivoService.findByKey(inventario.getTbcClaseActivo().getIdClaseActivo());
                String CodigoClase=codigoClaseA.getCodigoClase();
                System.out.println("El codigo de la clase para general el codigo inventario:"+CodigoClase+"tamanio:"+CodigoClase.length());
                
                //ir a inventario y consultar el ultimo codigo con la clase que se ingreso devolver el codigo, convertilo a int y sumarle uno
                List<TbInventario> LastInv=tbInventarioService.LastCodInventario(inventario.getTbcClaseActivo().getIdClaseActivo());
                String Correlativo="";
                if(LastInv.size()!=0){
                    //extraer los ultimos digitos convertitlo a int, sumarle uno y luego concatenarlo con CodigoInventario
                    String LastCodInv=LastInv.get(0).getCodigoInventario();
                    int LongLastCod=LastCodInv.length();
                   //hacer la comparacion para determinar el tamano de la clase si tiene  2 digitos extraer del 7 si tiene 3 extraer de 8
                    String CodIncrement="";
                    if(CodigoClase.length()==2){
                         CodIncrement=LastCodInv.substring(7,LongLastCod);
                    }
                    if(CodigoClase.length()==3){
                         CodIncrement=LastCodInv.substring(8,LongLastCod);
                    
                    }
                    
                    
                    System.out.println("ULTIMOS DIGITOS DEL CODIGO;"+CodIncrement);
                    int CodIncrementInt=Integer.parseInt(CodIncrement);
                    int Increment=CodIncrementInt+1;
                    System.out.println("YA INCREMENTADO;"+Increment);
                    if(Increment<=99)
                    {
                       
                        if(Increment<=9){
                        Correlativo="00"+Increment;
                        }
                        else
                            Correlativo="0"+Increment;
                    }
                    else{
                       
                        Correlativo=String.valueOf(Increment);
                    }
                    
                }
                else{
                     Correlativo="001";
                }
                 
                String CodigoInventario=CodigoClasificacion+CodigoClase+Correlativo;
                System.out.println("codigo inventario a ingresar:"+CodigoInventario);
                inventario.setCodigoInventario(CodigoInventario);
                
                 //crear obj estado para set el id estado
                 TbcEstadoInventario estado=new TbcEstadoInventario();
                 estado.setIdEstado(1);
                 inventario.setTbcEstadoInventario(estado);
                    
                tbInventarioService.save(inventario);
                String message = "Pais was successfully added.";
                modelAndView.addObject("message", message);
                return insertarInventario(CodigoInventario);
	}
        
        
        //agregar por lotes
        @RequestMapping(value="/add/lotes", method=RequestMethod.POST)
	public ModelAndView InsertandoPorLotes(@ModelAttribute TbInventario inventario) {
		ModelAndView modelAndView = new ModelAndView("home");
		//uso valor libro para obtener temporalmente la cantidad de elementos a ingresar por lotes
                int cantidadlotes= Integer.parseInt(inventario.getValorLibro().toString());
                //inventario.setValorLibro(BigDecimal.ZERO);
                inventario.setFechaInsert(new Date());
                //obtener el codigo de la clase seleccionada para armar el codigo de inventario
                TbcClaseActivo codigoClaseA = (TbcClaseActivo)tbcClaseActivoService.findByKey(inventario.getTbcClaseActivo().getIdClaseActivo());
                String CodigoClase=codigoClaseA.getCodigoClase();
                System.out.println("El codigo de la clase para general el codigo inventario:"+CodigoClase+"tamanio:"+CodigoClase.length());
                
                //ir a inventario y consultar el ultimo codigo con la clase que se ingreso devolver el codigo, convertilo a int y sumarle uno
                List<TbInventario> LastInv=tbInventarioService.LastCodInventario(inventario.getTbcClaseActivo().getIdClaseActivo());
                String Correlativo="";
                if(LastInv.size()!=0){
                    //extraer los ultimos digitos convertitlo a int, sumarle uno y luego concatenarlo con CodigoInventario
                    String LastCodInv=LastInv.get(0).getCodigoInventario();
                    int LongLastCod=LastCodInv.length();
                    
                   //hacer la comparacion para determinar el tamano de la clase si tiene  2 digitos extraer del 7 si tiene 3 extraer de 8
                    String CodIncrement="";
                    if(CodigoClase.length()==2){
                         CodIncrement=LastCodInv.substring(7,LongLastCod);
                    }
                    if(CodigoClase.length()==3){
                         CodIncrement=LastCodInv.substring(8,LongLastCod);
                    
                    }
                
                    int CodIncrementInt=Integer.parseInt(CodIncrement);
                    int Increment=CodIncrementInt+1;
              
                    if(Increment<=99)
                    {
                       
                        if(Increment<=9){
                        Correlativo="00"+Increment;
                        }
                        else
                            Correlativo="0"+Increment;
                    }
                    else{
                       
                        Correlativo=String.valueOf(Increment);
                    }
                }
                else{
                     Correlativo="001";
                }
                 
                String CodigoInventario=CodigoClasificacion+CodigoClase+Correlativo;
                
                //Convertir correlativo a int
                int Icorrelativo=Integer.parseInt(Correlativo);
                Icorrelativo=Icorrelativo-1;
                             
                for(int i=0;i<cantidadlotes;i++){
                    Icorrelativo=Icorrelativo+1;
                     if(Icorrelativo<=99)
                    {
                        if(Icorrelativo<=9){
                        Correlativo="00"+Icorrelativo;
                        }
                        else
                            Correlativo="0"+Icorrelativo;
                    }
                    else
                       Correlativo=String.valueOf(Icorrelativo);
                     
                    
                    CodigoInventario=CodigoClasificacion+CodigoClase+Correlativo;
                    inventario.setCodigoInventario(CodigoInventario);
                    
                      //crear obj estado para set el id estado
                    TbcEstadoInventario estado=new TbcEstadoInventario();
                    estado.setIdEstado(1);
                    inventario.setTbcEstadoInventario(estado);
                    
                    tbInventarioService.save(inventario);
                }
               
                String message = "Pais was successfully added.";
                modelAndView.addObject("message", message);
                return insertarInventario("1");
	}
        
        //Agregar varios activos que pertenecesn al mismo codigo
        @RequestMapping(value="/add/mismocodigo", method=RequestMethod.POST)
	public @ResponseBody String InsertandoMismoCodigo(@RequestBody String inventario) {
		ModelAndView modelAndView = new ModelAndView("home");
		System.out.println("String Json:" + inventario);
                 
                JSONObject array = new JSONObject(inventario);
                System.out.println("Object Array:" + array);
                 JSONArray object = array.getJSONArray("Inventario");
                 System.out.println("Object JsonArray:" + object);
                 JSONObject object2 = object.getJSONObject(1);
                  System.out.println("Object2:" + object2);
                 String idClase = object2.getString("idClase");
                
                 //Convertir el idClase a int
                 int idClaseInt=Integer.parseInt(idClase);
                
                 System.out.println("ID CLASE:" + idClase);
                 
               
                //obtener el codigo de la clase seleccionada para armar el codigo de inventario
                TbcClaseActivo codigoClaseA = (TbcClaseActivo)tbcClaseActivoService.findByKey(idClaseInt);
                String CodigoClase=codigoClaseA.getCodigoClase();
                //ir a inventario y consultar el ultimo codigo con la clase que se ingreso devolver el codigo, convertilo a int y sumarle uno
                List<TbInventario> LastInv=tbInventarioService.LastCodInventario(idClaseInt);
                String Correlativo="";
                if(LastInv.size()!=0){
                    //extraer los ultimos digitos convertitlo a int, sumarle uno y luego concatenarlo con CodigoInventario
                    String LastCodInv=LastInv.get(0).getCodigoInventario();
                    int LongLastCod=LastCodInv.length();
                    //hacer la comparacion para determinar el tamano de la clase si tiene  2 digitos extraer del 7 si tiene 3 extraer de 8
                    String CodIncrement="";
                    if(CodigoClase.length()==2){
                         CodIncrement=LastCodInv.substring(7,LongLastCod);
                    }
                    if(CodigoClase.length()==3){
                         CodIncrement=LastCodInv.substring(8,LongLastCod);
                    
                    }
                    System.out.println("ULTIMOS DIGITOS DEL CODIGO;"+CodIncrement);
                    int CodIncrementInt=Integer.parseInt(CodIncrement);
                    int Increment=CodIncrementInt+1;
                    System.out.println("YA INCREMENTADO;"+Increment);
                    if(Increment<=99)
                    {
                       
                        if(Increment<=9){
                        Correlativo="00"+Increment;
                        }
                        else
                            Correlativo="0"+Increment;
                    }
                    else{
                       
                        Correlativo=String.valueOf(Increment);
                    }
                       
                    
                }
                else{
                     Correlativo="001";
                }
                 
                String CodigoInventario=CodigoClasificacion+CodigoClase+Correlativo;
                System.out.println("codigo inventario a ingresarCODIGOOOOOOOOO:"+CodigoInventario);
               // inventario.setCodigoInventario(CodigoInventario);
                for (int i = 0; i < object.length(); i++) 
                {
                    JSONObject ObjInv = object.getJSONObject(i);
                    System.out.println("objeto for"+ObjInv);
                    TbInventario inv=new TbInventario();
                    
                    inv.setCodigoInventario(CodigoInventario);
                    
                    inv.setDescripcionEquipo("");
                    
                    String fechaA=ObjInv.getString("fechaA");
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                     Date fechaADate=new Date();
                    try {
                      fechaADate = formatter.parse(fechaA);
                    } catch (ParseException ex) {
                    }
                    inv.setFechaAdquisicion(fechaADate);
                   
                    String financiamiento=ObjInv.getString("financiamiento");
                    inv.setFinanciamiento(financiamiento);
                    
                    String idLocalizacion=ObjInv.getString("idLocalizacion");
                    int idLocalizacionInt=Integer.parseInt(idLocalizacion);
                    inv.setIdLocalizacion(idLocalizacionInt);
                    
                     //crear obj estado para set el id estado
                    TbcEstadoInventario estado=new TbcEstadoInventario();
                    estado.setIdEstado(1);
                    inv.setTbcEstadoInventario(estado);
                    
                    String descripcion=ObjInv.getString("descripcion");
                    inv.setDescripcionEquipo(descripcion);
                    
                    
                    String idAsignado=ObjInv.getString("idCustodiade");
                    int idAsignadoInt=Integer.parseInt(idAsignado);
                    inv.setIdPersonaAsignado(idAsignadoInt);
                    
                    String marca=ObjInv.getString("marca");
                    inv.setMarca(marca);
                    
                    String modelo=ObjInv.getString("modelo");
                    inv.setModelo(modelo);
                    
                    String factura=ObjInv.getString("factura");
                    inv.setNFactura(factura);
                    
                    String serie=ObjInv.getString("serie");
                    inv.setSerie(serie);
                    
                    //crear obj clase activo para set el id clase
                    TbcClaseActivo clasA=new TbcClaseActivo();
                    clasA.setIdClaseActivo(idClaseInt);
                    inv.setTbcClaseActivo(clasA);
                    
                    //crear obj persona para set el id persona en custodia de
                     String idCustodiad = ObjInv.getString("idCustodiade");
                     int idCustodiadInt=Integer.parseInt(idCustodiad);
                     TbcPersona per=new TbcPersona();
                     per.setIdPersona(idCustodiadInt);
                     inv.setTbcPersona(per);
                     
                    String valor = ObjInv.getString("valor");
                    Double valodD=Double.parseDouble(valor);
                    BigDecimal valorB= BigDecimal.valueOf(valodD);
                    inv.setValor(valorB);
                    
                    inv.setValorLibro(valorB);
                    
                    tbInventarioService.save(inv);
                }
               // tbInventarioService.save(inventario);
                String message = "Pais was successfully added.";
                modelAndView.addObject("message", message);
                return "2";
	}
        
        
        @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deletePais(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
                
                //delete tbrmovinv
                List<TbrMovimientoInventario> tbrMov =  tbrMovInvService.findByInv(id);
        for (TbrMovimientoInventario tbrMov1 : tbrMov) {
            tbrMovInvService.delete(tbrMov1.getIdMovimientoInventario());
        }
                
                
                //fin delete tbr
                
                
		tbInventarioService.delete(id);
		String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
		return listActivos();
	}
        
        
        //CARGAR LA VISTA PARA EL BOTON DE ETL
        @RequestMapping(value="/ETLVISTA")
	public ModelAndView ETLVISTA() {
		ModelAndView modelAndView = new ModelAndView("ETLExito");

		//List inventario = tbInventarioService.getAll();
		//modelAndView.addObject("inventario", inventario);

		return modelAndView;
	}
        
        //para hacer el ETL de base intranet a base local
           @RequestMapping(value="/ETLInv/{id}", method=RequestMethod.GET)
	public ModelAndView ETLInventario(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("ETLExito");
                System.out.println("ingresacontroller");
               tbInventarioService.ETLInv();
               String message = "Pais was successfully deleted.";
		modelAndView.addObject("message", message);
	 return ETLVISTA();
	}
        
        
        @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editPaisPage(@PathVariable Integer id) {
		//ModelAndView modelAndView = new ModelAndView("actualizar_inventario");
		TbInventario inventario = (TbInventario) tbInventarioService.findByKey(id);
              //  TbcClasificacionActivo activo = (TbcClasificacionActivo) tbClasActService.findByKey(inventario.getTbcClasificacionActivo().getIdClasificacionActivo());
                
                  Map<String, Object> myModel = new HashMap<String, Object>();
                   List ClasAct = tbClasActService.getAll();  
                   List persona=tbcPersonaService.getAll();
                   List clasiLocalizacion=tbcClasificacionLocalizacionService.getAll();
                     List proveedor=tbcProveedorService.getAll();
                   myModel.put("inventario",inventario ); 
            
                   myModel.put("persona",persona);
                  myModel.put("clasiLocalizacion",clasiLocalizacion);
                  myModel.put("AllclasificacionA",ClasAct );
                 myModel.put("proveedor",proveedor);
                //System.out.println("A ver el combo:"+inventario.getTbcClasificacionActivo().getIdClasificacionActivo()+activo.getNombreClasificacion());
		//modelAndView.addObject("inventario",inventario);
		return new ModelAndView("actualizar_inventario",myModel);
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingPais(@ModelAttribute TbInventario inventario, @PathVariable Integer id) {
		TbInventario ActivoActual = (TbInventario) tbInventarioService.findByKey(id);
		ModelAndView modelAndView = new ModelAndView("home");
                
                ActivoActual.setMarca(inventario.getMarca());
		ActivoActual.setDescripcionEquipo(inventario.getDescripcionEquipo());
                ActivoActual.setFechaAdquisicion(inventario.getFechaAdquisicion());
                ActivoActual.setModelo(inventario.getModelo());
                ActivoActual.setNFactura(inventario.getNFactura());
                ActivoActual.setSerie(inventario.getSerie());
               
                ActivoActual.setTbcPersona(inventario.getTbcPersona());
                
                ActivoActual.setIdLocalizacion(inventario.getIdLocalizacion());
                ActivoActual.setValor(inventario.getValor());
                 ActivoActual.setFinanciamiento(inventario.getFinanciamiento());
                ActivoActual.setTbcProveedor(inventario.getTbcProveedor());
		tbInventarioService.update(ActivoActual);

		String message = "Pais was successfully edited.";
		modelAndView.addObject("message", message);

		return listActivos();
	}
    
}
