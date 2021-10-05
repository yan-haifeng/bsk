package com.zime.bsk.controller;

import com.zime.bsk.entity.CakeCar;
import com.zime.bsk.entity.CakeOrderInfo;
import com.zime.bsk.service.CakeCarService;
import com.zime.bsk.service.CakeOrderInfoService;
import com.zime.bsk.util.JsonUtil;
import com.zime.bsk.util.OrderCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static com.zime.bsk.util.OrderCodeFactory.getRandomOrderCode;

/**
 * @Author: 94704
 * @DATE: 2019/12/3
 * @TIME: 9:28
 */
@Controller
@CrossOrigin
public class CakeOrderInfoController {

    @Autowired
    private CakeOrderInfoService cakeOrderInfoService;
    @Autowired
    private CakeCarService cakeCarService;

    /**
     * 通过用户id获取所有该用户的订单信息
     * @param orderUserid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeOrder/getAllCakeOrderInfoByUserId")
    public Object getAllCakeOrderInfoByUserId(Integer orderUserid){
        if(orderUserid == null){
            return JsonUtil.fail("orderUserid为空");
        } else {
            List<CakeOrderInfo> cakeOrderInfos = cakeOrderInfoService.getAllCakeOrderInfoByUserId(orderUserid);
            return JsonUtil.success("获取所有该用户的订单信息").addData(cakeOrderInfos).addCount(cakeOrderInfos.size());
        }
    }

    /**
     * 通过用户id获取所有该用户的某订单状态订单信息
     * @param orderUserid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeOrder/getAllCakeOrderInfoByUserIdByState")
    public Object getAllCakeOrderInfoByUserIdByState(Integer orderUserid, Integer orderState){
        if(orderUserid == null || orderState == null){
            return JsonUtil.fail("orderUserid或orderState为空");
        } else {
            List<CakeOrderInfo> cakeOrderInfos = cakeOrderInfoService.getAllCakeOrderInfoByUserIdByState(orderUserid, orderState);
            return JsonUtil.success("获取所有该用户的某订单状态订单信息").addData(cakeOrderInfos).addCount(cakeOrderInfos.size());
        }
    }

    /**
     * 添加订单
     * @param cakeOrderInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeOrder/addCakeOrderInfo")
    public Object addCakeOrderInfo(CakeOrderInfo cakeOrderInfo){
        if(cakeOrderInfo == null){
            return JsonUtil.fail("添加订单信息为空");
        } else {
            int flag = 0;
            try{
                String orderNo = OrderCodeFactory.getRandomOrderCode(10);
                cakeOrderInfo.setOrderNo(orderNo);
                cakeOrderInfo.setOrderTime(new Date());
                flag = cakeOrderInfoService.addCakeOrderInfo(cakeOrderInfo);
                if(flag == 1){
                    String[] carIds = cakeOrderInfo.getOrderCarid().split("\\?");
                    for(int i=0; i <carIds.length; i++){
                        CakeCar cakeCar = new CakeCar();
                        cakeCar.setCarId(Integer.parseInt(carIds[i]));
                        cakeCar.setCarState(1);
                        cakeCarService.editCakeCar(cakeCar);
                    }
                    cakeOrderInfo = cakeOrderInfoService.getCakeOrderInfoByNo(cakeOrderInfo.getOrderNo()).get(0);
                    List<CakeOrderInfo> temp = new ArrayList<>();
                    temp.add(cakeOrderInfo);
                    return JsonUtil.success("添加订单信息成功").addData(temp);
                } else {
                    return JsonUtil.fail("添加订单信息失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("添加订单信息失败");
            }
        }
    }

    /**
     * 修改订单
     * @param cakeOrderInfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeOrder/editCakeOrderInfo")
    public Object editCakeOrderInfo(CakeOrderInfo cakeOrderInfo){
        if(cakeOrderInfo == null){
            return JsonUtil.fail("修改订单信息为空");
        } else {
            int flag = 0;
            try{
                flag = cakeOrderInfoService.editCakeOrderInfo(cakeOrderInfo);
                if(flag == 1){
                    return JsonUtil.success("修改订单信息成功");
                } else {
                    return JsonUtil.fail("修改订单信息失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("修改订单信息失败");
            }
        }
    }

    /**
     * 通过id删除订单
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeOrder/removeCakeOrderInfo")
    public Object removeCakeOrderInfo(Integer orderId){
        if(orderId == null){
            return JsonUtil.fail("orderId为空");
        } else {
            int flag = 0;
            try{
                flag = cakeOrderInfoService.removeCakeOrderInfo(orderId);
                if(flag == 1){
                    return JsonUtil.success("删除订单信息成功");
                } else {
                    return JsonUtil.fail("删除订单信息失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除订单信息失败");
            }
        }
    }


}
