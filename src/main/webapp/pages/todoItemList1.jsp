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
        <th>代办事项标题</th>
        <th>待办事项内容</th>
        <th>优先级</th>
        <th>创建时间</th>
        <th>更新时间</th>
        <th>备注</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="item" varStatus="c">
        <tr>
            <td style="display: none;">${item.todoItemId}</td>
            <td style="display: none;">${item.userId}</td>
            <td>${c.count}</td>
            <td>${item.todoItemTitle}</td>
            <td>${item.todoItemContent}</td>
            <td>${item.priority}</td>
            <td>${item.creationDate}</td>
            <td>${item.lastUpdateDate}</td>
            <td>${item.comments}</td>
            <td>
                <button class="btn btn-default" onclick="edit(${item})">修改</button>
                <button class="btn btn-default" onclick="del(${item.todoItemId})">删除</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="row">
    <div class="col-md-6">
        当前第${page.pageNum}页 共${page.pages}页 共${page.total}条记录
    </div>
    <div class="col-md-6">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.hasPreviousPage}">
                    <li><a href="/todoItemController?getList&pn=1">首页</a></li>
                    <li>
                        <a href="/todoItemController?getList&pn=${page.pageNum-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach items="${page.navigatepageNums}" var="pageNum">
                    <c:if test="${page.pageNum==pageNum}">
                        <li class="active"><a href="#">${pageNum}</a></li>
                    </c:if>
                    <c:if test="${page.pageNum!=pageNum}">
                        <li><a href="/todoItemController?getList&pn=${pageNum}">${pageNum}</a></li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.hasNextPage}">
                    <li>
                        <a href="/todoItemController?getList&pn=${page.pageNum+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:if>
                <li><a href="/todoItemController?getList&pn=${page.pages}">末页</a></li>
            </ul>
        </nav>
    </div>
</div>

</body>
</html>
