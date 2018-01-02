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
            offset: "t",
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
            offset: "t",
            icon: 2,
            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
        })
    };

    //发生了错误事件
    socket.onerror = function () {
        layer.alert('发生错误，请联系管理员', {
            offset: "t",
            icon: 2,
            skin: 'layer-ext-moon' //该皮肤由layer.seaning.com友情扩展。关于皮肤的扩展规则，去这里查阅
        })
    };
    //发送消息
    $("#btnSubmit").click(function () {

        layer.confirm(  " 主项成绩："+$("#dominantScore").val()+"<br>"+
          "副项成绩："+$("#secondaryScore").val()+"<br>"+
       "视唱成绩："+$("#sightsingingScore").val(), {
            offset: "t",
            btn: ['确认提交','取消提交'] //按钮
        }, function(){ //确认方法
            submitScore(socket)
        }, function(){ //取消方法

        });

    });


})
function fillInfo(obj) {
    var time = 2000;
    if (obj.code == "fail") {
        layer.msg(obj.reason, {icon: 2, time: time})
    }
    else if (obj.code == "info") {
        $("#serialNumber").html(obj.serialNumber);
        $("#photo").attr('src',"/photos/" + obj.examNumber + ".jpg");
        $("#dominantTerm").html(obj.dominantTerm+"  "+obj.dominantInstrument);
        $("#dominantSong").html(obj.dominantSong);
        $("#secondaryTerm").html(obj.secondaryTerm+" "+obj.secondaryInstrument);
        $("#secondarySong").html(obj.secondarySong);
        $("#sightsinging").html(obj.sightsinging);
        $("#examNumber").val(obj.examNumber);
        $("#place").val(obj.place);
    }
    else if (obj.code == "cond") {
        if (obj.reviewer == "1")
            switch (obj.status) {
                case "0": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-primary indicator");
                    $("#reviewer1").html("一号评委（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-danger indicator");
                    $("#reviewer1").html("一号评委（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer1").attr("class", "layui-btn layui-btn-normal indicator");
                    $("#reviewer1").html("一号评委（已打分）");
                }
            }
        else if (obj.reviewer == "2")
            switch (obj.status) {
                case "0": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-primary indicator");
                    $("#reviewer2").html("二号评委（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-danger indicator");
                    $("#reviewer2").html("二号评委（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer2").attr("class", "layui-btn layui-btn-normal indicator");
                    $("#reviewer2").html("二号评委（已打分）");
                }
            }
        if (obj.reviewer == "3")
            switch (obj.status) {
                case "0": {
                    $("#reviewer3").attr("class", "layui-btn layui-btn-primary indicator");
                    $("#reviewer3").html("三号评委（离线）");
                    break;
                }
                case "1": {
                    $("#reviewer3").attr("class", "layui-btn layui-btn-danger indicator");
                    $("#reviewer3").html("三号评委（在线）");
                    break;
                }
                case "2": {
                    $("#reviewer3").attr("class", "layui-btn layui-btn-normal indicator");
                    $("#reviewer3").html("三号评委（已打分）");
                }
            }
    }
    else  if(obj.code == "finish"){
        layer.msg('所有评委均评分完毕', {icon: 1, time: 1500})
        $("#serialNumber").empty();
        $("#dominantScore").val("");
        $("#secondaryScore").val("");
        $("#sightsingingScore").val("");
        $("#dominantTerm").empty();
        $("#dominantSong").empty();
        $("#secondaryTerm").empty();
        $("#secondarySong").empty();
        $("#sightsinging").empty();
        $("#photo").attr('src',"");
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
                layer.msg(data.msg, { offset: "t",icon: 2, time: 1500});
                return false;
            }
            //数据更新成功
            else {
                layer.msg(data.msg, { offset: "t",icon: 1, time: 1500});
                socket.send("reviewerSubmit"+$("#serialNumber").html());


            }
        },
        error: function (xhr, type) {
            layer.msg('提交失败,请核对数据格式。', { offset: "t",icon: 2, time: 1500})
        }
    })
}