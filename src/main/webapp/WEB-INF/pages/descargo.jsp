<%-- 
    Document   : descargo
    Created on : 26-jul-2015, 16:12:08
    Author     : luis diaz
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
                <h2><i class="fa fa-pencil-square"></i> Descargo</h2>
                <p>
                    Esta es la seccion de Descargo de Activos Fijos
                </p>
                <hr>

                <form:form method="POST" action="${pageContext.request.contextPath}/Descargo/insertarDescargo" modelAttribute="descargo" id="descargoF" onsubmit="return valida_envioDescargo();" >
                    <div class="row">
                        <div class="col-md-12">
                            <div class="errorHandler alert alert-danger no-display" id="mensajeErrorFormM">
                                <i class="fa fa-times-sign"></i> You have some form errors. Please check below.
                            </div>
                            <div class="successHandler alert alert-success no-display" id="mensajeExitoFormM">
                                <i class="fa fa-ok"></i> Guardado con exito!
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label">
                                    Fecha Descargo <span class="symbol"></span>
                                </label>
                                <div class="input-group">
                                    <form:input id="fechaDescargo" path="fecha" type="text" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker" onchange="return validaFechaDescargo(event);" onblur="return validaFechaDescargo(event);"/>
                                    <span class="input-group-addon"> <i class="fa fa-calendar"></i> </span>
                                </div><span for="fechaInicio" class="help-block  no-display" id="span_fechaFnT">Ingrese una fecha</span>  

                            </div>


                            <br>



                            <div class="form-group">
                                <label class="control-label">
                                    Comentario<span class="symbol "></span>
                                </label>
                                <form:input path="comentario" type="text" placeholder="Ingrese un comentario" class="form-control" id="comentario" name="comentario" />

                            </div>
                            <br>



                            <div class="form-group">
                                <label class="control-label">
                                    Codigo Inventario<span class="symbol "></span>
                                </label>
                                <form:input path=""  type="text" placeholder="Ingrese un codigo" class="form-control" id="codigo" name="codigo" />
                                <span for="codigo" class="help-block  no-display" id="span_codigoE">El codigo es invalido o ya esta agreagado</span>  
                                <span for="codigo" class="help-block  no-display" id="span_codigoE2">El inventario con ese codigo esta descargado</span>  
                            
                            </div>

                        </div>

                        <div class="col-md-6">

                        </div>

                    </div>
                    <div class="row no-display">
                        <div class="col-md-12">
                            <div>
                                <span class="symbol required"></span>Campos Requeridos
                                <hr>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 text-center">
                        <button type="button" class="btn btn-default" onclick="enviarCodeD();" >Agregar</button>     
                    </div>
                    <div class="col-md-12 text-center">
                        &nbsp;<br/>
                    </div>                 
                    <div class="row">
                        <div class="col-md-8">

                        </div>
                        <div class="col-md-4">
                            <button class="btn btn-yellow btn-block" id="ingresar"   type="button" onclick="return enviarDes(event);" value="0" >
                                Ingresar <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </div>
                    </div>
                </form:form>

                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="tabla_prueba">
                        <thead>
                            <tr>
                                <th class="no-display">id</th>
                                <th>codigo</th>
                                <th>Clase</th>
                                 <th>Descripcion</th>  
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody id="tablabody" name="tablabody">


                        </tbody>
                    </table>
                </div>



            </div>
        </div>
        <!-- end: FORM VALIDATION 1 PANEL -->
    </div>
</div>

<!-- end: PAGE CONTENT-->



<%@include file="footer.jsp" %>		
<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesISDEMU-01.js"></script>
<script>
    function deleteElement(id)
    {
        var el = document.getElementById(id);
        el.parentNode.removeChild(el);
        return false;
    };  
    
     function enviarCodeD()
    {
        var codigoI = $("#codigo").val(); 
        if (condigoYaAgregado(codigoI) === true)
        {

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/Descargo/agregarInventario",
                dataType: "json",
                contentType: 'application/json',
                data: codigoI,
                success: function (listaInv)
                {
                    var num = 0;
                    listaInv.forEach(function (entry1)
                    {
                        num++;
                    }); 
                    if (num >= 1)
                    {
                         
                        listaInv.forEach(function (entry)
                        {
                            //console.log(entry);
                            //alert(entry.tbcEstadoInventario.idEstado);
                             
                            if(entry.tbcEstadoInventario.idEstado === 2)
                            {
                              
                            } 
                            else
                            {
                            $('#tabla_prueba').append('<tr  id="' + entry.idInventario + '">' + '<td class=\"no-display\" >' + entry.idInventario + '</td>' + '<td>' + entry.codigoInventario + '</td>' +'</td>' + '<td>' + entry.tbcClaseActivo.nombreClase + '</td>'+ '<td>' + entry.descripcionEquipo + '</td><td class="eliminar"><a href="" onclick="return deleteElement(' + "'" + entry.idInventario + "'" + ');"><span class="glyphicon glyphicon-remove"></span></a></td></tr>');
                            $('#span_codigoE').addClass("no-display");
                            $('#span_codigoE').closest("div").removeClass("has-error");
                            }
                        }); 
                     if ($('#tabla_prueba tr').size() <= 1)
                     {
                          
                         $('#span_codigoE2').delay(0).fadeIn(1000).fadeOut(5000);
                          //$('#span_codigoE').addClass("no-display");
                     }
                        
                    }
                    else
                    {
                        $('#span_codigoE').removeClass("no-display");
                        $('#span_codigoE').closest("div").addClass("has-error");
                        $('#span_codigoE').closest("div").removeClass("has-success");
                    }
                },
                error: function (data, status, er) {
                    alert("error: " + data + " status: " + status + " er:" + er);
                }

            });//Fin .ajax
        }
        else
                    {
                        $('#span_codigoE').removeClass("no-display");
                        $('#span_codigoE').closest("div").addClass("has-error");
                        $('#span_codigoE').closest("div").removeClass("has-success");
                    }
        
    };
    

    function enviarDes()
    {
        $("#ingresar").val(1);
                
        validaFechaDescargo();
        if ($('#tabla_prueba tr').size() > 1  && validaFechaDescargo()!==false)        
        {
           
            var fechaM = $("#fechaDescargo").val();
            var comentarioM = $("#comentario").val();
            var jsonArray = "{";

            jsonArray += "\"Descargo\":[{\"fecha\":\"" + fechaM + "\",\"comentario\":\" " + comentarioM + "\"" + "}],";

            jsonArray += "\"Inventario\":[";

            var l = 0;

            $('#tabla_prueba tr').each(function (index, element) {

                var id = $(element).find("td").eq(0).html();

                if (l != 0)
                {
                    jsonArray = jsonArray + "{\"idInv\":" + '"' + id + '"' + "},";
                }
                l = 1;
            });

            jsonArray = jsonArray.substring(0, jsonArray.length - 1);
            jsonArray = jsonArray + "]}";
            //alert(jsonArray);
            $.ajax({
                
                type: "POST",
                url: "${pageContext.request.contextPath}/Descargo/insertarDescargo",
                contentType: 'application/json',
                data: jsonArray,
                success: function (data)
                {
                    //alert("entra");
                    //$("#fechaDescargo").attr('value') = " ";
                            $('#descargoF').each(function () {
                        this.reset();
                        $('.help-block').closest("div").removeClass("has-success");
                        $('.help-block').closest("div").removeClass("has-error");
                    }); 
                    $('#mensajeExitoFormM').removeClass("no-display");
                    $('#tablabody').empty();
                },
                error: function (data, status, er)
                {
                    alert("error: " + data + " status: " + status + " er:" + er);
                }
            });
        }
        else
        {
            $('#mensajeErrorFormM').removeClass("no-display");
            
        }

    };


    $(document).ready(function () {

        $('#dropdown').select2();

    });
</script>