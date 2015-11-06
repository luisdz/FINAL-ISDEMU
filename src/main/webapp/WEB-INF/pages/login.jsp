<%-- 
    Document   : login
    Created on : 08-25-2015, 09:05:08 PM
    Author     : Jose Eduardo
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido, Formulario de Ingreso</title>
                
        
               <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/animate.css/animate.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/iCheck/skins/all.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles-responsive.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/iCheck/skins/all.css">
		<!--[if IE 7]>
		<link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome-ie7.min.css">
		<![endif]-->
		<!-- end: MAIN CSS -->
		<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
		<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
	</head>
	<!-- end: HEAD -->
	<!-- start: BODY -->
	<body class="login">
		<div class="row">
			<div class="main-login col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
				<div class="logo">
					<img src="${pageContext.request.contextPath}/assets/images/logo.png">
				</div>
				<!-- start: LOGIN BOX -->
				<div class="box-login">
					<h3>Inicio de Sesion</h3>
					<p>
						Por Favor Ingrese su usuario y contraseña.
					</p>
                                       <form action="<c:url value='/j_spring_security_check' />" method='POST'>
                
		
						<div class="errorHandler alert alert-danger no-display">
							<i class="fa fa-remove-sign"></i> You have some form errors. Please check below.
						</div>
						<fieldset>
                                                    
                                                    
							<div class="form-group">
								<span class="input-icon">
                                                                    <input class="form-control" type='text' name='username' value=''>
									<i class="fa fa-user"></i> </span>
							</div>
                                                     
							<div class="form-group form-actions">
								<span class="input-icon">
									<input class="form-control password" id="password" type='password' name='password'>
									<i class="fa fa-lock"></i>
									<a class="forgot" href="#">
										Olvide mi contraseña
									</a> </span>
							</div>
                                                    <c:if test="${not empty error}">
                                                            <div class="error">Su usuario o Contraseña son Inconrrectos</div>
                                                    </c:if>
                                                    <c:if test="${not empty msg}">
                                                        <div class="msg">${msg} no son esos</div>
                                                    </c:if>
							<div class="form-actions">
								
                                                            <button name="submit" type="submit" value="submit" class="btn btn-green pull-right">
									Iniciar <i class="fa fa-arrow-circle-right"></i>
								</button>
							</div>
							
						</fieldset>
                                            <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form>
					<!-- start: COPYRIGHT -->
					<div class="copyright">
						2015 &copy;Sistema Activos Fijos ISDEMU.
					</div>
					<!-- end: COPYRIGHT -->
				</div>
				<!-- end: LOGIN BOX -->
				<!-- start: FORGOT BOX -->
				
				<!-- end: FORGOT BOX -->
				<!-- start: REGISTER BOX -->
				
				<!-- end: REGISTER BOX -->
			</div>
		</div>
		<!-- start: MAIN JAVASCRIPTS -->
		<!--[if lt IE 9]>
		<script src="assets/plugins/respond.min.js"></script>
		<script src="assets/plugins/excanvas.min.js"></script>
		<script type="text/javascript" src="assets/plugins/jQuery/jquery-1.11.1.min.js"></script>
		<![endif]-->
		<!--[if gte IE 9]><!-->
		<script src="${pageContext.request.contextPath}/assets/plugins/jQuery/jquery-2.1.1.min.js"></script>
		<!--<![endif]-->
		<script src="${pageContext.request.contextPath}/assets/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/plugins/iCheck/jquery.icheck.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/plugins/jquery.transit/jquery.transit.js"></script>
		<script src="${pageContext.request.contextPath}/assets/plugins/TouchSwipe/jquery.touchSwipe.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
		<!-- end: MAIN JAVASCRIPTS -->
		<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script src="${pageContext.request.contextPath}/assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/js/login.js"></script>
		<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
		<script>
			jQuery(document).ready(function() {
				Main.init();
				Login.init();
			});
                        
//                        function tumadre(){
//                            
//                            
//                           usaurio=$("#j_username").text();
//                           alert(                            document.getElementById("j_username").value);
//                       alert(                            document.getElementById("j_password").value);
//                       document.forms[0]
//                        }
		</script>
    </body>
</html>
