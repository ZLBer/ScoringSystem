package test.controller;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.domain.Result;
import test.domain.Score;
import test.service.IAdminService;
import test.service.ISuadminService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by libin on 2017/10/27.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    IAdminService adminService;

    @GetMapping("/queryResult")
    @ResponseBody
    public Result queryResult(@Param("examNumber") String examNumber){
        List<Score> scores= adminService.queryResult(examNumber);
        if(scores.size()==0) return new Result(0,"","该生暂未考试");
        else return new Result(1,"", JSON.toJSONString(scores));
    }
    @GetMapping("/rateNumPick")
    @ResponseBody
    public Result rateNumPick(){
        return  new Result(1,adminService.rateNumPick(0)+"",adminService.rateNumPick(1)+"");
    }
    @GetMapping("/rateExam")
    @ResponseBody
    public Result rateExam(){
        return  new Result(1,adminService.rateExam(0)+"",adminService.rateExam(1)+"");
    }
}
