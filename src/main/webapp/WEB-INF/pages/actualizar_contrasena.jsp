<%-- 
    Document   : actualizar_contrasena
    Created on : 08-nov-2015, 11:33:05
    Author     : Miranda
--%>

<%@include file="header.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: BREADCRUMB -->
<div class="row">
    <div class="col-md-12">
        <ol class="breadcrumb">
            <li>
                <a href="#">
                    Seguridad
                </a>
            </li>
            <li class="active">
                Actualizar Contraseña
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
                <h2><span class="text-bold"><i class="fa fa-pencil-square"></i>Contraseña</span></h2>
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
                
                <hr>

                <form:form method="POST" action="${pageContext.request.contextPath}/Usuario/update_clave/1" onsubmit="return valida_envio();" modelAttribute="usuario" id="personaF">

                    <div class="row">
                                <div class="col-md-12">
                                    <div class="errorHandler alert alert-danger no-display" id="mensajeErrorForms">

                                        <i class="fa fa-times-sign"></i> Se encontraron errores, favor verificarlos.
                                    </div>
                                    <div class="successHandler alert alert-success no-display">
                                        <i class="fa fa-ok"></i> Validacion exitosa!
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    
                                        
                                                                                
                                </div>
                                <div class="col-md-4">
                                    
                                    <h2>Cambio de Contraseña</h2>
                                    
                                    <hr>
                                    
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Contraseña<span id="span_jefe" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="clave" type="password" class="form-control" id="jefe" name="jefe" onblur="return validaJefe(event);"/>
                                                <span for="jefe" class="help-block  no-display" id="span_jefeT">Ingrese un Jefe</span> 
                
                                    </div> 
                                                
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Re-Contraseña<span id="span_jefe" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="clave" type="password" class="form-control" id="jefe" name="jefe" onblur="return validaJefe(event);"/>
                                                <span for="jefe" class="help-block  no-display" id="span_jefeT">Ingrese un Jefe</span> 
                
                                    </div> 
                                    
                                   
                                </div>
                                <div class="col-md-4">
                                    
                          
                                    
                                   
                                </div>
                 
                </div>
                 <div class="row">
                                               
                        <div class="col-md-4">
                        </div>
                        <div class="col-md-4">
                            <button class="btn btn-yellow btn-block" type="submit">
                                Actualizar <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </div>
                        <div class="col-md-4">
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