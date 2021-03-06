<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                Consultar ultimos activos ingresados
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
                 <button id="btn_guardar" class="btn btn-yellow btn-block" type="button" onclick="enviar_localizacion();" style="width:250px;">
                Imprimir Codigos<i class="fa fa-arrow-circle-right"></i>
            </button>
                 <button id="btn_guardar2" class="btn btn-yellow btn-block" type="button" onclick="formatoAsignacion(event);" style="width:250px;">
                Hoja de Asignaciones <i class="fa fa-arrow-circle-right"></i>
            </button>
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
                            <th>Codigo</th> 
                                <th>Descripcion</th>
                                <th>Marca</th>
                                <th class="no-display">Modelo</th>
                                <th class="no-display">Serie</th>
                                <th class="no-display">Fecha de adquisicion</th>
                                <th>Valor</th> 
                                <th hidden="true">Clase</th> 
                                <th>Responsable</th> 
                                <th>Ubicacion</th> 
                                <th class="no-display">Asignado a</th> 
                                <th class="no-display">Factura</th> 
                                <th class="no-display">Observacion</th>
                                <th class="no-display">Valor en Libro</th>
                                <th class="no-display">F.Garantia</th>                                 
                                <th class="no-display">Region</th>                                  
                                <th class="no-display">Financiamiento</th> 
                            
                           
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="con" items="${inventario}">
                                <tr >
                                    <td>${con[1]}</td>
                                                <td>${con[0]}</td>
                                                <td>${con[2]}</td>
                                                <td class="no-display">${con[3]}</td>
                                                <td class="no-display">${con[4]}</td>
                                                <td class="no-display">${con[5]}</td>
                                              <td><fmt:formatNumber pattern="$#0.00" value="${con[6]}" /></td>
                                                <td hidden="true">${con[7]}</td>
                                                <td>${con[20]}</td>
                                                <td>${con[19]}</td>
                                                <td class="no-display">${con[10]}</td>
                                                <td class="no-display">${con[11]}</td>
                                                <td class="no-display">${con[12]}</td>
                                                <td class="no-display">${con[13]}</td>
                                                <td class="no-display">${con[14]}</td>
                                                <td class="no-display">${con[15]}</td>
                                                <td class="no-display">${con[16]}</td>    
                                  
                                   
                                    
                                    

                                </tr>
                            </c:forEach>	


                        </tbody>
                    </table>
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
    
     function enviar_localizacion()
    {        
                
              
        var jsonArray="{"
        
      
         jsonArray+="\"Inventario\":[";
        
        var l=0;
        var bandera = 0;
        $('#sample-table-2 tr').each(function(index, element){

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
           contentType: 'application/json; charset=utf-8',
           success: function (msg) {
               alert(msg);
               $("#tabla_codigo").empty();
               window.open(
                '${pageContext.request.contextPath}/Usuario/imprimir_codigo_barra',
                '_blank' // <- This is what makes it open in a new window.
              );
               //window.location="${pageContext.request.contextPath}/Usuario/imprimir_codigo_barra";
           },
           data: jsonArray
       });
        
    };
    
    function formatoAsignacion()
    {
       var schoolList=new Array();
       var a=0;
        <c:forEach items="${inventario}" var="inv">
        a=a+1;
        </c:forEach>
       //alert("alert : "+a)
       window.location.href='${pageContext.request.contextPath}/Reportes/getFormatoAsignacion/'+a ;
     
       
    };
    
    
</script>
 
<%@include file="footer.jsp"%>