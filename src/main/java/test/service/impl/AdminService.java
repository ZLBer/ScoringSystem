package test.service.impl;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopeMetadataResolver;
import org.springframework.stereotype.Service;
import test.domain.*;
import test.mapper.*;
import test.service.IAdminService;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by libin on 2017/10/28.
 */
@Service("adminService")
public class AdminService implements IAdminService {
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    InformationMapper informationMapper;
    @Override
    public  int   rateNumPick(int place){
    return   informationMapper.countSerialNum(place);
    }

    @Override
    public int rateExam(int place) {
      return scoreMapper.countExamNum(place);
    }

    @Override
    public List<Score> queryResultByExamNumber(String examNumber) {
        ScoreExample example=new ScoreExample();
        ScoreExample.Criteria criteria=  example.createCriteria();
        criteria.andExamNumberEqualTo(examNumber);
        List<Score> scores=scoreMapper.selectByExample(example);
        return scores;
    }

    @Override
    public List<Score> queryResultBySerialNumber(int place, int serialNumber) {
        List<Score> scores=scoreMapper.selectBySerialNumberANDPlace(place,serialNumber);
        return scores;
    }

    @Override
    public List<AllScore> queryScore(String beginTime, String endTime, int place) {
     List<Score> scores= scoreMapper.groupByReviewer(beginTime,endTime,place);
        for(Score s:scores){
            System.out.println(s.getDominantScore());
        }
    List<AllScore> allScores=new LinkedList<AllScore>();
     Map<String,AllScore> stringAllScoreMap=new HashMap<String, AllScore>();
     for(Score score: scores){
         if(!stringAllScoreMap.containsKey(score.getExamNumber())){
             AllScore allScore=new AllScore();
           for(Score sc:scores){
              if(score.getExamNumber().equals(sc.getExamNumber()))
                  allScore.addS(sc);
           }
             stringAllScoreMap.put(score.getExamNumber(),allScore);
         }
     }
        Iterator entries = stringAllScoreMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            AllScore allScore = (AllScore)entry.getValue();
            allScores.add(allScore);
        }
            return allScores;
    }

}
