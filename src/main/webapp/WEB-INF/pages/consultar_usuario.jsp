<%-- 
    Document   : consultar_usuario
    Created on : 21-sep-2015, 23:02:45
    Author     : Walter
--%>

<%@include file="header.jsp"%>
<!-- start: BREADCRUMB -->
<div class="row">
        <div class="col-md-12">
                <ol class="breadcrumb">
                        <li>
                                <a href="#">
                                        Seguridad
                                </a>
                        </li>
                        <li class="active">
                                Consultar Usuario
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
                                    <h4 class="panel-title"> <span class="text-bold">Consultar</span> Usuario</h4>
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
                                
                                <a href="${pageContext.request.contextPath}/Usuario/codigo_barra">Generar</a>
                                
                                
                                    <div class="table-responsive">
                                            <table class="table table-hover" id="sample-table-2">
                                                    <thead>
                                                            <tr>                                                                  
                                                                    <th>Nombre</th>
                                                                    <th>Apellidos</th>
                                                                    <th>Usuario</th>
                                                                    <th>Eliminar</th>
                                                                    <th>Actualizar</th>
                                                            </tr>
                                                    </thead>
                                                    <tbody>
                                                     <c:forEach var="usu" items="${usuario}">
                                                            <tr >
                                                                    <td>${usu.nombreUsuario}</td>
                                                                    <td>${usu.apellidoUsuario}</td>
                                                                    <td>${usu.usuario}</td>
                                                                    <td><a href="${pageContext.request.contextPath}/Usuario/delete/${usu.idUsuario}">
                                                                    Eliminar</a></td>
                                                                    <td><a href="${pageContext.request.contextPath}/Usuario/edit/${usu.idUsuario}">
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