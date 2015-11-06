<%-- 
    Document   : verificarInventario
    Created on : 08-24-2015, 12:51:11 PM
    Author     : Jose Eduardo
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
                <h2><i class="fa fa-pencil-square"></i> Verificacion de Inventario</h2>
                <p>
                    Esta es la seccion de Ingreso de Activos Fijos
                </p>
                <hr>

                <form:form method="POST" action="${pageContext.request.contextPath}/Descargo/insertarDescargo"  modelAttribute="verificarInventario" id="descargoF" onsubmit="return valida_envioDescargo();" >
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
                        

                           

                        </div>

                        <div class="col-md-6">
                           
                    

                            <div class="form-group">
                                <label class="control-label">
                                    Codigo Inventario<span class="symbol "></span>
                                </label>
                                <form:input path=""  type="text" placeholder="Ingrese un codigo" class="form-control" id="codigo" name="codigo" />
                                <span for="codigo" class="help-block  no-display" id="span_codigoE">El codigo es invalido o ya esta agreagado</span>  
                                <span for="codigo" class="help-block  no-display" id="span_codigoE2">El inventario con ese codigo esta descargado</span>  
                            
                            </div>
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
                                Verificar Inventario <i class="fa fa-arrow-circle-right"></i>
                            </button>
                        </div>
                    </div>
                </form:form>

                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="VerificarInv">
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
                
                <div class="col-md-6">
                    ACTIVOS FALTANTES
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="InventarioFaltante">
                        <thead>
                            <tr>
                                
                                <th>Codigo</th>
                                <th>Descripcion</th>
                                <th>Valor</th>
                              
                            </tr>
                        </thead>
                        <tbody id="tablabody" name="tablabody">


                        </tbody>
                    </table>
                </div>
               </div>   
                <div class="col-md-6">
                    ACTIVOS SOBRANTES
                    <table class="table table-striped table-hover" id="InventarioSobrante">
                        <thead>
                            <tr>
                                
                                <th>codigo</th>
                                <th>Descripcion</th>
                                <th>Valor</th>
                              
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
        var localizacion=$("#localizacion").val();
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
                   //alert(num);
                    if (num >= 1)
                    {
                        listaInv.forEach(function (entry)
                        {
                            //alert("for each");
                            $('#VerificarInv').append('<tr  id="' + entry.idInventario + '">' + '<td class=\"no-display\" >' + entry.idInventario + '</td>' + '<td>' + entry.codigoInventario + '</td>' +'</td>' + '<td>' + entry.tbcClaseActivo.nombreClase + '</td>'+'<td class=\"no-display\">' + localizacion + '</td>'+'<td>' + entry.descripcionEquipo + '</td><td class="eliminar"><a href="" onclick="return deleteElement(' + "'" + entry.idInventario + "'" + ');"><span class="glyphicon glyphicon-remove"></span></a></td></tr>');
                            $('#span_codigoE').addClass("no-display");
                            $('#span_codigoE').closest("div").removeClass("has-error");
                           
                        });
                   
                        
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
    

    function condigoYaAgregado(cod)
    {
        var l = 0;
        var flag = true;
        $('#VerificarInv tr').each(function (index, element) {
            if (l != 0)
            {
                if ($(element).find("td").eq(1).html() === cod)
                {
                    flag = false;
                }
            }
            l = 1;
        });
        return flag;
    };
    
    //BOTON VERIFICAR INVENTARIO
    function enviarDes()
    {
        $("#ingresar").val(1);
       //alert($("#ingresar").val());
        
       
        if ($('#VerificarInv tr').size() > 1)        
        {
            
            var jsonArray="{";
            jsonArray += "\"Inventario\":[";

            var l = 0;

            $('#VerificarInv tr').each(function (index, element) {

                var id = $(element).find("td").eq(0).html();
                var codigo = $(element).find("td").eq(1).html();
                var idlocalizacion = $(element).find("td").eq(3).html();

                if (l != 0)
                {
                    jsonArray = jsonArray + "{\"idInv\":" + '"' + id + '"'+",\"codigo\":"+'"'+codigo+'"'+",\"idlocalizacion\":"+'"'+idlocalizacion+'"'+"},";
                }
                l = 1;
            });

            jsonArray = jsonArray.substring(0, jsonArray.length - 1);
            jsonArray = jsonArray + "]}";
            //alert(jsonArray);
           
            //AQUI DEVULEVE LAS DOS LISTAS CON EL INVENTARIO FALTANTE Y EL SOBRANTE
            $.ajax({
                
                type: "POST",
                url: "${pageContext.request.contextPath}/VerificarInventario/add/agregarTBTemporal",
                contentType: 'application/json',
                dataType: "json",
                data: jsonArray,
                success: function (data)
                {
                   // alert("entra:"+data[1]);
                    //$("#fechaDescargo").attr('value') = " ";
                   
        
        
        //AQUI SE VA LLENAR LAS TABLAS CON LAS LISTAS DE LOS INVENTARIOS
          data[0].forEach(function (entry)
                        {
                            
                            //alert("for each");
                            $('#InventarioFaltante').append('<tr  id="' + entry[0] + '">' + '<td>' + entry[1] + '</td>'+'<td>' + entry[2] + '</td>'+ '<td>' + entry[3] + '</td></tr>');
                       //  alert("cadacodigo:"+entry);
                           
                        });
            data[1].forEach(function (entry)
                        {
                            //alert("for each");
                            $('#InventarioSobrante').append('<tr  id="' + entry[0] + '">' + '<td>' + entry[1] + '</td>'+'<td>' + entry[2] + '</td>'+ '<td>' + entry[3] + '</td></tr>');
                       //  alert("cadacodigo:"+entry);
                           
                        });
                        
                        
                    $('#descargoF').each(function () {
                        this.reset();
                        $('.help-block').closest("div").removeClass("has-success");
                        $('.help-block').closest("div").removeClass("has-error");
                    }); 
                    $('#mensajeExitoFormM').removeClass("no-display");
                   // $('#tablabody').empty();
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
    

    $(document).ready(function () {

        $('#dropdown').select2();

    });
</script>
