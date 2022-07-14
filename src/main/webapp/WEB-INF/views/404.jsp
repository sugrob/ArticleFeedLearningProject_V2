<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <META http-equiv="Content-Language" content="ru">
    <title>Feed::view</title>
</head>
<body>
<h1>Don't know about article with ID ${id}</h1>
<div>
    But.. feel free to browse <a href="${pageContext.request.contextPath}/feed">feed</a>, or&nbsp;&nbsp;
    <a href="${pageContext.request.contextPath}/create">create</a> new article.
</div>
</body>
</html>