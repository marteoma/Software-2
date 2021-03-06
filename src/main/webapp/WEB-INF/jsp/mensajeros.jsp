<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="url" uri="http://www.springframework.org/tags/form" %>


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
                    <div style="background: #E6E6E6" id="btn-add">
                        <p style="background: ">
                            <a href="<c:url value="add.htm"/>" class="btn btn-success"><span class ="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar Mensajero</a>
                    </p>    
                </div>
                    <h1>MENSAJEROS ACTUALES</h1>
                    <table class="table table-bordered table-striped table-hover">
                        <thead class="thead-dark table">
                            <tr class="table-dark">
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Platillo</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${datos}" var="dato">
                                <tr class="bg-warning">
                                    <td><c:out value="${dato.id}"/></td>
                                    <td><c:out value="${dato.name}"/></td>
                                    <td><c:out value="${dato.lastname}"/></td>
                                    <td><c:out value="${dato.plate}"/></td>
                                    <td>
                                        <a href="<c:url value="editM.htm?id=${dato.id}&type=mensajero"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                        <a href="<c:url value="deleteM.htm?id=${dato.id}&type=mensajero"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table> 
                

            </main>       
        </div> 
    </body>
</html>
