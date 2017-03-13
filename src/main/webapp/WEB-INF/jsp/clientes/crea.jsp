<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Alta Cliente</title>
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
        <section class="col-md-4">
        <h1>Alta Cliente</h1>
        <form:errors path="cliente.*" cssClass="error" element="div" />
        <form:form method="POST" class="well" modelAttribute="cliente" >
            <form:label path="nombre" >Nombre:<form:input class='form-control' path="nombre" /></form:label>
            <form:errors cssClass="label label-warning" path="nombre"/> <br>
            <form:label path="dni">DNI:<form:input class='form-control' path="dni" /></form:label>
            <form:errors cssClass="label label-warning" path="dni"/><br>
            <form:label path="socio">Socio:<form:checkbox class='form-control' path="socio"/></form:label><br>
            <form:label path="medioPago">Medio Pago
            <form:select path="medioPago" class="form-control">
                <c:forEach var="medio" items="${mediosPago}" varStatus="elemento">
                    <form:option value="${elemento.index}"  label="${medio}" />
                </c:forEach>    
            </form:select>
            </form:label>
            <p>            
                <input name="enviar" type="Submit" value="Guardar" class="btn btn-primary">
                <input name="enviar" type="reset" value="Limpiar" class="btn btn-default">
                <a href="listado">Volver</a>
            </p>
        </form:form>
            </section>
                </main>
        <%@include file="/WEB-INF/layout/footer.jspf"%>
    </body>
</html>