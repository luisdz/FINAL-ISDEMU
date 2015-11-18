<%-- 
    Document   : localizacion
    Created on : 15-ago-2015, 22:18:09
    Author     : Miranda
--%>
<%@include file="header.jsp" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: BREADCRUMB -->
<div class="row">
        <div class="col-md-12">
                <ol class="breadcrumb">
                        <li>
                                <a href="#">
                                        Catalogos
                                </a>
                        </li>
                        <li class="active">
                                Ingreso Localizacion
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
                        <h4 class="panel-title">Formulario de <span class="text-bold">Ingreso Localizacion</span></h4>
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
                    <h2><i class="fa fa-pencil-square"></i> Localizacion</h2>
                    <p>
                            Ingreso del Localizacion de ISDEMU
                    </p>
                    <hr>
              <form:form method="POST" action="${pageContext.request.contextPath}/Localizacion/add" onsubmit="return valida_envio();" modelAttribute="localizacion" id="localizacionF" >
                        <div class="row">
                            <div class="col-md-12">
                            <div class="errorHandler alert alert-danger no-display" id="mensajeErrorForm">

                                    <i class="fa fa-times-sign"></i> Error, debe ingresar todos los elementos requeridos.
                                </div>
                                <div class="successHandler alert alert-success no-display" id="mensajeExitoFormM">
                                    <i class="fa fa-ok"></i> Guardado con exito!
                                </div>
                            </div>
                                <div class="col-md-6">
    
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Riesgo<span id="span_riesgo" class="symbol "></span>
                                                </label>
                                               <form:select path="TbcRiesgo.idRiesgo" class="form-control" id="dropdown" name="dropdown" onchange="return validaRiesgo(event);">
                                                    <form:option value="0"  label="Selecciona Riesgo"/>       
                                                    <c:forEach var="rie" items="${riesgo}">
                                                               <form:option value="${rie.idRiesgo}"  label="${rie.nombreRiesgo}"/>
                                                            </c:forEach>
                                                 </form:select>
                                                <span for="riesgo" class="help-block  no-display" id="span_dropdownT">Ingrese un Riesgo</span>    
                                    </div>
                                    
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Clasificacion Localizacion<span id="span_clasificacion" class="symbol "></span>
                                                </label>
                                               <form:select path="TbcClasificacionLocalizacion.idClasificacionLocalizacion" class="form-control" id="dropdown1" name="dropdown1" onchange="return validaClasificacion(event);">
                                                    <form:option value="0"  label="Selecciona Clasificacion Loc"/>       
                                                    <c:forEach var="cla" items="${clasificacion_localizacion}">
                                                               <form:option value="${cla.idClasificacionLocalizacion}"  label="${cla.nombreClasificacion}"/>
                                                            </c:forEach>
                                                 </form:select>
                                                <span for="clasificacion" class="help-block  no-display" id="span_dropdown1T">Ingrese una Clasificacion Localizacion</span>    
                                    </div>
                                                          
                                                                                
                                </div>
                                <div class="col-md-6">
                                    
                                   <div class="form-group">
                                                <label class="control-label">
                                                        Nombre Localizacion<span id="span_nombre" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:input path="nombreLocalizacion" type="text" class="form-control" id="localizacion" name="localizacion" onblur="return validaLocalizacion(event);"/>
                                                <span for="jefe" class="help-block  no-display" id="span_nombreT">Ingrese una Localizacion</span> 
                
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
                   <form:input class="no-display" path="" type="text" value="${message}"  id="msje"  />
                                      <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
                     
                        </form:form>
                   </div>
                </div>
            </div>
            <!-- end: FORM VALIDATION 1 PANEL -->
        </div>

<%@include file="footer.jsp" %>	
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesLocalizacion.js"></script>
<script>
   $(document).ready(function () 
   {       
          
        if (document.forms["localizacionF"]["msje"].value==="1")
        {
             
           $('#mensajeExitoFormM').removeClass("no-display"); 
           document.forms["localizacionF"]["msje"].value==="0";
        }

    }); 
</script>