<%-- 
    Document   : movimiento
    Created on : 12-jul-2015, 11:15:45
    Author     : Luis diaz
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
                <h2><i class="fa fa-pencil-square"></i> Movimientos</h2>
                <p>
                    Esta es la seccion de Ingreso de Activos Fijos
                </p>
                <hr>
                    <form:form method="POST"  action="${pageContext.request.contextPath}/Movimiento/insertarMovimiento" modelAttribute="movimiento" id="movF" >
                        <div class="row">
                            <div class="col-md-12">
                                <div class="errorHandler alert alert-danger no-display" id="mensajeErrorFormM"  >
                                    <i class="fa fa-times-sign"></i> No se puede realizar la accion, existen errores en la informacion.
                                </div>
                                <div id="mensajeExitoFormM" class="successHandler alert alert-success no-display">
                                    <i class="fa fa-ok"></i> Guardado con Exito!
                                </div>
                            </div>
                            <div class="col-md-6">

                                    <div class="form-group">
                                    <label for="form-field-select-3">
                                        Tipo Localizacion<span id="span_clasi" class="symbol "></span>
                                    </label>

                                    <form:select path="" class="form-control" id="tipoClasificacion" name="tipoClasificacion" >
                                        <form:option value="0"  label="Seleccione un Tipo de Localizacion"/>
                                        <c:forEach var="clasiL" items="${clasiLocalizacion}">
                                            <form:option value="${clasiL.idClasificacionLocalizacion}"  label="${clasiL.nombreClasificacion}"/>
                                        </c:forEach>
                                    </form:select>
                                    <span for="clasiL" class="help-block  no-display" id="span_dropdownT">Seleccione un Tipo de Localizacion</span>
                                </div>

                                  <div class="form-group">
                                    <label for="form-field-select-3">
                                        Localizacion<span id="span_clasi" class="symbol "></span>
                                    </label>

                                    <form:select path="" class="form-control" id="localizacion" name="localizacion" >
                                        <form:option value="0"  label="Selecciona una localizacion"/>

                                    </form:select>
                                    <span for="clasifi" class="help-block  no-display" id="span_dropdownT">Seleccione una Clasificacion</span>
                                </div>

                                   <div class="form-group">
                                    <label for="form-field-select-3">
                                        Ubicacion<span id="span_clasi" class="symbol "></span>
                                    </label>

                                    <form:select path="" class="form-control" id="ubicacion" name="ubicacion" >
                                        <form:option value="0"  label="Selecciona una Ubicacion"/>

                                    </form:select>
                                    <span for="ubicacion" class="help-block  no-display" id="span_dropdownT">Seleccione una Ubicacion</span>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">
                                        Nuevo Responsable<span class="symbol"></span>
                                    </label>
                                    <form:select  multiple="single" path="" cssStyle="width: 100%" id="responsable" name="dropdown2" onchange="return validaRespMov(event);" onblur="return validaRespMov(event);">
                                        <form:option value="0" label="Seleccione responsable"/>                                                   
                                    </form:select>
                                    <span for="responsable" class="help-block  no-display" id="span_resp">Seleccione El nuevo responsable</span>  

                                </div>
                                <br>
                            </div>
                            <div class="col-md-6">

                                <div class="form-group">
                                    <label class="control-label">
                                        Fecha<span class="symbol "></span>
                                    </label>
                                    <div class="input-group">
                                        <form:input path="fechaMovimiento" type="text" data-date-format="dd-mm-yyyy" id="fechaMov" data-date-viewmode="years" onchange="return validaFechaMov(event);" onblur="return validaFechaMov(event);" class="form-control date-picker"/>
                                        <span class="input-group-addon"> <i class="fa fa-calendar"></i> </span>
                                    </div>  <span for="fechaMov" class="help-block  no-display" id="span_fecha">Ingrese una fecha</span>    

                                </div> 
                                <div class="form-group">
                                    <label class="control-label">
                                        Razon de cambio<span class="symbol "></span>
                                    </label>
                                    <form:input path="razonCambio" type="text" placeholder="Ingrese el nombre" class="form-control" id="razon" name="lastname"/>

                                </div>
                                <div class="form-group">
                                    <label class="control-label">
                                        Codigo Inventario<span class="symbol "></span>
                                    </label>
                                    <form:input path=""  type="text" placeholder="Ingrese un codigo" class="form-control" id="codigo" name="codigo" />
                                    <span for="codigo" class="help-block  no-display" id="span_codigoE">El codigo es invalido o ya esta agreagado</span>  
                                    <span for="codigo" class="help-block  no-display" id="span_codigoE2">El inventario con ese codigo esta descargado</span>  

                                </div>



                                <br>
                            </div>

                            <div class="col-md-6">






                            </div>

                        </div>
                        <div class="row  no-display">
                            <div class="col-md-12">
                                <div>
                                    <span class="symbol required"></span>Campos Requeridos
                                    <hr>
                                </div>
                            </div>
                        </div>

                    </form:form>
                <div class="col-md-12 text-center">
                    <button type="button" class="btn btn-default" onclick="enviarCodeM();" >Agregar</button>     
                </div>
                <div class="col-md-12 text-center">
                    &nbsp;<br/>
                </div>  
                <hr>
                <h4 class="panel-title"><span class="text-bold">Inventario</span></h4>

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

                <div class="row">
                    <div class="col-md-8">

                    </div>
                    <div class="col-md-4">
                        <button class="btn btn-yellow btn-block" type="button" id="ingresar" onclick="return enviarMov(event);" value="0" >
                            Guardar <i class="fa fa-arrow-circle-right"></i>
                        </button>
                    </div>
                </div>

                <!--                    validation-->

                <!--                    fin validation-->


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
    }
    ;

    function enviarMov()
    {
        //alert("enviar");
        $("#ingresar").val(1);
        validaRespMov();
        validaFechaMov();
        if ($('#tabla_prueba tr').size() > 1 && validaRespMov() && validaFechaMov() )
        {
            $('#mensajeErrorFormM').addClass("no-display");
            var fechaM = $("#fechaMov").val();
            
            var razonM = $("#razon").val();
            var codigoI = $("#codigo").val();
            var personaM = $('#responsable option:selected').text();
            var idpersonaM  = $('#responsable option:selected').val();

            var jsonArray = "{";
            jsonArray += "\"Movimiento\":[{\"fecha\":\"" + fechaM + "\",\"razon\":\" " + razonM + "\"" + ",\"codigo\":\"" + codigoI + "\",\"persona\":\"" + personaM + "\",\"idpersona\":\"" + idpersonaM + "\"" + "}],";
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
                url: "${pageContext.request.contextPath}/Movimiento/insertarMovimiento",
                contentType: 'application/json',
                success: function (msg) {
                    //alert("entra");
                    $('#movF').each(function () 
                    {
                        this.reset();
                        $('.help-block').closest("div").removeClass("has-success");
                        $('.help-block').closest("div").removeClass("has-error");
                    }); 
                    $('#mensajeExitoFormM').removeClass("no-display");
                    $('#tablabody').empty();
                    
                    window.location.href='./editMovimientoI/'+msg;                   
                    
                },
                data: jsonArray
            });
        }
        else
        {

            $('#mensajeErrorFormM').removeClass("no-display");
            return false;
        }

    }
    ;

    function enviarCodeM()
    {
        var codigoI = $("#codigo").val(); 
        if (condigoYaAgregado(codigoI) === true)
        {

            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/Movimiento/agregarInventarioM",
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
                            alert(" estado " + entry.tbcEstadoInventario.idEstado);
                            
                             if(entry.tbcEstadoInventario.idEstado === 2)
                            {
                                alert("entra");
                            } 
                            else
                            {
                            //console.log(entry);
                            $('#tabla_prueba').append('<tr  id="' + entry.idInventario + '">' + '<td class=\"no-display\" >' + entry.idInventario + '</td>' + '<td>' + entry.codigoInventario + '</td>' + '</td>' + '<td>' + entry.tbcClaseActivo.nombreClase + '</td>' + '<td>' + entry.descripcionEquipo + '</td><td class="eliminar"><a href="" onclick="return deleteElement(' + "'" + entry.idInventario + "'" + ');"><span class="glyphicon glyphicon-remove"></span></a></td></tr>');
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

    }
    ;


    $(document).ready(function () {


        $('#dropdown').select2();
        $('#dropdown2').select2();


    });

//Combos dependientes

$("#dropdown1").change(function () {
        var conceptName = $('#dropdown1 :selected').val(); // define the variable
        // alert(conceptName);



        $.ajax({
            url: "${pageContext.request.contextPath}/Inventario/listaClaseA",
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            data: conceptName,
            success: function (data) {
                var html = '';
                var len = data.length;
                //alert("devuelve algo"+data);
                $('#dropdown2').empty();
                html = '<option value="0"  label="Selecciona una clasificacion"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idClaseActivo + '">' + entry.nombreClase + '</option>';
                });
                $('#dropdown2').append(html);
                // alert("devuelve algo: "+data);
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);


            }
        });


    });
    
    
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
                html = '<option value="0"  label="Selecciona una localizacion"/>';
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
                $('#responsable').empty();
                html = '<option value="0"  label="Selecciona una persona"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idPersona + '">' + entry.nombrePersona + '</option>';
                });
                $('#responsable').append(html);
                // alert("devuelve algo: "+data);
                
                
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);

            }
        });


    });



</script>
