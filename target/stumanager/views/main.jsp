<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>学生成绩管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 50px;
        }
        .navbar-fixed-top {
            border: 0;
        }
        .sidebar {
            display: none;
        }
        @media (min-width: 768px) {
            .sidebar {
                position: fixed;
                top: 51px;
                bottom: 0;
                left: 0;
                z-index: 1000;
                display: block;
                padding: 20px;
                overflow-x: hidden;
                overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
                background-color: #f5f5f5;
                border-right: 1px solid #eee;
            }
        }
        .nav-sidebar {
            margin-right: -21px;
            margin-bottom: 20px;
            margin-left: -20px;
        }
        .nav-sidebar>li>a {
            padding-right: 20px;
            padding-left: 20px;
        }
        .nav-sidebar > .active > a, .nav-sidebar > .active > a:hover, .nav-sidebar > .active > a:focus {
            color: #fff;
            background-color: #428bca;
        }
        @media (max-width: 768px) {
            .btn {
                display: block;
            }
        }
        .nav li a {
            cursor:pointer;
        }
    </style>
</head>
<body>

<!--头部导航栏-->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="main.html">学生成绩管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a data-toggle="modal" data-target="#myModal">添加课程</a></li>
                <li><a data-toggle="modal" data-target="#publishModal">发布作业</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown">
                        关于我的 <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a data-toggle="modal" data-target="#teaModal">修改个人信息</a></li>
                        <li class="divider"></li>
                        <li><a href="#">我发布的作业</a></li>
                        <li class="divider"></li>
                        <li><a href="http://localhost:8080/CheckIn" target="manager">点名记录</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加课程
                </h4>
            </div>
            <form class="modal-body" role="form">
                <div class="form-group">
                    <label for="courseName">课程名称</label>
                    <input title="课程名称不超过20字" type="text" class="form-control" id="courseName" placeholder="请输入课程名称">
                </div>
                <div class="form-group">
                    <label for="courseDate">上课日期</label>
                    <div class="form-inline">
                        <div class='input-group date' id='datetimepicker1'>
                            <input type="text" class="form-control" id="courseDate" placeholder="请选择开课日期">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                        至
                        <div class='input-group date' id='datetimepicker2'>
                            <input type="text" class="form-control" id="courseDateTo" placeholder="请选择结课日期">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="branch">面向分院</label>
                    <select  id="branch" class="form-control" title="请选择分院">
                        <option>计算机与计算科学学院</option>
                        <option>信息与电气工程学院</option>
                        <option>工程学院</option>
                        <option>医学院</option>
                        <option>外国语学院</option>
                        <option>商学院</option>
                        <option>传媒与人文学院</option>
                        <option>法学院</option>
                        <option>创意与艺术设计学院</option>
                        <option>新西兰UW学院</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>课程简介</label>
                    <textarea id="introduction" class="form-control" rows="3" title="课程简介不超过100字"></textarea>
                </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addCourses(this)">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!--修改个人信息-->
<div class="modal fade" id="teaModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="teaModalLabel">
                    修改个人信息
                </h4>
            </div>
            <form class="modal-body" role="form">
                <div class="form-group">
                    <div class="form-inline">
                        <label for="courseName">姓名</label>
                        <input style="margin-right: 20px" title="姓名不超过10字" type="text" class="form-control" id="teacherName" placeholder="请输入姓名">
                        <label for="courseName">联系电话</label>
                        <input title="11位手机号码" type="number" class="form-control" id="iphone" placeholder="请输入手机号码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-inline">
                        <label for="courseName">年龄</label>
                        <input style="margin-right: 20px" title="年龄不能超过200" type="number" class="form-control" id="teacherAge" placeholder="请输入年龄">
                        <label for="teacherSex">学历</label>
                        <select style="margin-right: 20px" id="teacherSex" class="form-control" title="请选择性别">
                            <option></option>
                            <option>男</option>
                            <option>女</option>
                        </select>
                        <label for="education">学历</label>
                        <select id="education" class="form-control" title="请选择学历">
                            <option></option>
                            <option>硕士</option>
                            <option>博士</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-inline" style="margin: auto">
                        <label for="outlook">政治面貌</label>
                        <select style="margin-right: 20px" id="outlook" class="form-control" title="请选择政治面貌">
                            <option></option>
                            <option>群众</option>
                            <option>团员</option>
                            <option>党员</option>
                        </select>
                        <label for="teacherType">职称</label>
                        <select  id="teacherType" class="form-control" title="请选择职称">
                            <option></option>
                            <option>助教</option>
                            <option>讲师</option>
                            <option>副教授</option>
                            <option>教授</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label>个人简介</label>
                    <textarea id="teacherInfo" class="form-control" rows="3" title="课程简介不超过100字"></textarea>
                </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="changeInfo(this)">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!--发布作业-->
<div class="modal fade" id="publishModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="publishModalLabel">
                    发布作业
                </h4>
            </div>
            <form class="modal-body" role="form">
                <div class="form-group">
                    <label for="curName">课程名</label>
                    <select  id="curName" class="form-control" title="请选择课程">
                        <option> </option>
                        <!-- <option>软件体系结构</option>
                        <option>人机交互</option> -->
                    </select>
                </div>
                <div class="form-group">
                    <label for="pubDate">作业期限</label>
                    <div class="form-inline">
                        <div class='input-group date' id='datetimepicker3'>
                            <input type="text" class="form-control" id="pubDate" placeholder="请选择开课日期">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                        至
                        <div class='input-group date' id='datetimepicker4'>
                            <input type="text" class="form-control" id="subDate" placeholder="请选择结课日期">
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="taskName">作业题目</label>
                    <input id="taskName" title="作业题目不超过10字" type="text" class="form-control" placeholder="请输入作业题目">
                </div>
                <div class="form-group">
                    <label>作业内容</label>
                    <textarea id="taskContent" class="form-control" rows="3" title="作业题目不超过100字"></textarea>
                </div>
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">
                    关闭
                </button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addTask(this)">
                    提交
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<div class="container-fluid">
    <div class="row">
        <!--侧边栏-->
        <div class="col-sm-3 col-md-2 sidebar">
            <h4 style="margin-top: 0;">我的课程</h4>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="first.html" target="manager">首页</a></li>
                <!--<li><a href="#">Java 语言程序设计</a></li>
                <li><a href="#">Java EE 企业级应用开发</a></li>
                <li><a href="#">软件体系结构</a></li>
                <li><a href="#">需求分析与设计</a></li>
                <li><a href="#">C 语言程序设计</a></li>
                <li><a href="#">零杀吃鸡终极教学</a></li>-->
            </ul>
        </div>

        <iframe src="first.html" id="svn" name="manager" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" onLoad="changeFrameHeight()" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
            <!-- <h1 class="page-header">精选课程</h1>
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
                 <table class="table table-bordered table-striped">
                     <thead>
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
                     </tbody>
                 </table>
             </div>-->
        </iframe>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js" ></script>
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript">

    //页面加载时执行
    $(document).ready(function(){
        //获取该老师的所有课程
        $.ajax({
            type:"POST",
            url:"/loadCourseById",
            dataType:"json",
            success:function(text) {
                var html = "";
                var option = $('#curName').html();
                if(text.code!==0){
                    alert(text.msg);
                    return;
                }
                if (text.data!=null&&text.data.length>0) {
                    for (var i = 0; i < text.data.length; i++){
                        html += '<li value="'+text.data[i].curId+'" value1="'+text.data[i].curName+'"><a href="courseHome" target="manager" >'+text.data[i].curName+'</a></li>';
                        option += '<option>' + text.data[i].curName + '</option>';
                    }
                    $('#curName').html(option);
                    $('.nav-sidebar').append(html);
                    $(".nav-sidebar li").on("click", function () {
                        $(".nav-sidebar li").removeClass("active");
                        sessionStorage.setItem('curId',$(this).attr("value"));
                        sessionStorage.setItem('curName',$(this).attr("value1"));
                        $(this).addClass("active");
                    });
                }
            }
        });

    });
    //iframe 自适应宽高
    function changeFrameHeight(){
        var ifm = document.getElementById("svn");
        try{
            /*let bHeight = ifm.contentWindow.document.body.scrollHeight;
            let dHeight = ifm.contentWindow.document.documentElement.scrollHeight;*/
            ifm.height = ifm.contentWindow.document.body.scrollHeight;
            //console.log(ifm.height);
        }catch (ex){
            alert(ex);
        }

        /*let subWeb = document.frames ? document.frames["svn"].document : ifm.contentDocument;
        if(ifm != null && subWeb != null) {
            ifm.height = subWeb.body.scrollHeight;
            ifm.width = subWeb.body.scrollWidth;
        }*/
    }
    window.setInterval("changeFrameHeight()", 200);
    //添加作业
    function addTask(e){
        let curName = $('#curName').val();
        let pubDate = $('#pubDate').val();
        let subDate = $('#subDate').val();
        let taskName = $('#taskName').val();
        let taskContent = $('#taskContent').val();
        if (!curName || !pubDate || !subDate || !taskContent || !taskName) {
            alert("请填写完整");
            return;
        }
        $.ajax({
            type: "POST",
            url: "/addTask",
            dataType: "json",
            data: { curId: sessionStorage.getItem(), pubDate: pubDate, subDate: subDate, taskName: taskName, taskContent: taskContent },
            success: function (text) {
                if (text.code !== 0) {
                    alert(text.msg);
                    return;
                }
                //e.setAttribute("data-dismiss","modal");
            }
        });
        //e.setAttribute("data-dismiss","modal");
    }
    //修改个人信息
    function changeInfo(e){
        var age = $('#teacherAge').val();
        var name = $('#teacherName').val();
        var sex = $('#teacherSex').val();
        var type = $('#teacherType').val();
        if(!age || !name || !sex || !type ){
            alert("请填写完整");
            return ;
        }
        //e.setAttribute("data-dismiss","modal");
    }
    //添加课程
    function addCourses(e){
        var courseName = $('#courseName').val();
        var courseDate = $('#courseDate').val();
        var courseDateTo = $('#courseDateTo').val();
        var branch = $('#branch').val();
        var introduction = $('#introduction').val();

        if (!courseName || !courseDate || !courseDateTo || !branch || !introduction ) { //用户框value值和密码框value值都为空
            /*console.log(courseName);
            console.log(courseDate);
            console.log(courseDateTo);
            console.log(branch);
            console.log(introduction);*/
            alert("请填写完整");
            return false; //只有返回true表单才会提交
        } else if (!courseDate) { //开课时间为空
            return false;
        } else if (!courseDateTo) { //结课时间为空
            return false;
        }
        //提交数据
        //e.setAttribute("data-dismiss","modal");

    }
    //时间选择器，页面加载时执行
    $(function () {
        var picker1 = $('#datetimepicker1').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
            //minDate: '2016-7-1'
        });
        var picker2 = $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn')
        });
        //动态设置最小值
        picker1.on('dp.change', function (e) {
            picker2.data('DateTimePicker').minDate(e.date);
        });
        //动态设置最大值
        picker2.on('dp.change', function (e) {
            picker1.data('DateTimePicker').maxDate(e.date);
        });
        var picker3 = $('#datetimepicker3').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn'),
            //minDate: '2016-7-1'
        });
        var picker4 = $('#datetimepicker4').datetimepicker({
            format: 'YYYY-MM-DD',
            locale: moment.locale('zh-cn')
        });
        //动态设置最小值
        picker3.on('dp.change', function (e) {
            picker4.data('DateTimePicker').minDate(e.date);
        });
        //动态设置最大值
        picker3.on('dp.change', function (e) {
            picker4.data('DateTimePicker').maxDate(e.date);
        });
    });

    //头部导航栏选中状态修改
    $(".navbar-nav li").click(function () {
        $(".navbar-nav li").removeClass("active");
        $(this).addClass("active");
    });
    //侧边栏选中状态修改
    // $(".nav-sidebar li").get(1).addEventListener("click", function () {
    //    console.log(222);
    // });
    // $(".nav-sidebar li").on("click", function () {
    //     $(".nav-sidebar li").removeClass("active");
    //     console.log(1);
    //     $(this).addClass("active");
    // });
</script>
</body>
</html>