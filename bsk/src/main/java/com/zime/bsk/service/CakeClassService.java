package com.zime.bsk.service;

import com.zime.bsk.entity.CakeClass;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:00
 */
public interface CakeClassService {

    //获取所有一级蛋糕类别信息
    List<CakeClass> getAllCakeClass();

    //通过id获取对应一级蛋糕类别信息
    List<CakeClass> getCakeClassById(Integer id);

    //添加一级蛋糕类别
    int addCakeClass(CakeClass cakeClass);

    //通过蛋糕类别id修改一级蛋糕类别
    int editCakeClass(CakeClass cakeClass);

    //通过蛋糕类别id删除一级蛋糕类别
    int removeCakeClass(Integer id);
}
