package test.service.impl;

import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;
import test.domain.*;
import test.mapper.*;
import test.service.IAdminService;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by libin on 2017/10/28.
 */
@Service("adminService")
public class AdminService implements IAdminService {
    @Resource
    ScoreMapper scoreMapper;
    @Resource
    InformationMapper informationMapper;
    @Override
    public  int   rateNumPick(int place){
    return   informationMapper.countSerialNum(place);
    }

    @Override
    public int rateExam(int place) {
      return scoreMapper.countExamNum(place);
    }

    @Override
    public List<Score> queryResult(String examNumber) {
        ScoreExample example=new ScoreExample();
        ScoreExample.Criteria criteria=  example.createCriteria();
        criteria.andExamNumberEqualTo(examNumber);
        List<Score> scores=scoreMapper.selectByExample(example);
        return scores;
    }
}
