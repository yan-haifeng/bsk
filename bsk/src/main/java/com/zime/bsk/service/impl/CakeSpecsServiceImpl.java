package com.zime.bsk.service.impl;

import com.zime.bsk.dao.CakeSpecsMapper;
import com.zime.bsk.entity.CakeSpecs;
import com.zime.bsk.entity.CakeSpecsExample;
import com.zime.bsk.service.CakeCarService;
import com.zime.bsk.service.CakeSpecsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/5
 * @TIME: 9:45
 */
@Service
public class CakeSpecsServiceImpl implements CakeSpecsService {

    @Resource
    private CakeSpecsMapper cakeSpecsMapper;

    @Override
    public List<CakeSpecs> getAllCakeSpecsByCakeId(Integer cakeId) {
        CakeSpecsExample cakeSpecsExample = new CakeSpecsExample();
        cakeSpecsExample.or().andCakespecsCakeidEqualTo(cakeId);
        return cakeSpecsMapper.selectByExample(cakeSpecsExample);
    }

    @Override
    public List<CakeSpecs> getCakeSpecs(Integer id) {
        CakeSpecsExample cakeSpecsExample = new CakeSpecsExample();
        cakeSpecsExample.or().andCakespecsIdEqualTo(id);
        return cakeSpecsMapper.selectByExample(cakeSpecsExample);
    }
}
