package test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import test.GlobalVariance;
import test.domain.Login;
import test.domain.Result;
import test.domain.Score;
import test.mapper.LoginMapper;
import test.mapper.ScoreMapper;
import test.service.IAdminService;
import test.service.ISuadminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by libin on 2017/10/27.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    IAdminService adminService;
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    LoginMapper loginMapper;
    @GetMapping("/main")
    public String toMainBoard(Model model){
        model.addAttribute("bodyRightContent", "admin/main");
        return "main";
    }
    @GetMapping("/queryResult")
    @ResponseBody
    public Result queryResult(@Param("place") Integer place,@Param("serialNumber") int serialNumber){
        List<Score> scores= adminService.queryResultBySerialNumber(place,serialNumber);
        if(scores.size()==0) return new Result(0,"","该生暂未考试");
        else return new Result(1,"", JSON.toJSONString(scores));
    }
    @GetMapping("/rateNumPick")
    @ResponseBody
    public Result rateNumPick(){
        return  new Result(1, GlobalVariance.MAX_SELECTED_NUM[0]+"",GlobalVariance.MAX_SELECTED_NUM[1]+"");
    }
    @GetMapping("/rateExam")
    @ResponseBody
    public Result rateExam(){
        return  new Result(1,GlobalVariance.SERIALNUMBER_EXAMING_A+"",GlobalVariance.SERIALNUMBER_EXAMING_B+"");
    }

    @RequestMapping("/downloadByTime/{day}/{timeBegin}/{timeEnd}/{place}")
    public String  downloadByTime(@PathVariable("day") String day,@PathVariable("timeBegin")String timeBegin,@PathVariable("timeEnd")String timeEnd,@PathVariable("place")Integer place,HttpServletResponse response, Model model){
        //System.out.println(param);
//        JSONObject jo=new JSONObject();
//        Map<String, String> m=(Map<String, String>)jo.parse("{\"place\":\"0\",\"day\":\"2017-12-05\",\"timeBegin\":\"00:00:00\",\"timeEnd\":\"23:00:00\"}"); //string转map
//        List<Score>  s=    scoreMapper.groupByReviewer(m.get("day")+" "+m.get("timeBegin"),m.get("day")+" "+m.get("timeEnd"),Integer.parseInt(m.get("place")));
//        System.out.println(s.get(1).getDominantScore());
//         adminService.queryScore(m.get("day")+" "+m.get("timeBegin"),m.get("day")+" "+m.get("timeEnd"),Integer.parseInt(m.get("place")));
        response.setHeader("Content-Disposition", "attachment;filename=score.xls");
        response.setHeader("content-type","application/vnd.ms-excel");
        model.addAttribute("place" ,place==0?"A":"B");
        model.addAttribute("dsay",day);
        model.addAttribute("timeBegin",timeBegin);
        model.addAttribute("timeEnd",timeEnd);
        model.addAttribute("scores",adminService.queryScore(day+" "+timeBegin,day+" "+timeEnd,place));
        return "score.xml";
    }
    @GetMapping("toModifyReviewerPwd")
    public  String toModifyReviewerPwd(Model model){
        model.addAttribute("bodyRightContent", "admin/ModifyReviewerPwd");
        return "main";
    }

    @GetMapping("ModifyReviewerPwd")
    @ResponseBody
    public  Result ModifyReviewerPwd(@Param("pwd") String pwd){
        System.out.println(pwd);
if(loginMapper.updateReviwerPwd(pwd)>0)
    return new Result(1,"","");
else return new Result(0,"","");
    }

    @GetMapping("toCleanStu")
    public  String toCleanStu(Model model){
        model.addAttribute("bodyRightContent", "admin/cleanStu");
        return "main";
    }
    @GetMapping("cleanStu")
    public  String cleanStu(@Param("place") Integer place, Model model, HttpSession session){
        Login login=(Login) session.getAttribute("user");
        if(login.getCategory().equals(GlobalVariance.USER_ADMIN)){
            if(place==0)
                GlobalVariance.SERIALNUMBER_EXAMING_A=-1;
            else if(place==1)
                GlobalVariance.SERIALNUMBER_EXAMING_B=-1;
        }
        model.addAttribute("result","考场信息清空成功！");
        model.addAttribute("bodyRightContent", "admin/result");
        return "main";
    }
    @GetMapping("/numPicker/goExamNum")
    public  String  goExamNum(Model model){
        model.addAttribute("bodyRightContent", "numPicker/examNum");
        return "main";
    }
}
