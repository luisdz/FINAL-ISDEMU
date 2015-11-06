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
                Clase de Activo
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
                <h2><i class="fa fa-pencil-square"></i> CLASIFICACION DE ACTIVOS</h2>
                <p>
                    Esta es la seccion de Ingreso de Clasificaciones de Activos
                </p>
                <hr>







                <form:form method="POST" action="${pageContext.request.contextPath}/ClasificacionActivo/actualizarClasificacion/${clasificacionA.idClasificacionActivo}" onsubmit="return valida_envio();" modelAttribute="clasificacionA" id="clasificacionAF">

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
                                    Poliza<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="tbcPoliza.idPoliza" class="form-control" id="poliza" name="poliza">
                                    <form:option value="0"  label="Selecciona una Poliza"/>
                                    <c:forEach var="poli" items="${poliza}">
                                        <form:option value="${poli.idPoliza}"  label="${poli.nombrePoliza}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="poliza" class="help-block  no-display" id="span_dropdownT">Seleccione una Poliza</span>
                            </div>
                            
                            
                            <div class="form-group">
                                <label class="control-label">
                                    Nombre Clasificacion:<span id="span_marca" class="symbol"></span>
                                </label>
                                <form:input path="nombreClasificacion" type="text" placeholder="Ingrese una Clasificacion de Activo" class="form-control" id="clasificacion" name="clasificacion" onblur="return validaNombre(event);"/>
                                <span for="clasificacion" class="help-block  no-display" id="span_nombreT">Ingrese Nombre Clasificacion</span> 
                            </div>
                         



                           
                        </div>  
                        <!--     Cierre div izquiero-->
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">
                                    Codigo Clasificacion:<span id="span_serie" class="symbol"></span>
                                </label>
                                <form:input path="codigoClasificacion" type="text" placeholder="Ingrese el codigo de la clase" class="form-control" id="codigoClasi" name="codigoClasi" onblur="return validaCodigo(event);"/>
                                <span for="codigoClasi" class="help-block  no-display" id="span_codigoT">Ingrese el Codigo Clasificacion</span> 
                            </div>

                             


                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="col-md-8">
                                </div>
                                <div class="col-md-4">
                                    <button class="btn btn-yellow btn-block" type="submit">
                                        Actualizar <i class="fa fa-arrow-circle-right"></i>
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
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesClasiActivo.js"></script>
