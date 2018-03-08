package test.controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import test.domain.Result;
import test.domain.ScoreResult;
import test.domain.ScoreResultExample;
import test.mapper.ScoreResultMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by libin on 2018/3/8.
 */
@Controller

public class QueryResult {
    @Resource
    ScoreResultMapper resultMapper;
    @GetMapping("/query")
    public String fillQuery(Model model, @Param("idNumber") String idNumber,@Param("name") String name){

        return "query/fillQuery";
    }
    @ResponseBody
    @GetMapping("/resultQuery")
    public String resultQuery(Model model,@Param("idNumber") String idNumber){
        ScoreResultExample example=new ScoreResultExample();
        ScoreResultExample.Criteria criteria=  example.createCriteria();
        criteria.andIdNumberEqualTo(idNumber);
        List <ScoreResult> results=resultMapper.selectByExample(example);
        String json = JSONArray.toJSONString(results);
        return json;
    }
}
