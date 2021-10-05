package com.zime.bsk.dao;

import com.zime.bsk.entity.CakeCar;
import com.zime.bsk.entity.CakeCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CakeCarMapper {
    long countByExample(CakeCarExample example);

    int deleteByExample(CakeCarExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(CakeCar record);

    int insertSelective(CakeCar record);

    List<CakeCar> selectByExample(CakeCarExample example);

    CakeCar selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") CakeCar record, @Param("example") CakeCarExample example);

    int updateByExample(@Param("record") CakeCar record, @Param("example") CakeCarExample example);

    int updateByPrimaryKeySelective(CakeCar record);

    int updateByPrimaryKey(CakeCar record);
}