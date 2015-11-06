<%-- 
    Document   : consultar_poliza
    Created on : 12-jul-2015, 15:11:40
     Author     : Luis Diaz
--%>
<%@include file="header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <h4 class="panel-title">Consultar <span class="text-bold">Poliza</span> </h4>
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
                 <div class="col-md-12">
                            <div class="errorHandler alert alert-danger no-display" id="mensajeErrorForm">

                                <i class="fa fa-times-sign"></i> You have some form errors. Please check below.
                            </div>
                            <div class="successHandler alert alert-success no-display" id="mensajeExitoFormM">
                                <i class="fa fa-ok"></i> Eliminado con exito!
                            </div>
                        </div>
                    <div class="table-responsive">
                            <table class="table table-striped table-hover" id="sample-table-2">
                                    <thead>
                                            <tr>
                                                   <th class="no-display">id</th>
                                                    <th>Nombre</th>
                                                    <th>Codigo</th>
                                                    <th>Fecha inicio</th>
                                                    <th>Fecha fin</th>
                                                    <th>Edit</th>
                                                    <th>Delete</th>
                                            </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <c:forEach var="pol" items="${poliza}">
                                            <tr align="center">
                                                    <td class="no-display">${pol.idPoliza}</td>
                                                    <td>${pol.nombrePoliza}</td>
                                                    <td>${pol.codigoPoliza}</td>
                                                    <td>${pol.fechaInicio}</td>
                                                    <td>${pol.fechaFin}</td>
                                                    <td><a href="${pageContext.request.contextPath}/Poliza/editPoliza/${pol.idPoliza}">
					Actualizar</a></td>
                                                    <td><a onclick="return confirmar('¿Está seguro que desea eliminar el registro?')" href="${pageContext.request.contextPath}/Poliza/deletePoliza/${pol.idPoliza}"> Eliminar</a>
                                                    </td>
                                            </tr>
                                        </c:forEach>
                                        
                                        
<!--                                            <tr>
                                                    <td>Peter Clark</td>
                                                    <td>UI Designer</td>
                                                    <td>(641)-734-4763</td>
                                                    <td>
                                                    <a href="#" class="edit-row">
                                                            Edit
                                                    </a></td>
                                                    <td>
                                                    <a href="#" class="delete-row">
                                                            Delete
                                                    </a></td>
                                            </tr>
                                            <tr>
                                                    <td>Nicole Bell</td>
                                                    <td>Content Designer</td>
                                                    <td>(741)-034-4573</td>
                                                    <td>
                                                    <a href="#" class="edit-row">
                                                            Edit
                                                    </a></td>
                                                    <td>
                                                    <a href="#" class="delete-row">
                                                            Delete
                                                    </a></td>
                                            </tr>
                                            <tr>
                                                    <td>Steven Thompson</td>
                                                    <td>Visual Designer</td>
                                                    <td>(471)-543-4073</td>
                                                    <td>
                                                    <a href="#" class="edit-row">
                                                            Edit
                                                    </a></td>
                                                    <td>
                                                    <a href="#" class="delete-row">
                                                            Delete
                                                    </a></td>
                                            </tr>
                                            <tr>
                                                    <td>Ella Patterson</td>
                                                    <td>Web Editor</td>
                                                    <td>(799)-994-9999</td>
                                                    <td>
                                                    <a href="#" class="edit-row">
                                                            Edit
                                                    </a></td>
                                                    <td>
                                                    <a href="#" class="delete-row">
                                                            Delete
                                                    </a></td>
                                            </tr>
                                            <tr>
                                                    <td>Kenneth Ross</td>
                                                    <td>Senior Designer</td>
                                                    <td>(111)-114-1173</td>
                                                    <td>
                                                    <a href="#" class="edit-row">
                                                            Edit
                                                    </a></td>
                                                    <td>
                                                    <a href="#" class="delete-row">
                                                            Delete
                                                    </a></td>
                                            </tr>-->
                                    </tbody>
                            </table>
                    </div>
            </div>
        </div>
        <!-- end: EXPORT DATA TABLE PANEL -->
         
    </div>
    </div>
<%@include file="footer.jsp"%>

 <script  language="JavaScript">
    function confirmar( mensaje ) 
    { 
        return confirm(mensaje); 
    } 
</script>