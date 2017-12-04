package test.service.impl;

import org.springframework.stereotype.Service;
import test.domain.Information;
import test.domain.InformationExample;
import test.domain.Score;
import test.domain.ScoreExample;
import test.mapper.InformationMapper;
import test.mapper.ScoreMapper;
import test.service.IGuardService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by libin on 2017/11/24.
 */
@Service("guardService")
public class GuardService implements IGuardService {
    @Resource
    InformationMapper informationMapper;
    @Resource
    ScoreMapper scoreMapper;
    @Override
    public Information getInformationByExamNumber(String examNumber) {
        InformationExample example = new InformationExample();
        InformationExample.Criteria criteria = example.createCriteria();
        criteria.andExamNumberEqualTo(examNumber);
        List<Information> inf=  informationMapper.selectByExample(example);
        if(inf.size()>0){
            return inf.get(0);
        }
        else return null;

    }

    @Override
    public List<Score> checkScoring(int serialNumber) {

        ScoreExample example=new ScoreExample();
        ScoreExample.Criteria criteria=example.createCriteria();
        criteria.andSerialNumberEqualTo(serialNumber);
        List<Score> scores=scoreMapper.selectByExample(example);

        return scores;
    }

    @Override
    public List<Information> getInformationBySerialNumber(int serialNumber) {
       InformationExample example=new InformationExample();
       InformationExample.Criteria criteria=example.createCriteria();

      criteria.andSerialNumberEqualTo(serialNumber);
        List<Information> infs=  informationMapper.selectByExample(example);
        return infs;

    }
}
