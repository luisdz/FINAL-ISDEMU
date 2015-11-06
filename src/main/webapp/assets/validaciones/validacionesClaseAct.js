/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  function validaClasificacion()
    {
        var x = document.forms["claseAF"]["dropdown1"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_dropdownT').removeClass("no-display");            
            $('#span_dropdownT').closest("div").addClass("has-error");            
             $('#span_dropdownT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_dropdownT').addClass("no-display");
             $('#span_dropdownT').closest("div").removeClass("has-error");
             $('#span_dropdownT').closest("div").addClass("has-success");
        }

    };
function validaClase()
    {
        var x = document.forms["claseAF"]["clase"].value;
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

function validaCodigo()
    {
        var x = document.forms["claseAF"]["codigoClase"].value;
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






 //Envio descargo     
 var  flag=true;

    function valida_envio()
    {
         
        flag=true;        
        
        
        if(validaClasificacion()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        }
        if(validaClase()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        } 
        if(validaCodigo()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
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




