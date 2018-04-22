<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
        <link rel="stylesheet" href="<c:url value="/src/css/main.css"/>">
    </head>

    <body>
        <div class="container">
            <jsp:include page="/fragments/header.htm" />                            
            <main class="content">
                <div>
                    <form:form method="post" commandName="admin">
                        <form:errors path="*" element="div"/>
                        <form:input path="email"/>
                        <form:input path="password" type="password"/>
                        <form:button id="admin-submit">Enviar</form:button>
                    </form:form>
                </div>       
            </main>
        </div> 
    </body>
</html>
