<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Visualiza Cliente </title>
        <link rel="stylesheet"  type="text/css" href="<c:url value='/css/common.css'/>">        
    </head>
    <body>
        <%@include file="/WEB-INF/layout/header.jspf" %>
        <h1>Datos Cliente ${id}</h1>
        ID: ${cliente.id}<br>
        Nombre: ${cliente.nombre}<br>
        DNI:${cliente.dni}<br>
        Socio: ${cliente.socio?"Sí":"No"}<br>
        Socio: ${mediosPago[cliente.medioPago]}<br>
        <p><a href='${srvUrl}/edita?id=${cliente.id}'>Editar</a>&nbsp;
            <a href='${srvUrl}'>Volver</a></p>
        <%@include file="/WEB-INF/layout/footer.jspf"%>
    </body>
</html>

