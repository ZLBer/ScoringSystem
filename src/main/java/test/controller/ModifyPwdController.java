package test.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.domain.Login;
import test.domain.Result;
import test.service.IModifyPwdService;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by libin on 2017/9/24.
 */

@Controller
public class ModifyPwdController {
    @Resource
    IModifyPwdService modifyPwdService;

    @GetMapping("/gotoModifyPwd")
    public String gotoModifyPwd(Model model) {
        model.addAttribute("bodyRightContent", "modifyPassword");
        return "main";
    }

    @PostMapping("/modifyPwd")
    @ResponseBody
    public Result modifyPwd(HttpSession session, String password, Model model) {
        Result result = new Result(1, "修改密码", "密码修改成功");
        try {
            String type = (String) session.getAttribute("templateDir");
            Login u = (Login) session.getAttribute("user");
            System.out.println("修改密码:"+password);
            System.out.println(modifyPwdService.modifyPwd(u,password));
        }catch (Exception e){
            result.setState(0);
            result.setMsg("未知错误");
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
