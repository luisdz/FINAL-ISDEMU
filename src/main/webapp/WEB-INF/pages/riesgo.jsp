<%-- 
    Document   : riesgo
    Created on : 13-ago-2015, 16:41:01
    Author     : Luis
--%>
<%@include file="header.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                <h2><i class="fa fa-pencil-square"></i> Riesgo</h2>
                <p>
                    Esta es la seccion de Ingreso de Unidades
                </p>
                <hr>

                <form:form id="riesgoF" method="POST" action="${pageContext.request.contextPath}/Riesgo/insertarRiesgo" onsubmit="return valida_envioRiesgo();" modelAttribute="riesgo" >
                    <div class="row">
                        <div class="col-md-12">
                            <div id="mensajeErrorForm" class="errorHandler alert alert-danger no-display">
                                <i class="fa fa-times-sign"></i> No se puede realizar la accion, existen errores en la informacion.
                            </div>
                            <div class="successHandler alert alert-success no-display" id="mensajeExitoFormM">
                                <i class="fa fa-ok"></i> Guardado con exito!
                            </div>
                        </div>
                        <div class="col-md-6">


                            <div class="form-group">
                                <label class="control-label">
                                    Nombre<span class="symbol "></span>
                                </label>
                                <form:input path="nombreRiesgo" type="text" placeholder="Ingrese el nombre" class="form-control" id="nombre" name="nombre" onblur="return validaNombreRiesgo(event);"/>
                                <span for="nombre" class="help-block  no-display" id="span_nombreT">Ingrese un nombre</span>    
                                
                            </div>

                             
                        </div>
                        <div class="col-md-6">


                        </div>
                    </div>
                    <div class="row no-display">
                        <div class="col-md-12">
                            <div>
                                <span class="symbol required"></span>Required Fields
                                <hr>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-8">

                        </div>
                        <div class="col-md-4">
                            <button class="btn btn-yellow btn-block" type="submit">
                                Ingresar <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </div>
                    </div>
                                
                     <form:input class="no-display" path="" type="text" value="${message}" placeholder="Ingrese el nombre" id="msje"  />
                                          
                </form:form>
            </div>
        </div>
        <!-- end: FORM VALIDATION 1 PANEL -->
    </div>
</div>
 
<!-- end: PAGE CONTENT-->
<%@include file="footer.jsp" %>	
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesISDEMU-01.js"></script>
<script>
   $(document).ready(function () 
   {       
         
        if (document.forms["riesgoF"]["msje"].value==="1")
        {
            
           $('#mensajeExitoFormM').removeClass("no-display"); 
           document.forms["riesgoF"]["msje"].value==="0";
        }

    }); 
</script>