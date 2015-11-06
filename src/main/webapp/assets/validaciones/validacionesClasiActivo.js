/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  function validaNombre()
    {
        var x = document.forms["clasificacionAF"]["clasificacion"].value;
        if (x === null || x === "")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_nombreT').removeClass("no-display");            
            $('#span_nombreT').closest("div").addClass("has-error");            
             $('#span_nombreT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_nombreT').addClass("no-display");
             $('#span_nombreT').closest("div").removeClass("has-error");
             $('#span_nombreT').closest("div").addClass("has-success");
        }

    };

function validaCodigo()
    {
        var x = document.forms["clasificacionAF"]["codigoClasi"].value;
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
        
        if(validaNombre()===false)
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


