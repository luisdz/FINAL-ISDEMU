<%-- 
    Document   : descargo
    Created on : 26-jul-2015, 16:12:08
    Author     : luis diaz
--%>



<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
						<!-- start: PAGE CONTENT -->
		                                                
<!--    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  -->
               
  
  <!-- jQuery Form Validation code -->
  
                                                
                                                
    <div class="row">
        <div class="col-md-12">
            <!-- start: FORM VALIDATION 1 PANEL -->
            <div class="panel panel-white">
                <div class="panel-heading">
                        <h4 class="panel-title">Formulario de <span class="text-bold">Ingreso</span></h4>
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
                    <h2><i class="fa fa-pencil-square"></i> Descargo</h2>
                    <p>
                            Esta es la seccion de Ingreso de Activos Fijos
                    </p>
                    <hr>
                     <form:form method="POST" action="${pageContext.request.contextPath}/Descargo/insertarDescargo" modelAttribute="descargo" >
                       <div class="row">
                                <div class="col-md-12">
                                        <div class="errorHandler alert alert-danger no-display">
                                                <i class="fa fa-times-sign"></i> You have some form errors. Please check below.
                                        </div>
                                        <div class="successHandler alert alert-success no-display">
                                                <i class="fa fa-ok"></i> Your form validation is successful!
                                        </div>
                                </div>
                                <div class="col-md-6">
                                     <div class="form-group">
                                        <p>
                                                Fecha 
                                        </p>
                                        <div class="input-group">
                                                <form:input path="fecha" type="text" data-date-format="dd-mm-yyyy" data-date-viewmode="years" class="form-control date-picker"/>
                                                <span class="input-group-addon"> <i class="fa fa-calendar"></i> </span>
                                        </div>
                                   </div>
                         
                                    
                                    <br>

                                          

                                        <div class="form-group">
                                                <label class="control-label">
                                                        Comentario<span class="symbol required"></span>
                                                </label>
                                            <form:input path="comentario" type="text" placeholder="Ingrese el nombre" class="form-control" id="lastname" name="lastname"/>
                
                                        </div>
                                     <br>
                                     
                                         <div class="form-group">
                                            <label for="form-field-select-3">
                                                    Inventario
                                            </label>

                                              <form:select path="TbInventario.idInventario" class="form-control" id="dropdown" name="dropdown">
                                                  <form:option value="0"  label="Selecciona un elemento"/>
                                                        <c:forEach var="inv" items="${inventario}">
                                                            <form:option value="${inv.idInventario}"  label="${inv.claseEquipo}"/>
                                                         </c:forEach>
                                              </form:select>
                                     </div>
                                      
                                      
                                       </div>
                            
                            <div class="col-md-6">
                                
                                 
 
                                
                                
                                
                            </div>
                               
                        </div>
                        <div class="row">
                                <div class="col-md-12">
                                        <div>
                                                <span class="symbol required"></span>Campos Requeridos
                                                <hr>
                                        </div>
                                </div>
                        </div>
                        <div class="row">
                                <div class="col-md-8">

                                </div>
                                <div class="col-md-4">
                                        <button class="btn btn-yellow btn-block"   type="submit" value="Submit">
                                                Ingresar <i class="fa fa-arrow-circle-right"></i>
                                        </button>
                                </div>
                        </div>
                    </form:form>
                    
<!--                    validation-->
                   
<!--                    fin validation-->
                    

                </div>
            </div>
            <!-- end: FORM VALIDATION 1 PANEL -->
        </div>
    </div>
						
						<!-- end: PAGE CONTENT-->
                                                        
                                                
                                                
<%@include file="footer.jsp" %>		