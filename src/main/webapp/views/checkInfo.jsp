<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>上课点名</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
    <style>
        .main {
            padding: 20px;
        }
        @media (min-width: 768px) {
            .main {
                padding-right: 40px;
                padding-left: 40px;
            }
        }
        .main .page-header {
            margin-top: 0;
        }
    </style>
</head>
<body>
<div class="main">
    <h1 class="page-header">上课点名
        <div id="toolbar" class="btn-group pull-right" >
            <button onclick="newCheckIn()" id="btn_add" type="button" class="btn btn-default" style="border-radius: 0">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
        </div>
    </h1>

    <div class="table-responsive">
        <table id="table" class="table table-bordered"></table>
    </div>


</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $('#table').bootstrapTable({
        method: 'post',
        url:"http://localhost:8080/getCheck",//要请求数据的文件路径
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        striped: true, //是否显示行间隔色
        pagination:true,//是否分页
        queryParamsType:'limit',//查询参数组织方式
        queryParams:queryParams,//请求服务器时所传的参数
        dataField: "data",
        pageNumber: 1,
        sidePagination: 'server',//指定服务器端分页
        pageSize:10,//单页记录数
        pageList:[5,10,20,30],//分页步进值
        showRefresh:true,//刷新按钮
        showColumns:true,
        clickToSelect: true,//是否启用点击选中行
        onDblClickRow: function (row) {
            sessionStorage.setItem('checkId', row.id);
            sessionStorage.setItem('curId', row.curId);
            sessionStorage.setItem('curName', row.curName);
            window.location.href = 'checkInDetail?time=' +row.checkDate+'';
        
            //console.log("click:" + row.playerName)
        },
        columns: [
        {
            field: 'id',
            title: 'id',
            visible: false
        },
        {
            field: 'curId',
            title: '课序号'
        }, {
            field: 'curName',
            title: '课程名'
        }, {
            field: 'checkDate',
            title: '日期'
        }, {
            field: 'shouldNum',
            title: '上课人数'
        }, {
            field: 'lateNum',
            title: '迟到人数'
        }, {
            field: 'notNum',
            title: '缺课人数'
        }],
        locale:'zh-CN',//中文支持,
        responseHandler:function(res){
            var errcode = res.code;//在此做了错误代码的判断
            if (errcode != 0) {
                alert("错误代码" + res.msg);
                return;
            }
            return {
                total: res.data.rowsTotal,
                data: res.data.list
            };
        }
        /*data: [{
            id: 1,
            name: '人机交互',
            time: '2017-6-59',
            shouldNum: 30,
            trueNum: 25,
            lateNum: 20,
            notNum: 5,
        }, {
            id: 2,
            name: 'Java 大数据开发',
            price: '2017-6-58',
            shouldNum: 30,
            trueNum: 25,
            lateNum: 20,
            notNum: 5,
        }, {
            id: 3,
            name: '项目管理',
            price: '2017-6-21',
            shouldNum: 30,
            trueNum: 25,
            lateNum: 20,
            notNum: 5,
        }]*/
    });

    //请求服务数据时所传参数
    function queryParams(params){
        return{
            //每页多少条数据
            pageLimit: params.limit,
            //请求第几页
            pageIndex:params.offset+1,
            curId:sessionStorage.getItem('curId')
            // Name:$('#search_name').val(),
            // Tel:$('#search_tel').val()
        }
    }

    //新增点名
    function newCheckIn() {
        if (sessionStorage.getItem('curId') !== null) {
            var date = new Date();
            var sign1 = "-";
            var sign2 = ":";
            var year = date.getFullYear() // 年
            var month = date.getMonth() + 1; // 月
            var day = date.getDate(); // 日
            var hour = date.getHours(); // 时
            var minutes = date.getMinutes(); // 分
            var seconds = date.getSeconds() //秒
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (day >= 0 && day <= 9) {
                day = "0" + day;
            }
            if (hour >= 0 && hour <= 9) {
                hour = "0" + hour;
            }
            if (minutes >= 0 && minutes <= 9) {
                minutes = "0" + minutes;
            }
            if (seconds >= 0 && seconds <= 9) {
                seconds = "0" + seconds;
            }
            var currentdate = year + sign1 + month + sign1 + day;
            $.ajax({
                type: "POST",
                url: "/addCheck",
                dataType: "json",
                data: { curId: sessionStorage.getItem('curId') },
                success: function (text) {
                    if (text.code !== 0) {
                        alert(text.msg);
                        return;
                    }
                    location.reload();
                }
            });
        } else {
            alert("请先选择课程");
        }

    }

</script>
</body>
</html>