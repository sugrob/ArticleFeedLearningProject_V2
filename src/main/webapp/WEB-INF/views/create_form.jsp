<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html; charset=utf-8">
    <META http-equiv="Content-Language" content="ru">
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/form.css" rel="stylesheet"/>
    <title>Feed::create</title>
</head>
<body>
    <div class="content">
        <h1>Feed::create</h1>
        <form:form method="post" action="${pageContext.request.contextPath}/save" modelAttribute="article">
            <form:hidden  path="id" />

            <div class="field">
                <label>Title:</label>
                <form:input path="title" />
                <form:errors path="title" cssClass="error" />
            </div>

            <div class="field">
                <label>Content:</label>
                <form:textarea path="content" />
               <form:errors path="content" cssClass="error" />
            </div>

            <input type="submit" value="Add new" />
        </form:form>
    </div>
</body>
</html>
