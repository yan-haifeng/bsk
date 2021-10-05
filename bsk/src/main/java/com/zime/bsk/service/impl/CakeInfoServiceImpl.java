package com.zime.bsk.service.impl;

import com.zime.bsk.dao.CakeInfoMapper;
import com.zime.bsk.entity.CakeInfo;
import com.zime.bsk.entity.CakeInfoExample;
import com.zime.bsk.service.CakeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:06
 */
@Service
public class CakeInfoServiceImpl implements CakeInfoService {

    @Resource
    private CakeInfoMapper cakeInfoMapper;


    @Override
    public List<CakeInfo> getAllCakeInfo() {
        CakeInfoExample cakeInfoExample = new CakeInfoExample();
        return cakeInfoMapper.selectByExample(cakeInfoExample);
    }

    @Override
    public List<CakeInfo> getAllCakeInfoByClassId(Integer cakeClassid) {
        CakeInfoExample cakeInfoExample = new CakeInfoExample();
        cakeInfoExample.or().andCakeClassidEqualTo(cakeClassid);
        return cakeInfoMapper.selectByExample(cakeInfoExample);
    }

    @Override
    public List<CakeInfo> getAllCakeInfoByClassMinId(Integer cakeClassminid) {
        CakeInfoExample cakeInfoExample = new CakeInfoExample();
        cakeInfoExample.or().andCakeClassminidEqualTo(cakeClassminid);
        return cakeInfoMapper.selectByExample(cakeInfoExample);
    }

    @Override
    public List<CakeInfo> getCakeInfoById(Integer id) {
        CakeInfoExample cakeInfoExample = new CakeInfoExample();
        cakeInfoExample.or().andCakeIdEqualTo(id);
        return cakeInfoMapper.selectByExample(cakeInfoExample);
    }

    @Override
    public List<CakeInfo> getCakeInfoByDay() {
        CakeInfoExample cakeInfoExample = new CakeInfoExample();
        cakeInfoExample.or().andCakeDiscountdayEqualTo(1);
        return cakeInfoMapper.selectByExample(cakeInfoExample);
    }

    @Override
    public int addCakeInfo(CakeInfo cakeInfo) {
        return cakeInfoMapper.insertSelective(cakeInfo);
    }

    @Override
    public int editCakeInfo(CakeInfo cakeInfo) {
        CakeInfoExample cakeInfoExample = new CakeInfoExample();
        cakeInfoExample.or().andCakeIdEqualTo(cakeInfo.getCakeId());
        return cakeInfoMapper.updateByExampleSelective(cakeInfo, cakeInfoExample);
    }

    @Override
    public int removeCakeInfo(Integer id) {
        return cakeInfoMapper.deleteByPrimaryKey(id);
    }
}
