/**
 * Created by libin on 2017/12/5.
 */
var layer;
$(function () {
    layui.use('layer', function () {
        layer = layui.layer;
    })
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#day'//指定元素
        });
        laydate.render({
            elem: '#timeBegin'//指定元素
            , type: 'time'
        });
        laydate.render({
            elem: '#timeEnd'//指定元素
            , type: 'time'
        });
    })
    var data = {};
    $.get("/numPicker/getMaxNum", data, function (data, status) {
        console.log("getMax status :" + status);
        if (status === "success") {
        } else {
        }
    }, "json");

    layui.use('form', function () {
        form = layui.form;
        form.render();
        form.on('submit(demo)', function (data) {
            if (data.field.day == "" || data.field.timeBegin == "" || data.field.timeEnd == "") {
                layer.msg('请正确选择时间', {icon: 2, time: 1500})
                return false;
            }

            window.location.href = "/admin/downloadByTime/" + data.field.day + "/" + data.field.timeBegin + "/" + data.field.timeEnd + "/" + data.field.place;
            //     $.ajax({
            //         type: 'POST',
            //         dataType: 'json',
            //         url: '/admin/downloadByTime',
            //         contentType: 'application/json',
            //         data: JSON.stringify(data.field),
            //         success: function (data) {
            //             layer.msg("tesst", {icon: 1, time: time})
            //         },
            //         error: function (xhr, type) {
            //             layer.msg('添加失败,请核对数据格式。', {icon: 2, time: time})
            //         }
            //     })
            return false;
        });
    })

    $("#scoreSearch").click(function () {
        $.ajax({
            type: 'GET',
            url: '/admin/queryResult',
            dataType: 'json',
            data: {
                serialNumber: $("#serialNumber").val(),
                place: $("#place").val()
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
                    var obj = data.msg;
                    var ob = $.parseJSON(obj.toString());
                    console.log(ob.length)
                    for (i = 1; i < 4; i++) {
                        $("#reviewer" + i).empty();
                        $("#dominantScore" + i).empty();
                        $("#secondaryScore" + i).empty();
                        $("#sightsingingScore" + i).empty();
                        $("#scoreTime" + i).empty();

                    }
                    for (i = 1; i < ob.length + 1; i++) {
                        $("#reviewer" + i).html(ob[i - 1].reviewer);
                        $("#dominantScore" + i).html(ob[i - 1].dominantScore);
                        $("#secondaryScore" + i).html(ob[i - 1].secondaryScore);
                        $("#sightsingingScore" + i).html(ob[i - 1].sightsingingScore);
                        $("#scoreTime" + i).html(format(ob[i - 1].scoreTime));
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
                $("#result").html("A考场抽取最大号" + data.operation + ",B考场抽取最大号" + data.msg + "");
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
                $("#result").html("A考场正在考试人序号" + data.operation + ",B考场正在考试人序号" + data.msg + "");
            },
            error: function (xhr, type) {
                layer.msg('查询失败', {icon: 2, time: 1500})
            }
        })
    })
    $("#ModifyReviewerPwd").click(function () {
        layer.confirm("是否要将密码初始为" + $("#pwd").val(), {
            btn: ['确认提交', '取消提交'] //按钮
        }, function () { //确认方法
            $.ajax({
                type: 'GET',
                url: '/admin/ModifyReviewerPwd',
                data: {
                    pwd: $("#pwd").val()
                },
                dataType: 'json',
                success: function (data) {
                    if(data.state==1){
                        layer.alert('密码初始化成功！', {
                            icon: 1,
                            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                        })
                    }else{
                        layer.alert('密码初始化失败', {
                            icon: 2,
                            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                        })
                    }

                },
                error: function (xhr, type) {
                    layer.alert('密码初始化失败', {
                        icon: 2,
                        skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
                    })
                }
            })

        }, function () { //取消方法

        });


    })
})
//时间戳转时间格式
function add0(m){return m<10?'0'+m:m }
function format(shijianchuo)
{
//shijianchuo是整数，否则要parseInt转换
    var time = new Date(shijianchuo);
    var y = time.getFullYear();
    var m = time.getMonth()+1;
    var d = time.getDate();
    var h = time.getHours();
    var mm = time.getMinutes();
    var s = time.getSeconds();
    return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}