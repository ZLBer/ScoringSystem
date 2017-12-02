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
    String  main(Model model){
        model.addAttribute("bodyRightContent", "guard/main");
        return "main";
    }
    @GetMapping("/guardBoard")
   String guarBoard(HttpSession session, Model model){
               GlobalVariance globalVariance=new GlobalVariance();
              Login login= (Login) session.getAttribute("user");
        List<Information> waitList=new LinkedList<Information>();
            if(login.getAccount().substring(0,1).equals("A")){
            waitList  = globalVariance.WaitList[0];
            }
    else{
                 waitList=globalVariance.WaitList[1];
            }

        model.addAttribute("bodyRightContent", "admin/download");
        return "main";
    }
    @ResponseBody
    @GetMapping("/offerNumber")
    Information  offerNumber(@RequestParam("serialNumber")String serialNumber){
      Information information= guardService.getInformationBySerialNumber(serialNumber);
      return information;
    }
   @ResponseBody
    @GetMapping("/checkReviewer")
   Result checkScore(HttpServletRequest request){
      guardService.checkScoring(request.getParameter("serialNumber"));
        return new Result(1,"","");
    }
}
