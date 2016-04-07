<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<body>
<div id="container" style="width: 80%">
    <div id="header" style="background-color: lightseagreen;">
        <span><h1>欢迎页面</h1></span>
    </div>
    <p>欢迎：<span style="text-align: right"><shiro:user>${user.name}(<a href="<c:url value="/logout"/>">logout</a>)</shiro:user>
    <shiro:guest>游客(<a href="<c:url value="/login"/>">login</a>)</shiro:guest></span></p>
    <shiro:user>
    <h2>服务列表</h2>
    <ul>
        <shiro:hasPermission name="gps"><li>gps实时跟踪服务</li></shiro:hasPermission>
        <shiro:hasPermission name="history"><li>历史数据服务</li></shiro:hasPermission>
    </ul>
        <p><a href="<c:url value="/vehicle/allVehicles"/>">车辆列表</a></p>
    </shiro:user>
</div>
</body>

</html>
