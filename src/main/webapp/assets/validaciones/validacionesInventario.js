/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function validaClasificacion()
    {
       
        var x = document.forms["inventarioF"]["dropdown1"].value;
        if (x === null || x === "" || x === "0")
        {
 
            $('#span_dropdownT').removeClass("no-display");            
            $('#span_dropdownT').closest("div").addClass("has-error");            
             $('#span_dropdownT').closest("div").removeClass("has-success");
            
            return false;
        }
        else
        {
        
            $('#span_dropdownT').addClass("no-display");
             $('#span_dropdownT').closest("div").removeClass("has-error");
             $('#span_dropdownT').closest("div").addClass("has-success");
        }

    };
    
function validaClase()
    {
       
        var x = document.forms["inventarioF"]["dropdown2"].value;
        if (x === null || x === "" || x === "0")
        {
            
            $('#span_dropdown2T').removeClass("no-display");            
            $('#span_dropdown2T').closest("div").addClass("has-error");            
             $('#span_dropdown2T').closest("div").removeClass("has-success");
            
            return false;
        }
        else
        {
      
            $('#span_dropdown2T').addClass("no-display");
             $('#span_dropdown2T').closest("div").removeClass("has-error");
             $('#span_dropdown2T').closest("div").addClass("has-success");
        }

    };
    
function validaCustodia()
    {
       
        var x = document.forms["inventarioF"]["persona"].value;
        if (x === null || x === "" || x === "0")
        {
         
            $('#span_personaT').removeClass("no-display");            
            $('#span_personaT').closest("div").addClass("has-error");            
             $('#span_personaT').closest("div").removeClass("has-success");
            
            return false;
        }
        else
        {
       
            $('#span_personaT').addClass("no-display");
             $('#span_personaT').closest("div").removeClass("has-error");
             $('#span_personaT').closest("div").addClass("has-success");
        }

    };
    
     function validaUbicacion()
    {
       
        var x = document.forms["inventarioF"]["tipoClasificacion"].value;
        if (x === null || x === "" || x === "0")
        {
       
            $('#span_ubicacionT').removeClass("no-display");            
            $('#span_ubicacionT').closest("div").addClass("has-error");            
             $('#span_ubicacionT').closest("div").removeClass("has-success");
            
            return false;
        }
        else
        {
       
            $('#span_ubicacionT').addClass("no-display");
             $('#span_ubicacionT').closest("div").removeClass("has-error");
             $('#span_ubicacionT').closest("div").addClass("has-success");
        }

    };
    
    function validatipoLocalizacion()
    {
       
        var x = document.forms["inventarioF"]["tipoClasificacion"].value;
        if (x === null || x === "" || x === "0")
        {
       
            $('#span_localizaciontipoT').removeClass("no-display");            
            $('#span_localizaciontipoT').closest("div").addClass("has-error");            
             $('#span_localizaciontipoT').closest("div").removeClass("has-success");
            
            return false;
        }
        else
        {
       
            $('#span_localizaciontipoT').addClass("no-display");
             $('#span_localizaciontipoT').closest("div").removeClass("has-error");
             $('#span_localizaciontipoT').closest("div").addClass("has-success");
        }

    };
    
function validaLocalizacion()
    {
       
        var x = document.forms["inventarioF"]["localizacion"].value;
        if (x === null || x === "" || x === "0")
        {
       
            $('#span_localizacionT').removeClass("no-display");            
            $('#span_localizacionT').closest("div").addClass("has-error");            
             $('#span_localizacionT').closest("div").removeClass("has-success");
            
            return false;
        }
        else
        {
       
            $('#span_localizacionT').addClass("no-display");
             $('#span_localizacionT').closest("div").removeClass("has-error");
             $('#span_localizacionT').closest("div").addClass("has-success");
        }

    };
    
    function validaMarca()
    {
        var x = document.forms["inventarioF"]["marca"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_marcaT').removeClass("no-display");            
            $('#span_marcaT').closest("div").addClass("has-error");            
             $('#span_marcaT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_marcaT').addClass("no-display");
             $('#span_marcaT').closest("div").removeClass("has-error");
             $('#span_marcaT').closest("div").addClass("has-success");
        }

    };
function validaModelo()
    {
        var x = document.forms["inventarioF"]["modelo"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_modeloT').removeClass("no-display");            
            $('#span_modeloT').closest("div").addClass("has-error");            
             $('#span_modeloT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_modeloT').addClass("no-display");
             $('#span_modeloT').closest("div").removeClass("has-error");
             $('#span_modeloT').closest("div").addClass("has-success");
        }

    };

function validaSerie()
    {
        var x = document.forms["inventarioF"]["serie"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_serieT').removeClass("no-display");            
            $('#span_serieT').closest("div").addClass("has-error");            
             $('#span_serieT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_serieT').addClass("no-display");
             $('#span_serieT').closest("div").removeClass("has-error");
             $('#span_serieT').closest("div").addClass("has-success");
        }

    };
    
    function validaClaseEquipo()
    {
        var x = document.forms["inventarioF"]["claseEquipo"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_claseT').removeClass("no-display");            
            $('#span_claseT').closest("div").addClass("has-error");            
             $('#span_claseT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_claseT').addClass("no-display");
             $('#span_claseT').closest("div").removeClass("has-error");
             $('#span_claseT').closest("div").addClass("has-success");
        }

    };
    
function validaValor()
    {
        var x = document.forms["inventarioF"]["cantidadl"].value;
        if (x < 0)
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_valorCT').removeClass("no-display");            
            $('#span_valorCT').closest("div").addClass("has-error");            
             $('#span_valorCT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_valorCT').addClass("no-display");
             $('#span_valorCT').closest("div").removeClass("has-error");
             $('#span_valorCT').closest("div").addClass("has-success");
        }

    };
    
function validaFactura()
    {
        var x = document.forms["inventarioF"]["factura"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_facturaT').removeClass("no-display");            
            $('#span_facturaT').closest("div").addClass("has-error");            
             $('#span_facturaT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_facturaT').addClass("no-display");
             $('#span_facturaT').closest("div").removeClass("has-error");
             $('#span_facturaT').closest("div").addClass("has-success");
        }

    };
    
function validaFinanciamiento()
    {
        var x = document.forms["inventarioF"]["financiamiento"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_financiamientoT').removeClass("no-display");            
            $('#span_financiamientoT').closest("div").addClass("has-error");            
             $('#span_financiamientoT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_financiamientoT').addClass("no-display");
             $('#span_financiamientoT').closest("div").removeClass("has-error");
             $('#span_financiamientoT').closest("div").addClass("has-success");
        }

    };
    
function validaFechaAdq()
    {
        var x = document.forms["inventarioF"]["fecha_adq"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fechaAdq').removeClass("no-display");            
            $('#span_fechaAdq').closest("div").addClass("has-error");            
             $('#span_fechaAdq').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fechaAdq').addClass("no-display");
             $('#span_fechaAdq').closest("div").removeClass("has-error");
             $('#span_fechaAdq').closest("div").addClass("has-success");
        }

    };
       
 //Envio descargo     
 var  flag=true;

    function valida_envio()
    {
         
        flag=false;        
        
        
        if(validaClasificacion()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        
        if(validaClase()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaCustodia()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaUbicacion()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        } 
        if(validatipoLocalizacion()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaLocalizacion()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaMarca()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaModelo()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaSerie()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaValor()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaFactura()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaFinanciamiento()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        if(validaFechaAdq()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
       return flag;
       
    };

    //Envio descargo


    $(window).click(function ()
    {
         $('#mensajeErrorForm').addClass("no-display");       
    });  
    



    $(document).ready(function ()
    {        
        console.log("ready!");
    });
