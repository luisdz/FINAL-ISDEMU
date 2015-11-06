<%-- 
    Document   : protected
    Created on : 08-25-2015, 08:30:47 PM
    Author     : Jose Eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>Welcome : ${pageContext.request.userPrincipal.name} 
                 | <a href="<c:url value="/logout" />" > Logout</a></h2>  
	</c:if>
    </body>
</html>
