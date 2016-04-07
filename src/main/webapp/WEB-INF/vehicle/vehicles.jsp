<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>

<body>
<div id="container" style="width: 80%">
    <div id="header" style="background-color: lightseagreen;">
        <span><h1>车辆列表</h1></span>
    </div>
    <table>
        <tr>
            <th>车辆名称</th>
            <th>所有者</th>
            <th>终端号</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${response.entity}" var="vehicle">
            <tr>
                <td><c:out value="${vehicle.name}"/></td>
                <td><c:out value="${vehicle.owner}"/></td>
                <td><c:out value="${vehicle.terminalId}"/></td>
                <td><a href="<c:url value="/vehicle/removeVehicle/${vehicle.name}"/>">删除</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
<p><a href="<c:url value="/vehicle/addVehicle"/>">添加一辆车</a></p>
</body>

</html>
