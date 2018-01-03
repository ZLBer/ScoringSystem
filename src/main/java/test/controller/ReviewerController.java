package test.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.GlobalVariance;
import test.domain.Information;
import test.domain.Login;
import test.domain.Result;
import test.service.IGuardService;
import test.service.IReviewerService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by libin on 2017/11/27.
 */
@Controller
@RequestMapping("/reviewer")
public class ReviewerController {
    private static Logger logger = Logger.getLogger(ReviewerController.class);
         @Resource
    IReviewerService  reviewerService;
         @Resource
    IGuardService guardService;
    @GetMapping("/main")
    String  main(Model model,HttpSession session){
        installModel(model,session);
        model.addAttribute("bodyRightContent", "reviewer/board");
        return "main";
    }
         @ResponseBody
    @RequestMapping("/scoreSubmit")
    public Result scoreSubmit(@Param("serialNumber") String serialNumber,@Param("dominantScore") String dominantScore,@Param("secondaryScore") String secondaryScore,@Param("sightsingingScore") String sightsingingScore,@Param("reviewer") String reviewer,@Param("palce") int place,@Param("examNumber") String examNumber){

      if( reviewerService.checkIsSave(reviewer,examNumber)==true) {
          logger.info("评委"+reviewer+"给"+examNumber+"打分失败，已经给此考生打分");
          return new Result(0,"","您已经给此考生评分");
      }
      if(reviewerService.checkSubmitFromat(dominantScore,secondaryScore,sightsingingScore)==false) return new Result(0,"","请确保正确打分，打分格式为0-100范围内的整数。");
           boolean rt=  reviewerService.saveScore(examNumber,place,Integer.parseInt(serialNumber),dominantScore,secondaryScore,sightsingingScore,reviewer);
        if(rt==true){
            logger.info("评委"+reviewer+"给"+examNumber+"打分成功");
            return new Result(1,"","成绩提交成功！");
        }

        else { logger.info("评委"+reviewer+"给"+examNumber+"打分失败");
            return new Result(0,"","提交失败，数据格式错误！");
        }
         }

    /**
     * 每次登陆或者重新链接时，查询状态并注入Model
     * @param model
     * @param session
     */
    private  void  installModel(Model model,HttpSession session){
        Login login=(Login)session.getAttribute("user");
        if(login.getAccount().equals(GlobalVariance.ACCOUNT_REVIEWE_A1)||login.getAccount().equals(GlobalVariance.ACCOUNT_REVIEWE_A2)||login.getAccount().equals(GlobalVariance.ACCOUNT_REVIEWE_A3)){
            int serialNumber=GlobalVariance.SERIALNUMBER_EXAMING_A;
            if(serialNumber==-1) {
            //    model.addAttribute("place","序号：A");
                return;
            }
            else{
                Information information= guardService.getInfromationBySerialNubmerANDPlace(0,GlobalVariance.SERIALNUMBER_EXAMING_A);
                model.addAttribute("serialNumber",serialNumber);
                model.addAttribute("dominantTerm",information.getDominantTerm());
                model.addAttribute("dominantInstrument",information.getDominantInstrument());
                model.addAttribute("dominantSong",information.getDominantSong());
                model.addAttribute("secondaryTerm",information.getSecondaryTerm());
                model.addAttribute("secondaryInstrument",information.getSecondaryInstrument());
                model.addAttribute("secondarySong",information.getSecondarySong());
                model.addAttribute("sightsinging",information.getSightsinging());
                model.addAttribute("serialNumberExaming",serialNumber);
                model.addAttribute("place",0+"");
                model.addAttribute("examNumber",information.getExamNumber());
                model.addAttribute("photo","/photos/" + information.getExamNumber()+".jpg");
            }

        }
        else {
            int serialNumber=GlobalVariance.SERIALNUMBER_EXAMING_B;
            if(serialNumber==-1) {
            //    model.addAttribute("place","序号：B");
                return;
            }
            else{
                Information   information= guardService.getInfromationBySerialNubmerANDPlace(1,GlobalVariance.SERIALNUMBER_EXAMING_B);
                model.addAttribute("serialNumber",serialNumber);
                model.addAttribute("dominantTerm",information.getDominantTerm());
                model.addAttribute("dominantInstrument",information.getDominantInstrument());
                model.addAttribute("dominantSong",information.getDominantSong());
                model.addAttribute("secondaryTerm",information.getSecondaryTerm());
                model.addAttribute("secondaryInstrument",information.getSecondaryInstrument());
                model.addAttribute("secondarySong",information.getSecondarySong());
                model.addAttribute("sightsinging",information.getSightsinging());
                model.addAttribute("serialNumberExaming",serialNumber);
                model.addAttribute("place",1+"");
                model.addAttribute("examNumber",information.getExamNumber());
                model.addAttribute("photo","/photos/" + information.getExamNumber()+".jpg");
            }
        }
    }
}
