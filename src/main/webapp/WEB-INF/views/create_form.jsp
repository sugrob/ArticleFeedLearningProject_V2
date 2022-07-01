<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <META http-equiv="Content-Language" content="ru">
    <title>Feed::edit</title>
</head>
<body>
<h1>Feed::edit</h1>
<form:form method="post" action="${pageContext.request.contextPath}/save" modelAttribute="article">
    <form:hidden  path="id" />
    <label>Title:</label>
    <div><form:input path="title" /></div>
    <div><form:errors path="title" cssClass="error" /></div>

    <label>Content:</label>
    <div><form:textarea path="content" /></div>
    <div><form:errors path="content" cssClass="error" /></div>

    <input type="submit" value="Add new" />
</form:form>
</body>
</html>
