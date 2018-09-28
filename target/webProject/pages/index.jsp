<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>待办管理系统</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>

    <!-- Latest compiled and minified Locales -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <style type="text/css">
        .myiframe {
            display: inline-block;
        }

        .container {
            margin-top: 50px;
        }
    </style>
    <script>
        $(function () {
            changeWH();
        });

        function changeWH() {

            // $("#myiframe").height($(".col-lg-9").height());
            $("#myiframe").width($(".col-lg-10").width());
        }

        window.onresize = function () {
            changeWH();

        };

        function changeSrc(url){
            $('iframe').attr('src',url)
        }
    </script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-2">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="#" onclick="changeSrc('/todoItemController?getList')">待办事项列表</a></li>
                <li role="presentation"><a href="#" onclick="changeSrc('/pages/infoMaintenance.jsp')">个人信息维护</a></li>
            </ul>
        </div>
        <div class="col-lg-10">
            <iframe src="/todoItemController?getList" frameborder="0"  id="myiframe" height="500"></iframe>
            <%--<iframe src="/todoItemController/toTodoList" frameborder="0"  id="myiframe" height="500"></iframe>--%>
        </div>
    </div>
</div>

</body>
</html>
