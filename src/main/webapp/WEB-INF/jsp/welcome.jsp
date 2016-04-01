<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<body>
<div id="container" style="width: 80%">
    <div id="header" style="background-color: lightseagreen;">
        <span><h1>欢迎页面</h1></span>
    </div>
    普通用户：<span style="text-align: right">${user.name}</span>
</div>
</body>

</html>
