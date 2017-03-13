<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Edita Cliente</title>
        <link rel="stylesheet"  type="text/css" href="<c:url value='/css/common.css'/>">
        <%@include file="/WEB-INF/layout/bootstrapheader.jspf"%>
    </head>
    <body class="container">
         <%@include file="/WEB-INF/layout/header.jspf" %>
        <main class="row">
        <nav class="col-md-2">
            <h2>Opciones</h2>
            <ul class=" nav nav-pills nav-stacked">
                <li ><a href="listado" class="btn btn-default">Volver</a></li>
            </ul>
        </nav>        
            <section>
        <h1>Editar Cliente</h1>
        <form:form method="POST" modelAttribute="cliente" cssClass="well col-md-4">
            <h3>Cliente nº: ${cliente.id}</h3>
            <form:label path="nombre">Nombre: <form:input path="nombre" cssClass="form-control"/></form:label>
            <form:errors cssClass="label label-warning" path="nombre"/> <br>
        <form:label path="dni">DNI:<form:input path="dni" cssClass="form-control"/></form:label>
        <form:errors cssClass="label label-warning" path="dni"/><br>
        <form:label path="socio">Socio:<form:checkbox path="socio" cssClass="form-control"/></form:label><br>
        <form:label path="medioPago">Medio Pago:
            <form:select path="medioPago" cssClass="form-control">
                <c:forEach var="medio" items="${mediosPago}" varStatus="elemento">
                    <form:option value="${elemento.index}"  label="${medio}" />
                </c:forEach>    
            </form:select>
        </form:label>
        <p>
        <input name="enviar" type="Submit" value="Guardar">
        <input name="enviar" type="Reset" value="Limpiar">
        <a href="listado">Volver</a>
        </p>
        </form:form>
            </section>
        </main>
        
        <%@include file="/WEB-INF/layout/footer.jspf"%>
    </body>
</html>