package com.zime.bsk.dao;

import com.zime.bsk.entity.CakeUserTalk;
import com.zime.bsk.entity.CakeUserTalkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CakeUserTalkMapper {
    long countByExample(CakeUserTalkExample example);

    int deleteByExample(CakeUserTalkExample example);

    int deleteByPrimaryKey(Integer talkId);

    int insert(CakeUserTalk record);

    int insertSelective(CakeUserTalk record);

    List<CakeUserTalk> selectByExample(CakeUserTalkExample example);

    CakeUserTalk selectByPrimaryKey(Integer talkId);

    int updateByExampleSelective(@Param("record") CakeUserTalk record, @Param("example") CakeUserTalkExample example);

    int updateByExample(@Param("record") CakeUserTalk record, @Param("example") CakeUserTalkExample example);

    int updateByPrimaryKeySelective(CakeUserTalk record);

    int updateByPrimaryKey(CakeUserTalk record);
}