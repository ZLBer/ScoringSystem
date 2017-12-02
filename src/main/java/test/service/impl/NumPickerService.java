package test.service.impl;

import test.domain.Information;
import test.mapper.InformationMapper;
import test.service.INumPicker;

import javax.annotation.Resource;

public class NumPickerService implements INumPicker{
    @Resource
    private InformationMapper informationMapper;

    @Override
    public Information query(String examNumber) {
        return informationMapper.selectByPrimaryKey(examNumber);
    }

    @Override
    public boolean save(Information information) {
        return false;
    }
    @Override
    public boolean addToList(Information information, int PLACE_NUM) {
        return false;
    }

    @Override
    public int getMaxValue(int PLACE_NUM) {
        return 0;
    }

    @Override
    public int allocateNumToList(int PLACE_NUM, int[] nums) {
        return 0;
    }
}
