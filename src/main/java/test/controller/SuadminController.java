package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import test.service.ISuadminService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class SuadminController {
    @Resource
    ISuadminService suadminService;

    @GetMapping("/suadmin/download")
    public String download(Model model, HttpServletResponse response){
        response.setHeader("Content-Disposition", "attachment;filename=score.xls");
        response.setHeader("content-type","application/vnd.ms-excel");
        Map datas = suadminService.getAllScore();
        model.addAttribute("datas",datas);
        return "allScore.xml";
    }
}
