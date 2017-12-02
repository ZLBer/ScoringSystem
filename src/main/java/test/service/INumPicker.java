package test.service;

import test.domain.Information;

public interface INumPicker {
    public Information query(String examNumber);
    public int save(Information information);
    public boolean addToList(Information information);
    public void getAndUpdateMaxValue();
    public void allocateNumToList(int PLACE_NUM,int[] nums);
}
