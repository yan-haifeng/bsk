package com.zime.bsk.dao;

import com.zime.bsk.entity.CakeClassMin;
import com.zime.bsk.entity.CakeClassMinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CakeClassMinMapper {
    long countByExample(CakeClassMinExample example);

    int deleteByExample(CakeClassMinExample example);

    int deleteByPrimaryKey(Integer cakeclassminId);

    int insert(CakeClassMin record);

    int insertSelective(CakeClassMin record);

    List<CakeClassMin> selectByExample(CakeClassMinExample example);

    CakeClassMin selectByPrimaryKey(Integer cakeclassminId);

    int updateByExampleSelective(@Param("record") CakeClassMin record, @Param("example") CakeClassMinExample example);

    int updateByExample(@Param("record") CakeClassMin record, @Param("example") CakeClassMinExample example);

    int updateByPrimaryKeySelective(CakeClassMin record);

    int updateByPrimaryKey(CakeClassMin record);
}