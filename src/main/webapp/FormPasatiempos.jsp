<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="título" scope="request" value="Pasatiempos" />
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${título}" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<header>
		<a href="FormPasatiempoNuevo.jsp">Agregar⁬⁬&hellip;</a>
		<h1>
			<c:out value="${título}" />
		</h1>
	</header>
	<ul>
		<c:forEach var="it" items="${requestScope.lista}">
			<li><c:url var="url" value="CtrlPasatiempoBusca">
					<c:param name="id" value="${it.id}" />
				</c:url> <a href="${url}"><c:out value="${it.nombre}" /></a></li>
		</c:forEach>
	</ul>
	<%@include file="/WEB-INF/jspf/mi-footer.jspf"%>
</body>
</html>
