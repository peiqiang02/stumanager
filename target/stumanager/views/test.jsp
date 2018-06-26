<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Modal</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">
        查询条件
    </div>
    <div class="panel-body form-group" style="margin-bottom:0px;">
        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">课程名：</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" name="Name" id="search_name" />
        </div>
        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px">手机号：</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" name="Name" id="search_tel" />
        </div>
        <div class="col-sm-1 col-sm-offset-4">
            <button class="btn btn-primary" id="search_btn">查询</button>
        </div>
    </div>
</div>
<table id="mytab" class="table table-hover"></table>
<div id="toolbar" class="btn-group pull-right" style="margin-right: 20px;">
    <button id="btn_edit" type="button" class="btn btn-default" style="display: none; border-radius: 0">
        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
    </button>
    <button id="btn_delete" type="button" class="btn btn-default" style="display: none;">
        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
    </button>
    <button id="btn_add" type="button" class="btn btn-default">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
    </button>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
    //根据窗口调整表格高度
    $(window).resize(function () {
        $('#mytab').bootstrapTable('resetView', {
            height: tableHeight()
        })
    })
    //生成用户数据
    $('#mytab').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        url: "http://localhost:8080/test1",//要请求数据的文件路径
        height: tableHeight(),//高度调整
        toolbar: '#toolbar',//指定工具栏
        striped: true, //是否显示行间隔色
        dataField: "data",//bootstrap table 可以前端分页也可以后端分页，这里
        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的
        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
        pageNumber: 1, //初始化加载第一页，默认第一页
        pagination: true,//是否分页
        queryParamsType: 'limit',//查询参数组织方式
        queryParams: queryParams,//请求服务器时所传的参数
        sidePagination: 'server',//指定服务器端分页
        pageSize: 2,//单页记录数
        pageList: [5, 10, 20, 30],//分页步进值
        showRefresh: true,//刷新按钮
        showColumns: true,
        clickToSelect: true,//是否启用点击选中行
        toolbarAlign: 'right', //工具栏对齐方式
        buttonsAlign: 'right',//按钮对齐方式
        toolbar: '#toolbar',//指定工作栏
        columns: [
            {
                title: 'ID',
                field: 'curId',
                // visible: false
            },
            {
                title: '课程名称',
                field: 'curName',
                // sortable: true
            },
            {
                title: '指导老师',
                field: 'teaName',
                // sortable: true
            },
            {
                title: '课程介绍',
                field: 'curIntroduction',
                // formatter: operateFormatter
            }
        ],
        locale: 'zh-CN',//中文支持,
        responseHandler: function (res) {
            //在ajax获取到数据，渲染表格之前，修改数据源
            return {
                total : res.data.rowsTotal,
                data : res.data.list
            };
        }
    })
    //三个参数，value代表该列的值
    /*function operateFormatter(value, row, index) {
        // if (value == 2) {
        //     return '<i class="fa fa-lock" style="color:red"></i>'
        // } else if (value == 1) {
        //     return '<i class="fa fa-unlock" style="color:green"></i>'
        // } else {
        //     return '数据错误'
        // }
    }*/

    //请求服务数据时所传参数
    function queryParams(params) {
        console.log(params);
        return {
            //每页多少条数据
            pageLimit: params.limit,
            //请求第几页
            pageIndex: params.offset / params.limit + 1,
            teaId: 2
        }
    }
    //查询按钮事件
    $('#search_btn').click(function () {
        $('#mytab').bootstrapTable('refresh', { url: '../index.php/admin/index/userManagement' });
    })
    //tableHeight函数
    function tableHeight() {
        //可以根据自己页面情况进行调整
        return $(window).height() - 280;
    }
</script>
</body>
</html>