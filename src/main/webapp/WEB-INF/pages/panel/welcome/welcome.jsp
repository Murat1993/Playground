<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>${appName}</title>
</head>
<body>
<%@include file="../../commons/head.jsp" %>
<div class="container">
    <div class="jumbotron">
        <div class="text-center">
            <h2 class="display-2 ">Добро пожаловать! ${appName}<span class="text-danger" style="font-size: 20;">
                &nbsp;&nbsp;Version:${appVersion }</span></h2>
            <p class="lead">Выберите функцию на панели навигации выше</p>
        </div>
    </div>
</div>

</body>
</html>
