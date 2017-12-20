package test.service;


import org.apache.ibatis.annotations.Param;

/**
 * Created by libin on 2017/11/27.
 */
public interface IReviewerService {
     boolean saveScore(String examNumber,int place,int serialNumber,String dominantScore,String secondaryScore,String sightsingingScore,String reviewer);
     boolean checkIsSave(String examNumber,String reviewer);
     boolean  checkSubmitFromat(String dominantScore,  String secondaryScore,String sightsingingScore);
}
