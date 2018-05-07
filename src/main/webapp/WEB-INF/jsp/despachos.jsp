<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="url" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link rel="stylesheet" href="<c:url value="/src/css/main.css"/>">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>

    <body>
        <div class="container">
            <jsp:include page="/fragments/header.htm"></jsp:include>
            <jsp:include page="/fragments/nav.htm"></jsp:include>
                <main class="content">
               
                    <div>
                        <h1>Pedidos sin Asignacion</h1>
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Contenido</th>
                                    <th>Estado</th>
                                    <th>ID</th>
                                    <th>Mensajero</th>
                                    <th>Cliente</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pedidos}" var="dato">
                                <tr>
                                    <td><c:out value="${dato.contenido}"/></td>
                                    <td><c:out value="${dato.estado}"/></td>
                                    <td><c:out value="${dato.id_pedido}"/></td>
                                    <td><c:out value="${dato.mensajero}"/></td>
                                    <td><c:out value="${dato.cliente}"/></td>
                                    <td>
                                        <button  onclick=""><span class="glyphicon glyphicon-ok" aria-hidden="false"></span></button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table> 
                </div>

                <div>
                    <h1>Mensajeros</h1>
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Platillo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${mensajeros}" var="dato">
                                <tr>
                                    <td><c:out value="${dato.id_mensajero}"/></td>
                                    <td><c:out value="${dato.nombre_mensajero}"/></td>
                                    <td><c:out value="${dato.apellido}"/></td>
                                    <td><c:out value="${dato.placa}"/></td>
                                    <td>
                                        <button  onclick="${despachoController.setMensajero(dato.nombre_mensajero)}"><span class="glyphicon glyphicon-ok" aria-hidden="false"></span></button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                     <form:form method="post" commandName="Pedido">
                    <input type="submit" value="Despachar" class="btn btn-danger"/>   
                    </form:form>
                    
                
            </main>      
        </div> 
    </body>
</html>
