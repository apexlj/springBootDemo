<%--
  Created by IntelliJ IDEA.
  User: sq
  Date: 2016/3/30
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/main.css"/>"/>
    <script type="text/javascript" src="<c:url value="/static/js/lib/jquery-1.9.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/static/js/main.js"/>"></script>
    <title>登陆</title>
</head>

<body>
<div id="container" style="width: 80%">
    <div id="header" style="background-color: lightseagreen;">
        <span><h1>登陆页面</h1></span>
    </div>
    <div id="error" class="errorClass"><c:out value="${error}"/></div>
    <div id="login-form" style="background-color: beige; width: 40%;text-align: center">
        <form:form action="login" modelAttribute="userInfo">
            <table>
                <tr>
                    <td>用户名: </td>
                    <td>
                        <form:errors path="name" cssClass="errorClass"/>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>密码: </td>
                    <td>
                        <form:errors path="password" cssClass="errorClass"/>
                        <form:password path="password"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" name="提交"></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
</body>

</html>

