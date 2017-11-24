package test;

import test.domain.Information;

import java.util.LinkedList;

/**
 * 本类用于存放全局静态变量
 */
public class GlobalVariance {
    //目录名
    public final static String[] TEMPLATE_DIR  = {"numPicker","guard","reviewer","admin","suadmin"};
    //页面主体右侧模代号
    public final static String BodyRightContent = "bodyRightContent";
    //选号人
    public static final int USER_NUM_PICKER= 0;
    //控制进场
    public static final int USER_GUARD = 1;
    //评委
    public static final int USER_REVIEWER = 2;
    //管理员
    public static final int USER_ADMIN = 3;
    //超级管理员
    public static final int USER_SUADMIN = 4;
    //A组等待队列
    public static LinkedList<Information> AWaitList = new LinkedList<Information>();
    //B组等待队列
    public static LinkedList<Information> BWaitList = new LinkedList<Information>();
    //已经被选取的最大号
    public static int MAX_SELECTED_NUM = 0;
}
