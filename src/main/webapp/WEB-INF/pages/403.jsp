<%-- 
    Document   : 403
    Created on : 04-27-2016, 08:03:02 PM
    Author     : Jose Eduardo
--%>

<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
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
								<img style="margin:0 auto 0 32%" src="${pageContext.request.contextPath}/assets/images/denegado.png" />
        <h1 style="text-align:center ">Lo sentimos <%=SecurityContextHolder.getContext().getAuthentication().getName()%> No se tienen los permisos suficientes para ingresar a esta seccion.</h1>
        <h2 style="text-align:center ">Por Favor comunicate con el administrador del sistema, para que tu usuario sea configurado con acceso a este sitio.</h2>
                                  
			</div>
		</div>

    </body>
</html>
