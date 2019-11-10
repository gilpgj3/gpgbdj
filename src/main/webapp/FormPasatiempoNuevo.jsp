<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<c:set var="título" scope="request" value="Pasatiempo Nuevo" />
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${título}" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<form action="CtrlPasatiempoAgrega" method="post">
		<header>
			<a href="CtrlPasatiempos">Cancelar⁬⁬⁬</a>
			<button type="submit">Guardar</button>
			<h1>
				<c:out value="${título}" />
			</h1>
		</header>
		<p>
			<input name="nombre" type="text" placeholder="Nombre">
		</p>
		<%@include file="/WEB-INF/jspf/mi-footer.jspf"%>
	</form>
</body>
</html>
