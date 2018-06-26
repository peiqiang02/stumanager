<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>课程主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
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
            <h2 id="curName" style="margin-right: 20px ;display:inline-block;">oracle 数据库</h2>
            <h2 id="teaName" style="margin-right: 20px ;display:inline-block;">朱勇</h2>
            <h2 style="display:inline-block;">副教授</h2>
        </div>
        <div class="panel-body form-group" style="margin-bottom:0;">
            <h2 class="page-header" style="margin-top: 0; margin-bottom: 10px;">课程简介</h2>
            <p id="info" style="text-indent:2em;">
                <font size="4">
                    软件体系结构是具有一定形式的结构化元素，即构件的集合，包括处理构件、数据构件和连接构件。
                    处理构件负责对数据进行加工， 数据构件是被加工的信息，连接构件把体系结构的不同部分组合连接起来。
                    这一定义注重区分处理构件、数据构件和连接构件，这一方法在其他的定义和方法中基本上得到保持。
                </font>
            </p>

        </div>
    </div>

    <div style="display: flex;flex-grow: 1;justify-content: flex-end;">
        <button id="btn_add" type="button" class="btn btn-default" style="border-radius: 0;" data-toggle="modal" data-target="#stuModal">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
    </div>

    <div class="table-responsive">
        <table id="myTable" class="table table-bordered table-striped">
        </table>
    </div>

</div>

<!--模态框-->
<div class="modal fade" id="stuModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加学生
                </h4>
            </div>
            <form class="modal-body" role="form">
                <div class="form-group form-inline">
                    <label for="stuId">学生学号</label>
                    <input style="margin-right: 20px" title="学生学号" type="number" class="form-control" id="stuId" placeholder="请输入学生学号">
                    <label for="stuName">学生姓名</label>
                    <input title="学生姓名不超过10字" type="text" class="form-control" id="stuName" placeholder="请输入学生姓名">
                </div>
                <div class="form-group form-inline">
                    <label for="stuAge">学生年龄</label>
                    <input style="margin-right: 20px" title="学生年龄不超过100" type="number" class="form-control" id="stuAge" placeholder="请输入学生年龄">
                    <label for="stuSex">性　别　</label>
                    <select  id="stuSex" class="form-control" title="请选择性别">
                        <option></option>
                        <option>男</option>
                        <option>女</option>
                    </select>
                </div>
                <div class="form-group form-inline">
                    <label for="stuMajor">学生专业</label>
                    <input style="margin-right: 20px" title="学生专业不超过20字" type="text" class="form-control" id="stuMajor" placeholder="请输入学生专业">
                    <label for="stuClass">学生班级</label>
                    <input title="学生班级不超过10字" type="text" class="form-control" id="stuClass" placeholder="请输入学生姓名">
                </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addStu(this)">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

    $('#myTable').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        url:"/SC/loadStudentByCurId",//要请求数据的文件路径
        striped: true, //是否显示行间隔色
        pagination:true,//是否分页
        queryParamsType:'limit',//查询参数组织方式
        queryParams:queryParams,//请求服务器时所传的参数
        dataField: "data",
        sidePagination:'server',//指定服务器端分页
        pageSize:10,//单页记录数
        pageList:[5,10,20,30],//分页步进值
        showRefresh:true,//刷新按钮
        showColumns:true,
        clickToSelect: true,//是否启用点击选中行
        onDblClickRow: function (row) {
            //alert(row.stuId);
            window.location.href='courseGrades.html?stuId='+row.stuId+''
            //console.log("click:" + row.playerName)
        },
        columns: [{
            field: 'stuId',
            title: '学号'
        }, {
            field: 'stuAge',
            title: '年龄'
        }, {
            field: 'stuName',
            title: '姓名'
        }, {
            field: 'stuSex',
            title: '性别'
        }, {
            field: 'stuMajor',
            title: '专业'
        }, {
            field: 'stuClass',
            title: '班级'
        }],
        locale:'zh-CN',//中文支持,
        responseHandler:function(list){
            return {
                total: list.data.rowsTotal,
                data : list.data.list
            }
        }
    });

    //请求服务数据时所传参数
    function queryParams(params){
        return{
            //每页多少条数据
            pageLimit: params.limit,
            //请求第几页
            pageIndex: params.offset / params.limit + 1,
            curId: sessionStorage.getItem('curId')
        }
    }

    //页面加载时
    $(function () {

        $.ajax({
            type:"POST",
            url:"/loadCourseByCurId",
            dataType:"json",
            data:{curId:sessionStorage.getItem('curId')},
            success:function(text) {
                if(text.code!==0){
                    alert(text.msg);
                    return;
                }
                //console.log(text.data.curName);
                $('#teaName').text(text.data.teaName);
                $('#curName').text(text.data.curName); 
                $('#info').text(text.data.curIntroduction);
            }
        });

    });

    //添加学生
    function addStu(e) {
        var stuId = $('#stuId').val();
        var stuAge = $('#stuAge').val();
        var stuName = $('#stuName').val();
        var stuSex = $('#stuSex').val();
        var stuMajor = $('#stuMajor').val();
        var stuClass = $('#stuClass').val();
        if(!stuId || !stuAge || !stuSex || !stuName || !stuSex || !stuMajor || !stuClass ){
            alert("请填写完整");
            return ;
        }
        $.ajax({
            type:"POST",
            url:"/SC/addStudent",
            dataType:"json",
            data:{
                stuId:stuId,
                stuAge:stuAge,
                stuName:stuName,
                stuSex:stuSex,
                stuMajor:stuMajor,
                stuClass:stuClass,
                curId: sessionStorage.getItem('curId')
                },
            success:function(text) {
                if(text.code!==0){
                    alert(text.msg);
                    return;
                }
                //e.setAttribute("data-dismiss","modal");
            }
        });

    }

</script>
</body>
</html>