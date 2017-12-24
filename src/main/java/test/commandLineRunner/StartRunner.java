package test.commandLineRunner;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import test.GlobalVariance;
import test.mapper.ScoreMapper;

import javax.annotation.Resource;

/**
 * Created by libin on 2017/12/21.
 */
@Component
public class StartRunner implements CommandLineRunner {
    private static Logger logger = Logger.getLogger(StartRunner.class);

    @Resource
    ScoreMapper scoreMapper;
    @Override
    public void run(String... strings) throws Exception {
       int  ACount =scoreMapper.countByPlace(GlobalVariance.PLACE_A);
        Integer AMax;
        Integer BMax;
       if(ACount%3!=0){
           AMax= scoreMapper.maxSerialNumberByPlace(GlobalVariance.PLACE_A);
           GlobalVariance.SERIALNUMBER_EXAMING_A=AMax;
       }
        logger.info("A考场考号初始化为"+GlobalVariance.SERIALNUMBER_EXAMING_A);

        int  BCount =scoreMapper.countByPlace(GlobalVariance.PLACE_B);
        if(BCount%3!=0){
            BMax= scoreMapper.maxSerialNumberByPlace(GlobalVariance.PLACE_B);
            GlobalVariance.SERIALNUMBER_EXAMING_B=BMax;
        }
        logger.info("B考场考号初始化为"+GlobalVariance.SERIALNUMBER_EXAMING_B);
    }
}
