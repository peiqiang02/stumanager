<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>学生成绩</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
    <style>
        .main {
            padding: 20px;
            margin-top: 0;
        }

        @media (min-width: 768px) {
            .main {
                padding-right: 25px;
                padding-left: 25px;
            }
        }

        h2 {
            margin-top: 10px;
        }
    </style>
</head>

<body>
    <div class="main">
        <div class="panel panel-default" style="margin-bottom: 10px;">
            <div class="panel-heading" style="display: flex;align-items: center;">
                <h2 id="curName" style="margin-right: 20px ;display:inline-block;">软件体系结构</h2>
                <h2 id="stuName" style="margin-right: 20px ;display:inline-block;">李捷</h2>
                <div class="btn-group" role="group" style="display: flex;flex-grow: 1;justify-content: flex-end;">
                    <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..." type="button" style="margin-right: 20px">提 交</button>
                </div>
            </div>
            <div class="panel-body form-group" style="margin-bottom:0;">
                <h2 class="page-header" style="margin-top: 0; margin-bottom: 10px;">学生成绩</h2>
                <div class="form-group">
                    <div class="form-inline">
                        <label for="examScore">考试成绩</label>
                        <input title="成绩为100分制" type="text" class="form-control" id="examScore" placeholder="请输入考试成绩" oninput="if(value.length>=3)value=value.slice(0,3)"
                            style="margin-right: 20px">
                        <label for="taskScore">作业成绩</label>
                        <input title="成绩为100分制" type="text" class="form-control" id="taskScore" placeholder="请输入作业成绩" oninput="if(value.length>=3)value=value.slice(0,3)"
                            style="margin-right: 20px">
                        <label for="nomalScore">平时成绩</label>
                        <input title="成绩为100分制" type="text" class="form-control" id="nomalScore" placeholder="请输入平时成绩" oninput="if(value.length>=3)value=value.slice(0,3)"
                            style="margin-right: 20px">
                        <label for="totalScore">总评成绩</label>
                        <input title="成绩为100分制" type="text" class="form-control" id="totalScore" placeholder="请输入总评成绩" oninput="if(value.length>=3)value=value.slice(0,3)">
                    </div>
                </div>

            </div>
        </div>

        <div class="table-responsive">
            <table id="myTable" class="table table-bordered table-striped">
            </table>
        </div>

    </div>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript">

        //生成表格
        $('#myTable').bootstrapTable({
            method: 'post',
            contentType: "application/x-www-form-urlencoded",//必须要有！！！！
            url: "loadTaskGrade",//要请求数据的文件路径
            striped: true, //是否显示行间隔色
            pagination: true,//是否分页
            queryParamsType: 'limit',//查询参数组织方式
            queryParams: queryParams,//请求服务器时所传的参数
            dataField: "list",
            sidePagination: 'server',//指定服务器端分页
            pageSize: 10,//单页记录数
            pageList: [5, 10, 20, 30],//分页步进值
            showRefresh: true,//刷新按钮
            showColumns: true,
            clickToSelect: true,//是否启用点击选中行
            columns: [{
                field: 'taskId',
                title: '作业序号'
            }, {
                field: 'curName',
                title: '课程名'
            }, {
                field: 'stuId',
                title: '学号'
            }, {
                field: 'stuName',
                title: '姓名'
            }, {
                title: '成绩',
                field: 'taskScore',
            }],
            locale: 'zh-CN',//中文支持,
            responseHandler: function (res) {
                return {
                    total: res.data.rowsTotal,
                    list: res.data.list
                };
            }
        });

        //请求服务数据时所传参数
        function queryParams(params) {
            return {
                pageLimit: params.limit,
                pageIndex: params.offset / params.limit + 1,
                curId: sessionStorage.getItem('curId'),
                stuId: getUrlParam('stuId') 
            }
        }

        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");//构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);//匹配目标参数
            if (r != null) return unescape(r[2]); return null;//返回参数值
        }
        $(function () {
            var studentId = getUrlParam('stuId');
            $.ajax({//获取选课表里的学生信息
                type: "POST",
                url: "/SC/loadSCByStuIdandCurId",
                dataType: "json",
                data: {
                     curId: sessionStorage.getItem('curId'), 
                     stuId: studentId 
                     },
                success: function (text) {
                    if (text.code !== 0) {
                        alert(text.msg);
                        return;
                    }
                    $('#curName').text(text.data.curName);
                    $('#stuName').text(text.data.stuName);

                    sessionStorage.setItem("scId",text.data.id);
                }
            });
        });

        $("#fat-btn").click(function () {
            var studentId = getUrlParam('stuId');
            var examScore = $("#examScore").val();
            var taskScore = $("#taskScore").val();
            var nomalScore = $("#nomalScore").val();
            var totalScore = $("#totalScore").val();
            $.ajax({//提交学生成绩
                type: "POST",
                url: "/SC/updateGrades",
                dataType: "json",
                data: { 
                    scId: sessionStorage.getItem('scId'), 
                    examScore: examScore, 
                    taskScore: taskScore, 
                    nomalScore: nomalScore, 
                    totalScore: totalScore 
                    },
                success: function (text) {
                    if (text.code !== 0) {
                        alert(text.msg);
                        return;
                    }
                }
            });

        });

    </script>
</body>

</html>