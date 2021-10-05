package com.zime.bsk.service.impl;

import com.zime.bsk.dao.CakeOrderInfoMapper;
import com.zime.bsk.entity.CakeOrderInfo;
import com.zime.bsk.entity.CakeOrderInfoExample;
import com.zime.bsk.service.CakeOrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:07
 */
@Service
public class CakeOrderInfoServiceImpl implements CakeOrderInfoService {

    @Resource
    private CakeOrderInfoMapper cakeOrderInfoMapper;


    @Override
    public List<CakeOrderInfo> getAllCakeOrderInfoByUserId(Integer userId) {
        CakeOrderInfoExample cakeOrderInfoExample = new CakeOrderInfoExample();
        cakeOrderInfoExample.or().andOrderUseridEqualTo(userId);
        return cakeOrderInfoMapper.selectByExample(cakeOrderInfoExample);
    }

    @Override
    public List<CakeOrderInfo> getAllCakeOrderInfoByUserIdByState(Integer userId, Integer orderState) {
        CakeOrderInfoExample cakeOrderInfoExample = new CakeOrderInfoExample();
        cakeOrderInfoExample.or().andOrderUseridEqualTo(userId).andOrderStateEqualTo(orderState);
        return cakeOrderInfoMapper.selectByExample(cakeOrderInfoExample);
    }

    @Override
    public List<CakeOrderInfo> getCakeOrderInfoByNo(String orderNo) {
        CakeOrderInfoExample cakeOrderInfoExample = new CakeOrderInfoExample();
        cakeOrderInfoExample.or().andOrderNoEqualTo(orderNo);
        return cakeOrderInfoMapper.selectByExample(cakeOrderInfoExample);
    }

    @Override
    public List<CakeOrderInfo> getCakeOrderInfoById(Integer id) {
        CakeOrderInfoExample cakeOrderInfoExample = new CakeOrderInfoExample();
        cakeOrderInfoExample.or().andOrderIdEqualTo(id);
        return cakeOrderInfoMapper.selectByExample(cakeOrderInfoExample);
    }

    @Override
    public int addCakeOrderInfo(CakeOrderInfo cakeOrderInfo) {
        return cakeOrderInfoMapper.insertSelective(cakeOrderInfo);
    }

    @Override
    public int editCakeOrderInfo(CakeOrderInfo cakeOrderInfo) {
        CakeOrderInfoExample cakeOrderInfoExample = new CakeOrderInfoExample();
        cakeOrderInfoExample.or().andOrderIdEqualTo(cakeOrderInfo.getOrderId());
        return cakeOrderInfoMapper.updateByExampleSelective(cakeOrderInfo, cakeOrderInfoExample);
    }

    @Override
    public int removeCakeOrderInfo(Integer id) {
        return cakeOrderInfoMapper.deleteByPrimaryKey(id);
    }
}
