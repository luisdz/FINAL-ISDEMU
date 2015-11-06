<%@include file="header.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                ETL
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
                <h4 class="panel-title">Seccion del ETL <span class="text-bold">Inventario</span></h4>
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
                <h2><i class="fa fa-pencil-square"></i> INVENTARIO</h2>
                <p>
                    En esta seccion se hace la migracion de los datos de la base de datos que se encuentra en linea, a la base de datos
                    de su maquina a nivel local para que pueda realizarse la verificacion de inventario en las distintas sedes , 
                    asegurandose que la informacion de verificacion se haga contra una base de datos actualizada, este procesos puede durar
                    algunos minutos...
                </p>
                <hr>

                          
<div class="row">
                       
    <div class="col-md-6">
          
    <button id="btn_guardaru" class="btn btn-yellow btn-block center-block" type="button">
                                        Iniciar Proceso <i class="fa fa-arrow-circle-right"></i>
    </button>
    </div>
    <div class="col-md-6">
          <div id="load-image" class="center-block">
            </div>
    </div>

    
    
                                
</div>
                </div>

             

            </div>
        </div>
        <!-- end: FORM VALIDATION 1 PANEL -->
    </div>
</div>

<!-- end: PAGE CONTENT-->
<%@include file="footer.jsp" %>	

<script>
    
    $("#btn_guardaru").click(function(){
    //alert("entra");
     var $contenidoAjax = $('#load-image').html('<p><img src="${pageContext.request.contextPath}/assets/images/barra-load.gif" alt="Rapido"/></p>');
    var datos="1"; 
    $.ajax(
        {
         type: "GET",
         data: datos,
         url: "${pageContext.request.contextPath}/Inventario/ETLInv/1",
         success: function(result){
             //alert("ya lo hizo");
        $contenidoAjax.html('<p class="text-center bg-primary">Proceso Realizado con Exito-- La Base de Datos Local ha sido actualizaco correctamente.</p>');
    }});
});
      
</script>