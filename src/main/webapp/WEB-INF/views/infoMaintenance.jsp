<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>待办管理系统</title>
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/static/js/JQuery.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <%--<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->--%>
    <script src="/static/js/bootstrap.min.js"></script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>

    <!-- Latest compiled and minified Locales -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <%--表单验证--%>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
    <style type="text/css">
        #form-div {
            /*display: none;*/
        }

    </style>
</head>
<body>
<script>
    $(function () {
        $.ajax({
            url: "/user/getUser",
            type: 'post',
            dataType: 'json',
            success: function (data, status) {
                $("#userName").val(data.userName);
                $("#age").val(data.age);
                $("#phoneNumber").val(data.phoneNumber);
                $("#comments").val(data.comments);
            },
            fail: function (err, status) {
                console.log(err)
            }
        })
    });

    $.validator.setDefaults({
        submitHandler: function (form) {
            form.submit();
        }
    });
    jQuery.validator.addMethod("isMobile", function (value, element) {
        var length = value.length;
        var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;
        return this.optional(element) || (length == 11 && mobile.test(value));
    }, "请正确填写您的手机号码");
    $().ready(function () {
        $(".form-horizontal").validate();
    });
</script>
<div id="form-div">
    <form class="form-horizontal" action="/user/update" method="post" style="width: 500px;">
        <div class="form-group">
            <label for="userName" class="col-sm-4 control-label">姓名：</label>
            <div class="col-sm-8">
                <input type="text" name="userName" class="form-control" id="userName" required>
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-4 control-label">年龄：</label>
            <div class="col-sm-8">
                <input type="text" name="age" class="form-control" id="age" min="1" max="200" required>
            </div>
        </div>
        <div class="form-group">
            <label for="phoneNumber" class="col-sm-4 control-label">手机号：</label>
            <div class="col-sm-8">
                <input type="text" name="phoneNumber" isMobile="true" class="form-control" id="phoneNumber" required>
            </div>
        </div>
        <div class="form-group">
            <label for="comments" class="col-sm-4 control-label">备注：</label>
            <div class="col-sm-8">
                <textarea name="comments" class="form-control" rows="3" id="comments" placeholder="备注"></textarea>
            </div>
        </div>
        <input type="hidden" value="0" name="userId">
        <div class="form-group">
            <label class="col-sm-4 control-label"> </label>
            <div class="col-sm-8">
                <button type="submit" class="btn btn-default">提交</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
