<%-- 
    Document   : prestamo
    Created on : 26-jul-2015, 21:30:38
    Author     : Miranda
--%>

<%@include file="header.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- start: BREADCRUMB -->
<div class="row">
        <div class="col-md-12">
                <ol class="breadcrumb">
                        <li>
                                <a href="#">
                                        Prestamo Equipo
                                </a>
                        </li>
                        <li class="active">
                                Ingreso Prestamo Equipo
                        </li>
                </ol>
        </div>
</div>
<!-- end: BREADCRUMB -->
                                                
<!-- start: PAGE CONTENT -->

<div class="row">
        <div class="col-md-12">
            <!-- start: FORM VALIDATION 1 PANEL -->
            <div class="panel panel-white">
                <div class="panel-heading">
                        <h4 class="panel-title">Formulario de <span class="text-bold">Ingreso Prestamo de Equipo</span></h4>
                    <div class="panel-tools">
                            <div class="dropdown">
                                    <a data-toggle="dropdown" class="btn btn-xs dropdown-toggle btn-transparent-grey">
                                            <i class="fa fa-cog"></i>
                                    </a>
                                    <ul class="dropdown-menu dropdown-light pull-right" role="menu">
                                            <li>
                                                    <a class="panel-collapse collapses" href="#"><i class="fa fa-angle-up"></i> <span>Collapse</span> </a>
                                            </li>
                                            <li>
                                                    <a class="panel-refresh" href="#">
                                                            <i class="fa fa-refresh"></i> <span>Refresh</span>
                                                    </a>
                                            </li>
                                            <li>
                                                    <a class="panel-config" href="#panel-config" data-toggle="modal">
                                                            <i class="fa fa-wrench"></i> <span>Configurations</span>
                                                    </a>
                                            </li>
                                            <li>
                                                    <a class="panel-expand" href="#">
                                                            <i class="fa fa-expand"></i> <span>Fullscreen</span>
                                                    </a>
                                            </li>
                                    </ul>
                            </div>
                            <a class="btn btn-xs btn-link panel-close" href="#">
                                    <i class="fa fa-times"></i>
                            </a>
                    </div>
                </div>
                <div class="panel-body">
                    <h2><i class="fa fa-pencil-square"></i> Prestamo Equipo</h2>
                    <p>
                            Ingreso de Prestamo Equipo de ISDEMU
                    </p>
                    <hr>
              <form:form method="POST" action="${pageContext.request.contextPath}/Prestamo/add" modelAttribute="prestamo" id="prestamoE" name="prestamoE">
                        <div class="row">
                                <div class="col-md-12">
                                    <div class="errorHandler alert alert-danger no-display" id="mensajeErrorFormM"  >
                                        <i class="fa fa-times-sign"></i> No se puede realizar la accion, existen errores en la informacion.
                                    </div>
                                    <div id="mensajeExitoFormM" class="successHandler alert alert-success no-display">
                                        <i class="fa fa-ok"></i> Guardado con Exito!
                                    </div>
                                </div>
                                <div class="col-md-6">
    
                                   
                                    <div class="form-group">
                                                <label class="control-label">
                                                        N Prestamo<span id="span_numero" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="NPrestamo" type="text" class="form-control" id="numero" name="numero" onkeypress="return valideKey(event);" onblur="return validaNumero(event);"/>
                                                <span for="numero" class="help-block  no-display" id="span_numeroT">Ingrese un Numero</span>                   
                                    </div>
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Tema Impartir<span id="span_nombre" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="temaImpartir" type="text" placeholder="Tema" class="form-control" id="tema" name="tema" onblur="return validaTema(event);"/>
                                                <span for="nombre" class="help-block  no-display" id="span_nombreT">Ingrese un Tema</span> 
                                    </div>
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Persona a Impartir<span id="span_persona" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="personaImpartir" type="text" placeholder="persona" class="form-control" id="persona" name="persona" onblur="return validaPersona(event);"/>
                                                <span for="persona" class="help-block  no-display" id="span_personaT">Ingrese un Persona</span> 
                        
                                    </div>
                                    <div class="form-group">
                                            <label class="control-label">
                                                    Destino<span id="span_destino" class="symbol"></span>
                                            </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                            <form:input path="destino" type="text" placeholder="destino" class="form-control" id="destino" name="destino" onblur="return validaDestino(event);"/>
                                            <span for="destino" class="help-block  no-display" id="span_destinoT">Ingrese un Destino</span> 
                
                                    </div>
                                                                                
                                </div>
                                <div class="col-md-6">
                                    
                                   <div class="form-group">
                                        <label class="control-label">
                                                Fecha Solicitud<span id="span_sol" class="symbol"></span>
                                        </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                        <form:input path="fechaSolicitud" type="text" id="fecha_sol" name="fecha_sol" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker" onchange="return validaFechaSolicitud(event);" onblur="return validaFechaSolicitud(event);"/>
                                        <span for="fecha_sol" class="help-block  no-display" id="span_fechaSol">Ingrese una fecha solicitud</span>    

                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">
                                                Fecha Reservacion<span id="span_pres" class="symbol"></span>
                                        </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                        <form:input path="fechaReservacion" type="text" id="fecha_pres" name="fecha_pres" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker" onchange="return validaFechaReservacion(event);" onblur="return validaFechaReservacion(event);"/>
                                        <span for="fecha_pres" class="help-block  no-display" id="span_fechaRes">Ingrese una fecha reservacion</span>    

                                    </div>
                                   <!--  <div class="form-group">
                                        <label class="control-label">
                                                Hora Inicio<span class="symbol required"></span>
                                        </label>
                                                   <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">
                                        <form:input path="horaInicio" type="text" id="hora_inicio" name="hora_inicio" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker"/>

                                    </div>-->
                                     <!-- <div class="form-group">
                                        <label class="control-label">
                                                Hora Fin<span class="symbol required"></span>
                                        </label>
                                                  <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">
                                        <form:input path="horaFin" type="text" id="hora_fin" name="hora_fin" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker"/>

                                    </div> -->
                                    
                                   
                                </div>                                       
                             </div>
                         <div class="col-md-12 text-center">            
                                <div class="form-group" align="center">
                                    <label class="control-label">
                                        Codigo Inventario<span class="symbol "></span>
                                    </label>
                                    <form:input path=""  type="text" placeholder="Ingrese un codigo" class="form-control" id="codigo" name="codigo" style="width:50%" />
                                    <span for="codigo" class="help-block  no-display" id="span_codigoE">El codigo es invalido o ya esta agreagado</span>  
                                    <span for="codigo" class="help-block  no-display" id="span_codigoE2">El inventario con ese codigo esta descargado</span>  

                                 </div> 
                            </div>
                            <div class="col-md-12 text-center">
                                <button type="button" class="btn btn-default" onclick="enviarCodeM();" >Agregar</button>  
                                &nbsp;<br/><br/>
                            </div>      
                        
                       <div class="table-responsive">
                            <table class="table table-striped table-hover table-bordered" id="tabla_prueba">
                                    <thead>
                                            <tr>
                                                <th class="no-display">id</th>
                                                <th>codigo</th>
                                                <th>Clase</th>
                                                <th>Descripcion</th>  
                                                <th>Eliminar</th>
                                            </tr>
                                    </thead>
                                    <tbody id="tablabody" name="tablabody">
                                        
                                        
                                    </tbody>
                            </table>    
                                        
                                        
                            </table>
                        </div>        
                        
                        <div class="row">
                                <div class="col-md-8">
                                       
                                </div>
                                <div class="col-md-4">
                                        <button class="btn btn-yellow btn-block" type="button" onclick="enviar();">
                                                Guardar <i class="fa fa-arrow-circle-right"></i>
                                        </button>
                                </div>
                        </div>
                   
                        </form:form>
                   </div>
                </div>
            </div>
            <!-- end: FORM VALIDATION 1 PANEL -->
        </div>

<%@include file="footer.jsp" %>	
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesPrestamo.js"></script>

<script>
    
    function myFunction_personal(){
        if (document.prestamoE.dropdown1.selectedIndex==0){ 
        alert("Debe seleccionar un inventario para agregar a la tabla")
      return 0; 
   	}

                  var id = $("#dropdown1").val();
                  var numero = $('#dropdown1 option:selected').text();
                      $('#tabla_prueba').append('<tr id="' + id + '"><td>' + id + '</td><td>' + numero + '</td><td class="eliminar"><a href="" onclick="return deleteElement('+"'"+ id +"'"+ ');"><span class="glyphicon glyphicon-remove"></span></a></td></tr>');
      
    };

    function deleteElement(id){
        var el = document.getElementById(id);
        el.parentNode.removeChild(el);
        return false;
        }
        
    function enviar()
    {
      
      if (valida_envio()){      
        return 0; 
         }
        
        var nPrestamo=$("#numero").val();
        var tema=$("#tema").val();
        var persona=$("#persona").val();
        var destino=$("#destino").val();
        var fecha_solic=$("#fecha_sol").val();
        var fecha_reser=$("#fecha_pres").val();
        var hora_inicio=$("#hora_inicio").val();
        var hora_fin=$("#hora_fin").val();
        
        var jsonArray="{"
        
      
        jsonArray+="\"Prestamo\":[{\"nPrestamo\":\""+nPrestamo+"\",\"destino\":\""+destino+"\",\"hora_inicio\":\""+hora_inicio+"\",\"hora_fin\":\""+hora_fin+"\",\"tema\":\""+tema+"\",\"persona\":\""+persona+"\",\"fecha_solic\":\""+fecha_solic+"\",\"fecha_reser\":\" "+fecha_reser+"\""+"}],";
         
         jsonArray+="\"Inventario\":[";
        
        var l=0;
        var bandera = 0;
        $('#tabla_prueba tr').each(function(index, element){

        var id = $(element).find("td").eq(0).html();
      
        if(l!=0){
            jsonArray=jsonArray+"{\"idInv\":"+'"'+id+'"'+"},";
    bandera=1;
          }

        l=1;

    });


    jsonArray=jsonArray.substring(0,jsonArray.length-1);
    jsonArray=jsonArray+"]}";
    if(bandera==0)
    {
        alert("Debe ingresar al menos un activo");
        return 0;
    }
    //alert(jsonArray);
         $.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/Prestamo/add",
           dataType: "json",
           contentType: 'application/json',
           success: function (msg) {
               $('#mensajeExitoFormM').removeClass("no-display");
               document.getElementById('numero').value="";
               document.getElementById('tema').value="";
               document.getElementById('persona').value="";
               document.getElementById('destino').value="";
               document.getElementById('fecha_sol').value="";
               document.getElementById('fecha_pres').value="";
               document.getElementById('hora_inicio').value="";
               document.getElementById('hora_fin').value="";
               $("#tablabody").empty();
           },
           data: jsonArray
       });
        
    }
                    
    
       function valideKey(evt)
		    {
		        var code = (evt.which) ? evt.which : evt.keyCode;
		            if(code==8)
		            {
		                //backspace
		                return true;
		            }
		            else if(code>=48 && code<=57)
		            {
		                //is a number
		                return true;
		            }
		            else
		            {
		                return false;
		            }
		    };
                    
                    
       function enviarCodeM()
    {
        var codigoI = $("#codigo").val(); 
        if (codigoI=="")
        {
            return 0;
        }
        if (condigoYaAgregado(codigoI) === true)
        {

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/Control/agregarInventarioM",
                dataType: "json",
                contentType: 'application/json',
                data: codigoI,
                success: function (listaInv)
                {
                    
                    var num = 0;
                    listaInv.forEach(function (entry1)
                    {
                        num++;
                    });
                    if (num >= 1)
                    {
                        
                        listaInv.forEach(function (entry)
                        {
                             if(false)
                            {
                              
                            } 
                            else
                            {
                               
                            //console.log(entry);
                            $('#tabla_prueba').append('<tr  id="' + entry.idInventario + '">' + '<td class=\"no-display\" >' + entry.idInventario + '</td>' + '<td>' + entry.codigoInventario + '</td>' + '</td>' + '<td>' + entry.tbcClaseActivo.nombreClase + '</td>' + '<td>' + entry.descripcionEquipo + '</td><td class="eliminar"><a href="" onclick="return deleteElement(' + "'" + entry.idInventario + "'" + ');"><span class="glyphicon glyphicon-remove"></span></a></td></tr>');
                            $('#span_codigoE').addClass("no-display");
                            $('#span_codigoE').closest("div").removeClass("has-error");
                        }
                        });
                            
                      if ($('#tabla_prueba tr').size() <= 1)
                     {
                         $('#span_codigoE2').delay(0).fadeIn(1000).fadeOut(5000);
                          //$('#span_codigoE').addClass("no-display");
                     }  

                    }
                    else
                    {
                        $('#span_codigoE').removeClass("no-display");
                        $('#span_codigoE').closest("div").addClass("has-error");
                        $('#span_codigoE').closest("div").removeClass("has-success");
                    }
                },
                error: function (data, status, er) {
                    alert("error: " + data + " status: " + status + " er:" + er);
                }

            });//Fin .ajax
        }
        else
        {
            $('#span_codigoE').removeClass("no-display");
            $('#span_codigoE').closest("div").addClass("has-error");
            $('#span_codigoE').closest("div").removeClass("has-success");
        }

    }
    ;              
                    
    $( document ).ready(function() {


           $('#dropdown1').select2();


       });
            

</script>
