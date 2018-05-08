<%-- 
    Document   : edit
    Created on : 25/04/2018, 01:01:43 AM
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
        <title>Edit</title>
        <link rel="stylesheet" href="<c:url value="/src/css/main.css"/>">  
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
      <jsp:include page="/fragments/header.htm"></jsp:include>
      <jsp:include page="/fragments/nav.htm"></jsp:include>
      <main class="content">
          <div class="panel panel-primary">
              <div class="panel-heading" v>Formulario de Ediccion de Pedidos</div>
              <div class="panel-body">
                  
                  <form:form method="post" commandName="Pedido">
                      
                      <p>
                      <form:label path="contenido">Contenido</form:label>
                      <form:input path="contenido" cssClass="form-control"></form:input>
                      </p>
                      
                      <p>
                      <form:label path="estado">Estado</form:label>
                      <form:input path="estado" cssClass="form-control"></form:input>
                      </p>
                      <p>
                      <form:label path="mensajero">Mensajero</form:label>
                      <form:input path="mensajero" cssClass="form-control"></form:input>
                      </p>
                      
                      <p>
                      <form:label path="cliente">Cliente</form:label>
                      <form:input path="cliente" cssClass="form-control"></form:input>
                      </p>
                      
                      <input type="submit" value="Editar" class="btn btn-danger"/>
                  </form:form>
              </div>
          </div>
               
      </main>   
    </body>
</html>
