<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>${post.message}</title>
</head>
<body>

<div class="container">
    <form action="<c:url value="/search"/>" method="get">
        <div class="form-group">
            <p><input type="text" name="query" placeholder="Crawl" required>
        </div>
        <input type="submit" value="Crawl" class="btn btn-default">
    </form>
</div>

</body>