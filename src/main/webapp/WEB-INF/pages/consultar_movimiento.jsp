<%-- 
    Document   : consultar_movimiento
    Created on : 12-jul-2015, 15:06:25
    Author     : Luis Diaz
--%>
<%@include file="header.jsp"%>

<div class="row">
    <div class="col-md-12">
            <ol class="breadcrumb">
                    <li>
                            <a href="#">
                                    Movimientos
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
                    <h4 class="panel-title">Consultar <span class="text-bold">Movimientos</span> </h4>
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
                                            Nuevo <i class="fa fa-plus"></i>
                                    </button>
                                    <div class="btn-group pull-right">
                                            <button data-toggle="dropdown" class="btn btn-green dropdown-toggle">
                                                    Exportar <i class="fa fa-angle-down"></i>
                                            </button>
                                            <ul class="dropdown-menu dropdown-light pull-right">
                                                    <li>
                                                            <a href="#" class="export-pdf" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Save as PDF
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-png" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Save as PNG
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-csv" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Save as CSV
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-txt" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Save as TXT
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-xml" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Save as XML
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-sql" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Save as SQL
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-json" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Save as JSON
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-excel" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Export to Excel
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-doc" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
                                                                    Export to Word
                                                            </a>
                                                    </li>
                                                    <li>
                                                            <a href="#" class="export-powerpoint" data-table="#sample-table-2" data-ignoreColumn ="0,1,2,6,7">
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
                                                  
                                                    <th>Fecha de Movimiento</th>  
                                                    <th>Razon</th>
                                                    <th>Nuevo responsable</th> 
                                                    <th>Editar</th>                                                    
                                                    <th class="no-display">Eliminar</th>
                                            </tr>
                                    </thead>
                                    <tbody>
                                        
                                        
                                        <c:forEach var="mov" items="${movimiento}">
                                            <tr align="center">
                                                <c:forEach var="col" begin="1" items="${mov}">
                                                     <td>${col}</td>
                                                </c:forEach>
                                                <c:forEach var="col" begin="0" end="0"  items="${mov}">
                                                     <td><a href="${pageContext.request.contextPath}/Movimiento/editMovimientoI/${col}"> Detalle</a></td>
                                                     <td class="no-display"><a href="${pageContext.request.contextPath}/Movimiento/deleteMovimiento/${col}"> Eliminar</a>
                                                    </td>
                                                </c:forEach> 
                                                    

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
<%@include file="footer.jsp"%>