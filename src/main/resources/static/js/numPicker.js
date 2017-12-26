$(function () {
    numPicker = new NumPicker();
    numPicker.init();
});
function NumPicker() {
    var photosDir = '/photos/';
    var hasWait = [0,0];
    var waitNumId = ["#waitA","#waitB"];
    var formArea = "#infoForm";
    var waitListId = ["#listA","#listB"];
    var searchInput = "#searchInput";
    var searchButton = "#search";
    var saveButton = "#save";
    var addToListButton = "#add";
    var alloAButton = "#alloA";
    var alloBButton = "#alloB";
    var printALButton = "#printA";
    var printBLButton = "#printB";
    var maxId = ["#maxA","#maxB"];
    var templateDir = "/numPicker";
    var searchUrl = "/search";
    var saveUrl = "/save";
    var conformListUrl = "/allocate";
    var addUrl = "/add";
    var getMaxUrl = "/getMaxNum";
    var getListUrl = "/getListInfo";
    var hasExamedUrl = "/hasExam";
    var deleteUrl = "/delete";
    var time = 1000;
    var waitList = [[],[]];
    var serialNum = [2];
    var max = [0,0];
    this.init = function () {
        cleanTips();
        updateList();
        getMaxNum();
        bindEvent();
    };
    var tmpStu = {
        examNumber: "",
        serialNumber: "",
        name: "",
        sex: "",
        phoneNumber: "",
        homeAddress: "",
        idNumber: "",
        faculty: "",
        dominantTerm: "",
        dominantInstrument: "",
        dominantSong: "",
        secondaryTerm: "",
        secondaryInstrument: "",
        secondarySong: "",
        sightsinging: "",
        entranceTime: "",
        place: "",
        hasExam:""
    };
    /**
     * 将对象中的数据更新到页面中
     */
    var showInfoData = function () {
        for (var a in tmpStu) {
            if (a==="place") {continue}
            $(formArea).find("input[name=" + a + "]").val(tmpStu[a]);
        }
        //显示照片
        $('img').attr('src',photosDir+tmpStu.examNumber+'.jpg');
        layui.use('form',function () {
            var form = layui.form;
            form.render();
        });
    };
    /**
     * 将页面中的数据更新到临时对象中
     */
    var updateTmpStu = function () {
        var inputs = $(formArea).find("input");
        for (var i = 6; i < inputs.length-2; i++) {
            tmpStu[inputs[i].name] = inputs[i].value;
        }
        var place = $("input:radio:first").next().hasClass("layui-form-radioed")?0:1;
        tmpStu["place"] = place;
    };
    /**
     * 处理返回Result对象的结果
     */
    var result = function (result) {
        layui.use('layer', function(){
            var layer = layui.layer;
            if (result.state===0) {
                layer.msg(result.msg, {icon: 1,time:time});
            }else{
                layer.msg(result.msg, {icon: 2,time:time});
            }
        });
    };
    /**
     * 绑定事件 应该在页面打开时执行一次
     */
    var bindEvent = function () {
        $(searchButton).on('click', function () {
            search();
        });
        $(saveButton).on('click', save);
        $(addToListButton).on('click', function () {
            add();
        });
        $(alloAButton).on('click', function () {
            allocateNum(0);
        });
        $(alloBButton).on('click', function () {
            allocateNum(1);
        });
        $(printALButton).on('click', function () {
            printL(0);
        });
        $(printBLButton).on('click', function () {
            printL(1);
        });
    };
    /**
     * 查询函数
     */
    var search = function () {
        cleanTips();
        var examId = $(searchInput).val();
        console.log(examId);
        var url = templateDir + searchUrl;
        var data = {
            examId: examId
        };
        $.get(url, data, function (data, status) {
            console.log("search status :" + status);
            if (status === "success") {
                console.log("查询成功 "+JSON.stringify(data));
                tmpStu = data;
                hasAllo();
                hasExamed();
                showInfoData();
            } else {
                operationFailed("响应状态不为成功");
                console.error("查询请求失败");
            }
        }, "json");
    };
    /**
     * 将数据保存到后端的
     */
    var save = function () {
        updateTmpStu();
        var jsonStr = JSON.stringify(tmpStu);
        var url = templateDir + saveUrl;
        var data = {
            jsonStr: jsonStr
        };
        $.post(url, data, function (data, status) {
            console.log("save status :" + status);
            if (status === "success") {
                console.log("保存成功 "+data);
                result(data);
            } else {
                operationFailed("响应状态不为成功");
                console.error("保存请求失败");
            }
        }, "json");
    };
    /**
     * 获取最大值 应该在页面打开时执行一次
     */
    var getMaxNum = function () {
        var url = templateDir + getMaxUrl;
        var data = {};
        $.get(url, data, function (data, status) {
            console.log("getMax status :" + status);
            if (status === "success") {
                console.log("查询成功 "+data);
                for (var i=0;i<data.length;i++) {
                    $(maxId[i]).text(data[i]);
                    max[i] = data[i];
                }
            } else {
                operationFailed("响应状态不为成功");
                console.error("获取最大数请求失败");
            }
        }, "json");
    };
    /**
     * 在前段为某个等待栏随机分配序号
     */
    var allocateNum = function (place) {
        var items = $(waitListId[place]).find(".waitListItem");
        var a = [items.length];
        for (var i = 0; i < items.length; i++) {
            a[i] = max[place] + (1 + i);
        }
        shuffle(a);
        for (var i = 0; i < items.length; i++) {
            $(items[i]).find(".serialNum").text(a[i]);
        }
        serialNum[place] = a;
    };
    /**
     * 加入到等待栏中
     */
    var add = function () {
        updateTmpStu()
        if (tmpStu.hasExam===true){
            layui.use('layer',function () {
                var layer = layui.layer;
                layer.alert('该考生已经有考试记录，不允许再次分配序号', {
                    skin: 'layui-layer-molv' //样式类名
                    ,closeBtn: 0
                });
            });
            return;
        }
        if (!hasSightSing()){
            layui.use('layer',function () {
                var layer = layui.layer;
                layer.alert('该考生“视唱”为空！', {
                    skin: 'layui-layer-molv' //样式类名
                    ,closeBtn: 0
                });
            });
            return;
        }
        if (foundItems(0,tmpStu.examNumber)||foundItems(1,tmpStu.examNumber)){
            layui.use('layer',function () {
                var layer = layui.layer;
                layer.alert('该考生已经在队列里了', {
                    skin: 'layui-layer-molv' //样式类名
                    ,closeBtn: 0
                });
            });
            return;
        }
        var place = tmpStu.place;
        var jsonStr = JSON.stringify(tmpStu);
        var url = templateDir + addUrl;
        var data = {
            jsonStr: jsonStr
        };
        $.post(url, data, function (data, status) {
            console.log("save status :" + status);
            if (status === "success") {
                console.log("加入成功 "+data);
                result(data);
            } else {
                operationFailed("响应状态不为成功");
                console.error("添加请求失败");
            }
        }, "json");
        addAItem(tmpStu.examNumber,place);
        hasWait[place]++;
        updateHasWait(place);
    };
    /**
     * 打印指定列数据
     * @param place 栏位
     */
    var printL = function (place) {
        var jsonStr = JSON.stringify(serialNum[place]);
        var url = templateDir + conformListUrl;
        var data = {
            place:place,
            jsonStr: jsonStr
        };
        $.post(url, data, function (data, status) {
            console.log("save status :" + status);
            if (status === "success") {
                console.log("打印成功 "+data);
                updateMaxNum(place,serialNum[place].length);
                result(data);
            } else {
                operationFailed("响应状态不为成功");
                console.error("打印请求失败");
            }
        }, "json");
        window.open("/nums/"+place);
        cleanItems(place);
        hasWait[place] = 0;
        updateHasWait(place);
        max[place]+=waitList[place].length;
    };
    /**
     * 更新等待栏列表 打开页面时执行一次
     */
    var updateList = function () {
        cleanItems(0);
        cleanItems(1);
        var url = templateDir + getListUrl;
        var data = {};
        $.get(url, data, function (data, status) {
            console.log("save status :" + status);
            if (status === "success") {
                console.log("获取等待列表成功 "+JSON.stringify(data));
                for (var i=0;i<data.length;i++){
                    console.log(1+" "+data[i].length);
                    for (var j=0;j<data[i].length;j++){
                        addAItem(data[i][j].examNumber,i);
                        console.log(2);
                    }
                }
                console.log(3);
                hasWait[0] = waitList[0].length;
                hasWait[1] = waitList[1].length;
                console.log(4);
                updateHasWait(0);
                updateHasWait(1);
            } else {
                operationFailed("响应状态不为成功");
                console.error("获取列表请求失败");
            }
        }, "json");
    };
    /**
     * 向页面指定的等待栏中加一项
     * @param examid 考试号
     * @param place 栏位
     */
    var addAItem = function (examid,place) {
        var htmlStr = "<li id='"+examid+"' class=\"waitListItem\">"+examid+"<span class=\"delete\" onclick=\"deleteItem(this,"+place+")\">X</span><span class=\"serialNum\">空</span></li>";
        $(waitListId[place]).append(htmlStr);
        waitList[place].push(tmpStu);
    };
    /**
     * 清空指定的等待栏
     * @param place 栏位
     */
    var cleanItems = function (place) {
        waitList[place] = [];
        $(waitListId[place]).html("");
    };
    /**
     * 更新等待人数 打开页面时执行一次
     */
    var updateHasWait = function (place) {
        $(waitNumId[place]).val(hasWait[place]);
    };
    /**
     * 更新指定列的最大值
     * @param place 列号
     * @param num 新增数
     */
    var updateMaxNum = function (place,num) {
        $(maxId[place]).text((max[place]+=num))
    };
    /**
     * 生成excel表头
     */
    var generateExcelTitle = function(){
        var a = [
            {
                "value":"考试号",
                "type":"ROW_HEADER",
                "datatype":"string"
            },
            {
                "value":"姓名",
                "type":"ROW_HEADER",
                "datatype":"string"
            },
            {
                "value":"考场",
                "type":"ROW_HEADER",
                "datatype":"string"
            },
            {
                "value":"序号",
                "type":"ROW_HEADER",
                "datatype":"string"
            }
        ];
        JSON_DATA.title = a;
    };
    /**
     * 生成表数据
     * @param place 栏位
     */
    var generateExcelBody = function(place) {
        JSON_DATA.data.splice(0, JSON_DATA.data.length);
        for (var i=0;i<waitList[place].length;i++){
            var row = [];
            var data = ["examNumber","name","place","serialNumber"];
            for (var j=0;j<data.length;j++){
                console.info(waitList[place][i][data[j]]);
                var c = {
                    "value":waitList[place][i][data[j]],
                    "type":"String"
                };
                row.push(c);
            }
            JSON_DATA.data.push(row);
        }
    };
    /**
     * 下载栏位数据
     * @param place 栏位
     */
    var downloadExcel = function (place) {
        generateExcelBody(place);
        JSONToExcelConvertor(JSON_DATA.data,"信息表",JSON_DATA.title);
    };
    /**
     * 是否已经考试（有分数）
     */
    var hasExamed = function () {
        if (tmpStu.hasExam==true){
            operationFailed("注意：该考生已经有考试记录。")
            showExamTips();
        }
    };
    /**
     * 查询考生是否已经分配过序号
     */
    var hasAllo = function () {
        if (tmpStu.serialNumber>0){
            var place = tmpStu.place==0?'A':'B';
            $("input[name=placeInfo]").val(place+tmpStu.serialNumber);
            showSerialTips();
        }else{
            $("input[name=placeInfo]").val("未分配");
        }
    };
    /**
     * 清空提示
     */
    var cleanTips = function () {
        $("#hasExamTips").css('display','none');
        $("#hasSerialTips").css('display','none');
    };
    /**
     * 显示已考试提示
     */
    var showExamTips = function () {
        $("#hasExamTips").css("display","block");
        $("#hasSerialTips").css('display','none');
    };
    /**
     * 显示已分配提示
     */
    var showSerialTips = function () {
        $("#hasExamTips").css('display','none');
        $("#hasSerialTips").css('display','block');
    };
    /**
     * 删除等待的一项
     * @param place
     * @param examId
     */
    this.deleteItemFromServer = function(place,examId){
        var jsonStr = JSON.stringify(serialNum[place]);
        var url = templateDir + deleteUrl+"/"+place+"/"+examId;
        var data = {
        };
        $.post(url, data, function (data, status) {
            console.log("save status :" + status);
            if (status === "success") {
                console.log("删除请求发送成功 "+data);
                deleteItemFromLocal(place,examId);
                hasWait[place]--;
                updateHasWait(place);
                result(data);
            } else {
                operationFailed("响应状态不为成功");
                console.error("打印请求发送失败");
            }
        }, "json");
    };
    /**
     * 删除本都存储的元素
     * @param place
     * @param examId
     */
    var deleteItemFromLocal = function (place,examId) {
        var a = waitList[place];
        for (var i=0;i<a.length;i++){
            if (a[i].examNumber===examId){
                a.splice(i,1);
                break;
            }
        }
    };
    /**
     * 查找元素
     * @param place
     * @param examId
     * @returns {boolean}
     */
    var foundItems = function (place,examId) {
        console.log("在place"+place+"中查找")
        var a = waitList[place];
        for (var i=0;i<a.length;i++){
            if (a[i].examNumber===examId){
                return true;
            }
        }
        return false;
    }
    /**
     * 是否有视唱
     * @returns {boolean}
     */
    var hasSightSing = function () {
        return !(tmpStu.sightsinging === "" || tmpStu.sightsinging === undefined);
    }
}
/**
 * 操作失败弹出失败提示
 * @param msg 提示信息
 */
function operationFailed(msg) {
    layui.use('layer', function(){
        var layer = layui.layer;
        layer.msg(msg);
    });
}
/**
 * 数组乱序排序
 * @param a 排序数组
 */
function shuffle(a) {
    var len = a.length;
    for (var i = 0; i < len - 1; i++) {
        var index = parseInt(Math.random() * (len - i));
        var temp = a[index];
        a[index] = a[len - i - 1];
        a[len - i - 1] = temp;
    }
}
/**
 * 删除选定元素
 * @param place
 * @param element
 */
function deleteItem(element,place) {
    var examId = $(element).parent().attr('id');
    console.log("place："+place);
    console.log("examId："+examId);
    numPicker.deleteItemFromServer(place,examId);
    $(element).parent().remove()
}