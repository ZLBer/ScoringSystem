package test.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import test.GlobalVariance;
import test.domain.Information;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class IndexController{

    @RequestMapping(path = "/")
    public String index(){
        return "login";
    }

    @GetMapping("/nums/{place}")
    public String nums(HttpServletRequest request, Model model, @PathVariable int place) throws IOException {
        String jsonStr = request.getParameter("jsonStr");
        List<Information> data = (List<Information>) GlobalVariance.WaitList[place].clone();
        GlobalVariance.WaitList[place].clear();
        model.addAttribute("datas",data);
        return "numPicker/nums";
    }
}
