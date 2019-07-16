<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>backend</title>
    <link rel="stylesheet"  href="../userplat/lib/bootstrap/bootstrap.min.css" />
    <link rel="stylesheet"  href="../userplat/lib/bootstraptable/bootstrap-table.css" />
    <link rel="stylesheet"  href="../userplat/css/index.css" />
    <script src="../userplat/lib/jquery/jquery-3.3.1.min.js"></script>
    <script src="../userplat/lib/bootstrap/bootstrap.min.js"></script>
    <script src="../userplat/js/userSetting.js"></script>
</head>

<body>
<div class="panel panel-default" id="userSet">
    <div class="panel-heading">
        <h3 class="panel-title">商品类型管理</h3>
    </div>
    <div class="panel-body">
        <input type="button" value="添加商品类型" class="btn btn-primary" id="doAddProTpye">
        <br>
        <br>
        <#-- 添加商品类型列表 -->
        <table id="account_table" class="table table-striped table_list"></table>
    </div>
</div>

<!-- 添加商品类型 start -->
<div class="modal fade" tabindex="-1" id="ProductType">
    <!-- 窗口声明 -->
    <div class="modal-dialog modal-lg">
        <!-- 内容声明 -->
        <div class="modal-content">
            <!-- 头部、主体、脚注 -->
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">添加商品类型</h4>
            </div>
            <div class="modal-body text-center">
                <div class="row text-right">
                    <label for="productTypeName" class="col-sm-4 control-label">类型名称：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="productTypeName">
                    </div>
                </div>
                <br>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary addProductType">添加</button>
                <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- 添加商品类型 end -->

<!-- 修改商品类型 start -->
<div class="modal fade" tabindex="-1" id="myProductType">
    <!-- 窗口声明 -->
    <div class="modal-dialog modal-lg">
        <!-- 内容声明 -->
        <div class="modal-content">
            <!-- 头部、主体、脚注 -->
            <div class="modal-header">
                <button class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">修改商品类型</h4>
            </div>
            <div class="modal-body text-center">
                <div class="row text-right">
                    <label for="proTypeNum" class="col-sm-4 control-label">编号：</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="proTypeNum" readonly>
                    </div>
                </div>
                <br>
                <div class="row text-right">
                    <label for="proTypeName" class="col-sm-4 control-label">类型名称</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="proTypeName">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button class="btn btn-warning updateProType">修改</button>
                <button class="btn btn-primary cancel" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
<!-- 修改商品类型 end -->
</body>

<script src="../userplat/lib/bootstraptable/bootstrap-table.js"></script>
<script src="../userplat/lib/bootstraptable/locale/bootstrap-table-zh-CN.js"></script>
<script src="../userplat/js/productType.js"></script>


</html>