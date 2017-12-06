/**
 * Created by libin on 2017/11/24.
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
        // alert(msg.data);
        //   var obj= $.parseJSON(msg.data);
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
        layer.alert('与服务器断开链接，请联系管理员', {
            icon: 2,
            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
        })
    };
    //发送消息
    $("#btnSend").click(function () {
        socket.send("guardQuery" + $("#serialNumber").val());
    });

    //关闭
    $("#btnSubmit").click(function () {
        socket.send("guardSubmit" + $("#serialNumber").val());
    });
})

function fillInfo(obj) {
    var time = 2000;
    if (obj.code == "fail") {
        layer.msg(obj.reason, {icon: 2, time: time})
    }
    else if (obj.code == "info") {
        $("#serialNumber").val(obj.serialNumber);
        $("#photo").attr('src',"/image/" + obj.examNumber + ".jpg");
        $("#dominantTerm").html(obj.dominantTerm);
        $("#secondaryTerm").html(obj.secondaryTerm);
        $("#sightsinging").html(obj.sightsinging);
    }
    else if (obj.code == "cond") {
        if (obj.reviewer == "1")
            switch (obj.status) {
                case "0": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-primary btn");
                    $("#reviewer1").html("评委一（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-danger btn");
                    $("#reviewer1").html("评委一（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-normal btn");
                    $("#reviewer1").html("评委一（已打分）");
                }
            }
        else if (obj.reviewer == "2")
            switch (obj.status) {
                case "0": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-primary btn");
                    $("#reviewer2").html("评委二（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-danger btn");
                    $("#reviewer2").html("评委二（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-normal btn");
                    $("#reviewer2").html("评委二（已打分）");
                }
            }
        if (obj.reviewer == "3")
            switch (obj.status) {
                case "0": {
                    $("#reviewer3").attr("class", "layui-btn layui-btn-primary btn");
                    $("#reviewer3").html("评委三（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer3").attr("class", "layui-btn layui-btn-danger btn");
                    $("#reviewer3").html("评委三（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer3").attr("class", "layui-btn layui-btn-normal btn");
                    $("#reviewer3").html("评委三（已打分）");
                }
            }
    }

}