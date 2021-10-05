package com.zime.bsk.service.impl;

import com.zime.bsk.dao.AddressMapper;
import com.zime.bsk.entity.Address;
import com.zime.bsk.entity.AddressExample;
import com.zime.bsk.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/11/21
 * @TIME: 9:02
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;


    @Override
    public List<Address> getAllAddressByUserId(Integer userId) {
        AddressExample addressExample = new AddressExample();
        addressExample.or().andAddressUseridEqualTo(userId);
        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public List<Address> getAddressById(Integer id) {
        AddressExample addressExample = new AddressExample();
        addressExample.or().andAddressIdEqualTo(id);
        return addressMapper.selectByExample(addressExample);
    }

    @Override
    public int addAddress(Address address) {
        return addressMapper.insertSelective(address);
    }

    @Override
    public int editAddress(Address address) {
        AddressExample addressExample = new AddressExample();
        addressExample.or().andAddressIdEqualTo(address.getAddressId());
        return addressMapper.updateByExampleSelective(address, addressExample);
    }

    @Override
    public int removeAddress(Integer addressId) {
        return addressMapper.deleteByPrimaryKey(addressId);
    }
}
