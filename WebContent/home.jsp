<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="./resources/css/style.css" rel="stylesheet" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JNoteboard</title>
</head>
<body>
<f:view>
	<h:form styleClass="add-box">
		<h:inputTextarea value="#{noteController.note.text}" />
		<h:commandButton value="Adicionar" actionListener="#{noteController.addAction}" styleClass="button" />
	</h:form>

	<c:forEach var="note" items="${noteController.notes}">
		<div class='note'>
			<div class='header'>
				<div class='bt-close icon'></div>
			</div>
			<span>
				<c:out value="${note.text}"/>
			</span>
		</div>
	</c:forEach>
</f:view>
</body>
</html>