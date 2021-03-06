
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@include file="header.jsp" %>

<!-- start: BREADCRUMB -->
						<div class="row">
							<div class="col-md-12">
								<ol class="breadcrumb">
									<li>
										<a href="#">
											Sistema Activos Fijos
										</a>
									</li>
									<li class="active">
										Accesos directos
									</li>
								</ol>
							</div>
						</div>
						<!-- end: BREADCRUMB -->
                                                
						<!-- start: PAGE CONTENT -->
                                                

						<div class="row">
							<div class="col-md-6 col-lg-3 col-sm-6">
								<div class="panel panel-default panel-white core-box">
									<div class="panel-tools">
										<a href="#" class="btn btn-xs btn-link panel-close">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="panel-body no-padding">
										<div class="partition-green padding-20 text-center core-icon">
											<i class="fa fa-barcode fa-2x icon-big"></i>
										</div>
										<div class="padding-20 core-content">
											<h3 class="title block no-margin">INVENTARIO</h3>
											<span class="subtitle"> Acceso directo al registro de activos fijos. </span>
										</div>
									</div>
									<div class="panel-footer clearfix no-padding">
										<div class=""></div>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-green" data-toggle="tooltip" data-placement="top" title="More Options"><i class="fa fa-cog"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-blue" data-toggle="tooltip" data-placement="top" title="Add Content"><i class="fa fa-plus"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-red" data-toggle="tooltip" data-placement="top" title="View More"><i class="fa fa-chevron-right"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-lg-3 col-sm-6">
								<div class="panel panel-default panel-white core-box">
									<div class="panel-tools">
										<a href="#" class="btn btn-xs btn-link panel-close">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="panel-body no-padding">
										<div class="partition-blue padding-20 text-center core-icon">
											<i class="fa fa-sign-in fa-2x icon-big"></i>
										</div>
										<div class="padding-20 core-content">
											<h3 class="title block no-margin">MOVIMIENTOS</h3>
											<span class="subtitle"> Acceso directo al registro de movimientos de equipo. </span>
										</div>
									</div>
									<div class="panel-footer clearfix no-padding">
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-green" data-toggle="tooltip" data-placement="top" title="More Options"><i class="fa fa-cog"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-blue" data-toggle="tooltip" data-placement="top" title="Add Content"><i class="fa fa-plus"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-red" data-toggle="tooltip" data-placement="top" title="View More"><i class="fa fa-chevron-right"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-lg-3 col-sm-6">
								<div class="panel panel-default panel-white core-box">
									<div class="panel-tools">
										<a href="#" class="btn btn-xs btn-link panel-close">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="panel-body no-padding">
										<div class="partition-red padding-20 text-center core-icon">
											<i class="fa fa-desktop fa-2x icon-big"></i>
										</div>
										<div class="padding-20 core-content">
											<h3 class="title block no-margin">PRESTAMOS</h3>
											<span class="subtitle"> Acceso directo al registro de prestamos de equipo. </span>
										</div>
									</div>
									<div class="panel-footer clearfix no-padding">
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-green" data-toggle="tooltip" data-placement="top" title="More Options"><i class="fa fa-cog"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-blue" data-toggle="tooltip" data-placement="top" title="Add Content"><i class="fa fa-plus"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-red" data-toggle="tooltip" data-placement="top" title="View More"><i class="fa fa-chevron-right"></i></a>
									</div>
								</div>
							</div>
							<div class="col-md-6 col-lg-3 col-sm-6">
								<div class="panel panel-default panel-white core-box">
									<div class="panel-tools">
										<a href="#" class="btn btn-xs btn-link panel-close">
											<i class="fa fa-times"></i>
										</a>
									</div>
									<div class="panel-body no-padding">
										<div class="partition-azure padding-20 text-center core-icon">
											<i class="fa fa-bar-chart-o fa-2x icon-big"></i>
										</div>
										<div class="padding-20 core-content">
											<h3 class="title block no-margin">REPORTE</h3>
											<span class="subtitle"> Acceso directo al seccion de reportes del sistema de activos. </span>
										</div>
									</div>
									<div class="panel-footer clearfix no-padding">
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-green" data-toggle="tooltip" data-placement="top" title="More Options"><i class="fa fa-cog"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-blue" data-toggle="tooltip" data-placement="top" title="Add Content"><i class="fa fa-plus"></i></a>
										<a href="#" class="col-xs-4 padding-10 text-center text-white tooltips partition-red" data-toggle="tooltip" data-placement="top" title="View More"><i class="fa fa-chevron-right"></i></a>
									</div>
								</div>
							</div>
						</div>
<div class="row">
        <div class="col-md-6 col-lg-4 col-sm-6">
                <div class="panel panel-blue core-box">
                        <div class="e-slider owl-carousel owl-theme">
                                <div class="item">
                                        <div class="panel-body">
                                                <div class="core-box">
<%
Date dNow = new Date();
SimpleDateFormat ft =  new SimpleDateFormat ("dd/MM/yyyy");
String currentDate = ft.format(dNow);
int i=0;
%>								<div class="text-dark text-bold">
                                                                ULTIMOS MOVIMIENTOS DE EQUIPO HOY: <%=currentDate%>



                                        </div>
                                                        <div class="text-white space15">
                                                            <i class="fa fa-truck fa-4x pull-left"></i>
                                                                Ultimos movimientos Realizados (<i>Desglose de Activos</i>)
                                                        </div>
                                                        <div class="progress progress-xs transparent-black no-radius space5">
                                                                <div aria-valuetransitiongoal="88" class="progress-bar progress-bar-success partition-white animate-progress-bar" ></div>
                                                        </div>

                                                </div>
                                        </div>
                                        <div class="padding-10">
                                                <span class="bold-text">${nmov}</span><span class="text-light"> Movimientos </span>
                                                <a href="${pageContext.request.contextPath}/Movimiento/consultarMov.html" class="view-more pull-right text-dark text-bold">
                                                        Ver listado Completo <i class="fa fa-angle-right text-light"></i>
                                                </a>
                                        </div>
                                </div>
                        <div class="item">
                            <div class="panel-body">
                                <div class="core-box">
                                    <div class="text-dark text-bold">
                                    ULTIMOS MOVIMIENTOS DE EQUIPO


                                    </div>
                                    <table>  
                                        <thead>  
                                            <tr>
                                            <th>Fecha Movimiento &nbsp;</th> 
                                            <th>Razon de cambio</th> 
                                            

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="mov" items="${mov}" begin="0" end="4">

                                                <tr>
                                                <td>  ${mov.fechaMovimiento}&nbsp; &nbsp;</td>
                                               <td>  ${mov.razonCambio}&nbsp; &nbsp;</td>
                                                <td>  </td> 
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                            <div class="padding-10">
                                <span class="bold-text">${nmov}</span><span class="text-light"> Movimientos </span>
                                <a href="${pageContext.request.contextPath}/Movimiento/consultarMov.html" class="view-more pull-right text-dark text-bold">
                                Ver listado Completo <i class="fa fa-angle-right text-light"></i>
                                </a>
                            </div>
                    </div>

                </div>
        </div>
</div>
<div class="col-md-6 col-lg-4 col-sm-6">
        <div class="panel panel-green">
                <div class="e-slider owl-carousel owl-theme">
                        <div class="item">
                                <div class="panel-body">
                                        <div class="core-box">
                                                <div class="text-dark text-bold space15">

                                                </div>
                                                <div class="space5">
                                                        <i class="fa fa-thumbs-down fa-4x pull-left"></i>
                                                        Listado de Activos descargados del inventarios
                                                        <br/>
                                                        Selecciona la opcion de ver mas, para visualizar el detalle
                                                </div>

                                        </div>
                                </div>
                                <div class="padding-10">
                                        <span class="bold-text">${ndeg} </span><span class="text-light"> Activos Descargados </span>
                                        <a href="#" class="view-more pull-right text-dark text-bold">
                                                Ver listado Completo <i class="fa fa-angle-right text-light"></i>
                                        </a>
                                </div>
                        </div>
                        <div class="item">
                            <div class="panel-body">
                                <div class="core-box">
                                    <div class="text-dark text-bold">
                                    ULTIMOS DESCARGOS DE EQUIPO


                                    </div>
                                    <table>  
                                        <thead>  
                                            <tr>
                                            <th>Codigo</th> &nbsp;
                                            <th>Marca</th> &nbsp;
                                            <th>Modelo</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                              <c:forEach var="mov" items="${mov}" begin="1" end="4">

                                                <tr>
                                                <td>  ${mov.razonCambio}&nbsp; &nbsp;</td>
                                                <td>  &nbsp;</td> 
                                                <td>  </td> 
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                            <div class="padding-10">
                                <span class="bold-text">${ndeg}</span><span class="text-light"> Descargos </span>
                                <a href="${pageContext.request.contextPath}/Movimiento/consultarMov.html" class="view-more pull-right text-dark text-bold">
                                Ver listado Completo <i class="fa fa-angle-right text-light"></i>
                                </a>
                            </div>
                    </div>
                </div>
        </div>
</div>
<div class="col-md-6 col-lg-4 col-sm-6">
<div class="panel panel-blue core-box">
        <div class="e-slider owl-carousel owl-theme">
                <div class="item">
                        <div class="panel-body">
                                <div class="core-box">
                                        <div class="text-dark text-bold">
                                                ULTIMOS ACTIVOS INGRESADOS
                                        </div>
                                        <div class="text-white space15">
                                              <i class="fa fa-laptop fa-4x pull-left"></i>
                                                Ultimos Activos Ingresados (<i>Desglose de Activos</i>)
                                        </div>
                                    <div class="progress progress-xs transparent-black no-radius space5">
                                                <div aria-valuetransitiongoal="59" class="progress-bar progress-bar-success partition-white animate-progress-bar" ></div>
                                        </div>

                                </div>
                        </div>
                        <div class="padding-10">
                                <span class="bold-text">${ninv}</span><span class="text-light"> Activos Ingresados </span>
                                <a href="#" class="view-more pull-right text-dark text-bold">
                                        Ver Listado Completo <i class="fa fa-angle-right text-light"></i>
                                </a>
                        </div>
                </div>
              <div class="item">
                            <div class="panel-body">
                                <div class="core-box">
                                    <div class="text-dark text-bold">
                                    ULTIMOS ACTIVOS INGRESADOS


                                    </div>
                                    <table>  
                                        <thead>  
                                            <tr>
                                            <th>Codigo &nbsp;</th> 
                                            <th>Marca &nbsp;</th> 
                                            <th>Valor &nbsp;</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                              <c:forEach var="inv" items="${inv}" begin="1" end="4">

                                                <tr>
                                                <td>  ${inv.codigoInventario}&nbsp; &nbsp;</td>
                                                <td>  ${inv.marca}&nbsp; &nbsp;</td>
                                                <td> $ ${inv.valor}&nbsp; &nbsp;</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                            <div class="padding-10">
                                <span class="bold-text">${ninv}</span><span class="text-light"> Movimientos </span>
                                <a href="${pageContext.request.contextPath}/Movimiento/consultarMov.html" class="view-more pull-right text-dark text-bold">
                                Ver listado Completo <i class="fa fa-angle-right text-light"></i>
                                </a>
                            </div>
                    </div>
               
        </div>
</div>
</div>
							
						</div>
				
	
						<!-- end: PAGE CONTENT-->
<%@include file="footer.jsp" %>		
