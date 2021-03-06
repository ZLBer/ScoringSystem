package test.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.domain.Score;
import test.domain.ScoreExample;
import test.domain.ScoreInfo;

public interface ScoreMapper {
    long countByExample(ScoreExample example);

    int deleteByExample(ScoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectByExample(ScoreExample example);

    Score selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByExample(@Param("record") Score record, @Param("example") ScoreExample example);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    int countExamNum(Integer place);
    List<Score>   groupByReviewer(@Param("scoreBeginTime") String scoreBeginTime, @Param("scoreEndTime")String scoreEndTime,@Param("place")int place);
    List<ScoreInfo> getScoreInfo();
    List<Score> selectBySerialNumberANDPlace(@Param("place") Integer place,@Param("serialNumber") Integer serialNumber);
    List<Score> selectByExamNumberANDReviewer(@Param("examNumber") String examNumber,@Param("reviewer") String reviewer);

    List<Score> selectBySerialNumberANDReviewer(@Param("serialNumber") Integer serialNumber,@Param("reviewer") String reviewer);
     int countByPlace(@Param("place") Integer place);
     Integer maxSerialNumberByPlace(@Param("place") Integer place);
}