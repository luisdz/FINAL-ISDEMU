/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

function validaSolicitante()
    {
        
        var x = document.forms["controlE"]["solicitante"].value;
        if (x === null || x === "")
        {
             
            $('#span_solicitanteT').removeClass("no-display");            
            $('#span_solicitanteT').closest("div").addClass("has-error");            
             $('#span_solicitanteT').closest("div").removeClass("has-success");
             
            return false;
        }
        else
        {
            
            $('#span_solicitanteT').addClass("no-display");
             $('#span_solicitanteT').closest("div").removeClass("has-error");
             $('#span_solicitanteT').closest("div").addClass("has-success");
        }

    };
    
    
    function validaDestino()
    {
        var x = document.forms["controlE"]["destino"].value;
        if (x === null || x === "")
        {
             
            $('#span_destinoT').removeClass("no-display");            
            $('#span_destinoT').closest("div").addClass("has-error");            
             $('#span_destinoT').closest("div").removeClass("has-success");
             
            return false;
        }
        else
        {
            
            $('#span_destinoT').addClass("no-display");
             $('#span_destinoT').closest("div").removeClass("has-error");
             $('#span_destinoT').closest("div").addClass("has-success");
        }

    };
    
    function validaFechaSalida()
    {
        var x = document.forms["controlE"]["fecha_sal"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fechaSal').removeClass("no-display");            
            $('#span_fechaSal').closest("div").addClass("has-error");            
             $('#span_fechaSal').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fechaSal').addClass("no-display");
             $('#span_fechaSal').closest("div").removeClass("has-error");
             $('#span_fechaSal').closest("div").addClass("has-success");
        }

    };
    
    function validaFechaTentativo()
    {
        var x = document.forms["controlE"]["fecha_devolucion"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_fechaTen').removeClass("no-display");            
            $('#span_fechaTen').closest("div").addClass("has-error");            
             $('#span_fechaTen').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_fechaTen').addClass("no-display");
             $('#span_fechaTen').closest("div").removeClass("has-error");
             $('#span_fechaTen').closest("div").addClass("has-success");
        }

    };
      
 var  flag=true;

    function valida_envio()
    {
         
        flag=false;        
        
        
        if(validaSolicitante()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
       
        
        if(validaDestino()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        
        if(validaFechaSalida()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
        
        if(validaFechaTentativo()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = true;
        }
   
 
        
       return flag;
       
    };


    $(window).click(function ()
    {
         $('#mensajeErrorForm').addClass("no-display");       
    });  
    



    $(document).ready(function ()
    {        
        console.log("ready!");
    });


