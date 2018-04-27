<%-- 
    Document   : add
    Created on : 26/04/2018, 01:07:45 PM
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
        <title>JSP Page</title>
        <link rel="stylesheet" href="<c:url value="/src/css/main.css"/>">  
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
      <jsp:include page="/fragments/header.htm"></jsp:include>
      <jsp:include page="/fragments/nav.htm"></jsp:include>
      <main class="content">
          <div class="panel panel-primary">
              <div class="panel-heading" v>Formulario de Creacion</div>
              <div class="panel-body">
                  
                  <form:form method="post" commandName="Mensajero">
                      
                   
                      <p>
                      <form:label path="nombre_mensajero">Nombre</form:label>
                      <form:input path="nombre_mensajero" cssClass="form-control"></form:input>
                      </p>
                      <p>
                      <form:label path="apellido">Apellido</form:label>
                      <form:input path="apellido" cssClass="form-control"></form:input>
                      </p>
                      
                      <p>
                      <form:label path="placa">Placa</form:label>
                      <form:input path="placa" cssClass="form-control"></form:input>
                      </p>
                      
                      <input type="submit" value="Agregar" class="btn btn-danger"/>
                  </form:form>
              </div>   
          </div>
    </body>
</html>
