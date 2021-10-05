package com.zime.bsk.controller;

import com.zime.bsk.entity.CakeCar;
import com.zime.bsk.service.CakeCarService;
import com.zime.bsk.service.CakeInfoService;
import com.zime.bsk.service.CakeSpecsService;
import com.zime.bsk.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 94704
 * @DATE: 2019/12/3
 * @TIME: 9:27
 */
@Controller
@CrossOrigin
public class CakeCarController {

    @Autowired
    private CakeCarService cakeCarService;
    @Autowired
    private CakeInfoService cakeInfoService;
    @Autowired
    private CakeSpecsService cakeSpecsService;


    /**
     * 通过用户id获取用户所有未购买的购物车信息
     * @param carUserid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeCar/getAllCakeCarByUserIdNotBuy")
    public Object getAllCakeCarByUserIdNotBuy(Integer carUserid){
        if(carUserid == null){
            return JsonUtil.fail("carUserid为空");
        } else {
            List<CakeCar> cakeCarList = cakeCarService.getAllCakeCarByUserIdNotBuy(carUserid);
            addCakeInfoAndSpecs(cakeCarList);
            return JsonUtil.success("获取用户所有未购买的购物车信息").addData(cakeCarList).addCount(cakeCarList.size());
        }
    }

    /**
     * 通过id获取购物车信息
     * @param carId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeCar/getCakeCarById")
    public Object getCakeCarById(Integer carId){
        if(carId == null){
            return JsonUtil.fail("carId为空");
        } else {
            List<CakeCar> cakeCarList = cakeCarService.getCakeCarById(carId);
            addCakeInfoAndSpecs(cakeCarList);
            return JsonUtil.success("获取对应购物车信息").addData(cakeCarList).addCount(cakeCarList.size());
        }
    }

    /**
     * 添加购物车-有重复添加则修改数量
     * @param cakeCar
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeCar/addCakeCar")
    public Object addCakeCar(CakeCar cakeCar){
        if(cakeCar == null){
            return JsonUtil.fail("添加购物车信息为空");
        } else {
            int flag = 0;
            try{
                List<CakeCar> cakeCars = cakeCarService.getAllCakeCarByUserIdNotBuy(cakeCar.getCarUserid());
                int isExist = -1;
                for(int i=0; i<cakeCars.size(); i++){
                    if(cakeCars.get(i).getCarCakeid()==cakeCar.getCarCakeid() && cakeCars.get(i).getCarSpecsid()==cakeCar.getCarSpecsid()){
                        isExist = i;
                        break;
                    }
                }
                if(isExist>-1){
                    cakeCars.get(isExist).setCarNum(cakeCars.get(isExist).getCarNum()+1);
                    flag = cakeCarService.editCakeCar(cakeCars.get(isExist));
                } else {
                    flag = cakeCarService.addCakeCar(cakeCar);
                }
                if(flag==1 && isExist>-1){
                    return JsonUtil.success("更新购物车数量成功");
                } else if(flag==1 && isExist<0){
                    return JsonUtil.success("添加购物车成功");
                } else {
                    return JsonUtil.fail("添加购物车失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("添加购物车失败");
            }
        }
    }

    /**
     * 修改购物车
     * @param cakeCar
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeCar/editCakeCar")
    public Object editCakeCar(CakeCar cakeCar){
        if(cakeCar == null){
            return JsonUtil.fail("修改购物车信息为空");
        } else {
            int flag = 0;
            try{
                flag = cakeCarService.editCakeCar(cakeCar);
                if(flag == 1){
                    return JsonUtil.success("修改购物车成功");
                } else {
                    return JsonUtil.fail("修改购物车失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("修改购物车失败");
            }
        }
    }

    /**
     * 通过id删除购物车
     * @param carId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeCar/removeCakeCar")
    public Object removeCakeCar(Integer carId){
        if(carId == null){
            return JsonUtil.fail("carId为空");
        } else {
            int flag = 0;
            try{
                flag = cakeCarService.removeCakeCar(carId);
                if(flag == 1){
                    return JsonUtil.success("删除购物车成功");
                } else {
                    return JsonUtil.fail("删除购物车失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除购物车失败");
            }
        }
    }

    /**
     * 通过用户id删除所有用户购物车
     * @param carUserid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/cakeCar/removeCakeCarByUserId")
    public Object removeCakeCarByUserId(Integer carUserid){
        if(carUserid == null){
            return JsonUtil.fail("carUserid为空");
        } else {
            int flag = 0;
            try{
                flag = cakeCarService.removeCakeCarByUserId(carUserid);
                if(flag == 1){
                    return JsonUtil.success("删除所有购物车成功");
                } else {
                    return JsonUtil.fail("删除所有购物车失败");
                }
            } catch (Exception e){
                e.printStackTrace();
                return JsonUtil.fail("删除所有购物车失败");
            }
        }
    }


    public void addCakeInfoAndSpecs(List<CakeCar> cars){
        for(int i=0; i<cars.size(); i++){
            cars.get(i).setCakeInfoList(cakeInfoService.getCakeInfoById(cars.get(i).getCarCakeid()));
            String[] imgs = cars.get(i).getCakeInfoList().get(0).getCakeImg().split("\\?");
            cars.get(i).getCakeInfoList().get(0).setCakeImgList(Arrays.asList(imgs));
            cars.get(i).getCakeInfoList().get(0).setCakeImg(cars.get(i).getCakeInfoList().get(0).getCakeImgList().get(0));
            cars.get(i).setCakeSpecsList(cakeSpecsService.getCakeSpecs(cars.get(i).getCarSpecsid()));
        }
    }
}
