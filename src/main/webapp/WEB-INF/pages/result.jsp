<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Result</title>
</head>
<body>
  <div class="container">
    <c:forEach var="pair" items="${result}">
        <h5>title: ${pair.key}</h5>
        <h5>site: ${pair.value}</h5>
    </c:forEach>
  </div>
</body>