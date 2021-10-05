package com.zime.bsk.service;

import com.zime.bsk.entity.Address;

import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 8:59
 */
public interface AddressService {

    //通过用户id获取所有用户填写地址
    List<Address> getAllAddressByUserId(Integer userId);

    //通过id获取对应填写地址
    List<Address> getAddressById(Integer id);

    //添加用户地址
    int addAddress(Address address);

    //通过id修改用户地址
    int editAddress(Address address);

    //通过id删除用户地址
    int removeAddress(Integer addressId);
}
