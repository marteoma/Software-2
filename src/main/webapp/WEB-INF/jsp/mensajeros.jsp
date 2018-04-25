<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="url" uri="http://www.springframework.org/tags/form" %>


<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Spring Web MVC project</title>
    <link rel="stylesheet" href="<c:url value="/src/css/main.css"/>">    
  </head>

  <body>
    <div class="container">
      <jsp:include page="/fragments/header.htm"></jsp:include>
      <jsp:include page="/fragments/nav.htm"></jsp:include>
      <main class="content">
          
      </main>      
    </div> 
  </body>
</html>
