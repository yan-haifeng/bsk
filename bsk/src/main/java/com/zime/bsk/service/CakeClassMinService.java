package com.zime.bsk.service;

import com.zime.bsk.entity.CakeClassMin;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/3
 * @TIME: 9:04
 */
public interface CakeClassMinService {

    //获取所有的蛋糕二级类别信息
    List<CakeClassMin> getAllCakeClassMin();

    //通过蛋糕一级类别id获取到所有对应二级的类别信息
    List<CakeClassMin> getAllCakeClassMinByClassId(Integer cakeclassminClassid);

    //通过蛋糕二级类别id获取到对应二级的类别信息
    List<CakeClassMin> getCakeClassMinById(Integer id);

    //添加蛋糕二级类别信息
    int addCakeClassMin(CakeClassMin cakeClassMin);

    //通过id修改蛋糕二级类别信息
    int editCakeClassMin(CakeClassMin cakeClassMin);

    //通过id删除蛋糕二级类别信息
    int removeCakeClassMin(Integer id);

    //通过蛋糕一级类别id删除所有蛋糕二级类别信息
    int removeCakeClassMinByClassId(Integer cakeclassminClassid);
}
