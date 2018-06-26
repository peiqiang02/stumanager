<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>点名</title>
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
        <div class="panel panel-default">
            <div class="panel-heading" style="display: flex;align-items: center;">
                <h2 id="curName" style="margin-right: 20px ;display:inline-block;">计算机系统原理</h2>
                <h2 id="dateTime" style="margin-right: 20px ;display:inline-block;">2018年6月8日</h2>
                <h2 style=" display:inline-block;">签到</h2>
                <div class="btn-group" role="group" style="display: flex;flex-grow: 1;justify-content: flex-end;">
                    <button id="fat-btn" class="btn btn-primary" data-loading-text="Loading..." type="button" style="margin-right: 20px">提 交</button>
                </div>
            </div>
            <div class="panel-body form-group" style="margin-bottom:0px;">

                <div id="student" class="text" style="display:table; width: auto; margin-left: auto;margin-right: auto;">
                    <h2 id="xuehao" style="display:inline-block;margin-right: 20px"></h2>
                    <h2 id="xingming" style="display:inline-block; margin-right: 20px"></h2>
                    <h2 id="zhuangtai" style="display:inline-block; margin-bottom: 10px"></h2>
                </div>
                <div class="btn-group btn-group-lg" style="display:table;margin: 10px auto 20px auto;">
                    <button type="button" class="btn btn-success" onclick="changeState(this)">签到</button>
                    <button type="button" class="btn btn-warning" onclick="changeState(this)">迟到</button>
                    <button type="button" class="btn btn-danger" onclick="changeState(this)">缺课</button>
                </div>

            </div>
        </div>
        <!--<div class="page-header" style="margin-bottom: 0">
        <h1 style="margin-right: 20px ;display:inline-block;">计算机系统原理</h1>
        <h1 style="margin-right: 20px ;display:inline-block;">2018年6月8日</h1>
        <h1 style=" display:inline-block;">签到</h1>
    </div>-->

        <!--点名组件-->
        <!--<div>
        &lt;!&ndash;学生信息&ndash;&gt;
        <div class="text" style="display:table; width: auto; margin-left: auto;margin-right: auto;">
            <h2 id="xuehao" style="display:inline-block;margin-right: 20px">31501369</h2>
            <h2 id="xingming" style="display:inline-block; margin-right: 20px">李捷</h2>
            <h2 id="zhuangtai" style="display:inline-block; margin-right: 20px margin-bottom: 10px">未签</h2>
        </div>
        <div class="btn-group btn-group-lg" style="display:table; width: auto; margin-left: auto;margin-right: auto; margin-bottom: 20px">
            <button type="button" class="btn btn-success">签到</button>
            <button type="button" class="btn btn-warning">迟到</button>
            <button type="button" class="btn btn-danger">缺课</button>
        </div>
    </div>-->

        <div class="table-responsive">
            <table id="myTable" class="table table-bordered table-striped">
                <!--<thead>
            <tr>
                <th width="25%">编号</th>
                <th width="25%">学号</th>
                <th width="25%">姓名</th>
                <th>学生状态</th>
            </tr>
            </thead>
            <tbody>
            <tr onclick="this">
                <td>1</td>
                <td>31501370</td>
                <td>藤原拓海</td>
                <td align="center">
                    &lt;!&ndash;<div class="btn-group">
                        <button type="button" id="button" class="btn btn-default">未签</button>
                            <button type="button" id="buttonw" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">切换下拉菜单</span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a onclick="changeState(this,'btn btn-success')">签到</a></li>
                            <li><a onclick="changeState(this, 'btn btn-warning')">迟到</a></li>
                            <li><a onclick="changeState(this, 'btn btn-danger')">缺课</a></li>
                        </ul>
                    </div>&ndash;&gt;
                    <input id="button11" type="button" class="btn" onclick="changeColor(this)" value="签到">
                    <input id="button21" type="button" class="btn" onclick="changeColor(this)" value="迟到">
                    <input id="button31" type="button" class="btn" onclick="changeColor(this)" value="缺课">
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>31501371</td>
                <td>藤原北空</td>
                <td align="center">
                    <input id="button12" type="button" class="btn" onclick="changeColor(this)" value="签到">
                    <input id="button22" type="button" class="btn" onclick="changeColor(this)" value="迟到">
                    <input id="button32" type="button" class="btn" onclick="changeColor(this)" value="缺课">
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>31501372</td>
                <td>藤原北空3</td>
                <td align="center">
                    <input id="button13" type="button" class="btn" onclick="changeColor(this)" value="签到">
                    <input id="button23" type="button" class="btn" onclick="changeColor(this)" value="迟到">
                    <input id="button33" type="button" class="btn" onclick="changeColor(this)" value="缺课">
                </td>
            </tr>
            <tr>
                <td>4</td>
                <td>31501373</td>
                <td>藤原北空4</td>
                <td align="center">
                    <input id="button14" type="button" class="btn" onclick="changeColor(this)" value="签到">
                    <input id="button24" type="button" class="btn" onclick="changeColor(this)" value="迟到">
                    <input id="button34" type="button" class="btn" onclick="changeColor(this)" value="缺课">
                </td>
            </tr>
            <tr>
                <td>5</td>
                <td>31501374</td>
                <td>藤原北空5</td>
                <td align="center">
                    <input id="button15" type="button" class="btn" onclick="changeColor(this)" value="签到">
                    <input id="button25" type="button" class="btn" onclick="changeColor(this)" value="迟到">
                    <input id="button35" type="button" class="btn" onclick="changeColor(this)" value="缺课">
                </td>
            </tr>
            <tr>
                <td>6</td>
                <td>31501375</td>
                <td>藤原北空6</td>
                <td align="center">
                    <input id="button16" type="button" class="btn" onclick="changeColor(this)" value="签到">
                    <input id="button26" type="button" class="btn" onclick="changeColor(this)" value="迟到">
                    <input id="button36" type="button" class="btn" onclick="changeColor(this)" value="缺课">
                </td>
            </tr>
            </tbody>-->
            </table>
        </div>

    </div>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">

    $(function () {

        $.ajax({
            type:"POST",
            url:"getCheckInfo",
            dataType:"json",
            data:{checkId:sessionStorage.getItem('checkId')},
            async:false,//更改为同步
            success:function(text) {
                if(text.code!==0){
                    alert(text.msg);
                    return;
                }
                var html = '';
                html += '<thead>\n' +
                    '            <tr>\n' +
                    '                <th width="25%">编号</th>\n' +
                    '                <th width="25%">学号</th>\n' +
                    '                <th width="25%">姓名</th>\n' +
                    '                <th>学生状态</th>\n' +
                    '            </tr>\n' +
                    '            </thead>';
                html += '<tbody>';
                for (var i = 0;i< text.data.length ; i++){
                    // alert(text.data[i].id);
                    var j = i+1;
                    html += '<tr>';
                    html += '<td>'+text.data[i].id+'</td>';
                    html += '<td>' + text.data[i].stuId +'</td>';
                    html += '<td>' + text.data[i].stuName +'</td>';
                    html += '<td align="center">';
                    if (text.data[i].state === "签到") {
                        html += '<input id="button1' + i + '" type="button" class="btn btn-success" onclick="changeColor(this)" value="签到">';
                        html += '<input id="button2' + i + '" type="button" class="btn" onclick="changeColor(this)" value="迟到">';
                        html += '<input id="button3' + i + '" type="button" class="btn" onclick="changeColor(this)" value="缺课">';
                    }
                    else if (text.data[i].state === "迟到") {
                        html += '<input id="button1' + i + '" type="button" class="btn" onclick="changeColor(this)" value="签到">';
                        html += '<input id="button2' + i + '" type="button" class="btn btn-warning" onclick="changeColor(this)" value="迟到">';
                        html += '<input id="button3' + i + '" type="button" class="btn" onclick="changeColor(this)" value="缺课">';
                    }
                    else if (text.data[i].state === "缺课") {
                        html += '<input id="button1' + i + '" type="button" class="btn" onclick="changeColor(this)" value="签到">';
                        html += '<input id="button2' + i + '" type="button" class="btn" onclick="changeColor(this)" value="迟到">';
                        html += '<input id="button3' + i + '" type="button" class="btn btn-danger" onclick="changeColor(this)" value="缺课">';
                    } else {
                        html += '<input id="button1' + i + '" type="button" class="btn" onclick="changeColor(this)" value="签到">';
                        html += '<input id="button2' + i + '" type="button" class="btn" onclick="changeColor(this)" value="迟到">';
                        html += '<input id="button3' + i + '" type="button" class="btn" onclick="changeColor(this)" value="缺课">';
                    }
                    // html += '<input id="button1'+j+'" type="button" class="btn" onclick="changeColor(this)" value="签到">';
                    // html += '<input id="button2'+j+'" type="button" class="btn" onclick="changeColor(this)" value="迟到">';
                    // html += '<input id="button3'+j+'" type="button" class="btn" onclick="changeColor(this)" value="缺课">';
                    html += '</td>';
                    html += '</tr>';
                }
                html += '</tbody>';
                $('#myTable').html(html);
            }
        });

    });

        // $('#myTable').bootstrapTable({
        //     method: 'post',
        //     contentType: "application/x-www-form-urlencoded",//必须要有！！！！
        //     url: "getCheckInfo",//要请求数据的文件路径
        //     striped: true, //是否显示行间隔色
        //     pagination: false,//是否分页
        //     dataField: "data",
        //     queryParams: queryParams,//请求服务器时所传的参数
        //     showRefresh: true,//刷新按钮
        //     showColumns: true,
        //     clickToSelect: true,//是否启用点击选中行
        //     async: false ,
        //     columns: [{
        //         field: 'id',
        //         title: '编号', 
        //     }, {
        //         field: 'stuId',
        //         title: '学号'
        //     }, {
        //         field: 'stuName',
        //         title: '姓名'
        //     }, {
        //         field: 'state',
        //         title: '学生状态',
        //         formatter: operateFormatter
        //     }],
        //     locale: 'zh-CN',//中文支持,
        //     responseHandler: function (list) {
        //         return {
        //             data: list.data
        //         };

        //     }
        // });

        // //请求服务数据时所传参数
        // function queryParams(params) {
        //     return {
        //         checkId: sessionStorage.getItem('checkId')
        //     }
        // }

        // function operateFormatter(value, row, index) {
        //     return [
        //         '<input id="button1' + index + '" type="button" class="btn" onclick="changeColor(this)" value="签到">',
        //         '<input id="button2' + index + '" type="button" class="btn" onclick="changeColor(this)" value="迟到">',
        //         '<input id="button3' + index + '" type="button" class="btn" onclick="changeColor(this)" value="缺课">'
        //     ].join("")
        // }

        //页面加载时
        $(function () {
            //显示课程信息
            var time = getUrlParam('time');
            $('#curName').text(sessionStorage.getItem('curName'));
            $('#dateTime').text(time);
            // //显示学生信息
            // var myTable = document.getElementById("myTable");
            // if (myTable.rows.length > 0) {
            //     var html = "";
            //     html += '<h2 id="xuehao" style="display:inline-block;margin-right: 20px">' + myTable.rows[1].stuId + '</h2>';
            //     html += '<h2 id="xingming" style="display:inline-block; margin-right: 20px">' + myTable.rows[1].stuName + '</h2>';
            //     html += '<h2 id="zhuangtai" style="display:inline-block; margin-bottom: 10px">未签</h2>';
            //     $('#student').html(html);
            // } else {
            //     return 0;
            // }

            //提交表单
            var myTable = document.getElementById("myTable");
            var keyArray = [];
            $("#fat-btn").click(function () {
                $(this).button('loading').delay(1000).queue(function () {
                    $(this).button('reset');
                    $(this).dequeue();
                    for (var i = 1; i < myTable.rows.length; i++) {
                        var stuId = myTable.rows[i].cells[1].innerHTML;
                        var stuName = myTable.rows[i].cells[2].innerHTML;
                        var state = "未签";
                        if ($("#button1" + i + "").hasClass("btn-success")) { state = "签到" }
                        else if ($("#button2" + i + "").hasClass("btn-warning")) { state = "迟到" }
                        else { state = "缺课" }
                        keyArray.push({
                            checkId: sessionStorage.getItem('checkId'),
                            stuId: stuId,
                            state: state
                        });
                        
                    }
                    

                    $.ajax({
                        type: "POST",
                        url: "saveCheckInfo/"+sessionStorage.getItem('checkId'),
                        dataType: "json",
                        contentType: 'application/json',
                        data: JSON.stringify(keyArray),
                        success: function (text) {
                            if (text.code !== 0) {
                                alert(text.msg);
                                return;
                            }
                            alert("提交成功");
                        }
                    });
                });
            });
        });

        var j = 1;
        function changeState(e) {
            var myTable = document.getElementById("myTable");
            if (e.className === "btn btn-success") {
                $('#button1' + j + '').attr("class", "btn btn-success");
                $('#button2' + j + '').attr("class", "btn");
                $('#button3' + j + '').attr("class", "btn");
            }
            else if (e.className === "btn btn-warning") {
                $('#button2' + j + '').attr("class", "btn btn-warning");
                $('#button1' + j + '').attr("class", "btn");
                $('#button3' + j + '').attr("class", "btn");
            }
            else {
                $('#button3' + j + '').attr("class", "btn btn-danger");
                $('#button2' + j + '').attr("class", "btn");
                $('#button1' + j + '').attr("class", "btn");
            }
            if (j < myTable.rows.length) {
                var html = "";
                html += '<h2 id="xuehao" style="display:inline-block;margin-right: 20px">' + myTable.rows[j].cells[1].innerHTML + '</h2>';
                html += '<h2 id="xingming" style="display:inline-block; margin-right: 20px">' + myTable.rows[j].cells[2].innerHTML + '</h2>';
                html += '<h2 id="zhuangtai" style="display:inline-block; margin-bottom: 10px">未签</h2>';
                $('#student').html(html);
                j++;
            }
        }
        
        //获取url上的参数
        function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");//构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);//匹配目标参数
            if (r != null) return unescape(r[2]); return null;//返回参数值
        }

        //修改按钮颜色
        function changeColor(e) {
            let p = e.parentNode.children;
            for (let i = 0, pl = p.length; i < pl; i++) {
                if (p[i] !== e) {
                    p[i].className = "btn";
                }
            }
            if (e.value === "签到") $(e).addClass("btn-success");
            if (e.value === "迟到") $(e).addClass("btn-warning");
            if (e.value === "缺课") $(e).addClass("btn-danger");
        }

    //修改按钮颜色
    /*function changeState(e) {
        //console.log(e.text);
        $("#button").text(e.text).attr("class",className);
        $("#buttonw").attr("class",className).addClass("dropdown-toggle");
    }*/
    </script>
</body>

</html>