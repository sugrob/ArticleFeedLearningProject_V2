<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <META http-equiv="Content-Language" content="ru">
    <title>Feed::view</title>
</head>
<body>
    <h1>Feed::view</h1>
    <a href="${pageContext.request.contextPath}/create">Add new one</a>
    <br>
    <c:forEach var="article" items="${list}">
        <div>
            <div><b>#${article.id}</b>, created time:<fmt:formatDate value="${article.createdTime}" pattern="yyyy-MM-dd HH:mm"/></div>
            <div><b>${article.title}</b></div>
            <div>${article.content}</div>
            <div>
                <a href="${pageContext.request.contextPath}/edit/${article.id}">Edit</a>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/delete/${article.id}">Delete</a>
            </div>
        </div>
    </c:forEach>

    <c:if test = "${totalPages > 1}">
    <div id="pages">
        <c:forEach var = "i" begin = "1" end = "${totalPages}">
            <a href="${pageContext.request.contextPath}/feed/${i}">${i}</a>
        </c:forEach>
    </div>
    </c:if>
</body>
</html>