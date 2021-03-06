<%-- 
    Document   : detalle_control
    Created on : 15-sep-2015, 17:57:50
    Author     : Walter
--%>
<%@include file="header.jsp"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: BREADCRUMB -->
<div class="row">
        <div class="col-md-12">
                <ol class="breadcrumb">
                        <li>
                                <a href="#">
                                       Reportes
                                </a>
                        </li>
                        <li class="active">
                                 Reporte Inventario
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
                                <h2><i class="fa fa-pencil-square"></i>Reporte por Localizacion</h2>
                              
                        <hr>


<form:form method="POST" action="" id="controlE" name="controlE">
    
       
                
               <div class="row">

                           
                </div>
                <div class="col-md-12 text-center">            
                              
                            </div>
                      
                
                       <div class="table-responsive">
                        <table class="table table-striped table-hover" id="sample-table-2">
                                <thead>
                                        <tr>
                                            <th>CODIGO ACTIVO</th>
                                            <th>DESCRIPCION</th>                                             
                                            <th>CLASE</th>
                                            <th>MARCA</th>
                                            <th>MODELO</th>
                                            <th>SERIE</th>
                                            <th>VALOR</th>
                                            <th>UBICACION</th>
                                            <th>ASIGNADO A</th>
                                        </tr>
                                </thead>
                                <tbody id="tablabody" name="tablabody">

                                <c:forEach var="con" items="${reportLocali}">
                                            <tr>
                                                <td>${con[1]}</td>
                                                <td>${con[0]}</td>
                                                <td>${con[17]}</td>
                                                <td>${con[2]}</td>
                                                <td>${con[3]}</td>
                                                <td>${con[4]}</td>
                                                <td><fmt:formatNumber pattern="$#0.00" value="${con[6]}" /></td>
                                                <td>${con[19]}</td>
                                                <td>${con[20]}</td> 
                                            </tr>
                                        </c:forEach>	
                                          

                                </tbody>
                        </table>
                </div>
                            <div class="row">
                                <div class="col-md-12">
                                     &nbsp;<br/>  
                                </div>
                                <div class="col-md-4">
                                    <a href="${pageContext.request.contextPath}/ReportesL/reporteLocalizacion"  class="btn btn-yellow btn-block">
                                                Regresar <i class="fa fa-arrow-circle-right"></i>
                                        </a>
                                </div>
                            </div>
        </form:form>
            </div>
                            </div>
                            <!-- end: FORM VALIDATION 1 PANEL -->
                    </div>
            </div>

                <!-- end: PAGE CONTENT-->
<%@include file="footer.jsp" %>	