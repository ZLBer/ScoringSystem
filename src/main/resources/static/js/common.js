var layer;
var element;
var table;
var form;


$(function () {
    //调用layer模块

    layui.use('layer',function () {
        layer = layui.layer;
    })
    layui.use('element',function () {
        element = layui.element;
    })
    layui.use('form',function () {
        form = layui.form;
        form.render();
        form.on('submit(demo1)', function(data){
            var time = 1500;
            // layer.alert(JSON.stringify(data.field), {
            //     title: '最终的提交信息'
            // })
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url:'/admin/addPerson',
                contentType:'application/json',
                data:JSON.stringify(data.field) ,
                success: function(data){
                    layer.msg(data.msg,{icon:1,time:time})
                },
                error: function(xhr, type){
                    layer.msg('添加失败,请核对数据格式。',{icon:1,time:time})
                }
            })
            return false;
        });
       form.on('checkbox(selectAll1)', function(data){
           console.log(data.elem)
           var child = $(data.elem).parents('div').find(' input[name="informationBasic"]');
           child.each(function(index, item){
               item.checked = data.elem.checked;
           });
           form.render('checkbox');
           // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
       });
        form.on('checkbox(selectAll2)', function(data){
            console.log(data.elem)
            var child = $(data.elem).parents('div').find(' input[name="informationPolitics"]');
            child.each(function(index, item){
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
            // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });
        form.on('checkbox(selectAll3)', function(data){
            console.log(data.elem)
            var child = $(data.elem).parents('div').find(' input[name="informationOriginal"]');
            child.each(function(index, item){
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
            // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });
        form.on('checkbox(selectAll4)', function(data){
            console.log(data.elem)
            var child = $(data.elem).parents('div').find(' input[name="informationPresent"]');
            child.each(function(index, item){
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
            // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });
        form.on('checkbox(selectAll5)', function(data){
            console.log(data.elem)
            var child = $(data.elem).parents('div').find(' input[name="informationContact"]');
            child.each(function(index, item){
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
            // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });
        form.on('checkbox(selectAll6)', function(data){
            console.log(data.elem)
            var child = $(data.elem).parents('div').find(' input[name="informationSupplement"]');
            child.each(function(index, item){
                item.checked = data.elem.checked;
            });
            form.render('checkbox');
            // layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
        });
    })
    layui.use('table', function(){
        table = layui.table;
        table.on('edit(test)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            // layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
            $.ajax({
                type: 'POST',
                dataType: 'json',
                url:'/admin/updatePerson',
                contentType:'application/json',
                data:JSON.stringify(data) ,
                success: function(data){
                    layer.msg(data.msg,{icon:1,time:1500})
                },
                error: function(xhr, type){
                    layer.msg('修改失败,请核对数据格式。',{icon:1,time:1500})
                }
            })
        });
    });
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#birthday'//指定元素
        });
        laydate.render({
            elem: '#joinpartyTime'
        });
        laydate.render({
            elem:'#conversionTime'
        });
        laydate.render({
            elem:'#timeWork'
        });
        laydate.render({
            elem:'#timeRetirement'
        });
        laydate.render({
            elem:'#timeBasicparty'
        });
        laydate.render({
            elem:'#endtimeBasicparty'
        });
        laydate.render({
            elem:'#timeAdministration'
        });
        laydate.render({
            elem:'#endtimeAdministration'
        });
        laydate.render({
            elem:'#timeCommittee'
        });
        laydate.render({
            elem:'#endtimeCommittee'
        });
        laydate.render({
            elem:'#timeSteering'
        });
        laydate.render({
            elem:'#endtimeSteering'
        });
        laydate.render({
            elem:'#timeOrganization'
        });
        laydate.render({
            elem:'#endtimeOrganization'
        });
        laydate.render({
            elem:'#timeCorporation'
        });
        laydate.render({
            elem:'#endtimeCorporation'
        });
    });
    bindAjaxSubmitTo($("#modifyPwd>#submit"),"/modifyPwd");
    bindAjaxSubmitTo($("#personalInfo>#submit"),"/student/perfectPersonalInfo");
    bindAjaxSubmitTo($("#addSubject>#submit"),"/teacher/saveSubject");
    progressbar();
    //bindAjaxSubmitTo($("#test>#submit"),"/student/dotest");
});
//通用绑定按钮异步提交操作
function bindAjaxSubmitTo(element,url) {
    var time = 1500;
    element.on("click",function () {
        var inputs = element.siblings("input");
        var selectors = element.siblings("select");
        var param = {};
        for(var i=0;i<inputs.length;i++){
            var input = $(inputs[i]);
            param[input.attr("name")]=input.val();
        }
        for(var i=0;i<selectors.length;i++){
            var input = $(selectors[i]);
            param[input.attr("name")]=input.val();
        }
        $.post(url,param,function (data,status) {
            if(status==="success") {
                if (data.state == 1) {
                    layer.msg(data.msg, {icon: 1, time:time})
                }else{
                    layer.msg(data.msg, {icon: 2, time: time})
                }
            }else{
                layer.msg('请求失败，请重试',{icon:2,time:time})
            }
        })
    })
}
function seletAll(element){
   element.click(  function(){
        var checkboxName="i"+element.prop("name");
        if(this.checked){
            $("input[name="+checkboxName+"]").prop('checked', true)
        }else{
            $("input[name="+checkboxName+"]").prop('checked', false)
        }
    })
}

function progressbar() {
    var time = 1500;

    $("#submitExcel").click( function(){
        layer.msg('正在上传，请勿关闭页面，等待成功提示。',{icon:1,time:time})
        $.ajax({
            url: "/admin/uploadExcel",
            type: 'POST',
            cache: false,
            data: new FormData($('#infoLogoForm')[0]),
            processData: false,
            contentType: false,
            dataType:"json",
            success : function(data) {
                if (data.state == 1) {
                    layer.msg('数据处理成功！',{icon:1,time:time})
                  //   $("#percent").show();
                  // var  interval= window.setInterval(function(){
                  //       $.ajax({
                  //           url: "/admin/percent",
                  //           type: 'GET',
                  //           processData: false,
                  //           contentType: false,
                  //           dataType:"json",
                  //           success : function(data) {
                  //               if (data.state == 1) {
                  //
                  //                   if(data.msg="100%")
                  //                   clearInterval(interval);
                  //                   element.progress('percentChildren',data.msg)
                  //               }
                  //               }
                  //           })
                  //
                  //   },1000);
                } else {
                    layer.msg('请求失败，请重试',{icon:2,time:time})
                }
            },
            error: function(xhr, type){
                layer.msg('上传失败,请核对上传列与所选列的并核对数据格式',{icon:2,time:time})
            }
        }).on(function () {

        });
    });
}