<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <META http-equiv="Content-Language" content="ru">
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/feed.css" rel="stylesheet"/>
    <title>Feed::view</title>
</head>
<body>
    <div id="feed" class="content">
        <h1>Feed::view</h1>
        <div class="hint">*HINT: There are ${FEED_PAGE_LIMIT} items per page, so... you must add at least ${FEED_PAGE_LIMIT+1} items to see pagination :-)</div>
        <a href="${pageContext.request.contextPath}/create">Add new one</a>

        <c:forEach var="article" items="${list}">
            <div class="item">
                <div class="info"><b>#${article.id}</b>, created time:<fmt:formatDate value="${article.createdTime}" pattern="yyyy-MM-dd HH:mm"/></div>
                <div class="title">${article.title}</div>
                <div class="text">${article.content}</div>
                <div>
                    <a href="${pageContext.request.contextPath}/edit/${article.id}">Edit</a>&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/delete/${article.id}">Delete</a>
                </div>
            </div>
        </c:forEach>

        <c:if test = "${totalPages > 1}">
        <div class="pages">
            <c:forEach var = "i" begin = "1" end = "${totalPages}">
                <a href="${pageContext.request.contextPath}/feed/${i}">${i}</a>
            </c:forEach>
        </div>
        </c:if>
    </div>
</body>
</html>