<%-- 
    Document   : usuario
    Created on : 21-sep-2015, 23:22:58
    Author     : Walter
--%>


<%@include file="header.jsp" %>

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
                                Ingreso Usuario
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
                        <h4 class="panel-title">Formulario de <span class="text-bold">Ingreso Usuario</span></h4>
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
                    <h2><i class="fa fa-pencil-square"></i> Usuario</h2>
                    <p>
                            Ingreso de Usuarios
                    </p>
                    <hr>
              <form:form method="POST" action="${pageContext.request.contextPath}/Usuario/add" modelAttribute="usuario" id="usuarioF" >
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
                                                <label class="control-label">
                                                        Rol<span id="span_nombre" class="symbol "></span>
                                                </label>
                                               <form:select path="TbsRol.idRol" class="form-control" id="dropdown" name="dropdown" onchange="return validaUnidad(event);">
                                                    <form:option value="0"  label="Seleccione Rol"/>       
                                                    <c:forEach var="ro" items="${rol}">
                                                               <form:option value="${ro.idRol}"  label="${ro.nombreRol}"/>
                                                            </c:forEach>
                                                 </form:select>
                                                <span for="nombre" class="help-block  no-display" id="span_dropdownT">Seleccione un Rol</span>    
                                    </div>
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Nombres<span id="span_nombre" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="nombreUsuario" type="text" placeholder="Ingrese nombres" class="form-control" id="nombre" name="nombre" onblur="return validaNombrePersona(event);"/>
                                                <span for="nombres" class="help-block  no-display" id="span_nombreT">Ingrese un Nombre</span> 
                                    </div>                        
                                                                                
                                </div>
                                <div class="col-md-6">
                                    
                                   <div class="form-group">
                                                <label class="control-label">
                                                        Apellidos<span id="span_jefe" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="apellidoUsuario" type="text" class="form-control" id="apellido" name="apellido" onblur="return validaJefe(event);"/>
                                                <span for="jefe" class="help-block  no-display" id="span_jefeT">Ingrese Apellidos</span> 
                
                                    </div> 
                                                <div class="form-group">
                                                <label class="control-label">
                                                        Usuario<span id="span_encargado" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="usuario" type="text" class="form-control" id="user" name="user" onblur="return validaEncargado(event);"/>
                                                <span for="encargado" class="help-block  no-display" id="span_encargadoT">Ingrese un Usuario</span> 
                
                                    </div> 
                                    
                                   
                                </div>                                       
                             </div>
                      
                        
                        <div class="row">
                                <div class="col-md-8">
                                       
                                </div>
                                <div class="col-md-4">
                                        <button class="btn btn-yellow btn-block" type="submit">
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