<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>JNoteboard</title>
</head>
<body>
<f:view>
	<h:form>
		<span>Note:</span>
		<h:inputText value="#{noteController.note.text}" />
		<br/><br/>
		<h:commandButton value="Adicionar" actionListener="#{noteController.addAction}" />
	</h:form>
	
	<h:dataTable var="note" value="#{noteController.notes}" border="1" width="100%">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Text"/>
			</f:facet>
			<h:outputText value="#{note.text}" />
		</h:column>
	</h:dataTable>
</f:view>
</body>
</html>