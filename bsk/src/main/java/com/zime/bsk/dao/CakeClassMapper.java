package com.zime.bsk.dao;

import com.zime.bsk.entity.CakeClass;
import com.zime.bsk.entity.CakeClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CakeClassMapper {
    long countByExample(CakeClassExample example);

    int deleteByExample(CakeClassExample example);

    int deleteByPrimaryKey(Integer cakeclassId);

    int insert(CakeClass record);

    int insertSelective(CakeClass record);

    List<CakeClass> selectByExample(CakeClassExample example);

    CakeClass selectByPrimaryKey(Integer cakeclassId);

    int updateByExampleSelective(@Param("record") CakeClass record, @Param("example") CakeClassExample example);

    int updateByExample(@Param("record") CakeClass record, @Param("example") CakeClassExample example);

    int updateByPrimaryKeySelective(CakeClass record);

    int updateByPrimaryKey(CakeClass record);
}