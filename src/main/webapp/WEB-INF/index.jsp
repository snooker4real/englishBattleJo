<%--
  Created by IntelliJ IDEA.
  User: cindanojonathan
  Date: 08/08/2021
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>English Battle</title>

</head>
<body>
    <h1>English Batlle G19</h1>
    <c:if test="${erreur ne null}"><h2>${erreur}</h2></c:if>
    <form action="connexion" method="post">
        <!-- The action connexion is going to refer to the ConnexionServlet into the doPost method -->
        <input type="text" name="EMAIL" placeholder="Email"><br>
        <input type="password" name="MOT_DE_PASSE" placeholder="Mot de Passe"><br>
        <input type="submit" value="Connexion"><br>
    </form>
    <br>
    <h1>Hall of Fame</h1>
</body>
</html>
