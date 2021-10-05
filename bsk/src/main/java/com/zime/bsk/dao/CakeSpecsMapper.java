package com.zime.bsk.dao;

import com.zime.bsk.entity.CakeSpecs;
import com.zime.bsk.entity.CakeSpecsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CakeSpecsMapper {
    long countByExample(CakeSpecsExample example);

    int deleteByExample(CakeSpecsExample example);

    int deleteByPrimaryKey(Integer cakespecsId);

    int insert(CakeSpecs record);

    int insertSelective(CakeSpecs record);

    List<CakeSpecs> selectByExample(CakeSpecsExample example);

    CakeSpecs selectByPrimaryKey(Integer cakespecsId);

    int updateByExampleSelective(@Param("record") CakeSpecs record, @Param("example") CakeSpecsExample example);

    int updateByExample(@Param("record") CakeSpecs record, @Param("example") CakeSpecsExample example);

    int updateByPrimaryKeySelective(CakeSpecs record);

    int updateByPrimaryKey(CakeSpecs record);
}