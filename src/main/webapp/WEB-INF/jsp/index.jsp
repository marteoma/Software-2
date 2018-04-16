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
      <header>MR. CHEESE</header>
      <main class="content">
          <div class ="divlogin"
               <form method="post" action="main.jsp" id="login-form">
         
              <input type="text" placeholder="Usuario" class="campo"/>
              <input type ="password" placeholder="Contraseña" class="campo"/>
              <input type="submit"  value="INGRESAR" id ="btn-login"/>
          
        </form>
      </div>       
      </main>
    </div> 
  </body>
</html>
