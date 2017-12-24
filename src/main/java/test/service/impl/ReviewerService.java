package test.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import test.domain.Information;
import test.domain.Score;
import test.domain.ScoreExample;
import test.domain.ScoreInfo;
import test.mapper.InformationMapper;
import test.mapper.ScoreMapper;
import test.service.IReviewerService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by libin on 2017/11/27.
 */
@Service("reviewerService")
public class ReviewerService implements IReviewerService{
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    InformationMapper informationMapper;

    @Override
    public boolean saveScore(String examNumber,int place,int serialNumber,String dominantScore,String secondaryScore,String sightsingingScore,String reviewer) {
        try {
            int dominantS=Integer.parseInt(dominantScore);
            int  secondaryS=Integer.parseInt(secondaryScore);
            int sightsingingS=Integer.parseInt(sightsingingScore);
            Score score=new Score();
            score.setExamNumber(examNumber);
            score.setPlace(place);
            score.setSerialNumber(serialNumber);
            score.setDominantScore(dominantS);
            score.setSecondaryScore(secondaryS);
            score.setSightsingingScore(sightsingingS);
            score.setReviewer(reviewer);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            score.setScoreTime(df.parse(df.format(new Date())));
            scoreMapper.insert(score);
  //设置是否考试标记
 Information information=informationMapper.selectByPrimaryKey(examNumber);
        information.setHasExam(true);
        informationMapper.updateByPrimaryKeySelective(information);
        }catch (Exception e){
            return false;
        }


        return true;
    }

    /**
     *   根据reviewer和examNumber字段查询在Score表中是否有记录 ，有记录返回true，无记录返回false
     * @param reviewer
     * @param examNumber
     * @return
     */
    @Override
    public boolean checkIsSave( String reviewer,String examNumber) {
       System.out.println(examNumber+"     "+reviewer);
       List<Score>  scores= scoreMapper.selectByExamNumberANDReviewer(examNumber,reviewer);
       if(scores.size()>0) return  true;
       else return false;
//        ScoreExample example=new ScoreExample();
//        ScoreExample.Criteria criteria=example.createCriteria();
//        criteria.andExamNumberEqualTo(examNumber);
//        List<Score> scores=scoreMapper.selectByExample(example);
//        for(Score score:scores){
//            if(score.getReviewer().equals(reviewer)) return true;
//            System.out.println("score"+score.getReviewer());
//        }
//        return false;
    }

    @Override
    public boolean checkSubmitFromat(String dominantScore,String secondaryScore,  String sightsingingScore) {
        try {
            int dominantS=Integer.parseInt(dominantScore);
        int  secondaryS=Integer.parseInt(secondaryScore);
        int sightsingingS=Integer.parseInt(sightsingingScore);
        if(dominantS<=100&&dominantS>=0&&secondaryS>=0&&secondaryS<=100&sightsingingS>=0&&secondaryS<=100)
            return true;
        return false;
        }catch (Exception e){
            return false;
        }
    }

}
