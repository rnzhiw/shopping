var $table = $("#account_table");

//弹出删除商品类型模态框(bootstrap-table实现)
function productDelete(id) {
    $('#delete_product_modal').modal("show");
    $('#delete_product_id').val(id);
}

//商品删除
$('#do_delete_product_btn').click(function () {
    $.ajax({
        url: "/userplat/product/delete",
        type: "post",
        data: {
            id: $("#delete_product_id").val()
        },
        success: function (res) {
            // alert(id);
            if (res.success) {
                $("#delete_product_modal").modal("hide");
                $table.bootstrapTable('refresh');
            } else {
                alert(res.message);
                $("#delete_product_modal").modal("hide");
            }
        },
        //前端没有发送成功
        error: function() {
            alert("删除失败");
        }
    });
});

//弹出添加商品类型模态框
$("#doAddPro").on("click", function() {
    _this = this; //this是事件源
    $("#Product").modal("show");
});




//列出商品类型列表
$(function () {
    $table.bootstrapTable({
        url: '/userplat/product/list',
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
                title: '商品名称',
                align: 'center'
            },
            {
                field: 'price',
                title: '商品价格',
                align: 'center'
            },
            {
                field: 'status',
                title: '状态',
                align: 'center',
                formatter: function (value,row,index) {
                    if (value == 1) {
                        return "有效商品";
                    } else if (value == 2) {
                        return "无效商品"
                    }
                }
            },
            {
                field: 'productType',
                title: '商品类型',
                align: 'center',
                formatter: function(value,row,index) {
                    return "<div href=''></div>"
                }
            },
            {
                field: 'explain',
                title: '操作',
                align: 'center',
                formatter: function (value, row, index) {
                    return "<a type='button' onclick='openProductEditModel(" + row.id + ")' class='btn common-btn'>编辑</a>" +
                        "<a type='button' onclick='productDelete(" + row.id + ")' class='btn common-btn' >删除</a>" +
                        "<a type='button' onclick='modifyProductStatus(" + row.id + ")' class='btn common-btn' >修改状态</a>"
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






