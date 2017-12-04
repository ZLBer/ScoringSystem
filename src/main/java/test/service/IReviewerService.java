package test.service;

import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 * Created by libin on 2017/11/27.
 */
public interface IReviewerService {
     boolean saveScore(int serialNumber,String dominantScore,String secondaryScore,String sightsingingScore,String reviewer);
}
