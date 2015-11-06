<%-- 
    Document   : actualizar_movimiento
    Created on : 01-ago-2015, 10:16:36
    Author     : AlejandroPC
--%>
<%@include file="header.jsp"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: BREADCRUMB -->
<div class="row">
    <div class="col-md-12">
        <ol class="breadcrumb">
            <li>
                <a href="#">
                    Inventario
                </a>
            </li>
            <li class="active">
                Ingreso de Activos
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
                <h4 class="panel-title">Formulario de <span class="text-bold">Ingreso</span></h4>
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
                <h2><i class="fa fa-pencil-square"></i> Movimientos</h2>
                <p>
                    Esta es la seccion de Ingreso de Activos Fijos
                </p>
                <hr>
                 <div class="col-md-12">
                            <div class="errorHandler alert alert-danger no-display" id="mensajeErrorFormM"  >
                                <i class="fa fa-times-sign"></i> No se puede realizar la accion, existen errores en la informacion.
                            </div>
                            <div id="mensajeExitoFormM" class="successHandler alert alert-success no-display">
                                <i class="fa fa-ok"></i> Guardado con Exito!
                            </div>
                        </div>    

                <form:form id="movF" method="POST" action="${pageContext.request.contextPath}/Movimiento/editMovimientoI/${movimiento.idMovimiento}" modelAttribute="movimiento" >

                      <div class="col-md-6">  
                          
                          <div class="form-group no-display">
                        <label class="control-label no-display">
                            id<span class="symbol "></span>
                        </label>
                        <form:input path="idMovimiento" type="text" placeholder="${movimiento.idMovimiento}" class="form-control" id="id" name="lastname"/>
                    </div>
                          
                    <div class="form-group">
                        <label class="control-label">
                            Fecha movimiento<span class="symbol "></span>
                        </label>
                        <form:input path="fechaMovimiento" type="text" placeholder="${movimiento.fechaMovimiento}" class="form-control" id="fechaMov" name="lastname"/>
                    </div>

                       
                    <div class="form-group">
                        <label class="control-label">
                            Razon de cambio<span class="symbol "></span>
                        </label>
                        <form:input path="razonCambio" type="text" placeholder="${movimiento.razonCambio}" class="form-control" id="razon" name="lastname"/>
                    </div>
                    <div class="row">



                    </div>
                      </div>
                    <div class="col-md-6">
                        <div class="form-group">
                                <label class="control-label">
                                    Codigo Inventario<span class="symbol "></span>
                                </label>
                                <form:input path=""  type="text" placeholder="Ingrese un codigo" class="form-control" id="codigo" name="codigo" />
                                <span for="codigo" class="help-block  no-display" id="span_codigoE">El codigo es invalido o ya esta agreagado</span>  
                                <span for="codigo" class="help-block  no-display" id="span_codigoE2">El inventario con ese codigo esta descargado</span>  
                            
                        </div>
                    </div>
                        
                    </form:form>
                <div class="col-md-12 text-center">
                    <button type="button" class="btn btn-default" onclick="enviarCodeM();" >Agregar</button>     
                </div>


                </div>
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="tabla_prueba">
                        <thead>
                            <tr>
                                <th class="no-display">id mov inv</th>
                               
                                <th>Codigo</th>
                                <th>Clase</th>
                                <th>Descripcion</th>
                                <th>Anular</th>
                                <th></th>
                                
                            </tr>
                        </thead>
                        <tbody id="tablabody" name="tablabody">

                            <c:forEach var="mov" items="${movimientoInv}">
                                <tr id="${mov.idMovimientoInventario}" >
                                    <td class="no-display">${mov.idMovimientoInventario}</td>                                                                                      
                                    
                                    <td>${mov.tbInventario.codigoInventario}</td>
                                    <td>${mov.tbInventario.tbcClaseActivo.nombreClase}</td> 
                                    <td>${mov.tbInventario.descripcionEquipo}</td>
                                    <td><a onclick="return confirmar('¿Está seguro que desea anular el movimiento?')" href="${pageContext.request.contextPath}/Movimiento/deleteMovimiento/${mov.idMovimientoInventario}"> Anular</a></td>
                                 <td class="no-display"></td>       
                                </tr>
                            </c:forEach>	


                        </tbody>
                    </table>
                    <div class="row">
                            <div class="col-md-12"> 
                                <div class="col-md-4">
                                </div>
                            <div class="col-md-4">
                                <button class="btn btn-yellow btn-block" type="button" onclick="enviarMov();">
                                    Actualizar <i class="fa fa-arrow-circle-right"></i>
                                </button>
                            </div>
                               
                                
                             <div class="col-md-4">
                                <button class="btn btn-yellow btn-block" type="button" onclick="location.href='${pageContext.request.contextPath}/Movimiento/ReporteMovimiento/${movimiento.idMovimiento}' " >
                                     Imprimir  <i class="fa fa-arrow-circle-right"></i>
                                </button>
                            </div>   
                            </div>
                        </div>
                    
                </div>
                            

            </div>
        </div>
        <!-- end: FORM VALIDATION 1 PANEL -->
    </div>
</div>

<!-- end: PAGE CONTENT-->
<%@include file="footer.jsp" %>		

<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesISDEMU-01.js"></script>
<script>
    
    
    
    function deleteElement(id)
    {
        var el = document.getElementById(id);
        el.parentNode.removeChild(el);
        return false;
    }
    ;
    function condigoYaAgregado2(cod)
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
    
    function enviarCodeM()
    {
        var codigoI = $("#codigo").val();  
        
        if (condigoYaAgregado2(codigoI) === true)
        {
            
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/Movimiento/agregarInventarioM",
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
                            
                             if(entry.tbcEstadoInventario.idEstado === 2)
                            {                                
                            } 
                            else
                            {    
                            //console.log(entry);
                            $('#tabla_prueba').append('<tr  id="' + entry.idInventario + '">' + '<td class=\"no-display\" >' + entry.idInventario + '</td>' + '<td>' + entry.codigoInventario + '</td>' + '</td>' + '<td>' + entry.tbcClaseActivo.nombreClase + '</td>' + '<td>' + entry.descripcionEquipo + '</td><td class="eliminar"><a href="" onclick="return deleteElement(' + "'" + entry.idInventario + "'" + ');"><span class="glyphicon glyphicon-remove"></span></a></td><td class="no-display" >1</td></tr>');
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
    
    
  function enviarMov()
    {
        
        $("#ingresar").val(1);
        validaFechaMov();
         
        if ($('#tabla_prueba tr').size() > 1 && validaFechaMov() )
        {
           
            $('#mensajeErrorFormM').addClass("no-display");
            var fechaM = $("#fechaMov").val();
            
            var razonM = $("#razon").val();
            var codigoI = $("#codigo").val();
            //var personaM = $('#responsable option:selected').text();
           // var idpersonaM  = $('#responsable option:selected').val();
           alert("razon" + razonM);
            var id =  $("#id").val();

            var jsonArray = "{";
            jsonArray += "\"Movimiento\":[{\"fecha\":\"" + fechaM + "\",\"razon\":\" " + razonM + "\"" + ",\"codigo\":\"" + codigoI + "\",\"id\":\""+ id + "\"}],";
            jsonArray += "\"Inventario\":"+" [ ";
            var l = 0;
                
            $('#tabla_prueba tr').each(function (index, element) 
               {
                var id = $(element).find("td").eq(0).html();
                var nv = $(element).find("td").eq(5).html();
                //alert(nv);
                if(nv == 1)
                {
                if (l != 0)
                {
                    jsonArray = jsonArray + "{\"idInv\":" + '"' + id + '"' + "},";
                }
                }
                l = 1;

            });

            jsonArray = jsonArray.substring(0, jsonArray.length - 1);
            jsonArray = jsonArray + " ]}";
            //alert(jsonArray);
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/Movimiento/updateMov",
                dataType: "json",
                contentType: 'application/json',
                success: function (msg) {
                    //alert("entra");
                    $('#movF').each(function () 
                    {
                       
                        $('.help-block').closest("div").removeClass("has-success");
                        $('.help-block').closest("div").removeClass("has-error");
                    }); 
                    $('#mensajeExitoFormM').removeClass("no-display");
                    
                   window.onclick = function(){window.location=''};
                    
                  
                },
                data: jsonArray
            });
        }
        else
        {

            $('#mensajeErrorFormM').removeClass("no-display");
            return false;
        }

    }
    ;
    
</script>

<script  language="JavaScript">
    function confirmar( mensaje ) 
    { 
        return confirm(mensaje); 
    } 
</script>