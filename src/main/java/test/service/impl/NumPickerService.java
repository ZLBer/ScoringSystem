package test.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import test.GlobalVariance;
import test.domain.Information;
import test.domain.InformationExample;
import test.mapper.InformationMapper;
import test.service.INumPicker;
import javax.annotation.Resource;


@Service("numPickerService")
public class NumPickerService implements INumPicker{
    private static final Logger logger = LoggerFactory.getLogger(NumPickerService.class);

    @Resource
    private InformationMapper informationMapper;
    @Override
    public Information query(String examNumber) {
        return informationMapper.selectByPrimaryKey(examNumber);
    }
    @Override
    public int save(Information information) {
        return informationMapper.updateByPrimaryKey(information);
    }
    @Override
    public boolean addToList(Information information) {
        int PLACE_NUM = information.getPlace();
        if (PLACE_NUM == GlobalVariance.PLACE_A){
            GlobalVariance.WaitList[GlobalVariance.PLACE_A].add(information);
            return true;
        }else if (PLACE_NUM == GlobalVariance.PLACE_B){
            GlobalVariance.WaitList[GlobalVariance.PLACE_B].add(information);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void getAndUpdateMaxValue() {
        GlobalVariance.MAX_SELECTED_NUM[GlobalVariance.PLACE_A] = informationMapper.getMaxSerialNum(GlobalVariance.PLACE_A);
        GlobalVariance.MAX_SELECTED_NUM[GlobalVariance.PLACE_B] = informationMapper.getMaxSerialNum(GlobalVariance.PLACE_B);
    }
    @Override
    public void allocateNumToList(int PLACE_NUM, int[] nums) {
        int i=0;
        for (Object stu:GlobalVariance.WaitList[PLACE_NUM]){
            ((Information)stu).setSerialNumber(nums[i]);
            informationMapper.updateByPrimaryKey((Information) stu);
            i++;
        }
        GlobalVariance.WaitList[PLACE_NUM].clear();
        GlobalVariance.MAX_SELECTED_NUM[PLACE_NUM]+=(i);
        logger.info("numPickerService本次为"+PLACE_NUM+"分配了"+i+"人");
    }
}
