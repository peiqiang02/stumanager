<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>登陆</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
		<style>
			html,
			body {
				height: 100%;
			}

			body {
				display: -ms-flexbox;
				display: -webkit-box;
				display: flex;
				-ms-flex-align: center;
				-ms-flex-pack: center;
				-webkit-box-align: center;
				align-items: center;
				-webkit-box-pack: center;
				justify-content: center;
				padding-top: 40px;
				padding-bottom: 40px;
				background-color: #f5f5f5;
			}

			.form-signin {
				width: 100%;
				max-width: 330px;
				padding: 15px;
				margin: 0 auto;
			}

			.form-signin .checkbox {
				font-weight: 400;
			}

			.form-signin .form-control {
				position: relative;
				box-sizing: border-box;
				height: auto;
				padding: 10px;
				font-size: 16px;
			}

			.form-signin .form-control:focus {
				z-index: 2;
			}

			.form-signin input[type="text"] {
				margin-bottom: -1px;
				border-bottom-right-radius: 0;
				border-bottom-left-radius: 0;
			}

			.form-signin input[type="password"] {
				margin-bottom: 10px;
				border-top-left-radius: 0;
				border-top-right-radius: 0;
			}
		</style>
	</head>

	<body class="text-center">
		<div class="form-signin">
			<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
			<label for="userId" class="sr-only">请输入教工号</label>
			<input type="text" id="userId" class="form-control" placeholder="请输入教工号" required="" autofocus="">
			<label for="pwd" class="sr-only">请输入密码</label>
			<input type="password" id="pwd" class="form-control" placeholder="请输入密码" required="">
			<div class="checkbox mb-3">
				<label>
					<input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit" onclick="login()">Sign in</button>
			<p class="mt-5 mb-3 text-muted">© 2017-2018</p>
		</div>
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			function login() {
				var userId = $('#userId').val();
				var pwd = $('#pwd').val();
				if (!userId && !pwd) { //用户框value值和密码框value值都为空
					return false; //只有返回true表单才会提交
				} else if (!userId) { //用户框value值为空
					return false;
				} else if (!pwd) { //密码框value值为空
					return false;
				}
				$.ajax({
					type: "POST",
					url: "login",
					dataType: "json",
					data: { userId: userId, password: pwd },
					success: function (text) {
						var r = text;
						if (r.code != 0) {
							$('#pwd').val('');
							alert("密码错误");
							return;
						}
						window.location.href = "test";
					}
				});
			}
		</script>
	</body>

	</html>