/**
 * Created by libin on 2017/11/25.
 */
var layer;
$(function () {
    layui.use('layer', function () {
        layer = layui.layer;
    })
    var socket;
    if (typeof(WebSocket) == "undefined") {
        alert("您的浏览器不支持WebSocket");

    }
    socket = new WebSocket("ws://" + window.location.host + "/myHandler");
    //打开事件
    socket.onopen = function () {
        layer.alert('已成功连接至服务器', {
            icon: 1,
            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
        })
        //socket.send("这是来自客户端的消息" + location.href + new Date());
    };
    //获得消息事件
    socket.onmessage = function (msg) {
        var obj = msg.data;
        var ob = $.parseJSON(obj.toString());
        fillInfo(ob);
    };
    //关闭事件
    socket.onclose = function () {
        layer.alert('与服务器断开链接，请联系管理员', {
            icon: 2,
            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
        })
    };

    //发生了错误事件
    socket.onerror = function () {
        layer.alert('发生错误，请联系管理员', {
            icon: 2,
            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
        })
    };
    //发送消息
    $("#btnSubmit").click(function () {
        submitScore(socket)
        //     if(submitScore()==true) socket.send("reviewerSubmit");


    });

    //关闭
    $("#btnClose").click(function () {
        socket.close();
    });

})
function fillInfo(obj) {
    var time = 2000;
    if (obj.code == "fail") {
        layer.msg(obj.reason, {icon: 2, time: time})
    }
    else if (obj.code == "info") {
        $("#serialNumber").html(obj.serialNumber);
        $("#photo").attr('src',"/image/" + obj.examNumber + ".jpg");
        $("#dominantTerm").html(obj.dominantTerm);
        $("#secondaryTerm").html(obj.secondaryTerm);
        $("#sightsinging").html(obj.sightsinging);
        $("#examNumber").val(obj.examNumber);
        $("#place").val(obj.place);
    }
    else if (obj.code == "cond") {
        if (obj.reviewer == "1")
            switch (obj.status) {
                case "0": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-primary indicator");
                    $("#reviewer1").html("评委一（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-danger indicator");
                    $("#reviewer1").html("评委一（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-normal indicator");
                    $("#reviewer1").html("评委一（已打分）");
                }
            }
        else if (obj.reviewer == "2")
            switch (obj.status) {
                case "0": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-primary indicator");
                    $("#reviewer2").html("评委二（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-danger indicator");
                    $("#reviewer2").html("评委二（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-normal indicator");
                    $("#reviewer2").html("评委二（已打分）");
                }
            }
        if (obj.reviewer == "3")
            switch (obj.status) {
                case "0": {
                    $("#reviewer3").attr("class", "layui-btn layui-btn-primary indicator");
                    $("#reviewer3").html("评委三（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer3").attr("class", "layui-btn-big layui-btn-danger indicator");
                    $("#reviewer3").html("评委三（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer3").attr("class", "layui-btn-big layui-btn-normal indicator");
                    $("#reviewer3").html("评委三（已打分）");
                }
            }
    }

}
function submitScore(socket) {
    $.ajax({
        type: 'POST',
        url: '/reviewer/scoreSubmit',
        dataType: 'json',
        data: {
            serialNumber: $("#serialNumber").html(),
            dominantScore: $("#dominantScore").val(),
            secondaryScore: $("#secondaryScore").val(),
            sightsingingScore: $("#sightsingingScore").val(),
            reviewer:$("#reviewer").val(),
            examNumber:$("#examNumber").val(),
            place:$("#place").val()
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
                layer.msg(data.msg, {icon: 1, time: 1500});
                $("#serialNumber").empty();
                $("#dominantScore").val("");
                $("#secondaryScore").val("");
                $("#sightsingingScore").val("");
                $("#photo").html("");
                $("#dominantTerm").empty();
                $("#secondaryTerm").empty();
                $("#sightsinging").empty();
                $("#photo").attr('src',"");
                socket.send("reviewerSubmit");
            }
        },
        error: function (xhr, type) {
            layer.msg('提交失败,请核对数据格式。', {icon: 2, time: 1500})
        }
    })
}