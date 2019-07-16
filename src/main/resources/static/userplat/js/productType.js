var $table = $("#account_table");

//弹出删除商品类型模态框(bootstrap-table实现)
function productTypeDelete(id) {
    $('#delete_productType_modal').modal("show");
    $('#delete_productType_id').val(id);
}

//商品类型删除
$('#do_delete_productType_btn').click(function () {
    $.ajax({
        url: "/userplat/producttype/delete",
        type: "post",
        data: {
            id: $("#delete_productType_id").val()
        },
        success: function (res) {
            // alert(id);
            if (res.success) {
                $("#delete_productType_modal").modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
                $("#delete_productType_modal").modal("hide");
            }
        },
        error: function() {
            alert(id);
        }
    });
});

//弹出添加商品类型模态框
$("#doAddProTpye").on("click", function() {
    _this = this; //this是事件源
    $("#ProductType").modal("show");
});

//添加商品类型
$('#addProductType').click(function() {
    $.ajax({
        url: "/userplat/producttype/save",
        type: "post",
        data: {
            name: $('#productTypeName').val(),
        },
        success: function(res) {
            if(res.success) {
                $('#ProductType').modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
            }
        },
        error: function() {
            alert("编辑失败");
        }
    })
})

//弹出更新商品类型名称模态框(bootstrap-table实现),id为框架自带参数
function openProductTypeEditModel(id) {
    $('#myProductType').modal("show");
    $('#proTypeNum').val(id);
}

//更新商品类型
$('#update').click(function(){

    $.ajax({
        url: "/userplat/producttype/update",
        type: "post",
        data: {
            id: $('#proTypeNum').val(),
            name: $('#proTypeName').val()
        },
        success: function(res) {
            if(res.success) {
                $('#myProductType').modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
            }
        },
        error: function() {
            alert("编辑失败");
        }
    })

})

//修改商品类型状态：1：启用,2：禁用
function modifyStatus(id) {
    $.ajax({
        url: "/userplat/producttype/updateStatus",
        type: "post",
        data: {
            id: id
        },
        success: function(res) {
            if(res.success) {
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
            }
        },
        error: function() {
            alert("编辑失败");
        }
    })
}

//列出商品类型列表
$(function () {
    $table.bootstrapTable({
        url: '/userplat/producttype/list',
        striped: true,
        idField: 'id',
        // toolbar: '#toolbar',
        sidePagination: 'server',
        pagination: true,
        pageNumber: 2,
        pageSize: 6,
        paginationVAlign: 'bottom',
        paginationHAlign: 'right',
        paginationDetailHAlign: 'left',
        paginationPreText: '上一页',
        paginationNextText: '下一页',
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                sort: params.sort,
                sortOrder: params.order
            }
        },
        responseHandler: function (res) {
            return {
                total: res.data.total,
                rows: res.data.list
            };
        },
        columns: [
            {
                field: 'id',
                title: '编号',
                align: 'center'
            },
            {
                field: 'name',
                title: '类型名称',
                align: 'center'
            },
            {
                field: 'status',
                title: '状态',
                align: 'center',
                formatter: function (value,row,index) {
                    if (value == 1) {
                        return "启用";
                    } else if (value == 2) {
                        return "禁用"
                    }
                }
            },
            {
                field: 'explain',
                title: '操作',
                align: 'center',
                formatter: function (value, row, index) {
                    return "<a type='button' onclick='openProductTypeEditModel(" + row.id + ")' class='btn common-btn'>编辑</a>" +
                        "<a type='button' onclick='productTypeDelete(" + row.id + ")' class='btn common-btn' >删除</a>" +
                        "<a type='button' onclick='modifyStatus(" + row.id + ")' class='btn common-btn' >修改状态</a>"
                }
            }
        ]
    });

    $table.bootstrapTable('resetView', {
        height: $(window).height() - 155
    });

    // $(window).resize(function () {
    //     　　$table.bootstrapTable('resetView');
    // });

    $(window).resize(function () {
        // console.log("innerHeight:"+$(window).innerHeight());
        // console.log("height:"+$(window).height());
        $table.bootstrapTable('resetView', {
            height: $(window).height() - 155
        });
    });

})






