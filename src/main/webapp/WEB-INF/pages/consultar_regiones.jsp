<%-- 
    Document   : consultar_regiones
    Created on : 14-jul-2015, 21:20:14
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
										Consultar Regiones
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
                                    <h4 class="panel-title">Export <span class="text-bold">Basic</span> Table</h4>
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
                                    <p>
                                            Export HTML Table to JSON, XML, PNG, CSV, TXT, SQL, MS-Word, Ms-Excel, Ms-Powerpoint and PDF. You can easily set the font size, separator, export type, margin and etc..
                                    </p>
                                    <div class="row">
                                            <div class="col-md-12 space20">
                                                    <div class="btn-group pull-right">
                                                            <button data-toggle="dropdown" class="btn btn-green dropdown-toggle">
                                                                    Export <i class="fa fa-angle-down"></i>
                                                            </button>
                                                            <ul class="dropdown-menu dropdown-light pull-right">
                                                                   
                                                                    <li>
                                                                            <a href="#" class="export-excel" data-table="#sample-table-1">
                                                                                    Export to Excel
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="#" class="export-doc" data-table="#sample-table-1">
                                                                                    Export to Word
                                                                            </a>
                                                                    </li>
                                                                    <li>
                                                                            <a href="#" class="export-powerpoint" data-table="#sample-table-1">
                                                                                    Export to PowerPoint
                                                                            </a>
                                                                    </li>
                                                            </ul>
                                                    </div>
                                            </div>
                                    </div>
                                    <div class="table-responsive">
                                            <table class="table table-hover" id="sample-table-1">
                                                    <thead>
                                                            <tr>
                                                                    <th>Country</th>
                                                                    <th>Population</th>
                                                                    <th>Date</th>
                                                                    <th>%ge</th>
                                                                    <th>Prueba</th>
                                                                    <th>Paises</th>
                                                            </tr>
                                                    </thead>
                                                    <tbody>
                                                            <tr>
                                                                    <td>Chinna</td>
                                                                    <td>1,363,480,000</td>
                                                                    <td>March 24, 2014</td>
                                                                    <td>19.1</td>
                                                                    <td>19.1</td>
                                                                    <td>Brazil</td>
                                                            </tr>
                                                            <tr>
                                                                    <td>India</td>
                                                                    <td>1,241,900,000</td>
                                                                    <td>March 24, 2014</td>
                                                                    <td>17.4</td>
                                                                    <td>19.1</td>
                                                                    <td>Brazil</td>
                                                            </tr>
                                                            <tr>
                                                                    <td>United States</td>
                                                                    <td>317,746,000</td>
                                                                    <td>March 24, 2014</td>
                                                                    <td>4.44</td>
                                                                    <td>19.1</td>
                                                                    <td>Brazil</td>
                                                            </tr>
                                                            <tr>
                                                                    <td>Indonesia</td>
                                                                    <td>249,866,000</td>
                                                                    <td>July 1, 2013</td>
                                                                    <td>3.49</td>
                                                                    <td>19.1</td>
                                                                    <td>Brazil</td>
                                                            </tr>
                                                            <tr>
                                                                    <td>Brazil</td>
                                                                    <td>201,032,714</td>
                                                                    <td>July 1, 2013</td>
                                                                    <td>2.81</td>
                                                                    <td>19.1</td>
                                                                    <td>Brazil</td>
                                                            </tr>
                                                    </tbody>
                                            </table>
                                    </div>
                            </div>
                    </div>
                    <!-- end: EXPORT BASIC TABLE PANEL -->
            </div>
    </div>
   
<%@include file="footer.jsp"%>