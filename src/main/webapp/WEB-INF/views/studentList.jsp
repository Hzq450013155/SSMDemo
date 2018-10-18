<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>ceshi</title>
    <script src="/static/js/JQuery.js" type="javascript"></script>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>sex</th>
        <th>age</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>

            <td>
                <c:if test="${item.sex == 0}">
                    男
                </c:if>
                <c:if test="${item.sex == 1}">
                    女
                </c:if>
            </td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>

    <form action="/studentController?insert" method="post">
        姓名：<input type="text" name="name">
        性别：男 <input type="radio" name="sex" value="0" checked> 女 <input type="radio" name="sex" value="1">
        年龄：<input type="text" name="age">
        <input type="submit" value="新增">
    </form>

</table>

</body>
</html>
