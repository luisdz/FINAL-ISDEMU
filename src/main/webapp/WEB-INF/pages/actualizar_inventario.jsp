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
										Actualizar Activo
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
										<h4 class="panel-title">Formulario de <span class="text-bold">Actualizacion</span></h4>
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
										<h2><i class="fa fa-pencil-square"></i> INVENTARIO</h2>
										<p>
											Esta es la seccion de Edicion de Activos Fijos
										</p>
									<hr>


<form:form method="POST" action="${pageContext.request.contextPath}/Inventario/edit/${inventario.idInventario}" onsubmit="return valida_envio2();" modelAttribute="inventario" id="inventarioF" name="inventarioF">
    
        <div class="row">
                        <div class="col-md-12">
                            <div class="errorHandler alert alert-danger no-display" id="mensajeErrorForms">

                                <i class="fa fa-times-sign"></i> Se encontraron errores, favor verificarlos.
                            </div>
                            <div class="successHandler alert alert-success no-display">
                                <i class="fa fa-ok"></i> Validacion exitosa!
                            </div>
                        </div>
                        <div class="col-md-6">
                      
                    
                              <div class="form-group">
                                <label for="form-field-select-3">
                                    Tipo Localizacion<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="" class="form-control" id="tipoClasificacion" name="tipoClasificacion" onchange="return validatipoLocalizacion(event);">
                                   
                                     <form:option value="${inventario.tbcUbicacion.tbcLocalizacion.tbcClasificacionLocalizacion.idClasificacionLocalizacion}"  label="${inventario.tbcUbicacion.tbcLocalizacion.tbcClasificacionLocalizacion.nombreClasificacion}"/>
                                     <form:option value="0"  label="Seleccione un Tipo de Localizacion"/>
                                     <c:forEach var="clasiL" items="${clasiLocalizacion}">
                                       
                                        <form:option value="${clasiL.idClasificacionLocalizacion}"  label="${clasiL.nombreClasificacion}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="clasiL" class="help-block  no-display" id="span_localizaciontipoT">Seleccione un Tipo de Localizacion</span>
                            </div>
                            
                              <div class="form-group">
                                <label for="form-field-select-3">
                                    Localizacion<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="idLocalizacion" class="form-control" id="localizacion" name="localizacion" onchange="return validaLocalizacion(event);">
                                    
                                     <form:option value="${inventario.tbcUbicacion.tbcLocalizacion.idLocalizacion}"  label="${inventario.tbcUbicacion.tbcLocalizacion.nombreLocalizacion}"/>
                                    <form:option value="0"  label="Selecciona una localizacion"/>
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_localizacionT">Seleccione una localizacion</span>
                            </div>
                            
                               <div class="form-group">
                                <label for="form-field-select-3">
                                    Ubicacion<span id="span_clasi" class="symbol "></span>
                                </label>
                                      
                                <form:select path="" class="form-control" id="ubicacion" name="ubicacion" onchange="return validaUbicacion(event);">
                                    <form:option value="${inventario.tbcUbicacion.idUbicacion}"  label="${inventario.tbcUbicacion.nombreUbicacion}"/> 
                                    <form:option value="0"  label="Selecciona una Ubicacion"/>
                                   
                                </form:select>
                                <span for="ubicacion" class="help-block  no-display" id="span_ubicacionT">Seleccione una Ubicacion</span>
                            </div>




                            <div class="form-group">
                                <label for="form-field-select-3">
                                    En custodia de<span id="span_persona" class="symbol "></span>
                                </label>
                                <form:select path="tbcPersona.idPersona" class="form-control" id="persona" name="persona" onchange="return validaCustodia(event);">
                                 <form:option value="${pers.idPersona}"  label="${pers.nombrePersona}"/>    
                                   <c:forEach var="pers" items="${persona}">
                                    <form:option value="${pers.idPersona}"  label="${pers.nombrePersona}"/>
                                 </c:forEach> 
                                </form:select>
                                <span for="persona" class="help-block  no-display" id="span_personaT">Seleccione una Persona</span>
                            </div>
                            
                             <div class="form-group">
                                <label for="form-field-select-3">
                                    Asignado A<span id="span_persona" class="symbol "></span>
                                </label>
                                <form:select path="tbcPersonaAsignada.idPersona" class="form-control" id="personaasig" name="personaasig" onchange="return validaAsignadoA(event);">
                                 <form:option value="${pers.idPersona}"  label="${pers.nombrePersona}"/>    
                                   <c:forEach var="pers" items="${persona}">
                                    <form:option value="${pers.idPersona}"  label="${pers.nombrePersona}"/>
                                 </c:forEach> 
                                </form:select>
                                <span for="persona" class="help-block  no-display" id="span_personaA">Seleccione una Persona</span>
                            </div>
                            
                            




                            <div class="form-group">
                                <label class="control-label">
                                    Marca<span id="span_marca" class="symbol"></span>
                                </label>
                                <form:input path="marca" type="text" placeholder="Ingrese la marca del equipo" class="form-control" id="marca" name="marca" onblur="return validaMarca(event);"/>
                                <span for="marca" class="help-block  no-display" id="span_marcaT">Ingrese una Marca</span> 
                            </div>

                              <div class="form-group">
                                <label class="control-label">
                                    Modelo<span id="span_modelo" class="symbol"></span>
                                </label>
                                <form:input path="modelo" type="text" placeholder="Ingrese el modelo del equipo" class="form-control" id="modelo" name="modelo" onblur="return validaModelo(event);"/>
                                <span for="modelo" class="help-block  no-display" id="span_modeloT">Ingrese un Modelo</span> 
                            </div>
                                <div class="form-group">
                                <label class="control-label">
                                    Serie<span id="span_serie" class="symbol"></span>
                                </label>
                                <form:input path="serie" type="text" placeholder="Ingrese el numero de serie" class="form-control" id="serie" name="serie" onblur="return validaSerie(event);"/>
                                <span for="serie" class="help-block  no-display" id="span_serieT">Ingrese el numero de Serie</span> 
                            </div>  
                          
                             <div class="form-group">
                                <label class="control-label">
                                    Descripcion<span id="span_serie" class="symbol"></span>
                                </label>
                                <form:input path="descripcionEquipo" type="text" placeholder="Ingrese una descripcion del equipo" class="form-control" id="descripcionEquipo" name="descripcionEquipo" />
                                <span for="descripcionEquipo" class="help-block  no-display" id="span_serieT">Ingrese el numero de Serie</span> 
                            </div>
                                
                        </div>  
                        <!--     Cierre div izquiero-->
                        <div class="col-md-6">
                            

                                
                            <div class="form-group">
                                <label class="control-label">
                                    Fecha Adquisicion<span id="span_adq" class="symbol"></span>
                                </label>
                                <div class="input-group">
                                    <form:input path="fechaAdquisicion" type="text" id="fecha_adq" name="fecha_adq" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker" onchange="return validaFechaAdq(event);" onblur="return validaFechaAdq(event);"/>
                                    <span class="input-group-addon"> <i class="fa fa-calendar"></i></span>
                                   </div> <span for="fecha_adq" class="help-block  no-display" id="span_fechaAdq">Ingrese Fecha Adquisicion</span>
                                
                            </div>
                            
                                    
                                      <div class="form-group">
                                <label for="form-field-select-3">
                                    Proveedor<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="tbcProveedor.idProveedor" class="form-control" id="proveedor" name="proveedor">
                                    <form:option value="0"  label="Seleccion un proveedor"/>
                                    <c:forEach var="proveedor" items="${proveedor}">
                                        <form:option value="${proveedor.idProveedor}"  label="${proveedor.nombreProveedor}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_dropdownT">Seleccione un Proveedor</span>
                            </div>





                            <div class="form-group">
                                <label class="control-label">
                                    Valor<span id="span_valor" class="symbol"></span>
                                </label>
                                <form:input path="valor" type="text" placeholder="Ingrese el valor en $ del equipo" class="form-control" id="valor" name="valor" onkeypress="return valideKey(event);" onblur="return validaValor(event);"/>
                                <span for="valor" class="help-block  no-display" id="span_valorT">Ingrese Valor</span> 
                            </div>



                            <div class="form-group">
                                <label class="control-label">
                                    N Factura<span id="span_factura" class="symbol"></span>
                                </label>
                                <form:input path="NFactura" type="text" placeholder="Ingrese el numero de factura" class="form-control" id="factura" name="factura" onblur="return validaFactura(event);"/>
                                <span for="factura" class="help-block  no-display" id="span_facturaT">Ingrese numero factura</span> 
                            </div>



                            <div class="form-group">
                                <label class="control-label">
                                    Financiamiento<span id="span_finan" class="symbol"></span>
                                </label>
                                <form:input path="financiamiento" type="text" placeholder="Ingrese el tipo de financiamiento del equipo" class="form-control" id="financiamiento" name="financiamiento" onblur="return validaFinanciamiento(event);"/>
                                <span for="financiamiento" class="help-block  no-display" id="span_financiamientoT">Ingrese un Financiamiento</span> 
                            </div>
                        
                             <div class="form-group">
                                <label class="control-label">
                                    Observacion<span id="span_finan" class="symbol"></span>
                                </label>
                                <form:textarea path="observacion" type="text"  placeholder="Ingrese Una Observacion" class="form-control" id="observacion" name="observacion" />
                                <span for="observacion" class="help-block  no-display" id="span_financiamientoT">Ingrese una Observacion</span> 
                            </div>
                                   
                         
                        </div>
                                
                              

                        <div class="row">
                            <div class="col-md-12">
                                <div class="col-md-6">
                                </div>
                                <div class="col-md-2">
                                    <button id="btn_guardar" class="btn btn-yellow btn-block" type="submit" >
                                        Actualizar Activo <i class="fa fa-arrow-circle-right"></i>
                                    </button>
                                </div>
                            
                            </div>
                        </div>
                                
                            
</form:form>


</div>

 
</div>
								</div>
								<!-- end: FORM VALIDATION 1 PANEL -->
							</div>
						</div>
						
						<!-- end: PAGE CONTENT-->
				<%@include file="footer.jsp" %>	
                                <script src="${pageContext.request.contextPath}/assets/validaciones/validacionesInventario.js"></script>
<script>
     
    
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
                html = '<option value="0"  label="Selecciona una Ubicacion"/>';
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

//index change de ubicacion para cargar persona
    
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
                $('#persona').empty();
                html = '<option value="0"  label="Selecciona una persona"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idPersona + '">' + entry.nombrePersona + '</option>';
                });
                $('#persona').append(html);
                // alert("devuelve algo: "+data);
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);


            }
        });


    });

  
    function valideKey(evt)
    {
        var code = (evt.which) ? evt.which : evt.keyCode;
        if (code == 8)
        {
            //backspace
            return true;
        }
        else if (code >= 48 && code <= 57)
        {
            //is a number
            return true;
        }
        else
        {
            return false;
        }
    }
    ;
</script>