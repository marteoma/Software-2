<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link rel="stylesheet" href="<c:url value="/src/css/main.css"/>">
        <link rel="stylesheet" href="<c:url value="/src/css/chat.css"/>">

        <script src="https://www.gstatic.com/firebasejs/4.13.0/firebase.js"></script>
        <script src="https://www.gstatic.com/firebasejs/4.10.1/firebase-app.js"></script>
        <script src="https://www.gstatic.com/firebasejs/4.10.1/firebase-database.js"></script>        
    </head>

    <body>
        <div class="container">
            <jsp:include page="/fragments/header.htm"/>
            <jsp:include page="/fragments/nav.htm"/>
            <main class="content" id="content">               
                <div class="destinatarios">
                    <div class="group">
                        <h2>Clientes</h2>
                        <c:forEach items="${clientes}" var="c">
                            <div class="destinario">
                                <c:out value="${c.nombre_cliente}"></c:out>
                                <c:out value=" "></c:out>
                                <c:out value="${c.apellido}"></c:out>
                                </div>
                        </c:forEach>
                    </div>
                    <div class="group">
                        <h2>Mensajeros</h2>
                        <c:forEach items="${mensajeros}" var="c">
                            <div onclick="openChat(event, ${c.id_mensajero})" class="destinario">
                                <c:out value="${c.nombre_mensajero}"></c:out>
                                <c:out value=" "></c:out>
                                <c:out value="${c.apellido}"></c:out>                                
                                </div>
                        </c:forEach>
                    </div>
                </div>                                   
            </main>
        </div>
        <script src="<c:url value="/src/js/chat.js"/>"></script>            
    </body>
</html>
