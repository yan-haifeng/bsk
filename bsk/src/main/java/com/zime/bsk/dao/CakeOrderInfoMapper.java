package com.zime.bsk.dao;

import com.zime.bsk.entity.CakeOrderInfo;
import com.zime.bsk.entity.CakeOrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CakeOrderInfoMapper {
    long countByExample(CakeOrderInfoExample example);

    int deleteByExample(CakeOrderInfoExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(CakeOrderInfo record);

    int insertSelective(CakeOrderInfo record);

    List<CakeOrderInfo> selectByExample(CakeOrderInfoExample example);

    CakeOrderInfo selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") CakeOrderInfo record, @Param("example") CakeOrderInfoExample example);

    int updateByExample(@Param("record") CakeOrderInfo record, @Param("example") CakeOrderInfoExample example);

    int updateByPrimaryKeySelective(CakeOrderInfo record);

    int updateByPrimaryKey(CakeOrderInfo record);
}