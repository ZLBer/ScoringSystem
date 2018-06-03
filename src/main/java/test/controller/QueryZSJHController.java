package test.controller;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.domain.zsjh;
import test.domain.zsjhExample;
import test.mapper.zsjhMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2018/6/2.
 */
@Controller
public class QueryZSJHController {
    @Resource
    zsjhMapper zsjhMapper;

    @GetMapping("/beforeZSJH")
    public String beforeZSJH(Model model){

        zsjhExample example = new zsjhExample();
        zsjhExample.Criteria criteria = example.createCriteria();
        criteria.andIdGreaterThan(0);
    List<zsjh> results= zsjhMapper.selectByExample(example);
    model.addAttribute("results",results);
int count=0;
    for(zsjh z:results){
count+=Integer.valueOf(z.getZsjh());
}
        model.addAttribute("count",count);
        return "query/beforeZSJH";
    }
    @RequestMapping("/ZSJH")
    public String ZSJH(Model model, @Param("sf")String sf,@Param("zy")String zy){

        zsjhExample example = new zsjhExample();
        zsjhExample.Criteria criteria = example.createCriteria();
if("所有省份".equals(sf));
else
        criteria.andSfEqualTo(sf);
if("".equals(zy));
    else
        criteria.andZymcLike("%"+zy+"%");
        List<zsjh> results= zsjhMapper.selectByExample(example);
        model.addAttribute("results",results);
        model.addAttribute("zy",zy);
        model.addAttribute("sf",sf);
        System.out.println(results.size());
        int count=0;
        for(zsjh z:results) {
            count += Integer.valueOf(z.getZsjh());
        }
        model.addAttribute("count",count);
        return "query/beforeZSJH";
    }

}
