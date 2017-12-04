package test.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.domain.Result;
import test.service.IReviewerService;

import javax.annotation.Resource;

/**
 * Created by libin on 2017/11/27.
 */
@Controller
@RequestMapping("/reviewer")
public class ReviewerController {
         @Resource
    IReviewerService  reviewerService;
    @GetMapping("/main")
    String  main(Model model){
        model.addAttribute("bodyRightContent", "reviewer/main");
        return "main";
    }
         @ResponseBody
    @RequestMapping("/scoreSubmit")
    public Result scoreSubmit(@Param("serialNumber") String serialNumber,@Param("dominantScore") String dominantScore,@Param("secondaryScore") String secondaryScore,@Param("sightsingingScore") String sightsingingScore,@Param("reviewer") String reviewer){
           boolean rt=  reviewerService.saveScore(Integer.parseInt(serialNumber),dominantScore,secondaryScore,sightsingingScore,reviewer);
        if(rt==true)
             return new Result(1,"","成绩提交成功！");
        else  return new Result(0,"","提交失败，数据格式错误！");
         }


}
