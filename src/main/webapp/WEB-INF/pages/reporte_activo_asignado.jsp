<%-- 
    Document   : reporte_activo_asignado
    Created on : 22-sep-2015, 15:28:29
    Author     : Luis
--%>

<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: PAGE CONTENT -->

<!--    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
-->


<!-- jQuery Form Validation code -->



<div class="row">
    <div class="col-md-12">
        <!-- start: FORM VALIDATION 1 PANEL -->
        <div class="panel panel-white">
            <div class="panel-heading">
                <h4 class="panel-title">Reportes  <span class="text-bold">Activos fijos</span></h4>
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
                <h2><i class="fa fa-pencil-square"></i> Reportes</h2>
                <p>
                    Esta es la seccion de Reportes de Activos Fijos segun personal asignado
                </p>
                <hr>
                
                  
                
                 
 
                              <form:form method="POST"    modelAttribute="movimiento" id="repAsign" >
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
                                <label for="form-field-select-3">
                                    Tipo Localizacion<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="" class="form-control" id="tipoClasificacion" name="tipoClasificacion" >
                                    <form:option value="0"  label="Seleccione un Tipo de Localizacion"/>
                                    <c:forEach var="clasiL" items="${clasiLocalizacion}">
                                        <form:option value="${clasiL.idClasificacionLocalizacion}"  label="${clasiL.nombreClasificacion}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="clasiL" class="help-block  no-display" id="span_dropdownT">Seleccione un Tipo de Localizacion</span>
                            </div>
                            
                              <div class="form-group">
                                <label for="form-field-select-3">
                                    Localizacion<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="" class="form-control" id="localizacion" name="localizacion" >
                                    <form:option value="0"  label="Selecciona una localizacion"/>
                                    
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_dropdownT">Seleccione una Clasificacion</span>
                            </div>
                            
                             <div class="form-group">
                                <label for="form-field-select-3">
                                    Ubicacion<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="" class="form-control" id="ubicacion" name="ubicacion"  >
                                    <form:option value="0"  label="Selecciona una Ubicacion"/>
                                   
                                </form:select>
                                <span for="ubicacion" class="help-block  no-display" id="span_dropdownT">Seleccione una Ubicacion</span>
                            </div>  
                            <br>
                        </div>
                        
                         

                        <div class="col-md-6">

                           
                            <div class="form-group">
                                <label class="control-label">
                                    Asignado<span class="symbol"></span>
                                </label>
                                <form:select  multiple="single" path="" cssStyle="width: 100%" id="responsable" name="dropdown2" onchange="return validaRespMov(event);" onblur="return validaRespMov(event);">
                                    <form:option value="0" label="Seleccione responsable"/>                                                   
                                </form:select>
                                <span for="responsable" class="help-block  no-display" id="span_resp">Seleccione una persona</span>  
                            
                            </div>
                            <div class="form-group">
                                <label for="form-field-select-3">
                                    Mayor o menor de 600<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="" class="form-control" id="mayor" name="mayor" >
                                    <form:option value="0"  label="Menor de 600"/>
                                    <form:option value="1"  label="Mayor de 600"/>
                                </form:select>
                                <span for="mayor" class="help-block  no-display" id="span_dropdownT">Seleccione una Clasificacion</span>
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
                
                
                
                
                
                
                <div class="row">
                    <div class="col-md-8">

                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-yellow btn-block" type="button" id="ingresar" onclick="return enviarReporte2(event);" value="0" >
                            Guardar excel<i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                    </div>
                </div>

                <!--                    validation-->

                <!--                    fin validation-->


            </div>
        </div>
        <!-- end: FORM VALIDATION 1 PANEL -->
    </div>
 

<!-- end: PAGE CONTENT-->



<%@include file="footer.jsp" %>	
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
    
    //index change de localizacion para cargar ubicacion
    
     $("#localizacion").change(function () {
        var idLocalizacion = $('#localizacion :selected').val(); // define the variable
      // alert(idLocalizacion);



        $.ajax({
            url: "${pageContext.request.contextPath}/Inventario/listaUbicacion",
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: idLocalizacion,
            success: function (data) {
                var html = '';
                var len = data.length;
                //alert("devuelve algo"+data);
                $('#ubicacion').empty();
                html = '<option value="0"  label="Selecciona una localizacion"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idUbicacion + '">' + entry.nombreUbicacion + '</option>';
                });
                $('#ubicacion').append(html);
                // alert("devuelve algo: "+data);
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);


            }
        });


    });
    $("#ubicacion").change(function () {
        var idLocalizacion = $('#ubicacion :selected').val(); // define the variable
       //alert(idLocalizacion);



        $.ajax({
            url: "${pageContext.request.contextPath}/Inventario/listaPersona",
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: idLocalizacion,
            success: function (data) {
                var html = '';
                var len = data.length;
                //alert("devuelve algo"+data);
                $('#responsable').empty();
                html = '<option value="0"  label="Selecciona una persona"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idPersona + '">' + entry.nombrePersona + '</option>';
                });
                $('#responsable').append(html);
                // alert("devuelve algo: "+data);
                
                
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);

            }
        });


    });

    function enviarReporte2 ()
    {
     validaRespRepAsign();
     if(validaRespRepAsign()==true)
     {
     window.location.href='${pageContext.request.contextPath}/Reportes/getReporteAsignado/'+ $('#responsable option:selected').val() + '/'+$('#mayor option:selected').val() ;
    
        };
        
     };
        
    
</script>