package test.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import test.domain.ScoreResult;
import test.domain.ScoreResultExample;

public interface ScoreResultMapper {
    long countByExample(ScoreResultExample example);

    int deleteByExample(ScoreResultExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScoreResult record);

    int insertSelective(ScoreResult record);

    List<ScoreResult> selectByExample(ScoreResultExample example);

    ScoreResult selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScoreResult record, @Param("example") ScoreResultExample example);

    int updateByExample(@Param("record") ScoreResult record, @Param("example") ScoreResultExample example);

    int updateByPrimaryKeySelective(ScoreResult record);

    int updateByPrimaryKey(ScoreResult record);
}