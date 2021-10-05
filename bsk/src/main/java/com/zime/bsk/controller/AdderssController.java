package com.zime.bsk.controller;

import com.zime.bsk.entity.Address;
import com.zime.bsk.service.AddressService;
import com.zime.bsk.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/3
 * @TIME: 9:26
 */
@Controller
@CrossOrigin
public class AdderssController {

    @Autowired
    private AddressService addressService;

    /**
     * 通过用户id获取用户所有地址
     * @param addressUserid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/address/getAllAddressByUserId")
    public Object getAllAddressByUserId(Integer addressUserid){
        if(addressUserid == null){
            return JsonUtil.fail("addressUserid为空");
        } else {
            List<Address> addresses = addressService.getAllAddressByUserId(addressUserid);
            splitAddress(addresses);
            return JsonUtil.success("获取用户所有地址").addData(addresses).addCount(addresses.size());
        }
    }

    /**
     * 通过id获取地址
     * @param addressId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/address/getAddressById")
    public Object getAddressById(Integer addressId){
        if(addressId == null){
            return JsonUtil.fail("addressId为空");
        } else {
            List<Address> addresses = addressService.getAddressById(addressId);
            splitAddress(addresses);
            return JsonUtil.success("获取对应id地址").addData(addresses).addCount(addresses.size());
        }
    }

    /**
     * 添加用户地址
     * @param address
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/address/addAddress")
    public Object addAddress(Address address){
        if(address == null){
            return JsonUtil.fail("添加用户地址信息为空");
        } else {
            int flag = 0;
            try{
                flag = addressService.addAddress(address);
                if(flag == 1){
                    return JsonUtil.success("添加地址成功");
                } else {
                    return JsonUtil.fail("添加地址失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("添加地址失败");
            }
        }
    }

    /**
     * 修改用户地址
     * @param address
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/address/editAddress")
    public Object editAddress(Address address){
        if(address == null){
            return JsonUtil.fail("修改用户地址信息为空");
        } else {
            int flag = 0;
            try{
                flag = addressService.editAddress(address);
                if(flag == 1){
                    return JsonUtil.success("修改地址成功");
                } else {
                    return JsonUtil.fail("修改地址失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("修改地址失败");
            }
        }
    }

    /**
     * 通过地址id删除用户地址
     * @param addressId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/address/removeAddress")
    public Object removeAddress(Integer addressId){
        if(addressId == null){
            return JsonUtil.fail("addressId为空");
        } else {
            int flag = 0;
            try{
                flag = addressService.removeAddress(addressId);
                if(flag == 1){
                    return JsonUtil.success("删除地址成功");
                } else {
                    return JsonUtil.fail("删除地址失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除地址失败");
            }
        }
    }

    private void splitAddress(List<Address> addresses){
        for(int i=0; i<addresses.size(); i++){
            addresses.get(i).setAddressNameFirst(addresses.get(i).getAddressName().substring(0, 1));
            String[] addressd = addresses.get(i).getAddressInfo().split("\\?");
            addresses.get(i).setAddressInfo(addressd[0]);
            addresses.get(i).setAddressDetail("");
            if(addressd.length>1){
                addresses.get(i).setAddressDetail(addressd[1]);
            }
        }
    }

}
