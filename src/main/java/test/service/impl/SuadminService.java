package test.service.impl;

import org.springframework.stereotype.Service;
import test.domain.AllScore;
import test.domain.Score;
import test.domain.ScoreExample;
import test.domain.ScoreInfo;
import test.mapper.ScoreMapper;
import test.service.ISuadminService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("suadminService")
public class SuadminService implements ISuadminService {
    @Resource
    ScoreMapper scoreMapper;
    @Override
    public Map<String, AllScore> getAllScore() {
        Map<String,AllScore> data = new HashMap<String,AllScore>();
        List<ScoreInfo> list = scoreMapper.getScoreInfo();
        for (ScoreInfo score:list){
            if (data.keySet().contains(score.getExamNumber())){
                ((AllScore)data.get(score.getExamNumber())).addScore(score);
                System.out.println("表姓名："+score.getName());
            }else{
                AllScore allScore = new AllScore(score);
                data.put(score.getExamNumber(),allScore);
            }
        }
        return data;
    }
}
