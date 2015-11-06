<%-- 
    Document   : actualizar_control
    Created on : 05-ago-2015, 21:48:32
    Author     : Walter
--%>

<%@include file="header.jsp"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: BREADCRUMB -->
<div class="row">
        <div class="col-md-12">
                <ol class="breadcrumb">
                        <li>
                                <a href="#">
                                        Control Salida
                                </a>
                        </li>
                        <li class="active">
                                Etidar Control Salida
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
                                <h4 class="panel-title">Edicion de <span class="text-bold">Control</span></h4>
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
                                <h2><i class="fa fa-pencil-square"></i> Control de Salida</h2>
                              
                        <hr>


<form:form method="POST" action="${pageContext.request.contextPath}/Control/editControl1/${control.idControlSalida}" modelAttribute="control" id="controlE" name="controlE">
    
       
               <div class="row">
                                <div class="col-md-12">
                                    <div class="errorHandler alert alert-danger no-display" id="mensajeErrorForm">

                                        <i class="fa fa-times-sign"></i> You have some form errors. Please check below.
                                    </div>
                                    <div class="successHandler alert alert-success no-display">
                                        <i class="fa fa-ok"></i> Your form validation is successful!
                                    </div>
                                </div>
                                <div class="col-md-6">
    
                                                                      
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Solicitante<span id="span_solicitante" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="solicitante" type="text" class="form-control" id="solicitante" name="solicitante" onblur="return validaSolicitante(event);"/>
                                                <span for="solicitante" class="help-block  no-display" id="span_solicitanteT">Ingrese un Solicitante</span>                   
                
                                    </div>
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Observacion<span id="span_observacion" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="observacion" type="text" class="form-control" id="observacion" name="observacion" onblur="return validaObservacion(event);"/>
                                                <span for="observacion" class="help-block  no-display" id="span_observacionT">Ingrese una Observacion</span>                   
                
                                    </div>
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Destino<span id="span_destino" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="destino" type="text" class="form-control" id="destino" name="destino" onblur="return validaDestino(event);" />
                                                <span for="destino" class="help-block  no-display" id="span_destinoT">Ingrese un Destino</span>                   
                
                                    </div>                                            
                                </div>
                                <div class="col-md-6">                                    
                                   
                                    <div class="form-group">
                                        <label class="control-label">
                                                Fecha Salida<span id="span_sal" class="symbol"></span>
                                        </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                        <form:input path="fechaSalida" type="text" id="fecha_sal" name="fecha_sal" data-date-format="yyyy-mm-dd" data-date-viewmode="years" class="form-control date-picker" onchange="return validaFechaSalida(event);" onblur="return validaFechaSalida(event);"/>
                                        <span for="fecha_sal" class="help-block  no-display" id="span_fechaSal">Ingrese una fecha salida</span>    

                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="control-label">
                                                Fecha Tentativo Devolucion<span id="span_ten" class="symbol"></span>
                                        </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                        <form:input path="fechaTentativaDevolucion" type="text" id="fecha_devolucion" name="fecha_devolucion" data-date-format="yyyy-mm-dd" data-date-viewmode="years" class="form-control date-picker" onchange="return validaFechaTentativo(event);" onblur="return validaFechaTentativo(event);"/>
                                        <span for="fecha_ten" class="help-block  no-display" id="span_fechaTen">Ingrese una fecha tentativa devolucion</span>    

                                    </div>
                                    
                                   
                                </div>                                       
                             </div>
                
               <div class="row">

                           
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
                        <table class="table table-striped table-hover" id="tabla_prueba">
                                <thead>
                                        <tr>
                                            <th class="no-display">id</th>
                                            <th>Codigo Inv</th>                                             
                                            <th>Clase Activo</th>
                                            <th>Descripcion</th>
                                            <th>Eliminar</th>
                                        </tr>
                                </thead>
                                <tbody id="tablabody" name="tablabody">

                                <c:forEach var="con" items="${controlInv}">
                                            <tr id="${con[0]}">
                                                <td class="no-display">${con[0]}</td>
                                                <td>${con[1]}</td>
                                                <td>${con[2]}</td>
                                                <td>${con[3]}</td>
                                                <td><a href="" onclick="return deleteElement('${con[0]}');"><span class="glyphicon glyphicon-remove"></span></a></td>
                                            </tr>
                                        </c:forEach>	
                                          

                                </tbody>
                        </table>
                </div>
                            <div class="row">
                                <div class="col-md-12">
                                     &nbsp;<br/>  
                                </div>
                                <div class="col-md-4">
                                        <button class="btn btn-yellow btn-block" type="button" onclick="enviar();">
                                                Actualizar <i class="fa fa-arrow-circle-right"></i>
                                        </button>
                                </div>
                            </div>
        </form:form>
            </div>
                            </div>
                            <!-- end: FORM VALIDATION 1 PANEL -->
                    </div>
            </div>

                <!-- end: PAGE CONTENT-->
<%@include file="footer.jsp" %>		
 
       
            
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesControl.js"></script>
<script>                             

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
         
        var solicitante=$("#solicitante").val();
        var fecha_sal=$("#fecha_sal").val();
        var observacion=$("#observacion").val();
        var destino=$("#destino").val();
        var fecha_devolucion=$("#fecha_devolucion").val();
        
        var jsonArray="{"
        
      
        jsonArray+="\"Control\":[{\"solicitante\":\""+solicitante+"\",\"observacion\":\""+observacion+"\",\"destino\":\""+destino+"\",\"fecha_devolucion\":\""+fecha_devolucion+"\",\"fecha_sal\":\" "+fecha_sal+"\""+"}],";
         
         jsonArray+="\"Inventario\":[";
        
        var l=0;
    
        $('#tabla_prueba tr').each(function(index, element){

        var id = $(element).find("td").eq(0).html();
      
        if(l!=0){
            jsonArray=jsonArray+"{\"idInv\":"+'"'+id+'"'+"},";

          }

        l=1;

    });


    jsonArray=jsonArray.substring(0,jsonArray.length-1);
    jsonArray=jsonArray+"]}";
    //alert(jsonArray);
         $.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/Control/editControl1/${control.idControlSalida}",
           dataType: "json",
           contentType: 'application/json; charset=utf-8',
           success: function (msg) {
               alert("Actualizado con Exito");
               location.reload();
           },
           data: jsonArray
       });
        
    };
    
    function enviarCodeM()
    {
        var codigoI = $("#codigo").val(); 
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
                 



 </script>
