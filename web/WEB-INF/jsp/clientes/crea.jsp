<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Alta Cliente</title>
        <link rel="stylesheet"  type="text/css" href="<c:url value='/css/common.css'/>">
    </head>
    <body>
        <h1>Alta Cliente</h1>
        <form:errors path="cliente.*" cssClass="error" element="div" />
        <form:form method="POST" modelAttribute="cliente" >
            <form:label path="nombre" >Nombre:</form:label><form:input path="nombre" />
                <form:errors cssClass="error" path="nombre"/> <br>
            <form:label path="dni">DNI:</form:label><form:input path="dni" />
                <form:errors cssClass="error" path="dni"/><br>
            <form:label path="socio">Socio:</form:label><form:checkbox path="socio"/><br>
            <input name="enviar" type="Submit" value="Guardar">
            <input name="enviar" type="reset" value="Limpiar">
            <a href="listado">Volver</a>
        </form:form>
    </body>
</html>