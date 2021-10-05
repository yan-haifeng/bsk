package com.zime.bsk.service.impl;

import com.zime.bsk.dao.CakeClassMinMapper;
import com.zime.bsk.entity.CakeClassExample;
import com.zime.bsk.entity.CakeClassMin;
import com.zime.bsk.entity.CakeClassMinExample;
import com.zime.bsk.service.CakeClassMinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/3
 * @TIME: 9:05
 */
@Service
public class CakeClassMinServiceImpl implements CakeClassMinService {

    @Resource
    private CakeClassMinMapper cakeClassMinMapper;

    @Override
    public List<CakeClassMin> getAllCakeClassMin() {
        CakeClassMinExample cakeClassMinExample = new CakeClassMinExample();
        return cakeClassMinMapper.selectByExample(cakeClassMinExample);
    }

    @Override
    public List<CakeClassMin> getAllCakeClassMinByClassId(Integer cakeclassId) {
        CakeClassMinExample cakeClassExample = new CakeClassMinExample();
        cakeClassExample.or().andCakeclassminClassidEqualTo(cakeclassId);
        return cakeClassMinMapper.selectByExample(cakeClassExample);
    }

    @Override
    public List<CakeClassMin> getCakeClassMinById(Integer id) {
        CakeClassMinExample cakeClassExample = new CakeClassMinExample();
        cakeClassExample.or().andCakeclassminIdEqualTo(id);
        return cakeClassMinMapper.selectByExample(cakeClassExample);
    }

    @Override
    public int addCakeClassMin(CakeClassMin cakeClassMin) {
        return cakeClassMinMapper.insertSelective(cakeClassMin);
    }

    @Override
    public int editCakeClassMin(CakeClassMin cakeClassMin) {
        CakeClassMinExample cakeClassMinExample = new CakeClassMinExample();
        cakeClassMinExample.or().andCakeclassminIdEqualTo(cakeClassMin.getCakeclassminId());
        return cakeClassMinMapper.updateByExampleSelective(cakeClassMin, cakeClassMinExample);
    }

    @Override
    public int removeCakeClassMin(Integer id) {
        return cakeClassMinMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int removeCakeClassMinByClassId(Integer cakeclassminClassid) {
        CakeClassMinExample cakeClassExample = new CakeClassMinExample();
        cakeClassExample.or().andCakeclassminClassidEqualTo(cakeclassminClassid);
        return cakeClassMinMapper.deleteByExample(cakeClassExample);
    }


}
