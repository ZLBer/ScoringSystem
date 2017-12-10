package test.service;

import test.domain.AllScore;
import test.domain.Score;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/10/28.
 */
public interface IAdminService {
    int   rateNumPick(int place);
    int   rateExam(int place);
    List<Score> queryResultByExamNumber(String examNumber);
    List<Score> queryResultBySerialNumber(int place,int SerialNumber);
    List<AllScore> queryScore(String beginTime,String endTime,int place);
}
