<%-- 
    Document   : consultar_ubicacion
    Created on : 13-ago-2015, 23:12:16
    Author     : Walter
--%>


<%@include file="header.jsp"%>
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
                                Consultar Ubicacion
                        </li>
                </ol>
        </div>
</div>
<!-- end: BREADCRUMB -->
                                                
<!-- start: PAGE CONTENT -->
	<div class="row">
            <div class="col-md-12">
                    <!-- start: EXPORT BASIC TABLE PANEL -->
                    <div class="panel panel-white">
                            <div class="panel-heading">
                                    <h4 class="panel-title"> <span class="text-bold">Consultar</span> Ubicacion</h4>
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
                                                                            <a href="#" class="export-excel" data-table="#sample-table-2">
                                                                                    Export to Excel
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="#" class="export-doc" data-table="#sample-table-2">
                                                                                    Export to Word
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="#" class="export-powerpoint" data-table="#sample-table-2">
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
                                            <table class="table table-hover" id="sample-table-2">
                                                    <thead>
                                                            <tr>
                                                             
                                                                    <th>Nombre Ubicacion</th>
                                                                    <th>Eliminar</th>
                                                                    <th>Actualizar</th>
                                                            </tr>
                                                    </thead>
                                                    <tbody>
                                                     <c:forEach var="ubi" items="${ubicacion}">
                                                            <tr >
                                                                
                                                                    <td>${ubi.nombreUbicacion}</td>
                                                                    <td><a href="${pageContext.request.contextPath}/Ubicacion/delete/${ubi.idUbicacion}" onclick="if(!confirm('¿Desea borrar la Ubicacion?'))return false">
                                                                    Eliminar</a></td>
                                                                    <td><a href="${pageContext.request.contextPath}/Ubicacion/edit/${ubi.idUbicacion}">
                                                                    Actualizar</a></td>
                                                                    
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                            </table>
                                    </div>
                            </div>
                    </div>
                    <!-- end: EXPORT BASIC TABLE PANEL -->
            </div>
    </div>
<%@include file="footer.jsp"%>