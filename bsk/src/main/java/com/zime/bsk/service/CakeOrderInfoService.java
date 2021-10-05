package com.zime.bsk.service;

import com.zime.bsk.entity.CakeOrderInfo;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:00
 */
public interface CakeOrderInfoService {

    //通过用户id获取所有该用户的订单信息
    List<CakeOrderInfo> getAllCakeOrderInfoByUserId(Integer userId);

    //通过用户id获取所有该用户的某订单状态订单信息
    List<CakeOrderInfo> getAllCakeOrderInfoByUserIdByState(Integer userId, Integer orderState);

    //通过订单号获取订单信息
    List<CakeOrderInfo> getCakeOrderInfoByNo(String orderNo);

    //通过订单id获取订单信息
    List<CakeOrderInfo> getCakeOrderInfoById(Integer id);

    //添加订单
    int addCakeOrderInfo(CakeOrderInfo cakeOrderInfo);

    //修改订单
    int editCakeOrderInfo(CakeOrderInfo cakeOrderInfo);

    //删除订单
    int removeCakeOrderInfo(Integer id);
}
