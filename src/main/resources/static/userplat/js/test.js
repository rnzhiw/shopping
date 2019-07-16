var $table = $("#account_table");

//列出成员
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
                formatter: function (value) {
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
                    return "<a type='button' onclick='openMemberEditModel(" + row.id + ")' class='btn common-btn'>编辑</a>" +
                        "<a type='button' onclick='memberDelete(" + row.id + ")' class='btn common-btn' >删除</a>" +
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

    $('.selectpicker').selectpicker('refresh');
})