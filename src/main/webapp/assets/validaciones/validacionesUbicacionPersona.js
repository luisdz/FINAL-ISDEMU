/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validaUbicacion()
    {
       
        var x = document.forms["personaF"]["dropdown"].value;
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
    
 function validaPersona()
    {
       
        var x = document.forms["personaF"]["dropdown1"].value;
        if (x === null || x === "" || x === "0")
        {
             
            $('#span_dropdown1T').removeClass("no-display");            
            $('#span_dropdown1T').closest("div").addClass("has-error");            
            $('#span_dropdown1T').closest("div").removeClass("has-success");
            
            return false;
        }
        else
        {
         
            $('#span_dropdown1T').addClass("no-display");
            $('#span_dropdown1T').closest("div").removeClass("has-error");
            $('#span_dropdown1T').closest("div").addClass("has-success");
        }

    };

function validaJefe()
    {
        var x = document.forms["personaF"]["jefe"].value;
        if (x === null || x === "" || x === "0")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_jefeT').removeClass("no-display");            
            $('#span_jefeT').closest("div").addClass("has-error");            
             $('#span_jefeT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_jefeT').addClass("no-display");
             $('#span_jefeT').closest("div").removeClass("has-error");
             $('#span_jefeT').closest("div").addClass("has-success");
        }

    };

function validaEncargado()
    {
        var x = document.forms["personaF"]["encargado"].value;
        if (x === null || x === "" || x === "0")
        {
            //$('#span_nombre').addClass("symbol required");
            $('#span_encargadoT').removeClass("no-display");            
            $('#span_encargadoT').closest("div").addClass("has-error");            
             $('#span_encargadoT').closest("div").removeClass("has-success");

            return false;
        }
        else
        {
            //$('#span_nombre').to("required");
            $('#span_encargadoT').addClass("no-display");
             $('#span_encargadoT').closest("div").removeClass("has-error");
             $('#span_encargadoT').closest("div").addClass("has-success");
        }

    };
       
 //Envio descargo     
 var  flag=true;

    function valida_envio()
    {
         
        flag=true;        
        
        if(validaUbicacion()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        } 
        if(validaPersona()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        } 
        if(validaJefe()===false)
        {        
            $('#mensajeErrorForm').removeClass("no-display");
            flag = false;
        } 
        if(validaEncargado()===false)
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



