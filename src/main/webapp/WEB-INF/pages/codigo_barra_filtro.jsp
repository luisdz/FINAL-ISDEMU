<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                Consultar
            </li>
        </ol>
    </div>
</div>
<!-- end: BREADCRUMB -->
<!-- start: PAGE CONTENT -->

<div class="row">
    <div class="col-md-12">
        <!-- start: EXPORT DATA TABLE PANEL  -->
        <div class="panel panel-white">
            <div class="panel-heading">
                <h4 class="panel-title">Consultar <span class="text-bold">Inventario</span> Activos Fijos</h4>
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
                <div class="row">
                    <div class="col-md-12 space20">
                        
                        <div class="btn-group pull-right">
                            <button data-toggle="dropdown" class="btn btn-green dropdown-toggle">
                                Export <i class="fa fa-angle-down"></i>
                            </button>
                            <ul class="dropdown-menu dropdown-light pull-right">
                                <li>
                                    <a href="#" class="export-pdf" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Save as PDF
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-png" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Save as PNG
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-csv" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Save as CSV
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-txt" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Save as TXT
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-xml" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Save as XML
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-sql" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Save as SQL
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-json" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Save as JSON
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-excel" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Export to Excel
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-doc" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Export to Word
                                    </a>
                                </li>
                                <li>
                                    <a href="#" class="export-powerpoint" data-table="#sample-table-2" data-ignoreColumn ="3,4">
                                        Export to PowerPoint
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="sample-table-2">
                        <thead>
                            <tr>
                                <th class="no-display">ID inventario</th>
                                <th>Clase Equipo</th>
                                <th>En custodia de</th>
                                <th>descripcionEquipo</th>
                                <th>codigoInventario</th>
                                <th>Marca</th>
                                <th>Modelo</th>
                                <th>Ubicacion</th> 
                                <th>fechaAdquisicion</th>
                                <th>valor</th>
                            
                                
                                <th>Seleccionar</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="inv" items="${inventario}">
                                <tr id="${inv.codigoInventario}" >
                                    <td class="no-display">${inv.idInventario}</td>
                                    <td>${inv.tbcClaseActivo.nombreClase}</td>
                                    <td>${inv.tbcPersona.nombrePersona}</td>
                                    <td>${inv.descripcionEquipo}</td>
                                    <td>${inv.codigoInventario}</td>
                                    <td>${inv.marca}</td>
                                    <td>${inv.modelo}</td>
                                    <td>${inv.tbcUbicacion.nombreUbicacion}</td>
                                    <td>${inv.fechaAdquisicion}</td>
                                    <td>${inv.valor}</td>
                                   
                                    
                                    <td><button type="button" onclick="cargarDatos(${inv.codigoInventario})">Agregar</button></td>

                                </tr>
                            </c:forEach>	


                        </tbody>
                    </table>
                </div>
                <div class="table-responsive">
                    <table class="table table-striped table-hover" id="tabla_codigo">
                        <thead>
                             <tr>
                                <th>Codigo Inventario</th>
                                <th>Descripcion Equipo</th>
                                <th>Eliminar</th>
                             </tr>
                        </thead>
                        <tbody>
                            
                            
                            
                          </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="col-md-8">

                    </div>
                    <div class="col-md-2">
                                    <button id="btn_guardar" class="btn btn-yellow btn-block" type="button" onclick="enviar();" >
                                        Imprimir Codigos<i class="fa fa-arrow-circle-right"></i>
                                    </button>
                                </div>
                    </div>
            </div>
        </div>
        <!-- end: EXPORT DATA TABLE PANEL -->
    </div>
</div>
<!-- end: PAGE CONTENT-->

<script  language="JavaScript">
    function confirmar( mensaje ) 
    { 
        return confirm(mensaje); 
    } 
    
    
    function cargarDatos(id) {
        
        var id_ = document.getElementById(id).cells[0].innerHTML;
	var codigo = document.getElementById(id).cells[4].innerHTML;
	var nombre_inventario = document.getElementById(id).cells[5].innerHTML;
        $('#tabla_codigo').append('<tr id="' + id_ + '"><td>' + codigo + '</td><td>' + nombre_inventario + '</td><td class="eliminar"><a href="" onclick="return deleteElement('+"'"+ id_ +"'"+ ');"><span class="glyphicon glyphicon-remove"></span></a></td></tr>');
       
}

function deleteElement(id){
        var el = document.getElementById(id);
        el.parentNode.removeChild(el);
        return false;
        }
        
        
  function enviar()
    {        
                
              
        var jsonArray="{"
        
      
         jsonArray+="\"Inventario\":[";
        
        var l=0;
        var bandera = 0;
        $('#tabla_codigo tr').each(function(index, element){

        var id = $(element).find("td").eq(0).html();
      
        if(l!=0){
            jsonArray=jsonArray+"{\"idInv\":"+'"'+id+'"'+"},";
            bandera=1;
          }

        l=1;

    });


    jsonArray=jsonArray.substring(0,jsonArray.length-1);
    jsonArray=jsonArray+"]}";
    //alert(jsonArray);
    if(bandera==0)
    {
        alert("Debe ingresar al menos un activo");
        return 0;
    }
         $.ajax({
           type: "POST",
           url: "${pageContext.request.contextPath}/Usuario/codigo_barra",
           dataType: "json",
           contentType: 'application/json; charset=utf-8',
           success: function (msg) {
               alert("msg");
               $("#tabla_codigo").empty();
           },
           data: jsonArray
       });
        
    };
</script>
<%@include file="footer.jsp"%>
