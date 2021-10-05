package com.zime.bsk.dao;

import com.zime.bsk.entity.CakeInfo;
import com.zime.bsk.entity.CakeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CakeInfoMapper {
    long countByExample(CakeInfoExample example);

    int deleteByExample(CakeInfoExample example);

    int deleteByPrimaryKey(Integer cakeId);

    int insert(CakeInfo record);

    int insertSelective(CakeInfo record);

    List<CakeInfo> selectByExample(CakeInfoExample example);

    CakeInfo selectByPrimaryKey(Integer cakeId);

    int updateByExampleSelective(@Param("record") CakeInfo record, @Param("example") CakeInfoExample example);

    int updateByExample(@Param("record") CakeInfo record, @Param("example") CakeInfoExample example);

    int updateByPrimaryKeySelective(CakeInfo record);

    int updateByPrimaryKey(CakeInfo record);
}