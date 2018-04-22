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
      <table class="table table-bordered table-striped table-hover">
          <thead>
              <tr>
                  <th>Contenido</th>
                  <th>Estado</th>
                  <th>ID</th>
                  <th>Mensajero</th>
                  <th>Cliente</th>
              </tr>
          </thead>
          <tbody>
          <c:forEach items="${datos}" var="dato">
              <tr>
                  <td><c:out value="${dato.contenido}"/></td>
                  <td><c:out value="${dato.estado}"/></td>
                  <td><c:out value="${dato.id_pedido}"/></td>
                  <td><c:out value="${dato.mensajero}"/></td>
                  <td><c:out value="${dato.cliente}"/></td>
              </tr>
          </c:forEach>
          </tbody>
      </table>     
      </main>   
      
      
    </div> 
  </body>
</html>