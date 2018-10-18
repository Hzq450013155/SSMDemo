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
            display: none;
        }

    </style>
</head>
<body>
<script>
    var datas;
    $(function () {
        // $.ajax({
        //     url: "/todoItemController?getListJson",
        //     type: 'get',
        //     dataType: 'json',
        //     success: function (data, status) {
        //         datas = data;
        //         for (var i = 0; i < data.length; i++) {
        //             var cdate = new Date(data[i].creationDate);
        //             var udate = new Date(data[i].lastUpdateDate);
        //             $("#todoTable tbody").append("<tr>");
        //             $("#todoTable tbody").append("<td>" + (i + 1) + "</td>");
        //             $("#todoTable tbody").append("<td>" + data[i].userName + "</td>");
        //             $("#todoTable tbody").append("<td>" + data[i].todoItemTitle + "</td>");
        //             $("#todoTable tbody").append("<td>" + data[i].todoItemContent + "</td>");
        //             $("#todoTable tbody").append("<td>" + data[i].priority + "</td>");
        //             $("#todoTable tbody").append("<td>" + cdate.Format("yyyy-MM-dd HH:mm:ss") + "</td>");
        //             $("#todoTable tbody").append("<td>" + udate.Format("yyyy-MM-dd HH:mm:ss") + "</td>");
        //             $("#todoTable tbody").append("<td>" + data[i].comments + "</td>");
        //             $("#todoTable tbody").append("<td><button class=\"btn btn-default\" onclick=\"edit(" + i + ")\">修改</button><button class=\"btn btn-default\" onclick=\"del(" + data[i].todoItemId + ")\">删除</button></td>");
        //             $("#todoTable tbody").append("</tr>");
        //         }
        //         $("#todoTable tbody").trigger("create");
        //     },
        //     fail: function (err, status) {
        //         console.log(err)
        //     }
        // })
    });

    function add() {
        if ($("#form-div").css("display") == "none") {
            $("#form-div").show();
            $("#myform")[0].reset();
            $("#myform").attr('action', "/todoItemController?insert");
        } else {
            $("#form-div").hide();
        }
    }

    function edit(i) {
        $("#form-div").show();
        $("#myform")[0].reset();
        $("#myform").attr('action', "/todoItemController?update");
        $("#todoItemId").val(datas[i].todoItemId);
        $("#todoItemTitle").val(datas[i].todoItemTitle);
        $("#todoItemContent").val(datas[i].todoItemContent);
        if (datas[i].priority == "LOW") {
            $("#optionsRadios1").attr("checked", "checked");
        } else if (datas[i].priority == "HIGH") {
            $("#optionsRadios3").attr("checked", "checked");
        } else {
            $("#optionsRadios2").attr("checked", "checked");
        }
        $("#comments").val(datas[i].comments);
    }


    function closeDiv() {
        $("#form-div").hide();
    }

    function del(todoItemId) {
        if (confirm("确定删除吗？") == true) {
            $.ajax({
                url: "/todoItemController?delete",
                type: 'post',
                data: {
                    todoItemId: todoItemId
                },
                dataType: 'json',
                success: function (data, status) {
                    if (data == 1) {
                        alert("删除成功")
                    } else {
                        alert("删除失败")
                    }
                    reloadPage();
                },
                fail: function (err, status) {
                    console.log(err)
                }
            })
        } else {
            return false;
        }


    }

    $.validator.setDefaults({
        submitHandler: function (form) {
            form.submit();
        }
    });

    $().ready(function () {
        $(".form-horizontal").validate();
    });

</script>
<button class="btn btn-default" onclick="add()">新增</button>
<%--<button class="btn btn-default" onclick="edit()">修改</button>--%>
<%--<button class="btn btn-default" onclick="del()">删除</button>--%>
<div id="form-div">
    <form id="myform" class="form-horizontal" action="/todoItemController?insert" method="post" style="width: 500px;">
        <input type="hidden" name="todoItemId" id="todoItemId">
        <div class="form-group">
            <label for="todoItemTitle" class="col-sm-4 control-label">待办事项标题：</label>
            <div class="col-sm-8">
                <input type="text" name="todoItemTitle" class="form-control" id="todoItemTitle" required
                       placeholder="标题">
            </div>
        </div>
        <div class="form-group">
            <label for="todoItemContent" class="col-sm-4 control-label">待办事项内容：</label>
            <div class="col-sm-8">
                <input type="text" name="todoItemContent" class="form-control" id="todoItemContent" required
                       placeholder="内容">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-4 control-label">优先级：</label>
            <div class="col-sm-8">
                <label class="radio-inline">
                    <input type="radio" name="priority" id="optionsRadios1" value="LOW" checked required> LOW
                </label>
                <label class="radio-inline">
                    <input type="radio" name="priority" id="optionsRadios2" value="MEDIUM"> MEDIUM
                </label>
                <label class="radio-inline">
                    <input type="radio" name="priority" id="optionsRadios3" value="HIGH"> HIGH
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="comments" class="col-sm-4 control-label">备注：</label>
            <div class="col-sm-8">
                <textarea name="comments" class="form-control" rows="3" id="comments" placeholder="备注"></textarea>
            </div>
        </div>
        <input type="hidden" value="0" name="todoItemId">
        <input type="hidden" value="0" name="userId">
        <div class="form-group">
            <label class="col-sm-4 control-label"> </label>
            <div class="col-sm-8">
                <button type="submit" class="btn btn-default">提交</button>
                <span style="width: 20px;"></span>
                <button type="button" class="btn btn-default" onclick="closeDiv()">关闭</button>
            </div>
        </div>
    </form>
</div>

<table id="todoTable" class="table table-striped table-bordered table-condensed table-hover">
    <h3>待办事项</h3>
    <thead>
    <tr>
        <%--<th>选择</th>--%>
        <th>序号</th>
        <th>属主用户</th>
        <th>代办事项标题</th>
        <th>待办事项内容</th>
        <th>优先级</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>备注</th>
        <%--<th>操作</th>--%>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="item" varStatus="c">
        <tr>
                <%--<td><input type="checkbox" name="todoItemId" value="${item.todoItemId}"/></td>--%>
            <td style="display: none;">${item.todoItemId}</td>
            <td style="display: none;">${item.userId}</td>
            <td>${c.count}</td>
            <td>${item.userName}</td>
            <td>${item.todoItemTitle}</td>
            <td>${item.todoItemContent}</td>
            <td>${item.priority}</td>
            <td><fmt:formatDate value="${item.creationDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${item.lastUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${item.comments}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--<nav aria-label="Page navigation">--%>
<%--<ul class="pagination">--%>
<%--<li>--%>
<%--<a href="#" aria-label="Previous">--%>
<%--<span aria-hidden="true">&laquo;</span>--%>
<%--</a>--%>
<%--</li>--%>
<%--<li class="active"><a href="#">1</a></li>--%>
<%--<li><a href="#">2</a></li>--%>
<%--<li><a href="#">3</a></li>--%>
<%--<li><a href="#">4</a></li>--%>
<%--<li><a href="#">5</a></li>--%>
<%--<li>--%>
<%--<a href="#" aria-label="Next">--%>
<%--<span aria-hidden="true">&raquo;</span>--%>
<%--</a>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</nav>--%>
<script>
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "H+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    };

    function reloadPage() {
        window.location.reload()
    }
</script>
</body>
</html>
