<%-- 
    Document   : Ubicacion Persona
    Created on : 01-mar-2016, 20:06:09
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
                                        Catalogos
                                </a>
                        </li>
                        <li class="active">
                              Actualizar Ubicacion Persona
                        </li>
                </ol>
        </div>
</div>
<div class="row">
        <div class="col-md-12">
            <!-- start: FORM VALIDATION 1 PANEL -->
            <div class="panel panel-white">
                <div class="panel-heading">
                        <h4 class="panel-title">Formulario de <span class="text-bold">Actualizacion Ubicacion a Persona</span></h4>
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
                    <h2><i class="fa fa-pencil-square"></i>Ubicacion Persona</h2>
                    <p>
                            Asignacion de Ubicacion al Personal de ISDEMU
                    </p>
                    <hr>
              <form:form method="POST" action="${pageContext.request.contextPath}/UbicacionPersona/edit/${ubicacionpersona.idUbicacionPersona}" onsubmit="return valida_envio();" modelAttribute="ubicacionpersona" id="personaF" >
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
                                                        Ubicacion<span id="span_nombre" class="symbol "></span>
                                                </label>
                                               <form:select path="TbcUbicacion.idUbicacion" class="form-control" id="dropdown" name="dropdown" onchange="return validaUbicacion(event);">
                                                    <form:option value="0"  label="Selecciona ubicacion"/>       
                                                    <c:forEach var="ubi" items="${ubicacion}">
                                                               <form:option value="${ubi.idUbicacion}"  label="${ubi.nombreUbicacion}"/>
                                                            </c:forEach>
                                                 </form:select>
                                                <span for="nombre" class="help-block  no-display" id="span_dropdownT">Ingrese una ubicacion</span>    
                                    </div>
                                    <div class="form-group">
                                                <label class="control-label">
                                                        Persona<span id="span_nombre" class="symbol "></span>
                                                </label>
                                               <form:select path="TbcPersona.idPersona" class="form-control" id="dropdown1" name="dropdown1" onchange="return validaPersona(event);">
                                                    <form:option value="0"  label="Selecciona persona"/>       
                                                    <c:forEach var="per" items="${persona}">
                                                               <form:option value="${per.idPersona}"  label="${per.nombrePersona}"/>
                                                            </c:forEach>
                                                 </form:select>
                                                <span for="nombre" class="help-block  no-display" id="span_dropdown1T">Ingrese una persona</span>    
                                    </div>                      
                                                                                
                                </div>
                                <div class="col-md-6">
                                    
                                   <div class="form-group">
                                                <label class="control-label">
                                                        Jefe<span id="span_jefe" class="symbol"></span>
                                                </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                                <form:select path="jefatura" class="form-control" id="jefe" name="jefe" onblur="return validaJefe(event);">
                                                    <form:option value="0"  label="Seleccionar.."/>       
                                                    <form:option value="Si"  label="Si"/>
                                                    <form:option value="No"  label="No"/>  
                                                 </form:select>                                                
                                                <span for="jefe" class="help-block  no-display" id="span_jefeT">Seleccione si es Jefe</span> 
                
                                    </div> 
                                                <div class="form-group">
                                                <label class="control-label">
                                                        Encargado<span id="span_encargado" class="symbol"></span>
                                                </label>
                                                <form:select path="encargadoAfijo" class="form-control" id="encargado" name="encargado" onblur="return validaEncargado(event);">
                                                    <form:option value="0"  label="Seleccionar.."/>       
                                                    <form:option value="Si"  label="Si"/>
                                                    <form:option value="No"  label="No"/>  
                                                 </form:select>  
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->                                                
                                                <span for="encargado" class="help-block  no-display" id="span_encargadoT">Ingrese un Encargado</span> 
                
                                    </div> 
                                    
                                   
                                </div>                                       
                             </div>
                      
                        
                        <div class="row">
                                <div class="col-md-8">
                                       
                                </div>
                                <div class="col-md-4">
                                    <button class="btn btn-yellow btn-block" type="submit" onclick="quitarmensaje();">
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
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesUbicacionPersona.js"></script>
 <script>
   $(document).ready(function () 
   {       
          
        if (document.forms["personaF"]["msje"].value==="1")
        {
            
           $('#mensajeExitoFormM').removeClass("no-display"); 
           document.forms["personaF"]["msje"].value==="0";
        }

    }); 
    
    function quitarmensaje(){
        
        $('#mensajeExitoFormM').addClass("no-display"); 
    };
</script>