/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validaJefe()
    {
        var x = document.forms["claveF"]["jefe"].value;
        var y = document.forms["claveF"]["jefe2"].value;
        if (x === y )
        {
             //$('#span_nombre').to("required");
            $('#span_jefeT').addClass("no-display");
             $('#span_jefeT').closest("div").removeClass("has-error");
             $('#span_jefeT').closest("div").addClass("has-success");
            
        }
        else
        {
                       
             //$('#span_nombre').addClass("symbol required");
            $('#span_jefeT').removeClass("no-display");            
            $('#span_jefeT').closest("div").addClass("has-error");            
             $('#span_jefeT').closest("div").removeClass("has-success");

            return false;
        }

    };


 //Envio descargo     
 var  flag=true;

    function valida_envio()
    {
         
        flag=true;        
        

        if(validaJefe()===false)
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



