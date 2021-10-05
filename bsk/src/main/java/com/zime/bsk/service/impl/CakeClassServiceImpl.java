package com.zime.bsk.service.impl;

import com.zime.bsk.dao.CakeClassMapper;
import com.zime.bsk.entity.CakeClass;
import com.zime.bsk.entity.CakeClassExample;
import com.zime.bsk.service.CakeClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:06
 */
@Service
public class CakeClassServiceImpl implements CakeClassService {

    @Resource
    private CakeClassMapper cakeClassMapper;

    @Override
    public List<CakeClass> getAllCakeClass() {
        CakeClassExample cakeClassExample = new CakeClassExample();
        return cakeClassMapper.selectByExample(cakeClassExample);
    }

    @Override
    public List<CakeClass> getCakeClassById(Integer id) {
        CakeClassExample cakeClassExample = new CakeClassExample();
        cakeClassExample.or().andCakeclassIdEqualTo(id);
        return cakeClassMapper.selectByExample(cakeClassExample);
    }

    @Override
    public int addCakeClass(CakeClass cakeClass) {
        return cakeClassMapper.insertSelective(cakeClass);
    }

    @Override
    public int editCakeClass(CakeClass cakeClass) {
        CakeClassExample cakeClassExample = new CakeClassExample();
        cakeClassExample.or().andCakeclassIdEqualTo(cakeClass.getCakeclassId());
        return cakeClassMapper.updateByExampleSelective(cakeClass, cakeClassExample);
    }

    @Override
    public int removeCakeClass(Integer id) {
        return cakeClassMapper.deleteByPrimaryKey(id);
    }
}
