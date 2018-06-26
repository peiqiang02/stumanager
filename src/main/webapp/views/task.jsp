<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我发布的作业</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
    <style>
        .main {
            padding: 20px;
        }
        @media (min-width: 768px) {
            .main {
                padding-right: 25px;
                padding-left: 25px;
            }
        }
        .main .page-header {
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="main">
    <h1 id="myTime" class="page-header"></h1>

    <div class="table-responsive">
        <table id="myTable" class="table table-bordered table-striped">
        </table>
    </div>

</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">

    $('#myTable').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        url:"loadTaskByCouseId",//要请求数据的文件路径
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
            sessionStorage.setItem('taskId',row.id);
            window.location.href='../../../../../../Downloads/StuManager/taskDetail.jsp'
            //console.log("click:" + row.playerName)
        },
        columns: [{
            field: 'id',
            title: '序号'
        }, {
            field: 'curName',
            title: '课程名'
        }, {
            field: 'taskName',
            title: '作业名'
        }, {
            field: 'taskDate',
            title: '发布日期'
        }, {
            field: 'taskContent',
            title: '作业简介'
        }],
        locale:'zh-CN',//中文支持,
        responseHandler:function(list){
            return {
                total: list.data.rowsTotal,
                data: list.data.list
            };
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

    //显示时间
    function showTime(){
        var nowTime=new Date();
        var year=nowTime.getFullYear();
        var month=nowTime.getMonth()+1;
        var date=nowTime.getDate();
        document.getElementById("myTime").innerText=year+"年"+month+"月"+date+"日 "+nowTime.toLocaleTimeString();
    }
    window.setInterval("showTime()",1000);

</script>

</body>
</html>