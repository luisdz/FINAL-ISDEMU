/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Validaciones luis




function validaNombreRiesgo()
    {
        var x = document.forms["riesgoF"]["nombre"].value;
        if (x === null || x === "")
        {
             
            $('#span_nombreT').removeClass("no-display");            
            $('#span_nombreT').closest("div").addClass("has-error");            
             $('#span_nombreT').closest("div").removeClass("has-success");
             
            return false;
        }
        else
        {
            
            $('#span_nombreT').addClass("no-display");
             $('#span_nombreT').closest("div").removeClass("has-error");
             $('#span_nombreT').closest("div").addClass("has-success");
        }

};


function validaNombreClasLocal()
    {
        var x = document.forms["claslocalF"]["nombre"].value;
        if (x === null || x === "")
        {
             
            $('#span_nombreT').removeClass("no-display");            
            $('#span_nombreT').closest("div").addClass("has-error");            
             $('#span_nombreT').closest("div").removeClass("has-success");
             
            return false;
        }
        else
        {
            
            $('#span_nombreT').addClass("no-display");
             $('#span_nombreT').closest("div").removeClass("has-error");
             $('#span_nombreT').closest("div").addClass("has-success");
        }

};

function validaNombreProveedor()
    {
        var x = document.forms["proveedorF"]["nombre"].value;
        if (x === null || x === "")
        {
             
            $('#span_nombreT').removeClass("no-display");            
            $('#span_nombreT').closest("div").addClass("has-error");            
             $('#span_nombreT').closest("div").removeClass("has-success");
             
            return false;
        }
        else
        {
            
            $('#span_nombreT').addClass("no-display");
             $('#span_nombreT').closest("div").removeClass("has-error");
             $('#span_nombreT').closest("div").addClass("has-success");
        }

};


 function validaNombrePoliza()
    {
        var x = document.forms["polizaF"]["nombre"].value;
        if (x === null || x === "")
        {
             
            $('#span_nombreT').removeClass("no-display");            
            $('#span_nombreT').closest("div").addClass("has-error");            
             $('#span_nombreT').closest("div").removeClass("has-success");
             
            return false;
        }
        else
        {
            
            $('#span_nombreT').addClass("no-display");
             $('#span_nombreT').closest("div").removeClass("has-error");
             $('#span_nombreT').closest("div").addClass("has-success");
        }

    };
    
    function validaCodigoPoliza()
    {
        var x = document.forms["polizaF"]["codigo"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_codigoT').removeClass("no-display");            
            $('#span_codigoT').closest("div").addClass("has-error");            
             $('#span_codigoT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_codigoT').addClass("no-display");
             $('#span_codigoT').closest("div").removeClass("has-error");
             $('#span_codigoT').closest("div").addClass("has-success");
        }

    };
function validaFechaIniPoliza()
    {
        var x = document.forms["polizaF"]["fechaInicio"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fechaIniT').removeClass("no-display");            
            $('#span_fechaIniT').closest("div").addClass("has-error");            
             $('#span_fechaIniT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fechaIniT').addClass("no-display");
             $('#span_fechaIniT').closest("div").removeClass("has-error");
             $('#span_fechaIniT').closest("div").addClass("has-success");
        }

    };

function validaFechaFnPoliza()
    {
        var x = document.forms["polizaF"]["fechaFin"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fechaFnT').removeClass("no-display");            
            $('#span_fechaFnT').closest("div").addClass("has-error");            
             $('#span_fechaFnT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fechaFnT').addClass("no-display");
             $('#span_fechaFnT').closest("div").removeClass("has-error");
             $('#span_fechaFnT').closest("div").addClass("has-success");
        }

    };
    
  function validaFechaDescargo()
    {
        var x = document.forms["descargoF"]["fechaDescargo"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fechaFnT').removeClass("no-display");            
            $('#span_fechaFnT').closest("div").addClass("has-error");            
             $('#span_fechaFnT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fechaFnT').addClass("no-display");
             $('#span_fechaFnT').closest("div").removeClass("has-error");
             $('#span_fechaFnT').closest("div").addClass("has-success");
        }
            
    };  
function validaInvDescargo()
    {
        var x = document.forms["descargoF"]["dropdown"].value;
        //alert(x);
        if (x === "0")
        {
            //alert("error");
            //$('#span_nombre').addClass("symbol required");
            $('#span_cmbInv').removeClass("no-display");            
            $('#span_cmbInv').closest("div").addClass("has-error");            
             $('#span_cmbInv').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
           // alert("valido");
            //$('#span_nombre').to("required");
            $('#span_cmbInv').addClass("no-display");
             $('#span_cmbInv').closest("div").removeClass("has-error");
             $('#span_cmbInv').closest("div").addClass("has-success");
        }

    }; 

   
 //Envio descargo     
 var  flag=true;

    function valida_envio()
    {
         
        flag=true;        
        
        
        if(validaNombrePoliza()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        }
        if(validaCodigoPoliza()===false)
        {
         $('#mensajeErrorForm').removeClass("no-display");
             flag =  false;
        }
        
        if(validaFechaIniPoliza()===false)
        {
         $('#mensajeErrorForm').removeClass("no-display");
             flag =  false;
        }
        
        if(validaFechaFnPoliza()===false)
        {
         $('#mensajeErrorForm').removeClass("no-display");
             flag =  false;
        }
       return flag;
       
    };
    function valida_envioDescargo()
    {
         
        flag=true;        
        
        
        if(validaFechaDescargo()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        }
        if(validaInvDescargo()===false)
        {
         $('#mensajeErrorForm').removeClass("no-display");
             flag =  false;
        }
        
        
       return flag;
       
    };
    
    function valida_envioProveedor()
    {
         
        flag=true;        
        
        
        if(validaNombreProveedor()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        }
         
        
        
       return flag;
       
    };
    
    function valida_envioClasLocal()
    {
         
        flag=true;        
        
        
        if(validaNombreClasLocal()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        }
         
        
        
       return flag;
       
    };
    
    function valida_envioRiesgo()
    {
         
        flag=true;        
        
        
        if(validaNombreRiesgo()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        }
         
        
        
       return flag;
       
    };


  



    $(document).ready(function ()
    {        
        console.log("ready!");
    });
    
$(window).click(function ()
    {
      
     $('#mensajeExitoFormM').addClass("no-display");
     var b = $("#ingresar").val();      
     if(b==="0") {   
         $('#mensajeErrorFormM').addClass("no-display"); 
     };     
     $("#ingresar").val(0);
    }); 
 
//Fuciones Descargo
function condigoYaAgregado(cod)
    {
        var l = 0;
        var flag = true;
        $('#tabla_prueba tr').each(function (index, element) {
            if (l != 0)
            {
                if ($(element).find("td").eq(1).html() === cod)
                {
                    flag = false;
                }
            }
            l = 1;
        });
        return flag;
    };

//Fin funciones descargo

//Validaciones movimiento
//?
function validaFechaMovimiento()
    {
        var x = document.forms["polizaF"]["fechaInicio"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fechaIniT').removeClass("no-display");            
            $('#span_fechaIniT').closest("div").addClass("has-error");            
             $('#span_fechaIniT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fechaIniT').addClass("no-display");
             $('#span_fechaIniT').closest("div").removeClass("has-error");
             $('#span_fechaIniT').closest("div").addClass("has-success");
        }

    };
function validaFechaMov()
    {
        var x = document.forms["movF"]["fechaMov"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fecha').removeClass("no-display");            
            $('#span_fecha').closest("div").addClass("has-error");            
             $('#span_fecha').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fecha').addClass("no-display");
             $('#span_fecha').closest("div").removeClass("has-error");
             $('#span_fecha').closest("div").addClass("has-success");
             return true;
        }
            
    }; 
    
    function validaRespMov()
    {
        var x = document.forms["movF"]["responsable"].value;
        //alert(x);
        if (x === "0")
        {
            //alert("error");
            //$('#span_nombre').addClass("symbol required");
            $('#span_resp').removeClass("no-display");            
            $('#span_resp').closest("div").addClass("has-error");            
             $('#span_resp').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
           // alert("valido");
            //$('#span_nombre').to("required");
            $('#span_resp').addClass("no-display");
             $('#span_resp').closest("div").removeClass("has-error");
             $('#span_resp').closest("div").addClass("has-success");
              return true;
        }

    }; 
//Fin funciones movimiento

//reporte asignado a
 function validaRespRepAsign()
    {
        var x = document.forms["repAsign"]["responsable"].value;
        //alert(x);
        if (x === "0")
        {
            //alert("error");
            //$('#span_nombre').addClass("symbol required");
            $('#span_resp').removeClass("no-display");            
            $('#span_resp').closest("div").addClass("has-error");            
             $('#span_resp').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
           // alert("valido");
            //$('#span_nombre').to("required");
            $('#span_resp').addClass("no-display");
             $('#span_resp').closest("div").removeClass("has-error");
             $('#span_resp').closest("div").addClass("has-success");
              return true;
        }

    }; 
//fin reporte asignado a