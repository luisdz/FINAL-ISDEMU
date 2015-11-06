<%@include file="header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: BREADCRUMB -->
						<div class="row">
							<div class="col-md-12">
								<ol class="breadcrumb">
									<li>
										<a href="#">
											Catalogo
										</a>
									</li>
									<li class="active">
										Clase Activo
									</li>
                                                                        
                                                                        <li class="active">
										Actualizar Clase
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
										<h2><i class="fa fa-pencil-square"></i> Clase Activo</h2>
										<p>
											Esta es la seccion donde podra actualizar una clase ingresada
										</p>
									<hr>


<form:form method="POST" action="${pageContext.request.contextPath}/ClaseActivo/actualizar/${claseA.idClaseActivo}" modelAttribute="claseA" id="claseAF" >
    
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
                                    Clasificacion Activo<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="tbcClasificacionActivo.idClasificacionActivo" class="form-control" id="dropdown1" name="dropdown1" onchange="return validaClasificacion(event);">
                                    <form:option value="0"  label="Selecciona una clasificacion"/>
                                    <c:forEach var="clasi" items="${AllclasificacionA}">
                                        <form:option value="${clasi.idClasificacionActivo}"  label="${clasi.nombreClasificacion}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_dropdownT">Seleccione una Clasificacion</span>
                            </div>
                            
                            
                            <div class="form-group">
                                <label class="control-label">
                                    Nombre Clase:<span id="span_marca" class="symbol"></span>
                                </label>
                                <form:input path="nombreClase" type="text" placeholder="Ingrese una Clase de Activo" class="form-control" id="clase" name="clase" onblur="return validaClase(event);"/>
                                <span for="clase" class="help-block  no-display" id="span_claseT">Ingrese una Clase</span> 
                            </div>
                         



                           
                        </div>  
                        <!--     Cierre div izquiero-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">
                                    Codigo Clase:<span id="span_serie" class="symbol"></span>
                                </label>
                                <form:input path="codigoClase" type="text" placeholder="Ingrese el codigo de la clase" class="form-control" id="codigoClase" name="codigoClase" onkeypress="return valideKey(event);" onblur="return validaCodigo(event);"/>
                                <span for="codigoClase" class="help-block  no-display" id="span_codigoT">Ingrese el codigo de la clase</span> 
                            </div>

                             


                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="col-md-8">
                                </div>
                                <div class="col-md-4">
                                    <button class="btn btn-yellow btn-block" type="submit">
                                        Guardar <i class="fa fa-arrow-circle-right"></i>
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
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesClaseAct.js"></script>