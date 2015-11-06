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
                <h2><i class="fa fa-pencil-square"></i> INVENTARIO</h2>
                <p>
                    Esta es la seccion de Ingreso de Activos Fijos
                </p>
                <hr>







                <form:form method="POST" action="${pageContext.request.contextPath}/Inventario/add" modelAttribute="inventario" id="inventarioF" name="inventarioF">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="errorHandler alert alert-danger no-display" id="mensajeErrorForms">

                                <i class="fa fa-times-sign"></i> Se encontraron errores, favor verificarlos.
                            </div>
                            <div class="successHandler alert alert-success no-display" id="mensajeExitoFormM">
                                <i class="fa fa-ok"></i> Guardado con exito! Activo con Codigo ${codigoIngresado}
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="form-field-select-3">
                                    Clasificacion Activo<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="" class="form-control" id="dropdown1" name="dropdown1" onchange="return validaClasificacion(event);">
                                    <form:option value="0"  label="Selecciona una clasificacion"/>
                                    <c:forEach var="clasi" items="${clasificacionA}">
                                        <form:option value="${clasi.idClasificacionActivo}"  label="${clasi.nombreClasificacion}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_dropdownT">Seleccione una Clasificacion</span>
                            </div>

                            <div class="form-group">
                                <label for="form-field-select-3">
                                    Clase de Activo<span id="span_clase" class="symbol "></span>
                                </label>

                                <form:select path="TbcClaseActivo.idClaseActivo" class="form-control" id="dropdown2" name="dropdown" onchange="return validaClase(event);">
                                    <form:option value="0"  label="Selecciona una clasificacion"/>

                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_dropdown2T">Seleccione una Clase de Activo</span>
                            </div>

                                                       
                              <div class="form-group">
                                <label for="form-field-select-3">
                                    Tipo Localizacion<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="" class="form-control" id="tipoClasificacion" name="tipoClasificacion" onchange="return validatipoLocalizacion(event);">
                                    <form:option value="0"  label="Seleccione un Tipo de Localizacion"/>
                                    <c:forEach var="clasiL" items="${clasiLocalizacion}">
                                        <form:option value="${clasiL.idClasificacionLocalizacion}"  label="${clasiL.nombreClasificacion}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="clasiL" class="help-block  no-display" id="span_localizaciontipoT">Seleccione un Tipo de Localizacion</span>
                            </div>
                            
                              <div class="form-group">
                                <label for="form-field-select-3">
                                    Localizacion<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="idLocalizacion" class="form-control" id="localizacion" name="localizacion" onchange="return validaLocalizacion(event);">
                                    <form:option value="0"  label="Selecciona una localizacion"/>
                                    
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_localizacionT">Seleccione una Localizacion</span>
                            </div>
                            
                               <div class="form-group">
                                <label for="form-field-select-3">
                                    Ubicacion<span id="span_clasi" class="symbol "></span>
                                </label>
                                <form:select path="TbcUbicacion.idUbicacion" class="form-control" id="ubicacion" name="ubicacion" onchange="return validaUbicacion(event);">
                                    <form:option value="0"  label="Selecciona una Ubicacion"/>
                                   
                                </form:select>
                                <span for="ubicacion" class="help-block  no-display" id="span_ubicacionT">Seleccione una Ubicacion</span>
                            </div>

                            <div class="form-group">
                                <label for="form-field-select-3">
                                    En custodia de<span id="span_persona" class="symbol "></span>
                                </label>
                                <form:select path="tbcPersona.idPersona" class="form-control" id="persona" name="persona" onchange="return validaCustodia(event);">
                                    <form:option value="0"  label="Selecciona la persona encargada del Activo"/>       
                                    
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_personaT">Seleccione una Persona</span>
                            </div>




                            <div class="form-group">
                                <label class="control-label">
                                    Marca<span id="span_marca" class="symbol"></span>
                                </label>
                                <form:input path="marca" type="text" placeholder="Ingrese la marca del equipo" class="form-control" id="marca" name="marca"/>
                                <span for="marca" class="help-block  no-display" id="span_marcaT">Ingrese una Marca</span> 
                            </div>

                              <div class="form-group">
                                <label class="control-label">
                                    Modelo<span id="span_modelo" class="symbol"></span>
                                </label>
                                <form:input path="modelo" type="text" placeholder="Ingrese el modelo del equipo" class="form-control" id="modelo" name="modelo" />
                                <span for="modelo" class="help-block  no-display" id="span_modeloT">Ingrese un Modelo</span> 
                            </div>
                                <div class="form-group">
                                <label class="control-label">
                                    Serie<span id="span_serie" class="symbol"></span>
                                </label>
                                <form:input path="serie" type="text" placeholder="Ingrese el numero de serie" class="form-control" id="serie" name="serie" />
                                <span for="serie" class="help-block  no-display" id="span_serieT">Ingrese el numero de Serie</span> 
                            </div> 
                                
                                     
                             <div class="form-group">
                                <label class="control-label">
                                    Descripcion<span id="span_serie" class="symbol"></span>
                                </label>
                                <form:input path="descripcionEquipo" type="text" placeholder="Ingrese una descripcion del equipo" class="form-control" id="descripcionEquipo" name="descripcionEquipo" />
                                <span for="descripcionEquipo" class="help-block  no-display" id="span_serieT">Ingrese el numero de Serie</span> 
                            </div>
                                
                        </div>  
                        <!--     Cierre div izquiero-->
                        <div class="col-md-6">
                           
                            <div class="form-group">
                                <label class="control-label">
                                    Fecha Adquisicion<span id="span_adq" class="symbol"></span>
                                </label>
                                <div class="input-group">
                                    <form:input path="fechaAdquisicion" type="text" id="fecha_adq" name="fecha_adq" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker" onchange="return validaFechaAdq(event);" onblur="return validaFechaAdq(event);"/>
                                    <span class="input-group-addon"> <i class="fa fa-calendar"></i></span>
                                   </div> <span for="fecha_adq" class="help-block  no-display" id="span_fechaAdq">Ingrese Fecha Adquisicion</span>
                                
                            </div>

                              <div class="form-group">
                                <label for="form-field-select-3">
                                    Proveedor<span id="span_clasi" class="symbol "></span>
                                </label>

                                <form:select path="tbcProveedor.idProveedor" class="form-control" id="proveedor" name="proveedor">
                                    <form:option value="0"  label="Seleccion un proveedor"/>
                                    <c:forEach var="proveedor" items="${proveedor}">
                                        <form:option value="${proveedor.idProveedor}"  label="${proveedor.nombreProveedor}"/>
                                    </c:forEach>
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_dropdownT">Seleccione un Proveedor</span>
                            </div>




                            <div class="form-group">
                                <label class="control-label">
                                    Valor<span id="span_valor" class="symbol"></span>
                                </label>
                                <form:input path="valor" type="text" placeholder="Ingrese el valor en $ del equipo" class="form-control" id="valor" name="valor" onkeypress="return valideKey(event);"/>
                                <span for="valor" class="help-block  no-display" id="span_valorT">Ingrese Valor</span> 
                            </div>



                            <div class="form-group">
                                <label class="control-label">
                                    N Factura<span id="span_factura" class="symbol"></span>
                                </label>
                                <form:input path="NFactura" type="text" placeholder="Ingrese el numero de factura" class="form-control" id="factura" name="factura"/>
                                <span for="factura" class="help-block  no-display" id="span_facturaT">Ingrese numero factura</span> 
                            </div>
                        <div class="form-group">
                                <label class="control-label">
                                    Financiamiento<span id="span_finan" class="symbol"></span>
                                </label>
                                <form:input path="financiamiento" type="text" placeholder="Ingrese el tipo de financiamiento del equipo" class="form-control" id="financiamiento" name="financiamiento" />
                                <span for="financiamiento" class="help-block  no-display" id="span_financiamientoT">Ingrese un Financiamiento</span> 
                            </div>


                            <div class="form-group">
                                <label class="control-label">
                                    Observacion<span id="span_finan" class="symbol"></span>
                                </label>
                                <form:textarea path="observacion" type="text"  placeholder="Ingrese Una Observacion" class="form-control" id="observacion" name="observacion" />
                                <span for="observacion" class="help-block  no-display" id="span_financiamientoT">Ingrese una Observacion</span> 
                            </div>
                                
                          
                            <div class="form-group">
                                <label for="form-field-select-3">
                                    Tipo de Ingreso<span id="span_persona" class="symbol "></span>
                                </label>
                                <form:select path="" class="form-control" id="cmb_tipoingreso" name="dropdown" >
                                    <form:option value="0"  label="Selecciona el tipo de ingreso "/>       
                                       <form:option value="1"  label="Por lotes"/>
                                       <form:option value="2"  label="Por un mismo codigo"/>
                                         
                                </form:select>
                                <span for="clasifi" class="help-block  no-display" id="span_personaT">Seleccione una Persona</span>
                            </div>
                                
                            <div class="form-group">
                                <label class="control-label">
                                    Cantidad<span id="span_valor" class="symbol"></span>
                                </label>
                                <form:input path="valorLibro" type="text" placeholder="Ingrese la cantidad de activos a ingresar" class="form-control" readonly="true" id="cantidadl" name="cantidadl" onkeypress="return valideKey(event);" onblur="return validaValor(event);"/>
                                <span for="cantidadl" class="help-block  no-display" id="span_valorCT">Ingrese Cantidad</span> 
                            </div>


                        </div>
                          
                        <div class="row">
                            <div class="col-md-12">
                                <div class="col-md-6">
                                </div>
                                <div class="col-md-2">
                                    <button id="btn_guardar" class="btn btn-yellow btn-block" type="submit" >
                                        Guardar Activo <i class="fa fa-arrow-circle-right"></i>
                                    </button>
                                </div>
                                
                                
                                
                                <div class="col-md-2">
                                    <button id="btn_agregar" class="btn btn-yellow btn-block" type="button" disabled="true" onclick="agregarInventario();">
                                        Agregar <i class="fa fa-arrow-circle-right"></i>
                                    </button>
                                </div>
                                
                                <div class="col-md-2">
                                    <button id="btn_guardaru" class="btn btn-yellow btn-block no-display" type="button" onclick="enviarInventarioU()">
                                        Guardar <i class="fa fa-arrow-circle-right"></i>
                                    </button>
                                </div>
                            </div>
                        </div>
                                
                         <div class="table-responsive">
                        <table class="table table-striped table-hover" id="tabla_inventario">
                                <thead>
                                        <tr>
                                               <th class="no-display">id</th>
                                               <th>clasificacion</th>.
                                                <th>clase</th>
                                                 <th>Descripcion</th>
                                                <th>En custodia de</th>   
                                                <th>marca</th>
                                                <th>modelo</th>
                                                <th>serie</th>
                                                <th>fecha</th> 
                                                <th>valor</th>  
                                                <th>Factura</th>  
                                                <th>Financiamiento</th>  
                                                <th>Ubicacion</th> 
                                              
                                                <th>Delete</th>
                                        </tr>
                                </thead>
                                <tbody id="tablabody" name="tablabody">

                              	
                                          

                                </tbody>
                        </table>
                        </div>  
                          <form:input class="no-display" path="" type="text" value="${message}"  id="msje"  />
                        
                                
                                
                    </form:form>
                </div>


            </div>
        </div>
        <!-- end: FORM VALIDATION 1 PANEL -->
    </div>
</div>

<!-- end: PAGE CONTENT-->
<%@include file="footer.jsp" %>	

<script src="${pageContext.request.contextPath}/assets/validaciones/validacionesInventario.js"></script>

<script>
    
  
    
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
                   // alert(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idClaseActivo + '">'+entry.codigoClase+'-'+ entry.nombreClase + '</option>';
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

//index change de ubicacion para cargar persona
    
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
                $('#persona').empty();
                html = '<option value="0"  label="Selecciona una persona"/>';
                data.forEach(function (entry)
                {
                    console.log(entry);
                    // alert("foreach :"+entry.nombreClase );
                    html += '<option value="' + entry.idPersona + '">' + entry.nombrePersona + '</option>';
                });
                $('#persona').append(html);
                // alert("devuelve algo: "+data);
            },
            error: function (data, status, er) {
                alert("error: " + data + " status: " + status + " er:" + er);


            }
        });


    });

//para cambiar el tipo de ingreso
 $("#cmb_tipoingreso").change(function () {
        var conceptName = $('#cmb_tipoingreso :selected').val(); // define the variable
       //alert(conceptName);
       $('#inventarioF').attr('action', '${pageContext.request.contextPath}/Inventario/add/lotes');
    
    if(conceptName==0)
    { 
     $('#cantidadl').attr("readonly", true);
     $('#btn_guardar').show();
     $('#btn_guardaru').hide();
     $('#btn_agregar').attr('disabled','disabled');
    }
    if(conceptName==1)
    { 
        $('#cantidadl').attr("readonly", false);
     $('#btn_guardar').show();
        $('#btn_guardaru').hide();
    }
    if(conceptName==2) {  
       // $('#btn_guardar').attr('disabled','disabled');
       $('#cantidadl').attr("readonly", true);
        $('#btn_agregar').removeAttr('disabled');
        $('#btn_guardar').hide();
        $('#btn_guardaru').show();
        
        
    }
    
   });
   var i=0;
    //funcion para agregar los activos a la tabla
    function agregarInventario(){ 
         //alert("valida");
        if (valida_envio()){      
           
            
        return 0; 
         }
        
        
                  i++;
                  var clasificacion = $('#dropdown1 option:selected').text();
                  var clase = $('#dropdown2 option:selected').text();
                  var idclase=$('#dropdown2 option:selected').val();
                  var idLocalizacion=$('#localizacion').val();
                   var ubicacion=$('#ubicacion option:selected').text();
                  var descripcion = $('#descripcionEquipo').val();
                  var custodiad = $('#persona option:selected').text();
                  var idcustodiad = $('#persona option:selected').val();
                  var marca = $('#marca').val();
                  var modelo = $('#modelo').val();
                  var serie = $('#serie').val();
                  var fecha = $('#fecha_adq').val();
                  var valor = $('#valor').val();
                  var factura= $('#factura').val();
                  var financiamiento=$('#financiamiento').val();
                  var idInv=i.toString();
                 
                  $('#tabla_inventario').append('<tr  id="' + idInv + '">'+'\
                            <td class=\"no-display\" >' +idInv + '</td>'+'\
                            <td>' + clasificacion + '</td>\n\\n\
                            <td>' + clase + '</td>\n\\n\\n\
                            <td class=\"no-display\">' + idclase + '</td>\n\\n\\n\
                            <td>' + descripcion + '</td>\n\\n\
                            <td>' + custodiad + '</td>\n\\n\\n\
                            <td class=\"no-display\">' + idcustodiad + '</td>\n\\n\\n\
                            <td>' + marca + '</td>\n\\n\
                            <td>' + modelo + '</td>\n\\n\
                            <td>' + serie + '</td>\n\\n\
                            <td>' + fecha + '</td>\n\\n\
                            <td>' + valor + '</td>\n\\n\
                            <td>' + factura + '</td>\n\
                            <td>' + financiamiento + '</td>\n\\n\\n\\n\
                            <td class=\"no-display\">' + idLocalizacion + '</td>\n\\n\\n\
                            <td>' + ubicacion + '</td>\n\\n\
                            <td class="eliminar">\n\
                              <a href="" onclick="return deleteElement('+"'"+ idInv +"'"+ ');">\
                                <span class="glyphicon glyphicon-remove"></span>\n\
                              </a>\n\
                            </td>\n\
                 </tr>');
                
              };
      
//enviar todo lo que esta en la tabla que se va guardar
    function enviarInventarioU()
    {
       //alert("enviar");
        
        if($('#tabla_inventario tr').size()>1)
        {
        
         var jsonArray="{";
         jsonArray+="\"Inventario\":[";
         var l=0;
    
        $('#tabla_inventario tr').each(function(index, element){

        var clasificacion = $(element).find("td").eq(1).html();
        var idclase = $(element).find("td").eq(3).html();
        var descripcion = $(element).find("td").eq(4).html();
        var custodiade = $(element).find("td").eq(6).html();
        var marca = $(element).find("td").eq(7).html();
        var modelo = $(element).find("td").eq(8).html();
        var serie = $(element).find("td").eq(9).html();
        var fechaAd = $(element).find("td").eq(10).html();
        var valor = $(element).find("td").eq(11).html();
        var nfactura = $(element).find("td").eq(12).html();
        var financiamiento = $(element).find("td").eq(13).html();
        var idLocalizacion = $(element).find("td").eq(14).html();
      
        if(l!=0)
        {
            jsonArray=jsonArray+"{\"clasi\":"+'"'+clasificacion+'"'+",\"idClase\":"+'"'+idclase+'"'+",\"descripcion\":"+'"'+descripcion+'"'+",\"idCustodiade\":"+'"'+custodiade+'"'+",\"marca\":"+'"'+marca+'"'+",\"modelo\":"+'"'+modelo+'"'+",\"serie\":"+'"'+serie+'"'+",\"fechaA\":"+'"'+fechaAd+'"'+",\"valor\":"+'"'+valor+'"'+",\"factura\":"+'"'+nfactura+'"'+",\"financiamiento\":"+'"'+financiamiento+'"'+",\"idLocalizacion\":"+'"'+idLocalizacion+'"'+"},";
                    
          }

        l=1;

    });


    jsonArray=jsonArray.substring(0,jsonArray.length-1);
    jsonArray=jsonArray+"]}";
    //alert(jsonArray);
    console.log(jsonArray);
         $.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/Inventario/add/mismocodigo",
           dataType: "json",
           contentType: 'application/json',
           success: function (msg) {
                   $('#inventarioF').each(function () {
                        this.reset();
                        $('.help-block').closest("div").removeClass("has-success");
                        $('.help-block').closest("div").removeClass("has-error");
                    }); 
                    $('#mensajeExitoFormM').removeClass("no-display");
                    $('#tablabody').empty();
           },
           data: jsonArray
       });
       }
       else
       {
       
        //$('#mensajeErrorFormM').removeClass("no-display");
       alert("Debe ingresar al menos un elemento a la tabla");
       } 
    }
   
   function deleteElement(id)
    {
        
        
        var el = document.getElementById(id);
        el.parentNode.removeChild(el);
        return false; 
    };
        
    function valideKey(evt)
    {
        var code = (evt.which) ? evt.which : evt.keyCode;
        if (code == 8)
        {
            //backspace
            return true;
        }
        else if (code >= 48 && code <= 57)
        {
            //is a number
            return true;
        }
        else
        {
            return false;
        }
    }
    ;
    
 
   $(document).ready(function () 
   {       
         // alert(document.forms["inventarioF"]["msje"].value);
        if (document.forms["inventarioF"]["msje"].value==="1")
        {
             
           $('#mensajeExitoFormM').removeClass("no-display"); 
           document.forms["inventarioF"]["msje"].value==="0";
        }

    }); 

</script>
