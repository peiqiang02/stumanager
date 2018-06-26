<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>作业详情</title>
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
            <h2 id="taskName" style="margin-right: 20px ;display:inline-block;">软件体系结构</h2>
            <h2 id="taskDate" style="margin-right: 20px ;display:inline-block;"></h2>
            <h2 style="margin-right: 20px ;display:inline-block;">发布</h2>
            <div class="btn-group" role="group" style="display: flex;flex-grow: 1;justify-content: flex-end;">
                <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..." type="button" style="margin-right: 20px">提 交</button>
            </div>
        </div>
        <div class="panel-body form-group" style="margin-bottom:0;">
            <h2 class="page-header" style="margin-top: 0; margin-bottom: 10px;">作业简介</h2>
            <p id="taskInfo" style="text-indent:2em;">
                <font size="4">
                    软件体系结构是具有一定形式的结构化元素，即构件的集合，包括处理构件、数据构件和连接构件。
                    处理构件负责对数据进行加工， 数据构件是被加工的信息，连接构件把体系结构的不同部分组合连接起来。
                    这一定义注重区分处理构件、数据构件和连接构件，这一方法在其他的定义和方法中基本上得到保持。
                </font>
            </p>

        </div>
    </div>

    <div class="table-responsive">
        <table id="myTable" class="table table-bordered table-striped">
        </table>
    </div>

</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">

    //生成表格
    $('#myTable').bootstrapTable({
        method: 'post',
        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        url:"loadTaskGrade",//要请求数据的文件路径
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
        columns: [{
            field: 'id',
            title: '作业序号'
        }, {
            field: 'name',
            title: '课程名'
        }, {
            field: 'stuId',
            title: '学号'
        }, {
            field: 'stuName',
            title: '姓名'
        }, {
            title:'成绩',
            field:'grades',
            align:'center',
            formatter:operateFormatter
        }],
        locale:'zh-CN',//中文支持,
        responseHandler:function(list){
            return list;
        }
    });

    //请求服务数据时所传参数
    function queryParams(params){
        return{
            //每页多少条数据
            pageSize: params.limit,
            //请求第几页
            pageIndex: params.offset / params.limit + 1,
            
        }
    }

    function operateFormatter(value,row,index){
        return [
            '<input id="abc'+index+'" style="margin-bottom: 1px;" type="number" oninput="if(value.length>=3)value=value.slice(0,3)" value="-1">'
        ].join("")
    }

    //页面加载时
    $(function () {

        $.ajax({
            type:"POST",
            url:"/getOneTask",
            dataType:"json",
            data:{taskId:sessionStorage.getItem('taskId')},
            success:function(text) {
                if(text.code!==0){
                    alert(text.msg);
                    return;
                }
                console.log(text.data.taskContext);
                $('#taskName').text(text.data.curName);
                $('#taskDate').text(text.data.taskDate);
                $('#taskInfo').text(text.data.taskContext);
            }
        });

        //提交表单
        var myTable = document.getElementById("myTable");
        var keyArray = new Array();
        $("#fat-btn").click(function(){
            $(this).button('loading').delay(1000).queue(function() {
                $(this).button('reset');
                //$(this).dequeue();//避免重复提交
                for(var i = 1; i <= myTable.rows.length; i++){
                    var id = myTable.rows[i].cells[1].innerHTML;
                    var name = myTable.rows[i].cells[1].innerHTML;
                    var stuId = myTable.rows[i].cells[2].innerHTML;
                    var stuName = myTable.rows[i].cells[3].innerHTML;
                    var grades = $("#abc"+i+"").val();
                    var key = {
                        id:id,
                        name:name,
                        stuId:stuId,
                        stuName:stuName,
                        grades:grades
                    };
                    keyArray.push({key:key});
                }
                $.ajax({
                    type:"POST",
                    url:"",
                    dataType:"json",
                    data:{list:keyArray},
                    success:function(text) {
                        if(text.code!==0){
                            alert(text.msg);
                            return;
                        }
                        alert("提交成功");
                    }
                });
            });
        });

    });


</script>
</body>
</html>