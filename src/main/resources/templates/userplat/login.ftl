<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link href="../userplat/lib/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="../userplat/lib/font-awesome/font-awesome.css" rel="stylesheet">

    <link href="../userplat/css/test.css">

    <link href="../userplat/lib/others/animate.css" rel="stylesheet">
    <link href="../userplat/lib/others/style.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name">H+</h1>

        </div>
        <h3 id="aaa">欢迎使用 H+</h3>

        <form class="m-t" role="form" action="/userplat/login" method="post">
            <div class="form-group">
                <input type="text" class="form-control" name="loginName" placeholder="邮箱" required="">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="密码" required="">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b login">登 录</button>
            <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="/userplat/register">注册一个新账号</a>
            </p>
        </form>
    </div>
</div>

<!-- 全局js -->
<script src="../userplat/lib/jquery/jquery-3.3.1.min.js"></script>
<script src="../userplat/lib/bootstrap/bootstrap.min.js"></script>
<script src="../userplat/js/login.js"></script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

</body>

</html>
