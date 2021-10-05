package com.zime.bsk.service.impl;

import com.zime.bsk.dao.CakeCarMapper;
import com.zime.bsk.entity.CakeCar;
import com.zime.bsk.entity.CakeCarExample;
import com.zime.bsk.entity.CakeClassExample;
import com.zime.bsk.service.CakeCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:02
 */
@Service
public class CakeCarServiceImpl implements CakeCarService {

    @Resource
    private CakeCarMapper cakeCarMapper;

    @Override
    public List<CakeCar> getAllCakeCarByUserIdNotBuy(Integer userId) {
        CakeCarExample cakeCarExample = new CakeCarExample();
        cakeCarExample.or().andCarUseridEqualTo(userId).andCarStateEqualTo(0);
        return cakeCarMapper.selectByExample(cakeCarExample);
    }

    @Override
    public List<CakeCar> getAllCakeCarByUserIdBuy(Integer userId) {
        CakeCarExample cakeCarExample = new CakeCarExample();
        cakeCarExample.or().andCarUseridEqualTo(userId).andCarStateEqualTo(1);
        return cakeCarMapper.selectByExample(cakeCarExample);
    }

    @Override
    public List<CakeCar> getCakeCarById(Integer id) {
        CakeCarExample cakeCarExample = new CakeCarExample();
        cakeCarExample.or().andCarIdEqualTo(id);
        return cakeCarMapper.selectByExample(cakeCarExample);
    }

    @Override
    public int addCakeCar(CakeCar cakeCar) {
        return cakeCarMapper.insertSelective(cakeCar);
    }

    @Override
    public int editCakeCar(CakeCar cakeCar) {
        CakeCarExample cakeCarExample = new CakeCarExample();
        cakeCarExample.or().andCarIdEqualTo(cakeCar.getCarId());
        return cakeCarMapper.updateByExampleSelective(cakeCar, cakeCarExample);
    }

    @Override
    public int removeCakeCar(Integer id) {
        return cakeCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int removeCakeCarByUserId(Integer carUserid) {
        CakeCarExample cakeCarExample = new CakeCarExample();
        cakeCarExample.or().andCarUseridEqualTo(carUserid);
        return cakeCarMapper.deleteByExample(cakeCarExample);
    }
}
