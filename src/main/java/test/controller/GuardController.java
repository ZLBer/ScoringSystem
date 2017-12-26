package test.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import test.GlobalVariance;
import test.domain.Information;
import test.domain.Login;
import test.domain.Result;
import test.service.IGuardService;

import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by libin on 2017/11/24.
 */
@Controller
@RequestMapping("/guard")
public class GuardController {
    @Resource
    IGuardService guardService;

    @GetMapping("/main")
    String  main(Model model,HttpSession session){
        installModel(model,session);
        model.addAttribute("bodyRightContent", "guard/board");
        return "main";
    }

    @ResponseBody
    @GetMapping("/offerNumber")
    Information  offerNumber(HttpSession session,@RequestParam("serialNumber")int serialNumber) {
        Login login = (Login) session.getAttribute("user");
        List<Information> informations = guardService.getInformationBySerialNumber(serialNumber);
        Information information = new Information();

        for (Information inf : informations) {
            if (login.getAccount().equals(GlobalVariance.ACCOUNT_GUARD_A)) {
                if (inf.getPlace() == GlobalVariance.PLACE_A) {
                    information = inf;
                    return information;
                }
                if (login.getAccount().equals(GlobalVariance.ACCOUNT_GUARD_B)) {
                    if (inf.getPlace() == GlobalVariance.PLACE_B) {
                        information = inf;
                        return information;
                    }
                }
            }



        }
        return information;
    }
private  void  installModel(Model model,HttpSession session){
    Login login=(Login)session.getAttribute("user");
    if(login.getAccount().equals(GlobalVariance.ACCOUNT_GUARD_A)){
        model.addAttribute("place","序号：A");
        int serialNumber=GlobalVariance.SERIALNUMBER_EXAMING_A;
        if(serialNumber==-1) {

            return;
        }
        else{
  Information   information= guardService.getInfromationBySerialNubmerANDPlace(0,GlobalVariance.SERIALNUMBER_EXAMING_A);
   model.addAttribute("serialNumber",serialNumber);
   model.addAttribute("dominantTerm",information.getDominantTerm());
       model.addAttribute("secondaryTerm",information.getSecondaryTerm());
       model.addAttribute("sightsinging",information.getSightsinging());
       model.addAttribute("serialNumberExaming",serialNumber);
       model.addAttribute("photo","/photos/" + information.getExamNumber()+".jpg");
        }

    }
    else {
        model.addAttribute("place","序号：B");
        int serialNumber=GlobalVariance.SERIALNUMBER_EXAMING_B;
        if(serialNumber==-1) {

            return;
        }
        else{
            Information   information= guardService.getInfromationBySerialNubmerANDPlace(1,GlobalVariance.SERIALNUMBER_EXAMING_B);
            model.addAttribute("serialNumber",serialNumber);
            model.addAttribute("dominantTerm",information.getDominantTerm());
            model.addAttribute("secondaryTerm",information.getSecondaryTerm());
            model.addAttribute("sightsinging",information.getSightsinging());
            model.addAttribute("serialNumberExaming",serialNumber);
            model.addAttribute("photo","/photos/" + information.getExamNumber()+".jpg");
        }
    }
}
}
