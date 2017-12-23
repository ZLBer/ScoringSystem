package test.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.GlobalVariance;
import test.domain.*;
import test.service.INumPicker;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;

@RestController
public class NumPickerController {
    private static final Logger logger = LoggerFactory.getLogger(NumPickerController.class);
    @Resource
    private INumPicker numPickerService;
    private final ObjectMapper mapper;
    @Autowired
    public NumPickerController(ObjectMapper mapper) {
        this.mapper = mapper;
    }
    @GetMapping("/numPicker/getMaxNum")
    public int[] getMaxNum(){
        logger.info("获取最大值操作");
        numPickerService.getAndUpdateMaxValue();
        return GlobalVariance.MAX_SELECTED_NUM;
    }
    @PostMapping("/numPicker/save")
    public Result save(HttpServletRequest request){
        String jsonStr = request.getParameter("jsonStr");
        try {
            Information stu = mapper.readValue(jsonStr,Information.class);
            numPickerService.save(stu);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.CreateFailureResult();
        }
        return Result.CreateSuccessResult();
    }
    @PostMapping("/numPicker/add")
    public Result addToList(HttpServletRequest request){
        String jsonStr = request.getParameter("jsonStr");
        logger.info("add收到的json串为："+jsonStr);
        try {
            Information stu = mapper.readValue(jsonStr,Information.class);
            numPickerService.addToList(stu);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.CreateFailureResult();
        }
        return Result.CreateSuccessResult();
    }
    @PostMapping("/numPicker/allocate")
    public Result allocateNum(HttpServletRequest request){
        String jsonStr = request.getParameter("jsonStr");
        int place = Integer.parseInt(request.getParameter("place"));
        try {
            int[] stu = mapper.readValue(jsonStr,int[].class);
            numPickerService.allocateNumToList(place,stu);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.CreateFailureResult();
        }
        return Result.CreateSuccessResult();
    }
    @GetMapping("/numPicker/getListInfo")
    public LinkedList[] getListInfo(){
        logger.info("开始获取列表操作");
        return GlobalVariance.WaitList;
    }
    @GetMapping("/numPicker/search")
    public Information search(HttpServletRequest request){
        String examId = request.getParameter("examId");
        logger.info("要查询的考试号为："+examId);
        return numPickerService.query(examId);
    }
    @GetMapping("/numPicker/hasExam")
    public boolean hasExamed(HttpServletRequest request){
        String examId = request.getParameter("examId");
        return numPickerService.hasExamed(examId);
    }
    @PostMapping("/numPicker/delete/{place}/{examId}")
    public Result delete(@PathVariable("place")int place,@PathVariable("examId")String examId){
        try{
            logger.debug("执行delete操作");
            numPickerService.delete(examId,place);
        }catch (Exception e){
            return Result.CreateFailureResult();
        }
        return Result.CreateSuccessResult();
    }
    //未完
    private Information createInfo(HttpServletRequest request){
        Class<Information> infoClass = Information.class;
        Field[] fields = infoClass.getDeclaredFields();
        String[] methodName = new String[fields.length];
        int i=0;
        for (Field field:fields){
            String fieldName = field.getName();
            methodName[i] = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1,fieldName.length());
        }
        return null;
    }
}
