package com.zime.bsk.service;

import com.zime.bsk.entity.CakeSpecs;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/5
 * @TIME: 9:42
 */
public interface CakeSpecsService {

    //通过蛋糕id获取某个蛋糕的所有规格
    List<CakeSpecs> getAllCakeSpecsByCakeId(Integer cakeId);

    //通过蛋糕规格id获取某个规格
    List<CakeSpecs> getCakeSpecs(Integer id);
}
