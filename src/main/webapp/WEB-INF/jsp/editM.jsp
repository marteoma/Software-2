<%-- 
    Document   : editM
    Created on : 26/04/2018, 03:35:24 PM
    Author     : Carlos Asprilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="url" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Mensajero</title>
        <link rel="stylesheet" href="<c:url value="/src/css/main.css"/>">  
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
            <jsp:include page="/fragments/header.htm"></jsp:include>
            <jsp:include page="/fragments/nav.htm"></jsp:include>
                <main class="content">
                    <div class="panel panel-primary">
                        <div class="panel-heading" v>Formulario de Edicion de Mensajeros</div>
                        <div class="panel-body">

                        <form:form method="post" commandName="Mensajero">

                            <p>
                                <form:label path="name">Nombre</form:label>
                                <form:input path="name" cssClass="form-control" required="required"  title="Solo letras ,Tamaño máximo: 50 caracteres"></form:input>
                                </p>
                                <p>
                                <form:label path="lastname">Apellido</form:label>
                                <form:input path="lastname" cssClass="form-control" required="required"  title="Solo letras ,Tamaño máximo: 50 caracteres"></form:input>
                                </p>

                                <p>
                                <form:label path="plate">Placa</form:label>
                                <form:input path="plate" cssClass="form-control" required="required" title="Tamaño máximo:10 caracteres"></form:input>
                                </p>

                                <input type="submit" value="Editar" class="btn btn-danger"/>
                        </form:form>
                    </div>   
                </div>
            </main>
    </body>
</html>
