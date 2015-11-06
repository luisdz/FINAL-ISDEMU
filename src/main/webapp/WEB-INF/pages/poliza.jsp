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
                Ingreso de Activos
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
                <h2><i class="fa fa-pencil-square"></i> POLIZA</h2>
                <p>
                    Esta es la seccion de Ingreso de Activos Fijos
                </p>
                <hr>





                <!--                    <form action="#" role="form" id="form">-->
                <form:form  method="POST" action="${pageContext.request.contextPath}/Poliza/insertarPoliza" onsubmit="return valida_envio();" modelAttribute="poliza" id="polizaF"  >

                    <div class="row">
                        <div class="col-md-12">
                            <div class="errorHandler alert alert-danger no-display" id="mensajeErrorForm">

                                <i class="fa fa-times-sign"></i> You have some form errors. Please check below.
                            </div>
                            <div class="successHandler alert alert-success no-display" id="mensajeExitoFormM">
                                <i class="fa fa-ok"></i> Guardado con exito!
                            </div>
                        </div>
                        <div class="col-md-6">




                            <div class="form-group">
                                <label class="control-label">
                                    Nombre<span id="span_nombre" class="symbol "></span>
                                </label>
                                <!--                                                <input type="text" placeholder="Nombre" class="form-control" id="nombre" name="firstname">-->
                                <form:input path="nombrePoliza" type="text" placeholder="Ingrese el nombre de la poliza" class="form-control" id="nombre" name="nombre" onblur="return validaNombrePoliza(event);"/>
                                <span for="nombre" class="help-block  no-display" id="span_nombreT">Ingrese un nombre</span>    
                            </div>
                            <div class="form-group">
                                <label class="control-label">
                                    Codigo<span class="symbol"></span>
                                </label>
                                <!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                                <form:input path="codigoPoliza" type="text" placeholder="Ingrese el codigo de la poliza" class="form-control" id="codigo" name="codigo" onblur="return validaCodigoPoliza(event);"/>
                                <span for="codigo" class="help-block  no-display" id="span_codigoT">Ingrese un codigo</span>    
                            
                            </div>
                                </div>
                                <div class="col-md-6">   

                            <div class="form-group">
                                <label class="control-label">
                                    Fecha Inicio<span class="symbol"></span>
                                </label>
                                <div class="input-group">
                                    <form:input path="fechaInicio" type="text" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker" id="fechaInicio" onchange="return validaFechaIniPoliza(event);" onblur="return validaFechaIniPoliza(event);"/>
                                    <span class="input-group-addon"> <i class="fa fa-calendar"></i> </span>
                                  </div>  <span for="fechaInicio" class="help-block  no-display" id="span_fechaIniT">Ingrese una fecha</span>    
                            
                            
                                
                            </div>

                            <div class="form-group">
                                <label class="control-label">
                                    Fecha Fin<span class="symbol"></span>
                                </label>
                                <div class="input-group">
                                    <form:input path="fechaFin" type="text" data-date-format="dd-mm-yyyy" data-date-viewmode="years" id="fechaFin" class="form-control date-picker" onchange="return validaFechaFnPoliza(event);" onblur="return validaFechaFnPoliza(event);"/>
                                    <span class="input-group-addon"> <i class="fa fa-calendar"></i> </span>
                                 </div>   <span for="fechaFin" class="help-block  no-display" id="span_fechaFnT">Ingrese una fecha</span>    
                            
                                
                            </div>

                        </div>
                        <div class="col-md-6">


                        </div>
                        <div class="row">

                            <div class="col-md-4">
                                <button class="btn btn-yellow btn-block" type="submit"  >
                                    Guardar Activo <i class="fa fa-arrow-circle-right"></i>
                                </button>
                            </div>
                        </div>
                                    </div>
                                     <form:input class="no-display" path="" type="text" value="${message}"  id="msje"  />
                                      <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
                     
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
          
        if (document.forms["polizaF"]["msje"].value==="1")
        {
             
           $('#mensajeExitoFormM').removeClass("no-display"); 
           document.forms["polizaF"]["msje"].value==="0";
        }

    }); 
</script>
