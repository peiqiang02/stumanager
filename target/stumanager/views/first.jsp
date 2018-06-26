<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
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

        .placeholders {
            margin-bottom: 30px;
            text-align: center;
        }

        .placeholder {
            margin-bottom: 20px;
        }

        .placeholder img {
            display: inline-block;
            border-radius: 50%;
        }

        .sub-header {
            padding-bottom: 10px;
            border-bottom: 1px solid #eee;
        }
    </style>
</head>

<body>
    <div class="main">
        <h1 class="page-header">精选课程</h1>
        <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="img/course1.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4>Java</h4>
                <span class="text-muted">Java 语言程序设计</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="img/course2.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4>Oracle</h4>
                <span class="text-muted">大数据综合实践</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="img/course3.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4>Html</h4>
                <span class="text-muted">前端样式设计</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="img/course4.png" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4>Axure rp8</h4>
                <span class="text-muted">移动端原型设计</span>
            </div>
        </div>

        <h2 class="sub-header">所有课程</h2>

        <div class="table-responsive">
            <table id="mytab" class="table table-bordered table-striped">
                <!--<thead>
            <tr>
                <th width="7%">课序号</th>
                <th width="13%">课程名</th>
                <th width="7%">任课教师</th>
                <th width="13%">面向分院</th>
                <th width="10%">上课日期</th>
                <th>课程简介</th>
                <th style="text-align: center" width="15%">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr onclick="this">
                <td>1,001</td>
                <td>零杀吃鸡教学课</td>
                <td>藤原拓海</td>
                <td>计算机与计算科学学院</td>
                <td>2018-9-8至2019-2-16</td>
                <td>dolor</td>
                <td align="center">
                    <input style="margin-bottom: 1px;" type="button" value="修改" class="btn" onclick="check();">
                    <input style="margin-bottom: 1px;" type="button" value="删除" class="btn" onclick="check();">
                </td>
            </tr>
            <tr>
                <td>1,002</td>
                <td>amet</td>
                <td></td>
                <td></td>
                <td>consectetur</td>
                <td>adipiscing</td>
                <td>elit</td>
            </tr>
            <tr>
                <td>1,003</td>
                <td>Integer</td>
                <td></td>
                <td></td>
                <td>nec</td>
                <td>odio</td>
                <td>Praesent</td>
            </tr>
            <tr>
                <td>1,003</td>
                <td>libero</td>
                <td></td>
                <td></td>
                <td>Sed</td>
                <td>cursus</td>
                <td>ante</td>
            </tr>
            <tr>
                <td>1,004</td>
                <td>dapibus</td>
                <td></td>
                <td></td>
                <td>diam</td>
                <td>Sed</td>
                <td>nisi</td>
            </tr>
            <tr>
                <td>1,005</td>
                <td>Nulla</td>
                <td></td>
                <td></td>
                <td>quis</td>
                <td>sem</td>
                <td>at</td>
            </tr>
            <tr>
                <td>1,006</td>
                <td>nibh</td>
                <td></td>
                <td></td>
                <td>elementum</td>
                <td>imperdiet</td>
                <td>Duis</td>
            </tr>
            <tr>
                <td>1,007</td>
                <td>sagittis</td>
                <td></td>
                <td></td>
                <td>ipsum</td>
                <td>Praesent</td>
                <td>mauris</td>
            </tr>
            <tr>
                <td>1,008</td>
                <td>Fusce</td>
                <td></td>
                <td></td>
                <td>nec</td>
                <td>tellus</td>
                <td>sed</td>
            </tr>
            <tr>
                <td>1,009</td>
                <td>augue</td>
                <td></td>
                <td></td>
                <td>semper</td>
                <td>porta</td>
                <td>Mauris</td>
            </tr>
            <tr>
                <td>1,010</td>
                <td>massa</td>
                <td></td>
                <td></td>
                <td>Vestibulum</td>
                <td>lacinia</td>
                <td>arcu</td>
            </tr>
            <tr>
                <td>1,011</td>
                <td>eget</td>
                <td></td>
                <td></td>
                <td>nulla</td>
                <td>Class</td>
                <td>aptent</td>
            </tr>
            <tr>
                <td>1,012</td>
                <td>taciti</td>
                <td></td>
                <td></td>
                <td>sociosqu</td>
                <td>ad</td>
                <td>litora</td>
            </tr>
            <tr>
                <td>1,013</td>
                <td>torquent</td>
                <td></td>
                <td></td>
                <td>per</td>
                <td>conubia</td>
                <td>nostra</td>
            </tr>
            <tr>
                <td>1,014</td>
                <td>per</td>
                <td></td>
                <td></td>
                <td>inceptos</td>
                <td>himenaeos</td>
                <td>Curabitur</td>
            </tr>
            <tr>
                <td>1,015</td>
                <td>sodales</td>
                <td></td>
                <td></td>
                <td>ligula</td>
                <td>in</td>
                <td>libero</td>
            </tr>
            </tbody>-->
            </table>
        </div>
    </div>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <script type="text/javascript">

        //生成表格
        $('#mytab').bootstrapTable({
            method: 'post',
            contentType: "application/x-www-form-urlencoded",//必须要有！！！！
            url: "loadAllCourse",//要请求数据的文件路径
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
                field: 'curId',
                title: '课序号'
            }, {
                field: 'curName',
                title: '课程名'
            }, {
                field: 'teaName',
                title: '任课教师'
            },
            //     {
            //     field: 'shouldNum',
            //     title: '面向分院'
            // }, {
            //     field: 'curDate',
            //     title: '上课日期'
            // },
                {
                field: 'curIntroduction',
                title: '课程简介'
            }, {
                title: '操作',
                field: 'Attribute',
                align: 'center',
                valign: 'middle',
                formatter: operateFormatter
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
                //每页多少条数据
                pageLimit: params.limit,
                //请求第几页
                pageIndex: params.offset / params.limit + 1
            }
        }

        function operateFormatter(value, row, index) {
            return [
                '<input style="margin-bottom: 1px;" type="button" value="修改" class="btn" onclick="check();">',
                '<input style="margin-bottom: 1px;" type="button" value="删除" class="btn" onclick="check();">'
            ].join("")
        }

        function check() {
            alert("该功能没有实现")
        }

    </script>
</body>

</html>