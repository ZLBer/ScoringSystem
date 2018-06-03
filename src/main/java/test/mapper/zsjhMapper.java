package test.mapper;


import org.apache.ibatis.annotations.Param;
import test.domain.zsjh;
import test.domain.zsjhExample;

import java.util.List;

public interface zsjhMapper {
    long countByExample(zsjhExample example);

    int deleteByExample(zsjhExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(zsjh record);

    int insertSelective(zsjh record);

    List<zsjh> selectByExample(zsjhExample example);

    zsjh selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") zsjh record, @Param("example") zsjhExample example);

    int updateByExample(@Param("record") zsjh record, @Param("example") zsjhExample example);

    int updateByPrimaryKeySelective(zsjh record);

    int updateByPrimaryKey(zsjh record);
}