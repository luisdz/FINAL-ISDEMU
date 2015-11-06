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
                        <button class="btn btn-orange add-row">
                            Add New <i class="fa fa-plus"></i>
                        </button>
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
                            
                                
                                <th>Editar</th>
                                <th>Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="inv" items="${inventario}">
                                <tr >
                                    <td class="no-display">${inv.idInventario}</td>
                                    <td>${inv.tbcClaseActivo.nombreClase}</td>
                                    <td>${inv.tbcPersona.nombrePersona}</td>
                                    <td>${inv.descripcionEquipo}</td>
                                    <td>${inv.codigoInventario}</td>
                                    <td>${inv.marca}</td>
                                    <td>${inv.modelo}</td>
                                    <td>${inv.tbcPersona.tbcUbicacion.nombreUbicacion}</td>
                                    <td>${inv.fechaAdquisicion}</td>
                                    <td>${inv.valor}</td>
                                   
                                    
                                    <td><a href="${pageContext.request.contextPath}/Inventario/edit/${inv.idInventario}">
                                            Editar</a></td>
                                    <td><a href="${pageContext.request.contextPath}/Inventario/delete/${inv.idInventario}" onclick="return confirmar('¿Está seguro que desea eliminar el registro?')">
                                            Eliminar</a></td>

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
</script>
<%@include file="footer.jsp"%>