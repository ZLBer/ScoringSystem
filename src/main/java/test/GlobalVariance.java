package test;

import org.springframework.web.socket.WebSocketSession;
import test.domain.Information;
import test.mapper.InformationMapper;

import javax.annotation.Resource;
import java.util.LinkedList;

/**
 * 本类用于存放全局静态变量
 */
public class GlobalVariance {
    @Resource
    private InformationMapper informationMapper;
    //目录名
    public final static String[] TEMPLATE_DIR  = {"numPicker","guard","reviewer","admin","suadmin"};
    //页面主体右侧模代号
    public final static String BodyRightContent = "bodyRightContent";
    //场A
    public static final int PLACE_A = 0;
    //场B
    public static final int PLACE_B = 1;
    //选号人
    public static final int USER_NUM_PICKER= 0;
    //控制进场A
    public static final int USER_GUARD_A = 11;
    //控制进场B
    public static final int USER_GUARD_B= 12;
    //评委
    public static final int USER_REVIEWER = 2;
    //管理员
    public static final int USER_ADMIN = 3;
    //超级管理员
    public static final int USER_SUADMIN = 4;
    //等待队列
    public static LinkedList[] WaitList = new LinkedList[]{new LinkedList<Information>(), new LinkedList<Information>()};
    //已经被选取的最大号
    public static int[] MAX_SELECTED_NUM = {0,0};
    //第一个数代表场号 A0 B1
    //第二个数代表人员 控场0 评委11 平稳22 平稳33
    public static WebSocketSession[][] SSessions = new WebSocketSession[2][4];

    //进场人账号
    public static final String ACCOUNT_GUARD_A = "aguard";
    public static final String ACCOUNT_GUARD_B = "bguard";

    //评委账号
    public static final String ACCOUNT_REVIEWE_A1 = "a1";
    public static final String ACCOUNT_REVIEWE_A2 = "a2";
    public static final String ACCOUNT_REVIEWE_A3 = "a3";
    public static final String ACCOUNT_REVIEWE_B1 = "b1";
    public static final String ACCOUNT_REVIEWE_B2 = "b2";
    public static final String ACCOUNT_REVIEWE_B3 = "b3";

    //座位标志
    public static  int SEAT = 0;
    public static final int   REVIEWER_OFFLINE=0 ;
    public static final int   REVIEWER_ONLINE=1 ;
    public static final int   REVIEWER_SCORE=2;
    //
}
