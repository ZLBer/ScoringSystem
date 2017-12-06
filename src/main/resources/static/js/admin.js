/**
 * Created by libin on 2017/12/5.
 */
var layer;
$(function () {
    layui.use('layer', function () {
        layer = layui.layer;
    })

    $("#scoreSearch").click(function () {
        $.ajax({
            type: 'GET',
            url: '/admin/queryResult',
            dataType: 'json',
            data: {
                examNumber: $("#examNumber").val()
            }
            ,
            success: function (data) {
                //数据更新失败
                if (data.state == 0) {
                    layer.msg(data.msg, {icon: 2, time: 1500});
                    return false;
                }
                //数据更新成功
                else {
                    layer.msg('查询成功', {icon: 1, time: 1500});
                    var obj=data.msg;
                    var ob = $.parseJSON(obj.toString());
                    for(i=1;i<4;i++){
                        $("#reviewer"+i).html(ob[i-1].reviewer);
                        $("#dominantScore"+i).html(ob[i-1].dominantScore);
                        $("#secondaryScore"+i).html(ob[i-1].secondaryScore);
                        $("#sightsingingScore"+i).html(ob[i-1].sightsingingScore);
                    }

                }
            },
            error: function (xhr, type) {
                layer.msg('查询失败', {icon: 2, time: 1500})
            }
        })
    })
    $("#numPickSearch").click(function () {
        $.ajax({
            type: 'GET',
            url: '/admin/rateNumPick',
            dataType: 'json',
            success: function (data) {
                    layer.msg('查询成功', {icon: 1, time: 1500});
                  $("#result").html("A考场抽号"+data.operation+"人,B考场抽号"+data.msg+"人");
            },
            error: function (xhr, type) {
                layer.msg('查询失败', {icon: 2, time: 1500})
            }
        })
    })
    $("#examSearch").click(function () {
        $.ajax({
            type: 'GET',
            url: '/admin/rateExam',
            dataType: 'json',
            success: function (data) {
                layer.msg('查询成功', {icon: 1, time: 1500});
                $("#result").html("A考场已考试"+data.operation+"人,B考场已考试"+data.msg+"人");
            },
            error: function (xhr, type) {
                layer.msg('查询失败', {icon: 2, time: 1500})
            }
        })
    })
})