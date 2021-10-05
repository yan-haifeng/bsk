package com.zime.bsk.service;

import com.zime.bsk.entity.CakeCar;
import com.zime.bsk.entity.CakeInfo;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:00
 */
public interface CakeInfoService {

    //获取所有蛋糕信息
    List<CakeInfo> getAllCakeInfo();

    //通过一级类别id获取所有蛋糕信息
    List<CakeInfo> getAllCakeInfoByClassId(Integer cakeClassid);

    //通过二级类别id获取所有蛋糕信息
    List<CakeInfo> getAllCakeInfoByClassMinId(Integer cakeClassminid);

    //通过蛋糕id获取某个蛋糕
    List<CakeInfo> getCakeInfoById(Integer id);

    //获取今日蛋糕
    List<CakeInfo> getCakeInfoByDay();

    //添加蛋糕信息
    int addCakeInfo(CakeInfo cakeInfo);

    //修改蛋糕信息
    int editCakeInfo(CakeInfo cakeInfo);

    //通过id删除蛋糕信息
    int removeCakeInfo(Integer id);
}
