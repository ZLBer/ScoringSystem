package test.service.impl;

import org.springframework.stereotype.Service;
import test.domain.Score;
import test.mapper.ScoreMapper;
import test.service.IReviewerService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by libin on 2017/11/27.
 */
@Service("reviewerService")
public class ReviewerService implements IReviewerService{
    @Resource
    ScoreMapper scoreMapper;

    @Override
    public boolean saveScore(int serialNumber,String dominantScore,String secondaryScore,String sightsingingScore,String reviewer) {
        try {
            int dominantS=Integer.parseInt(dominantScore);
            int  secondaryS=Integer.parseInt(secondaryScore);
            int sightsingingS=Integer.parseInt(sightsingingScore);
            Score score=new Score();
            score.setSerialNumber(serialNumber);
            score.setDominantScore(dominantS);
            score.setSecondaryScore(secondaryS);
            score.setSightsingingScore(sightsingingS);
            score.setReviewer(reviewer);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            score.setScoreTime(df.parse(df.format(new Date())));
            scoreMapper.insert(score);
        }catch (Exception e){
            return false;
        }


        return true;
    }

}
