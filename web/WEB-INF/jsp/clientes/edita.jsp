<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Edita Cliente</title>
        <link rel="stylesheet"  type="text/css" href="<c:url value='/css/common.css'/>">
    </head>
    <body>
         <%@include file="/WEB-INF/layout/header.jspf" %>
        <h1>Editar Cliente</h1>
        <form:form method="POST" modelAttribute="cliente">
        Cliente nº: ${cliente.id}<br>
        <form:label path="nombre">Nombre: <form:input path="nombre" /></form:label>
            <form:errors cssClass="error" path="nombre"/> <br>
        <form:label path="dni">DNI:<form:input path="dni" /></form:label>
        <form:errors cssClass="error" path="dni"/><br>
        <form:label path="socio">Socio:<form:checkbox path="socio"/></form:label><br>
        <input name="enviar" type="Submit" value="Guardar">
        <input name="enviar" type="Reset" value="Limpiar">
        <a href="listado">Volver</a>
        </form:form>
        <%@include file="/WEB-INF/layout/footer.jspf"%>
    </body>
</html>