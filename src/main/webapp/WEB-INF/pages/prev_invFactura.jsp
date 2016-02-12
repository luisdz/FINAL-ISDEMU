<%-- 
    Document   : prev_invFactura
    Created on : 10-feb-2016, 21:57:03
    Author     : Luis
--%>

<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                Consultar
            </li>
        </ol>
    </div>
</div>
<!-- end: BREADCRUMB -->
<!-- start: PAGE CONTENT -->

<div class="row">
    <div class="col-md-12">
        <!-- start: EXPORT DATA TABLE PANEL  -->
        <div class="panel panel-white">
            <div class="panel-heading">
                <h4 class="panel-title">Consultar <span class="text-bold">Inventario</span> Activos Fijos</h4>
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
                
                
               <form:form method="POST" action="${pageContext.request.contextPath}/Reportes/listReporteInvFactura"  modelAttribute="inventario" id="movF" >
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
                                    Numero Factura<span id="span_marca" class="symbol"></span>
                                </label>
                                <form:input path="marca" type="text" placeholder="Ingrese un numero de factura" class="form-control" id="factura" onchange="return validaFactura(event);" onblur="return validaFactura(event);" name="marca"/>
                                <span for="marca" class="help-block  no-display" id="span_nombreT">Ingrese un numero de factura</span> 
                            </div>
                            
                            
                             <div class="form-group">
                                <label for="form-field-select-3">
                                    Mayor o menor de 600<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="valor" class="form-control" id="mayor" name="mayor" >
                                    <form:option value="0"  label="Menor de 600"/>
                                    <form:option value="1"  label="Mayor de 600"/>
                                </form:select>
                                <span for="mayor" class="help-block  no-display" id="span_dropdownT">Seleccione una Clasificacion</span>
                            </div>
                            <br>
                        </div>
                        
                         
                      
                    <div class="row">
                    <div class="col-md-8">

                    </div>
                    <div class="col-md-2">
                                    <button id="btn_guardar" class="btn btn-yellow btn-block" type="submit" >
                                        Consultar Activo <i class="fa fa-arrow-circle-right"></i>
                                    </button>
                                </div>
                        <div class="col-md-2">
                        <button class="btn btn-yellow btn-block" type="button" id="ingresar" onclick="return enviarReporte2(event);" value="0" >
                            Guardar Excel <i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                    </div>
                    
                </div>

                    </div>
                    <div class="row  no-display">
                        <div class="col-md-12">
                            <div>
                                <span class="symbol required"></span>Campos Requeridos
                                <hr>
                            </div>
                        </div>
                    </div>

                </form:form>
                

            </div>
        </div>
        <!-- end: EXPORT DATA TABLE PANEL -->
    </div>
</div>
<!-- end: PAGE CONTENT-->

<script  language="JavaScript">
    function confirmar( mensaje ) 
    { 
        return confirm(mensaje); 
    } 
</script>


<%@include file="footer.jsp"%>

<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesISDEMU-01.js"></script>
 <script>
 
    
    $(document).ready(function () 
    {


        $('#dropdown').select2();
        $('#dropdown2').select2();


    });

//Combos dependientes

$("#dropdown1").change(function () {
        var conceptName = $('#dropdown1 :selected').val(); // define the variable
        // alert(conceptName);



        $.ajax({
            url: "${pageContext.request.contextPath}/Inventario/listaClaseA",
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: conceptName,
            success: function (data) {
                var html = '';
                var len = data.length;
                //alert("devuelve algo"+data);
                $('#dropdown2').empty();
                html = '<option value="0"  label="Selecciona una clasificacion"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idClaseActivo + '">' + entry.nombreClase + '</option>';
                });
                $('#dropdown2').append(html);
                // alert("devuelve algo: "+data);
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);


            }
        });


    });
    
    
    //index change de tipo de clasificacion de localizacion para cargar localizacion
    
     $("#tipoClasificacion").change(function () {
        var idTipoClasificacion = $('#tipoClasificacion :selected').val(); // define the variable
      // alert(idTipoClasificacion);



        $.ajax({
            url: "${pageContext.request.contextPath}/Inventario/listaLocalizacion",
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: idTipoClasificacion,
            success: function (data) {
                var html = '';
                var len = data.length;
                //alert("devuelve algo"+data);
                $('#localizacion').empty();
                html = '<option value="0"  label="Selecciona una localizacion"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idLocalizacion + '">' + entry.nombreLocalizacion + '</option>';
                });
                $('#localizacion').append(html);
                // alert("devuelve algo: "+data);
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);


            }
        });


    });
    
   function enviarReporte2 ()
    {
        //alert("excel2");
     validaFactura();
     
     //alert($('#factura').val());
     if(validaFactura()===true)
     {
     alert($('#factura').val());
     window.location.href='${pageContext.request.contextPath}/Reportes/getReportefacturaInv/'+ $('#factura').val() + '/'+$('#mayor option:selected').val() ;
     };
        
   };
      
     
        
    
</script>