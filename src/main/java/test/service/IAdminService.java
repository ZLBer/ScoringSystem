package test.service;

import test.domain.InformationAll;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by libin on 2017/10/28.
 */
public interface IAdminService {
    List<String> getCTitles(String [] informationBasic,String [] informationPolitics,String [] informationOriginal,String [] informationPresent,String [] informationContact,String [] informationSupplement);
     List<List<String>> getETitles(String[] informationBasic, String[] informationPolitics, String[] informationOriginal, String[] informationPresent, String[] informationContact, String[] informationSupplement);
     void addSave( List<List<String>> titles,List<String> record);
     void coverSave( List<List<String>> titles,List<String> record);
     void updateSave( List<List<String>> titles,List<String> record);
     void insertOrUpdateSave( List<List<String>> titles,List<String> record);
     String saveByall(InformationAll informationAll);
     String updateByall(InformationAll informationAll);
     String deleteById(int id);
}
