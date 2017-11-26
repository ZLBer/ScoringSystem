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
}