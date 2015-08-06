<%-- 
    Document   : actualizar_prestamo
    Created on : 06-ago-2015, 10:57:51
    Author     : Walter
--%>

<%@include file="header.jsp"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start: BREADCRUMB -->
<div class="row">
        <div class="col-md-12">
                <ol class="breadcrumb">
                        <li>
                                <a href="#">
                                        Control Salida
                                </a>
                        </li>
                        <li class="active">
                                Etidar Control Salida
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
                                <h4 class="panel-title">Edicion de <span class="text-bold">Prestamo Equipo</span></h4>
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
                                <h2><i class="fa fa-pencil-square"></i> Prestamo de Equipo</h2>
                              
                        <hr>


<form:form method="POST" action="${pageContext.request.contextPath}/Prestamo/editPrestamo2/${prestamo.idPrestamoEquipo}" modelAttribute="prestamo" >
    
       
                <div class="form-group">
                        <label class="control-label">
                                id Prestamo Equipo<span class="symbol required"></span>
                        </label>
                        <form:input path="idPrestamoEquipo" type="text" placeholder="${prestamo.idPrestamoEquipo}" class="form-control" id="id" name="lastname"/>
                </div>
    
               <div class="form-group">
                            <label class="control-label">
                                    Fecha Solicitud<span class="symbol required"></span>
                            </label>
<!--                                                <input type="text" placeholder="Codigo" class="form-control" id="codigo" name="firstname">-->
                            <form:input path="fechaSolicitud" type="text" placeholder="${prestamo.fechaSolicitud}" class="form-control" id="fecha_sol" name="fecha_sol"/>

                </div> 
                
                
                
               <div class="row">
      
                                
<!--                                <div class="col-md-4">
                                    <button class="btn btn-yellow btn-block" id="btnDetalle" type="button">
                                                Detalle inventario <i class="fa fa-arrow-circle-right"></i>
                                        </button>
                                </div>-->
                        
                        
                            <div class="row">
                                
                                <div class="col-md-4">
                                        <button class="btn btn-yellow btn-block" type="submit">
                                                Actualizar <i class="fa fa-arrow-circle-right"></i>
                                        </button>
                                </div>
                            </div>
                </div>
                  </form:form>

                       <div class="table-responsive">
                        <table class="table table-striped table-hover" id="sample-table-2">
                                <thead>
                                        <tr>
                                             <th>id control inv</th>
                                               <th>ID control</th>
                                                <th>ID inventario</th>
                                                <th>marca</th>
                                                <th>Delete</th>
                                        </tr>
                                </thead>
                                <tbody id="tablabody" name="tablabody">

                                <c:forEach var="pre" items="${prestamoInv}">
                                            <tr align="center">
                                                <td>${pre.idPrestamoEquipoInventario}</td>
                                                <td>${pre.tbPrestamoEquipo.idPrestamoEquipo}</td>
                                                <td>${pre.tbInventario.idInventario}</td>                                                  
                                                <td>${pre.tbInventario.marca}</td> 
                                                <td><a href=""> Eliminar</a></td>

                                            </tr>
                                        </c:forEach>	
                                          

                                </tbody>
                        </table>
                </div>

 
</div>
								</div>
								<!-- end: FORM VALIDATION 1 PANEL -->
							</div>
						</div>
						
						<!-- end: PAGE CONTENT-->
				<%@include file="footer.jsp" %>		
                                
                                
                                <script>
$("#btnDetalle").click(function () {
   var conceptName = $("#id").val(); // define the variable
    //var conceptName = 1;
    alert(conceptName);
    
    
    
   $.ajax({ 
                url: "${pageContext.request.contextPath}/Movimiento/detalleInventarios", 
                type: 'POST', 
                dataType: 'json', 
                contentType: 'application/json',
                mimeType: 'application/json',
                
                
                data: "{id:" + conceptName + "}", 
                
               success: function(data) 
            { 
                   var html = '';
                   var len = data.length;
                    //alert("devuelve algo"+data);
//                            $('#dropdown2').empty();
//                            data.forEach(function(entry) 
//                            {
//                                    console.log(entry);
//                                   // alert("foreach :"+entry.nombreClase );
//                                   html += '<option value="' + entry.idClaseActivo + '">' + entry.nombreClase + '</option>';
//                            });
//                            $('#dropdown2').append(html);
                    alert("devuelve algo: "+data);
                                       
                    //var tblBody = document.createElement("tbody");
 
  // Crea las celdas
                        $('#tablabody').empty();
                        data.forEach(function(entry) 
                            {
                                 console.log(entry);
                                 html = '';
                                 html+="<tr>";
                                 html+="<td>"+entry.idInventario+"</td>";
                                 html+="<td>"+entry.marca+"</td>";
                                 html+="<td>"+entry.modelo+"</td>";
                                 html+="</tr>";
                                 
                                
                                 $('#tablabody').append(html);
                                //tblBody.appendChild(hilera);
                                
                            });
                            
                         },    
                error:function(data,status,er) 
                { 
                    alert("error: "+data+" status: "+status+" er:"+er);
                    
                    
                }
            });
   
       
    });
 </script>