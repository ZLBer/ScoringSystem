package test.service;

import test.domain.Information;

public interface INumPicker {
    public Information query(String examNumber);
    public boolean save(Information information);
    public boolean addToList(Information information,int PLACE_NUM);
    public int getMaxValue(int PLACE_NUM);
    public int allocateNumToList(int PLACE_NUM,int[] nums);
}
