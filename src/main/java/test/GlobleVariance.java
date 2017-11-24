package test;

import org.thymeleaf.spring4.expression.Fields;
import test.domain.Information;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class GlobleVariance {
    public static String[] args;
    //页面主体右侧模代号
    public final static String BodyRightContent = "bodyRightContent";
    //选号人
    public static final int USER_NUM_PICKER= 1;
    //控制进场
    public static final int USER_GUARD = 2;
    //评委
    public static final int USER_REVIEWER = 3;
    //管理员
    public static final int USER_ADMIN = 4;
    //超级管理员
    public static final int USER_SUADMIN = 5;
    //A组等待队列
    public static LinkedList<Information> AWaitList = new LinkedList<Information>();
    //B组等待队列
    public static LinkedList<Information> BWaitList = new LinkedList<Information>();
    //已经被选取的最大号
    public static int MAX_SELECTED_NUM = 0;

    static{
    }
}
