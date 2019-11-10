<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="titulo" scope="request" value="Error" />
<html>
<head>
<meta charset="UTF-8">
<title>${titulo}</title>
</head>
<body>
	<h1>${titulo}</h1>
	<p><c:out value="${requestScope.error}"/></p>
	<p>
		<button type="button" onclick="history.back()">Aceptar</button>
	</p>
</body>
</html>