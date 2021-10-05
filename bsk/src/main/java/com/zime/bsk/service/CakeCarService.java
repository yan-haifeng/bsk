package com.zime.bsk.service;

import com.zime.bsk.entity.CakeCar;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 8:59
 */
public interface CakeCarService {

    //通过用户id获取用户所有未购买的购物车信息
    List<CakeCar> getAllCakeCarByUserIdNotBuy(Integer userId);

    //通过用户id获取用户所有购买的购物车信息
    List<CakeCar> getAllCakeCarByUserIdBuy(Integer userId);

    //通过id获取购物车信息
    List<CakeCar> getCakeCarById(Integer id);

    //添加购物车
    int addCakeCar(CakeCar cakeCar);

    //修改购物车
    int editCakeCar(CakeCar cakeCar);

    //通过id删除购物车
    int removeCakeCar(Integer id);

    //通过用户id删除所有用户购物车
    int removeCakeCarByUserId(Integer carUserid);

}
